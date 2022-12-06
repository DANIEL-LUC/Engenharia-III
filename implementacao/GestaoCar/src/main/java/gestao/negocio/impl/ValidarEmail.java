package gestao.negocio.impl;

import gestao.dominio.EntidadeDominio;
import gestao.dominio.Vendedor;
import gestao.negocio.IStrategy;

public class ValidarEmail implements IStrategy {


	public String processar(EntidadeDominio entidade) {
		String mensagem = "";
		
		if(entidade instanceof Vendedor){
			Vendedor vendedor = (Vendedor)entidade;
					
			String email = vendedor.getEmail();
			if(isEmail(email)) {
				return null;
			}else {
				return "Digite um E-mail válido";
			}
		}else{
			return "Deve ser registrado um vendedor!";
		}
	}
	
	private boolean isEmail(String email) {
		return email != null && email.matches("^[a-zA-Z0-9_!#$%&'\\*+/=?{|}~^.-]+@[a-zA-Z0-9.-]+$");
	}

}
