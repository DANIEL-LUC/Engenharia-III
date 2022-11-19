package gestao.dominio;

public class Automovel extends EntidadeDominio {

	private String ano_fabricacao;

	private float km_rodado;

	private String descricao;

	private boolean tv;

	private String cor_externa;

	private float preco;

	private boolean publicado;

	private String condicao;

	private String vin;

	private ModeloAutomovel modeloAutomovel;

	private Vendedor vendedor;

	private OpcionaisVeiculo opcionaisVeiculo;
	
	
	
	

	public Automovel() {
		super();
	}

	public String getAno_fabricacao() {
		return ano_fabricacao;
	}

	public void setAno_fabricacao(String ano_fabricacao) {
		this.ano_fabricacao = ano_fabricacao;
	}

	public float getKm_rodado() {
		return km_rodado;
	}

	public void setKm_rodado(float km_rodado) {
		this.km_rodado = km_rodado;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isTv() {
		return tv;
	}

	public void setTv(boolean tv) {
		this.tv = tv;
	}

	public String getCor_externa() {
		return cor_externa;
	}

	public void setCor_externa(String cor_externa) {
		this.cor_externa = cor_externa;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public boolean isPublicado() {
		return publicado;
	}

	public void setPublicado(boolean publicado) {
		this.publicado = publicado;
	}

	public String getCondicao() {
		return condicao;
	}

	public void setCondicao(String condicao) {
		this.condicao = condicao;
	}

	public String getVin() {
		return vin;
	}

	public void setVin(String vin) {
		this.vin = vin;
	}

	public ModeloAutomovel getModeloAutomovel() {
		return modeloAutomovel;
	}

	public void setModeloAutomovel(ModeloAutomovel modeloAutomovel) {
		this.modeloAutomovel = modeloAutomovel;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public OpcionaisVeiculo getOpcionaisVeiculo() {
		return opcionaisVeiculo;
	}

	public void setOpcionaisVeiculo(OpcionaisVeiculo opcionaisVeiculo) {
		this.opcionaisVeiculo = opcionaisVeiculo;
	}
	
	
	
	
	
	

}
