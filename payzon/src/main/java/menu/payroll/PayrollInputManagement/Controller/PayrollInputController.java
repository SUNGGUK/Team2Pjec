package menu.payroll.PayrollInputManagement.Controller;

import menu.payroll.PayrollInputManagement.Model.TotalKouzyo;
import menu.payroll.PayrollInputManagement.Model.TotalShiharai;
import menu.payroll.PayrollInputManagement.Service.PayrollInputService;

import java.util.List;

public class PayrollInputController {
    private PayrollInputService payrollInputService;

    public PayrollInputController() {
        this.payrollInputService = new PayrollInputService();
    }

    // 급여 정보 입력 메서드
    // 給与情報入力メソッド
    public void inputPayroll(int shainId, TotalShiharai shiharai, TotalKouzyo kouzyo) {
        payrollInputService.inputPayroll(shainId, shiharai, kouzyo);
    }

    // 사원 ID로 급여 및 공제 정보 조회 메서드
    // 社員IDで給与および控除情報を取得するメソッド
    public List<String[]> getPayrollByShainId(int shainId) {
        return payrollInputService.getPayrollByShainId(shainId);
    }
    
    // 모든 사원 급여 정보 조회 메서드
    // すべての社員の給与情報を取得するメソッド
    public List<String[]> getAllPayrolls() {
        return payrollInputService.getAllPayrolls();
    }
}
