package menu.BasicSettings.VacationSettings.model;

import java.sql.Date;

// 휴가 항목 설정 테이블 클래스입니다 (휴가의 종류, 적용 기간 등을 포함)
// 休暇項目設定クラス (休暇の種類や適用期間などを含む)
public class kyuuka_koumoku_settei {
    int kyuuka_ID; // 휴가 ID
    String kyuuka_shurui; // 휴가 종류
    Date tekiyou_kikan; // 적용 기간
    int kyuuka_nissuu; // 휴가 일수
    char shiyou_kanou_umu; // 사용 가능 여부

    // 생성자: 초기값 설정
    // コンストラクタ: 初期値の設定
    public kyuuka_koumoku_settei(int kyuuka_ID, String kyuuka_shurui, Date tekiyou_kikan, int kyuuka_nissuu, char shiyou_kanou_umu) {
        this.kyuuka_ID = kyuuka_ID;
        this.kyuuka_shurui = kyuuka_shurui;
        this.tekiyou_kikan = tekiyou_kikan;
        this.kyuuka_nissuu = kyuuka_nissuu;
        this.shiyou_kanou_umu = shiyou_kanou_umu;
    }

    // 휴가 ID를 반환
    // 休暇IDを返す
    public int getKyuuka_ID() {
        return kyuuka_ID;
    }

    // 휴가 ID 설정
    // 休暇IDを設定する
    public void setKyuuka_ID(int kyuuka_ID) {
        this.kyuuka_ID = kyuuka_ID;
    }

    // 휴가 종류를 반환
    // 休暇の種類を返す
    public String getKyuuka_shurui() {
        return kyuuka_shurui;
    }

    // 휴가 종류 설정
    // 休暇の種類を設定する
    public void setKyuuka_shurui(String kyuuka_shurui) {
        this.kyuuka_shurui = kyuuka_shurui;
    }

    // 적용 기간을 반환
    // 適用期間を返す
    public Date getTekiyou_kikan() {
        return tekiyou_kikan;
    }

    // 적용 기간 설정
    // 適用期間を設定する
    public void setTekiyou_kikan(Date tekiyou_kikan) {
        this.tekiyou_kikan = tekiyou_kikan;
    }

    // 휴가 일수를 반환
    // 休暇日数を返す
    public int getKyuuka_nissuu() {
        return kyuuka_nissuu;
    }

    // 휴가 일수 설정
    // 休暇日数を設定する
    public void setKyuuka_nissuu(int kyuuka_nissuu) {
        this.kyuuka_nissuu = kyuuka_nissuu;
    }

    // 사용 가능 여부 반환
    // 使用可能かどうかを返す
    public char getShiyou_kanou_umu() {
        return shiyou_kanou_umu;
    }

    // 사용 가능 여부 설정
    // 使用可能かどうかを設定する
    public void setShiyou_kanou_umu(char shiyou_kanou_umu) {
        this.shiyou_kanou_umu = shiyou_kanou_umu;
    }
}
