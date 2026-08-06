public class media {

    public static double calcularMedia(double[] notas) {
        if (notas.length == 0) return 0.0;

        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    public static void main(String[] args) {
        double[] notasAluno = {7.5, 8.0, 9.5, 6.0};
        double media = calcularMedia(notasAluno);
        System.out.printf("Média do aluno: %.2f\n", media); 
    }
}