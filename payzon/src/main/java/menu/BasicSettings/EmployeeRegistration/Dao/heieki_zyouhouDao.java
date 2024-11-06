package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.heieki_zyouhou;

//-- 11. 병역 정보 테이블 (heieki_zyouhou)
//-- 11. 兵役情報テーブル (heieki_zyouhou)
public class heieki_zyouhouDao {

    // 병역 정보 데이터 삽입 메서드 / 兵役情報データ挿入メソッド
    public heieki_zyouhou insert(Connection conn, heieki_zyouhou heieki) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO heieki_zyouhou (shain_ID, heieki_kubun, gun_betsu, hukumu_kaishi_bi, hukumu_shuuryou_bi, " +
                         "saishuu_kaikyuu, heika, miryou_ziyuu) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, heieki.getShain_ID());
            pstmt.setString(2, heieki.getHeieki_kubun());
            pstmt.setString(3, heieki.getGun_betsu());
            pstmt.setDate(4, heieki.getHukumu_kaishi_bi());
            pstmt.setDate(5, heieki.getHukumu_shuuryou_bi());
            pstmt.setString(6, heieki.getSaishuu_kaikyuu());
            pstmt.setString(7, heieki.getHeika());
            pstmt.setString(8, heieki.getMiryou_ziyuu());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return heieki;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
