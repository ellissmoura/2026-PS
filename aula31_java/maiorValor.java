public class maiorValor {

    public static int buscarMaior(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            throw new IllegalArgumentException("O array não pode estar vazio.");
        }
        
        int maior = numeros[0];
        for (int i = 1; i < numeros.length; i++) {
            if (numeros[i] > maior) {
                maior = numeros[i];
            }
        }
        return maior;
    }

    public static void main(String[] args) {
        int[] valores = {12, 45, 3, 89, 21};
        System.out.println("Maior valor: " + buscarMaior(valores)); // Saída: 89
    }
}