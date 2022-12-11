package gestao.negocio.impl;

import java.util.Calendar;

import gestao.dominio.Automovel;
import gestao.dominio.EntidadeDominio;
import gestao.negocio.IStrategy;

public class ValidarData implements IStrategy {

	@Override
	public String processar(EntidadeDominio entidade) {
		
		Calendar cal = Calendar.getInstance();
		
		if(entidade instanceof Automovel){
			Automovel automovel = (Automovel)entidade;
			
			String[] data = automovel.getAnoFabricacao().split("-");
			if(data[0].matches("[0-9]{4}")){
			}else return "Digite um ano valido";
			
			Integer dataInt = Integer.parseInt(data[0]);
			Integer dataAtual = cal.get(Calendar.YEAR);
			if( dataInt > 1950 && dataInt <= dataAtual ) {
				return null;
			}else return "A data de fabricação deve ser antes ou no ano atual e depois de 1950";
			
		}else{
			return "Deve ser registrado um automovel!";
		}
	}

}
