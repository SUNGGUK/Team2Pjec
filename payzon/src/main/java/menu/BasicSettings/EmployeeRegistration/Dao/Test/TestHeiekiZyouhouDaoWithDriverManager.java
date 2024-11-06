package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.Dao.heieki_zyouhouDao;
import menu.BasicSettings.EmployeeRegistration.model.heieki_zyouhou;

import java.sql.Date;

//-- 11. 병역 정보 테이블 (heieki_zyouhou) --테스트 성공
public class TestHeiekiZyouhouDaoWithDriverManager {

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

            // 3. 테스트할 병역 정보 객체 생성
            System.out.println("병역 정보 객체 생성 중...");
            heieki_zyouhou newHeieki = new heieki_zyouhou(
                1, // 사원 ID
                "육군", // 군 복무 종류
                "제1사단", // 복무 부서
                Date.valueOf("2020-01-01"), // 복무 시작일
                Date.valueOf("2022-01-01"), // 복무 종료일
                "상병", // 최종 계급
                "보병", // 병과
                "해당 없음" // 미필사유
            );
            System.out.println("병역 정보 객체 생성 완료");

            // 4. DAO를 사용하여 데이터 삽입
            System.out.println("DAO를 사용하여 데이터 삽입 중...");
            heieki_zyouhouDao dao = new heieki_zyouhouDao();
            heieki_zyouhou insertedHeieki = dao.insert(conn, newHeieki);

            // 5. 삽입 결과 확인
            if (insertedHeieki != null) {
                System.out.println("데이터 삽입 성공: " + insertedHeieki.getShain_ID());
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
