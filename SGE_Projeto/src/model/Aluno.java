package model;

import java.util.ArrayList;
import java.util.List;

public class Aluno extends Usuario {
    private String matricula;
    private Curso curso;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    public Aluno(String nome, String login, String senha, String matricula, Curso curso) {
        super(nome, login, senha);
        this.matricula = matricula;
        this.curso = curso;
    }

    public String getMatricula() { return matricula; }
    public Curso getCurso() { return curso; }
    public List<Avaliacao> getAvaliacoes() { return avaliacoes; }

    public void adicionarAvaliacao(Avaliacao a) { avaliacoes.add(a); }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatório do Aluno: " + nome + " ---");
        System.out.println("Matrícula: " + matricula);
        System.out.println("Curso: " + (curso != null ? curso.getNome() : "(não informado)"));
        System.out.println("Avaliações:");
        for (Avaliacao a : avaliacoes) {
            System.out.println("  - " + a.getDescricao() + ": " + a.getNota());
        }
    }
}