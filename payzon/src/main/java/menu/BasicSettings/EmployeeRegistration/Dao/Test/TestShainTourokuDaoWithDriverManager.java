package menu.BasicSettings.EmployeeRegistration.Dao.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.Dao.shain_tourokuDao;
import menu.BasicSettings.EmployeeRegistration.model.shain_touroku;

import java.sql.Date;

//-- 6. 사원 등록 테이블 (shain_touroku)
//shain_touroku Oracle에 직접 연결해서 자바 콘솔에서 확인하는 코드 , 구동 확인

public class TestShainTourokuDaoWithDriverManager {

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

            // 3. 테스트할 사원 등록 객체 생성
            System.out.println("사원 등록 정보 객체 생성 중...");
            shain_touroku newShain = new shain_touroku(
            	    10200, // 중복되지 않는 ID 지정
            	    "정규직", // 고용 형태
            	    "홍길동", // 사원 이름
            	    "Hong Gil Dong", // 사원 영어 이름
            	    Date.valueOf("2024-10-01"), // 입사일
            	    null, // 퇴사일 (optional)
            	    "기획부", // 부서
            	    "과장", // 직위
            	    "내국인", // 내외국인
            	    "123456-1234567", // 주민번호
            	    "서울특별시 강남구", // 주소
            	    "02-1234-5678", // 전화번호
            	    "010-1234-5678", // 휴대전화번호
            	    "example@example.com", // 이메일
            	    "@exampleSNS", // SNS
            	    "이 사원은 매우 성실합니다." // 비고
            	);
            System.out.println("사원 등록 정보 객체 생성 완료");

            // 4. DAO를 사용하여 데이터 삽입
            System.out.println("DAO를 사용하여 데이터 삽입 중...");
            shain_tourokuDao dao = new shain_tourokuDao();
            shain_touroku insertedShain = dao.insert(conn, newShain);

            // 5. 삽입 결과 확인
            if (insertedShain != null) {
                System.out.println("데이터 삽입 성공: " + insertedShain.getShain_namae());
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
