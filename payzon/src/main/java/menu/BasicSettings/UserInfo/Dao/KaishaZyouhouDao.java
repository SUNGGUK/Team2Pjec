package menu.BasicSettings.UserInfo.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import menu.BasicSettings.UserInfo.Model.KaishaZyouhou;

// 회사 정보 DAO 클래스
// 会社情報DAOクラス
public class KaishaZyouhouDao {

    // 최신 회사 정보 조회 메서드
    // 最新の会社情報を取得するメソッド
    public KaishaZyouhou getLatestCompanyInfo(Connection conn) throws SQLException {
        String sql = "SELECT * FROM kaisha_zyouhou ORDER BY 수정_일자 DESC FETCH FIRST 1 ROWS ONLY";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    KaishaZyouhou kaishaZyouhou = new KaishaZyouhou();
                    kaishaZyouhou.setKaisha_mei(rs.getString("kaisha_mei"));
                    kaishaZyouhou.setShachou_yakushoku(rs.getString("shachou_yakushoku"));
                    kaishaZyouhou.setShachou_mei(rs.getString("shachou_mei"));
                    kaishaZyouhou.setZigyou_bangou(rs.getLong("zigyou_bangou"));
                    kaishaZyouhou.setHouzin_bangou(rs.getLong("houzin_bangou"));
                    kaishaZyouhou.setSetsuritsu_bi(rs.getDate("setsuritsu_bi"));
                    kaishaZyouhou.setUlebusaito(rs.getString("ulebusaito"));
                    kaishaZyouhou.setYubinbango(rs.getString("yubinbango"));
                    kaishaZyouhou.setZigyouzyou_zyuusho(rs.getString("zigyouzyou_zyuusho"));
                    kaishaZyouhou.setDenwa_bangou(rs.getLong("denwa_bangou"));
                    kaishaZyouhou.setFakus__bangou(rs.getString("fakus__bangou"));
                    kaishaZyouhou.setZigyou_shurui(rs.getString("zigyou_shurui"));
                    kaishaZyouhou.setZigyou_naiyou(rs.getString("zigyou_naiyou"));
                    return kaishaZyouhou;
                }
            }
        }
        return null;
    }

    // 회사 정보 저장 또는 업데이트 메서드
    // 会社情報を保存または更新するメソッド
    public int saveOrUpdateCompanyInfo(Connection conn, KaishaZyouhou kaisha) throws SQLException {
        String query = "MERGE INTO kaisha_zyouhou USING DUAL ON (kaisha_mei = ?) " +
                       "WHEN MATCHED THEN UPDATE SET shachou_yakushoku = ?, shachou_mei = ?, zigyou_bangou = ?, " +
                       "houzin_bangou = ?, setsuritsu_bi = ?, ulebusaito = ?, yubinbango = ?, " +
                       "zigyouzyou_zyuusho = ?, denwa_bangou = ?, fakus__bangou = ?, zigyou_shurui = ?, zigyou_naiyou = ? " +
                       "WHEN NOT MATCHED THEN INSERT (kaisha_mei, shachou_yakushoku, shachou_mei, zigyou_bangou, " +
                       "houzin_bangou, setsuritsu_bi, ulebusaito, yubinbango, zigyouzyou_zyuusho, denwa_bangou, " +
                       "fakus__bangou, zigyou_shurui, zigyou_naiyou) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, kaisha.getKaisha_mei());
            stmt.setString(2, kaisha.getShachou_yakushoku());
            stmt.setString(3, kaisha.getShachou_mei());
            stmt.setLong(4, kaisha.getZigyou_bangou());
            stmt.setLong(5, kaisha.getHouzin_bangou());
            stmt.setDate(6, Date.valueOf(kaisha.getSetsuritsu_bi().toString())); 
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
            stmt.setDate(19, Date.valueOf(kaisha.getSetsuritsu_bi().toString())); 
            stmt.setString(20, kaisha.getUlebusaito());
            stmt.setString(21, kaisha.getYubinbango());
            stmt.setString(22, kaisha.getZigyouzyou_zyuusho());
            stmt.setLong(23, kaisha.getDenwa_bangou());
            stmt.setString(24, kaisha.getFakus__bangou());
            stmt.setString(25, kaisha.getZigyou_shurui());
            stmt.setString(26, kaisha.getZigyou_naiyou());

            return stmt.executeUpdate();
        }
    }
}
