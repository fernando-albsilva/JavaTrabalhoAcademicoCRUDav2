package jdbc;

import java.sql.Connection;

public class TesteBD {

	public static void main(String[] args) {

		Connection con = ConnectionFactory.getConnection();
        
 		System.out.println("Conexão Ok");

	}

}
