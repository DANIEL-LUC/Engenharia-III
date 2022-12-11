package gestao.controller.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import gestao.controle.web.command.AbstractCommand;
import gestao.controller.IFachada;
import gestao.dao.IDAO;
import gestao.dao.impl.AutomovelDAO;
import gestao.dao.impl.ModeloAutomovelDAO;
import gestao.dao.impl.VendedorDAO;
import gestao.dominio.Automovel;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.ModeloAutomovel;
import gestao.dominio.Vendedor;
import gestao.negocio.IStrategy;
import gestao.negocio.impl.CompletarClassificacaoSocial;
import gestao.negocio.impl.ValidarCombustivel;
import gestao.negocio.impl.ValidarCondicao;
import gestao.negocio.impl.ValidarCpf;
import gestao.negocio.impl.ValidarDadosAutomovel;
import gestao.negocio.impl.ValidarDadosObrgModelo;
import gestao.negocio.impl.ValidarDadosVendedor;
import gestao.negocio.impl.ValidarData;
import gestao.negocio.impl.ValidarEmail;
import gestao.negocio.impl.ValidarExistenciaAutomovel;
import gestao.negocio.impl.ValidarExistenciaVendedor;
import gestao.negocio.impl.ValidarMarca;
import gestao.negocio.impl.ValidarTipoAutomovel;
import gestao.negocio.impl.ValidarVIN;
import gestao.negocio.impl.VerificarEconomico;
import gestao.negocio.impl.VerificarExistenciaCpf;
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
		AutomovelDAO automovelDAo = new AutomovelDAO();
		
		
		daos.put(ModeloAutomovel.class.getName(), modeloDAO);
		daos.put(Vendedor.class.getName(), vendedorDAO);
		daos.put(Automovel.class.getName(), automovelDAo);
		
		
		// REGRAS MODELO 
		
		ValidarDadosObrgModelo validarModelo = new ValidarDadosObrgModelo();
		CompletarClassificacaoSocial classificacaoSocial = new CompletarClassificacaoSocial();
		ValidarCombustivel validarCombustive = new ValidarCombustivel();
		ValidarTipoAutomovel validarTipo = new ValidarTipoAutomovel();
		ValidarMarca validarMarca = new ValidarMarca();
		VerificarEconomico verificarEconomia = new VerificarEconomico();
	
		List<IStrategy> rnsSalvarModeloAutomovel = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarModeloAutomovel = new ArrayList<IStrategy>();
		
		rnsSalvarModeloAutomovel.add(validarModelo);
		rnsSalvarModeloAutomovel.add(classificacaoSocial);
		rnsSalvarModeloAutomovel.add(validarCombustive);
		rnsSalvarModeloAutomovel.add(validarTipo);
		rnsSalvarModeloAutomovel.add(validarMarca);
		rnsSalvarModeloAutomovel.add(verificarEconomia);		
		
		
		Map<String, List<IStrategy>> regrasModeloAutomovel = new HashMap<String, List<IStrategy>>();

		regrasModeloAutomovel.put("Salvar", rnsSalvarModeloAutomovel);
		
		// |||||||||||| REGRAS VENDEDOR
		ValidarDadosVendedor  validarDados = new ValidarDadosVendedor();
		ValidarCpf validarCPF = new ValidarCpf();
		ValidarEmail validarEmail = new ValidarEmail();
		ValidarExistenciaVendedor existenciaVendedor = new ValidarExistenciaVendedor();
		VerificarExistenciaCpf verificarCpf = new VerificarExistenciaCpf();
		
		
		// VENDEDOR REGRAS SALVAR
		List<IStrategy> rnsSalvarVendedor = new ArrayList<IStrategy>();
		
		rnsSalvarVendedor.add(validarDados);
		rnsSalvarVendedor.add(validarCPF);
		rnsSalvarVendedor.add(validarEmail);
		rnsSalvarVendedor.add(existenciaVendedor);
		
		// VENDEDOR REGRAS CONSULTAR
		
		List<IStrategy> rnsConsultarVendedor = new ArrayList<IStrategy>();
		
		rnsConsultarVendedor.add(verificarCpf);
		
		Map<String, List<IStrategy>> regrasVendedor = new HashMap<String, List<IStrategy>>();
		regrasVendedor.put("Salvar", rnsSalvarVendedor);
		regrasVendedor.put("Consultar", rnsConsultarVendedor);
		
		
		
		// ||||||||  REGRAS AUTOMOVEL
		
		ValidarDadosAutomovel validarDadosAutomovel = new ValidarDadosAutomovel();
		ValidarData validarData = new ValidarData();
		ValidarCondicao validarCondicao = new ValidarCondicao();
		ValidarVIN validarVin = new ValidarVIN();
		ValidarExistenciaAutomovel validarExistenciaVIN = new ValidarExistenciaAutomovel();
		
		List<IStrategy> rnsSalvarAutomovel = new ArrayList<IStrategy>();
		List<IStrategy> rnsConsultarAutomovel = new ArrayList<IStrategy>();
		List<IStrategy> rnsEditarAutomovel = new ArrayList<IStrategy>();
		
		rnsSalvarAutomovel.add(validarDadosAutomovel);
		rnsSalvarAutomovel.add(validarData);
		rnsSalvarAutomovel.add(validarCondicao);
		rnsSalvarAutomovel.add(validarVin);
		rnsSalvarAutomovel.add(validarExistenciaVIN);
		
		rnsEditarAutomovel.add(validarDadosAutomovel);
		rnsEditarAutomovel.add(validarData);
		rnsEditarAutomovel.add(validarCondicao);
		
		
		
		Map<String, List<IStrategy>> regrasAutomovel = new HashMap<String, List<IStrategy>>();
		regrasAutomovel.put("Salvar", rnsSalvarAutomovel);
		regrasAutomovel.put("Editar", rnsEditarAutomovel);
		
		//:::::: ADICIONANDO REGRAS NO MAP
		regras.put(ModeloAutomovel.class.getName(), regrasModeloAutomovel);
		regras.put(Vendedor.class.getName(), regrasVendedor);
		regras.put(Automovel.class.getName(), regrasAutomovel);
	
		
	}
	
	
	public Resultado salvar(EntidadeDominio entidade) {
		resultado = new Resultado();
		String nmClasse = entidade.getClass().getName();	
		
		String msg = executarRegras(entidade, "Salvar");

		
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
		

		String msg = executarRegras(entidade, "Editar");
	
		if(msg == null){
			IDAO dao = daos.get(nmClasse);
			dao.alterar(entidade);
			List<EntidadeDominio> entidades = new ArrayList<EntidadeDominio>();
			entidades.add(0, entidade);
			resultado.setEntidades(entidades);
		}else{
			resultado.setMsg(msg);
					
			
		}
		
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
		
		
		String msg = executarRegras(entidade, "Consultar");
		
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
		
		System.out.println("exevutar regra=== "+nmClasse);
		System.out.println("exevutar regra=== "+nmClasse);
		if(regrasOperacao != null){
			System.out.println("exevutar === "+nmClasse);
			List<IStrategy> regras = regrasOperacao.get(operacao);
			
			if(regras != null){
				System.out.println("regrasssssssssss === ");
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
