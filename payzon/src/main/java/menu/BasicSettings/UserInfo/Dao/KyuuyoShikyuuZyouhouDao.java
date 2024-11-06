package menu.BasicSettings.UserInfo.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import menu.BasicSettings.UserInfo.Model.KyuuyoShikyuuZyouhou;

// 급여 지급 정보 DAO 클래스
// 給与支給情報DAOクラス
public class KyuuyoShikyuuZyouhouDao {

    // 급여 지급 정보 삽입 메서드
    // 給与支給情報を挿入するメソッド
    public int insertKyuuyoShikyuuInfo(Connection conn, KyuuyoShikyuuZyouhou kyuuyoInfo) throws SQLException {
        String insertQuery = "INSERT INTO kyuuyo_shikyuu_zyouhou (shain_ID, kyuuyo_seisan_kikan, kyuuyo_shikyuu_bi, kinyuu_kikan, kouza_bangou, yokinshu) "
                            + "VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
            pstmt.setInt(1, kyuuyoInfo.getShain_ID());
            pstmt.setDate(2, Date.valueOf(kyuuyoInfo.getKyuuyo_seisan_kikan()));
            pstmt.setDate(3, Date.valueOf(kyuuyoInfo.getKyuuyo_shikyuu_bi()));
            pstmt.setString(4, kyuuyoInfo.getKinyuu_kikan());
            pstmt.setString(5, kyuuyoInfo.getKouza_bangou());
            pstmt.setString(6, kyuuyoInfo.getYokinshu());

            return pstmt.executeUpdate();
        }
    }

    // 사원 ID로 계좌 번호 조회 메서드
    // 社員IDで口座番号を取得するメソッド
    public String getKouzaBangou(Connection conn, int shainID) throws SQLException {
        String query = "SELECT kouza_bangou FROM kyuuyo_shikyuu_zyouhou WHERE shain_ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, shainID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("kouza_bangou");
                } else {
                    return null;
                }
            }
        }
    }

    // 급여 지급 정보 업데이트 메서드
    // 給与支給情報を更新するメソッド
    public int updateKyuuyoShikyuuInfo(Connection conn, KyuuyoShikyuuZyouhou kyuuyoInfo) throws SQLException {
        String updateQuery = "UPDATE kyuuyo_shikyuu_zyouhou SET kyuuyo_seisan_kikan = ?, kyuuyo_shikyuu_bi = ?, " +
                             "kinyuu_kikan = ?, kouza_bangou = ?, yokinshu = ? WHERE shain_ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(updateQuery)) {
            pstmt.setDate(1, Date.valueOf(kyuuyoInfo.getKyuuyo_seisan_kikan()));
            pstmt.setDate(2, Date.valueOf(kyuuyoInfo.getKyuuyo_shikyuu_bi()));
            pstmt.setString(3, kyuuyoInfo.getKinyuu_kikan());
            pstmt.setString(4, kyuuyoInfo.getKouza_bangou());
            pstmt.setString(5, kyuuyoInfo.getYokinshu());
            pstmt.setInt(6, kyuuyoInfo.getShain_ID());

            return pstmt.executeUpdate();
        }
    }

    // 사원 ID로 급여 지급 정보 조회 메서드
    // 社員IDで給与支給情報を取得するメソッド
    public KyuuyoShikyuuZyouhou getKyuuyoShikyuuZyouhouByShainID(Connection conn, int shainID) throws SQLException {
        String selectQuery = "SELECT * FROM kyuuyo_shikyuu_zyouhou WHERE shain_ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(selectQuery)) {
            pstmt.setInt(1, shainID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new KyuuyoShikyuuZyouhou(
                        rs.getInt("shain_ID"),
                        rs.getDate("kyuuyo_seisan_kikan").toLocalDate(),
                        rs.getDate("kyuuyo_shikyuu_bi").toLocalDate(),
                        rs.getString("kinyuu_kikan"),
                        rs.getString("kouza_bangou"),
                        rs.getString("yokinshu")
                    );
                } else {
                    return null;
                }
            }
        }
    }
}
