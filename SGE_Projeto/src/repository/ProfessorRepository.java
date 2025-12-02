package repository;

import model.Professor;
import java.util.ArrayList;
import java.util.List;

public class ProfessorRepository {
    private List<Professor> professores = new ArrayList<>();
    public void salvar(Professor p){ professores.add(p); }
    public List<Professor> listar(){ return professores; }
    public Professor buscarPorLogin(String login){
        return professores.stream().filter(x->x.getLogin().equals(login)).findFirst().orElse(null);
    }
}