package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.kyouiku_kunren;

//-- 14. 교육 훈련 테이블 (kyouiku_kunren)
//-- 14. 教育訓練テーブル (kyouiku_kunren)
public class kyouiku_kunrenDao {

    // 교육 훈련 데이터 삽입 메서드 / 教育訓練データ挿入メソッド
    public kyouiku_kunren insert(Connection conn, kyouiku_kunren kyouiku) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO kyouiku_kunren (shain_ID, kyouiku_shurui, kyouiku_mei, kaishi_bi, shuuryou_bi, kyouiku_kikan_mei, kyouiku_hi, kanpu_kyouiku_hi) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, kyouiku.getShain_ID());
            pstmt.setString(2, kyouiku.getKyouiku_shurui());
            pstmt.setString(3, kyouiku.getKyouiku_mei());
            pstmt.setDate(4, kyouiku.getKaishi_bi());
            pstmt.setDate(5, kyouiku.getShuuryou_bi());
            pstmt.setString(6, kyouiku.getKyouiku_kikan_mei());
            pstmt.setDouble(7, kyouiku.getKyouiku_hi());
            pstmt.setDouble(8, kyouiku.getKanpu_kyouiku_hi());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return kyouiku;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
