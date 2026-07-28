public class Main {
    public static void main(String[] args) {
        Estudante e1 = new Estudante("Ellis", 20, 28, "El123", 8.5);
        Estudante e2 = new Estudante("Elena", 19, 28, "El456", 5.0);
        Estudante e3 = new Estudante("Elvis", 22, 28, "El789", 7.0);

        e1.setNome("");
        e2.setIdade(-3);
        e3.atualizarNota(9.0);
        e2.promoverAno();

        System.out.println(e1.resumo());
        System.out.println(e2.resumo());
        System.out.println(e3.resumo());

        System.out.println("E1 tem nota maior que E2? " + e1.compararNota(e2));
    }
}
