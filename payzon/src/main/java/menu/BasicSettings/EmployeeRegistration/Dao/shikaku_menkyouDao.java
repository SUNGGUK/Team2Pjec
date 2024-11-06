package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.shikaku_menkyou;

//-- 12. 자격 면허 테이블 (shikaku_menkyou)
//-- 12. 資格免許テーブル (shikaku_menkyou)
public class shikaku_menkyouDao {

    // 자격 면허 정보 삽입 / 資格免許情報の挿入
    public shikaku_menkyou insert(Connection conn, shikaku_menkyou shikaku) throws SQLException {
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            String sql = "INSERT INTO shikaku_menkyou (shain_ID, shikaku_mei, hakkyuu_bi, hakkyuu_kikan_mei, shikakushou_bangou, biko) " +
                         "VALUES (?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, shikaku.getShain_ID()); // 사원 ID / 社員ID
            pstmt.setString(2, shikaku.getShikaku_mei()); // 자격 명칭 / 資格名称
            pstmt.setDate(3, shikaku.getHakkyuu_bi()); // 발급일 / 発給日
            pstmt.setString(4, shikaku.getHakkyuu_kikan_mei()); // 발급 기관명 / 発給機関名
            pstmt.setString(5, shikaku.getShikakushou_bangou()); // 자격증 번호 / 資格証番号
            pstmt.setString(6, shikaku.getBiko()); // 비고 / 備考

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                return shikaku;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(rs);
            JdbcUtil.close(pstmt);
        }
    }
}
