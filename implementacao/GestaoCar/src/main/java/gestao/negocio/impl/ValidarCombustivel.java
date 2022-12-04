package gestao.negocio.impl;

import gestao.dominio.EntidadeDominio;
import gestao.dominio.ModeloAutomovel;
import gestao.negocio.IStrategy;

public class ValidarCombustivel implements IStrategy {


	public String processar(EntidadeDominio entidade) {
		ModeloAutomovel modelo = (ModeloAutomovel)entidade;
		
		switch (modelo.getEspecificacaoTecnica().getCombustivel()) {
		case "Gasolina":
			return null;
		case "Alcool":
			return null;
		case "Flex":
			return null;
		default:
			return "O combustivel precisa ser 'Gasolina','Alcool' ou 'Flex'" + modelo.getEspecificacaoTecnica().getCombustivel();
		}
		
	}

}
