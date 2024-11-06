package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe"; // 데이터베이스 URL
    private static final String DB_USER = "system"; // 하드코딩된 사용자 이름
    private static final String DB_PASSWORD = "1234"; // 하드코딩된 비밀번호

    // 데이터베이스 연결을 반환하는 메서드
    public static Connection getConnection() {
        try {
            // 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");
            
            // 데이터베이스 연결 생성
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC 드라이버를 찾을 수 없습니다: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("데이터베이스 연결 오류: " + e.getMessage());
        }
        return null; // 연결 실패 시 null 반환
    }
}
