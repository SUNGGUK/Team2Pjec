package menu.attendance.AttendanceQuery.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import jdbc.connection.ConnectionProvider;
import menu.attendance.AttendanceQuery.Model.AttendanceQuery;

public class AttendanceQueryDAO {

    // 월별 조회 메서드
	public List<AttendanceQuery> getMonthlyAttendance(int year, int month, String department, String position) {
	    List<AttendanceQuery> attendanceList = new ArrayList<>();
	    StringBuilder query = new StringBuilder(
	        "SELECT e.shain_ID, e.shain_namae, e.bu, e.yakushoku, k.kintai_bi, k.kintai_ID " +
	        "FROM shain_touroku e " +
	        "JOIN kintai_kiroku k ON e.shain_ID = k.shain_ID " +
	        "WHERE EXTRACT(YEAR FROM k.kintai_bi) = ? " +
	        "AND EXTRACT(MONTH FROM k.kintai_bi) = ?"
	    );

	    if (department != null && !department.isEmpty()) {
	        query.append(" AND e.bu = ?");
	    }
	    if (position != null && !position.isEmpty()) {
	        query.append(" AND e.yakushoku = ?");
	    }
	    query.append(" ORDER BY e.shain_ID, k.kintai_bi");

	    try (Connection conn = ConnectionProvider.getConnection();
	         PreparedStatement pstmt = conn.prepareStatement(query.toString())) {

	        pstmt.setInt(1, year);
	        pstmt.setInt(2, month);

	        int paramIndex = 3;
	        if (department != null && !department.isEmpty()) {
	            pstmt.setString(paramIndex++, department);
	        }
	        if (position != null && !position.isEmpty()) {
	            pstmt.setString(paramIndex, position);
	        }

	        ResultSet rs = pstmt.executeQuery();
	        while (rs.next()) {
	            AttendanceQuery attendance = new AttendanceQuery();
	            attendance.setEmployeeId(rs.getInt("shain_ID"));
	            attendance.setEmployeeName(rs.getString("shain_namae"));
	            attendance.setDepartment(rs.getString("bu"));
	            attendance.setPosition(rs.getString("yakushoku"));
	            attendance.setAttendanceDate(rs.getDate("kintai_bi"));
	            attendance.setAttendanceType(rs.getInt("kintai_ID"));
	            attendanceList.add(attendance);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return attendanceList;
	}


    // 사원별 근태 조회 메서드
    public List<AttendanceQuery> getEmployeeMonthlyAttendance(int employeeId, int year, int month) {
        List<AttendanceQuery> attendanceList = new ArrayList<>();

        String query = "SELECT k.kintai_bi, k.kintai_ID, k.kinngaku, k.kintai_zikan " +
                       "FROM kintai_kiroku k " +
                       "WHERE k.shain_ID = ? " +
                       "AND EXTRACT(YEAR FROM k.kintai_bi) = ? " +
                       "AND EXTRACT(MONTH FROM k.kintai_bi) = ? " +
                       "ORDER BY k.kintai_bi";

        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setInt(1, employeeId);
            pstmt.setInt(2, year);
            pstmt.setInt(3, month);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                AttendanceQuery attendance = new AttendanceQuery();
                attendance.setEmployeeId(employeeId);
                attendance.setAttendanceDate(rs.getDate("kintai_bi"));
                attendance.setAttendanceType(rs.getInt("kintai_ID"));
                attendance.setAmount(rs.getInt("kinngaku"));
                attendance.setHours(rs.getInt("kintai_zikan"));

                attendanceList.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceList;
    }

    // 근태 항목 리스트 조회
    public List<String> getAttendanceItems() {
        List<String> attendanceItems = new ArrayList<>();
        
        String query = "SELECT kintai_shurui FROM kintai_koumoku_settei WHERE shiyou_kanou_umu = 'Y'";
        
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                attendanceItems.add(rs.getString("kintai_shurui"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return attendanceItems;
    }

    // 휴가 항목 리스트 조회
    public List<String> getVacationItems() {
        List<String> vacationItems = new ArrayList<>();

        String query = "SELECT kyuuka_shurui FROM kyuuka_koumoku_settei WHERE shiyou_kanou_umu = 'Y'";

        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                vacationItems.add(rs.getString("kyuuka_shurui"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vacationItems;
    }

    // 전체 근태 기록 조회 메서드
    public List<AttendanceQuery> getAllAttendanceRecords() {
        List<AttendanceQuery> attendanceList = new ArrayList<>();

        String query = "SELECT e.shain_ID, e.shain_namae, e.bu, e.yakushoku, e.koyou_keitai, " +
                       "k.kintai_bi, k.kintai_ID, k.kinngaku, k.kintai_zikan, k.bikou, " +
                       "k.nyuryoku_bi AS inputDate, " +
                       "k_koumoku.kintai_shurui AS attendanceItem " +
                       "FROM shain_touroku e " +
                       "JOIN kintai_kiroku k ON e.shain_ID = k.shain_ID " +
                       "JOIN kintai_koumoku_settei k_koumoku ON k.kintai_ID = k_koumoku.kintai_ID " +
                       "ORDER BY e.shain_ID, k.kintai_bi";

        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                AttendanceQuery attendance = new AttendanceQuery();

                // Employee Details
                attendance.setEmployeeId(rs.getInt("shain_ID"));
                attendance.setEmployeeName(rs.getString("shain_namae"));
                attendance.setDepartment(rs.getString("bu"));
                attendance.setPosition(rs.getString("yakushoku"));
                attendance.setCategory(rs.getString("koyou_keitai")); // 고용형태

                // Attendance Details
                attendance.setAttendanceDate(rs.getDate("kintai_bi"));
                attendance.setAttendanceType(rs.getInt("kintai_ID"));
                attendance.setAmount(rs.getInt("kinngaku"));
                attendance.setHours(rs.getInt("kintai_zikan"));
                attendance.setBikou(rs.getString("bikou"));
                attendance.setInputDate(rs.getDate("inputDate"));
                attendance.setAttendanceItem(rs.getString("attendanceItem"));

                // 근태기간 계산
                Date attendanceDate = rs.getDate("kintai_bi");
                int hours = rs.getInt("kintai_zikan");
                if (attendanceDate != null && hours > 0) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(attendanceDate);
                    calendar.add(Calendar.HOUR, hours);
                    Date endDate = new Date(calendar.getTime().getTime());
                    attendance.setAttendancePeriod(
                        attendanceDate.toString() + " ~ " + endDate.toString()
                    );
                } else {
                    attendance.setAttendancePeriod(attendanceDate != null ? attendanceDate.toString() : "N/A");
                }

                // 근태일수 계산
                attendance.setAttendanceDays((hours / 24) + ((hours % 24) > 0 ? 1 : 0));

                attendanceList.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceList;
    }
    
    public List<AttendanceQuery> getFilteredAttendanceRecords(
            boolean inputDateCheck, String inputDate, String department, 
            String employeeName, String attendanceGroup, 
            String attendanceItem, String vacationItem, 
            String attendanceStartDate, String attendanceEndDate, String bikou) {

        List<AttendanceQuery> attendanceList = new ArrayList<>();
        StringBuilder query = new StringBuilder(
                "SELECT e.shain_ID, e.shain_namae, e.bu, e.yakushoku, e.koyou_keitai, " +
                "k.kintai_bi, k.kintai_ID, k.kinngaku, k.kintai_zikan, k.bikou, " +
                "k.nyuryoku_bi AS inputDate, " +
                "k_koumoku.kintai_shurui AS attendanceItem " +
                "FROM shain_touroku e " +
                "JOIN kintai_kiroku k ON e.shain_ID = k.shain_ID " +
                "JOIN kintai_koumoku_settei k_koumoku ON k.kintai_ID = k_koumoku.kintai_ID " +
                "WHERE 1=1");

        // 조건에 따른 쿼리 생성
        if (inputDateCheck && inputDate != null && !inputDate.isEmpty()) {
            query.append(" AND k.nyuryoku_bi = TO_DATE(?, 'YYYY-MM-DD')");
        }
        if (department != null && !department.isEmpty()) {
            query.append(" AND e.bu = ?");
        }
        if (employeeName != null && !employeeName.isEmpty()) {
            query.append(" AND e.shain_namae = ?");
        }
        if (attendanceGroup != null && !attendanceGroup.isEmpty()) {
            query.append(" AND k_koumoku.kintai_shurui = ?");
        }
        if (attendanceItem != null && !attendanceItem.isEmpty()) {
            query.append(" AND k_koumoku.kintai_shurui = ?");
        }
        if (vacationItem != null && !vacationItem.isEmpty()) {
            query.append(" AND k.kintai_ID = (SELECT kintai_ID FROM kyuuka_koumoku_settei WHERE kyuuka_shurui = ?)");
        }
        if (attendanceStartDate != null && !attendanceStartDate.isEmpty()) {
            query.append(" AND k.kintai_bi >= TO_DATE(?, 'YYYY-MM-DD')");
        }
        if (attendanceEndDate != null && !attendanceEndDate.isEmpty()) {
            query.append(" AND k.kintai_bi <= TO_DATE(?, 'YYYY-MM-DD')");
        }
        if (bikou != null && !bikou.isEmpty()) {
            query.append(" AND k.bikou = ?");
        }
        
        

        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query.toString())) {

            // 조건에 맞게 파라미터 설정
            int paramIndex = 1;
            if (inputDateCheck && inputDate != null && !inputDate.isEmpty()) {
                pstmt.setString(paramIndex++, inputDate);
            }
            if (department != null && !department.isEmpty()) {
                pstmt.setString(paramIndex++, department);
            }
            if (employeeName != null && !employeeName.isEmpty()) {
                pstmt.setString(paramIndex++, employeeName);
            }
            if (attendanceGroup != null && !attendanceGroup.isEmpty()) {
                pstmt.setString(paramIndex++, attendanceGroup);
            }
            if (attendanceItem != null && !attendanceItem.isEmpty()) {
                pstmt.setString(paramIndex++, attendanceItem);
            }
            if (vacationItem != null && !vacationItem.isEmpty()) {
                pstmt.setString(paramIndex++, vacationItem);
            }
            if (attendanceStartDate != null && !attendanceStartDate.isEmpty()) {
                pstmt.setString(paramIndex++, attendanceStartDate);
            }
            if (attendanceEndDate != null && !attendanceEndDate.isEmpty()) {
                pstmt.setString(paramIndex++, attendanceEndDate);
            }
            if (bikou != null && !bikou.isEmpty()) {
                pstmt.setString(paramIndex++, bikou);
            }

            ResultSet rs = pstmt.executeQuery();

            // 결과 처리
            while (rs.next()) {
                AttendanceQuery attendance = new AttendanceQuery();
                attendance.setEmployeeId(rs.getInt("shain_ID"));
                attendance.setEmployeeName(rs.getString("shain_namae"));
                attendance.setDepartment(rs.getString("bu"));
                attendance.setPosition(rs.getString("yakushoku"));
                attendance.setCategory(rs.getString("koyou_keitai"));
                attendance.setAttendanceDate(rs.getDate("kintai_bi"));
                attendance.setAttendanceType(rs.getInt("kintai_ID"));
                attendance.setAmount(rs.getInt("kinngaku"));
                attendance.setHours(rs.getInt("kintai_zikan"));
                attendance.setBikou(rs.getString("bikou"));
                attendance.setInputDate(rs.getDate("inputDate"));
                attendance.setAttendanceItem(rs.getString("attendanceItem"));

                // 근태기간 계산
                Date attendanceDate = rs.getDate("kintai_bi");
                int hours = rs.getInt("kintai_zikan");
                if (attendanceDate != null && hours > 0) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(attendanceDate);
                    calendar.add(Calendar.HOUR, hours);
                    Date endDate = new Date(calendar.getTimeInMillis());
                    attendance.setAttendancePeriod(
                        attendanceDate.toString() + " ~ " + endDate.toString()
                    );
                } else {
                    attendance.setAttendancePeriod(attendanceDate != null ? attendanceDate.toString() : "N/A");
                }
                attendance.setAttendanceDays((hours / 24) + ((hours % 24) > 0 ? 1 : 0));

                attendanceList.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceList;
    }
    
    
}
