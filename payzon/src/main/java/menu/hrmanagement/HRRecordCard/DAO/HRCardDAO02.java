package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard02;

public class HRCardDAO02 {

    public List<HRCard02> getAllHRCards02() {
        List<HRCard02> hrCardList02 = new ArrayList<>();

        String sql = "SELECT * FROM shain_touroku";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard02 hrCard02 = new HRCard02();

                hrCard02.setShain_ID(rs.getInt("shain_ID")); // 사원번호 설정 / 社員番号を設定
                hrCard02.setKoyou_keitai(rs.getString("koyou_keitai")); // 고용형태 설정 / 雇用形態を設定
                hrCard02.setShain_namae(rs.getString("shain_namae")); // 성명(일어) 설정 / 名前（日本語）を設定
                hrCard02.setShain_eigo_namae(rs.getString("shain_eigo_namae")); // 성명(영어) 설정 / 名前（英語）を設定
                hrCard02.setNyuusha_bi(rs.getDate("nyuusha_bi")); // 입사일 설정 / 入社日を設定
                hrCard02.setTaisha_bi(rs.getDate("taisha_bi")); // 퇴사일 설정 / 退社日を設定
                hrCard02.setBu(rs.getString("bu")); // 부서 설정 / 部署を設定
                hrCard02.setYakushoku(rs.getString("yakushoku")); // 직위 설정 / 職位を設定
                hrCard02.setZyuumin_bangou(rs.getString("zyuumin_bangou")); // 주민등록번호 설정 / 住民番号を設定
                hrCard02.setZyuusho(rs.getString("zyuusho")); // 주소 설정 / 住所を設定
                hrCard02.setDenwa_bangou(rs.getString("denwa_bangou")); // 전화번호 설정 / 電話番号を設定
                hrCard02.setKeitai_bangou(rs.getString("keitai_bangou")); // 휴대전화번호 설정 / 携帯電話番号を設定
                hrCard02.setMeiru_adoresu(rs.getString("meiru_adoresu")); // 이메일 주소 설정 / メールアドレスを設定

                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
                hrCardList02.add(hrCard02);
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList02; // 전체 직원 목록 반환 / 全社員リストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard02 getHRCardById(int shain_Id) {
        HRCard02 hrCard02 = null;
        String sql = "SELECT * FROM shain_touroku WHERE shain_ID = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard02 = new HRCard02();

                hrCard02.setShain_ID(rs.getInt("shain_ID")); // 사원번호 설정 / 社員番号を設定
                hrCard02.setKoyou_keitai(rs.getString("koyou_keitai")); // 고용형태 설정 / 雇用形態を設定
                hrCard02.setShain_namae(rs.getString("shain_namae")); // 성명(일어) 설정 / 名前（日本語）を設定
                hrCard02.setShain_eigo_namae(rs.getString("shain_eigo_namae")); // 성명(영어) 설정 / 名前（英語）を設定
                hrCard02.setNyuusha_bi(rs.getDate("nyuusha_bi")); // 입사일 설정 / 入社日を設定
                hrCard02.setTaisha_bi(rs.getDate("taisha_bi")); // 퇴사일 설정 / 退社日を設定
                hrCard02.setBu(rs.getString("bu")); // 부서 설정 / 部署を設定
                hrCard02.setYakushoku(rs.getString("yakushoku")); // 직위 설정 / 職位を設定
                hrCard02.setZyuumin_bangou(rs.getString("zyuumin_bangou")); // 주민등록번호 설정 / 住民番号を設定
                hrCard02.setZyuusho(rs.getString("zyuusho")); // 주소 설정 / 住所を設定
                hrCard02.setDenwa_bangou(rs.getString("denwa_bangou")); // 전화번호 설정 / 電話番号を設定
                hrCard02.setKeitai_bangou(rs.getString("keitai_bangou")); // 휴대전화번호 설정 / 携帯電話番号を設定
                hrCard02.setMeiru_adoresu(rs.getString("meiru_adoresu")); // 이메일 주소 설정 / メールアドレスを設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard02; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}