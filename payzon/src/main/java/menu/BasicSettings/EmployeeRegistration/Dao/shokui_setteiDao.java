package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.shokui_settei;

//-- 5. 직위 테이블 (shokui_settei)
//-- 5. 職位テーブル (shokui_settei)
public class shokui_setteiDao {

    // 직위 정보 삽입 / 職位情報の挿入
    public shokui_settei insert(Connection conn, shokui_settei shokuiSettei) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            String insertQuery = "INSERT INTO shokui_settei (shain_id, shokui_mei) VALUES (?, ?)";
            pstmt = conn.prepareStatement(insertQuery);
            pstmt.setInt(1, shokuiSettei.getShain_id()); // 사원 ID / 社員ID
            pstmt.setString(2, shokuiSettei.getShokui_mei()); // 직위명 / 職位名

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                return shokuiSettei;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(pstmt);
        }
    }

    // 모든 직위 정보 조회 / 全ての職位情報の取得
    public List<shokui_settei> getAllShokui(Connection conn) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        List<shokui_settei> shokuiList = new ArrayList<>();

        try {
            String selectQuery = "SELECT shain_id, shokui_mei FROM shokui_settei";
            pstmt = conn.prepareStatement(selectQuery);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                int shain_id = rs.getInt("shain_id"); // 사원 ID / 社員ID
                String shokui_mei = rs.getString("shokui_mei"); // 직위명 / 職位名
                shokuiList.add(new shokui_settei(shain_id, shokui_mei));
            }
            return shokuiList;
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
