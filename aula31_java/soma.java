public class soma{

    public static int somarArray(int[] numeros) {
        int soma = 0;
        for (int i = 0; i < numeros.length; i++) {
            soma += numeros[i];
        }
        return soma;
    }

    public static void main(String[] args) {
        int[] valores = {5, 10, 15, 20};
        int resultado = somarArray(valores);
        System.out.println("Soma total: " + resultado); // Saída: 50
    }
}