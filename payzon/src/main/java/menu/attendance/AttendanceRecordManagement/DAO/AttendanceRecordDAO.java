package menu.attendance.AttendanceRecordManagement.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import menu.attendance.AttendanceRecordManagement.Model.AttendanceRecord;

public class AttendanceRecordDAO {

    private static AttendanceRecordDAO instance = new AttendanceRecordDAO();

    public static AttendanceRecordDAO getInstance() {
        return instance;
    }

    // 모든 사원의 간단한 정보 조회
    public List<AttendanceRecord> selectAllEmployees() throws SQLException {
        String sql = "SELECT koyou_keitai AS employment_type, shain_ID AS shain_id, shain_namae AS shain_name, bu AS department, yakushoku "
                   + "FROM shain_touroku "
                   + "ORDER BY shain_ID ASC";

        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            List<AttendanceRecord> employeeList = new ArrayList<>();
            while (rs.next()) {
                AttendanceRecord record = new AttendanceRecord();
                record.setEmployment_type(rs.getString("employment_type"));
                record.setShain_id(rs.getInt("shain_id"));
                record.setShain_name(rs.getString("shain_name"));
                record.setDepartment(rs.getString("department"));
                record.setYakushoku(rs.getString("yakushoku"));
                employeeList.add(record);
            }
            return employeeList;
        }
    }

    // 특정 사원의 근태 기록과 휴가 상태를 모두 조회
    public List<AttendanceRecord> selectEmployeeData(int employeeId) throws SQLException {
        String sql = "SELECT k.kintai_kiroku_ID, k.kintai_bi, k.kinngaku, k.kintai_zikan, k.bikou,\r\n"
        		+ "       s.shain_namae, s.bu, s.yakushoku,\r\n"
        		+ "       ks.kintai_shurui, kn.kyuuka_shurui, kn.kyuuka_nissuu, kn.shiyou_kyuuka_nissuu, kn.nokori_kyuuka_nissuu\r\n"
        		+ "FROM kintai_kiroku k\r\n"
        		+ "JOIN shain_touroku s ON k.shain_ID = s.shain_ID\r\n"
        		+ "JOIN kintai_koumoku_settei ks ON k.kintai_ID = ks.kintai_ID\r\n"
        		+ "LEFT JOIN kyuuka_nissuu kn ON k.shain_ID = kn.shain_ID\r\n"
        		+ "WHERE k.shain_ID = <employeeId>";

        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, employeeId);

            try (ResultSet rs = pstmt.executeQuery()) {
                List<AttendanceRecord> records = new ArrayList<>();
                while (rs.next()) {
                    AttendanceRecord record = new AttendanceRecord();
                    record.setKintai_kiroku_id(rs.getInt("kintai_kiroku_ID"));
                    record.setKintai_bi(rs.getDate("kintai_bi"));
                    record.setKinngaku(rs.getInt("kinngaku"));
                    record.setKintai_zikan(rs.getInt("kintai_zikan"));
                    record.setBikou(rs.getString("bikou"));
                    
                    // Employee details
                    record.setShain_name(rs.getString("shain_namae"));
                    record.setDepartment(rs.getString("bu"));
                    record.setYakushoku(rs.getString("yakushoku"));
                    
                    // Attendance and leave types
                    record.setKintai_shurui(rs.getString("kintai_shurui"));
                    record.setKyuuka_shurui(rs.getString("kyuuka_shurui"));
                    record.setKyuuka_nissuu(rs.getInt("kyuuka_nissuu"));
                    record.setShiyou_kyuuka_nissuu(rs.getInt("shiyou_kyuuka_nissuu"));
                    record.setNokori_kyuuka_nissuu(rs.getInt("nokori_kyuuka_nissuu"));
                    
                    records.add(record);
                }
                System.out.println("Retrieved records for employeeId " + employeeId + ": " + records);
                return records;
            }
        }
    }


    // 새로운 근태 기록 삽입
    public void insertAttendanceRecord(AttendanceRecord record) throws SQLException {
        String sql = "INSERT INTO kintai_kiroku (kintai_kiroku_ID, shain_ID, kintai_ID, kintai_bi, kinngaku, kintai_zikan, bikou) "
                   + "VALUES (kintai_seq.nextval, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, record.getShain_id());
            pstmt.setInt(2, record.getKintai_id());
            pstmt.setDate(3, new java.sql.Date(record.getKintai_bi().getTime()));
            pstmt.setInt(4, record.getKinngaku());
            pstmt.setInt(5, record.getKintai_zikan());
            pstmt.setString(6, record.getBikou());
            pstmt.executeUpdate();
        }
    }

    // 근태 기록 수정
    public void updateAttendanceRecord(AttendanceRecord record) throws SQLException {
        String sql = "UPDATE kintai_kiroku SET kintai_ID = ?, kintai_bi = ?, kinngaku = ?, kintai_zikan = ?, bikou = ? "
                   + "WHERE kintai_kiroku_ID = ?";
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, record.getKintai_id());
            pstmt.setDate(2, new java.sql.Date(record.getKintai_bi().getTime()));
            pstmt.setInt(3, record.getKinngaku());
            pstmt.setInt(4, record.getKintai_zikan());
            pstmt.setString(5, record.getBikou());
            pstmt.setInt(6, record.getKintai_kiroku_id());
            pstmt.executeUpdate();
        }
    }

    // 근태 기록 삭제
    public void deleteAttendanceRecord(int recordId) throws SQLException {
        String sql = "DELETE FROM kintai_kiroku WHERE kintai_kiroku_ID = ?";
        try (Connection conn = ConnectionProvider.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, recordId);
            pstmt.executeUpdate();
        }
    }

    // ResultSet에서 AttendanceRecord 객체로 변환
    private AttendanceRecord convertAttendanceRecord(ResultSet rs) throws SQLException {
        return new AttendanceRecord(
            rs.getInt("KINTAI_KIROKU_ID"),    // 근태 기록 ID
            rs.getInt("SHAIN_ID"),            // 사원 ID
            rs.getInt("KINTAI_ID"),           // 근태 항목 ID
            rs.getDate("KINTAI_BI"),          // 근태 일자
            rs.getInt("KINNGAKU"),            // 금액
            rs.getInt("KINTAI_ZIKAN"),        // 근태 시간
            rs.getString("BIKOU"),            // 비고
            rs.getString("SHAIN_NAMAE"),      // 사원 이름
            rs.getString("KOYOU_KEITAI"),     // 고용 형태
            rs.getString("BU"),               // 부서
            rs.getString("YAKUSHOKU"),        // 직위
            rs.getString("KINTAI_SHURUI")     // 근태 항목 종류
        );
    }
}


/*
 * //AttendanceRecordDAO.java package
 * menu.attendance.AttendanceRecordManagement.DAO;
 * 
 * import java.sql.Connection; import java.sql.PreparedStatement; import
 * java.sql.ResultSet; import java.sql.SQLException; import java.util.ArrayList;
 * import java.util.List;
 * 
 * import jdbc.connection.ConnectionProvider; import
 * menu.attendance.AttendanceRecordManagement.Model.AttendanceRecord;
 * 
 * public class AttendanceRecordDAO {
 * 
 * private static AttendanceRecordDAO instance = new AttendanceRecordDAO();
 * 
 * public static AttendanceRecordDAO getInstance() { return instance; }
 * 
 * // 모든 사원의 간단한 정보 조회 public List<AttendanceRecord> selectAllEmployees() throws
 * SQLException { String sql =
 * "SELECT koyou_keitai AS employment_type, shain_ID AS shain_id, shain_namae AS shain_name, bu AS department, yakushoku "
 * + "FROM shain_touroku " + "ORDER BY shain_ID ASC";
 * 
 * try (Connection conn = ConnectionProvider.getConnection(); PreparedStatement
 * pstmt = conn.prepareStatement(sql); ResultSet rs = pstmt.executeQuery()) {
 * 
 * List<AttendanceRecord> employeeList = new ArrayList<>(); while (rs.next()) {
 * AttendanceRecord record = new AttendanceRecord();
 * record.setEmployment_type(rs.getString("employment_type"));
 * record.setShain_id(rs.getInt("shain_id"));
 * record.setShain_name(rs.getString("shain_name"));
 * record.setDepartment(rs.getString("department"));
 * record.setYakushoku(rs.getString("yakushoku")); employeeList.add(record); }
 * return employeeList; } }
 * 
 * // 특정 사원의 연도별 근태 기록 조회 public List<AttendanceRecord>
 * selectEmployeeAttendanceRecords(int employeeId) throws SQLException { String
 * sql =
 * "SELECT k.kintai_kiroku_ID, k.shain_ID, k.kintai_ID, k.kintai_bi, k.kinngaku, k.kintai_zikan, k.bikou, "
 * + "s.shain_namae, s.bu, s.yakushoku, kks.kintai_shurui " +
 * "FROM kintai_kiroku k " + "JOIN shain_touroku s ON k.shain_ID = s.shain_ID "
 * + "JOIN kintai_koumoku_settei kks ON k.kintai_ID = kks.kintai_ID " +
 * "WHERE k.shain_ID = ? " + "ORDER BY k.kintai_kiroku_ID DESC";
 * 
 * try (Connection conn = ConnectionProvider.getConnection(); PreparedStatement
 * pstmt = conn.prepareStatement(sql)) { pstmt.setInt(1, employeeId); try
 * (ResultSet rs = pstmt.executeQuery()) { List<AttendanceRecord> records = new
 * ArrayList<>(); while (rs.next()) { AttendanceRecord record =
 * convertAttendanceRecord(rs); records.add(record); } return records; } } }
 * 
 * // 새로운 근태 기록 삽입 public void insertAttendanceRecord(AttendanceRecord record)
 * throws SQLException { String sql =
 * "INSERT INTO kintai_kiroku (kintai_kiroku_ID, shain_ID, kintai_ID, kintai_bi, kinngaku, kintai_zikan, bikou) "
 * + "VALUES (kintai_seq.nextval, ?, ?, ?, ?, ?, ?)"; try (Connection conn =
 * ConnectionProvider.getConnection(); PreparedStatement pstmt =
 * conn.prepareStatement(sql)) { pstmt.setInt(1, record.getShain_id());
 * pstmt.setInt(2, record.getKintai_id()); pstmt.setDate(3, new
 * java.sql.Date(record.getKintai_bi().getTime())); pstmt.setInt(4,
 * record.getKinngaku()); pstmt.setInt(5, record.getKintai_zikan());
 * pstmt.setString(6, record.getBikou()); pstmt.executeUpdate(); } }
 * 
 * // 근태 기록 수정 public void updateAttendanceRecord(AttendanceRecord record)
 * throws SQLException { String sql =
 * "UPDATE kintai_kiroku SET kintai_ID = ?, kintai_bi = ?, kinngaku = ?, kintai_zikan = ?, bikou = ? "
 * + "WHERE kintai_kiroku_ID = ?"; try (Connection conn =
 * ConnectionProvider.getConnection(); PreparedStatement pstmt =
 * conn.prepareStatement(sql)) { pstmt.setInt(1, record.getKintai_id());
 * pstmt.setDate(2, new java.sql.Date(record.getKintai_bi().getTime()));
 * pstmt.setInt(3, record.getKinngaku()); pstmt.setInt(4,
 * record.getKintai_zikan()); pstmt.setString(5, record.getBikou());
 * pstmt.setInt(6, record.getKintai_kiroku_id()); pstmt.executeUpdate(); } }
 * 
 * // 근태 기록 삭제 public void deleteAttendanceRecord(int recordId) throws
 * SQLException { String sql =
 * "DELETE FROM kintai_kiroku WHERE kintai_kiroku_ID = ?"; try (Connection conn
 * = ConnectionProvider.getConnection(); PreparedStatement pstmt =
 * conn.prepareStatement(sql)) { pstmt.setInt(1, recordId);
 * pstmt.executeUpdate(); } }
 * 
 * // 특정 사원의 휴가 일수 현황 조회 // AttendanceRecordDAO.java
 * 
 * public List<AttendanceRecord> selectEmployeeAttendanceRecords(int employeeId,
 * int year) throws SQLException { String sql =
 * "SELECT k.KINTAI_KIROKU_ID, k.SHAIN_ID, k.KINTAI_ID, k.KINTAI_BI, k.KINNGAKU, k.KINTAI_ZIKAN, k.BIKOU, "
 * + "s.SHAIN_NAMAE, s.BU, s.KOYOU_KEITAI, s.YAKUSHOKU, kks.KINTAI_SHURUI " +
 * "FROM KINTAI_KIROKU k " + "JOIN SHAIN_TOUROKU s ON k.SHAIN_ID = s.SHAIN_ID "
 * + "JOIN KINTAI_KOUMOKU_SETTEI kks ON k.KINTAI_ID = kks.KINTAI_ID " +
 * "WHERE k.SHAIN_ID = ? AND EXTRACT(YEAR FROM k.KINTAI_BI) = ? " +
 * "ORDER BY k.KINTAI_KIROKU_ID DESC";
 * 
 * try (Connection conn = ConnectionProvider.getConnection(); PreparedStatement
 * pstmt = conn.prepareStatement(sql)) { pstmt.setInt(1, employeeId);
 * pstmt.setInt(2, year);
 * 
 * try (ResultSet rs = pstmt.executeQuery()) { List<AttendanceRecord> records =
 * new ArrayList<>(); while (rs.next()) { AttendanceRecord record =
 * convertAttendanceRecord(rs); records.add(record); } return records; } } }
 * 
 * // AttendanceRecordDAO 클래스의 selectEmployeeLeaveStatus 메서드 public
 * List<AttendanceRecord> selectEmployeeLeaveStatus(int employeeId) throws
 * SQLException { String sql =
 * "SELECT kn.koyou_keitai, kn.shain_ID, kn.shain_namae, kn.bu, kn.yakushoku, "
 * +
 * "kn.kyuuka_nissuu, kn.shiyou_kyuuka_nissuu, kn.nokori_kyuuka_nissuu, ks.kyuuka_shurui "
 * + "FROM kyuuka_nissuu kn " +
 * "JOIN kyuuka_koumoku_settei ks ON kn.kyuuka_shurui = ks.kyuuka_shurui " +
 * "WHERE kn.shain_ID = ?";
 * 
 * try (Connection conn = ConnectionProvider.getConnection(); PreparedStatement
 * pstmt = conn.prepareStatement(sql)) { pstmt.setInt(1, employeeId); try
 * (ResultSet rs = pstmt.executeQuery()) { List<AttendanceRecord> leaveRecords =
 * new ArrayList<>(); while (rs.next()) { AttendanceRecord record = new
 * AttendanceRecord(); record.setShain_id(rs.getInt("shain_ID"));
 * record.setEmployment_type(rs.getString("koyou_keitai"));
 * record.setShain_name(rs.getString("shain_namae"));
 * record.setDepartment(rs.getString("bu"));
 * record.setYakushoku(rs.getString("yakushoku"));
 * record.setKyuuka_nissuu(rs.getInt("kyuuka_nissuu"));
 * record.setShiyou_kyuuka_nissuu(rs.getInt("shiyou_kyuuka_nissuu"));
 * record.setNokori_kyuuka_nissuu(rs.getInt("nokori_kyuuka_nissuu"));
 * record.setKyuuka_shurui(rs.getString("kyuuka_shurui"));
 * leaveRecords.add(record); } return leaveRecords; } } }
 * 
 * 
 * // ResultSet에서 AttendanceRecord 객체로 변환 private AttendanceRecord
 * convertAttendanceRecord(ResultSet rs) throws SQLException { return new
 * AttendanceRecord( rs.getInt("KINTAI_KIROKU_ID"), // 근태 기록 ID
 * rs.getInt("SHAIN_ID"), // 사원 ID rs.getInt("KINTAI_ID"), // 근태 항목 ID
 * rs.getDate("KINTAI_BI"), // 근태 일자 rs.getInt("KINNGAKU"), // 금액
 * rs.getInt("KINTAI_ZIKAN"), // 근태 시간 rs.getString("BIKOU"), // 비고
 * rs.getString("SHAIN_NAMAE"), // 사원 이름 rs.getString("KOYOU_KEITAI"), // 고용 형태
 * rs.getString("BU"), // 부서 rs.getString("YAKUSHOKU"), // 직위
 * rs.getString("KINTAI_SHURUI") // 근태 항목 종류 ); } }
 */