package menu.payroll.PayrollInputManagementforDailyWorkers.Controller;

import menu.payroll.PayrollInputManagementforDailyWorkers.Model.TotalKouzyo;
import menu.payroll.PayrollInputManagementforDailyWorkers.Model.TotalShiharai;
import menu.payroll.PayrollInputManagementforDailyWorkers.Service.PayrollInputDailyService;

import java.util.List;

public class PayrollInputDailyController {
    private PayrollInputDailyService PayrollInputDailyService; // 급여 입력 서비스 (給与入力サービス)

    public PayrollInputDailyController() {
        this.PayrollInputDailyService = new PayrollInputDailyService(); // 서비스 초기화 (サービスの初期化)
    }

    // 급여 정보 입력 메서드 (給与情報入力メソッド)
    public void inputPayroll(int shainId, TotalShiharai shiharai, TotalKouzyo kouzyo) {
        PayrollInputDailyService.inputPayroll(shainId, shiharai, kouzyo); // 서비스 호출 (サービス呼び出し)
    }

    // 사원 ID로 급여 및 공제 정보 조회 메서드 (社員IDで給与と控除情報を取得するメソッド)
    public List<String[]> getPayrollByShainId(int shainId) {
        return PayrollInputDailyService.getPayrollByShainId(shainId); // 서비스 호출 (サービス呼び出し)
    }
    
    // 모든 사원 급여 정보 조회 메서드 (全社員の給与情報を取得するメソッド)
    public List<String[]> getAllPayrolls() {
        return PayrollInputDailyService.getAllPayrolls(); // 서비스 호출 (サービス呼び出し)
    }
}
