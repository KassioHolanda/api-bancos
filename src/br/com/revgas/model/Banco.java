package br.com.revgas.model;

public class Banco {
	private long id;
	private int codigoDeCompensacao;
	private String nomeInstituicao;
	
	public Banco() {}

	public Banco(long id, int codigoDeCompensacao, String nomeInstituicao) {		
		this.id = id;
		this.codigoDeCompensacao = codigoDeCompensacao;
		this.nomeInstituicao = nomeInstituicao;
	}

	public int getCodigoDeCompensacao() {
		return codigoDeCompensacao;
	}

	public void setCodigoDeCompensacao(int codigoDeCompensacao) {
		this.codigoDeCompensacao = codigoDeCompensacao;
	}

	public String getNomeInstituicao() {
		return nomeInstituicao;
	}

	public void setNomeInstituicao(String nomeInstituicao) {
		this.nomeInstituicao = nomeInstituicao;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
