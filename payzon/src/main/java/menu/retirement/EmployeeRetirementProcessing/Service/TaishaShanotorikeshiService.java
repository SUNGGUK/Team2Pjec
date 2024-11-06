package menu.retirement.EmployeeRetirementProcessing.Service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.connection.ConnectionProvider;
import menu.retirement.EmployeeRetirementProcessing.DAO.Taisha_shanotorikeshiDAO;
import menu.retirement.EmployeeRetirementProcessing.Model.Taisha_shanotorikeshi;

public class TaishaShanotorikeshiService {

    private Taisha_shanotorikeshiDAO taishaShanotorikeshiDAO;

    // TaishaShanotorikeshiService 생성자, DAO 객체를 초기화
    // TaishaShanotorikeshiServiceのコンストラクタ、DAOオブジェクトを初期化
    public TaishaShanotorikeshiService() {
        this.taishaShanotorikeshiDAO = new Taisha_shanotorikeshiDAO();
    }

    // 특정 사원의 퇴직 정보를 조회하는 메서드
    // 特定の社員の退職情報を取得するメソッド
    public Taisha_shanotorikeshi getTaishaShanotorikeshi(int shainId) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) { // 데이터베이스 연결
            // データベースに接続
            Taisha_shanotorikeshi result = taishaShanotorikeshiDAO.getTaishaShanotorikeshi(conn, shainId); // DAO를 통해 퇴직 정보 조회
            // DAOを使用して退職情報を取得
            System.out.println("Fetched Taisha_shanotorikeshi: " + result); // 조회된 데이터 출력 (디버깅용)
            // 取得したデータを出力（デバッグ用）
            return result; // 조회 결과 반환
            // 取得結果を返す
        }
    }

    // 퇴직 처리 정보를 데이터베이스에 저장하는 메서드
    // 退職処理情報をデータベースに保存するメソッド
    public boolean saveTaishaShanotorikeshi(Taisha_shanotorikeshi taishaShanotorikeshi) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false); // 트랜잭션 시작 (자동 커밋 해제)
            // トランザクションの開始（自動コミット解除）
            
            // 먼저 해당 사원의 퇴직 정보가 있는지 조회
            // まず、該当社員の退職情報があるかどうかを確認
            Taisha_shanotorikeshi existingTaisha = taishaShanotorikeshiDAO.getTaishaShanotorikeshi(conn, taishaShanotorikeshi.getShain_ID());

            boolean success;
            if (existingTaisha == null) {
                // 퇴직 정보가 없으면 새로운 데이터를 삽입
                // 退職情報がなければ新しいデータを挿入
                taishaShanotorikeshiDAO.insertTaishaShanotorikeshi(conn, taishaShanotorikeshi);
                success = true; // 삽입 성공
                // 挿入成功
            } else {
                // 퇴직 정보가 있으면 업데이트 실행
                // 退職情報があれば更新を実行
                success = taishaShanotorikeshiDAO.updateTaishaShanotorikeshi(conn, taishaShanotorikeshi);
            }

            // 성공 여부에 따라 트랜잭션 커밋 또는 롤백
            // 成功可否に応じてトランザクションをコミットまたはロールバック
            if (success) {
                conn.commit();
            } else {
                conn.rollback();
            }
            return success;

        } catch (SQLException e) {
            throw new SQLException("퇴직 정보 저장 중 오류 발생", e); // 오류 발생 시 예외 처리
            // エラーが発生した場合に例外処理を実行
        }
    }

    // 새로운 퇴직 정보 삽입 메서드
    // 新しい退職情報を挿入するメソッド
    public void insertTaishaShanotorikeshi(Taisha_shanotorikeshi taishaShanotorikeshi) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false); // 트랜잭션 시작
            // トランザクション開始
            taishaShanotorikeshiDAO.insertTaishaShanotorikeshi(conn, taishaShanotorikeshi); // 데이터 삽입
            // データ挿入
            conn.commit(); // 커밋
            // コミット
        } catch (SQLException e) {
            throw new SQLException("데이터 삽입 중 오류 발생", e); // 오류 발생 시 예외 처리
            // エラーが発生した場合の例外処理
        }
    }

    // 기존 퇴직 정보 업데이트 메서드
    // 既存の退職情報を更新するメソッド
    public boolean updateTaishaShanotorikeshi(Taisha_shanotorikeshi taishaShanotorikeshi) throws SQLException {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false); // 트랜잭션 시작
            // トランザクション開始
            boolean success = taishaShanotorikeshiDAO.updateTaishaShanotorikeshi(conn, taishaShanotorikeshi); // 업데이트 실행
            // 更新の実行
            if (success) {
                conn.commit(); // 업데이트 성공 시 커밋
                // 更新成功時にコミット
            } else {
                conn.rollback(); // 실패 시 롤백
                // 失敗時にロールバック
            }
            return success; // 성공 여부 반환
            // 成功の可否を返す
        } catch (SQLException e) {
            throw new SQLException("데이터 업데이트 중 오류 발생", e); // 오류 발생 시 예외 처리
            // エラー発生時に例外処理を実行
        }
    }
}
