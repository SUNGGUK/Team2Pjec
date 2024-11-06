package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard03;

public class HRCardDAO03 {

    public List<HRCard03> getAllHRCards03() {
        List<HRCard03> hrCardList03 = new ArrayList<>();

        String sql = "SELECT * FROM huyou_kazoku";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard03 hrCard03 = new HRCard03();

                hrCard03.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard03.setNamae(rs.getString("namae")); // 성명(일어) 설정 / 名前（日本語）を設定
                hrCard03.setKankei(rs.getString("kankei")); // 관계 설정 / 関係を設定
                hrCard03.setZyuumin_touroku_bangou(rs.getString("zyuumin_touroku_bangou")); // 주민등록번호 설정 / 住民登録番号を設定

                // 동거 여부를 boolean으로 변환하여 설정 / 同居の有無をbooleanに変換して設定
                String doukyoUmuValue = rs.getString("doukyo_umu");
                hrCard03.setDoukyo_umu("1".equals(doukyoUmuValue)); // 또는 "true".equalsIgnoreCase(doukyoUmuValue); / または "true".equalsIgnoreCase(doukyoUmuValue);
                
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
                hrCardList03.add(hrCard03);
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList03; // 전체 가족 목록 반환 / 全家族リストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard03 getHRCardById(int shain_Id) {
        HRCard03 hrCard03 = null;
        String sql = "SELECT * FROM huyou_kazoku WHERE shain_ID = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard03 = new HRCard03();

                hrCard03.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard03.setNamae(rs.getString("namae")); // 성명(일어) 설정 / 名前（日本語）を設定
                hrCard03.setKankei(rs.getString("kankei")); // 관계 설정 / 関係を設定
                hrCard03.setZyuumin_touroku_bangou(rs.getString("zyuumin_touroku_bangou")); // 주민등록번호 설정 / 住民登録番号を設定

                // 동거 여부를 boolean으로 변환하여 설정 / 同居の有無をbooleanに変換して設定
                String doukyoUmuValue = rs.getString("doukyo_umu");
                hrCard03.setDoukyo_umu("1".equals(doukyoUmuValue)); // 또는 "true".equalsIgnoreCase(doukyoUmuValue); / または "true".equalsIgnoreCase(doukyoUmuValue);
                
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard03; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}