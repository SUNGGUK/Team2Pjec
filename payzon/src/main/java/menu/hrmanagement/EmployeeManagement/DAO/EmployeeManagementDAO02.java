package menu.hrmanagement.EmployeeManagement.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.EmployeeManagement.Model.EmployeeManagement02;

public class EmployeeManagementDAO02 {

    // 모든 직원 정보를 가져오는 메서드 // すべての社員情報を取得するメソッド
    public List<EmployeeManagement02> getAllEmployees02() {
        List<EmployeeManagement02> employeeList02 = new ArrayList<>();
        
        String sql = "SELECT * FROM kyuuyo_shidai_hoken"; // WHERE 절 제거 // WHERE句を削除

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                EmployeeManagement02 employee02 = new EmployeeManagement02();
                employee02.setShain_ID(rs.getInt("shain_ID")); //사원ID // 社員ID
                employee02.setGinkou_mei(rs.getString("ginkou_mei"));  //은행명 // 銀行名
                employee02.setKouza_bangou(rs.getString("kouza_bangou"));  //계좌번호 // 口座番号
                
                employeeList02.add(employee02);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return employeeList02; // 직원 목록 반환 // 社員リストを返す
    }
    
    // 사원 정보를 삭제하는 메서드 // 社員情報を削除するメソッド
    public boolean deleteEmployees(int shainIds) {
        String sql = "DELETE FROM kyuuyo_shidai_hoken WHERE shain_ID = ?"; // 사원 ID로 삭제 // 社員IDで削除
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
}