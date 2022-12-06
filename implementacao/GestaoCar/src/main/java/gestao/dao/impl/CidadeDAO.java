package gestao.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gestao.dao.AbstractJdbcDAO;
import gestao.dominio.Cidade;
import gestao.dominio.Endereco;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.Estado;
import gestao.dominio.Vendedor;

public class CidadeDAO extends AbstractJdbcDAO {


	protected CidadeDAO(String table, String idTable) {
		super(table, idTable);
		// TODO Auto-generated constructor stub
	}

	public CidadeDAO() {
		super("Cidades", "cid_id");
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		System.out.println("CIDADE DAO = =");
		
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		Cidade cid = (Cidade)entidade;
		Estado est = cid.getEstado();
		EstadoDAO estadoDAO = new EstadoDAO();
		estadoDAO.salvar(est);
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO cidades(cid_nome, cid_est_id) ");
		sql.append(" VALUES (?, ?)");	
		try {
			connection.setAutoCommit(false);
			
					
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, cid.getNome());
			pst.setInt(2, est.getId());
		
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idCid=0;
			if(rs.next())
				idCid = rs.getInt("cid_id");
			System.out.println("ID da cidade = " +idCid);
			cid.setId(idCid);
			
			connection.commit();					
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();	
		}finally{
			if(ctrlTransaction){
				try {
					pst.close();
					if(ctrlTransaction)
						connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
		}
		
	}


	@Override
	public void alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		ResultSet rs =null;
		List<EntidadeDominio> listCidade = new ArrayList();
		Estado estResult = new Estado();
		
		
		String sql = null;
		
		System.out.println("________Cidades DAO --> entidade.getID() = " + entidade.getId());
		if(entidade.getId() != 0) {
			if(entidade.getId() == -1) {
				sql = "SELECT * FROM cidades;";
			}else{
				sql = "SELECT * FROM cidades WHERE cid_id = ";
				sql += entidade.getId() + ";";
				}
		}
		
		System.out.println("________SQL => " + sql);
		
        try{
        	
        	System.out.println("________Dentro do try do CidadeDAO " + sql);
        	pst = connection.prepareStatement(sql);
        	EstadoDAO estDAO = new EstadoDAO();
        	rs = pst.executeQuery();
//        	rs = pst.getResultSet();
        	System.out.println("________ Query executada");
            while(rs.next()){
            	Cidade cidade = new Cidade();
            	Estado est = new Estado();
            	est.setId(rs.getInt("cid_est_id"));
            	estDAO.connection = connection;
            	estDAO.ctrlTransaction = false;
            	estResult = (Estado) estDAO.consultar(est).get(0);	
            	
            	cidade.setId(rs.getInt("cid_id"));
            	cidade.setNome(rs.getString("cid_nome"));
            	cidade.setEstado(estResult);
                
            	listCidade.add(cidade);            
            }
            connection.commit();
            System.out.println("________ Query executada entidade => " + listCidade.get(0).getId());
            return listCidade;
	
        
        }catch (SQLException e) {
//			try {
//				//connection.rollback();
//			} catch (SQLException e1) {
//				e1.printStackTrace();
//			}
//			e.printStackTrace();			
		}finally{
			try {
				//pst.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listCidade;
      }


}
