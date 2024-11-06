package menu.hrmanagement.EmployeeManagement.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.hrmanagement.EmployeeManagement.Model.EmployeeManagement03;
import menu.hrmanagement.EmployeeManagement.Service.EmployeeManagementService03;

public class EmployeeServletZaishoku extends HttpServlet {
    private EmployeeManagementService03 employeeManagementService03;

    @Override
    public void init() throws ServletException {
        // Service 객체 초기화 // サービスオブジェクトを初期化
        this.employeeManagementService03 = new EmployeeManagementService03();
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String selZyoutaiZaishoku = request.getParameter("selZyoutaiZaishoku");
		
		List<EmployeeManagement03> employees03;
		if(selZyoutaiZaishoku != null) {
			employees03 = employeeManagementService03.getEmployeesByZyoutai("在職"); // 재직 상태의 직원 목록을 가져옵니다. // 在職状態の社員リストを取得します。
		}else {
			employees03 = employeeManagementService03.getAllEmployees03(); // 모든 직원 목록을 가져옵니다. // すべての社員リストを取得します。
		}
		
		request.setAttribute("employees03", employees03);
		
        RequestDispatcher dispatcher = request.getRequestDispatcher("/view/HRManagement/employeeManagement.jsp");
        dispatcher.forward(request, response); // JSP 페이지로 요청을 전달합니다. // JSPページにリクエストを転送します。
	}

}
