package gestao.negocio.impl;

import java.util.Calendar;

import gestao.dominio.Automovel;
import gestao.dominio.EntidadeDominio;

import gestao.negocio.IStrategy;

public class ValidarCondicao extends AbstractValidateIsNull {


	
	public String processar(EntidadeDominio entidade) {
		
		Calendar cal = Calendar.getInstance();
		System.out.println("DEntro editar validar");
		if(entidade instanceof Automovel){
			Automovel automovel = (Automovel)entidade;
			if(isEmpty(automovel.getAnoFabricacao())) return "Ano de fabricação é obrigatório.";
			
			String[] data = automovel.getAnoFabricacao().split("-");
			Integer dataInt = Integer.parseInt(data[0]);
			Integer dataAtual = cal.get(Calendar.YEAR);
			
			Integer ano = (dataAtual - dataInt );
			if( ano <3 ) {
				if((automovel.getKmRodado() == 0.0)&& (ano == 0)) {
					automovel.setCondicao("Novo");
					return null;
				}
				
				Integer kmPermitido = (1+ano)*20;
				if(automovel.getKmRodado() <= kmPermitido) {
					automovel.setCondicao("Seminovo");
					return null;
				}
				
				automovel.setCondicao("Usado");
				return null;
			}else {
				automovel.setCondicao("Usado");
				return null;
			}
			
		}else{
			return "Deve ser registrado um automovel!";
		}
	}


}
