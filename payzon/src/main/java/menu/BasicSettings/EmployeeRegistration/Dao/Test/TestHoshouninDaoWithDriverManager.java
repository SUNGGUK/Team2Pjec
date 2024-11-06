package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.Dao.hoshouninDao;
import menu.BasicSettings.EmployeeRegistration.model.hoshounin;

import java.sql.Date;

//-- 17. 보증인 테이블 (hoshounin)--테스트 확인
public class TestHoshouninDaoWithDriverManager {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // 1. JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. 데이터베이스 연결 (DriverManager 사용)
            System.out.println("데이터베이스 연결 시도 중...");
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe", // JDBC URL
                "system", // 사용자 이름
                "1234"    // 비밀번호
            );
            System.out.println("데이터베이스 연결 성공");

            // 3. 테스트할 보증인 정보 객체 생성
            System.out.println("보증인 정보 객체 생성 중...");
            hoshounin newHoshounin = new hoshounin(
                1, // 사원 ID
                "김철수", // 보증인 이름
                "친구", // 관계
                "890123-4567890", // 주민등록번호
                5000000, // 보증 금액
                Date.valueOf("2024-01-15"), // 보증일
                Date.valueOf("2025-01-15"), // 종료일
                "010-9876-5432" // 전화번호
            );
            System.out.println("보증인 정보 객체 생성 완료");

            // 4. DAO를 사용하여 데이터 삽입
            System.out.println("DAO를 사용하여 데이터 삽입 중...");
            hoshouninDao dao = new hoshouninDao();
            hoshounin insertedHoshounin = dao.insert(conn, newHoshounin);

            // 5. 삽입 결과 확인
            if (insertedHoshounin != null) {
                System.out.println("데이터 삽입 성공: " + insertedHoshounin.getHoshounin_mei());
            } else {
                System.out.println("데이터 삽입 실패");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("예외 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 6. 연결 종료
            if (conn != null) {
                try {
                    conn.close();
                    System.out.println("데이터베이스 연결 종료 완료");
                } catch (SQLException e) {
                    System.out.println("데이터베이스 연결 종료 중 오류 발생: " + e.getMessage());
                }
            }
        }
    }
}
