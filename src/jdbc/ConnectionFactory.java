package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectionFactory {
	
	private static final String DRIVE = "com.mysql.jdbc.Driver";
//	private static final String URL = "jdbc:mysql://database-poo-av2.cboaqzt9rwj4.us-east-1.rds.amazonaws.com:3306/db_aula_prog_java?useTimezone=true&serverTimezone=UTC"; 
	private static final String URL = "jdbc:mysql://localhost:3306/AulaJava"; 
	private static final String USER = "administrador"; 
	private static final String SENHA = "admin1234"; 
	
	
	public static Connection getConnection() {
        try {
        	
        	// Class.forName(DRIVER); opcional dependendo da versao
        	
            return DriverManager.getConnection(
            		URL, USER, SENHA);
        } catch (SQLException e) {
            throw new RuntimeException("Erro na conexão com o Banco de Dados!",e);
        }
	}


	public static void closeConnection(Connection con, PreparedStatement stmt) {
		// TODO Auto-generated method stub
		
	}


}