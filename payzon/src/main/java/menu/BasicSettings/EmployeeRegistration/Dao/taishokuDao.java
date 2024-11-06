package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.taishoku;

//-- 18. 퇴직 테이블 (taishoku)
//-- 18. 退職テーブル (taishoku)
public class taishokuDao {

    // 퇴직 정보를 삽입하는 메서드 / 退職情報を挿入するメソッド
    public taishoku insert(Connection conn, taishoku taishoku) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO taishoku (shain_ID, zyoutai, taishoku_kubun, taishoku_bi, taishoku_ziyuu, taishoku_go_renrakusaki, " +
                         "chuukan_seisan_umu, taishoku_seisan_umu, taishoku_kin, bikou) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, taishoku.getShain_ID()); // 사원 ID / 社員ID
            pstmt.setString(2, taishoku.getZyoutai()); // 상태 / 状態
            pstmt.setString(3, taishoku.getTaishoku_kubun()); // 퇴직 구분 / 退職区分
            pstmt.setDate(4, taishoku.getTaishoku_bi()); // 퇴직일 / 退職日
            pstmt.setString(5, taishoku.getTaishoku_ziyuu()); // 퇴직 사유 / 退職理由
            pstmt.setString(6, taishoku.getTaishoku_go_renrakusaki()); // 퇴직 후 연락처 / 退職後連絡先
            pstmt.setString(7, String.valueOf(taishoku.getChuukan_seisan_umu())); // 중간 정산 여부 / 中間精算有無
            pstmt.setString(8, String.valueOf(taishoku.getTaishoku_seisan_umu())); // 퇴직 정산 여부 / 退職精算有無
            pstmt.setDouble(9, taishoku.getTaishoku_kin()); // 퇴직금 / 退職金
            pstmt.setBytes(10, taishoku.getBikou()); // 비고 / 備考

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return taishoku;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(pstmt);
        }
    }
}
