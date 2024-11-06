package menu.payroll.PayrollInputManagement.DAO;

import jdbc.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollInputDAO {

    // 급여 정보 입력 메서드
    // 給与情報入力メソッド
    public void inputPayroll(int shainId, double shikyuuzoukyuu, double kihonkyu, double shokujitane, double hoikutane, 
                             double yakushokutane, double sharyouijihi, double kinzokutane, double touchakutane, 
                             double shouyo, double kyuujitsutane, String kazeiUmu, String zessaTani, 
                             String kintaiIkatsu, double ikkatsuShikyuugaku, String shiyouUmu, String keisanHouhou,
                             int koujoId, double koujoSougaku, double shotokuzei, double chihoShotokuzei,
                             String koujoKamoku, double daibuHoken, double kikandaniShotokuzei, double kokuminNenkin,
                             double kenkouHoken, double choukikaigoHoken, double koyouHoken, double gojokaihi,
                             String koujoZessaTani, String koujoShiyouUmu, String koujoBikou, String koujoKeisanHouhou) {
        
        String insertShiharaiSql = "INSERT INTO total_shiharai (total_kingaku, shain_ID, shikyuuzoukyuu, kihonkyu, shokujitane, hoikutane, yakushokutane, sharyouijihi, kinzokutane, touchakutane, shouyo, kyuujitsutane, kazei_umu, zessa_tani, kintai_ikkatsu, ikkatsu_shikyuugaku, shiyou_umu, keisan_houhou) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        String insertKouzyoSql = "INSERT INTO total_kouzyo (koujo_id, shain_ID, koujo_sougaku, shotokuzei, chiho_shotokuzei, koujokamoku, daibu_hoken, kikandani_shotokuzei, kokumin_nenkin, kenkou_hoken, choukikaigo_hoken, koyou_hoken, gojokaihi, zessa_tani, shiyou_umu, bikou, keisan_houhou) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmtShiharai = conn.prepareStatement(insertShiharaiSql);
             PreparedStatement pstmtKouzyo = conn.prepareStatement(insertKouzyoSql)) {

            // 급여 정보 입력
            // 給与情報を入力する
            pstmtShiharai.setInt(1, 0);
            pstmtShiharai.setInt(2, shainId);
            pstmtShiharai.setDouble(3, shikyuuzoukyuu);
            pstmtShiharai.setDouble(4, kihonkyu);
            pstmtShiharai.setDouble(5, shokujitane);
            pstmtShiharai.setDouble(6, hoikutane);
            pstmtShiharai.setDouble(7, yakushokutane);
            pstmtShiharai.setDouble(8, sharyouijihi);
            pstmtShiharai.setDouble(9, kinzokutane);
            pstmtShiharai.setDouble(10, touchakutane);
            pstmtShiharai.setDouble(11, shouyo);
            pstmtShiharai.setDouble(12, kyuujitsutane);
            pstmtShiharai.setString(13, kazeiUmu);
            pstmtShiharai.setString(14, zessaTani);
            pstmtShiharai.setString(15, kintaiIkatsu);
            pstmtShiharai.setDouble(16, ikkatsuShikyuugaku);
            pstmtShiharai.setString(17, shiyouUmu);
            pstmtShiharai.setString(18, keisanHouhou);

            pstmtShiharai.executeUpdate();

            // 공제 정보 입력
            // 控除情報を入力する
            pstmtKouzyo.setInt(1, koujoId);
            pstmtKouzyo.setInt(2, shainId);
            pstmtKouzyo.setDouble(3, koujoSougaku);
            pstmtKouzyo.setDouble(4, shotokuzei);
            pstmtKouzyo.setDouble(5, chihoShotokuzei);
            pstmtKouzyo.setString(6, koujoKamoku);
            pstmtKouzyo.setDouble(7, daibuHoken);
            pstmtKouzyo.setDouble(8, kikandaniShotokuzei);
            pstmtKouzyo.setDouble(9, kokuminNenkin);
            pstmtKouzyo.setDouble(10, kenkouHoken);
            pstmtKouzyo.setDouble(11, choukikaigoHoken);
            pstmtKouzyo.setDouble(12, koyouHoken);
            pstmtKouzyo.setDouble(13, gojokaihi);
            pstmtKouzyo.setString(14, koujoZessaTani);
            pstmtKouzyo.setString(15, koujoShiyouUmu);
            pstmtKouzyo.setString(16, koujoBikou);
            pstmtKouzyo.setString(17, koujoKeisanHouhou);

            pstmtKouzyo.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 사원 ID로 급여 및 공제 정보 조회 메서드
    // 社員IDで給与および控除情報を取得するメソッド
    public List<String[]> getPayrollByShainId(int shainId) {
        List<String[]> payrollList = new ArrayList<>();
        String sql = "SELECT st.koyou_keitai, st.shain_namae, st.bu, ts.shikyuuzoukyuu, tk.koujo_sougaku " +
                     "FROM total_shiharai ts " +
                     "JOIN total_kouzyo tk ON ts.shain_ID = tk.shain_ID " +
                     "JOIN shain_touroku st ON ts.shain_ID = st.shain_ID " +
                     "WHERE ts.shain_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shainId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                String[] payrollInfo = new String[5]; // 배열 크기를 5로 변경
                payrollInfo[0] = rs.getString("koyou_keitai"); // 고용 형태
                payrollInfo[1] = rs.getString("shain_namae"); // 사원 이름
                payrollInfo[2] = rs.getString("bu"); // 부서
                payrollInfo[3] = String.valueOf(rs.getDouble("shikyuuzoukyuu")); // 급여
                payrollInfo[4] = String.valueOf(rs.getDouble("koujo_sougaku")); // 공제
                payrollList.add(payrollInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payrollList;
    }
}
