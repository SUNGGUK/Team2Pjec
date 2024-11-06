package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.hatsurei;

//-- 16. 발령 테이블 (hatsurei)
//-- 16. 発令テーブル (hatsurei)
public class hatsureiDao {

    // 발령 정보 데이터 삽입 메서드 / 発令情報データ挿入メソッド
    public hatsurei insert(Connection conn, hatsurei hatsurei) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO hatsurei (shain_ID, hatsurei_bi, bu, yakushoku_mei, shokumu_mei, bikou) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, hatsurei.getShain_ID());
            pstmt.setDate(2, hatsurei.getHatsurei_bi());
            pstmt.setString(3, hatsurei.getBu());
            pstmt.setString(4, hatsurei.getYakushoku_mei());
            pstmt.setString(5, hatsurei.getShokumu_mei());
            pstmt.setString(6, hatsurei.getBikou());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return hatsurei;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
