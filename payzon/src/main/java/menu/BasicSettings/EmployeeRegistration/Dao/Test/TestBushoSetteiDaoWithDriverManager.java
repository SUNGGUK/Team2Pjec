package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import menu.BasicSettings.EmployeeRegistration.Dao.busho_setteiDao;
import menu.BasicSettings.EmployeeRegistration.model.busho_settei;

//-- 4. 부서 테이블 (busho_settei)--테스트 완료
public class TestBushoSetteiDaoWithDriverManager {

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

            // 3. 부서 정보 삽입 테스트
            System.out.println("부서 정보 삽입 테스트 중...");
            busho_settei newBusho = new busho_settei(1, "기획팀");
            busho_setteiDao dao = new busho_setteiDao();
            dao.insert(conn, newBusho);
            System.out.println("부서 정보 삽입 완료");

            // 4. 모든 부서 정보 조회 테스트
            System.out.println("모든 부서 정보 조회 테스트 중...");
            List<busho_settei> bushoList = dao.getAllBusho(conn);
            for (busho_settei busho : bushoList) {
                System.out.println("사원 ID: " + busho.getShain_id() + ", 부서명: " + busho.getBusho_mei());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버를 찾을 수 없습니다: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("예외 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 5. 연결 종료
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
