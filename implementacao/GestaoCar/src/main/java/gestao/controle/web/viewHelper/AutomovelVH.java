package gestao.controle.web.viewHelper;

import gestao.dominio.Cidade;
import gestao.dominio.Endereco;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.Estado;
import gestao.dominio.Vendedor;
import gestao.util.Resultado;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AutomovelVH implements IViewHelper{

	public void set(EntidadeDominio entidade) {

	}


	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		
		
		return null;
	}


	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setView(Resultado resultado, ServletConfig config) {
		// TODO Auto-generated method stub
		
	}



}
