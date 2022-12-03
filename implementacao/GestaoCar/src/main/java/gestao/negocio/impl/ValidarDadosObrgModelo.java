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
			
			
			if(isNull(nome)) return "Nome é obrigatório." ;
			if(isNull(ano)) return "Ano de lançamento é obrigatório.";
			if(isNull(acento)) return "Número de acentos é obrigatório.";
			if(isNull(portas)) return "Número de portas é obrigatório.";
			if(isNull(preco)) return "O preço médio é obrigatório";
			if(isNull(potencia)) return "A potência do veículo é obrigatória";
			if(isNull(cambio)) return "O tipo do cambio é obrigatório";
			if(isNull(combustivel)) return "O tipo do combustível é obrigatório";
			if(isNull(kmLitro)) return "A quantidade de km por litro é obrigatório";
			if(isNull(marca)) return "A marca é um campo obrigatório";
			if(isNull(tipo)) return "Selecionar o tipo do automovél é obrigatório";
			
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
