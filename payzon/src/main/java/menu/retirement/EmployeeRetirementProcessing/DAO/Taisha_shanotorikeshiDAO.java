package menu.retirement.EmployeeRetirementProcessing.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import menu.retirement.EmployeeRetirementProcessing.Model.Taisha_shanotorikeshi;

public class Taisha_shanotorikeshiDAO {

    // 특정 사원의 퇴직 정보를 조회하는 메서드
    // 特定社員の退職情報を取得するメソッド
    public Taisha_shanotorikeshi getTaishaShanotorikeshi(Connection conn, int shainId) throws SQLException {
        // 특정 사원의 퇴직 정보를 조회하기 위한 SQL 쿼리
        // 特定社員の退職情報を取得するためのSQLクエリ
        String sql = "SELECT * FROM taishoku WHERE shain_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 입력받은 shainId가 잘 설정되었는지 확인하는 로그
            // 入力されたshainIdが正しく設定されているか確認するログ
            System.out.println("Shain ID: " + shainId);
            
            // 쿼리의 첫 번째 파라미터로 shain_id 값을 설정
            // クエリの最初のパラメータにshain_idの値を設定
            pstmt.setInt(1, shainId); 
            try (ResultSet rs = pstmt.executeQuery()) {
                // 결과가 존재하면 Taisha_shanotorikeshi 객체를 생성해 반환
                // 結果が存在する場合はTaisha_shanotorikeshiオブジェクトを作成して返す
                if (rs.next()) {
                    return new Taisha_shanotorikeshi(
                        rs.getInt("shain_id"),
                        rs.getString("taishoku_kubun"),
                        rs.getDate("taishoku_bi"),
                        rs.getString("taishoku_ziyuu"),
                        rs.getString("taishoku_go_renrakusaki")
                    );
                } else {
                    // 해당 사원 ID가 데이터베이스에 없을 경우 메시지 출력 후 null 반환
                    // 該当する社員IDがデータベースに存在しない場合はメッセージを出力し、nullを返す
                    System.out.println("データベースに社員IDが存在しません。");
                    return null;
                }
            }
        } catch (SQLException e) {
            // 예외 발생 시 로그를 출력하고 예외를 다시 던짐
            // 例外発生時にログを出力し、例外を再度投げる
            System.out.println("DAO: 取得中にエラーが発生しました - " + e.getMessage());
            throw e;
        }
    }

    // 퇴직 정보를 삽입하는 메서드
    // 退職情報を挿入するメソッド
    public void insertTaishaShanotorikeshi(Connection conn, Taisha_shanotorikeshi taishaShanotorikeshi) throws SQLException {
        // 새로운 퇴직 정보를 추가하기 위한 SQL 쿼리
        // 新しい退職情報を追加するためのSQLクエリ
        String sql = "INSERT INTO taishoku (shain_id, taishoku_kubun, taishoku_bi, taishoku_ziyuu, taishoku_go_renrakusaki) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 각 필드에 대한 파라미터 설정
            // 各フィールドに対するパラメータの設定
            pstmt.setInt(1, taishaShanotorikeshi.getShain_ID()); // 사원 ID / 社員ID
            pstmt.setString(2, taishaShanotorikeshi.getTaishoku_kubun()); // 퇴직 구분 / 退職区分
            pstmt.setDate(3, new java.sql.Date(taishaShanotorikeshi.getTaishoku_bi().getTime())); // 퇴직일 / 退職日
            pstmt.setString(4, taishaShanotorikeshi.getTaishoku_ziyuu()); // 퇴직 사유 / 退職理由
            pstmt.setString(5, taishaShanotorikeshi.getTaishoku_go_renrakusaki()); // 퇴직 후 연락처 / 退職後の連絡先
            pstmt.executeUpdate(); // 데이터베이스에 쿼리 실행 / データベースにクエリを実行
        }
    }

    // 특정 사원의 퇴직 정보를 업데이트하는 메서드
    // 特定社員の退職情報を更新するメソッド
    public boolean updateTaishaShanotorikeshi(Connection conn, Taisha_shanotorikeshi taishaShanotorikeshi) throws SQLException {
        // 퇴직 정보를 업데이트하기 위한 SQL 쿼리
        // 退職情報を更新するためのSQLクエリ
        String sql = "UPDATE taishoku SET taishoku_kubun = ?, taishoku_bi = ?, taishoku_ziyuu = ?, taishoku_go_renrakusaki = ? WHERE shain_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            // 각 필드에 대한 파라미터 설정
            // 各フィールドに対するパラメータの設定
            pstmt.setString(1, taishaShanotorikeshi.getTaishoku_kubun()); // 퇴직 구분 / 退職区分
            pstmt.setDate(2, new java.sql.Date(taishaShanotorikeshi.getTaishoku_bi().getTime())); // 퇴직일 / 退職日
            pstmt.setString(3, taishaShanotorikeshi.getTaishoku_ziyuu()); // 퇴직 사유 / 退職理由
            pstmt.setString(4, taishaShanotorikeshi.getTaishoku_go_renrakusaki()); // 퇴직 후 연락처 / 退職後の連絡先
            pstmt.setInt(5, taishaShanotorikeshi.getShain_ID()); // 사원 ID / 社員ID
            
            int updatedRows = pstmt.executeUpdate(); // 업데이트된 행의 개수를 반환 / 更新された行の数を返す
            return updatedRows > 0; // 업데이트가 성공했는지 여부 반환 / 更新が成功したかどうかを返す
        }
    }
}
