package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.Dao.taishokuDao;
import menu.BasicSettings.EmployeeRegistration.model.taishoku;

import java.sql.Date;

//-- 18. 퇴직 테이블 (taishoku) --테스트 확인 
public class TestTaishokuDaoWithDriverManager {

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

            // 3. 테스트할 퇴직 정보 객체 생성
            System.out.println("퇴직 정보 객체 생성 중...");
            taishoku newTaishoku = new taishoku(
                1, // 사원 ID
                "퇴직", // 상태
                "정년퇴직", // 퇴직 구분
                Date.valueOf("2024-12-31"), // 퇴직 일자
                "개인적인 이유", // 퇴직 사유
                "example@example.com", // 퇴직 후 연락처
                'Y', // 중간정산 여부
                'Y', // 퇴직정산 여부
                20000000, // 퇴직금
                null // 비고
            );
            System.out.println("퇴직 정보 객체 생성 완료");

            // 4. DAO를 사용하여 데이터 삽입
            System.out.println("DAO를 사용하여 데이터 삽입 중...");
            taishokuDao dao = new taishokuDao();
            taishoku insertedTaishoku = dao.insert(conn, newTaishoku);

            // 5. 삽입 결과 확인
            if (insertedTaishoku != null) {
                System.out.println("데이터 삽입 성공: " + insertedTaishoku.getShain_ID());
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
