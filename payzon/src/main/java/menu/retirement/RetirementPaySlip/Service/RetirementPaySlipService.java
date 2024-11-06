package menu.retirement.RetirementPaySlip.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import menu.retirement.RetirementPaySlip.DAO.RetirementPaySlipDAO;
import menu.retirement.RetirementPaySlip.Model.RetirementPaySlip;

public class RetirementPaySlipService {

    private RetirementPaySlipDAO retirementPaySlipDAO = RetirementPaySlipDAO.getInstance();

    /**
     * 지급년도 기준으로 퇴직급여 정보를 조회하는 메서드
     * 
     * @param year 조회할 지급년도
     * @return 지정된 지급년도에 해당하는 퇴직급여 정보 목록
     */
    // 支給年度に基づいて退職給与情報を検索するメソッド
    // @param year 検索する支給年度
    // @return 指定された支給年度に該当する退職給与情報のリスト
    public List<RetirementPaySlip> getRetirementPaySlipsByYear(int year) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            return retirementPaySlipDAO.selectByYear(conn, year);  // DAO에서 데이터 조회
                                                                   // DAOからデータを検索
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("지급년도 기준 퇴직급여 정보 조회 중 오류 발생", e); // 예외 발생 시 오류 메시지 출력
                                                                                // 例外発生時にエラーメッセージを出力
        }
    }

    /**
     * shain_id를 기준으로 특정 사원의 퇴직급여 정보를 조회하는 메서드
     * 
     * @param shainId 조회할 사원의 ID
     * @return 해당 사원의 퇴직급여 정보
     */
    // shain_idに基づいて特定の社員の退職給与情報を検索するメソッド
    // @param shainId 検索する社員のID
    // @return 該当社員の退職給与情報
    public RetirementPaySlip getRetirementPaySlipByShainId(int shainId) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            return retirementPaySlipDAO.selectByShainId(conn, shainId);  // DAO에서 데이터 조회
                                                                         // DAOからデータを検索
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("shain_id로 퇴직급여 정보 조회 중 오류 발생", e);  // 예외 발생 시 오류 메시지 출력
                                                                                 // 例外発生時にエラーメッセージを出力
        }
    }
}
