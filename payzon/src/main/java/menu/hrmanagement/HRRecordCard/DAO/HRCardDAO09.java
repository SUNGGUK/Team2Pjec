package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard09;

public class HRCardDAO09 {

    public List<HRCard09> getAllHRCards09() {
        List<HRCard09> hrCardList09 = new ArrayList<>();

        String sql = "SELECT * FROM kyouiku_kunren";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard09 hrCard09 = new HRCard09();

                hrCard09.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard09.setKyouiku_shurui(rs.getString("kyouiku_shurui")); // 교육 종류 설정 / 教育種類を設定
                hrCard09.setKyouiku_mei(rs.getString("kyouiku_mei")); // 교육 이름 설정 / 教育名を設定
                hrCard09.setKaishi_bi(rs.getDate("kaishi_bi")); // 시작일 설정 / 開始日を設定
                hrCard09.setShuuryou_bi(rs.getDate("shuuryou_bi")); // 종료일 설정 / 終了日を設定
                hrCard09.setKyouiku_kikan_mei(rs.getString("kyouiku_kikan_mei")); // 교육 기관 이름 설정 / 教育機関名を設定
                hrCard09.setKyouiku_hi(rs.getInt("kyouiku_hi")); // 교육비 설정 / 教育費を設定
                hrCard09.setKanpu_kyouiku_hi(rs.getInt("kanpu_kyouiku_hi")); // 간부 교육비 설정 / 幹部教育費を設定

                hrCardList09.add(hrCard09); // 리스트에 HRCard 추가 / リストにHRCardを追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList09; // 전체 HR 카드 목록 반환 / 全HRカードリストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard09 getHRCardById(int shain_Id) {
        HRCard09 hrCard09 = null;
        String sql = "SELECT * FROM kyouiku_kunren WHERE shain_ID = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard09 = new HRCard09();

                hrCard09.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard09.setKyouiku_shurui(rs.getString("kyouiku_shurui")); // 교육 종류 설정 / 教育種類を設定
                hrCard09.setKyouiku_mei(rs.getString("kyouiku_mei")); // 교육 이름 설정 / 教育名を設定
                hrCard09.setKaishi_bi(rs.getDate("kaishi_bi")); // 시작일 설정 / 開始日を設定
                hrCard09.setShuuryou_bi(rs.getDate("shuuryou_bi")); // 종료일 설정 / 終了日を設定
                hrCard09.setKyouiku_kikan_mei(rs.getString("kyouiku_kikan_mei")); // 교육 기관 이름 설정 / 教育機関名を設定
                hrCard09.setKyouiku_hi(rs.getInt("kyouiku_hi")); // 교육비 설정 / 教育費を設定
                hrCard09.setKanpu_kyouiku_hi(rs.getInt("kanpu_kyouiku_hi")); // 간부 교육비 설정 / 幹部教育費を設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard09; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}