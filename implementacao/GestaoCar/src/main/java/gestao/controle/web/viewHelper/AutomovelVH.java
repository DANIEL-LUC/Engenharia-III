package gestao.controle.web.viewHelper;

import java.io.IOException;

import gestao.dominio.Automovel;
import gestao.dominio.Cidade;
import gestao.dominio.ClassificacaoSocial;
import gestao.dominio.Endereco;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.EspecificacaoTecnica;
import gestao.dominio.Estado;
import gestao.dominio.Marca;
import gestao.dominio.ModeloAutomovel;
import gestao.dominio.TipoAutomovel;
import gestao.dominio.Vendedor;
import gestao.util.Resultado;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AutomovelVH implements IViewHelper{

	public void set(EntidadeDominio entidade) {

	}


	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		System.out.println("DENTRO DA VIEW HELPER Automovel");
		String operacao = request.getParameter("operacao");
		
		Automovel m = new Automovel();
		
		String id = request.getParameter("txtId");
		
		System.out.println("id=" + id);
		
		if(operacao != null) {
			if( operacao.equals("Consultar") || operacao.equals("Excluir") ) {
				System.out.println("Dentro do is VH Modelo id = " + id);
				
				if(id != null) {
					m.setId(Integer.parseInt(id));
				}else {
					m.setId(-1);
					return m;
				}
				return m;
			}else if(operacao.equals("Editar")) {
				m.setId(Integer.parseInt(id));
			}
		}else {
			m.setId(-1);
			return m;
		}
		
		String vin = request.getParameter("txtVin");
		String Ano = request.getParameter("txtAnoFabricacao");
		String preco = request.getParameter("txtPreco");
		String cor = request.getParameter("txtCor");
		String kmRodado = request.getParameter("numberKmRodado");
		String publicar = request.getParameter("txtPublicar");		
		String descricao = request.getParameter("txtDescricao");
		
		String idVendedor = request.getParameter("txtIdVendedor");
		String idModelo = request.getParameter("txtIdModelo");
		

		System.out.println("Dentro da VH MODELO NOME = " + idVendedor);
	
		Vendedor v = new Vendedor();
		ModeloAutomovel model = new ModeloAutomovel();
		if(kmRodado != null && !kmRodado.trim().equals("")){
			m.setKmRodado(Float.parseFloat(kmRodado));
		}
		
		if(preco != null && !preco.trim().equals("")){
			m.setPreco(Float.parseFloat(preco));
		}
		if(idModelo != null && !idModelo.trim().equals("")){
			 model= new ModeloAutomovel(Integer.parseInt(idModelo));
		}
		if(idVendedor != null && !idVendedor.trim().equals("")){
			 v = new Vendedor(Integer.parseInt(idVendedor));
		}
		m.setModeloAutomovel(model);
		m.setVendedor(v);
		m.setAnoFabricacao(Ano);
		m.setCorExterna(cor);
		m.setVin(vin);
		m.setDescricao(descricao);
		
		

		return m;
	}


	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		RequestDispatcher d=null;
		
		String uri = request.getRequestURI();
		
		String operacao = request.getParameter("operacao");
		
		
		if(resultado.getMsg() == null){
			
			if(operacao == null) {
				resultado.setMsg("Lista de Automoveis!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("listaAutomoveis.jsp"); 
			}else if(operacao.equals("Cadastrar")){
				resultado.setMsg("Automovel cadastrado com sucesso!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("listaAutomoveis.jsp");
				
			}else if(operacao.equals("Consultar")) {
				
				if(uri.equals("/GestaoCar/ConsultarModeloNome")) {
					resultado.setMsg("Modelos!");
					request.getSession().setAttribute("resultado", resultado);
					d= request.getRequestDispatcher("BuscarModelo.jsp");
				}else {
					resultado.setMsg("Lista de modelos de automoveis!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("EditarAutomovel.jsp");
				}
				 
			}else if (operacao.equals("Editar")) {
				resultado.setMsg("Automovel editado com sucesso!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("Resultado.jsp"); 
			}else if (operacao.equals("Excluir")) {
				resultado.setMsg("Modelo excluido com sucesso!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("Resultado.jsp"); 
			}
			
		}else {
			request.getSession().setAttribute("resultado", resultado);
			d= request.getRequestDispatcher("Resultado.jsp"); 
		}
		
		try {
			d.forward(request,response);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void setView(Resultado resultado, ServletConfig config) {
		// TODO Auto-generated method stub
		
	}



}
