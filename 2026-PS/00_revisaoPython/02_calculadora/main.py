def Leia():
    v1 = int(input('Digite um valor: '))
    v2 = int(input('Digite outro valor: '))
    op = input('Digite a operaçaõ [* / + -]: ')
    msg = f'{v1} {op} {v2}'
    if op == '+':
        res = Soma(v1, v2)
    elif op == '-':
        res = Subtracao(v1,v2)
    elif op == '*':
        res = Multiplicacao(v1,v2)
    elif op == '/':
        res = Divisao(v1,v2)
    Escreva(msg, res)

def Soma(v1, v2):
    return (v1+v2)

def Subtracao(v1, v2):
    return (v1-v2)

def Multiplicacao(v1, v2):
    return (v1*v2)

def Divisao(v1, v2):
    return (v1/v2)

def Escreva(msg, resultado):
    print(f'{msg} = {resultado}')

Leia()