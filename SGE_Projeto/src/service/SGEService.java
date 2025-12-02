package service;

import model.*;
import repository.*;

public class SGEService {
    // Instancia todos os repositórios
    public AlunoRepository alunoRepo = new AlunoRepository();
    public ProfessorRepository profRepo = new ProfessorRepository();
    public CursoRepository cursoRepo = new CursoRepository();
    public TurmaRepository turmaRepo = new TurmaRepository();

    // Métodos de negócio (o UI chama esses métodos para realizar operações)
    public Aluno cadastrarAluno(String nome, String login, String senha, String matricula, Curso curso){
        Aluno a = new Aluno(nome, login, senha, matricula, curso);
        alunoRepo.salvar(a);
        return a;
    }

    public Professor cadastrarProfessor(String nome, String login, String senha, String especialidade, String registro){
        Professor p = new Professor(nome, login, senha, especialidade, registro);
        profRepo.salvar(p);
        return p;
    }

    public Curso cadastrarCursoPresencial(String nome, String codigo, int carga, String sala){
        CursoPresencial c = new CursoPresencial(nome, codigo, carga, sala);
        cursoRepo.salvar(c);
        return c;
    }

    public Curso cadastrarCursoEAD(String nome, String codigo, int carga, String plataforma){
        CursoEAD c = new CursoEAD(nome, codigo, carga, plataforma);
        cursoRepo.salvar(c);
        return c;
    }

    public Turma criarTurma(String codigo, Professor prof, Curso curso){
        Turma t = new Turma(codigo, prof, curso);
        turmaRepo.salvar(t);
        return t;
    }
}