package gestao.dominio;

import java.util.Collection;

public class Cidade extends EntidadeDominio {

	private String nome;

	private Estado estado;

	private Collection<Endereco> endereco;

	public Cidade(String nome, Estado estado) {
		this.nome = nome;
		this.estado = estado;
	}
	
	
	public Cidade() {
		super();
	}


	public Cidade(Estado estado) {
		this.estado = estado;
	}


	public Cidade(String nomeCidade) {
		this.nome = nomeCidade;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Collection<Endereco> getEndereco() {
		return endereco;
	}

	public void setEndereco(Collection<Endereco> endereco) {
		this.endereco = endereco;
	}
	
	

}
