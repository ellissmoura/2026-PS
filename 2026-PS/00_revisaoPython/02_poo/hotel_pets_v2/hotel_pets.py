import pickle

# ================================================================
# ARQUIVO: hotel_pet.py
# DISCIPLINA: Programação de Sistemas (2026-2)
# AULA: Aula 24 - Persistência de Objetos
# AUTOR: Ellis
# CONCEITOS: Classe, Objetos, Métodos, Persistência binária
# ATIVIDADE: Sistema de Hospedagem de Pets
# ================================================================

class Pet:
    def __init__(self, nome, especie, nome_dono, telefone_dono, hospedado=False, observacoes=None):
        self.nome = nome
        self.especie = especie
        self.nome_dono = nome_dono
        self.telefone_dono = telefone_dono
        self.hospedado = hospedado
        self.observacoes = observacoes

    def exibir(self):
        print(f" Nome do Pet : {self.nome}")
        print(f" Espécie     : {self.especie}")
        print(f" Dono        : {self.nome_dono}")
        print(f" Telefone    : {self.telefone_dono}")
        print(f" Hospedado   : {'Sim' if self.hospedado else 'Não'}")
        print(f" Observações : {self.observacoes if self.observacoes else 'Nenhuma'}")

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


# --- FUNÇÕES DE LÓGICA ---

def cadastrar(pets):
    print("\n--- Novo Pet ---")
    nome = input("Nome do Pet : ")
    especie = input("Espécie     : ")
    nome_dono = input("Nome do Dono: ")
    telefone_dono = input("Telefone    : ")
    observacoes = input("Observações : ")
    pets.append(Pet(nome, especie, nome_dono, telefone_dono, hospedado=False, observacoes=observacoes))
    print("✓ Pet cadastrado.")

def listar(pets):
    if not pets:
        print("\n(nenhum pet cadastrado)")
        return
    print(f"\n--- Lista de Pets ({len(pets)}) ---")
    for i, p in enumerate(pets, start=1):
        print(f"\n[{i}]")
        p.exibir()

def remover(pets):
    listar(pets)
    if not pets:
        return
    try:
        indice = int(input("\nNº do pet a remover: ")) - 1
        if 0 <= indice < len(pets):
            removido = pets.pop(indice)
            print(f"✓ Pet '{removido.nome}' removido.")
        else:
            print("Erro: índice inválido.")
    except ValueError:
        print("Erro: digite apenas números.")

def salvar_em_txt(pets, caminho):
    with open(caminho, "w", encoding="utf-8") as arquivo:
        for p in pets:
            linha = f"{p.nome};{p.especie};{p.nome_dono};{p.telefone_dono};{p.hospedado};{p.observacoes}"
            arquivo.write(linha + "\n")
    print(f"✓ {len(pets)} pet(s) salvo(s) em {caminho}")

def salvar_em_binario(pets, caminho):
    with open(caminho, "wb") as arquivo:
        pickle.dump(pets, arquivo)
    print(f"✓ {len(pets)} pet(s) salvo(s) em {caminho} (binário)")

def carregar_de_binario(caminho):
    try:
        with open(caminho, "rb") as arquivo:
            return pickle.load(arquivo)
    except (FileNotFoundError, EOFError):
        print(f"Aviso: Arquivo {caminho} não encontrado. Começando lista vazia.")
        return []

def menu():
    pets = carregar_de_binario("pets.bin")

    while True:
        print("\n======= HOTEL PET =======")
        print("1. Cadastrar Pet")
        print("2. Listar Pets")
        print("3. Remover Pet")
        print("4. Registrar Entrada")
        print("5. Registrar Saída")
        print("6. Salvar em .txt (Exportar)")
        print("7. Salvar em binário (.bin)")
        print("0 - Sair")

        opcao = input("Opção: ")

        if opcao == "1":
            cadastrar(pets)
        elif opcao == "2":
            listar(pets)
        elif opcao == "3":
            remover(pets)
        elif opcao == "4":
            listar(pets)
            if pets:
                i = int(input("Nº do pet: ")) - 1
                if 0 <= i < len(pets):
                    pets[i].registrar_entrada()
        elif opcao == "5":
            listar(pets)
            if pets:
                i = int(input("Nº do pet: ")) - 1
                if 0 <= i < len(pets):
                    pets[i].registrar_saida()
        elif opcao == "6":
            salvar_em_txt(pets, "pets.txt")
        elif opcao == "7":
            salvar_em_binario(pets, "pets.bin")
        elif opcao == "0":
            print("Até logo!")
            break
        else:
            print("Opção inválida.")

if __name__ == "__main__":
    menu()
