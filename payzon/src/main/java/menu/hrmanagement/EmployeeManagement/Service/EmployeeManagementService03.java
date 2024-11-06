package menu.hrmanagement.EmployeeManagement.Service;

import java.util.List;

import menu.hrmanagement.EmployeeManagement.DAO.EmployeeManagementDAO03;
import menu.hrmanagement.EmployeeManagement.Model.EmployeeManagement03;

public class EmployeeManagementService03 {

    private EmployeeManagementDAO03 employeeDAO03;

    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public EmployeeManagementService03() {
        this.employeeDAO03 = new EmployeeManagementDAO03(); // EmployeeManagementDAO03의 인스턴스를 초기화 / EmployeeManagementDAO03のインスタンスを初期化
    }

    // 전체 직원 목록을 가져오는 메서드 / すべての社員リストを取得するメソッド
    public List<EmployeeManagement03> getAllEmployees03() {
        return employeeDAO03.getAllEmployees03(); // 모든 직원 정보를 가져옴 / すべての社員情報を取得
    }
    
    // 선택된 직원들을 삭제하는 메서드 / 選択した社員を削除するメソッド
    public void deleteEmployees(int shainIds) {
        employeeDAO03.deleteEmployees(shainIds); // DAO의 삭제 메서드 호출 / DAOの削除メソッドを呼び出す
    }
    
    // 특정 상태의 직원 목록을 가져오는 메서드 / 特定の状態の社員リストを取得するメソッド
    public List<EmployeeManagement03> getEmployeesByZyoutai(String zyoutai) {
        return employeeDAO03.getEmployeesByZyoutai(zyoutai); // 상태에 따른 직원 목록을 반환 / 状態に基づく社員リストを返す
    }
}