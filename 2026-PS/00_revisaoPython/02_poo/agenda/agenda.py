import pickle

"""
agenda.py — Aula 23 (Programação de Sistemas, 2026)
Agenda de Contatos: agora com persistência binária.
"""

class Contato:
    def __init__(self, nome, telefone, email):
        self.nome = nome
        self.telefone = telefone
        self.email = email

    def exibir(self):
        print(f" Nome    : {self.nome}")
        print(f" Telefone: {self.telefone}")
        print(f" Email   : {self.email}")

# --- FUNÇÕES DE LÓGICA ---

def cadastrar(contatos):
    print("\n--- Novo contato ---")
    nome = input("Nome    : ")
    telefone = input("Telefone: ")
    email = input("Email   : ")
    contatos.append(Contato(nome, telefone, email))
    print("✓ Contato cadastrado.")

def listar(contatos):
    if not contatos:
        print("\n(agenda vazia)")
        return

    print(f"\n--- Agenda ({len(contatos)} contatos) ---")
    for i, c in enumerate(contatos, start=1):
        print(f"\n[{i}]")
        c.exibir()

def remover(contatos):
    listar(contatos)
    if not contatos:
        return

    try:
        indice = int(input("\nNº do contato a remover: ")) - 1
        if 0 <= indice < len(contatos):
            removido = contatos.pop(indice)
            print(f"✓ Contato '{removido.nome}' removido.")
        else:
            print("Erro: Índice inválido.")
    except ValueError:
        print("Erro: Digite apenas números.")

def salvar_em_txt(contatos, caminho):
    with open(caminho, "w", encoding="utf-8") as arquivo:
        for c in contatos:
            linha = f"{c.nome};{c.telefone};{c.email}"
            arquivo.write(linha + "\n")
    print(f"✓ {len(contatos)} contato(s) salvo(s) em {caminho}")

def salvar_em_binario(contatos, caminho):
    with open(caminho, "wb") as arquivo:
        pickle.dump(contatos, arquivo)
    print(f"✓ {len(contatos)} contato(s) salvo(s) em {caminho} (binário)")

def carregar_de_binario(caminho):
    try:
        with open(caminho, "rb") as arquivo:
            return pickle.load(arquivo)
    except (FileNotFoundError, EOFError):
        print(f"Aviso: Arquivo {caminho} não encontrado. Começando agenda vazia.")
        return []

def menu():
    contatos = carregar_de_binario("agenda.bin")

    while True:
        print("\n======= AGENDA =======")
        print("1. Cadastrar contato")
        print("2. Listar contatos")
        print("3. Remover contato")
        print("4. Salvar em .txt (Exportar)")
        print("5. Salvar em binário (.bin)") 
        print("0 - Sair")

        opcao = input("Opção: ")

        if opcao == "1":
            cadastrar(contatos)
        elif opcao == "2":
            listar(contatos)
        elif opcao == "3":
            remover(contatos)
        elif opcao == "4":
            salvar_em_txt(contatos, "agenda.txt")
        elif opcao == "5":
            salvar_em_binario(contatos, "agenda.bin")
        elif opcao == "0":
            print("Até logo!")
            break
        else:
            print("Opção inválida.")

if __name__ == "__main__":
    menu()