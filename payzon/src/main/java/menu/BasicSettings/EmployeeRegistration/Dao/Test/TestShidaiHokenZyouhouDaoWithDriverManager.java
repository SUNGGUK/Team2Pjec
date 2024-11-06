package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.Dao.shidai_hoken_zyouhouDao;
import menu.BasicSettings.EmployeeRegistration.model.shidai_hoken_zyouhou;

import java.sql.Date;

//-- 8. 4대 보험 정보 테이블 (shidai_hoken_zyouhou)
// shidai_hoken_zyouhou Oracle에 직접 연결해서 자바 콘솔에서 확인하는 코드

public class TestShidaiHokenZyouhouDaoWithDriverManager {

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

            // 3. 테스트할 4대 보험 정보 객체 생성
            System.out.println("4대 보험 정보 객체 생성 중...");
            shidai_hoken_zyouhou newHoken = new shidai_hoken_zyouhou(
                1, // 보험 ID
                1, // 사원 ID
                "건강보험", // 보험 종류
                "ABC123456", // 등록 번호
                Date.valueOf("2024-01-01"), // 취득일
                null // 상실일 (optional)
            );
            System.out.println("4대 보험 정보 객체 생성 완료");

            // 4. DAO를 사용하여 데이터 삽입
            System.out.println("DAO를 사용하여 데이터 삽입 중...");
            shidai_hoken_zyouhouDao dao = new shidai_hoken_zyouhouDao();
            shidai_hoken_zyouhou insertedHoken = dao.insert(conn, newHoken);

            // 5. 삽입 결과 확인
            if (insertedHoken != null) {
                System.out.println("데이터 삽입 성공: " + insertedHoken.getHoken_ID());
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
