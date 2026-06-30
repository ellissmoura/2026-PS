// Importa a classe ArrayList da biblioteca Java
import java.util.ArrayList;

// Classe principal que contém todos os exercícios
public class Aula29Exercicios {

    // 🧩 Exercício 1 — Média da Turma
    // Método estático que recebe um array de notas e retorna a média
    static double calcularMedia(double[] notas) {
        double soma = 0; // variável para acumular a soma das notas
        for (double nota : notas) { // percorre cada nota do array
            soma += nota; // adiciona a nota à soma
        }
        return soma / notas.length; // divide pela quantidade de notas e retorna a média
    }

    // 🧩 Exercício 2 — Contador de Aprovados
    // Método que conta quantas notas são >= 6.0
    static int contarAprovados(double[] notas) {
        int contador = 0; // contador de aprovados
        for (double nota : notas) { // percorre cada nota
            if (nota >= 6.0) { // verifica se a nota é maior ou igual a 6
                contador++; // incrementa o contador
            }
        }
        return contador; // retorna o total de aprovados
    }

    // 🧩 Exercício 3 — Catálogo de Produtos (ArrayList)
    // Método que adiciona um produto à lista
    static void adicionarProduto(ArrayList<String> lista, String nome) {
        lista.add(nome); // insere o produto na lista
    }

    // Método que lista todos os produtos numerados
    static void listarProdutos(ArrayList<String> lista) {
        for (int i = 0; i < lista.size(); i++) { // percorre a lista usando índice
            System.out.println((i + 1) + " - " + lista.get(i)); // imprime número e nome do produto
        }
    }

    // 🧩 Exercício 4 — Maior Valor com Sobrecarga
    // Versão que recebe um array e retorna o maior valor
    static int maiorValor(int[] valores) {
        int maior = valores[0]; // assume que o primeiro é o maior inicialmente
        for (int v : valores) { // percorre cada valor do array
            if (v > maior) { // se encontrar valor mai;or
                maior = v; // atualiza o maior
            }
        }
        return maior; // retorna o maior valor encontrado
    }

    // Versão sobrecarregada que recebe dois números e retorna o maior
    static int maiorValor(int a, int b) {
        return (a > b) ? a : b; // usa operador ternário para decidir qual é maior
    }

    // 🧩 Exercício 5 — Boletim Integrador
    // Método que exibe boletim usando os métodos calcularMedia e contarAprovados
    static void exibirBoletim(double[] notas) {
        double media = calcularMedia(notas); // calcula a média chamando o método do Ex 1
        int aprovados = contarAprovados(notas); // conta aprovados chamando o método do Ex 2
        String situacao = (media >= 6.0) ? "APROVADA" : "EM RECUPERACAO"; // decide situação da turma

        // imprime os resultados formatados
        System.out.println("Média: " + media);
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Situação: " + situacao);
    }

    // Método main para testar todos os exercícios
    public static void main(String[] args) {
        // Teste Exercício 1
        System.out.println(calcularMedia(new double[]{7.0, 8.0, 9.0})); // deve imprimir 8.0

        // Teste Exercício 2
        System.out.println(contarAprovados(new double[]{7.0, 4.0, 9.0, 6.0})); // deve imprimir 3

        // Teste Exercício 3
        ArrayList<String> lista = new ArrayList<>(); // cria lista vazia
        adicionarProduto(lista, "Pizza"); // adiciona "Pizza"
        adicionarProduto(lista, "Suco"); // adiciona "Suco"
        listarProdutos(lista); // imprime lista numerada

        // Teste Exercício 4
        System.out.println(maiorValor(new int[]{3, 9, 5})); // deve imprimir 9
        System.out.println(maiorValor(12, 7)); // deve imprimir 12

        // Teste Exercício 5
        exibirBoletim(new double[]{7.0, 5.0, 9.0, 6.0}); // boletim da turma 1
        exibirBoletim(new double[]{4.0, 3.0, 5.0}); // boletim da turma 2
    }
}


