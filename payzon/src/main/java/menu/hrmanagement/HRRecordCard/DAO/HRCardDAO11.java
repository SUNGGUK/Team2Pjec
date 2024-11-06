package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard11;

public class HRCardDAO11 {

    public List<HRCard11> getAllHRCards11() {
        List<HRCard11> hrCardList11 = new ArrayList<>();

        String sql = "SELECT * FROM hatsurei";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard11 hrCard11 = new HRCard11();

                hrCard11.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard11.setHatsurei_kubun(rs.getString("hatsurei_kubun")); // 발령 구분 설정 / 発令区分を設定
                hrCard11.setHatsurei_bi(rs.getDate("hatsurei_bi")); // 발령일 설정 / 発令日を設定
                hrCard11.setBu(rs.getString("bu")); // 부서 설정 / 部署を設定
                hrCard11.setYakushoku_mei(rs.getString("yakushoku_mei")); // 직책 이름 설정 / 役職名を設定
                hrCard11.setShokumu_mei(rs.getString("shokumu_mei")); // 직무 이름 설정 / 職務名を設定
                hrCard11.setBikou(rs.getString("bikou")); // 비고 설정 / 備考を設定

                hrCardList11.add(hrCard11); // 리스트에 HRCard 추가 / リストにHRCardを追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList11; // 전체 HR 카드 목록 반환 / 全HRカードリストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard11 getHRCardById(int shain_Id) {
        HRCard11 hrCard11 = null;
        String sql = "SELECT * FROM hatsurei WHERE shain_ID = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard11 = new HRCard11();

                hrCard11.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard11.setHatsurei_kubun(rs.getString("hatsurei_kubun")); // 발령 구분 설정 / 発令区分を設定
                hrCard11.setHatsurei_bi(rs.getDate("hatsurei_bi")); // 발령일 설정 / 発令日を設定
                hrCard11.setBu(rs.getString("bu")); // 부서 설정 / 部署を設定
                hrCard11.setYakushoku_mei(rs.getString("yakushoku_mei")); // 직책 이름 설정 / 役職名を設定
                hrCard11.setShokumu_mei(rs.getString("shokumu_mei")); // 직무 이름 설정 / 職務名を設定
                hrCard11.setBikou(rs.getString("bikou")); // 비고 설정 / 備考を設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard11; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}