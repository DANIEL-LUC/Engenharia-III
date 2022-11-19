package gestao.controle.web.command;

import gestao.dominio.EntidadeDominio;
import gestao.util.Resultado;

public class EditarCommand extends AbstractCommand {
public Resultado executar(EntidadeDominio entidade) {
		
		System.out.println("Dentro do Editar command");
		return fachada.editar(entidade);
	}
}
