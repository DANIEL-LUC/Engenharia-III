
package gestao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.postgresql.Driver;

public class Conexao {
	
	 private static final String DRIVER = "org.postgresql.Driver";
	    private static final String URL = "jdbc:postgresql://localhost:5432/gestaoCar";
	    private static final String USER = "postgres";
	    private static final String PASS = "123";
	    
	    public static Connection getConnection(){
	        try {
	            Class.forName(DRIVER);
	            return DriverManager.getConnection(URL, USER, PASS);
	            
	        } catch (ClassNotFoundException ex) {
	            System.out.println("Não foi possível acessar a classe de Conexão.\nErro: " + ex.getMessage());
	            return null;
	        } catch (SQLException ex) {
	            System.out.println("Não foi possível acessar o banco de dados.\nErro: " + ex.getMessage());
	            return null;
	        }
	    }
//	public static Connection getConnectionPostgres() throws ClassNotFoundException, SQLException {
//		driver = "org.postgresql.Driver";
//		url = "jdbc:postgresql://localhost:5432/gestaoCar";
//		user = "postgres";
//		password = "123";
//		return getConnection();
//
//	}
//
//	public static Connection getConnectionH2() throws ClassNotFoundException, SQLException {
//		driver = "org.h2.Driver";
//		url = "jdbc:h2:~/test";	
//		user = "sa";
//		password = "";
//		return getConnection();
//
//	}

	public static Connection getConnectionPostgres() throws ClassNotFoundException, SQLException {
		System.out.println("Dentro da conex�o");
		
		Class.forName("org.postgresql.Driver");
		Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/gestaoCar"
				,"postgres", "123");
		
		System.out.println("Dentro da conex�o 5555555555555555555555555555555555555");
		return conn;

	}

}
