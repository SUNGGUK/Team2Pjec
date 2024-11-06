package menu.attendance.AttendanceRecordManagement.Service;

import java.util.List;
import menu.attendance.AttendanceRecordManagement.DAO.AttendanceRecordDAO;
import menu.attendance.AttendanceRecordManagement.Model.AttendanceRecord;

public class AttendanceServiceImpl implements AttendanceService {
    private final AttendanceRecordDAO attendanceRecordDAO = AttendanceRecordDAO.getInstance();

    @Override
    public List<AttendanceRecord> getEmployeeList() throws Exception {
        List<AttendanceRecord> attendanceRecords = attendanceRecordDAO.selectAllEmployees();
        
        if (attendanceRecords == null || attendanceRecords.isEmpty()) {
            System.out.println("Service Layer: No records found.");
        } else {
            System.out.println("Service Layer: Fetched " + attendanceRecords.size() + " records.");
        }
        
        return attendanceRecords;
    }

    @Override
    public List<AttendanceRecord> getEmployeeAttendanceRecords(int shainId) throws Exception {
        return attendanceRecordDAO.selectEmployeeData(shainId);
    }

    @Override
    public List<AttendanceRecord> getEmployeeData(int shainId) throws Exception {
        // Implement the required method to fetch both attendance and leave data
        return attendanceRecordDAO.selectEmployeeData(shainId);
    }

    @Override
    public void saveAttendanceRecord(AttendanceRecord record) throws Exception {
        attendanceRecordDAO.insertAttendanceRecord(record);
    }

    @Override
    public List<AttendanceRecord> getEmployeeLeaveStatus(int shainId) throws Exception {
        return attendanceRecordDAO.selectEmployeeData(shainId);
    }
}
