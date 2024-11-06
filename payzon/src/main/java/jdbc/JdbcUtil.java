package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	
	public static Connection getConnection() throws SQLException{
	       String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 예시: Oracle
	       String user = "system";
	       String password = "1234";
	       return DriverManager.getConnection(url, user, password);
	   }
	
	public static void close(ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException ex) {
		}
		}
	}
		
		public static void close(Statement stmt) {
			if(stmt != null) {
				try {
					stmt.close();
				} catch(SQLException ex) {
			}
		}
		}
		
		public static void close(Connection conn) {
			if(conn != null) {
				try {
					conn.close();
				} catch(SQLException ex) {
			}
		}
		}
		
		public static void rollback(Connection conn) {
			if(conn != null) {
				try {
					conn.rollback();
				} catch(SQLException ex) {
			}
		}
		}
}
