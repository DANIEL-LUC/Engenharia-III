package gestao.dominio;

import java.util.Collection;

public class Estado extends EntidadeDominio {

	private String nome;

	private Collection<Cidade> cidade;

	public Estado(String nome) {
		this.nome = nome;
	}

	public Estado() {
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<Cidade> getCidade() {
		return cidade;
	}

	public void setCidade(Collection<Cidade> cidade) {
		this.cidade = cidade;
	}
	
	

}
