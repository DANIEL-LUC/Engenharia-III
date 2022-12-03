package gestao.dominio;

import java.util.Collection;

public class Marca {

	private String nome;

	private Collection<ModeloAutomovel> modeloAutomovel;
	
	

	public Marca() {	
	}

	public Marca(String marca) {
		this.nome = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Collection<ModeloAutomovel> getModeloAutomovel() {
		return modeloAutomovel;
	}

	public void setModeloAutomovel(Collection<ModeloAutomovel> modeloAutomovel) {
		this.modeloAutomovel = modeloAutomovel;
	}
	
	
	

}
