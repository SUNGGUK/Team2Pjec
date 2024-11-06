package menu.retirement.RetirementPayInputManagement.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import menu.retirement.RetirementPayInputManagement.Model.RetirementPayshain;

public class RetirementPayshainRightDAO {

    private static RetirementPayshainRightDAO instance = new RetirementPayshainRightDAO();

    public static RetirementPayshainRightDAO getInstance() {
        return instance;
    }

    // ResultSet을 RetirementPayshain 객체로 변환하는 메서드
    private RetirementPayshain convertRetirementPayshain(ResultSet rs) throws SQLException {
        return new RetirementPayshain(
                rs.getString("koyou_keitai"),
                rs.getString("shain_ID"),
                rs.getString("shain_namae"),
                rs.getString("bu"),
                rs.getString("yakushoku"),
                rs.getString("zyoutai")
        );
    }

    // 부서로 필터링하여 사원 정보를 조회하는 메서드
    public List<RetirementPayshain> selectByDepartment(Connection conn, String department, int currentPage, int recordsPerPage) throws SQLException {
        List<RetirementPayshain> list = new ArrayList<>();

        // SQL 쿼리 작성
        StringBuilder sql = new StringBuilder(
                "SELECT * FROM (" +
                "    SELECT s.koyou_keitai, s.shain_id, s.shain_namae, s.bu, s.yakushoku, t.zyoutai, ROWNUM rnum " +
                "    FROM shain_touroku s " +
                "    JOIN taishoku t ON s.shain_id = t.shain_id " +
                "    WHERE 1=1");

        // 부서 필터 추가
        if (department != null && !department.isEmpty()) {
            sql.append(" AND s.bu = ?");
        }

        sql.append(" ORDER BY s.shain_ID DESC" +
                   " ) WHERE rnum BETWEEN ? AND ?");

        try (PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
            int paramIndex = 1;

            // 부서 필터가 있는 경우 파라미터 설정
            if (department != null && !department.isEmpty()) {
                pstmt.setString(paramIndex++, department);
            }

            pstmt.setInt(paramIndex++, (currentPage - 1) * recordsPerPage + 1);
            pstmt.setInt(paramIndex, currentPage * recordsPerPage);

            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    list.add(convertRetirementPayshain(rs));
                }
            }
        }
        return list;
    }

    // 특정 사원의 정보를 조회하는 메서드
    public RetirementPayshain selectById(Connection conn, String shainID) throws SQLException {
        String sql = "SELECT s.koyou_keitai, s.shain_id, s.shain_namae, s.bu, s.yakushoku, t.zyoutai " +
                     "FROM shain_touroku s " +
                     "JOIN taishoku t ON s.shain_id = t.shain_id " +
                     "WHERE s.shain_ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, shainID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return convertRetirementPayshain(rs);
                }
                return null;
            }
        }
    }
}
