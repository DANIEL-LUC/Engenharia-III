package gestao.controle.web.command;

import gestao.dominio.EntidadeDominio;
import gestao.util.Resultado;

public interface ICommand {

	public abstract Resultado executar(EntidadeDominio entidade);

}
