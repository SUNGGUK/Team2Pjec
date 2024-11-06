package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.busho_settei;

//-- 4. 부서 테이블 (busho_settei)
//-- 4. 部署テーブル (busho_settei)
public class busho_setteiDao {

    // 부서 정보 삽입 / 部署情報挿入
    public busho_settei insert(Connection conn, busho_settei bushoSettei) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            String insertQuery = "INSERT INTO busho_settei (shain_id, busho_mei) VALUES (?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, bushoSettei.getShain_id());
            pstmt.setString(2, bushoSettei.getBusho_mei());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                return bushoSettei;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(pstmt);
        }
    }

    // 모든 부서 정보 조회 / すべての部署情報を取得
    public List<busho_settei> getAllBusho(Connection conn) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<busho_settei> bushoList = new ArrayList<>();

        try {
            String selectQuery = "SELECT shain_id, busho_mei FROM busho_settei";
            pstmt = conn.prepareStatement(selectQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int shain_id = rs.getInt("shain_id");
                String busho_mei = rs.getString("busho_mei");
                bushoList.add(new busho_settei(shain_id, busho_mei));
            }
            return bushoList;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
