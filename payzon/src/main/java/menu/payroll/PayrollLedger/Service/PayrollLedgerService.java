package menu.payroll.PayrollLedger.Service;

import menu.payroll.PayrollLedger.DAO.PayrollLedgerDAO;
import java.util.List;

public class PayrollLedgerService {

    private PayrollLedgerDAO payrollLedgerDAO = new PayrollLedgerDAO(); // PayrollLedgerDAO 인스턴스 생성 (PayrollLedgerDAOインスタンス生成)

    // 전체 급여 정보 조회 메서드 (全ての給与情報取得メソッド)
    public List<String[]> getAllPayrolls() {
        return payrollLedgerDAO.getAllPayrolls(); // 전체 급여 정보 반환 (全ての給与情報を返す)
    }
}
