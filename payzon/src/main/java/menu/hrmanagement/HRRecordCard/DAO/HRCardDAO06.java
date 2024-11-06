package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard06;

public class HRCardDAO06 {

    public List<HRCard06> getAllHRCards06() {
        List<HRCard06> hrCardList06 = new ArrayList<>();

        String sql = "SELECT * FROM heieki_zyouhou";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard06 hrCard06 = new HRCard06();

                hrCard06.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard06.setHeieki_kubun(rs.getString("heieki_kubun")); // 해역 구분 설정 / 海域区分を設定
                hrCard06.setGun_betsu(rs.getString("gun_betsu")); // 군별 설정 / 軍別を設定
                hrCard06.setHukumu_kaishi_bi(rs.getDate("hukumu_kaishi_bi")); // 복무 시작일 설정 / 復務開始日を設定
                hrCard06.setHukumu_shuuryou_bi(rs.getDate("hukumu_shuuryou_bi")); // 복무 종료일 설정 / 復務終了日を設定
                hrCard06.setSaishuu_kaikyuu(rs.getString("saishuu_kaikyuu")); // 최종 계급 설정 / 最終階級を設定
                hrCard06.setHeika(rs.getString("heika")); // 해과 설정 / 平課を設定
                hrCard06.setMiryou_ziyuu(rs.getString("miryou_ziyuu")); // 미량 사유 설정 / 未量理由を設定

                hrCardList06.add(hrCard06); // 리스트에 HRCard 추가 / リストにHRCardを追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList06; // 전체 HR 카드 목록 반환 / 全HRカードリストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard06 getHRCardById(int shain_Id) {
        HRCard06 hrCard06 = null;
        String sql = "SELECT * FROM heieki_zyouhou WHERE shain_ID = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard06 = new HRCard06();

                hrCard06.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard06.setHeieki_kubun(rs.getString("heieki_kubun")); // 해역 구분 설정 / 海域区分を設定
                hrCard06.setGun_betsu(rs.getString("gun_betsu")); // 군별 설정 / 軍別を設定
                hrCard06.setHukumu_kaishi_bi(rs.getDate("hukumu_kaishi_bi")); // 복무 시작일 설정 / 復務開始日を設定
                hrCard06.setHukumu_shuuryou_bi(rs.getDate("hukumu_shuuryou_bi")); // 복무 종료일 설정 / 復務終了日を設定
                hrCard06.setSaishuu_kaikyuu(rs.getString("saishuu_kaikyuu")); // 최종 계급 설정 / 最終階級を設定
                hrCard06.setHeika(rs.getString("heika")); // 해과 설정 / 平課を設定
                hrCard06.setMiryou_ziyuu(rs.getString("miryou_ziyuu")); // 미량 사유 설정 / 未量理由を設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard06; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}
