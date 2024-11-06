package menu.payroll.PayrollLedger.DAO;

import jdbc.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollLedgerDAO {

    // 전체 급여 정보를 조회하는 메서드 (全体給与情報を取得するメソッド)
    public List<String[]> getAllPayrolls() {
        List<String[]> payrollList = new ArrayList<>();
        String sql = "SELECT sk.seisan_kaishi_bi, sk.seisan_shuryo_bi, sk.shikyuu_bi, COUNT(DISTINCT sk.shain_id) as inwon, " +
                     "SUM(sk.shikyuuzoukyuu) as total_shiharai, SUM(sk.koujo_sougaku) as total_koujo " +
                     "FROM shain_kyuuyo sk " +
                     "JOIN shain_touroku st ON sk.shain_id = st.shain_id " +
                     "GROUP BY sk.seisan_kaishi_bi, sk.seisan_shuryo_bi, sk.shikyuu_bi";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                String[] row = new String[6];
                row[0] = rs.getString("seisan_kaishi_bi");        // 정산 기간 시작일 (精算期間開始日)
                row[1] = rs.getString("seisan_shuryo_bi");        // 정산 기간 종료일 (精算期間終了日)
                row[2] = rs.getString("shikyuu_bi");              // 지급일 (支給日)
                row[3] = String.valueOf(rs.getInt("inwon"));      // 인원 (人数)
                row[4] = String.valueOf(rs.getDouble("total_shiharai")); // 지급 총액 (支給総額)
                row[5] = String.valueOf(rs.getDouble("total_koujo"));    // 공제 총액 (控除総額)
                payrollList.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payrollList;
    }
}
