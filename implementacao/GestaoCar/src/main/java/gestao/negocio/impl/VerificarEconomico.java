package gestao.negocio.impl;

import gestao.dominio.EntidadeDominio;
import gestao.dominio.ModeloAutomovel;
import gestao.negocio.IStrategy;

public class VerificarEconomico implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		ModeloAutomovel modelo = (ModeloAutomovel)entidade;
		
		
		if(modelo.getEspecificacaoTecnica().getKmLitro() > 1.3 ) {
			modelo.setEconomico(true);
		}else modelo.setEconomico(false);
		
		return null;
		
	}

}
