package gestao.dominio;


public class TipoAutomovel extends EntidadeDominio {
	enum ClassesSocial {LUXO, POPULAR};
	private ClassesSocial social;

	private String tipoVeiculo;
	
	
	public ClassesSocial getSocial() {
		return social;
	}

	public void setSocial(ClassesSocial social) {
		this.social = social;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	
}
