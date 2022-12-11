package gestao.dominio;

public class ClassificacaoSocial extends EntidadeDominio {

	private String classificacao;

	public ClassificacaoSocial(String social) {
		this.classificacao = social;
	}

	public ClassificacaoSocial() {
		// TODO Auto-generated constructor stub
	}

	public String getClassificao() {
		return classificacao;
	}

	public void setClassificao(String classificacao) {
		this.classificacao = classificacao;
	}

	
}
