package menu.BasicSettings.VacationSettings.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.VacationSettings.model.kintai_koumoku_settei;

// 근태 항목 설정 DAO 클래스
// 勤怠項目設定DAOクラス
public class kintai_koumoku_setteiDao {

    // 새로운 근태 항목을 데이터베이스에 삽입하는 메서드
    // 新しい勤怠項目をデータベースに挿入するメソッド
    public kintai_koumoku_settei insert(Connection conn, kintai_koumoku_settei kintaiKoumokuSettei) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            // SQL 삽입 쿼리 정의
            // SQL挿入クエリを定義
            String insertQuery = "INSERT INTO kintai_koumoku_settei (kintai_ID, kintai_shurui, kouzyo_kisoku, tani, shiyou_kanou_umu) VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(insertQuery);

            // 각 파라미터 설정
            // 各パラメータを設定
            pstmt.setInt(1, kintaiKoumokuSettei.getKintai_ID());
            pstmt.setString(2, kintaiKoumokuSettei.getKintai_shurui());
            pstmt.setString(3, kintaiKoumokuSettei.getKouzyo_kisoku());
            pstmt.setString(4, kintaiKoumokuSettei.getTani());
            pstmt.setString(5, String.valueOf(kintaiKoumokuSettei.getShiyou_kanou_umu()));

            // SQL 실행 및 삽입 확인
            // SQLを実行し、挿入を確認
            int insertedCount = pstmt.executeUpdate();

            if (insertedCount > 0) {
                return kintaiKoumokuSettei; // 성공 시 객체 반환
                // 成功時、オブジェクトを返す
            } else {
                return null; // 실패 시 null 반환
                // 失敗時、nullを返す
            }
        } finally {
            JdbcUtil.close(rs); // ResultSet 리소스 해제
            // ResultSetリソースを解放
            JdbcUtil.close(pstmt); // PreparedStatement 리소스 해제
            // PreparedStatementリソースを解放
        }
    }
}
