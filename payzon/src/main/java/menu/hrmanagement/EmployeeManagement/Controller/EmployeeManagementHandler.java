package menu.hrmanagement.EmployeeManagement.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.hrmanagement.EmployeeManagement.Model.EmployeeManagement01;
import menu.hrmanagement.EmployeeManagement.Model.EmployeeManagement02;
import menu.hrmanagement.EmployeeManagement.Model.EmployeeManagement03;
import menu.hrmanagement.EmployeeManagement.Service.EmployeeManagementService01;
import menu.hrmanagement.EmployeeManagement.Service.EmployeeManagementService02;
import menu.hrmanagement.EmployeeManagement.Service.EmployeeManagementService03;
import mvc.command.CommandHandler;

public class EmployeeManagementHandler implements CommandHandler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 요청으로부터 action 파라미터를 가져옵니다. // リクエストからactionパラメータを取得します。
        String action = request.getParameter("action");

        // 직원 정보를 조회하는 서비스 // 社員情報を取得するサービス
        EmployeeManagementService01 service01 = new EmployeeManagementService01();
        EmployeeManagementService02 service02 = new EmployeeManagementService02();
        EmployeeManagementService03 service03 = new EmployeeManagementService03();
        
        // 삭제 요청 처리 // 削除リクエストを処理
        if ("delete".equals(action)) {
            // 선택된 직원들의 shain_ID 목록을 가져옵니다. // 選択された社員のshain_IDリストを取得します。
            String[] selectedIds = request.getParameterValues("selectedEmployees");
            if (selectedIds != null) {
                List<Integer> shainIds = new ArrayList<>();
                for (String id : selectedIds) {
                    shainIds.add(Integer.parseInt(id));
                }
                // 선택된 직원 삭제 // 選択された社員を削除
                service01.deleteEmployees(shainIds);
            }
        }

        // 직원 목록을 조회하고 request에 설정 // 社員リストを取得し、リクエストに設定
        List<EmployeeManagement01> employeeList01 = service01.getAllEmployees01();
        List<EmployeeManagement02> employeeList02 = service02.getAllEmployees02();
        List<EmployeeManagement03> employeeList03 = service03.getAllEmployees03();
        
        request.setAttribute("employeeList01", employeeList01);
        request.setAttribute("employeeList02", employeeList02);
        request.setAttribute("employeeList03", employeeList03);

        // JSP 페이지로 이동하여 결과 표시 // JSPページに移動して結果を表示
        return "/view/HRManagement/employeeManagement.jsp";
    }
}
