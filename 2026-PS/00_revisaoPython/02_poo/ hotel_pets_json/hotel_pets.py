import pickle

# ================================================================
# ARQUIVO: hotel_pet.py
# DISCIPLINA: Programação de Sistemas (2026-2)
# AULA: Aula 24 - Persistência de Objetos
# AUTOR: Ellis
# CONCEITOS: Classe, Objetos, Métodos, Persistência binária
# ATIVIDADE: Sistema de Hospedagem de Pets
# ================================================================
import json
import os

ARQUIVO_JSON = "2026-PS/02_poo/hotel_pets_json/pets.json"

os.makedirs(os.path.dirname(ARQUIVO_JSON), exist_ok=True)

class Pet:
    def __init__(self, nome, especie, idade, peso, altura, data_nascimento, nome_dono, vacinado, hospedado=False):
        self.nome = nome
        self.especie = especie
        self.idade = idade
        self.peso = peso
        self.altura = altura
        self.data_nascimento = data_nascimento
        self.nome_dono = nome_dono
        self.vacinado = vacinado
        self.hospedado = hospedado

    def exibir_dados(self):
        print("\n--- Dados do Pet ---")
        print(f"Nome: {self.nome}")
        print(f"Espécie: {self.especie}")
        print(f"Idade: {self.idade}")
        print(f"Peso: {self.peso} kg")
        print(f"Altura: {self.altura} cm")
        print(f"Data de nascimento: {self.data_nascimento}")
        print(f"Dono: {self.nome_dono}")
        print(f"Vacinado: {'Sim' if self.vacinado else 'Não'}")
        print(f"Hospedado: {'Sim' if self.hospedado else 'Não'}")

    def registrar_entrada(self):
        if self.hospedado:
            print(f"{self.nome} já está hospedado.")
        else:
            self.hospedado = True
            print(f"{self.nome} entrou no hotel.")

    def registrar_saida(self):
        if not self.hospedado:
            print(f"{self.nome} não está hospedado.")
        else:
            self.hospedado = False
            print(f"{self.nome} saiu do hotel.")

    def para_dicionario(self):
        return {
            "nome": self.nome,
            "especie": self.especie,
            "idade": self.idade,
            "peso": self.peso,
            "altura": self.altura,
            "data_nascimento": self.data_nascimento,
            "nome_dono": self.nome_dono,
            "vacinado": self.vacinado,
            "hospedado": self.hospedado
        }

    @staticmethod
    def criar_de_dicionario(dados):
        return Pet(
            dados["nome"],
            dados["especie"],
            dados["idade"],
            dados["peso"],
            dados["altura"],
            dados["data_nascimento"],
            dados["nome_dono"],
            dados["vacinado"],
            dados["hospedado"]
        )


def salvar_pets(lista_pets):
    lista_dicionarios = [pet.para_dicionario() for pet in lista_pets]

    with open(ARQUIVO_JSON, "w", encoding="utf-8") as arquivo:
        json.dump(lista_dicionarios, arquivo, ensure_ascii=False, indent=4)

    print("Dados salvos com sucesso em pets.json!")


def carregar_pets():
    if not os.path.exists(ARQUIVO_JSON):
        return []

    with open(ARQUIVO_JSON, "r", encoding="utf-8") as arquivo:
        lista_dicionarios = json.load(arquivo)

    return [Pet.criar_de_dicionario(dados) for dados in lista_dicionarios]


def cadastrar_pet(lista_pets):
    print("\n--- Cadastro de Pet ---")

    nome = input("Nome do pet: ")
    especie = input("Espécie: ")
    idade = int(input("Idade: "))
    peso = float(input("Peso (kg): "))
    altura = float(input("Altura (cm): "))
    data_nascimento = input("Data de nascimento (dd/mm/aaaa): ")
    nome_dono = input("Nome do dono: ")

    resposta = input("O pet está vacinado? (s/n): ").lower()
    vacinado = resposta == "s"

    pet = Pet(nome, especie, idade, peso, altura, data_nascimento, nome_dono, vacinado)
    lista_pets.append(pet)

    print("Pet cadastrado com sucesso!")


def listar_pets(lista_pets):
    print("\n--- Lista de Pets ---")

    if not lista_pets:
        print("Nenhum pet cadastrado.")
        return

    for i, pet in enumerate(lista_pets, 1):
        print(f"\nPet {i}:")
        pet.exibir_dados()


def menu():
    pets = carregar_pets()

    # Cadastro automático de 3 pets para teste
    if not pets:  
        pets.append(Pet("Rex", "Cachorro", 5, 20.5, 55, "10/03/2021", "João", True))
        pets.append(Pet("Mia", "Gato", 3, 4.2, 25, "15/07/2023", "Ana", True))
        pets.append(Pet("Thor", "Papagaio", 2, 1.1, 18, "01/01/2024", "Carlos", False))
        salvar_pets(pets)

    while True:
        print("\n========= HOTEL PARA PETS =========")
        print("1 - Cadastrar pet")
        print("2 - Listar pets")
        print("3 - Registrar entrada")
        print("4 - Registrar saída")
        print("5 - Salvar dados")
        print("0 - Sair")
        opcao = input("Escolha uma opção: ")

        if opcao == "1":
            cadastrar_pet(pets)

        elif opcao == "2":
            listar_pets(pets)

        elif opcao == "3":
            listar_pets(pets)
            numero = int(input("Número do pet: "))
            pets[numero - 1].registrar_entrada()

        elif opcao == "4":
            listar_pets(pets)
            numero = int(input("Número do pet: "))
            pets[numero - 1].registrar_saida()

        elif opcao == "5":
            salvar_pets(pets)

        elif opcao == "0":
            salvar_pets(pets)
            print("Sistema encerrado.")
            break

        else:
            print("Opção inválida.")


if __name__ == "__main__":
    menu()
