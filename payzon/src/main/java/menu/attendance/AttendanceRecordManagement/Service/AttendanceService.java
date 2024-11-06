package menu.attendance.AttendanceRecordManagement.Service;

import java.util.List;
import menu.attendance.AttendanceRecordManagement.Model.AttendanceRecord;

public interface AttendanceService {
    List<AttendanceRecord> getEmployeeList() throws Exception;

    // 사원별 근태 기록 조회 메서드
    List<AttendanceRecord> getEmployeeAttendanceRecords(int shainId) throws Exception;

    // 사원별 근태 기록 및 휴가 상태 조회 메서드
    List<AttendanceRecord> getEmployeeData(int shainId) throws Exception;

    void saveAttendanceRecord(AttendanceRecord record) throws Exception;

    List<AttendanceRecord> getEmployeeLeaveStatus(int shainId) throws Exception;
}
