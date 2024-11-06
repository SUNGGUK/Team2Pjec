package menu.retirement.EmployeeRetirementProcessing.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import menu.retirement.EmployeeRetirementProcessing.DAO.RetirementProcessingDAO;
import menu.retirement.EmployeeRetirementProcessing.Model.RetirementProcessing;

public class RetirementProcessingService {

	private RetirementProcessingDAO retirementProcessingDAO;

	// RetirementProcessingService 클래스 생성자
	// RetirementProcessingServiceクラスのコンストラクタ
	public RetirementProcessingService() {
		this.retirementProcessingDAO = RetirementProcessingDAO.getInstance(); // DAO 인스턴스를 생성자에서 초기화
		// コンストラクタでDAOインスタンスを初期化
	}

	// 퇴직 처리 정보 업데이트 메서드
	// 退職処理情報の更新メソッド
	public void updateRetirementProcessing(RetirementProcessing retirementProcessing) throws SQLException {
		System.out.println("DAO에서 가져온 데이터11:");
		try (Connection conn = ConnectionProvider.getConnection()) {
			conn.setAutoCommit(false); // 트랜잭션 시작 - 자동 커밋을 끄고 수동 트랜잭션 관리
			// トランザクションの開始 - 自動コミットをオフにして手動で管理
			retirementProcessingDAO.update(conn, retirementProcessing); // DAO를 통해 업데이트 실행
			// DAOを通じて更新を実行
			conn.commit(); // 트랜잭션 커밋으로 업데이트 완료
			// トランザクションをコミットして更新完了
		} catch (SQLException e) {
			throw new SQLException("퇴직 처리 정보 업데이트 중 오류 발생", e); // 오류 발생 시 예외를 던짐
			// エラーが発生した場合に例外をスロー
		}
	}

	// 모든 퇴직 처리 정보 조회 메서드
	// すべての退職処理情報を取得するメソッド
	public List<RetirementProcessing> getAllRetirementProcessing() throws SQLException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			// DAO를 통해 모든 퇴직 처리 정보 조회
			// DAOを通じてすべての退職処理情報を取得
			List<RetirementProcessing> list = retirementProcessingDAO.selectAll(conn);

			// DAO에서 가져온 데이터를 출력
			// DAOから取得したデータを出力
			if (list != null && !list.isEmpty()) {
				System.out.println("DAO에서 가져온 데이터:");
				for (RetirementProcessing rp : list) {
					System.out.println(rp.toString()); // 각 퇴직 처리 정보를 출력 (toString 메서드 구현 필요)
					// 各退職処理情報を出力 (toStringメソッドの実装が必要)
				}
			} else {
				System.out.println("DAO에서 데이터를 가져오지 못했습니다."); // 조회된 데이터가 없을 때
				// 取得したデータがない場合
			}

			return list; // 조회된 퇴직 처리 정보 목록 반환
			// 取得された退職処理情報リストを返す
		}
	}

	// 전체 퇴직 처리 건수 조회 메서드
	// 全体の退職処理件数を取得するメソッド
	public int getTotalRetirementCount() throws SQLException {
		try (Connection conn = ConnectionProvider.getConnection()) {
			return retirementProcessingDAO.getTotalCount(conn); // DAO에서 전체 건수 조회
			// DAOから全体の件数を取得
		}
	}
}
