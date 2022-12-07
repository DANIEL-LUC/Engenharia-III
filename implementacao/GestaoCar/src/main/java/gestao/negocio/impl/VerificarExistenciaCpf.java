package gestao.negocio.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import gestao.dao.impl.VendedorDAO;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.Vendedor;
import gestao.negocio.IStrategy;

public class VerificarExistenciaCpf implements IStrategy {

	public String processar(EntidadeDominio entidade) {
		Vendedor vendedor = (Vendedor)entidade;
		
		List<EntidadeDominio> vendedorResultado = new ArrayList();
		VendedorDAO vendedorDAO = new VendedorDAO();
		try {
			vendedorResultado = vendedorDAO.consultar(vendedor);
			if(vendedorResultado.size() != 0) {
				return null;
			}
			
			return "CPF não encontrado";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
