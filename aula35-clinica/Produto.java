/*
 * Disciplina: 2026-P5
 * Estudante: Ellis
 * Data: 2026.09.03
 * Projeto: aula35-clinica
 * Arquivo: Produto.java
 */

public class Produto {

    private int codigo;
    private String nome;
    private double preco;

    public Produto() {
    }

    public Produto(int codigo, String nome, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }


    public void alterarPreco(double preco) {
        this.preco = preco;
    }

    public void alterarPreco(double preco, double desconto) {
        this.preco = preco - (preco * (desconto / 100.0));
    }
    
    @Override
    public String toString() {
        return String.format("[ID: %03d] %-15s -> R$ %.2f", codigo, nome, preco);
    }
}