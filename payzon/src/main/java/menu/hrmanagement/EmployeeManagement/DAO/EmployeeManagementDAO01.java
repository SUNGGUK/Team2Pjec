package menu.hrmanagement.EmployeeManagement.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.hrmanagement.EmployeeManagement.Model.EmployeeManagement01;

public class EmployeeManagementDAO01 {

    // 모든 직원 정보를 가져오는 메서드 // すべての社員情報を取得するメソッド
    public List<EmployeeManagement01> getAllEmployees01() {
        List<EmployeeManagement01> employeeList01 = new ArrayList<>();
        
        String sql = "SELECT * FROM shain_touroku"; // WHERE 절 제거 // WHERE句を削除

        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
             
            while (rs.next()) {
                EmployeeManagement01 employee01 = new EmployeeManagement01();
                employee01.setShain_ID(rs.getInt("shain_ID"));  //사원ID // 社員ID
                employee01.setKoyou_keitai(rs.getString("koyou_keitai"));  //고용형태 // 雇用形態
                employee01.setShain_namae(rs.getString("shain_namae"));  //사원명(일어) // 社員名（日本語）
                employee01.setShain_eigo_namae(rs.getString("shain_eigo_namae"));  //사원명(영어) // 社員名（英語）
                employee01.setNyuusha_bi(rs.getDate("nyuusha_bi"));  //입사일 // 入社日
                employee01.setTaisha_bi(rs.getDate("taisha_bi"));  //퇴직일 // 退職日
                employee01.setBu(rs.getString("bu"));  //부서 // 部署
                employee01.setYakushoku(rs.getString("yakushoku"));  //직위 // 職位
                employee01.setNai_gaikokuzin(rs.getString("nai_gaikokuzin"));  //내/외국인 // 内/外国人
                employee01.setZyuumin_bangou(rs.getString("zyuumin_bangou"));  //주민번호 // 住民番号
                employee01.setZyuusho(rs.getString("zyuusho"));  //주소 // 住所
                employee01.setDenwa_bangou(rs.getString("denwa_bangou"));  //전화번호 // 電話番号
                employee01.setKeitai_bangou(rs.getString("keitai_bangou"));  //휴대전화번호 // 携帯電話番号
                employee01.setMeiru_adoresu(rs.getString("meiru_adoresu"));  //메일주소 // メールアドレス
                employee01.setSns(rs.getString("sns"));  //sns // SNS
                
                employeeList01.add(employee01);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return employeeList01; // 직원 목록 반환 // 社員リストを返す
    }
    
    // 선택된 직원들을 삭제하는 메서드 // 選択した社員を削除するメソッド
    public void deleteEmployees(List<Integer> shainIds) {
        String sql = "DELETE FROM shain_touroku WHERE shain_ID = ?"; // 사원 ID로 삭제 // 社員IDで削除
        
        try (Connection conn = JdbcUtil.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
             
            for (Integer shainId : shainIds) {
                pstmt.setInt(1, shainId);
                pstmt.addBatch();
            }
            pstmt.executeBatch(); // 일괄 실행 // バッチ実行
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}