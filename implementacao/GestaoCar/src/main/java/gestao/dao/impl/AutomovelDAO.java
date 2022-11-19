package gestao.dao.impl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import gestao.dao.AbstractJdbcDAO;
import gestao.dominio.EntidadeDominio;

public class AutomovelDAO extends AbstractJdbcDAO{


	public AutomovelDAO(Connection connection, String table, String idTable) {
		super(connection, table, idTable);
		// TODO Auto-generated constructor stub
	}


	@Override
	public void salvar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		
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
