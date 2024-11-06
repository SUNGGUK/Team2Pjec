package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard01;

public class HRCardDAO01 {

    public List<HRCard01> getAllHRCards01() {
        List<HRCard01> hrCardList01 = new ArrayList<>();

        String sql = "SELECT * FROM kaisha_zyouhou";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard01 hrCard01 = new HRCard01();

                hrCard01.setKaisha_mei(rs.getString("kaisha_mei")); // 회사명 설정 / 会社名を設定
                hrCard01.setShachou_yakushoku(rs.getString("shachou_yakushoku")); // 사장 직책 설정 / 社長職を設定
                hrCard01.setShachou_mei(rs.getString("shachou_mei")); // 사장명 설정 / 社長名を設定
                hrCard01.setZigyou_bangou(rs.getInt("zigyou_bangou")); // 사업번호 설정 / 事業番号を設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
                hrCardList01.add(hrCard01);
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList01; // 전체 직원 목록 반환 / 全社員リストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard01 getHRCardById(int shain_Id) {
        HRCard01 hrCard01 = null;
        String sql = "SELECT * FROM kaisha_zyouhou WHERE kaisha_mei = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard01 = new HRCard01();

                hrCard01.setKaisha_mei(rs.getString("kaisha_mei")); // 회사명 설정 / 会社名を設定
                hrCard01.setShachou_yakushoku(rs.getString("shachou_yakushoku")); // 사장 직책 설정 / 社長職を設定
                hrCard01.setShachou_mei(rs.getString("shachou_mei")); // 사장명 설정 / 社長名を設定
                hrCard01.setZigyou_bangou(rs.getInt("zigyou_bangou")); // 사업번호 설정 / 事業番号を設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard01; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}