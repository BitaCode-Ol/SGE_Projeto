package repository;

import model.Turma;
import java.util.ArrayList;
import java.util.List;

public class TurmaRepository {
    private List<Turma> turmas = new ArrayList<>();
    public void salvar(Turma t){ turmas.add(t); }
    public List<Turma> listar(){ return turmas; }
    public Turma buscarPorCodigo(String codigo){
        return turmas.stream().filter(x->x.getCodigo().equals(codigo)).findFirst().orElse(null);
    }
}