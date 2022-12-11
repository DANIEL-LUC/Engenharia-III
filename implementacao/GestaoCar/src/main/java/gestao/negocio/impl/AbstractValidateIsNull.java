package gestao.negocio.impl;

import gestao.dominio.EntidadeDominio;
import gestao.negocio.IStrategy;

public abstract class AbstractValidateIsNull implements IStrategy {

	protected StringBuilder mensagemErro;

	protected boolean isNull(Object obj) {
		return obj == null;
	}

	protected boolean isEmpty(String s) {
		return (s.equals(""));
	}

	protected boolean isBoolean() {
		return false;
	}

	protected boolean isInt() {
		return false;
	}


	public String processar(EntidadeDominio entidade) {
		return null;

	}

}
