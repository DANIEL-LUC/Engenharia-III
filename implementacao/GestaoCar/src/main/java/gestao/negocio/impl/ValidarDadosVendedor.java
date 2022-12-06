package gestao.negocio.impl;

import gestao.dominio.EntidadeDominio;
import gestao.dominio.ModeloAutomovel;
import gestao.dominio.Vendedor;
import gestao.negocio.IStrategy;

public class ValidarDadosVendedor extends AbstractValidateIsNull implements IStrategy {


	public String processar(EntidadeDominio entidade) {
		String mensagem = "";
		
		if(entidade instanceof Vendedor){
			Vendedor vendedor = (Vendedor)entidade;
			
			String nome = vendedor.getNome();
			String cpf = vendedor.getCpf();
			String email = vendedor.getEmail();
			String telefone = vendedor.getTelefone();
			
			String logradouro = vendedor.getEndereco().getLogradouro();
			String numero = vendedor.getEndereco().getNumero();
			String cep = vendedor.getEndereco().getCep();
			String cidade = vendedor.getEndereco().getCidade().getNome();
			String estador = vendedor.getEndereco().getCidade().getEstado().getNome();
			
			
			if(isNull(nome)) return "Nome é obrigatório." ;
			if(isNull(cpf)) return "CPF é obrigatório.";
			if(isNull(email)) return "E-mail é obrigatório.";
			if(isNull(telefone)) return "telefone é obrigatório.";
			if(isNull(logradouro)) return "logradouro é obrigatório";
			if(isNull(cep)) return "CEP é obrigatória";
			if(isNull(numero)) return "número da resideência é obrigatório";
			if(isNull(cidade)) return "Cidade é obrigatório";
			if(isNull(estador)) return "Estado é obrigatório";
			
			
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
