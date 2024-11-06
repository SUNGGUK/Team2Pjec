package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import menu.BasicSettings.EmployeeRegistration.model.kyuuyo_shidai_hoken;

//-- 7. 급여 및 4대 보험 테이블 (kyuuya_shidai_hoken)
//-- 7. 給与および4大保険テーブル (kyuuya_shidai_hoken)
public class kyuuyo_shidai_hokenDao {

    // 데이터 삽입 메서드 / データ挿入メソッド
	public int insertKyuuyoShidaiHoken(Connection conn, kyuuyo_shidai_hoken kyuuyo) throws SQLException {
	    String query = "INSERT INTO kyuuyo_shidai_hoken (shain_ID, kokumin_nenkin, kenko_hoken, genmen1, kaigo_hoken, " +
	                   "genmen2, koyo_hoken, rodo_sha, zeigaku, seinen_zei, genmen3, jigyo_sha, hiyatoi, sonota_sha, " +
	                   "rodo_jigyo_sha, menjo, gaito_nashi1, shinki_80_1, shinki_90_1, gaito_nashi2, shinki_80_2, shinki_90_2, " +
	                   "kihonkyuu, nenkin_shotoku, kenko_shotoku, koyo_shotoku, sangyou_saigai, ginkou_mei, kouza_bangou) " +
	                   "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; // 쿼리의 ? 개수를 29개로 맞춤 / クエリの ? の個数を29個に調整
	    try (PreparedStatement pstmt = conn.prepareStatement(query)) {
	        pstmt.setInt(1, kyuuyo.getShain_ID());
	        pstmt.setString(2, String.valueOf(kyuuyo.getKokumin_nenkin()));
	        pstmt.setString(3, String.valueOf(kyuuyo.getKenko_hoken()));
	        pstmt.setInt(4, kyuuyo.getGenmen1());
	        pstmt.setString(5, String.valueOf(kyuuyo.getKaigo_hoken()));
	        pstmt.setInt(6, kyuuyo.getGenmen2());
	        pstmt.setString(7, String.valueOf(kyuuyo.getKoyo_hoken()));
	        pstmt.setString(8, String.valueOf(kyuuyo.getRodo_sha()));
	        pstmt.setInt(9, kyuuyo.getZeigaku());
	        pstmt.setString(10, String.valueOf(kyuuyo.getSeinen_zei()));
	        pstmt.setInt(11, kyuuyo.getGenmen3());
	        pstmt.setString(12, String.valueOf(kyuuyo.getJigyo_sha()));
	        pstmt.setString(13, String.valueOf(kyuuyo.getHiyatoi()));
	        pstmt.setString(14, String.valueOf(kyuuyo.getSonota_sha()));
	        pstmt.setString(15, String.valueOf(kyuuyo.getRodo_jigyo_sha()));
	        pstmt.setString(16, String.valueOf(kyuuyo.getMenjo()));
	        pstmt.setString(17, String.valueOf(kyuuyo.getGaito_nashi1()));
	        pstmt.setString(18, String.valueOf(kyuuyo.getShinki_80_1()));
	        pstmt.setString(19, String.valueOf(kyuuyo.getShinki_90_1()));
	        pstmt.setString(20, String.valueOf(kyuuyo.getGaito_nashi2()));
	        pstmt.setString(21, String.valueOf(kyuuyo.getShinki_80_2()));
	        pstmt.setString(22, String.valueOf(kyuuyo.getShinki_90_2()));
	        pstmt.setInt(23, kyuuyo.getKihonkyuu());
	        pstmt.setInt(24, kyuuyo.getNenkin_shotoku());
	        pstmt.setInt(25, kyuuyo.getKenko_shotoku());
	        pstmt.setInt(26, kyuuyo.getKoyo_shotoku());
	        pstmt.setInt(27, kyuuyo.getSangyou_saigai());
	        pstmt.setString(28, kyuuyo.getGinkou_mei());
	        pstmt.setString(29, kyuuyo.getKouza_bangou());

	        return pstmt.executeUpdate();
	    }
	}

    // 데이터 조회 메서드 / データ取得メソッド
    public kyuuyo_shidai_hoken getKyuuyoShidaiHoken(Connection conn, int shain_ID) throws SQLException {
        String query = "SELECT * FROM kyuuyo_shidai_hoken WHERE shain_ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, shain_ID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new kyuuyo_shidai_hoken(
                        rs.getInt("shain_ID"),
                        rs.getString("kokumin_nenkin").charAt(0),
                        rs.getString("kenko_hoken").charAt(0),
                        rs.getInt("genmen1"),
                        rs.getString("kaigo_hoken").charAt(0),
                        rs.getInt("genmen2"),
                        rs.getString("koyo_hoken").charAt(0),
                        rs.getString("rodo_sha").charAt(0),
                        rs.getInt("zeigaku"),
                        rs.getString("seinen_zei").charAt(0),
                        rs.getInt("genmen3"),
                        rs.getString("jigyo_sha").charAt(0),
                        rs.getString("hiyatoi").charAt(0),
                        rs.getString("sonota_sha").charAt(0),
                        rs.getString("rodo_jigyo_sha").charAt(0),
                        rs.getString("menjo").charAt(0),
                        rs.getString("gaito_nashi1").charAt(0),
                        rs.getString("shinki_80_1").charAt(0),
                        rs.getString("shinki_90_1").charAt(0),
                        rs.getString("gaito_nashi2").charAt(0),
                        rs.getString("shinki_80_2").charAt(0),
                        rs.getString("shinki_90_2").charAt(0),
                        rs.getInt("kihonkyuu"),
                        rs.getInt("nenkin_shotoku"),
                        rs.getInt("kenko_shotoku"),
                        rs.getInt("koyo_shotoku"),
                        rs.getInt("sangyou_saigai"),
                        rs.getString("ginkou_mei"),
                        rs.getString("kouza_bangou")
                    );
                } else {
                    return null;
                }
            }
        }
    }
}
