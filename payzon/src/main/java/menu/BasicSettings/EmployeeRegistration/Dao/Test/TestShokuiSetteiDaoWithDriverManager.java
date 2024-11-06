package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import menu.BasicSettings.EmployeeRegistration.Dao.shokui_setteiDao;
import menu.BasicSettings.EmployeeRegistration.model.shokui_settei;


//-- 5. 직위 테이블 (shokui_settei) 테스트 확인
public class TestShokuiSetteiDaoWithDriverManager {

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

            // 3. 직위 정보 삽입 테스트
            System.out.println("직위 정보 삽입 테스트 중...");
            shokui_settei newShokui = new shokui_settei(1, "과장");
            shokui_setteiDao dao = new shokui_setteiDao();
            dao.insert(conn, newShokui);
            System.out.println("직위 정보 삽입 완료");

            // 4. 모든 직위 정보 조회 테스트
            System.out.println("모든 직위 정보 조회 테스트 중...");
            List<shokui_settei> shokuiList = dao.getAllShokui(conn);
            for (shokui_settei shokui : shokuiList) {
                System.out.println("사원 ID: " + shokui.getShain_id() + ", 직위명: " + shokui.getShokui_mei());
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
