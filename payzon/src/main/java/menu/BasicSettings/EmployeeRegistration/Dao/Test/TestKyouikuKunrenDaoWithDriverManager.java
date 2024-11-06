package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.Dao.kyuuyo_shidai_hokenDao;
import menu.BasicSettings.EmployeeRegistration.model.kyuuyo_shidai_hoken;

//-- 7. 급여 및 4대 보험 테이블 (kyuuya_shidai_hoken)--테스트 완료
public class TestKyouikuKunrenDaoWithDriverManager {

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // 1. JDBC 드라이버 로드
            Class.forName("oracle.jdbc.driver.OracleDriver");

            // 2. 데이터베이스 연결
            conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@localhost:1521:xe",
                "system",
                "1234"
            );

            // 3. 테스트 데이터 생성
            kyuuyo_shidai_hoken testData = new kyuuyo_shidai_hoken(
                1, 'Y', 'Y', 1000, 'N', 500, 'Y', 'Y', 300, 'N', 200, 'N', 
                'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'N', 'Y', 'Y', 2500, 3000, 
                2000, 1500, 1200, "은행명", "1234567890"
            );

            // 4. DAO 생성 및 데이터 삽입 테스트
            kyuuyo_shidai_hokenDao dao = new kyuuyo_shidai_hokenDao();
            int insertResult = dao.insertKyuuyoShidaiHoken(conn, testData);
            System.out.println("Data Insertion Result: " + (insertResult > 0 ? "Success" : "Failed"));

            // 5. 데이터 조회 테스트
            kyuuyo_shidai_hoken retrievedData = dao.getKyuuyoShidaiHoken(conn, 1);
            if (retrievedData != null) {
                System.out.println("Data Retrieved: " + retrievedData.getGinkou_mei());
            } else {
                System.out.println("Data Retrieval Failed.");
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC 드라이버 로드 실패: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("SQL 오류 발생: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 데이터베이스 연결 종료
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
