package br.com.emmanuelneri.vo;

public final class PessoaVO {

    private final String nome;
    private final String email;
    private String vaga;

    public PessoaVO(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public PessoaVO(String nome, String email, String vaga) {
        this.nome = nome;
        this.email = email;
        this.vaga = vaga;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getVaga() {
        return vaga;
    }
    
    
}
