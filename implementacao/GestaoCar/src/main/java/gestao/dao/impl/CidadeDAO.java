package gestao.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import gestao.dao.AbstractJdbcDAO;
import gestao.dominio.Cidade;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.Estado;

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
		// TODO Auto-generated method stub
		return null;
	}

}
