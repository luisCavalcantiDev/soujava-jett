package br.com.emmanuelneri.vo;

public final class PessoaVO {

	private final String nome;
	private final String email;

	public PessoaVO(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}
}
