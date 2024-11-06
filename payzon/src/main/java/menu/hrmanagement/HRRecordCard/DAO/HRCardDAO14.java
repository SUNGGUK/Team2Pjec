package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard14;

public class HRCardDAO14 {

    public List<HRCard14> getAllHRCards14() {
        List<HRCard14> hrCardList14 = new ArrayList<>();

        String sql = "SELECT * FROM shain_touroku"; // 사원 등록 테이블에서 모든 레코드를 선택하는 SQL 쿼리 / 社員登録テーブルからすべてのレコードを選択するSQLクエリ

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard14 hrCard14 = new HRCard14();

                hrCard14.setShain_ID(rs.getInt("shain_ID")); // 사원번호 설정 / 社員番号を設定
                hrCard14.setKoyou_keitai(rs.getString("koyou_keitai")); // 고용 형태 설정 / 雇用形態を設定
                hrCard14.setShain_namae(rs.getString("shain_namae")); // 성명(일어) 설정 / 氏名(日本語)を設定
                hrCard14.setShain_eigo_namae(rs.getString("shain_eigo_namae")); // 성명(영어) 설정 / 氏名(英語)を設定
                hrCard14.setNyuusha_bi(rs.getDate("nyuusha_bi")); // 입사일 설정 / 入社日を設定
                hrCard14.setTaisha_bi(rs.getDate("taisha_bi")); // 퇴사일 설정 / 退社日を設定
                hrCard14.setBu(rs.getString("bu")); // 부서 설정 / 部署を設定
                hrCard14.setYakushoku(rs.getString("yakushoku")); // 직위 설정 / 役職を設定
                hrCard14.setZyuumin_bangou(rs.getString("zyuumin_bangou")); // 주민등록번호 설정 / 住民登録番号を設定
                hrCard14.setZyuusho(rs.getString("zyuusho")); // 주소 설정 / 住所を設定
                hrCard14.setDenwa_bangou(rs.getString("denwa_bangou")); // 전화번호 설정 / 電話番号を設定
                hrCard14.setKeitai_bangou(rs.getString("keitai_bangou")); // 휴대전화번호 설정 / 携帯電話番号を設定
                hrCard14.setMeiru_adoresu(rs.getString("meiru_adoresu")); // 이메일 주소 설정 / メールアドレスを設定

                hrCardList14.add(hrCard14); // 리스트에 HRCard 추가 / リストにHRCardを追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList14; // 전체 HR 카드 목록 반환 / 全HRカードリストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard14 getHRCardById(int shain_Id) {
        HRCard14 hrCard14 = null;
        String sql = "SELECT * FROM shain_touroku WHERE shain_ID = ?"; // 특정 사원 ID를 사용하여 사원 정보를 조회하는 SQL 쿼리 / 特定社員IDを使用して社員情報を照会するSQLクエリ
        
        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard14 = new HRCard14();

                hrCard14.setShain_ID(rs.getInt("shain_ID")); // 사원번호 설정 / 社員番号を設定
                hrCard14.setKoyou_keitai(rs.getString("koyou_keitai")); // 고용 형태 설정 / 雇用形態を設定
                hrCard14.setShain_namae(rs.getString("shain_namae")); // 성명(일어) 설정 / 氏名(日本語)を設定
                hrCard14.setShain_eigo_namae(rs.getString("shain_eigo_namae")); // 성명(영어) 설정 / 氏名(英語)を設定
                hrCard14.setNyuusha_bi(rs.getDate("nyuusha_bi")); // 입사일 설정 / 入社日を設定
                hrCard14.setTaisha_bi(rs.getDate("taisha_bi")); // 퇴사일 설정 / 退社日を設定
                hrCard14.setBu(rs.getString("bu")); // 부서 설정 / 部署を設定
                hrCard14.setYakushoku(rs.getString("yakushoku")); // 직위 설정 / 役職を設定
                hrCard14.setZyuumin_bangou(rs.getString("zyuumin_bangou")); // 주민등록번호 설정 / 住民登録番号を設定
                hrCard14.setZyuusho(rs.getString("zyuusho")); // 주소 설정 / 住所を設定
                hrCard14.setDenwa_bangou(rs.getString("denwa_bangou")); // 전화번호 설정 / 電話番号を設定
                hrCard14.setKeitai_bangou(rs.getString("keitai_bangou")); // 휴대전화번호 설정 / 携帯電話番号を設定
                hrCard14.setMeiru_adoresu(rs.getString("meiru_adoresu")); // 이메일 주소 설정 / メールアドレスを設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard14; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}