package dbUnit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class jdbcUtil {

	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			}catch (SQLException e) {
				// TODO: handle exception
				System.out.println("Connection Close Error");
				e.printStackTrace();
			}
		}
	}
	
	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {
			try {
				pstmt.close();
			}catch (SQLException e) {
				// TODO: handle exception
				System.out.println("PreparedStatement Close Error");
				e.printStackTrace();
			}
		}
	}
	
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			}catch (SQLException e) {
				// TODO: handle exception
				System.out.println("ResultSet Close Error");
				e.printStackTrace();
			}
		}
	}
	
	
}
