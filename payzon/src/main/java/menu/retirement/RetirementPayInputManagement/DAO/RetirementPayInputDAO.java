package menu.retirement.RetirementPayInputManagement.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import menu.retirement.RetirementPayInputManagement.Model.RetirementPayInput1;

public class RetirementPayInputDAO {

    private static RetirementPayInputDAO instance = new RetirementPayInputDAO();

    public static RetirementPayInputDAO getInstance() {
        return instance;
    }

    private RetirementPayInput1 convertRetirementPayInput(ResultSet rs) throws SQLException {
        return new RetirementPayInput1(
        		rs.getString("shain_id"),
                rs.getDate("jitsu_shikyuu_gaku_bi"),
                rs.getString("getseisan_kubun"),
                rs.getString("shain_namae"),
                rs.getString("yakushoku"),
                rs.getString("bu"),
                rs.getDate("Santei_kikan"),
                rs.getInt("kinzoku_nissuu"),
                rs.getString("taishoku_kin"),
                rs.getString("kouza_bangou")
        );
    }

    
    public RetirementPayInput1 selectEmployeeInfoById(Connection conn, String shainID) throws SQLException {
        String sql = "SELECT s.shain_namae, s.yakushoku, s.bu, s.shain_id, ky.kouza_bangou " +
                "FROM shain_touroku s " +
                "JOIN kyuuyo_shidai_hoken ky ON s.shain_id = ky.shain_id";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, shainID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // 성명, 직위, 부서, 사원ID, 지급 방법을 담아 반환
                    return new RetirementPayInput1(
                        rs.getString("shain_id"),
                        null, // 지급일(입력 기능에서 처리)
                        null, // 퇴직 구분(입력 기능에서 처리)
                        rs.getString("shain_namae"),
                        rs.getString("yakushoku"),
                        rs.getString("bu"),
                        null, // 산정 기간(입력 기능에서 처리)
                        0, // 근속일수(입력 기능에서 처리)
                        null, // 퇴직금(입력 기능에서 처리)
                        rs.getString("kouza_bangou")
                    );
                }
            }
        }
        return null; // 해당 사원이 없을 경우 null 반환
    }
    
    public void insertRetirementPaymentDetails(Connection conn, RetirementPayInput1 retirementPayInput) throws SQLException {
        String sql = "INSERT INTO taishoku_kyuuyo_Hozon (shain_id, Seisan_kubun, jitsu_shikyuu_gaku_bi, Santei_kikan, kinzoku_nissuu, taishoku_kin) " +
                     "VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, retirementPayInput.getShain_id());
            pstmt.setString(2, retirementPayInput.getSeisan_kubun());//정산구분
            pstmt.setDate(3, retirementPayInput.getJitsu_shikyuu_gaku_bi()); // 지급일
            pstmt.setDate(4, retirementPayInput.getSantei_kikan()); // 산정 기간
            pstmt.setInt(5, retirementPayInput.getKinzoku_nissuu()); // 근속 일수
            pstmt.setString(6, retirementPayInput.getTaishoku_kin()); // 실 지급액

            pstmt.executeUpdate();
        }
    }

    

    /*public RetirementPayInput1 selectById(Connection conn, String shainID) throws SQLException {
        String sql = "SELECT ta.jitsu_shikyuu_gaku_bi, t.taishoku_kubun, s.shain_namae, s.yakushoku, s.bu, ta.Santei_kikan, ta.kinzoku_nissuu, t.taishoku_kin, ky.kouza_bangou " +
                     "FROM Shain_touroku s " +
                     "LEFT JOIN taishoku t ON s.shain_id = t.shain_id " +
                     "LEFT JOIN taishoku_kyuuyo ta ON s.shain_ID = ta.shain_ID " +
                     "LEFT JOIN kyuuyo_shidai_hoken ky ON s.shain_ID = ky.shain_ID " +
                     "WHERE s.shain_ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, shainID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return convertRetirementPayInput(rs);
                }
                return null;
            }
        }
    }*/

    public void update(Connection conn, RetirementPayInput1 retirementPayInput) throws SQLException {
        String sql = "UPDATE taishoku_kyuuyo_Hozon SET getShain_id = ?, jitsu_shikyuu_gaku_bi = ?, seisan_kubun = ?, Santei_kikan = ?, kinzoku_nissuu = ?, taishoku_kin = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
        	 pstmt.setString(1, retirementPayInput.getShain_id());
             pstmt.setString(2, retirementPayInput.getSeisan_kubun());//정산구분
             pstmt.setDate(3, retirementPayInput.getJitsu_shikyuu_gaku_bi()); // 지급일
             pstmt.setDate(4, retirementPayInput.getSantei_kikan()); // 산정 기간
             pstmt.setInt(5, retirementPayInput.getKinzoku_nissuu()); // 근속 일수
             pstmt.setString(6, retirementPayInput.getTaishoku_kin()); // 실 지급액

            pstmt.executeUpdate();
        }
    }
}
