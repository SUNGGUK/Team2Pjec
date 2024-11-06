package menu.payroll.PayrollInputManagement.Service;

import menu.payroll.PayrollInputManagement.Model.*;
import jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PayrollInputService {

    // 급여 정보 입력 메서드 (給与情報入力メソッド)
    public void inputPayroll(int shainId, TotalShiharai shiharai, TotalKouzyo kouzyo) {
        // 구현 필요
    }

    // 사원 ID로 급여 및 공제 정보 조회 메서드 (社員IDで給与と控除情報を取得するメソッド)
    public List<String[]> getPayrollByShainId(int shainId) {
        return null; // 구현 필요
    }
    
    // 전체 사원 급여 정보 조회 메서드 (全社員の給与情報を取得するメソッド)
    public List<String[]> getAllPayrolls() {
        List<String[]> payrollList = new ArrayList<>();
        String sql = "SELECT st.koyou_keitai, st.shain_namae, st.bu, " +
                     "ts.shikyuuzoukyuu, tk.koujo_sougaku " +
                     "FROM total_shiharai ts " +
                     "JOIN total_kouzyo tk ON ts.shain_ID = tk.shain_ID " +
                     "JOIN shain_touroku st ON ts.shain_ID = st.shain_ID";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String[] row = new String[5];
                row[0] = rs.getString("koyou_keitai"); // 고용 형태 (雇用形態)
                row[1] = rs.getString("shain_namae");  // 사원 이름 (社員名)
                row[2] = rs.getString("bu");            // 부서 (部署)
                row[3] = String.valueOf(rs.getDouble("shikyuuzoukyuu")); // 급여 (支給総額)
                row[4] = String.valueOf(rs.getDouble("koujo_sougaku"));    // 공제 (控除総額)
                payrollList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // 예외 처리 (例外処理)
        }
        return payrollList; // 급여 리스트 반환 (給与リストを返す)
    }

}
