package gestao.negocio.impl;

import gestao.dominio.EntidadeDominio;
import gestao.negocio.IStrategy;

public abstract class AbstractValidateIsNull implements IStrategy {

	protected StringBuilder mensagemErro;

	protected boolean isNull() {
		return false;
	}

	protected boolean isString() {
		return false;
	}

	protected boolean isBoolean() {
		return false;
	}

	protected boolean isInt() {
		return false;
	}


	public void processar(EntidadeDominio entidade) {

	}

}
