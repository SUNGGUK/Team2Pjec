package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.keireki_zyouhou;

//-- 10. 경력 정보 테이블 (keireki_zyouhou)
//-- 10. 経歴情報テーブル (keireki_zyouhou)
public class keireki_zyouhouDao {

    // 경력 정보 데이터 삽입 메서드 / 経歴情報データ挿入メソッド
    public keireki_zyouhou insert(Connection conn, keireki_zyouhou keireki) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO keireki_zyouhou (shain_ID, kaisha_mei, tasha_nyuusha_bi, tasha_taishoku_bi, kinmu_kikan, " +
                         "saishuu_yakushoku, tantou_shokumu, taishoku_ziyuu) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, keireki.getShain_ID());
            pstmt.setString(2, keireki.getKaisha_mei());
            pstmt.setDate(3, keireki.getTasha_nyuusha_bi());
            pstmt.setDate(4, keireki.getTasha_taishoku_bi());
            pstmt.setInt(5, keireki.getKinmu_kikan());
            pstmt.setString(6, keireki.getSaishuu_yakushoku());
            pstmt.setString(7, keireki.getTantou_shokumu());
            pstmt.setString(8, keireki.getTaishoku_ziyuu());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return keireki;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
