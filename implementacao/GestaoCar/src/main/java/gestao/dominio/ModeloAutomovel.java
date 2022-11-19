package gestao.dominio;

import java.util.Collection;

public class ModeloAutomovel extends EntidadeDominio {

	private String nome;

	private String ano_lancamento;

	private String potencia;

	private String TipoCambio;

	private int acento;

	private int portas;

	private float media_preco;

	private String combustivel;

	private float kmLitro;

	private Collection<Automovel> automovel;

	private Marca marca;

	private TipoAutomovel tipoAutomovel;
	
	
	public ModeloAutomovel() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAno_lancamento() {
		return ano_lancamento;
	}

	public void setAno_lancamento(String ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
	}

	public String getPotencia() {
		return potencia;
	}

	public void setPotencia(String potencia) {
		this.potencia = potencia;
	}

	public String getTipoCambio() {
		return TipoCambio;
	}

	public void setTipoCambio(String tipoCambio) {
		TipoCambio = tipoCambio;
	}

	public int getAcento() {
		return acento;
	}

	public void setAcento(int acento) {
		this.acento = acento;
	}

	public int getPortas() {
		return portas;
	}

	public void setPortas(int portas) {
		this.portas = portas;
	}

	public float getMedia_preco() {
		return media_preco;
	}

	public void setMedia_preco(float media_preco) {
		this.media_preco = media_preco;
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

	public Collection<Automovel> getAutomovel() {
		return automovel;
	}

	public void setAutomovel(Collection<Automovel> automovel) {
		this.automovel = automovel;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public TipoAutomovel getTipoAutomovel() {
		return tipoAutomovel;
	}

	public void setTipoAutomovel(TipoAutomovel tipoAutomovel) {
		this.tipoAutomovel = tipoAutomovel;
	}

	
	
	

}
