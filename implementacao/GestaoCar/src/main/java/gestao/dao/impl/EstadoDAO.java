package gestao.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gestao.dao.AbstractJdbcDAO;
import gestao.dominio.Cidade;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.Estado;

public class EstadoDAO extends AbstractJdbcDAO {


	protected EstadoDAO(String table, String idTable) {
		super(table, idTable);
		// TODO Auto-generated constructor stub
	}



	public EstadoDAO() {
		super("estados", "id_estados");
	}



	@Override
	public void salvar(EntidadeDominio entidade) {
		
		System.out.println("SALVAR Estado");
		
		if(connection == null){
			openConnection();
		}
		PreparedStatement pst=null;
		Estado est = (Estado)entidade;


		
		StringBuilder sql = new StringBuilder();
		
		sql.append("INSERT INTO Estados(est_nome)");
		sql.append(" VALUES (?)");	
		try {
			connection.setAutoCommit(false);
			
					
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, est.getNome());
		
			pst.executeUpdate();		
					
			ResultSet rs = pst.getGeneratedKeys();
			int idEst=0;
			if(rs.next())
				idEst = rs.getInt(1);
			est.setId(idEst);
			
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
		List<EntidadeDominio> listEstado = new ArrayList();
		
		String sql = null;
		
		System.out.println("________Estados DAO --> entidade.getID() = " + entidade.getId());
		if(entidade.getId() != 0) {
			if(entidade.getId() == -1) {
				sql = "SELECT * FROM estados;";
			}else{
				sql = "SELECT * FROM estados WHERE est_id = ";
				sql += entidade.getId() + ";";
				}
		}
		
		System.out.println("________SQL => " + sql);
		
        try{
        	
        	System.out.println("________Dentro do try do EstadoDAO " + sql);
        	pst = connection.prepareStatement(sql);
        	EstadoDAO estDAO = new EstadoDAO();
        	rs = pst.executeQuery();
//        	rs = pst.getResultSet();
        	System.out.println("________ Query executada");
            while(rs.next()){
            	
            	Estado estado = new Estado();
            	
            	
            	estado.setId(rs.getInt("est_id"));
            	estado.setNome(rs.getString("est_nome"));
                
            	listEstado.add(estado);            
            }
            connection.commit();
            System.out.println("________ Query executada entidade => " + listEstado.get(0).getId());
            return listEstado;
	
        
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
		return listEstado;
      }

}
