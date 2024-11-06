package menu.retirement.EmployeeRetirementProcessing.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import menu.retirement.EmployeeRetirementProcessing.DAO.Taisha_shanotorikeshiDAO;
import menu.retirement.EmployeeRetirementProcessing.Model.Taisha_shanotorikeshi;

public class TaishaShanotorikeshiServiceTest {

	public static void main(String[] args) {
        Taisha_shanotorikeshiDAO dao = new Taisha_shanotorikeshiDAO();
        
        // 데이터베이스에서 존재하는 사원 ID를 사용
        Integer shainId = getExistingShainId();
        if (shainId == null) {
            System.out.println("데이터베이스에 사원 ID가 존재하지 않습니다.");
            return;
        }
        
        System.out.println("테스트할 사원 ID: " + shainId);
        
        // getTaishaShanotorikeshi 메서드 테스트
        try (Connection conn = ConnectionProvider.getConnection()) {
            Taisha_shanotorikeshi taisha = dao.getTaishaShanotorikeshi(conn, shainId);
            
            if (taisha != null) {
                System.out.println("사원 ID " + shainId + " 조회 성공:");
                System.out.println("퇴직 구분: " + taisha.getTaishoku_kubun());
                System.out.println("퇴직 일자: " + taisha.getTaishoku_bi());
                System.out.println("퇴직 사유: " + taisha.getTaishoku_ziyuu());
                System.out.println("퇴직 후 연락처: " + taisha.getTaishoku_go_renrakusaki());
            } else {
                System.out.println("사원 ID " + shainId + "이(가) 데이터베이스에 존재하지 않습니다.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터 조회 중 오류 발생: " + e.getMessage());
        }
    }

    // 데이터베이스에서 첫 번째 사원 ID를 조회하는 메서드 추가
    private static Integer getExistingShainId() {
        String sql = "SELECT shain_id FROM taishoku WHERE ROWNUM = 1";
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("shain_id"); // 첫 번째 사원 ID 반환
            }
        } catch (SQLException e) {
            System.out.println("사원 ID 조회 중 오류 발생: " + e.getMessage());
        }
        return null; // 사원 ID가 없을 경우 null 반환
    }
}