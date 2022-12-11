package gestao.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import gestao.dao.AbstractJdbcDAO;
import gestao.dominio.Cidade;
import gestao.dominio.ClassificacaoSocial;
import gestao.dominio.Endereco;
import gestao.dominio.EntidadeDominio;
import gestao.dominio.EspecificacaoTecnica;
import gestao.dominio.ModeloAutomovel;
import gestao.dominio.TipoAutomovel;
import gestao.dominio.Vendedor;
import gestao.dominio.Marca;

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
		
		System.out.println("______________________________>> classificação "+ modeloAutomovel.getClassifacaoSocial().getClassificao());
		try {
			connection.setAutoCommit(false);
			System.out.println("Deu CERTOOOOOO");
				
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO modeloautomoveis(mod_nome, mod_ano, mod_acentos, mod_portas, mod_preco,");
			sql.append("mod_marca, mod_potencia, mod_cambio, mod_combustivel, mod_km_litro, mod_tipo, mod_class_social, mod_economico ) "
					+ "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");		
					
			pst = connection.prepareStatement(sql.toString(), 
					Statement.RETURN_GENERATED_KEYS);
			
			pst.setString(1, modeloAutomovel.getNome());
			pst.setString(2, modeloAutomovel.getAnoLancamento());
			pst.setInt(3, modeloAutomovel.getAcento());
			pst.setInt(4,modeloAutomovel.getPortas());
			pst.setFloat(5, modeloAutomovel.getMediaPreco());
			pst.setString(6, modeloAutomovel.getMarca().getNome());
			pst.setFloat(7, modeloAutomovel.getEspecificacaoTecnica().getPotenciaCv());
			pst.setString(8, modeloAutomovel.getEspecificacaoTecnica().getCambio());
			pst.setString(9, modeloAutomovel.getEspecificacaoTecnica().getCombustivel());
			pst.setFloat(10, modeloAutomovel.getEspecificacaoTecnica().getKmLitro());
			pst.setString(11, modeloAutomovel.getTipoAutomovel().getTipo());
			pst.setString(12, modeloAutomovel.getClassifacaoSocial().getClassificao());
			pst.setBoolean(13, modeloAutomovel.isEconomico());
			
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
		System.out.println("Dentro do DAO ALTERAR MODELO");
		openConnection();
		PreparedStatement pst=null;
		ResultSet rs =null;
		ModeloAutomovel modeloAutomovel = (ModeloAutomovel)entidade;
		
		
		try {
			connection.setAutoCommit(false);
			System.out.println("Deu CERTOOOOOO");
						
			
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE modeloautomoveis SET mod_nome=?, mod_ano=?, mod_acentos=?, ");
			sql.append("mod_portas=?, mod_preco=?, mod_marca=?, mod_potencia=?, mod_cambio=?, "
					+ "mod_combustivel=?, mod_km_litro=? , mod_tipo=? WHERE mod_id=?");		
					
			pst = connection.prepareStatement(sql.toString());
			
			pst.setString(1, modeloAutomovel.getNome());
			pst.setString(2, modeloAutomovel.getAnoLancamento());
			pst.setInt(3, modeloAutomovel.getAcento());
			pst.setInt(4,modeloAutomovel.getPortas());
			pst.setFloat(5, modeloAutomovel.getMediaPreco());
			pst.setString(6, modeloAutomovel.getMarca().getNome());
			pst.setFloat(7, modeloAutomovel.getEspecificacaoTecnica().getPotenciaCv());
			pst.setString(8, modeloAutomovel.getEspecificacaoTecnica().getCambio());
			pst.setString(9, modeloAutomovel.getEspecificacaoTecnica().getCombustivel());
			pst.setFloat(10, modeloAutomovel.getEspecificacaoTecnica().getKmLitro());
			pst.setString(11, modeloAutomovel.getTipoAutomovel().getTipo());
			pst.setInt(12, modeloAutomovel.getId());
			
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

	public List<EntidadeDominio> consultar(EntidadeDominio entidade) throws SQLException {
		openConnection();
		PreparedStatement pst=null;
		ResultSet rs =null;
		List<EntidadeDominio> listModelo = new ArrayList();
		
		String sql = null;
		
		System.out.println("Modelos DAO --> entidade.getID() = " + entidade.getId());
		if(entidade.getId() != 0) {
			if(entidade.getId() == -1) {
				sql = "SELECT * FROM modeloautomoveis;";
			}else{
				sql = "SELECT * FROM modeloautomoveis WHERE mod_id = ";
				sql += entidade.getId() + ";";
				}
		}
		
		System.out.println("________SQL => " + sql);
		
        try{
        	connection.setAutoCommit(false);
        	System.out.println("________Dentro do try do modeloDAO " + sql);
        	pst = connection.prepareStatement(sql);
        	CidadeDAO cidDAO = new CidadeDAO();
        	rs = pst.executeQuery();
//        	rs = pst.getResultSet();
        	System.out.println("________ Query executada");
            while(rs.next()){
            	ModeloAutomovel modelo = new ModeloAutomovel();
            	Marca marca = new Marca(rs.getString("mod_marca"));
            	EspecificacaoTecnica tecnica = new EspecificacaoTecnica();
            	TipoAutomovel tipo = new TipoAutomovel(rs.getString("mod_tipo"));
            	ClassificacaoSocial social = new ClassificacaoSocial(rs.getString("mod_class_social"));
            
            	
            	modelo.setId(rs.getInt("mod_id"));
            	modelo.setNome(rs.getString("mod_nome"));
            	modelo.setAnoLancamento(rs.getString("mod_ano"));
            	modelo.setAcento(rs.getInt("mod_acentos"));
            	modelo.setPortas(rs.getInt("mod_portas"));
            	modelo.setMediaPreco(rs.getFloat("mod_preco"));
            	modelo.setEconomico(rs.getBoolean("mod_economico"));
            	
            	tecnica.setCambio(rs.getString("mod_cambio"));
            	tecnica.setCombustivel(rs.getString("mod_combustivel"));
            	tecnica.setKmLitro(rs.getFloat("mod_km_litro"));
            	tecnica.setPotenciaCv(rs.getFloat("mod_potencia"));
            	
            	
            	modelo.setTipoAutomovel(tipo);
            	modelo.setEspecificacaoTecnica(tecnica);
            	modelo.setMarca(marca);
            	modelo.setClassifacaoSocial(social);
            	
            	
         
                
            	listModelo.add(modelo);            
            }
            connection.commit();
            System.out.println("________ Query executada entidade => " + listModelo.get(0).getId());
            return listModelo;
	
        
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
		return listModelo;
      }



}
