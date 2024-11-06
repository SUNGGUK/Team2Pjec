package menu.attendance.AttendanceRecordManagement.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import jdbc..ConnectionProvider;
import menu.attendance.AttendanceRecordManagement.DAO.AttendanceRecordDAO;
import menu.attendance.AttendanceRecordManagement.Model.AttendanceRecord;

public class AttendanceListService {

    private AttendanceRecordDAO attendanceRecordDAO = new AttendanceRecordDAO();

    // 전체 근태 기록 목록을 가져오는 메서드
    public List<AttendanceRecord> getAllAttendanceRecords(int pageNo) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            int pageSize = 10;  // 한 페이지에 표시할 행 개수
            int startRow = (pageNo - 1) * pageSize;
            return attendanceRecordDAO.selectWithDetails(conn, startRow, pageSize);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("데이터베이스 오류로 근태 기록을 가져올 수 없습니다.", e);
        }
    }
}
