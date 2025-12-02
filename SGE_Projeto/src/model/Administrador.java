package model;

public class Administrador extends Usuario {
    private String nivel;

    public Administrador(String nome, String login, String senha, String nivel) {
        super(nome, login, senha);
        this.nivel = nivel;
    }

    @Override
    public boolean autenticar(String login, String senha) {
        return this.login.equals(login) && this.senha.equals(senha);
    }

    @Override
    public void gerarRelatorio() {
        System.out.println("--- Relatório do Administrador ---");
        System.out.println("Nome: " + nome + " (Nível: " + nivel + ")");
    }
}