package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.hoshounin;

//-- 17. 보증인 테이블 (hoshounin)
//-- 17. 保証人テーブル (hoshounin)
public class hoshouninDao {

    // 보증인 데이터 삽입 메서드 / 保証人データ挿入メソッド
    public hoshounin insert(Connection conn, hoshounin hoshounin) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            String sql = "INSERT INTO hoshounin (shain_ID, hoshounin_mei, kankei, zyuumin_touroku_bangou, hoshou_kingaku, hoshou_bi, syuuryou_bi, denwa_bangou) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, hoshounin.getShain_ID());
            pstmt.setString(2, hoshounin.getHoshounin_mei());
            pstmt.setString(3, hoshounin.getKankei());
            pstmt.setString(4, hoshounin.getZyuumin_touroku_bangou());
            pstmt.setDouble(5, hoshounin.getHoshou_kingaku());
            pstmt.setDate(6, hoshounin.getHoshou_bi());
            pstmt.setDate(7, hoshounin.getSyuuryou_bi());
            pstmt.setString(8, hoshounin.getDenwa_bangou());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return hoshounin;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(pstmt);
        }
    }
}
