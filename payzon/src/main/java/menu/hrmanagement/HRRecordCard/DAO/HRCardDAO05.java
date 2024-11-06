package menu.hrmanagement.HRRecordCard.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.HRRecordCard.Model.HRCard05;

public class HRCardDAO05 {

    public List<HRCard05> getAllHRCards05() {
        List<HRCard05> hrCardList05 = new ArrayList<>();

        String sql = "SELECT * FROM gakureki_zyouhou";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                HRCard05 hrCard05 = new HRCard05();

                hrCard05.setGakureki_ID(rs.getInt("gakureki_ID")); // 학력 ID 설정 / 学歴IDを設定
                hrCard05.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard05.setGakkou_mei(rs.getString("gakkou_mei")); // 학교명 설정 / 学校名を設定
                hrCard05.setSenkou(rs.getString("senkou")); // 전공 설정 / 専攻を設定
                hrCard05.setNyuugaku_bi(rs.getDate("nyuugaku_bi")); // 입학일 설정 / 入学日を設定
                hrCard05.setSotsugyou_bi(rs.getDate("sotsugyou_bi")); // 졸업일 설정 / 卒業日を設定
                hrCard05.setSotsugyou_umu(rs.getString("sotsugyou_umu")); // 졸업 여부 설정 / 卒業有無を設定

                hrCardList05.add(hrCard05); // 리스트에 HRCard 추가 / リストにHRCardを追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCardList05; // 전체 HR 카드 목록 반환 / 全HRカードリストを返す
    }

    // shain_ID를 사용하여 특정 사원 정보를 조회하는 메서드 / shain_IDを使用して特定社員情報を照会するメソッド
    public HRCard05 getHRCardById(int shain_Id) {
        HRCard05 hrCard05 = null;
        String sql = "SELECT * FROM gakureki_zyouhou WHERE shain_ID = ?";

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shain_Id); // shain_ID를 쿼리에 설정 / shain_IDをクエリに設定
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                hrCard05 = new HRCard05();

                hrCard05.setGakureki_ID(rs.getInt("gakureki_ID")); // 학력 ID 설정 / 学歴IDを設定
                hrCard05.setShain_ID(rs.getInt("shain_ID")); // 사원 ID 설정 / 社員IDを設定
                hrCard05.setGakkou_mei(rs.getString("gakkou_mei")); // 학교명 설정 / 学校名を設定
                hrCard05.setSenkou(rs.getString("senkou")); // 전공 설정 / 専攻を設定
                hrCard05.setNyuugaku_bi(rs.getDate("nyuugaku_bi")); // 입학일 설정 / 入学日を設定
                hrCard05.setSotsugyou_bi(rs.getDate("sotsugyou_bi")); // 졸업일 설정 / 卒業日を設定
                hrCard05.setSotsugyou_umu(rs.getString("sotsugyou_umu")); // 졸업 여부 설정 / 卒業有無を設定
                // 추가적인 필드 설정이 필요한 경우 여기에 추가 / 追加的なフィールド設定が必要な場合ここに追加
            }
        } catch (Exception e) {
            e.printStackTrace(); // 예외 발생 시 스택 트레이스 출력 / 例外が発生した場合、スタックトレースを出力
        }

        return hrCard05; // 사원 정보가 없으면 null을 반환 / 社員情報がない場合はnullを返す
    }
}