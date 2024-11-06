package menu.payroll.PayrollInputManagementforDailyWorkers.Service;

import menu.payroll.PayrollInputManagementforDailyWorkers.Model.*;
import jdbc.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PayrollInputDailyService {

    // 급여 정보 입력 메서드 (給与情報入力メソッド)
    public void inputPayroll(int shainId, TotalShiharai shiharai, TotalKouzyo kouzyo) {
        // 급여 입력 로직을 구현합니다. (給与入力ロジックを実装します。)
    }

    // 사원 ID로 급여 및 공제 정보 조회 메서드 (社員IDで給与及び控除情報を取得するメソッド)
    public List<String[]> getPayrollByShainId(int shainId) {
        // 사원 ID에 따른 급여 및 공제 정보 조회 로직을 구현합니다. (社員IDに基づく給与及び控除情報取得ロジックを実装します。)
        return null; // 아직 구현되지 않았습니다. (まだ実装されていません。)
    }
    
    // 일용직 사원 급여 정보 조회 메서드 (日雇い社員の給与情報を取得するメソッド)
    public List<String[]> getAllPayrolls() {
        List<String[]> payrollList = new ArrayList<>();
        String sql = "SELECT st.koyou_keitai, st.shain_namae, st.bu, " +
                     "ts.shikyuuzoukyuu, tk.koujo_sougaku " +
                     "FROM total_shiharai ts " +
                     "JOIN total_kouzyo tk ON ts.shain_ID = tk.shain_ID " +
                     "JOIN shain_touroku st ON ts.shain_ID = st.shain_ID " +
                     "WHERE st.koyou_keitai = '일용직'"; // 일용직 필터 (日雇いフィルタ)

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String[] row = new String[5];
                row[0] = rs.getString("koyou_keitai"); // 고용 형태 (雇用形態)
                row[1] = rs.getString("shain_namae");  // 사원 이름 (社員名)
                row[2] = rs.getString("bu");            // 부서 (部署)
                row[3] = String.valueOf(rs.getDouble("shikyuuzoukyuu")); // 급여 (給与)
                row[4] = String.valueOf(rs.getDouble("koujo_sougaku"));    // 공제 (控除)
                payrollList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payrollList;
    }
}
