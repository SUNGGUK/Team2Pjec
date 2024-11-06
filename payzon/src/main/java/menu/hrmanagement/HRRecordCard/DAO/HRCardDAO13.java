package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard13;

public class HRCardDAO13 {

    public List<HRCard13> getAllHRCards13() {
        List<HRCard13> hrCardList13 = new ArrayList<>();

        String sql = "SELECT * FROM stanpu_henkou_rireki"; // 스탬프 변경 이력 테이블에서 모든 레코드를 선택하는 SQL 쿼리 / スタンプ変更履歴テーブルからすべてのレコードを選択するSQLクエリ

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard13 hrCard13 = new HRCard13();

                hrCard13.setRireki_id(rs.getInt("rireki_id")); // 이력 ID 설정 / 履歴IDを設定
                hrCard13.setStanpu_shubetsu(rs.getString("stanpu_shubetsu")); // 스탬프 종류 설정 / スタンプ種別を設定

                hrCardList13.add(hrCard13); // 리스트에 HRCard 추가 / リストにHRCardを追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList13; // 전체 HR 카드 목록 반환 / 全HRカードリストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard13 getHRCardById(int shain_Id) {
        HRCard13 hrCard13 = null;
        String sql = "SELECT * FROM stanpu_henkou_rireki WHERE shain_ID = ?"; // 특정 사원 ID를 사용하여 스탬프 변경 이력을 조회하는 SQL 쿼리 / 特定社員IDを使用してスタンプ変更履歴を照会するSQLクエリ
        
        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard13 = new HRCard13();

                hrCard13.setRireki_id(rs.getInt("rireki_id")); // 이력 ID 설정 / 履歴IDを設定
                hrCard13.setStanpu_shubetsu(rs.getString("stanpu_shubetsu")); // 스탬프 종류 설정 / スタンプ種別を設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard13; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}