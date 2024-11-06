package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard08;

public class HRCardDAO08 {

    public List<HRCard08> getAllHRCards08() {
        List<HRCard08> hrCardList08 = new ArrayList<>();

        String sql = "SELECT * FROM gogaku_nouryoku";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard08 hrCard08 = new HRCard08();

                hrCard08.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard08.setGaikokugo_mei(rs.getString("gaikokugo_mei")); // 외국어명 설정 / 外国語名を設定
                hrCard08.setShiken_mei(rs.getString("shiken_mei")); // 시험명 설정 / 試験名を設定
                hrCard08.setKounin_tensuu(rs.getInt("kounin_tensuu")); // 공인 점수 설정 / 公認点数を設定
                hrCard08.setShutoku_bi(rs.getDate("shutoku_bi")); // 취득일 설정 / 取得日を設定
                hrCard08.setDokkai(rs.getString("dokkai")); // 독해 설정 / 読解を設定
                hrCard08.setSakubun(rs.getString("sakubun")); // 작문 설정 / 作文を設定
                hrCard08.setKaiwa(rs.getString("kaiwa")); // 회화 설정 / 会話を設定

                hrCardList08.add(hrCard08); // 리스트에 HRCard 추가 / リストにHRCardを追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList08; // 전체 HR 카드 목록 반환 / 全HRカードリストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard08 getHRCardById(int shain_Id) {
        HRCard08 hrCard08 = null;
        String sql = "SELECT * FROM gogaku_nouryoku WHERE shain_ID = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard08 = new HRCard08();

                hrCard08.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard08.setGaikokugo_mei(rs.getString("gaikokugo_mei")); // 외국어명 설정 / 外国語名を設定
                hrCard08.setShiken_mei(rs.getString("shiken_mei")); // 시험명 설정 / 試験名を設定
                hrCard08.setKounin_tensuu(rs.getInt("kounin_tensuu")); // 공인 점수 설정 / 公認点数を設定
                hrCard08.setShutoku_bi(rs.getDate("shutoku_bi")); // 취득일 설정 / 取得日を設定
                hrCard08.setDokkai(rs.getString("dokkai")); // 독해 설정 / 読解を設定
                hrCard08.setSakubun(rs.getString("sakubun")); // 작문 설정 / 作文を設定
                hrCard08.setKaiwa(rs.getString("kaiwa")); // 회화 설정 / 会話を設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard08; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}