package menu.hrmanagement.EmployeeManagement.Service;

import java.util.List;

import menu.hrmanagement.EmployeeManagement.DAO.EmployeeManagementDAO02;
import menu.hrmanagement.EmployeeManagement.Model.EmployeeManagement02;

public class EmployeeManagementService02 {
    
    private EmployeeManagementDAO02 employeeDAO02;

    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public EmployeeManagementService02() {
        this.employeeDAO02 = new EmployeeManagementDAO02(); // EmployeeManagementDAO02의 인스턴스를 초기화 / EmployeeManagementDAO02のインスタンスを初期化
    }

    // 전체 직원 목록을 가져오는 메서드 / すべての社員リストを取得するメソッド
    public List<EmployeeManagement02> getAllEmployees02() {
        return employeeDAO02.getAllEmployees02(); // 모든 직원 정보를 가져옴 / すべての社員情報を取得
    }
    
    // 직원 정보를 삭제하는 메서드 / 社員情報を削除するメソッド
    public boolean deleteEmployee(int shainIds) {
        return employeeDAO02.deleteEmployees(shainIds); // DAO의 삭제 메서드 호출 / DAOの削除メソッドを呼び出す
    }
}