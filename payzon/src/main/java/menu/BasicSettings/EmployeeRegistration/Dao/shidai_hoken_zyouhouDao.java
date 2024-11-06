package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.shidai_hoken_zyouhou;

//-- 8. 4대 보험 정보 테이블 (shidai_hoken_zyouhou)
//-- 8. 4大保険情報テーブル (shidai_hoken_zyouhou)
public class shidai_hoken_zyouhouDao {

    // 4대 보험 정보 삽입 / 4大保険情報の挿入
    public shidai_hoken_zyouhou insert(Connection conn, shidai_hoken_zyouhou shidai_hoken) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO shidai_hoken_zyouhou (hoken_ID, shain_ID, hoken_shurui, touroku_bangou, shutoku_bi, sousitsu_bi) VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, shidai_hoken.getHoken_ID()); // 보험 ID / 保険ID
            pstmt.setInt(2, shidai_hoken.getShain_ID()); // 사원 ID / 社員ID
            pstmt.setString(3, shidai_hoken.getHoken_shurui()); // 보험 종류 / 保険種類
            pstmt.setString(4, shidai_hoken.getTouroku_bangou()); // 등록 번호 / 登録番号
            pstmt.setDate(5, shidai_hoken.getShutoku_bi()); // 취득일 / 取得日
            pstmt.setDate(6, shidai_hoken.getSousitsu_bi()); // 상실일 / 喪失日

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return shidai_hoken;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
