/*
* disciplina: 2026-PS
*estudante: ELLIS MARIA SANDANO DE MOURA
*data: 2026.08.13
*projeto: aula32-projeto-secretaria
*arquivo: aluno.java */

public class Aluno {
    private String nome;
    private String matricula;
    private String curso;

    // Construtor
    public Aluno(String nome, String matricula, String curso) {
        this.nome = nome;
        this.matricula = matricula;
        this.curso = curso;
    }

    // Getters
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getCurso() {
        return curso;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}

