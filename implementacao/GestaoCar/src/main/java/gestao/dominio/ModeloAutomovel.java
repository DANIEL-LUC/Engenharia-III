package gestao.dominio;

import java.util.Collection;

public class ModeloAutomovel extends EntidadeDominio{

	private String nome;

	private String ano_lancamento;

	private int acento;

	private int portas;

	private float media_preco;

	private Collection<Automovel> automovel;

	private Marca marca;

	private TipoAutomovel tipoAutomovel;

	private ClassifacaoSocial classifacaoSocial;

	private EspecificacaoTecnica especificacaoTecnica;
	
	
	

	public ModeloAutomovel() {
		super();
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

	public ClassifacaoSocial getClassifacaoSocial() {
		return classifacaoSocial;
	}

	public void setClassifacaoSocial(ClassifacaoSocial classifacaoSocial) {
		this.classifacaoSocial = classifacaoSocial;
	}

	public EspecificacaoTecnica getEspecificacaoTecnica() {
		return especificacaoTecnica;
	}

	public void setEspecificacaoTecnica(EspecificacaoTecnica especificacaoTecnica) {
		this.especificacaoTecnica = especificacaoTecnica;
	}
	
	

}
