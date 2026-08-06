public class menorValor {

    static int buscarMenor(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("O array não pode estar vazio.");
        }

        int menor = numeros[0];

        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] < menor) {
                menor = numeros[i];
            }
        }

        return menor;
    }

    public static void main(String[] args) {
        int[] meusNumeros = {15, 8, 42, 4, 23, 10};

        int resultado = buscarMenor(meusNumeros);

        System.out.println("O menor valor do array é: " + resultado);
    }
}