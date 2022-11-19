package gestao.controle.web.command;

import gestao.dominio.EntidadeDominio;
import gestao.util.Resultado;

public class ConsultarCommand extends AbstractCommand {
	
	public Resultado executar(EntidadeDominio entidade) {
		
		System.out.println("Dentro do salvar command");
		return fachada.consultar(entidade);
	}
}
