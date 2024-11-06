package menu.BasicSettings.EmployeeRegistration.model;

import java.sql.Date;

//-- 8. 4대 보험 정보 테이블 (shidai_hoken_zyouhou)
//-- 8. 四大保険情報テーブル (shidai_hoken_zyouhou)
public class shidai_hoken_zyouhou {
    int hoken_ID; // 보험 ID / 保険ID
    int shain_ID; // 사원 ID / 社員ID
    String hoken_shurui; // 보험 종류 / 保険種類
    String touroku_bangou; // 등록 번호 / 登録番号
    Date shutoku_bi; // 취득일 / 取得日
    Date sousitsu_bi; // 상실일 / 喪失日

    // 기본 생성자 / デフォルトコンストラクタ
    public shidai_hoken_zyouhou() {}

    // 매개변수를 받는 생성자 / パラメータ付きコンストラクタ
    public shidai_hoken_zyouhou(int hoken_ID, int shain_ID, String hoken_shurui, String touroku_bangou, Date shutoku_bi, Date sousitsu_bi) {
        this.hoken_ID = hoken_ID;
        this.shain_ID = shain_ID;
        this.hoken_shurui = hoken_shurui;
        this.touroku_bangou = touroku_bangou;
        this.shutoku_bi = shutoku_bi;
        this.sousitsu_bi = sousitsu_bi;
    }

    // Getter and Setter methods
    public int getHoken_ID() { return hoken_ID; }
    public void setHoken_ID(int hoken_ID) { this.hoken_ID = hoken_ID; }

    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public String getHoken_shurui() { return hoken_shurui; }
    public void setHoken_shurui(String hoken_shurui) { this.hoken_shurui = hoken_shurui; }

    public String getTouroku_bangou() { return touroku_bangou; }
    public void setTouroku_bangou(String touroku_bangou) { this.touroku_bangou = touroku_bangou; }

    public Date getShutoku_bi() { return shutoku_bi; }
    public void setShutoku_bi(Date shutoku_bi) { this.shutoku_bi = shutoku_bi; }

    public Date getSousitsu_bi() { return sousitsu_bi; }
    public void setSousitsu_bi(Date sousitsu_bi) { this.sousitsu_bi = sousitsu_bi; }
}
