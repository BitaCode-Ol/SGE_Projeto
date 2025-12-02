package model;

public class Avaliacao {
    private double nota; // PRIVADO
    private String descricao;

    public Avaliacao(String descricao) {
        this.descricao = descricao;
        this.nota = -1;
    }

    public double getNota() { return nota; }
    public String getDescricao() { return descricao; }

    // Método de controle com validação (Encapsulamento)
    public boolean atribuirNota(double valor) {
        if (valor < 0 || valor > 10) return false;
        this.nota = valor;
        return true;
    }
}