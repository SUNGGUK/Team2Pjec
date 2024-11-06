package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.Dao.shikaku_menkyouDao;
import menu.BasicSettings.EmployeeRegistration.model.shikaku_menkyou;

import java.sql.Date;

//-- 12. 자격 면허 테이블 (shikaku_menkyou)
public class TestShikakuMenkyouDaoWithDriverManager {

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

            // 3. 테스트할 자격 면허 정보 객체 생성
            System.out.println("자격 면허 정보 객체 생성 중...");
            shikaku_menkyou newShikaku = new shikaku_menkyou(
                1, // 사원 ID
                "정보처리기사", // 자격증명
                Date.valueOf("2022-05-01"), // 발급일
                "대한민국 자격증 협회", // 발급 기관명
                "123456789", // 자격증 번호
                "이 자격증은 IT 분야에서 유용합니다." // 비고
            );
            System.out.println("자격 면허 정보 객체 생성 완료");

            // 4. DAO를 사용하여 데이터 삽입
            System.out.println("DAO를 사용하여 데이터 삽입 중...");
            shikaku_menkyouDao dao = new shikaku_menkyouDao();
            shikaku_menkyou insertedShikaku = dao.insert(conn, newShikaku);

            // 5. 삽입 결과 확인
            if (insertedShikaku != null) {
                System.out.println("데이터 삽입 성공: " + insertedShikaku.getShikaku_mei());
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
