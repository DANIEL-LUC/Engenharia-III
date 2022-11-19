package gestao.controle.web.viewHelper;

import gestao.dominio.EntidadeDominio;
import gestao.util.Resultado;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface IViewHelper {

	public EntidadeDominio getEntidade(HttpServletRequest request);
	
	public void setView(Resultado resultado, 
			HttpServletRequest request, HttpServletResponse response)throws ServletException;
	
	public void setView(Resultado resultado, ServletConfig config);
}

