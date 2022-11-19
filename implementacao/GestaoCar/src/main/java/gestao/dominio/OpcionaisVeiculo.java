package gestao.dominio;

public class OpcionaisVeiculo extends EntidadeDominio {

	private boolean aquecedor;

	private boolean arcondicionado;

	private boolean airBag;

	private boolean alarme;

	private boolean direcaoHidraulica;

	private boolean freioABS;

	private boolean tracao4x4;

	private Automovel automovel;
	
	
	
	public OpcionaisVeiculo() {
		
	}
	
	
	

	public boolean isAquecedor() {
		return aquecedor;
	}

	public void setAquecedor(boolean aquecedor) {
		this.aquecedor = aquecedor;
	}

	public boolean isArcondicionado() {
		return arcondicionado;
	}

	public void setArcondicionado(boolean arcondicionado) {
		this.arcondicionado = arcondicionado;
	}

	public boolean isAirBag() {
		return airBag;
	}

	public void setAirBag(boolean airBag) {
		this.airBag = airBag;
	}

	public boolean isAlarme() {
		return alarme;
	}

	public void setAlarme(boolean alarme) {
		this.alarme = alarme;
	}

	public boolean isDirecaoHidraulica() {
		return direcaoHidraulica;
	}

	public void setDirecaoHidraulica(boolean direcaoHidraulica) {
		this.direcaoHidraulica = direcaoHidraulica;
	}

	public boolean isFreioABS() {
		return freioABS;
	}

	public void setFreioABS(boolean freioABS) {
		this.freioABS = freioABS;
	}

	public boolean isTracao4x4() {
		return tracao4x4;
	}

	public void setTracao4x4(boolean tracao4x4) {
		this.tracao4x4 = tracao4x4;
	}

	public Automovel getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Automovel automovel) {
		this.automovel = automovel;
	}
	
	
	

}