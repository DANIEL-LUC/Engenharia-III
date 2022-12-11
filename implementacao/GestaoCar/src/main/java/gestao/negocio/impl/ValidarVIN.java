package gestao.negocio.impl;

import java.util.Calendar;

import gestao.dominio.Automovel;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.Vendedor;
import gestao.negocio.IStrategy;

public class ValidarVIN implements IStrategy {


	public String processar(EntidadeDominio entidade) {
		String mensagem = "";
		
		if(entidade instanceof Automovel){
			Automovel automovel = (Automovel)entidade;
					
			String vin = automovel.getVin();
			if(isVIN(vin)) {
				return null;
			}else {
				return "Digite um n° VIN válido";
			}
		}else{
			return "Deve ser registrado um Automovel!";
		}
	}
	
	private boolean isVIN(String vin) {
		return vin != null && vin.matches("[a-zA-Z0-9]{17}");
	}

}
