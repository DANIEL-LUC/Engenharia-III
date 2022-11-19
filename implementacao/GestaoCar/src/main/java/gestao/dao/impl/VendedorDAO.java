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

import gestao.dominio.Vendedor;



public class VendedorDAO extends AbstractJdbcDAO {

	protected VendedorDAO(String table, String idTable) {
		super(table, idTable);
		// TODO Auto-generated constructor stub
	}

	public VendedorDAO() {
		super("VENDEDORES", "VEN_ID");
	}

	@Override
	public void salvar(EntidadeDominio entidade) {
		System.out.println("Dentro do DAO SALVAR");
		openConnection();
		PreparedStatement pst=null;
		ResultSet rs =null;
		Vendedor vendedor = (Vendedor)entidade;
		Cidade cid = vendedor.getEndereco().getCidade();
		
		try {
			connection.setAutoCommit(false);
			System.out.println("Deu CERTOOOOOO");
			CidadeDAO cidDAO = new CidadeDAO();
			cidDAO.connection = connection;
			cidDAO.ctrlTransaction = false;
			cidDAO.salvar(cid);			
			
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO vendedores(ven_cpf, ven_nome, ven_email, ");
			sql.append("ven_telefone, ven_logradouro, ven_cep, ven_numero, ven_cid_id) VALUES (?,?,?,?,?,?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, vendedor.getCpf());
			pst.setString(2, vendedor.getNome());
			pst.setString(3, vendedor.getEmail());
			pst.setString(4, vendedor.getTelefone());
			pst.setString(5, vendedor.getEndereco().getLogradouro());
			pst.setString(6, vendedor.getEndereco().getCep());
			pst.setString(7, vendedor.getEndereco().getNumero());
			pst.setInt(8, cid.getId());
			
			//Timestamp time = new Timestamp(fornecedor.getDtCadastro().getTime());
			//pst.setTimestamp(4, time);
			pst.executeUpdate();
			
			rs = pst.getGeneratedKeys();
			int id=0;
			if(rs.next()) {
				id = rs.getInt("ven_id");
			System.out.println("--------------------------> id " + id);
			}
			vendedor.setId(id);
	
			
						
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
		
		
	}

	@Override
	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst=null;
		ResultSet rs =null;
		List<EntidadeDominio> listVendedores = new ArrayList();
		
		String sql = null;
		if(entidade == null) {
			sql = "SELECT * FROM vendedores;";
		}
		sql = "SELECT * FROM vendedores;";
        try{
        	connection.setAutoCommit(false);
        	System.out.println("________Dentro do try do VendedorDAO " + sql);
        	pst = connection.prepareStatement(sql);
        	
        	rs = pst.executeQuery();
//        	rs = pst.getResultSet();
        	System.out.println("________ Query executada");
            while(rs.next()){
            	Vendedor vendedor = new Vendedor();
            	vendedor.setId(rs.getInt("ven_id"));
            	vendedor.setCpf(rs.getString("ven_cpf"));
            	vendedor.setNome(rs.getString("ven_nome"));
            	vendedor.setEmail(rs.getString("ven_email"));
            	vendedor.setTelefone(rs.getString("ven_telefone"));
                
            	listVendedores.add(vendedor);            
            }
            connection.commit();
            return listVendedores;
	
        
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
		return listVendedores;
      }

}
