/*
 * Disciplina: 2026-P5
 * Estudante: Ellis
 * Data: 2026.09.03
 * Projeto: aula35-clinica
 * Arquivo: Main.java
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static Scanner teclado = new Scanner(System.in);
    static ArrayList<Produto> produtos = new ArrayList<>();


    public static void main(String[] args) {

        int opcao = 0;

        while (opcao != 5) {

            System.out.println("\n=== SISTEMA DE PRODUTOS ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Alterar preço");
            System.out.println("4 - Remover");
            System.out.println("5 - Sair");
            System.out.print("Opção: ");

            opcao = teclado.nextInt();
            teclado.nextLine();

            if (opcao == 1) {
                cadastrar();
            } else if (opcao == 2) {
                listar();
            } else if (opcao == 3) {
                alterarPreco();
            } else if (opcao == 4) {
                remover();
            }
        }

        System.out.println("Sistema encerrado.");
    }

    static Produto buscarPorCodigo(int codigo) {
        for (Produto p : produtos) {
            if (p.getCodigo() == codigo) {
                return p;
            }
        }
        return null;
    }

   
    static void cadastrar() {
        System.out.print("Código: ");
        int codigo = teclado.nextInt();
        teclado.nextLine();

        if (buscarPorCodigo(codigo) != null) {
            System.out.println("Erro: Já existe um produto cadastrado com o código " + codigo + "!");
            return;
        }

        System.out.print("Nome: ");
        String nome = teclado.nextLine();

        System.out.print("Preço: ");
        double preco = teclado.nextDouble();

        Produto p = new Produto(codigo, nome, preco);
        produtos.add(p);
        System.out.println("Produto cadastrado com sucesso!");
    }

    static void listar() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
        } else {
            for (Produto p : produtos) {
                System.out.println(p); 
            }
        }
    }

 
    static void alterarPreco() {
        System.out.print("Código do produto: ");
        int codigo = teclado.nextInt();

     
        Produto p = buscarPorCodigo(codigo);

        if (p == null) {
            System.out.println("Erro: Produto com código " + codigo + " não encontrado.");
            return;
        }

        System.out.println("1 - Novo preço direto");
        System.out.println("2 - Aplicar desconto (%) sobre valor");
        System.out.print("Opção: ");
        int op = teclado.nextInt();

        if (op == 1) {
            System.out.print("Novo preço: ");
            double novoPreco = teclado.nextDouble();
            p.alterarPreco(novoPreco); 
            System.out.println("Preço alterado com sucesso!");
        } else if (op == 2) {
            System.out.print("Preço base: ");
            double precoBase = teclado.nextDouble();
            System.out.print("Porcentagem de desconto (%): ");
            double desconto = teclado.nextDouble();
            p.alterarPreco(precoBase, desconto); 
            System.out.println("Preço com desconto alterado com sucesso!");
        }
    }

  
    static void remover() {
        System.out.print("Código do produto para remoção: ");
        int codigo = teclado.nextInt();

       
        Produto p = buscarPorCodigo(codigo);

        if (p != null) {
            
            produtos.remove(p);
            System.out.println("Produto removido com sucesso!");
        } else {
            
            System.out.println("Erro: Produto com código " + codigo + " não encontrado.");
        }
    }
}