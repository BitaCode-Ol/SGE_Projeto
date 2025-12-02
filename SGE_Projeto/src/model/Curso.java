package model;

public class Curso {
    protected String nome;
    protected String codigo;
    protected int cargaHoraria;

    public Curso(String nome, String codigo, int cargaHoraria) {
        this.nome = nome;
        this.codigo = codigo;
        this.cargaHoraria = cargaHoraria;
    }

    public String getNome() { return nome; }
    public String getCodigo() { return codigo; }
    public int getCargaHoraria() { return cargaHoraria; }

    // Método base polimórfico (Fase 4)
    public void detalharCurso(){
        System.out.println("Curso (Padrão): " + nome + " (" + codigo + ") - " + cargaHoraria + "h");
    }

    // Método polimórfico (Fase 6)
    public void gerarRelatorio(){
        System.out.println("--- Relatório de Curso ---");
        detalharCurso();
    }
}