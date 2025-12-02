package model;

import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String codigo;
    private Professor professor;
    private Curso curso;
    private List<Aluno> listaAlunos = new ArrayList<>();

    public Turma(String codigo, Professor professor, Curso curso) {
        this.codigo = codigo;
        this.professor = professor;
        this.curso = curso;
    }

    public String getCodigo() { return codigo; }
    public Professor getProfessor() { return professor; }
    public Curso getCurso() { return curso; }
    public List<Aluno> getListaAlunos() { return listaAlunos; }

    public void adicionarAluno(Aluno a) {
        if (!listaAlunos.contains(a)) listaAlunos.add(a);
    }

    public void removerAluno(Aluno a) {
        listaAlunos.remove(a);
    }

    public void mostrarResumo() {
        System.out.println("--- Resumo da Turma: " + codigo + " ---");
        System.out.println("Curso: " + (curso != null ? curso.getNome() : "(não informado)"));
        System.out.println("Professor: " + (professor != null ? professor.getNome() : "(não informado)"));
        System.out.println("Quantidade de alunos: " + listaAlunos.size());
    }
}