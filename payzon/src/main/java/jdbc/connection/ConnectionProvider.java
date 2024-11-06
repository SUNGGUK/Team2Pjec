package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	public static Connection getConnection() throws SQLException {
		/*
		 * return DriverManager.getConnection( "jdbc:apache:commons:dbcp:payzon");
		 */
			String jdbcUrl = "jdbc:oracle:thin:@//localhost:1521/xe"; // Oracle DB URL
	        String dbUser = "system"; // DB 사용자명
	        String dbPass = "1234";   // DB 비밀번호
	        
	        return DriverManager.getConnection(jdbcUrl, dbUser, dbPass);
	}
}
