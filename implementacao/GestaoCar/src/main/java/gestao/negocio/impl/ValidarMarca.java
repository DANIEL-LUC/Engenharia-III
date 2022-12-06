package gestao.negocio.impl;

import gestao.dominio.EntidadeDominio;
import gestao.dominio.ModeloAutomovel;
import gestao.negocio.IStrategy;

public class ValidarMarca implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		ModeloAutomovel modelo = (ModeloAutomovel)entidade;
		
		
		switch (modelo.getMarca().getNome()) {
		case "Chevrolet":
			return null;
		case "Volkswagen":
			return null;
		case "Renault":
			return null;
		case "Fiat":
			return null;
		case "Mercedes Benz":
			return null;
		default:
			return "A marca deve ser Mercedes Benz, Fiat, Renault, Volkswagen ou Chevrolet";
		}
		
	}

}
