package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard12;

public class HRCardDAO12 {

    public List<HRCard12> getAllHRCards12() {
        List<HRCard12> hrCardList12 = new ArrayList<>();

        String sql = "SELECT * FROM taishoku"; // 퇴직 테이블에서 모든 레코드를 선택하는 SQL 쿼리 / 退職テーブルからすべてのレコードを選択するSQLクエリ

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard12 hrCard12 = new HRCard12();

                hrCard12.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard12.setTaishoku_kubun(rs.getString("taishoku_kubun")); // 퇴직 구분 설정 / 退職区分を設定
                hrCard12.setTaishoku_bi(rs.getDate("taishoku_bi")); // 퇴직일 설정 / 退職日を設定
                hrCard12.setTaishoku_ziyuu(rs.getString("taishoku_ziyuu")); // 퇴직 사유 설정 / 退職理由を設定
                hrCard12.setTaishoku_go_renrakusaki(rs.getString("taishoku_go_renrakusaki")); // 퇴직 후 연락처 설정 / 退職後連絡先を設定
                hrCard12.setTaishoku_kin(rs.getInt("taishoku_kin")); // 퇴직금 설정 / 退職金を設定

                hrCardList12.add(hrCard12); // 리스트에 HRCard 추가 / リストにHRCardを追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList12; // 전체 HR 카드 목록 반환 / 全HRカードリストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard12 getHRCardById(int shain_Id) {
        HRCard12 hrCard12 = null;
        String sql = "SELECT * FROM taishoku WHERE shain_ID = ?"; // 특정 사원 ID를 사용하여 퇴직 정보를 조회하는 SQL 쿼리 / 特定社員IDを使用して退職情報を照会するSQLクエリ
        
        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard12 = new HRCard12();

                hrCard12.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard12.setTaishoku_kubun(rs.getString("taishoku_kubun")); // 퇴직 구분 설정 / 退職区分を設定
                hrCard12.setTaishoku_bi(rs.getDate("taishoku_bi")); // 퇴직일 설정 / 退職日を設定
                hrCard12.setTaishoku_ziyuu(rs.getString("taishoku_ziyuu")); // 퇴직 사유 설정 / 退職理由を設定
                hrCard12.setTaishoku_go_renrakusaki(rs.getString("taishoku_go_renrakusaki")); // 퇴직 후 연락처 설정 / 退職後連絡先を設定
                hrCard12.setTaishoku_kin(rs.getInt("taishoku_kin")); // 퇴직금 설정 / 退職金を設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard12; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}