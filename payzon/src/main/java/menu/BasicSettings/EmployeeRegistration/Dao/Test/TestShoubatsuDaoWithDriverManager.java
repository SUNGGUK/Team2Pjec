package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.Dao.shoubatsuDao;
import menu.BasicSettings.EmployeeRegistration.model.shoubatsu;

import java.sql.Date;

//-- 15. 상벌 테이블 (shoubatsu) --테스트 확인
public class TestShoubatsuDaoWithDriverManager {

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

            // 3. 테스트할 상벌 정보 객체 생성
            System.out.println("상벌 정보 객체 생성 중...");
            shoubatsu newShoubatsu = new shoubatsu(
                1, // 사원 ID
                "근무 태도 우수상", // 상벌 명칭
                "사내 감사팀", // 감독 기관
                Date.valueOf("2024-03-15"), // 상벌 날짜
                "우수한 근무 태도와 팀워크로 인정받음", // 내용
                "추가 메모 없음" // 비고
            );
            System.out.println("상벌 정보 객체 생성 완료");

            // 4. DAO를 사용하여 데이터 삽입
            System.out.println("DAO를 사용하여 데이터 삽입 중...");
            shoubatsuDao dao = new shoubatsuDao();
            shoubatsu insertedShoubatsu = dao.insert(conn, newShoubatsu);

            // 5. 삽입 결과 확인
            if (insertedShoubatsu != null) {
                System.out.println("데이터 삽입 성공: " + insertedShoubatsu.getShoubatsu_mei());
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
