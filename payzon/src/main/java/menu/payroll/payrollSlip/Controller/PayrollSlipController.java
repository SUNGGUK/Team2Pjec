package menu.payroll.payrollSlip.Controller;

import java.util.List;

import menu.payroll.payrollSlip.Model.*;
import menu.payroll.payrollSlip.Service.PayrollSlipService;

public class PayrollSlipController {
    private PayrollSlipService payrollSlipService; // PayrollSlipService 인스턴스 (PayrollSlipServiceインスタンス)

    public PayrollSlipController() {
        this.payrollSlipService = new PayrollSlipService(); // PayrollSlipService 초기화 (PayrollSlipServiceを初期化)
    }

    // 급여 정보 입력 메서드 (給与情報入力メソッド)
    public void inputPayroll(int shainId, TotalShiharai shiharai, TotalKouzyo kouzyo) {
        payrollSlipService.inputPayroll(shainId, shiharai, kouzyo); // 급여 정보 입력 (給与情報を入力)
    }

    // 사원 ID로 급여 및 공제 정보 조회 메서드 (社員IDで給与および控除情報取得メソッド)
    public List<String[]> getPayrollByShainId(int shainId) {
        return payrollSlipService.getPayrollByShainId(shainId); // 사원 ID로 급여 및 공제 정보 반환 (社員IDで給与および控除情報を返す)
    }

    // 모든 사원 급여 정보 조회 메서드 (全ての社員給与情報取得メソッド)
    public List<String[]> getAllPayrolls() {
        return payrollSlipService.getAllPayrolls(); // 모든 사원 급여 정보 반환 (全ての社員給与情報を返す)
    }
}
