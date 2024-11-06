package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard04;

public class HRCardDAO04 {

    public List<HRCard04> getAllHRCards04() {
        List<HRCard04> hrCardList04 = new ArrayList<>();

        String sql = "SELECT * FROM shidai_hoken_zyouhou";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard04 hrCard04 = new HRCard04();

                hrCard04.setHoken_ID(rs.getInt("hoken_ID")); // 보험 ID 설정 / 保険IDを設定
                hrCard04.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard04.setHoken_shurui(rs.getString("hoken_shurui")); // 보험 종류 설정 / 保険種類を設定
                hrCard04.setTouroku_bangou(rs.getNString("touroku_bangou")); // 등록 번호 설정 / 登録番号を設定
                hrCard04.setShutoku_bi(rs.getDate("shutoku_bi")); // 취득일 설정 / 取得日を設定
                hrCard04.setSousitsu_bi(rs.getDate("sousitsu_bi")); // 소실일 설정 / 喪失日を設定

                hrCardList04.add(hrCard04); // 리스트에 HRCard 추가 / リストにHRCardを追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList04; // 전체 HR 카드 목록 반환 / 全HRカードリストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard04 getHRCardById(int shain_Id) {
        HRCard04 hrCard04 = null;
        String sql = "SELECT * FROM shidai_hoken_zyouhou WHERE shain_ID = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard04 = new HRCard04();

                hrCard04.setHoken_ID(rs.getInt("hoken_ID")); // 보험 ID 설정 / 保険IDを設定
                hrCard04.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard04.setHoken_shurui(rs.getString("hoken_shurui")); // 보험 종류 설정 / 保険種類を設定
                hrCard04.setTouroku_bangou(rs.getNString("touroku_bangou")); // 등록 번호 설정 / 登録番号を設定
                hrCard04.setShutoku_bi(rs.getDate("shutoku_bi")); // 취득일 설정 / 取得日を設定
                hrCard04.setSousitsu_bi(rs.getDate("sousitsu_bi")); // 소실일 설정 / 喪失日を設定
                
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard04; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}