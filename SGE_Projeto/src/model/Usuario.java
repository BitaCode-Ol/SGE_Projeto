package model;

public abstract class Usuario implements Autenticacao {
    protected String nome;
    protected String login;
    protected String senha;

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() { return nome; }
    public String getLogin() { return login; }

    // Método abstrato polimórfico (Fase 6)
    public abstract void gerarRelatorio();
}