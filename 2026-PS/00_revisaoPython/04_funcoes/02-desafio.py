# ---- FUNÇÃO PARA SOLICITAR E VALIDAR NOTAS ----

def solicitar_notas(nome_aluno):
    """Solicita duas notas entre 0 e 10 e garante que sejam válidas."""
    
    while True:
        nota1 = float(input(f"Digite a primeira nota de {nome_aluno}: "))
        if 0 <= nota1 <= 10:
            break
        print("Nota inválida! Digite um valor entre 0 e 10.")

    while True:
        nota2 = float(input(f"Digite a segunda nota de {nome_aluno}: "))
        if 0 <= nota2 <= 10:
            break
        print("Nota inválida! Digite um valor entre 0 e 10.")

    return nota1, nota2


# ---- FUNÇÃO PARA CALCULAR MÉDIA ----

def calcular_media(n1, n2):
    """Calcula a média das duas notas."""
    return (n1 + n2) / 2


# ---- FUNÇÃO PARA DEFINIR SITUAÇÃO ----

def verificar_situacao(media):
    """Retorna a situação do aluno com base na média."""
    
    if media >= 7:
        return "Aprovado"
    elif media >= 4:
        return "Recuperação"
    else:
        return "Reprovado"


# ---- FUNÇÃO PARA GERAR RELATÓRIO ----

def gerar_relatorio(nome, media, situacao):
    """Mostra o resultado final do aluno."""
    
    print("\n--- Relatório do Aluno ---")
    print(f"Nome: {nome}")
    print(f"Média: {media:.2f}")
    print(f"Situação: {situacao}")
    print("--------------------------\n")


# ---- PROGRAMA PRINCIPAL ----

alunos = []

for i in range(3):
    nome = input(f"Digite o nome do aluno {i+1}: ")
    alunos.append(nome)

for aluno in alunos:

    nota1, nota2 = solicitar_notas(aluno)

    media = calcular_media(nota1, nota2)

    situacao = verificar_situacao(media)

    gerar_relatorio(aluno, media, situacao)