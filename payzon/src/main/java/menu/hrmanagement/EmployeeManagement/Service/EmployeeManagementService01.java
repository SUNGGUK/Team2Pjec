package menu.hrmanagement.EmployeeManagement.Service;

import java.util.List;

import menu.hrmanagement.EmployeeManagement.DAO.EmployeeManagementDAO01;
import menu.hrmanagement.EmployeeManagement.Model.EmployeeManagement01;

public class EmployeeManagementService01 {
    
    private EmployeeManagementDAO01 employeeDAO01;

    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public EmployeeManagementService01() {
        this.employeeDAO01 = new EmployeeManagementDAO01(); // EmployeeManagementDAO01의 인스턴스를 초기화 / EmployeeManagementDAO01のインスタンスを初期化
    }

    // 전체 직원 목록을 가져오는 메서드 / すべての社員リストを取得するメソッド
    public List<EmployeeManagement01> getAllEmployees01() {
        return employeeDAO01.getAllEmployees01(); // 모든 직원 정보를 가져옴 / すべての社員情報を取得
    }
    
    // 선택된 직원들을 삭제하는 메서드 / 選択された社員を削除するメソッド
    public void deleteEmployees(List<Integer> shainIds) {
        employeeDAO01.deleteEmployees(shainIds); // 직원 삭제 메서드 호출 / 社員削除メソッドを呼び出す
    }
}