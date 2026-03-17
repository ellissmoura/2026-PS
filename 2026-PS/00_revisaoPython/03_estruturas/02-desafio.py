biblioteca = []

def cadastrar():
    titulo = input("Título: ")
    autor = input("Autor: ")
    biblioteca.append({"titulo": titulo, "autor": autor, "disponivel": True})
    print("Livro cadastrado.\n")


def buscar_autor():
    busca = input("Autor (ou parte): ").lower()
    encontrados = [l for l in biblioteca if busca in l["autor"].lower()]

    if encontrados:
        for l in encontrados:
            status = "Disponível" if l["disponivel"] else "Emprestado"
            print(f"{l['titulo']} - {status}")
    else:
        print("Nenhum livro encontrado.")
    print()


def emprestar():
    titulo = input("Título para empréstimo: ").lower()
    for l in biblioteca:
        if l["titulo"].lower() == titulo:
            if l["disponivel"]:
                l["disponivel"] = False
                print("Empréstimo realizado.\n")
            else:
                print("Já está emprestado.\n")
            return
    print("Livro não encontrado.\n")


def devolver():
    titulo = input("Título para devolução: ").lower()
    for l in biblioteca:
        if l["titulo"].lower() == titulo:
            if not l["disponivel"]:
                l["disponivel"] = True
                print("Devolvido.\n")
            else:
                print("Já está disponível.\n")
            return
    print("Livro não encontrado.\n")


def relatorio():
    disponiveis = sum(1 for l in biblioteca if l["disponivel"])
    emprestados = sum(1 for l in biblioteca if not l["disponivel"])
    print(f"Disponíveis: {disponiveis}")
    print(f"Emprestados: {emprestados}\n")


while True:
    print("1-Cadastrar 2-Buscar 3-Emprestar 4-Devolver 5-Relatório 0-Sair")
    op = input("Opção: ")

    if op == "1":
        cadastrar()
    elif op == "2":
        buscar_autor()
    elif op == "3":
        emprestar()
    elif op == "4":
        devolver()
    elif op == "5":
        relatorio()
    elif op == "0":
        break
    else:
        print("Opção inválida.\n")
