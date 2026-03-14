def kg_para_libras(kg):
    """
    Converte quilogramas para libras.

    Fórmula:
        lb = kg * 2.20462

    Parâmetros:
        kg (float): valor em quilogramas

    Retorna:
        float: valor convertido em libras
    """
    return kg * 2.20462


def kg_para_gramas(kg):
    """
    Converte quilogramas para gramas.

    Fórmula:
        g = kg * 1000

    Parâmetros:
        kg (float): valor em quilogramas

    Retorna:
        float: valor convertido em gramas
    """
    return kg * 1000


if __name__ == "__main__":
    # Este bloco só executa se este arquivo for rodado diretamente.
    print("Testando massa.py...")
    print(f"1 kg = {kg_para_libras(1):.5f} lb (esperado: 2.20462)")
    print(f"2.5 kg = {kg_para_gramas(2.5)} g (esperado: 2500)")
    print("OK!")