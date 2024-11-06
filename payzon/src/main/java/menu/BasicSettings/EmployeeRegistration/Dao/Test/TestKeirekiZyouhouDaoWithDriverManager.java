package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.Dao.keireki_zyouhouDao;
import menu.BasicSettings.EmployeeRegistration.model.keireki_zyouhou;

import java.sql.Date;

//-- 10. 경력 정보 테이블 (keireki_zyouhou) -테스트 성공
public class TestKeirekiZyouhouDaoWithDriverManager {

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

            // 3. 테스트할 경력 정보 객체 생성
            System.out.println("경력 정보 객체 생성 중...");
            keireki_zyouhou newKeireki = new keireki_zyouhou(
                1, // 사원 ID
                "Example Company", // 회사명
                Date.valueOf("2020-01-01"), // 타사 입사일
                Date.valueOf("2023-01-01"), // 타사 퇴사일
                36, // 근무 기간 (개월)
                "팀장", // 최종 직책
                "프로젝트 관리", // 담당직무
                "개인 사유" // 퇴직 사유
            );
            System.out.println("경력 정보 객체 생성 완료");

            // 4. DAO를 사용하여 데이터 삽입
            System.out.println("DAO를 사용하여 데이터 삽입 중...");
            keireki_zyouhouDao dao = new keireki_zyouhouDao();
            keireki_zyouhou insertedKeireki = dao.insert(conn, newKeireki);

            // 5. 삽입 결과 확인
            if (insertedKeireki != null) {
                System.out.println("데이터 삽입 성공: " + insertedKeireki.getKaisha_mei());
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
