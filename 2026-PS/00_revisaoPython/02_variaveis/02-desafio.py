# Programa simples de controle de estoque

produtos = []
quantidades = []

critico = 0
adequado = 0
excesso = 0

# Cadastro de produtos
for i in range(5):
    nome = input("Digite o nome do produto: ")
    qtd = int(input("Digite a quantidade em estoque: "))
    
    produtos.append(nome)
    quantidades.append(qtd)

print("\n--- Relatório de Estoque ---")

# Análise dos produtos
for i in range(len(produtos)):

    if quantidades[i] < 5:
        status = "CRÍTICO"
        critico += 1

    elif quantidades[i] <= 20:
        status = "ADEQUADO"
        adequado += 1

    else:
        status = "EXCESSO"
        excesso += 1

    print("Produto:", produtos[i], "| Quantidade:", quantidades[i], "| Status:", status)

# Resumo geral
print("\n--- Resumo do Estoque ---")
print("Produtos em situação CRÍTICA:", critico)
print("Produtos em situação ADEQUADA:", adequado)
print("Produtos com EXCESSO:", excesso)

# Consulta de produto específico
while True:

    resposta = input("\nDeseja consultar um produto pelo nome? (s/n): ")

    if resposta.lower() == "n":
        print("Encerrando o programa...")
        break

    nome_busca = input("Digite o nome do produto: ")

    if nome_busca in produtos:

        indice = produtos.index(nome_busca)
        qtd = quantidades[indice]

        if qtd < 5:
            status = "CRÍTICO"
        elif qtd <= 20:
            status = "ADEQUADO"
        else:
            status = "EXCESSO"

        print("Produto:", nome_busca, "| Quantidade:", qtd, "| Status:", status)

    else:
        print("Produto não encontrado no estoque.")