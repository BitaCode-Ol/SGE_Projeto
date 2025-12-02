package repository;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno a){ alunos.add(a); }
    public List<Aluno> listar(){ return alunos; }
    public Aluno buscarPorMatricula(String m){
        return alunos.stream().filter(x->x.getMatricula().equals(m)).findFirst().orElse(null);
    }
}