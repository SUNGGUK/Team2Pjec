package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard10;

public class HRCardDAO10 {

    public List<HRCard10> getAllHRCards10() {
        List<HRCard10> hrCardList10 = new ArrayList<>();

        String sql = "SELECT * FROM shoubatsu";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard10 hrCard10 = new HRCard10();

                hrCard10.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard10.setShoubatsu_kubun(rs.getString("shoubatsu_kubun")); // 처분 구분 설정 / 処分区分を設定
                hrCard10.setShoubatsu_mei(rs.getString("shoubatsu_mei")); // 처분 이름 설정 / 処分名を設定
                hrCard10.setKantoku_kikan(rs.getString("kantoku_kikan")); // 감독 기관 설정 / 監督機関を設定
                hrCard10.setShoubatsu_bi(rs.getDate("shoubatsu_bi")); // 처분일 설정 / 処分日を設定
                hrCard10.setNaiyou(rs.getString("naiyou")); // 내용 설정 / 内容を設定
                hrCard10.setBikou(rs.getString("bikou")); // 비고 설정 / 備考を設定

                hrCardList10.add(hrCard10); // 리스트에 HRCard 추가 / リストにHRCardを追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList10; // 전체 HR 카드 목록 반환 / 全HRカードリストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard10 getHRCardById(int shain_Id) {
        HRCard10 hrCard10 = null;
        String sql = "SELECT * FROM shoubatsu WHERE shain_ID = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard10 = new HRCard10();

                hrCard10.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard10.setShoubatsu_kubun(rs.getString("shoubatsu_kubun")); // 처분 구분 설정 / 処分区分を設定
                hrCard10.setShoubatsu_mei(rs.getString("shoubatsu_mei")); // 처분 이름 설정 / 処分名を設定
                hrCard10.setKantoku_kikan(rs.getString("kantoku_kikan")); // 감독 기관 설정 / 監督機関を設定
                hrCard10.setShoubatsu_bi(rs.getDate("shoubatsu_bi")); // 처분일 설정 / 処分日を設定
                hrCard10.setNaiyou(rs.getString("naiyou")); // 내용 설정 / 内容を設定
                hrCard10.setBikou(rs.getString("bikou")); // 비고 설정 / 備考を設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard10; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}