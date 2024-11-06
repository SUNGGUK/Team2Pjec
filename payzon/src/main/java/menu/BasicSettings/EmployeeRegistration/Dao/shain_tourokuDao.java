package menu.BasicSettings.EmployeeRegistration.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import menu.BasicSettings.EmployeeRegistration.model.shain_touroku;

//-- 6. 사원 등록 테이블 (shain_touroku)
//-- 6. 社員登録テーブル (shain_touroku)
public class shain_tourokuDao {

    // 사원 등록 정보 삽입 메서드 / 社員登録情報挿入メソッド
    public shain_touroku insert(Connection conn, shain_touroku shain_touroku) throws SQLException {
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(
                "INSERT INTO shain_touroku " +
                "(shain_ID, koyou_keitai, shain_namae, shain_eigo_namae, nyuusha_bi, taisha_bi, " +
                "bu, yakushoku, nai_gaikokuzin, zyuumin_bangou, zyuusho, denwa_bangou, " +
                "keitai_bangou, meiru_adoresu, sns, bikou) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            // PreparedStatement에 값 설정 / PreparedStatementに値を設定
            pstmt.setInt(1, shain_touroku.getShain_ID()); // 사원 ID / 社員ID
            pstmt.setString(2, shain_touroku.getKoyou_keitai()); // 고용 형태 / 雇用形態
            pstmt.setString(3, shain_touroku.getShain_namae()); // 사원 이름 / 社員名前
            pstmt.setString(4, shain_touroku.getShain_eigo_namae()); // 사원의 영어 이름 / 社員英語名前
            pstmt.setDate(5, shain_touroku.getNyuusha_bi()); // 입사일 / 入社日
            pstmt.setDate(6, shain_touroku.getTaisha_bi()); // 퇴사일 / 退社日
            pstmt.setString(7, shain_touroku.getBu()); // 부서 / 部署
            pstmt.setString(8, shain_touroku.getYakushoku()); // 직위 / 役職
            pstmt.setString(9, shain_touroku.getNai_gaikokuzin()); // 내외국인 여부 / 内外国人
            pstmt.setString(10, shain_touroku.getZyuumin_bangou()); // 주민 번호 / 住民番号
            pstmt.setString(11, shain_touroku.getZyuusho()); // 주소 / 住所
            pstmt.setString(12, shain_touroku.getDenwa_bangou()); // 전화 번호 / 電話番号
            pstmt.setString(13, shain_touroku.getKeitai_bangou()); // 휴대 전화 번호 / 携帯電話番号
            pstmt.setString(14, shain_touroku.getMeiru_adoresu()); // 이메일 주소 / メールアドレス
            pstmt.setString(15, shain_touroku.getSns()); // SNS / SNS
            pstmt.setString(16, shain_touroku.getBikou()); // 비고 / 備考

            int affectedRows = pstmt.executeUpdate();

            // 삽입이 성공했는지 확인 / 挿入が成功したか確認
            if (affectedRows > 0) {
                return shain_touroku;
            } else {
                return null;
            }
        } finally {
            JdbcUtil.close(pstmt);
        }
    }
}
