package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.shoubatsu;

//-- 15. 상벌 테이블 (shoubatsu)
//-- 15. 賞罰テーブル (shoubatsu)
public class shoubatsuDao {

    // 상벌 정보를 삽입하는 메서드 / 賞罰情報を挿入するメソッド
    public shoubatsu insert(Connection conn, shoubatsu shoubatsu) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO shoubatsu (shain_ID, shoubatsu_mei, kantoku_kikan, shoubatsu_bi, naiyou, bikou) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, shoubatsu.getShain_ID()); // 사원 ID / 社員ID
            pstmt.setString(2, shoubatsu.getShoubatsu_mei()); // 상벌명 / 賞罰名
            pstmt.setString(3, shoubatsu.getKantoku_kikan()); // 감독 기관 / 監督機関
            pstmt.setDate(4, shoubatsu.getShoubatsu_bi()); // 상벌 일자 / 賞罰日
            pstmt.setString(5, shoubatsu.getNaiyou()); // 내용 / 内容
            pstmt.setString(6, shoubatsu.getBikou()); // 비고 / 備考

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return shoubatsu;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
