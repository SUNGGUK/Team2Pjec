package menu.retirement.RetirementPaySlip.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import menu.retirement.RetirementPaySlip.Model.RetirementPaySlip;

public class RetirementPaySlipDAO {

	// DAO의 싱글톤 인스턴스 생성
	// DAOのシングルトンインスタンスを生成
	private static RetirementPaySlipDAO instance = new RetirementPaySlipDAO();

	// 싱글톤 인스턴스를 반환하는 메서드
	// シングルトンインスタンスを返すメソッド
	public static RetirementPaySlipDAO getInstance() {
		return instance;
	}

	// ResultSet에서 RetirementPaySlip 객체로 변환하는 메서드
	// ResultSetからRetirementPaySlipオブジェクトに変換するメソッド
	private RetirementPaySlip convertRetirementPaySlip(ResultSet rs) throws SQLException {
		return new RetirementPaySlip(rs.getString("taishoku_kubun"), // 퇴직 구분 설정 退職区分を設定
				rs.getString("shain_namae"), // 사원 이름 설정 社員名を設定
				rs.getInt("taishoku_kin"), // 퇴직금 설정 退職金を設定
				rs.getDate("jitsu_shikyuu_gaku_bi"), // 지급일 설정 支給日を設定
				rs.getInt("shain_id") // 사원 ID 설정 社員IDを設定
		);
	}

	// 지급년도를 기준으로 퇴직급여 정보를 조회하는 메서드
	// 支給年度を基準に退職給与情報を取得するメソッド
	public List<RetirementPaySlip> selectByYear(Connection conn, int year) throws SQLException {
		List<RetirementPaySlip> list = new ArrayList<>();
		String sql = "SELECT t.taishoku_kubun, s.shain_namae, t.taishoku_kin, ta.jitsu_shikyuu_gaku_bi, s.shain_id "
				+ "FROM shain_touroku s " + "LEFT JOIN taishoku t ON s.shain_id = t.shain_id "
				+ "LEFT JOIN Taishoku_kyuuyo ta ON s.shain_id = ta.shain_id "
				+ "WHERE EXTRACT(YEAR FROM ta.jitsu_shikyuu_gaku_bi) = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, year); // 지급년도 바인딩
									// 支給年度をバインド
			try (ResultSet rs = pstmt.executeQuery()) {
				while (rs.next()) {
					list.add(convertRetirementPaySlip(rs)); // ResultSet의 각 행을 객체로 변환하여 리스트에 추가
															// ResultSetの各行をオブジェクトに変換しリストに追加
				}
			}
		}
		return list;
	}

	// 특정 사원 ID(shain_id)로 퇴직급여 정보를 조회하는 메서드
	// 特定の社員ID（shain_id）で退職給与情報を取得するメソッド
	public RetirementPaySlip selectByShainId(Connection conn, int shainId) throws SQLException {
		RetirementPaySlip retirementPaySlip = null;
		String sql = "SELECT t.taishoku_kubun, s.shain_namae, t.taishoku_kin, ta.jitsu_shikyuu_gaku_bi, s.shain_id "
				+ "FROM shain_touroku s " + "LEFT JOIN taishoku t ON s.shain_id = t.shain_id "
				+ "LEFT JOIN Taishoku_kyuuyo ta ON s.shain_id = ta.shain_id " + "WHERE s.shain_id = ?";

		try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, shainId); // 사원 ID를 쿼리에 설정
										// 社員IDをクエリに設定
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					retirementPaySlip = convertRetirementPaySlip(rs); // 첫 번째 결과를 RetirementPaySlip 객체로 변환
																		// 最初の結果をRetirementPaySlipオブジェクトに変換
				}
			}
		}
		return retirementPaySlip; // 결과 객체 반환 또는 null 반환
									// 結果オブジェクトを返すか、nullを返す
	}
}
