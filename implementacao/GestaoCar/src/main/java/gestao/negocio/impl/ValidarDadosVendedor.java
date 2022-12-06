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
			
			
			if(isNull(nome)) return "Nome � obrigat�rio." ;
			if(isNull(cpf)) return "CPF � obrigat�rio.";
			if(isNull(email)) return "E-mail � obrigat�rio.";
			if(isNull(telefone)) return "telefone � obrigat�rio.";
			if(isNull(logradouro)) return "logradouro � obrigat�rio";
			if(isNull(cep)) return "CEP � obrigat�ria";
			if(isNull(numero)) return "n�mero da reside�ncia � obrigat�rio";
			if(isNull(cidade)) return "Cidade � obrigat�rio";
			if(isNull(estador)) return "Estado � obrigat�rio";
			
			
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
