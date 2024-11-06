package menu.BasicSettings.UserInfo.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import menu.BasicSettings.UserInfo.Model.StanpuHenkouRireki;

// 도장/로고 변경 이력 DAO 클래스
// 印鑑/ロゴ変更履歴DAOクラス
public class StanpuHenkouRirekiDao {

    // 도장/로고 변경 이력 삽입 메서드
    // 印鑑/ロゴの変更履歴を挿入するメソッド
    public void insertStanpuHenkouRireki(Connection conn, StanpuHenkouRireki rireki) throws SQLException {
        String sql = "INSERT INTO stanpu_henkou_rireki (rireki_id, stanpu_shubetsu, shinsei_bi, shinkou_zyoutai, henkou_naiyou, fairu_keiro) " +
                     "VALUES (stanpu_henkou_rireki_seq.NEXTVAL, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, rireki.getStanpuShubetsu());  // "로고" 또는 "도장" ("ロゴ" または "印鑑")
            pstmt.setDate(2, new java.sql.Date(rireki.getShinseiBi().getTime()));
            pstmt.setString(3, rireki.getShinkouZyoutai());
            pstmt.setString(4, rireki.getHenkouNaiyou());
            pstmt.setString(5, rireki.getFairuKeiro());

            pstmt.executeUpdate();
        }
    }

    // 특정 rireki_id 값을 기준으로 변경 이력 조회 메서드
    // 特定のrireki_idを基に変更履歴を取得するメソッド
    public StanpuHenkouRireki getStanpuHenkouRirekiById(Connection conn, int rirekiId) throws SQLException {
        String sql = "SELECT * FROM stanpu_henkou_rireki WHERE rireki_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, rirekiId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new StanpuHenkouRireki(
                        rs.getInt("rireki_id"),
                        rs.getString("stanpu_shubetsu"),
                        rs.getDate("shinsei_bi"),
                        rs.getString("shinkou_zyoutai"),
                        rs.getString("henkou_naiyou"),
                        rs.getString("fairu_keiro")
                    );
                }
            }
        }
        return null;
    }
}
