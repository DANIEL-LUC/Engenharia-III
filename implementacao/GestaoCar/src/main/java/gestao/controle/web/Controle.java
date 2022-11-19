package gestao.controle.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import gestao.controle.web.command.ConsultarCommand;
import gestao.controle.web.command.ICommand;
import gestao.controle.web.command.SalvarCommand;
import gestao.controle.web.viewHelper.AutomovelVH;
import gestao.controle.web.viewHelper.IViewHelper;
import gestao.controle.web.viewHelper.VendedorVH;
import gestao.dominio.EntidadeDominio;

import gestao.util.Resultado;


public class Controle extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Map<String, ICommand> commands;
	private static Map<String, IViewHelper> vhs;
	private static String uri = null;
	private static HttpServletRequest request;
	private static String operacao = null;

	private static IViewHelper vh;

    public Controle() {
    	
    	vhs = new HashMap<String, IViewHelper>();
		vhs.put("/GestaoCar/Automovel", new AutomovelVH());
		vhs.put("/GestaoCar/Vendedor", new VendedorVH());
		
		
		
		commands = new HashMap<String, ICommand>();
		commands.put("Salvar", new SalvarCommand());
		commands.put("Consultar", new ConsultarCommand());
     
    }
    
	protected void doProcessRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		uri = request.getRequestURI();
		System.out.print(uri);
		this.request = request;
	
		operacao = request.getParameter("operacao");
		
		System.out.println("---------------> operacao = " + operacao);

		Resultado resultado = doProcess();

		vh.setView(resultado, request, response);
	}
    
	protected Resultado doProcess() throws ServletException {

		vh = vhs.get(uri);

		EntidadeDominio entidade = vh.getEntidade(request);
		
		if (operacao == null) {
			operacao = "Consultar";
		} else {
			operacao = request.getParameter("operacao");
			System.out.println(operacao);
		}

		if(operacao != null) {
			ICommand command = commands.get(operacao);
			System.out.println("COmmand  = ="+command.getClass().getName());

			Resultado resultado = command.executar(entidade);

			return resultado;
		}
		
		return null;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcessRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcessRequest(request, response);
	}

}
