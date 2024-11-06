package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.huyou_kazoku;

//-- 9. 부양 가족 테이블 (huyou_kazoku)
//-- 9. 扶養家族テーブル (huyou_kazoku)
public class huyou_kazokuDao {

    // 부양 가족 데이터 삽입 메서드 / 扶養家族データ挿入メソッド
    public huyou_kazoku insert(Connection conn, huyou_kazoku kazoku) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO huyou_kazoku (shain_ID, namae, kankei, zyuumin_touroku_bangou, " +
                         "shougai_umu, zei_kouzyo_umu, kenkou_hoken_umu, doukyo_umu, nen20_ika_ko_umu) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, kazoku.getShain_ID());
            pstmt.setString(2, kazoku.getNamae());
            pstmt.setString(3, kazoku.getKankei());
            pstmt.setString(4, kazoku.getZyuumin_touroku_bangou());
            pstmt.setString(5, String.valueOf(kazoku.getShougai_umu()));
            pstmt.setString(6, String.valueOf(kazoku.getZei_kouzyo_umu()));
            pstmt.setString(7, String.valueOf(kazoku.getKenkou_hoken_umu()));
            pstmt.setString(8, String.valueOf(kazoku.getDoukyo_umu()));
            pstmt.setString(9, String.valueOf(kazoku.getNen20_ika_ko_umu()));

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return kazoku;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
