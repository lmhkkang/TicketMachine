package dbUnit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionProvider {
	
	public static Connection getConnection() {
		Connection conn=null;
		try {
			String url ="jdbc:oracle:thin:@192.168.12.20:1521:xe";
			String id = "ticketmachine";
			String pass = "1234";
			
			conn = DriverManager.getConnection(url,id,pass);
			
		} catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Connection Error");
			e.printStackTrace();
		}
		
		return conn;
	}

}
