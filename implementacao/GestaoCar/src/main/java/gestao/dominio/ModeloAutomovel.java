package gestao.dominio;

import java.util.Collection;

public class ModeloAutomovel extends EntidadeDominio{

	private String nome;

	private String ano_lancamento;

	private Integer acento;

	private Integer portas;

	private float mediaPreco;

	private Collection<Automovel> automovel;

	private Marca marca;

	private TipoAutomovel tipoAutomovel;

	private ClassificacaoSocial classificacaoSocial;

	private EspecificacaoTecnica especificacaoTecnica;
	
	private boolean economico ;
	
	
	

	public ModeloAutomovel() {
		super();
	}
	public ModeloAutomovel(int id) {
		setId(id);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAnoLancamento() {
		return ano_lancamento;
	}

	public void setAnoLancamento(String ano_lancamento) {
		this.ano_lancamento = ano_lancamento;
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

	public float getMediaPreco() {
		return mediaPreco;
	}

	public void setMediaPreco(float media_preco) {
		this.mediaPreco = media_preco;
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

	public ClassificacaoSocial getClassifacaoSocial() {
		return classificacaoSocial;
	}

	public void setClassifacaoSocial(ClassificacaoSocial classifacaoSocial) {
		this.classificacaoSocial = classifacaoSocial;
	}

	public EspecificacaoTecnica getEspecificacaoTecnica() {
		return especificacaoTecnica;
	}

	public void setEspecificacaoTecnica(EspecificacaoTecnica especificacaoTecnica) {
		this.especificacaoTecnica = especificacaoTecnica;
	}

	public boolean isEconomico() {
		return economico;
	}

	public void setEconomico(boolean economico) {
		this.economico = economico;
	}
	
	

}
