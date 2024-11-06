package menu.hrmanagement.EmployeeManagement.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.EmployeeManagement.Model.EmployeeManagement03;

public class EmployeeManagementDAO03 {

    // 모든 직원 정보를 가져오는 메서드 // すべての社員情報を取得するメソッド
    public List<EmployeeManagement03> getAllEmployees03() {
        List<EmployeeManagement03> employeeList03 = new ArrayList<>();
        
        String sql = "SELECT * FROM taishoku"; // WHERE 절 제거 // WHERE句を削除

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                EmployeeManagement03 employee03 = new EmployeeManagement03();
                employee03.setShain_ID(rs.getInt("shain_ID")); // 사원ID // 社員ID
                employee03.setZyoutai(rs.getString("zyoutai")); // 상태 // 状態
                employee03.setTaishoku_bi(rs.getDate("taishoku_bi")); // 퇴직일 // 退職日
                
                employeeList03.add(employee03);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return employeeList03; // 직원 목록 반환 // 社員リストを返す
    }
    
    // 사원 정보를 삭제하는 메서드 // 社員情報を削除するメソッド
    public boolean deleteEmployees(int shainIds) {
        String sql = "DELETE FROM taishoku WHERE shain_ID = ?"; // 사원 ID로 삭제 // 社員IDで削除
        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            pstmt.setInt(1, shainIds);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0; // 삭제된 행의 수가 0보다 크면 성공 // 削除された行数が0より大きい場合は成功
        } catch (Exception e) {
            e.printStackTrace();
            return false; // 예외 발생 시 삭제 실패 // 例外が発生した場合は削除失敗
        }
    }
    
    //사원 상태가 재직인 사람만 나타나게 하는 메서드 // 社員の状態が在職の人だけを表示するメソッド
    public List<EmployeeManagement03> getEmployeesByZyoutai(String zyoutai) {
        List<EmployeeManagement03> employees03 = new ArrayList<>();

        // DB 연결 및 데이터 조회 예제 // DB接続とデータ取得の例
        String sql = "SELECT * FROM taishoku WHERE shain_ID = ?"; // 상태 필터링 쿼리 // 状態フィルタリングクエリ
        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, zyoutai);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                EmployeeManagement03 employee03 = new EmployeeManagement03();
                employee03.setShain_ID(rs.getInt("shain_ID")); // 사원 ID // 社員ID
                employee03.setZyoutai(rs.getString("zyoutai")); // 상태 // 状態
                employee03.setTaishoku_bi(rs.getDate("taishoku_bi")); // 퇴직일 // 退職日
                
                employees03.add(employee03);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees03; // 필터링된 직원 목록 반환 // フィルタリングされた社員リストを返す
    }
}