package model;

public class CursoEAD extends Curso {
    private String plataforma;

    public CursoEAD(String nome, String codigo, int cargaHoraria, String plataforma) {
        super(nome, codigo, cargaHoraria);
        this.plataforma = plataforma;
    }

    public String getPlataforma() { return plataforma; }

    @Override
    public void detalharCurso() {
        System.out.println("Curso EAD: " + nome + " (" + codigo + ") - " + cargaHoraria + "h - Plataforma: " + plataforma);
    }
}