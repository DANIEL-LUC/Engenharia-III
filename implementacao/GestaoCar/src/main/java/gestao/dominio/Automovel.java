package gestao.dominio;

public class Automovel extends EntidadeDominio {

	private String anoFabricacao;

	private float kmRodado;

	private String descricao;

	private boolean tv;

	private String corExterna;

	private float preco;

	private String publicado;

	private String condicao;

	private String vin;

	private ModeloAutomovel modeloAutomovel;

	private Vendedor vendedor;

	private OpcionaisVeiculo opcionaisVeiculo;
	
	
	
	

	public Automovel() {
		super();
	}

	public String getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(String ano_fabricacao) {
		this.anoFabricacao = ano_fabricacao;
	}

	public float getKmRodado() {
		return kmRodado;
	}

	public void setKmRodado(float kmRodado) {
		this.kmRodado = kmRodado;
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

	public String getCorExterna() {
		return corExterna;
	}

	public void setCorExterna(String cor_externa) {
		this.corExterna = cor_externa;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getPublicado() {
		return publicado;
	}

	public void setPublicado(String publicado) {
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
