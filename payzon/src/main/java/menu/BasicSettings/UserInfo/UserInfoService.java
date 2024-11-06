package menu.BasicSettings.UserInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import menu.BasicSettings.UserInfo.Model.UserInfo;
import menu.BasicSettings.UserInfo.Model.UserInfo.KaishaZyouhou;
import menu.BasicSettings.UserInfo.Model.UserInfo.KyuuyoShikyuuZyouhou;
import menu.BasicSettings.UserInfo.Model.UserInfo.Tantousha_Zyouhou;

// 사용자 정보 서비스를 제공하는 클래스
// ユーザー情報サービスを提供するクラス
public class UserInfoService {

    // 초기 사용자 정보를 가져오는 메서드
    // 初期ユーザー情報を取得するメソッド
    public UserInfo retrieveInitialInfo(Connection conn) throws SQLException {
    	String queryKaisha = "SELECT * FROM (SELECT * FROM kaisha_zyouhou ORDER BY kaisha_mei DESC) WHERE ROWNUM = 1";
    	String queryKyuuyo = "SELECT * FROM (SELECT * FROM kyuuyo_shikyuu_zyouhou ORDER BY shain_ID DESC) WHERE ROWNUM = 1";
    	String queryTantousha = "SELECT * FROM (SELECT * FROM tantousha_zyouhou ORDER BY namae DESC) WHERE ROWNUM = 1";

        UserInfo userInfo = new UserInfo();

        try (PreparedStatement stmtKaisha = conn.prepareStatement(queryKaisha);
             PreparedStatement stmtKyuuyo = conn.prepareStatement(queryKyuuyo);
             PreparedStatement stmtTantousha = conn.prepareStatement(queryTantousha)) {

            // 회사 정보 조회
            // 会社情報を取得
            try (ResultSet rsKaisha = stmtKaisha.executeQuery()) {
                if (rsKaisha.next()) {
                    userInfo.getKaishaZyouhou().setKaisha_mei(rsKaisha.getString("kaisha_mei"));
                    userInfo.getKaishaZyouhou().setShachou_yakushoku(rsKaisha.getString("shachou_yakushoku"));
                    userInfo.getKaishaZyouhou().setShachou_mei(rsKaisha.getString("shachou_mei"));
                    userInfo.getKaishaZyouhou().setZigyou_bangou(rsKaisha.getLong("zigyou_bangou"));
                    userInfo.getKaishaZyouhou().setHouzin_bangou(rsKaisha.getLong("houzin_bangou"));
                    userInfo.getKaishaZyouhou().setSetsuritsu_bi(rsKaisha.getDate("setsuritsu_bi"));
                    userInfo.getKaishaZyouhou().setUlebusaito(rsKaisha.getString("ulebusaito"));
                    userInfo.getKaishaZyouhou().setYubinbango(rsKaisha.getString("yubinbango"));
                    userInfo.getKaishaZyouhou().setZigyouzyou_zyuusho(rsKaisha.getString("zigyouzyou_zyuusho"));
                    userInfo.getKaishaZyouhou().setDenwa_bangou(rsKaisha.getLong("denwa_bangou"));
                    userInfo.getKaishaZyouhou().setFakus__bangou(rsKaisha.getString("fakus__bangou"));
                    userInfo.getKaishaZyouhou().setZigyou_shurui(rsKaisha.getString("zigyou_shurui"));
                    userInfo.getKaishaZyouhou().setZigyou_naiyou(rsKaisha.getString("zigyou_naiyou"));
                }
            }

            // 급여 정보 조회
            // 給与情報を取得
            try (ResultSet rsKyuuyo = stmtKyuuyo.executeQuery()) {
                if (rsKyuuyo.next()) {
                    userInfo.getKyuuyoShikyuuZyouhou().setShain_ID(rsKyuuyo.getInt("shain_ID"));
                    userInfo.getKyuuyoShikyuuZyouhou().setKyuuyo_seisan_kikan(rsKyuuyo.getDate("kyuuyo_seisan_kikan"));
                    userInfo.getKyuuyoShikyuuZyouhou().setKyuuyo_shikyuu_bi(rsKyuuyo.getDate("kyuuyo_shikyuu_bi"));
                    userInfo.getKyuuyoShikyuuZyouhou().setKinyuu_kikan(rsKyuuyo.getString("kinyuu_kikan"));
                    userInfo.getKyuuyoShikyuuZyouhou().setKouza_bangou(rsKyuuyo.getString("kouza_bangou"));
                    userInfo.getKyuuyoShikyuuZyouhou().setYokinshu(rsKyuuyo.getString("yokinshu"));
                }
            }

            // 담당자 정보 조회
            // 担当者情報を取得
            try (ResultSet rsTantousha = stmtTantousha.executeQuery()) {
                if (rsTantousha.next()) {
                    userInfo.getTantoushaZyouhou().setNamae(rsTantousha.getString("namae"));
                    userInfo.getTantoushaZyouhou().setBu(rsTantousha.getString("bu"));
                    userInfo.getTantoushaZyouhou().setYakushoku(rsTantousha.getString("yakushoku"));
                    userInfo.getTantoushaZyouhou().setDenwa_bangou(rsTantousha.getString("denwa_bangou"));
                    userInfo.getTantoushaZyouhou().setKeitai_bangou(rsTantousha.getString("keitai_bangou"));
                    userInfo.getTantoushaZyouhou().setMeiru_adoresu(rsTantousha.getString("meiru_adoresu"));
                }
            }
        }
        return userInfo;
    }

    // 회사 정보를 저장하거나 업데이트하는 메서드
    // 会社情報を保存または更新するメソッド
    public void saveOrUpdateKaishaZyouhou(Connection conn, UserInfo userInfo) throws SQLException {
        String query = "MERGE INTO kaisha_zyouhou USING DUAL ON (kaisha_mei = ?) " +
                       "WHEN MATCHED THEN UPDATE SET shachou_yakushoku = ?, shachou_mei = ?, zigyou_bangou = ?, " +
                       "houzin_bangou = ?, setsuritsu_bi = ?, ulebusaito = ?, yubinbango = ?, zigyouzyou_zyuusho = ?, denwa_bangou = ?, fakus__bangou = ?, zigyou_shurui = ?, zigyou_naiyou = ? " +
                       "WHEN NOT MATCHED THEN INSERT (kaisha_mei, shachou_yakushoku, shachou_mei, zigyou_bangou, " +
                       "houzin_bangou, setsuritsu_bi, ulebusaito, yubinbango, zigyouzyou_zyuusho, denwa_bangou, fakus__bangou, zigyou_shurui, zigyou_naiyou) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            KaishaZyouhou kaisha = userInfo.getKaishaZyouhou();
            // 각 필드 설정
            // 各フィールドを設定
            stmt.setString(1, kaisha.getKaisha_mei());
            stmt.setString(2, kaisha.getShachou_yakushoku());
            stmt.setString(3, kaisha.getShachou_mei());
            stmt.setLong(4, kaisha.getZigyou_bangou());
            stmt.setLong(5, kaisha.getHouzin_bangou());
            stmt.setDate(6, kaisha.getSetsuritsu_bi());
            stmt.setString(7, kaisha.getUlebusaito());
            stmt.setString(8, kaisha.getYubinbango());
            stmt.setString(9, kaisha.getZigyouzyou_zyuusho());
            stmt.setLong(10, kaisha.getDenwa_bangou());
            stmt.setString(11, kaisha.getFakus__bangou());
            stmt.setString(12, kaisha.getZigyou_shurui());
            stmt.setString(13, kaisha.getZigyou_naiyou());
            stmt.setString(14, kaisha.getKaisha_mei());
            stmt.setString(15, kaisha.getShachou_yakushoku());
            stmt.setString(16, kaisha.getShachou_mei());
            stmt.setLong(17, kaisha.getZigyou_bangou());
            stmt.setLong(18, kaisha.getHouzin_bangou());
            stmt.setDate(19, kaisha.getSetsuritsu_bi());
            stmt.setString(20, kaisha.getUlebusaito());
            stmt.setString(21, kaisha.getYubinbango());
            stmt.setString(22, kaisha.getZigyouzyou_zyuusho());
            stmt.setLong(23, kaisha.getDenwa_bangou());
            stmt.setString(24, kaisha.getFakus__bangou());
            stmt.setString(25, kaisha.getZigyou_shurui());
            stmt.setString(26, kaisha.getZigyou_naiyou());
            stmt.executeUpdate();
        }
    }

    // 급여 지급 정보를 저장하거나 업데이트하는 메서드
    // 給与支給情報を保存または更新するメソッド
    public void saveOrUpdateKyuuyoShikyuuZyouhou(Connection conn, UserInfo userInfo) throws SQLException {
        String query = "MERGE INTO kyuuyo_shikyuu_zyouhou USING DUAL ON (shain_ID = ?) " +
                       "WHEN MATCHED THEN UPDATE SET kinyuu_kikan = ?, kouza_bangou = ?, yokinshu = ?, kyuuyo_seisan_kikan = ?, kyuuyo_shikyuu_bi = ? " +
                       "WHEN NOT MATCHED THEN INSERT (shain_ID, kinyuu_kikan, kouza_bangou, yokinshu, kyuuyo_seisan_kikan, kyuuyo_shikyuu_bi) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            KyuuyoShikyuuZyouhou kyuuyo = userInfo.getKyuuyoShikyuuZyouhou();
            // 각 필드 설정
            // 各フィールドを設定
            stmt.setInt(1, kyuuyo.getShain_ID());
            stmt.setString(2, kyuuyo.getKinyuu_kikan());
            stmt.setString(3, kyuuyo.getKouza_bangou());
            stmt.setString(4, kyuuyo.getYokinshu());
            stmt.setDate(5, kyuuyo.getKyuuyo_seisan_kikan());
            stmt.setDate(6, kyuuyo.getKyuuyo_shikyuu_bi());
            stmt.setInt(7, kyuuyo.getShain_ID());
            stmt.setString(8, kyuuyo.getKinyuu_kikan());
            stmt.setString(9, kyuuyo.getKouza_bangou());
            stmt.setString(10, kyuuyo.getYokinshu());
            stmt.setDate(11, kyuuyo.getKyuuyo_seisan_kikan());
            stmt.setDate(12, kyuuyo.getKyuuyo_shikyuu_bi());
            stmt.executeUpdate();
        }
    }

    // 담당자 정보를 저장하거나 업데이트하는 메서드
    // 担当者情報を保存または更新するメソッド
    public void saveOrUpdateTantoushaZyouhou(Connection conn, UserInfo userInfo) throws SQLException {
        String query = "MERGE INTO tantousha_zyouhou USING DUAL ON (denwa_bangou = ?) " +
                       "WHEN MATCHED THEN UPDATE SET namae = ?, bu = ?, yakushoku = ?, keitai_bangou = ?, meiru_adoresu = ? " +
                       "WHEN NOT MATCHED THEN INSERT (namae, bu, yakushoku, denwa_bangou, keitai_bangou, meiru_adoresu) " +
                       "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            Tantousha_Zyouhou tantousha = userInfo.getTantoushaZyouhou();
            // 각 필드 설정
            // 各フィールドを設定
            stmt.setString(1, tantousha.getDenwa_bangou());
            stmt.setString(2, tantousha.getNamae());
            stmt.setString(3, tantousha.getBu());
            stmt.setString(4, tantousha.getYakushoku());
            stmt.setString(5, tantousha.getKeitai_bangou());
            stmt.setString(6, tantousha.getMeiru_adoresu());
            stmt.setString(7, tantousha.getNamae());
            stmt.setString(8, tantousha.getBu());
            stmt.setString(9, tantousha.getYakushoku());
            stmt.setString(10, tantousha.getDenwa_bangou());
            stmt.setString(11, tantousha.getKeitai_bangou());
            stmt.setString(12, tantousha.getMeiru_adoresu());
            stmt.executeUpdate();
        }
    }
}
