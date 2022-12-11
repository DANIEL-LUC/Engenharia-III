package gestao.negocio.impl;

import gestao.dominio.Automovel;
import gestao.dominio.EntidadeDominio;


public class ValidarDadosAutomovel extends AbstractValidateIsNull {
	
	public String processar(EntidadeDominio entidade) {
		String mensagem = "";
		
		if(entidade instanceof Automovel){
			Automovel automovel = (Automovel)entidade;
			
			String vin = automovel.getVin();
			String ano = automovel.getAnoFabricacao();
			Float preco = automovel.getPreco();
			String cor = automovel.getCorExterna();
			Float kmRodado = automovel.getKmRodado();
			
			Integer idModelo = automovel.getModeloAutomovel().getId();
			Integer idVendedor = automovel.getVendedor().getId();
			String descricao = automovel.getDescricao();
			
			
			if(isNull(vin)) return "N� VIN � obrigat�rio." ;
			if(isNull(ano)) return "Ano de fabrica��o � obrigat�rio.";
			if(isNull(preco)) return "O pre�o � obrigat�rio.";
			if(isNull(cor)) return "A cor externa � obrigat�rio.";
			if(isNull(kmRodado)) return "Quilomentros rodados � obrigat�rio";
			if(isNull(idModelo)) return "Selecionar o Modelo � obrigat�ria";
			if(isNull(idVendedor)) return "Selecionar o vendedor � obrigat�rio";
			if(isNull(descricao)) { 
				automovel.setDescricao("Descri��o");
				return null;
			}
			
			System.out.println("__________> km " + kmRodado);
				System.out.println("__________> mensagem " + mensagem);
			if(mensagem.equals("")) {
				return null;
			}else {
				return mensagem;
			}
			
		}else{
			return "Deve ser registrado um automovel!";
		}
	}

}
