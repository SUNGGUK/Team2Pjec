package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.Dao.hatsureiDao;
import menu.BasicSettings.EmployeeRegistration.model.hatsurei;

import java.sql.Date;

//-- 16. 발령 테이블 (hatsurei)--테스트 확인
public class TestHatsureiDaoWithDriverManager {

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

            // 3. 테스트할 발령 정보 객체 생성
            System.out.println("발령 정보 객체 생성 중...");
            hatsurei newHatsurei = new hatsurei(
                1, // 사원 ID
                Date.valueOf("2024-03-01"), // 발령일
                "영업부", // 부서
                "과장", // 직위 명칭
                "영업 관리", // 직무 명칭
                "추가 정보 없음" // 비고
            );
            System.out.println("발령 정보 객체 생성 완료");

            // 4. DAO를 사용하여 데이터 삽입
            System.out.println("DAO를 사용하여 데이터 삽입 중...");
            hatsureiDao dao = new hatsureiDao();
            hatsurei insertedHatsurei = dao.insert(conn, newHatsurei);

            // 5. 삽입 결과 확인
            if (insertedHatsurei != null) {
                System.out.println("데이터 삽입 성공: " + insertedHatsurei.getYakushoku_mei());
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
