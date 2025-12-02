package repository;

import model.Curso;
import java.util.ArrayList;
import java.util.List;

public class CursoRepository {
    private List<Curso> cursos = new ArrayList<>();
    public void salvar(Curso c){ cursos.add(c); }
    public List<Curso> listar(){ return cursos; }
    public Curso buscarPorCodigo(String codigo){
        return cursos.stream().filter(x->x.getCodigo().equals(codigo)).findFirst().orElse(null);
    }
}