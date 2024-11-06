package menu.BasicSettings.PayrollItemSettings.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.PayrollItemSettings.model.total_kouzyo;

//-- 22. 공제항목 테이블 (total_kouzyo)
//-- 22. 控除項目テーブル (total_kouzyo)
public class total_kouzyoDao {

    /**
     * 공제항목 정보를 데이터베이스에 삽입하는 메서드
     * 控除項目情報をデータベースに挿入するメソッド
     * 
     * @param conn 데이터베이스 연결 객체 / データベース接続オブジェクト
     * @param totalKouzyo 삽입할 공제항목 객체 / 挿入する控除項目オブジェクト
     * @return 삽입된 공제항목 객체 또는 null / 挿入された控除項目オブジェクトまたはnull
     * @throws SQLException 데이터베이스 처리 중 발생할 수 있는 예외 / データベース処理中に発生する可能性のある例外
     */
    public total_kouzyo insert(Connection conn, total_kouzyo totalKouzyo) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String insertQuery = "INSERT INTO total_kouzyo (koujo_id, koujo_sougaku, shotokuzei, chiho_shotokuzei, koujokamoku, daibu_hoken, kikandani_shotokuzei, kokumin_nenkin, kenkou_hoken, choukikaigo_hoken, koyou_hoken, gojokaihi, zessa_tani, shiyou_umu, bikou, keisan_houhou) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, totalKouzyo.getKoujo_id()); // 공제 ID 설정 / 控除ID設定
            pstmt.setInt(2, totalKouzyo.getKoujo_sougaku()); // 공제 총액 설정 / 控除総額設定
            pstmt.setInt(3, totalKouzyo.getShotokuzei()); // 소득세 설정 / 所得税設定
            pstmt.setInt(4, totalKouzyo.getChiho_shotokuzei()); // 지방 소득세 설정 / 地方所得税設定
            pstmt.setInt(5, totalKouzyo.getKoujokamoku()); // 공제 과목 설정 / 控除科目設定
            pstmt.setInt(6, totalKouzyo.getDaibu_hoken()); // 대부 보험 설정 / 大部保険設定
            pstmt.setInt(7, totalKouzyo.getKikandani_shotokuzei()); // 기간 단위 소득세 설정 / 期間単位所得税設定
            pstmt.setInt(8, totalKouzyo.getKokumin_nenkin()); // 국민 연금 설정 / 国民年金設定
            pstmt.setInt(9, totalKouzyo.getKenkou_hoken()); // 건강 보험 설정 / 健康保険設定
            pstmt.setInt(10, totalKouzyo.getChoukikaigo_hoken()); // 장기 개호 보험 설정 / 長期介護保険設定
            pstmt.setInt(11, totalKouzyo.getKoyou_hoken()); // 고용 보험 설정 / 雇用保険設定
            pstmt.setInt(12, totalKouzyo.getGojokaihi()); // 후생 연합회비 설정 / 互助会費設定
            pstmt.setString(13, totalKouzyo.getZessa_tani()); // 절세 단위 설정 / 節税単位設定
            pstmt.setString(14, String.valueOf(totalKouzyo.getShiyou_umu())); // 사용 여부 설정 / 使用有無設定
            pstmt.setString(15, totalKouzyo.getBikou()); // 비고 설정 / 備考設定
            pstmt.setString(16, totalKouzyo.getKeisan_houhou()); // 계산 방법 설정 / 計算方法設定

            int insertedCount = pstmt.executeUpdate();

            if (insertedCount > 0) {
                return totalKouzyo; // 삽입된 공제항목 반환 / 挿入された控除項目を返す
            } else {
                return null; // 삽입 실패 시 null 반환 / 挿入失敗時はnullを返す
            }
        } finally {
            JdbcUtil.close(rs); // ResultSet 리소스 해제 / ResultSet リソース解放
            JdbcUtil.close(pstmt); // PreparedStatement 리소스 해제 / PreparedStatement リソース解放
        }
    }
}
