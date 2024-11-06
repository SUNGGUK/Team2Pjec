package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.Dao.kyuuyo_shidai_hokenDao;
import menu.BasicSettings.EmployeeRegistration.model.kyuuyo_shidai_hoken;

public class TestKyuuyoShidaiHokenDaoWithDriverManager {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // JDBC 드라이버 로드 및 데이터베이스 연결
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "1234");

            kyuuyo_shidai_hokenDao dao = new kyuuyo_shidai_hokenDao();

            // 테스트 데이터 삽입
            kyuuyo_shidai_hoken testData = new kyuuyo_shidai_hoken(
                1, 'Y', 'Y', 1000, 'N', 500, 'Y', 'Y', 300, 'N', 200, 'N',
                'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y','Y', 2500, 3000,
                2000, 1500, 1200, "은행명", "1234567890"
            );

            int result = dao.insertKyuuyoShidaiHoken(conn, testData);
            System.out.println("Data insertion " + (result > 0 ? "successful." : "failed."));

            // 데이터 조회
            kyuuyo_shidai_hoken retrievedData = dao.getKyuuyoShidaiHoken(conn, 1);
            if (retrievedData != null) {
                System.out.println("Data retrieval successful: ");
                System.out.println("Shain ID: " + retrievedData.shain_ID);
                System.out.println("Kokumin Nenkin: " + retrievedData.kokumin_nenkin);
                // 필요한 필드만 선택해서 출력하거나 전체 데이터 출력
            } else {
                System.out.println("No data found with shain_ID = 1.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 실패: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL 오류 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("데이터베이스 연결 종료 실패: " + e.getMessage());
            }
        }
    }
}
