package menu.attendance.AttendanceRecordManagement.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import menu.attendance.AttendanceRecordManagement.Model.AttendanceRecord;
import menu.attendance.AttendanceRecordManagement.Service.AttendanceService;
import menu.attendance.AttendanceRecordManagement.Service.AttendanceServiceImpl;
import mvc.command.CommandHandler;

public class AttendanceManagementHandler implements CommandHandler {
	private final AttendanceService attendanceService = new AttendanceServiceImpl();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String action = req.getParameter("action");
		String shainIdParam = req.getParameter("shain_id");

		if ("viewAttendance".equals(action)) {
			return handleViewAttendance(req, res, shainIdParam);
		} else if ("viewLeaveStatus".equals(action)) {
			return handleViewLeaveStatus(req, res, shainIdParam);
		}

		// Default action to show the employee list
		return showEmployeeList(req);
	}

	 private String handleViewAttendance(HttpServletRequest req, HttpServletResponse res, String shainIdParam) throws IOException {
	        System.out.println("Received viewAttendance request for shainId: " + shainIdParam);

	        if (shainIdParam == null || shainIdParam.trim().isEmpty()) {
	            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid shain_id parameter");
	            return null;
	        }

	        try {
	            int shainId = Integer.parseInt(shainIdParam);
	            List<AttendanceRecord> attendanceList = attendanceService.getEmployeeAttendanceRecords(shainId);

	            System.out.println("Sending data for shainId " + shainId + ": " + attendanceList);
	            String json = new Gson().toJson(attendanceList);
	            res.setContentType("application/json");
	            res.setCharacterEncoding("UTF-8");
	            res.getWriter().write(json);
	        } catch (NumberFormatException e) {
	            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "shain_id must be a valid integer");
	        } catch (Exception e) {
	            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error retrieving attendance records");
	            e.printStackTrace();
	        }
	        return null;
	    }





	private String handleViewLeaveStatus(HttpServletRequest req, HttpServletResponse res, String shainIdParam)
			throws IOException {
		if (shainIdParam == null || shainIdParam.trim().isEmpty()) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid shain_id parameter");
			return null;
		}

		List<AttendanceRecord> leaveStatus = new ArrayList<>();
		for (String id : shainIdParam.split(",")) {
			try {
				int shainId = Integer.parseInt(id.trim());
				leaveStatus.addAll(attendanceService.getEmployeeLeaveStatus(shainId));
			} catch (NumberFormatException e) {
				System.out.println("Invalid shain_id in leave status: Not a valid integer - " + id);
			} catch (Exception e) {
				System.out.println("Error retrieving leave status for shain_id " + id + ": " + e.getMessage());
				e.printStackTrace();
			}
		}

		String json = new Gson().toJson(leaveStatus);
		res.setContentType("application/json");
		res.setCharacterEncoding("UTF-8");
		res.getWriter().write(json);
		return null;
	}

	private String showEmployeeList(HttpServletRequest req) throws Exception {
		List<AttendanceRecord> employeeList = attendanceService.getEmployeeList();
		System.out.println("Employee list retrieved: " + employeeList); // Log to verify data

		req.setAttribute("employeeList", employeeList);
		return "/view/attendance/attendanceManagement.jsp";
	}

}
