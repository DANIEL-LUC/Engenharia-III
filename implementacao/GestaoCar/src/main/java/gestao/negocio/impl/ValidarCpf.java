package gestao.negocio.impl;

import gestao.dominio.EntidadeDominio;
import gestao.dominio.Vendedor;
import gestao.negocio.IStrategy;

public class ValidarCpf implements IStrategy {


	public String processar(EntidadeDominio entidade) {
		String mensagem = "";
		
		if(entidade instanceof Vendedor){
			Vendedor vendedor = (Vendedor)entidade;
					
			String cpf = vendedor.getCpf();
			if(isCPF(cpf)) {
				return null;
			}else {
				return "Digite um CPF válido";
			}
		}else{
			return "Deve ser registrado um vendedor!";
		}
	}
	
	private boolean isCPF(String cpf) {
		return cpf != null && cpf.matches("[0-9]{11}");
	}

}
