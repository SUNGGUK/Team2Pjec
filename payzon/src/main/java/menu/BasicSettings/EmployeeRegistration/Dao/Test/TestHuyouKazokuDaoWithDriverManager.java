package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.Dao.huyou_kazokuDao;
import menu.BasicSettings.EmployeeRegistration.model.huyou_kazoku;

//-- 9. 부양 가족 테이블 (huyou_kazoku)-- 테스트 성공
public class TestHuyouKazokuDaoWithDriverManager {

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

            // 3. 테스트할 부양 가족 객체 생성
            System.out.println("부양 가족 정보 객체 생성 중...");
            huyou_kazoku newKazoku = new huyou_kazoku(
                1, // 사원 ID
                "홍길동", // 가족 이름
                "배우자", // 관계
                "123456-1234567", // 주민등록번호
                'Y', // 장애 여부
                'Y', // 세금 공제 여부
                'Y', // 건강 보험 여부
                'Y', // 동거 여부
                'N'  // 20세 이하 자녀 여부
            );
            System.out.println("부양 가족 정보 객체 생성 완료");

            // 4. DAO를 사용하여 데이터 삽입
            System.out.println("DAO를 사용하여 데이터 삽입 중...");
            huyou_kazokuDao dao = new huyou_kazokuDao();
            huyou_kazoku insertedKazoku = dao.insert(conn, newKazoku);

            // 5. 삽입 결과 확인
            if (insertedKazoku != null) {
                System.out.println("데이터 삽입 성공: " + insertedKazoku.getNamae());
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
