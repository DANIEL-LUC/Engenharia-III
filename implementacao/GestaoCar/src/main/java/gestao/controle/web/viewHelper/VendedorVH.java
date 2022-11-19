package gestao.controle.web.viewHelper;


import java.io.IOException;

import gestao.dominio.Cidade;
import gestao.dominio.Endereco;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.Estado;
import gestao.dominio.Vendedor;
import gestao.util.Resultado;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class VendedorVH implements IViewHelper {


	@Override
	public EntidadeDominio getEntidade(HttpServletRequest request) {
		System.out.println("DENTRO DA VIEW HELPER");
		
		String id = request.getParameter("txtId");
		String cpf = request.getParameter("txtCPF");
		String nomeVendedor = request.getParameter("txtNomeVendedor");
		String logradouro = request.getParameter("txtLogradouro");
		String nomeCidade = request.getParameter("txtCidade");
		String nomeEstado = request.getParameter("txtEstado");
		String cep = request.getParameter("txtCep");		
		String numero = request.getParameter("txtNumero");
		String complemento = request.getParameter("txtComplemento");
		String email = request.getParameter("txtEmail");
		String telefone = request.getParameter("txtTelefone");
		
		
		Vendedor v = new Vendedor();

		v.setCpf(cpf);
		v.setEmail(email);
		v.setNome(nomeVendedor);
		v.setTelefone(telefone);
		v.setEndereco(new Endereco());
		v.getEndereco().setCidade(new Cidade(nomeCidade));
		v.getEndereco().getCidade().setEstado(new Estado(nomeEstado));
		v.getEndereco().setCep(cep);
		v.getEndereco().setComplemento(complemento);
		v.getEndereco().setNumero(numero);
				
		System.out.println("VENDEDOR = " + v.getEndereco().getCidade().getEstado().getNome());
		return v;
	}


	@Override
	public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response)
			throws ServletException {
		RequestDispatcher d=null;
		
		String operacao = request.getParameter("operacao");
		
		
		if(resultado.getMsg() == null){
			
			if(operacao == null ) {
				resultado.setMsg("Lista de Vendedores!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("FormConsultarVendedor.jsp"); 
			}else if(operacao.equals("Salvar")){
				resultado.setMsg("Produto cadastrado com sucesso!");
				request.getSession().setAttribute("resultado", resultado);
				d= request.getRequestDispatcher("FormConsultarVendedor.jsp"); 
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

}
