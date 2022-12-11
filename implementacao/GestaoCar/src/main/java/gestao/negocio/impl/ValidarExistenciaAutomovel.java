package gestao.negocio.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gestao.dao.impl.AutomovelDAO;
import gestao.dao.impl.VendedorDAO;
import gestao.dominio.Automovel;
import gestao.dominio.EntidadeDominio;

import gestao.negocio.IStrategy;

public class ValidarExistenciaAutomovel implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Automovel automovel = (Automovel)entidade;
		
		List<EntidadeDominio> automovelResultado = new ArrayList();
		AutomovelDAO automovelDAO = new AutomovelDAO();
		try {
			automovelResultado = automovelDAO.consultar(automovel);
			if(automovelResultado.size() != 0) {
				automovel = (Automovel) automovelResultado.get(0);
				
				return "VIN já cadastrado";
			
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
