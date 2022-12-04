package gestao.negocio.impl;

import gestao.dominio.EntidadeDominio;
import gestao.dominio.ModeloAutomovel;
import gestao.negocio.IStrategy;

public class CompletarClassificacaoSocial implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		ModeloAutomovel modelo = (ModeloAutomovel)entidade;
		
		if(modelo.getMediaPreco() > 100000) {
			modelo.getClassifacaoSocial().setClassificao("LUXO");
		}else {
			modelo.getClassifacaoSocial().setClassificao("POPULAR");
		}
		
		
		return null;

	}

}
