package menu.BasicSettings.UserInfo.Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import menu.BasicSettings.UserInfo.Model.UserInfo;
import menu.BasicSettings.UserInfo.Model.UserInfo.KaishaZyouhou;
import menu.BasicSettings.UserInfo.Model.UserInfo.KyuuyoShikyuuZyouhou;
import menu.BasicSettings.UserInfo.Model.UserInfo.Tantousha_Zyouhou;

// 사용자 정보 취소 서비스 클래스
// ユーザー情報キャンセルサービスクラス
public class UserInfoCancelService {

    // 초기 사용자 정보를 가져오는 메서드
    // 初期ユーザー情報を取得するメソッド
    public UserInfo retrieveInitialInfo(Connection conn) throws SQLException {
        String query = "SELECT * FROM user_info";
        try (PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            // 결과가 있을 경우, 초기 사용자 정보 객체 생성
            // 結果がある場合、初期ユーザー情報オブジェクトを生成
            if (rs.next()) {
                UserInfo userInfo = new UserInfo();

                // 회사 정보 설정
                // 会社情報を設定
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
                
                userInfo.setKaishaZyouhou(kaishaZyouhou);

                // 담당자 정보 설정
                // 担当者情報を設定
                Tantousha_Zyouhou tantoushaZyouhou = new Tantousha_Zyouhou();
                tantoushaZyouhou.setNamae(rs.getString("namae"));
                tantoushaZyouhou.setBu(rs.getString("bu"));
                tantoushaZyouhou.setYakushoku(rs.getString("yakushoku"));
                tantoushaZyouhou.setDenwa_bangou(rs.getString("denwa_bangou"));
                tantoushaZyouhou.setKeitai_bangou(rs.getString("keitai_bangou"));
                tantoushaZyouhou.setMeiru_adoresu(rs.getString("meiru_adoresu"));
                
                userInfo.setTantoushaZyouhou(tantoushaZyouhou);

                // 급여 정보 설정
                // 給与情報を設定
                KyuuyoShikyuuZyouhou kyuuyoShikyuuZyouhou = new KyuuyoShikyuuZyouhou();
                kyuuyoShikyuuZyouhou.setShain_ID(rs.getInt("shain_ID"));
                kyuuyoShikyuuZyouhou.setKyuuyo_seisan_kikan(rs.getDate("kyuuyo_seisan_kikan"));
                kyuuyoShikyuuZyouhou.setKyuuyo_shikyuu_bi(rs.getDate("kyuuyo_shikyuu_bi"));
                kyuuyoShikyuuZyouhou.setKinyuu_kikan(rs.getString("kinyuu_kikan"));
                kyuuyoShikyuuZyouhou.setKouza_bangou(rs.getString("kouza_bangou"));
                kyuuyoShikyuuZyouhou.setYokinshu(rs.getString("yokinshu"));
                
                userInfo.setKyuuyoShikyuuZyouhou(kyuuyoShikyuuZyouhou);

                return userInfo; // 사용자 정보 반환
                // ユーザー情報を返す
            } else {
                return null; // 데이터가 없을 경우 null 반환
                // データがない場合はnullを返す
            }
        }
    }
}
