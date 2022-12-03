package gestao.controle.web.viewHelper;

import java.io.IOException;
import java.util.Date;

import gestao.dominio.Cidade;
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

public class ModeloAutomovelVH implements IViewHelper {

	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		System.out.println("DENTRO DA VIEW HELPER ModeloAutomovel");
		String operacao = request.getParameter("operacao");
		
		ModeloAutomovel m = new ModeloAutomovel();
		
		String id = request.getParameter("txtId");
		
		if(operacao != null) {
			if(operacao.equals("Editar") || operacao.equals("Consultar") || operacao.equals("Excluir") ) {
				System.out.println("Dentro do is VH Modelo id = " + id);
				
				m.setId(Integer.parseInt(id));
				return m;
			}
		}else {
			m.setId(-1);
			return m;
		}
		
		String nomeModelo = request.getParameter("txtNomeModelo");
		String Ano = request.getParameter("txtAnoLancamento");
		String preco = request.getParameter("txtPreco");
		String marca = request.getParameter("txtMarca");
		String kmLitro = request.getParameter("numberGastoLitro");
		String potencia = request.getParameter("numberPotencia");		
		String cambio = request.getParameter("txtCambio");
		String combustivel = request.getParameter("txtCombustivel");
		String acentos = request.getParameter("numberAcentos");
		String portas = request.getParameter("numberPortas");
		String tipoAutomovel = request.getParameter("txtTipoAutomovel");
		
		
		
		System.out.println("Dentro da VH MODELO NOME = " + nomeModelo);
	
		
		
		m.setAcento(Integer.parseInt(acentos));
		m.setAnoLancamento(Ano);
		m.setNome(nomeModelo);
		m.setPortas(Integer.parseInt(portas));
		m.setMediaPreco(Float.parseFloat(preco));
		
		Marca mar = new Marca(marca);
		
		EspecificacaoTecnica tecnico = new EspecificacaoTecnica();
		tecnico.setCambio(cambio);
		tecnico.setCombustivel(combustivel);
		tecnico.setKmLitro(Float.parseFloat(kmLitro));
		tecnico.setPotenciaCv(Float.parseFloat(potencia));
		
		TipoAutomovel tipo = new TipoAutomovel(tipoAutomovel);
		
		m.setMarca(mar);
		m.setEspecificacaoTecnica(tecnico);
		m.setTipoAutomovel(tipo);
		

		System.out.println("________ModeloAutomovelVH --> entidade = " + m.getAnoLancamento());
		return m;
	}


	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		RequestDispatcher d=null;
		
		String operacao = request.getParameter("operacao");
		
		
		if(resultado.getMsg() == null){
			
			if(operacao == null) {
				resultado.setMsg("Lista de Modelos de Automoveis!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("FormConsultarModelo.jsp"); 
			}else if(operacao.equals("Cadastrar")){
				resultado.setMsg("Modelo cadastrado com sucesso!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("FormConsultarModelo.jsp"); 
			}else if(operacao.equals("Consultar")) {
				resultado.setMsg("Lista de modelos de automoveis!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("EditarModelo.jsp"); 
			}else if (operacao.equals("Editar")) {
				resultado.setMsg("Vendedor editado com sucesso!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("FormConsultarVendedor.jsp"); 
			}else if (operacao.equals("Excluir")) {
				resultado.setMsg("Vendedor excluido com sucesso!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("Resultado.jsp"); 
			}
			
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
	
	public EntidadeDominio consultar() {
		return null;
	}

}
