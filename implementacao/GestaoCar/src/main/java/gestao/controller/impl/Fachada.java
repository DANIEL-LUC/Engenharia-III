package gestao.controller.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gestao.controle.web.command.AbstractCommand;
import gestao.controller.IFachada;
import gestao.dao.IDAO;
import gestao.dao.impl.ModeloAutomovelDAO;
import gestao.dao.impl.VendedorDAO;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.ModeloAutomovel;
import gestao.dominio.Vendedor;
import gestao.negocio.IStrategy;
import gestao.negocio.impl.ValidarDadosObrgModelo;
import gestao.util.Resultado;

public class Fachada implements IFachada {

	private AbstractCommand abstractCommand;

	
	private Map<String, IDAO> daos;

	private Map<String, Map<String, List<IStrategy>>> regras;
	
	private Resultado resultado;
	
	
	
	public Fachada(){

		daos = new HashMap<String, IDAO>();

		regras = new HashMap<String, Map<String, List<IStrategy>>>();
		
		VendedorDAO vendedorDAO = new VendedorDAO();
		ModeloAutomovelDAO modeloDAO = new ModeloAutomovelDAO();
		
		
		daos.put(ModeloAutomovel.class.getName(), modeloDAO);
		daos.put(Vendedor.class.getName(), vendedorDAO);
		
		
		
//		ValidadorDadosObrigatoriosFornecedor vrDadosObrigatoriosFornecedor = new ValidadorDadosObrigatoriosFornecedor();
//		ValidadorCnpj vCnpj = new ValidadorCnpj();
//		ComplementarDtCadastro cDtCadastro = new ComplementarDtCadastro();
//		ValidadorCpf vCpf = new ValidadorCpf();
//		ValidadorQtdProduto vQtd = new ValidadorQtdProduto();
		
		ValidarDadosObrgModelo validarModelo = new ValidarDadosObrgModelo();
//		
	
		List<IStrategy> rnsSalvarModeloAutomovel = new ArrayList<IStrategy>();
		/* Adicionando as regras a serem utilizadas na operação salvar do fornecedor*/
		rnsSalvarModeloAutomovel.add(validarModelo);
		
		
//		rnsSalvarFornecedor.add(vrDadosObrigatoriosFornecedor);
//		rnsSalvarFornecedor.add(vCnpj);
//		rnsSalvarFornecedor.add(cDtCadastro);
		
		
		Map<String, List<IStrategy>> regrasModeloAutomovel = new HashMap<String, List<IStrategy>>();

		regrasModeloAutomovel.put("Salvar", rnsSalvarModeloAutomovel);	
		
		
		regras.put(ModeloAutomovel.class.getName(), regrasModeloAutomovel);
		
	
		
	}
	
	
	public Resultado salvar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "Salvar");
		
//		IDAO dao = daos.get(nmClasse);
//		dao.salvar(entidade);
//		List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
//		entidades.add(0, entidade);
//		resultado.setEntidades(entidades);
//		
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			dao.salvar(entidade);
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
			entidades.add(0, entidade);
			resultado.setEntidades(entidades);
		}else{
			resultado.setMsg(msg);
					
		}
		
		return resultado;
	}


	public Resultado editar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		
		IDAO dao = daos.get(nmClasse);
		dao.alterar(entidade);
		List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
		entidades.add(0, entidade);
		resultado.setEntidades(entidades);
		
		
		
		//String msg = executarRegras(entidade, "Editar");
	
//		if(msg == null){
//			IDAO dao = daos.get(nmClasse);
//			dao.alterar(entidade);
//			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
//			entidades.add(0, entidade);
//			resultado.setEntidades(entidades);
//		}else{
//			resultado.setMsg(msg);
//					
//			
//		}
		
		return resultado;

	}

	public Resultado excluir(EntidadeDominio entidade) {
		System.out.println("FACHADA EXCLUIR");
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "Excluir");
		
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			try {
				dao.excluir(entidade);
				List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
				entidades.add(entidade);
				resultado.setEntidades(entidades);
			} catch (Exception e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar o registro!");
				System.out.println("CATCH FACHADA EXCLUIR");
				
			}
		}else{
			resultado.setMsg(msg);
					
			
		}
		
		return resultado;

	}

	public Resultado consultar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		
		String msg = executarRegras(entidade, "EXCLUIR");
		
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			System.out.println("Dentro do consultar fachada /n Entidade => " + dao);
			try {
				
				resultado.setEntidades(dao.consultar(entidade));
			} catch (SQLException e) {
				e.printStackTrace();
				resultado.setMsg("Não foi possível realizar a consulta!");
				
			}
		}else{
			resultado.setMsg(msg);
			
		}
		
		return resultado;

	}

	public Resultado visualizar(EntidadeDominio entidade) {
		
		return null;
	}
	
	
	
	private String executarRegras(EntidadeDominio entidade, String operacao){
		String nmClasse = entidade.getClass().getName();		
		StringBuilder msg = new StringBuilder();
		
		Map<String, List<IStrategy>> regrasOperacao = regras.get(nmClasse);
		
		
		if(regrasOperacao != null){
			List<IStrategy> regras = regrasOperacao.get(operacao);
			
			if(regras != null){
				for(IStrategy s: regras){			
					String m = s.processar(entidade);			
					
					if(m != null){
						msg.append(m);
						msg.append("\n");
					}			
				}	
			}			
			
		}
		
		if(msg.length()>0)
			return msg.toString();
		else
			return null;
	}
	
	

}
