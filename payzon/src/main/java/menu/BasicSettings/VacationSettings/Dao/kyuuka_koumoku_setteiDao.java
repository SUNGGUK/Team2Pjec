package menu.BasicSettings.VacationSettings.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.VacationSettings.model.kyuuka_koumoku_settei;

// 휴가 항목 설정 DAO 클래스
// 休暇項目設定DAOクラス
public class kyuuka_koumoku_setteiDao {

    // 데이터베이스에 새로운 휴가 항목을 삽입하는 메서드
    // データベースに新しい休暇項目を挿入するメソッド
    public kyuuka_koumoku_settei insert(Connection conn, kyuuka_koumoku_settei kyuuka) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            // SQL 문 정의: kyuuka_koumoku_settei 테이블에 데이터를 삽입
            // SQL文を定義: kyuuka_koumoku_settei テーブルにデータを挿入
            String sql = "INSERT INTO kyuuka_koumoku_settei (kyuuka_ID, kyuuka_shurui, tekiyou_kikan, kyuuka_nissuu, shiyou_kanou_umu) " +
                         "VALUES (?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            
            // 각 파라미터 설정
            // 各パラメータを設定
            pstmt.setInt(1, kyuuka.getKyuuka_ID());
            pstmt.setString(2, kyuuka.getKyuuka_shurui());
            pstmt.setDate(3, kyuuka.getTekiyou_kikan());
            pstmt.setInt(4, kyuuka.getKyuuka_nissuu());
            pstmt.setString(5, String.valueOf(kyuuka.getShiyou_kanou_umu()));

            // SQL 실행 및 영향받은 행 확인
            // SQLを実行し、影響を受けた行を確認
            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return kyuuka; // 삽입 성공 시 객체 반환
                // 挿入成功時、オブジェクトを返す
            } else {
                return null; // 실패 시 null 반환
                // 失敗時にnullを返す
            }
        } finally {
            JdbcUtil.close(pstmt); // PreparedStatement 리소스 해제
            // PreparedStatementリソースを解放
        }
    }
}
