package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard07;

public class HRCardDAO07 {

    public List<HRCard07> getAllHRCards07() {
        List<HRCard07> hrCardList07 = new ArrayList<>();

        String sql = "SELECT * FROM keireki_zyouhou";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard07 hrCard07 = new HRCard07();

                hrCard07.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard07.setKaisha_mei(rs.getString("kaisha_mei")); // 회사명 설정 / 会社名を設定
                hrCard07.setNyuusha_bi(rs.getDate("nyuusha_bi")); // 입사일 설정 / 入社日を設定
                hrCard07.setTaishoku_bi(rs.getDate("taishoku_bi")); // 퇴사일 설정 / 退社日を設定
                hrCard07.setSaishuu_yakushoku(rs.getString("saishuu_yakushoku")); // 최종 직책 설정 / 最終役職を設定
                hrCard07.setTantou_shokumu(rs.getString("tantou_shokumu")); // 담당 직무 설정 / 担当職務を設定

                hrCardList07.add(hrCard07); // 리스트에 HRCard 추가 / リストにHRCardを追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList07; // 전체 HR 카드 목록 반환 / 全HRカードリストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard07 getHRCardById(int shain_Id) {
        HRCard07 hrCard07 = null;
        String sql = "SELECT * FROM keireki_zyouhou WHERE shain_ID = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard07 = new HRCard07();

                hrCard07.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard07.setKaisha_mei(rs.getString("kaisha_mei")); // 회사명 설정 / 会社名を設定
                hrCard07.setNyuusha_bi(rs.getDate("nyuusha_bi")); // 입사일 설정 / 入社日を設定
                hrCard07.setTaishoku_bi(rs.getDate("taishoku_bi")); // 퇴사일 설정 / 退社日を設定
                hrCard07.setSaishuu_yakushoku(rs.getString("saishuu_yakushoku")); // 최종 직책 설정 / 最終役職を設定
                hrCard07.setTantou_shokumu(rs.getString("tantou_shokumu")); // 담당 직무 설정 / 担当職務を設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard07; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}
