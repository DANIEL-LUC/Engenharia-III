package gestao.dominio;


public class TipoAutomovel extends EntidadeDominio{

	private String tipo;

	private ModeloAutomovel modeloAutomovel;
	
	

	public TipoAutomovel(String tipoAutomovel) {
		this.tipo = tipoAutomovel;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public ModeloAutomovel getModeloAutomovel() {
		return modeloAutomovel;
	}

	public void setModeloAutomovel(ModeloAutomovel modeloAutomovel) {
		this.modeloAutomovel = modeloAutomovel;
	}

	

}
