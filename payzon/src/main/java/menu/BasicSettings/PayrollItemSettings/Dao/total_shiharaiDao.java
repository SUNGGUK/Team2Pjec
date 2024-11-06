package menu.BasicSettings.PayrollItemSettings.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.PayrollItemSettings.model.total_shiharai;

//-- 21. 지급항목 테이블 (total_shiharai)
//-- 21. 支給項目テーブル (total_shiharai)
public class total_shiharaiDao {

    /**
     * 지급항목 정보를 데이터베이스에 삽입하는 메서드
     * 支給項目情報をデータベースに挿入するメソッド
     * 
     * @param conn 데이터베이스 연결 객체 / データベース接続オブジェクト
     * @param totalShiharai 삽입할 지급항목 객체 / 挿入する支給項目オブジェクト
     * @return 삽입된 지급항목 객체 또는 null / 挿入された支給項目オブジェクトまたはnull
     * @throws SQLException 데이터베이스 처리 중 발생할 수 있는 예외 / データベース処理中に発生する可能性のある例外
     */
    public total_shiharai insert(Connection conn, total_shiharai totalShiharai) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String insertQuery = "INSERT INTO total_shiharai (total_kingaku, shikyuuzoukyuu, kihonkyu, shokujitane, hoikutane, yakushokutane, sharyouijihi, kinzokutane, touchakutane, shouyo, kyuujitsutane, kazei_umu, zessa_tani, kintai_ikkatsu, ikkatsu_shikyuugaku, shiyou_umu, keisan_houhou) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, totalShiharai.getTotal_kingaku()); // 총 금액 설정 / 総金額設定
            pstmt.setInt(2, totalShiharai.getShikyuuzoukyuu()); // 지급 증가액 설정 / 支給増給設定
            pstmt.setInt(3, totalShiharai.getKihonkyu()); // 기본급 설정 / 基本給設定
            pstmt.setInt(4, totalShiharai.getShokujitane()); // 식비 설정 / 食事手当設定
            pstmt.setInt(5, totalShiharai.getHoikutane()); // 보육 수당 설정 / 保育手当設定
            pstmt.setInt(6, totalShiharai.getYakushokutane()); // 직책 수당 설정 / 役職手当設定
            pstmt.setInt(7, totalShiharai.getSharyouijihi()); // 차량 유지비 설정 / 車両維持費設定
            pstmt.setInt(8, totalShiharai.getKinzokutane()); // 근속 수당 설정 / 勤続手当設定
            pstmt.setInt(9, totalShiharai.getTouchakutane()); // 도착 수당 설정 / 到着手当設定
            pstmt.setInt(10, totalShiharai.getShouyo()); // 상여금 설정 / 賞与設定
            pstmt.setInt(11, totalShiharai.getKyuujitsutane()); // 휴일 수당 설정 / 休日手当設定
            pstmt.setString(12, totalShiharai.getKazei_umu()); // 과세 여부 설정 / 課税有無設定
            pstmt.setString(13, totalShiharai.getZessa_tani()); // 절세 단위 설정 / 節税単位設定
            pstmt.setString(14, totalShiharai.getKintai_ikkatsu()); // 근태 일괄 설정 / 勤怠一括設定
            pstmt.setInt(15, totalShiharai.getIkkatsu_shikyuugaku()); // 일괄 지급액 설정 / 一括支給額設定
            pstmt.setString(16, String.valueOf(totalShiharai.getShiyou_umu())); // 사용 여부 설정 / 使用有無設定
            pstmt.setString(17, totalShiharai.getKeisan_houhou()); // 계산 방법 설정 / 計算方法設定

            int insertedCount = pstmt.executeUpdate();

            if (insertedCount > 0) {
                return totalShiharai; // 삽입된 지급항목 반환 / 挿入された支給項目を返す
            } else {
                return null; // 삽입 실패 시 null 반환 / 挿入失敗時はnullを返す
            }
        } finally {
            JdbcUtil.close(rs); // ResultSet 리소스 해제 / ResultSet リソース解放
            JdbcUtil.close(pstmt); // PreparedStatement 리소스 해제 / PreparedStatement リソース解放
        }
    }
}
