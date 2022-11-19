package gestao.controle.web.command;

import gestao.controller.impl.Fachada;
import gestao.dominio.EntidadeDominio;
import gestao.util.Resultado;

public class AbstractCommand implements ICommand {

	protected Fachada fachada = new Fachada();


	@Override
	public Resultado executar(EntidadeDominio entidade) {
		return null;
		// TODO Auto-generated method stub
		
	}

}
