package menu.retirement.EmployeeRetirementProcessing.DAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jdbc.connection.ConnectionProvider;
import menu.retirement.EmployeeRetirementProcessing.Model.Taisha_shanotorikeshi;

public class Taisha_shanotorikeshiDAOTest {

	 public static void main(String[] args) {
	        Taisha_shanotorikeshiDAO dao = new Taisha_shanotorikeshiDAO();

	        // 테스트할 사원 ID 설정
	        int testShainId = 1;  // 실제 데이터베이스에 존재하는 ID로 설정하세요.

	        // 데이터베이스 연결 및 테스트 실행
	        try (Connection conn = ConnectionProvider.getConnection()) {
	            // getTaishaShanotorikeshi 메서드를 사용하여 데이터 조회
	            System.out.println("사원 ID로 퇴직 정보 조회 테스트 시작");
	            Taisha_shanotorikeshi taisha = dao.getTaishaShanotorikeshi(conn, testShainId);
	            
	            // 조회 결과 출력
	            if (taisha != null) {
	                System.out.println("조회 성공:");
	                System.out.println("사원 ID: " + taisha.getShain_ID());
	                System.out.println("퇴직 구분: " + taisha.getTaishoku_kubun());
	                System.out.println("퇴직 일자: " + taisha.getTaishoku_bi());
	                System.out.println("퇴직 사유: " + taisha.getTaishoku_ziyuu());
	                System.out.println("퇴직 후 연락처: " + taisha.getTaishoku_go_renrakusaki());
	            } else {
	                System.out.println("해당 사원의 퇴직 정보를 찾을 수 없습니다.");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("데이터 조회 중 오류 발생: " + e.getMessage());
	        }
	    }
	}
