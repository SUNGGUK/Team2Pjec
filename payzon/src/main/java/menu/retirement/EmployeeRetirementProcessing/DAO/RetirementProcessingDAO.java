package menu.retirement.EmployeeRetirementProcessing.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jdbc.JdbcUtil;
import menu.retirement.EmployeeRetirementProcessing.Model.RetirementProcessing;

public class RetirementProcessingDAO {

    private static RetirementProcessingDAO instance = new RetirementProcessingDAO();

    // DAO 싱글톤 인스턴스 반환 메서드
    // DAOのシングルトンインスタンスを返すメソッド
    public static RetirementProcessingDAO getInstance() {
        return instance;
    }

    // ResultSet에서 RetirementProcessing 객체를 생성하는 메서드
    // ResultSetからRetirementProcessingオブジェクトを生成するメソッド
    private RetirementProcessing convertRetirementProcessing(ResultSet rs) throws SQLException {
        System.out.println("DAO: selectAll 메서드 시작");  // メソッドの開始ログ
        return new RetirementProcessing(
                rs.getString("zyoutai"),                            // 상태(퇴직 등) 설정 / 状態（退職など）設定
                rs.getInt("shain_ID"),                              // 사원 ID 설정 / 社員IDの設定
                rs.getString("shain_namae"),                        // 사원 이름 설정 / 社員名の設定
                rs.getString("bu"),                                 // 부서 설정 / 部署の設定
                rs.getString("yakushoku"),                          // 직책 설정 / 役職の設定
                rs.getDate("nyuusha_bi"),                           // 입사일 설정 / 入社日の設定
                rs.getDate("taishoku_bi"),                          // 퇴직일 설정 / 退職日の設定
                rs.getString("taishoku_kubun"),                     // 퇴직 구분 설정 / 退職区分の設定
                "Y".equalsIgnoreCase(rs.getString("chuukan_seisan_umu")), // 중간정산 여부 / 中間清算の有無
                "Y".equalsIgnoreCase(rs.getString("taishoku_seisan_umu"))  // 퇴직정산 여부 / 退職清算の有無
        );
    }

    // 퇴직 정보를 업데이트하는 메서드
    // 退職情報を更新するメソッド
    public void update(Connection conn, RetirementProcessing retirementProcessing) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            // 업데이트 쿼리 작성
            // 更新クエリの作成
            String sql = "UPDATE TAISHOKU T " +
                         "SET T.ZYOUTAI = ?, " +                         // 상태 업데이트 / 状態の更新
                         "T.TAISHOKU_BI = ?, " +                         // 퇴직일 업데이트 / 退職日の更新
                         "T.TAISHOKU_KUBUN = ?, " +                      // 퇴직 구분 업데이트 / 退職区分の更新
                         "T.CHUUKAN_SEISAN_UMU = ?, " +                  // 중간정산 여부 업데이트 / 中間清算の有無更新
                         "T.TAISHOKU_SEISAN_UMU = ? " +                  // 퇴직정산 여부 업데이트 / 退職清算の有無更新
                         "WHERE EXISTS (" +
                         "    SELECT 1 " +
                         "    FROM SHAIN_TOUROKU S " +
                         "    WHERE S.SHAIN_ID = T.SHAIN_ID AND S.SHAIN_ID = ?" +
                         ")";

            pstmt = conn.prepareStatement(sql);
            
            // 각 필드에 값을 설정
            // 各フィールドに値を設定
            pstmt.setString(1, retirementProcessing.getZyoutai());                    // 상태 / 状態
            pstmt.setDate(2, new java.sql.Date(retirementProcessing.getTaishoku_bi().getTime())); // 퇴직일 / 退職日
            pstmt.setString(3, retirementProcessing.getTaishoku_kubun());             // 퇴직 구분 / 退職区分
            pstmt.setString(4, retirementProcessing.isChuukan_seisan_umu() ? "Y" : "N"); // 중간정산 여부 / 中間清算の有無
            pstmt.setString(5, retirementProcessing.isTaishoku_seisan_umu() ? "Y" : "N"); // 퇴직정산 여부 / 退職清算の有無
            pstmt.setInt(6, retirementProcessing.getShain_ID());                      // 사원 ID / 社員ID
            
            int updatedRows = pstmt.executeUpdate();                                  // 업데이트 실행 / 更新の実行
            System.out.println("업데이트된 행 수: " + updatedRows);  // 更新された行数を出力
        } finally {
            JdbcUtil.close(pstmt); // 리소스 해제 / リソースの解放
        }
    }

    // 모든 퇴직 정보를 조회하는 메서드
    // 全ての退職情報を取得するメソッド
    public ArrayList<RetirementProcessing> selectAll(Connection conn) throws SQLException {
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<RetirementProcessing> list = new ArrayList<>();
        
        String sql = "SELECT t.ZYOUTAI, s.SHAIN_ID, s.SHAIN_NAMAE, s.BU, s.YAKUSHOKU, s.NYUUSHA_BI, " +
                "t.TAISHOKU_BI, t.TAISHOKU_KUBUN, t.CHUUKAN_SEISAN_UMU, t.TAISHOKU_SEISAN_UMU " +
                "FROM SHAIN_TOUROKU s JOIN TAISHOKU t ON s.SHAIN_ID = t.SHAIN_ID";
      
        try {
            ps = conn.prepareStatement(sql); // SQL 실행 준비 / SQL実行準備
            rs = ps.executeQuery();           // 쿼리 실행 / クエリの実行
            while (rs.next()) {
                list.add(convertRetirementProcessing(rs)); // ResultSet에서 데이터 변환 후 리스트에 추가 / ResultSetからデータを変換してリストに追加
                System.out.println("DAO: selectAll 메서드 데이터 크기 = " + list.size());  // データのサイズを出力
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JdbcUtil.close(rs);   // ResultSet 해제 / ResultSetの解放
            JdbcUtil.close(ps);   // PreparedStatement 해제 / PreparedStatementの解放
            JdbcUtil.close(conn); // Connection 해제 / Connectionの解放
        }
        return list;
    }

    // 퇴직 정보의 총 개수를 반환하는 메서드
    // 退職情報の総数を返すメソッド
    public int getTotalCount(Connection conn) throws SQLException {
        String sql = "SELECT COUNT(*) FROM TAISHOKU";
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = conn.prepareStatement(sql); // SQL 실행 준비 / SQL実行準備
            rs = pstmt.executeQuery();          // 쿼리 실행 / クエリの実行
            if (rs.next()) {
                return rs.getInt(1);            // 결과에서 총 개수를 가져옴 / 結果から総数を取得
            }
        } finally {
            JdbcUtil.close(rs);                 // ResultSet 해제 / ResultSetの解放
            JdbcUtil.close(pstmt);              // PreparedStatement 해제 / PreparedStatementの解放
        }
        return 0; // 결과가 없으면 0 반환 / 結果がなければ0を返す
    }
}
