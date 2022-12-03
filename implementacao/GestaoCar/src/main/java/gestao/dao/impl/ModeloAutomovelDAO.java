package gestao.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import gestao.dao.AbstractJdbcDAO;
import gestao.dominio.Cidade;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.ModeloAutomovel;
import gestao.dominio.Vendedor;

public class ModeloAutomovelDAO extends AbstractJdbcDAO {

	protected ModeloAutomovelDAO(String table, String idTable) {
		super(table, idTable);
		
	}
	public ModeloAutomovelDAO() {
		super("modeloautomoveis", "mod_id");
	}

	
	public void salvar(EntidadeDominio entidade) {
		System.out.println("Dentro do DAO SALVAR MODELO");
		openConnection();
		PreparedStatement pst=null;
		ResultSet rs =null;
		ModeloAutomovel modeloAutomovel = (ModeloAutomovel)entidade;
		
		
		try {
			connection.setAutoCommit(false);
			System.out.println("Deu CERTOOOOOO");
				
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO modeloautomoveis(mod_nome, mod_ano, mod_acentos, mod_portas, mod_preco,");
			sql.append("mod_marca, mod_potencia, mod_cambio, mod_combustivel, mod_km_litro ) VALUES (?,?,?,?,?,?,?,?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, modeloAutomovel.getNome());
			pst.setString(2, modeloAutomovel.getAno_lancamento());
			pst.setInt(3, modeloAutomovel.getAcento());
			pst.setInt(4,modeloAutomovel.getPortas());
			pst.setFloat(5, modeloAutomovel.getMedia_preco());
			pst.setString(6, modeloAutomovel.getMarca().getNome());
			pst.setFloat(7, modeloAutomovel.getEspecificacaoTecnica().getPotenciaCv());
			pst.setString(8, modeloAutomovel.getEspecificacaoTecnica().getCambio());
			pst.setString(9, modeloAutomovel.getEspecificacaoTecnica().getCombustivel());
			pst.setFloat(10, modeloAutomovel.getEspecificacaoTecnica().getKmLitro());
			
			//Timestamp time = new Timestamp(fornecedor.getDtCadastro().getTime());
			//pst.setTimestamp(4, time);
			pst.executeUpdate();
			
			rs = pst.getGeneratedKeys();
			int id=0;
			if(rs.next()) {
				id = rs.getInt("mod_id");
			System.out.println("--------------------------> id " + id);
			}
			modeloAutomovel.setId(id);
						
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

	public void alterar(EntidadeDominio entidade) {

	}

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		
		return null;
	}



}
