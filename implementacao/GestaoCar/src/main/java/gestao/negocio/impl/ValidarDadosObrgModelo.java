package gestao.negocio.impl;

import gestao.dominio.EntidadeDominio;
import gestao.dominio.ModeloAutomovel;

public class ValidarDadosObrgModelo extends AbstractValidateIsNull {
	
	public String processar(EntidadeDominio entidade) {
		String mensagem = "";
		
		if(entidade instanceof ModeloAutomovel){
			ModeloAutomovel modelo = (ModeloAutomovel)entidade;
			
			String nome = modelo.getNome();
			String ano = modelo.getAnoLancamento();
			Integer acento = modelo.getAcento();
			Integer portas = modelo.getPortas();
			Float preco = modelo.getMediaPreco();
			
			Float potencia = modelo.getEspecificacaoTecnica().getPotenciaCv();
			String cambio = modelo.getEspecificacaoTecnica().getCambio();
			String combustivel = modelo.getEspecificacaoTecnica().getCombustivel();
			Float kmLitro = modelo.getEspecificacaoTecnica().getKmLitro();
			
			String marca = modelo.getMarca().getNome();
			
			String tipo = modelo.getTipoAutomovel().getTipo();
			
			
			if(isNull(nome)) return "Nome � obrigat�rio." ;
			if(isNull(ano)) return "Ano de lan�amento � obrigat�rio.";
			if(isNull(acento)) return "N�mero de acentos � obrigat�rio.";
			if(isNull(portas)) return "N�mero de portas � obrigat�rio.";
			if(isNull(preco)) return "O pre�o m�dio � obrigat�rio";
			if(isNull(potencia)) return "A pot�ncia do ve�culo � obrigat�ria";
			if(isNull(cambio)) return "O tipo do cambio � obrigat�rio";
			if(isNull(combustivel)) return "O tipo do combust�vel � obrigat�rio";
			if(isNull(kmLitro)) return "A quantidade de km por litro � obrigat�rio";
			if(isNull(marca)) return "A marca � um campo obrigat�rio";
			if(isNull(tipo)) return "Selecionar o tipo do automov�l � obrigat�rio";
			
				System.out.println("__________> menagem " + mensagem);
			if(mensagem.equals("")) {
				return null;
			}else {
				return mensagem;
			}
			
		}else{
			return "Deve ser registrado um fornecedor!";
		}
	}
}
