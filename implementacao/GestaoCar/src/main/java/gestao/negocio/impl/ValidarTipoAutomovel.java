package gestao.negocio.impl;

import gestao.dominio.EntidadeDominio;
import gestao.dominio.ModeloAutomovel;
import gestao.negocio.IStrategy;

public class ValidarTipoAutomovel implements IStrategy {

	
	public String processar(EntidadeDominio entidade) {
		ModeloAutomovel modelo = (ModeloAutomovel)entidade;
		
		switch (modelo.getTipoAutomovel().getTipo()) {
		case "Convencional":
			return null;
		case "Moto":
			return null;
		case "Caminhonete":
			return null;
		default:
			return "O modelo do automóvel precisa ser do tipo 'Convencional','Moto' ou 'Caminhonete'";
		}
		
	}
}
