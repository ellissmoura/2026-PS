# ================================================================
# ARQUIVO: pet.py
# DISCIPLINA: Programação de Sistemas (2026-2)
# AULA: Aula 20 - Por que POO?
# AUTOR: Ellis
# CONCEITOS: Classe, Objetos, Métodos, Atributos, Encapsulamento
# ATIVIDADE: Classe Pet
# ================================================================

class Pet:
    def __init__(self, nome, especie, hospedado=False, nome_dono=None, telefone_dono=None, observacoes=None, vacinado=False, peso=None):
        self.nome = nome
        self.especie = especie
        self.hospedado = hospedado
        self.nome_dono = nome_dono
        self.telefone_dono = telefone_dono
        self.observacoes = observacoes
        self.vacinado = vacinado
        self.peso = peso

    def exibir_dados(self):
        print("\n--- Dados do Pet ---")
        print(f"Nome: {self.nome}")
        print(f"Espécie: {self.especie}")
        print(f"Hospedado: {'Sim' if self.hospedado else 'Não'}")
        print(f"Nome do Dono: {self.nome_dono}")
        print(f"Telefone do Dono: {self.telefone_dono}")
        print(f"Observações: {self.observacoes}")
        print(f"Vacinado: {'Sim' if self.vacinado else 'Não'}")
        print(f"Peso: {self.peso if self.peso else 'Não informado'} kg")

    def registrar_entrada(self):
        if self.hospedado:
            print(f"{self.nome} já está hospedado no hotel.")
        else:
            self.hospedado = True
            print(f"{self.nome} entrou no hotel.")

    def registrar_saida(self):
        if not self.hospedado:
            print(f"{self.nome} não está hospedado no hotel.")
        else:
            self.hospedado = False
            print(f"{self.nome} saiu do hotel.")

    def calcular_diaria(self):
        if not self.hospedado:
            print(f"{self.nome} não está hospedado no hotel.")
            return 0
        else:
            # diária com base apenas na espécie
            if self.especie.lower() == "cachorro":
                diaria = 50
            elif self.especie.lower() == "gato":
                diaria = 40
            else:
                diaria = 30
            return diaria
    
    def atualizar_observacoes(self, nova_observacao):
        if self.observacoes:
            self.observacoes += f" | {nova_observacao}"
        else:
            self.observacoes = nova_observacao

    def atualizar_dados_dono(self, nome_dono=None, telefone_dono=None):
        if nome_dono:
            self.nome_dono = nome_dono
        if telefone_dono:
            self.telefone_dono = telefone_dono

    def verificar_vacinacao(self):
        if self.vacinado:
            print("Vacinação em dia.")
        else:
            print("Atenção: vacinação pendente.")

    def atualizar_peso(self, novo_peso):
        self.peso = novo_peso
        print(f"Peso atualizado: {self.peso} kg")

    def emitir_relatorio(self):
        print(f"\nRelatório do Pet: {self.nome}")
        print(f"Espécie: {self.especie}")
        print(f"Hospedado: {'Sim' if self.hospedado else 'Não'}")
        print(f"Nome do Dono: {self.nome_dono}")
        print(f"Telefone do Dono: {self.telefone_dono}")
        print(f"Observações: {self.observacoes}")
        print(f"Vacinado: {'Sim' if self.vacinado else 'Não'}")
        print(f"Peso: {self.peso if self.peso else 'Não informado'} kg")
        print(f"Diária Atual: R${self.calcular_diaria():.2f}")


pet1 = Pet("Pitufo", "Passarinho", hospedado=True, nome_dono="Ellis", telefone_dono="123456789", observacoes="Tagarela, assobiador, gosta de sementes de girassol", vacinado=True, peso=0.2)
pet2 = Pet("GuiNegão", "Gato", hospedado=False, nome_dono="Ellis", telefone_dono="123456789", observacoes="Dorminhoco, comilhão, bravo", vacinado=False, peso=4.5)
pet3 = Pet("Nega", "Cadela", hospedado=True, nome_dono="Ellis", telefone_dono="123456789", observacoes="Quieta, medrosa", vacinado=True, peso=20)

pet1.emitir_relatorio()
pet1.verificar_vacinacao()
pet1.atualizar_peso(0.25)

pet2.emitir_relatorio()
pet2.verificar_vacinacao()
pet2.atualizar_peso(5.0)

pet3.emitir_relatorio()
pet3.verificar_vacinacao()
pet3.atualizar_peso(20)