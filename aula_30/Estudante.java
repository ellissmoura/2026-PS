public class Estudante {
    private String nome;
    private int idade;
    private int diaNascimento;
    private String codigoIdentificacao;
    private double notaFinal;

    public Estudante(String nome, int idade, int diaNascimento, String codigoIdentificacao, double notaFinal) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome não pode ser vazio.");
        }
        if (idade < 0) {
            throw new IllegalArgumentException("Idade não pode ser negativa.");
        }
        if (diaNascimento <= 0 || diaNascimento > 31) {
            throw new IllegalArgumentException("Dia de nascimento inválido.");
        }
        this.nome = nome;
        this.idade = idade;
        this.diaNascimento = diaNascimento;
        this.codigoIdentificacao = codigoIdentificacao;
        this.notaFinal = notaFinal;
    }

    public String getNome() { return nome; }
    public int getIdade() { return idade; }
    public int getDiaNascimento() { return diaNascimento; }
    public String getCodigoIdentificacao() { return codigoIdentificacao; }
    public double getNotaFinal() { return notaFinal; }

    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Alteração recusada: nome vazio.");
            return;
        }
        this.nome = nome;
    }

    public void setIdade(int idade) {
        if (idade < 0) {
            System.out.println("Alteração recusada: idade negativa.");
            return;
        }
        this.idade = idade;
    }

    public boolean atualizarNota(double novaNota) {
        if (novaNota < 0 || novaNota > 10) {
            System.out.println("Nota inválida. Alteração recusada.");
            return false;
        }
        this.notaFinal = novaNota;
        return true;
    }

    public boolean promoverAno() {
        if (notaFinal >= 6) {
            idade++;
            System.out.println("Estudante promovido para o próximo ano.");
            return true;
        } else {
            System.out.println("Promoção recusada: nota insuficiente.");
            return false;
        }
    }

    public String resumo() {
        return "Estudante: " + nome + " | Idade: " + idade + " | Dia Nasc.: " + diaNascimento +
               " | Código: " + codigoIdentificacao + " | Nota: " + notaFinal;
    }

    public boolean compararNota(Estudante outro) {
        return this.notaFinal > outro.notaFinal;
    }
}
