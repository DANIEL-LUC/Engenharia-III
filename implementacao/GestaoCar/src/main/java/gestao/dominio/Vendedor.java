package gestao.dominio;

import java.util.Collection;

public class Vendedor extends EntidadeDominio {

	private String cpf;

	private String nome;

	private String email;

	private String telefone;

	private Endereco endereco;
	

	private Collection<Automovel> automovel;
	
	
	public Vendedor() {
		super();
	}
	

	public Vendedor(int id) {
		setId(id);
	}


	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Collection<Automovel> getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Collection<Automovel> automovel) {
		this.automovel = automovel;
	}
	
	
	

}
