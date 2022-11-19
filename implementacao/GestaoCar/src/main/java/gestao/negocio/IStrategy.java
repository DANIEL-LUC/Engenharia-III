package gestao.negocio;

import gestao.dominio.EntidadeDominio;

public interface IStrategy {

	public abstract String processar(EntidadeDominio entidade);

}
