package gestao.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gestao.dao.AbstractJdbcDAO;
import gestao.dominio.Automovel;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.EspecificacaoTecnica;
import gestao.dominio.Marca;
import gestao.dominio.ModeloAutomovel;
import gestao.dominio.TipoAutomovel;
import gestao.dominio.Vendedor;

public class AutomovelDAO extends AbstractJdbcDAO{

	protected AutomovelDAO(String table, String idTable) {
		super(table, idTable);
		
	}
	public AutomovelDAO() {
		super("automoveis", "aut_id");
	} 
	
	public AutomovelDAO(Connection connection, String table, String idTable) {
		super(connection, table, idTable);
		// TODO Auto-generated constructor stub
	}


	public void salvar(EntidadeDominio entidade) {
		System.out.println("Dentro do DAO SALVAR AUTOMOVEL");
		openConnection();
		PreparedStatement pst=null;
		ResultSet rs =null;
		Automovel automovel = (Automovel)entidade;
		
		System.out.println("______________________________>> Condição "+ automovel.getCondicao());
		try {
			connection.setAutoCommit(false);
			System.out.println("Deu CERTOOOOOO");
				
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO automoveis(aut_vin, aut_ano, aut_preco, aut_cor, aut_km_rodado,");
			sql.append("aut_publicar, aut_ven_id, aut_mod_id, aut_descricao, aut_condicao ) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, automovel.getVin());
			pst.setString(2, automovel.getAnoFabricacao());
			pst.setFloat(3, automovel.getPreco());
			pst.setString(4,automovel.getCorExterna());
			pst.setFloat(5, automovel.getKmRodado());
			pst.setString(6, automovel.getPublicado());
			pst.setInt(7, automovel.getVendedor().getId());
			pst.setInt(8, automovel.getModeloAutomovel().getId());
			pst.setString(9, automovel.getDescricao());
			pst.setString(10, automovel.getCondicao());
			
			//Timestamp time = new Timestamp(fornecedor.getDtCadastro().getTime());
			//pst.setTimestamp(4, time);
			pst.executeUpdate();
			
			rs = pst.getGeneratedKeys();
			int id=0;
			if(rs.next()) {
				id = rs.getInt("aut_id");
			System.out.println("--------------------------> id " + id);
			}
			automovel.setId(id);
						
			connection.commit();		
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				//pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
	}


	@Override
	public void alterar(EntidadeDominio entidade) {
		System.out.println("Dentro do DAO ALTERAR MODELO");
		openConnection();
		PreparedStatement pst=null;
		ResultSet rs =null;
		Automovel automovel = (Automovel)entidade;
		
		
		try {
			connection.setAutoCommit(false);
			System.out.println("Deu CERTOOOOOO");
						
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE automoveis SET aut_vin=?, aut_ano=?, aut_preco=?, ");
			sql.append("aut_cor=?, aut_km_rodado=?, aut_ven_id=?, aut_mod_id=?, aut_condicao=? WHERE aut_id=?");		
					
			pst = connection.prepareStatement(sql.toString());
			
			pst.setString(1, automovel.getVin());
			pst.setString(2, automovel.getAnoFabricacao());
			pst.setFloat(3, automovel.getPreco());
			pst.setString(4,automovel.getCorExterna());
			pst.setFloat(5, automovel.getKmRodado());
			pst.setInt(6, automovel.getVendedor().getId());
			pst.setFloat(7, automovel.getModeloAutomovel().getId());
			pst.setString(8,automovel.getCondicao());
			pst.setFloat(9, automovel.getId());
			
			//Timestamp time = new Timestamp(fornecedor.getDtCadastro().getTime());
			//pst.setTimestamp(4, time);
			pst.executeUpdate();
						
			connection.commit();		
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				//pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}	
		
	}


	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst=null;
		ResultSet rs =null;
		List<EntidadeDominio> listAutomoveis = new ArrayList();
		Automovel automovelResult = (Automovel)entidade;
		
		StringBuilder sql = new StringBuilder();
		
		System.out.println("Automoveis DAO --> entidade.getID() = " + entidade.getId());
		if(entidade.getId() != 0) {
			if(entidade.getId() == -1) {
				sql.append("SELECT * FROM automoveis;");
				pst = connection.prepareStatement(sql.toString());
			}else{
				sql.append("SELECT * FROM automoveis WHERE aut_id = ");
				pst = connection.prepareStatement(sql.toString());
				pst.setInt(1, automovelResult.getId());
				}
		}
		if(automovelResult.getVin() != null) {
			sql.append("SELECT * FROM automoveis WHERE aut_vin=?");		
			
			pst = connection.prepareStatement(sql.toString());
			
			pst.setString(1, automovelResult.getVin());
		}
		
		System.out.println("________SQL => " + automovelResult.getVin());
		
        try{
        	connection.setAutoCommit(false);
        	System.out.println("________Dentro do try do modeloDAO " + sql);
        	
        	ModeloAutomovelDAO modDAO = new ModeloAutomovelDAO();
        	VendedorDAO venDAO = new VendedorDAO();
        	
        	List<EntidadeDominio> listVendedores = new ArrayList();
        	List<EntidadeDominio> listModelos = new ArrayList();
        	
        	rs = pst.executeQuery();
//        	rs = pst.getResultSet();
        	System.out.println("________ Query executada");
            while(rs.next()){
            	Automovel automovel = new Automovel();
            	Vendedor vendedor = new Vendedor(rs.getInt("aut_ven_id"));
            	ModeloAutomovel modelo = new ModeloAutomovel(rs.getInt("aut_mod_id"));
            	
            	listVendedores = venDAO.consultar(vendedor);
            	listModelos = modDAO.consultar(modelo);
            	
            	automovel.setModeloAutomovel((ModeloAutomovel) listModelos.get(0));
            	
            	System.out.println("--------------"+listVendedores.get(0).getId());
            	automovel.setVendedor((Vendedor) listVendedores.get(0));
            	System.out.println("--------------"+automovel.getVendedor().getEmail());
            	System.out.println("-------------- MODELOOOO "+automovel.getModeloAutomovel().getNome());
            	
            	automovel.setId(rs.getInt("aut_id"));
            	automovel.setAnoFabricacao(rs.getString("aut_ano"));
            	automovel.setCorExterna(rs.getString("aut_cor"));
            	automovel.setDescricao(rs.getString("aut_descricao"));
            	automovel.setKmRodado(rs.getFloat("aut_km_rodado"));
            	automovel.setPreco(rs.getFloat("aut_preco"));
            	automovel.setVin(rs.getString("aut_vin"));
            	automovel.setCondicao(rs.getString("aut_condicao"));
            	           	
         
                
            	listAutomoveis.add(automovel);            
            }
            connection.commit();
            
            return listAutomoveis;
	
        
        }catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();			
		}finally{
			try {
				//pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listAutomoveis;
      }


}
