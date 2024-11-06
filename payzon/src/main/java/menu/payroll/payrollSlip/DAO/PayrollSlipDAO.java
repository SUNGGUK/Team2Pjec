package menu.payroll.payrollSlip.DAO;

import jdbc.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PayrollSlipDAO {

    // 급여 정보 입력 메서드 (給与情報入力メソッド)
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

            // 급여 정보 입력 (給与情報を入力)
            pstmtShiharai.setInt(1, 0); // 총 지급 항목 ID (合計支給項目ID)
            pstmtShiharai.setInt(2, shainId); // 사원 ID (社員ID)
            pstmtShiharai.setDouble(3, shikyuuzoukyuu); // 지급 총액 (支給総額)
            pstmtShiharai.setDouble(4, kihonkyu); // 기본급 (基本給)
            pstmtShiharai.setDouble(5, shokujitane); // 식사 수당 (食事手当)
            pstmtShiharai.setDouble(6, hoikutane); // 보육 수당 (保育手当)
            pstmtShiharai.setDouble(7, yakushokutane); // 직책 수당 (役職手当)
            pstmtShiharai.setDouble(8, sharyouijihi); // 차량 유지비 (車両維持費)
            pstmtShiharai.setDouble(9, kinzokutane); // 근속 수당 (勤続手当)
            pstmtShiharai.setDouble(10, touchakutane); // 당직 수당 (当直手当)
            pstmtShiharai.setDouble(11, shouyo); // 보너스 (賞与)
            pstmtShiharai.setDouble(12, kyuujitsutane); // 휴일 수당 (休日手当)
            pstmtShiharai.setString(13, kazeiUmu); // 과세 여부 (課税の有無)
            pstmtShiharai.setString(14, zessaTani); // 절사 단위 (切捨て単位)
            pstmtShiharai.setString(15, kintaiIkatsu); // 근태 연결/일괄 지급 (勤怠連携/一括支給)
            pstmtShiharai.setDouble(16, ikkatsuShikyuugaku); // 일괄 지급액 (一括支給額)
            pstmtShiharai.setString(17, shiyouUmu); // 사용 여부 (使用の有無)
            pstmtShiharai.setString(18, keisanHouhou); // 계산 방법 (計算方法)

            pstmtShiharai.executeUpdate(); // 급여 정보 삽입 실행 (給与情報の挿入を実行)

            // 공제 정보 입력 (控除情報を入力)
            pstmtKouzyo.setInt(1, koujoId); // 공제 항목 ID (控除項目ID)
            pstmtKouzyo.setInt(2, shainId); // 사원 ID (社員ID)
            pstmtKouzyo.setDouble(3, koujoSougaku); // 공제 총액 (控除総額)
            pstmtKouzyo.setDouble(4, shotokuzei); // 소득세 (所得税)
            pstmtKouzyo.setDouble(5, chihoShotokuzei); // 지방 소득세 (地方所得税)
            pstmtKouzyo.setString(6, koujoKamoku); // 공제 항목 (控除科目)
            pstmtKouzyo.setDouble(7, daibuHoken); // 대입 보험 (代入保険)
            pstmtKouzyo.setDouble(8, kikandaniShotokuzei); // 기간 단위 소득세 (期間単位所得税)
            pstmtKouzyo.setDouble(9, kokuminNenkin); // 국민연금 (国民年金)
            pstmtKouzyo.setDouble(10, kenkouHoken); // 건강 보험 (健康保険)
            pstmtKouzyo.setDouble(11, choukikaigoHoken); // 장기 요양 보험 (長期介護保険)
            pstmtKouzyo.setDouble(12, koyouHoken); // 고용 보험 (雇用保険)
            pstmtKouzyo.setDouble(13, gojokaihi); // 고정 비용 (固定費)
            pstmtKouzyo.setString(14, koujoZessaTani); // 공제 절사 단위 (控除切捨て単位)
            pstmtKouzyo.setString(15, koujoShiyouUmu); // 공제 사용 여부 (控除使用の有無)
            pstmtKouzyo.setString(16, koujoBikou); // 공제 비고 (控除備考)
            pstmtKouzyo.setString(17, koujoKeisanHouhou); // 공제 계산 방법 (控除計算方法)

            pstmtKouzyo.executeUpdate(); // 공제 정보 삽입 실행 (控除情報の挿入を実行)

        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 처리 (SQL例外処理)
        }
    }

    // 사원 ID로 급여 및 공제 정보 조회 메서드 (社員IDで給与および控除情報取得メソッド)
    public List<String[]> getPayrollByShainId(int shainId) {
        List<String[]> payrollList = new ArrayList<>();
        String sql = "SELECT st.koyou_keitai, st.shain_namae, st.bu, ts.shikyuuzoukyuu, tk.koujo_sougaku " +
                     "FROM total_shiharai ts " +
                     "JOIN total_kouzyo tk ON ts.shain_ID = tk.shain_ID " +
                     "JOIN shain_touroku st ON ts.shain_ID = st.shain_ID " +
                     "WHERE ts.shain_ID = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, shainId); // 사원 ID 설정 (社員IDを設定)
            ResultSet rs = pstmt.executeQuery(); // 결과 집합 가져오기 (結果セットを取得)

            while (rs.next()) {
                String[] payrollInfo = new String[5]; // 배열 크기를 5로 변경 (配列のサイズを5に変更)
                payrollInfo[0] = rs.getString("koyou_keitai"); // 고용 형태 (雇用形態)
                payrollInfo[1] = rs.getString("shain_namae"); // 사원 이름 (社員名前)
                payrollInfo[2] = rs.getString("bu"); // 부서 (部署)
                payrollInfo[3] = String.valueOf(rs.getDouble("shikyuuzoukyuu")); // 급여 (給与)
                payrollInfo[4] = String.valueOf(rs.getDouble("koujo_sougaku")); // 공제 (控除)
                payrollList.add(payrollInfo); // 급여 정보 리스트에 추가 (給与情報リストに追加)
            }
        } catch (SQLException e) {
            e.printStackTrace(); // SQL 예외 처리 (SQL例外処理)
        }
        return payrollList; // 급여 정보 리스트 반환 (給与情報リストを返す)
    }
}
