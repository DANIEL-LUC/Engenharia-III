package gestao.dao.impl;

import java.sql.SQLException;
import java.util.List;

import gestao.dao.AbstractJdbcDAO;
import gestao.dominio.EntidadeDominio;

public class ModeloAutomovelDAO extends AbstractJdbcDAO {

	protected ModeloAutomovelDAO(String table, String idTable) {
		super(table, idTable);
		
	}

	
	public void salvar(EntidadeDominio entidade) {
	
		
	}

	public void alterar(EntidadeDominio entidade) {

	}

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		
		return null;
	}



}
