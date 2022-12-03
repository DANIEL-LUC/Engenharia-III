package gestao.dominio;

public class EspecificacaoTecnica extends EntidadeDominio {

	private float potenciaCv;

	private String cambio;

	private String combustivel;

	private float kmLitro;

	public float getPotenciaCv() {
		return potenciaCv;
	}

	public void setPotenciaCv(float potenciaCv) {
		this.potenciaCv = potenciaCv;
	}

	public String getCambio() {
		return cambio;
	}

	public void setCambio(String cambio) {
		this.cambio = cambio;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	public float getKmLitro() {
		return kmLitro;
	}

	public void setKmLitro(float kmLitro) {
		this.kmLitro = kmLitro;
	}

	
	
}
