package menu.payroll.PayrollLedger.Controller;

import menu.payroll.PayrollLedger.DAO.PayrollLedgerDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/payrollLedger") // 요청 경로 설정 (リクエストパスを設定)
public class PayrollLedgerController extends HttpServlet {

    private PayrollLedgerDAO payrollLedgerDAO;

    @Override
    public void init() throws ServletException {
        super.init();
        payrollLedgerDAO = new PayrollLedgerDAO(); // DAO 초기화 (DAOを初期化)
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 전체 급여 정보 조회 (全体給与情報を取得)
        List<String[]> payrollList = payrollLedgerDAO.getAllPayrolls();

        // 조회된 급여 정보를 요청 속성에 설정 (取得した給与情報をリクエスト属性に設定)
        request.setAttribute("payrollList", payrollList);

        // JSP 페이지로 포워딩 (JSPページにフォワード)
        request.getRequestDispatcher("/payrollLedger.jsp").forward(request, response);
    }
}
