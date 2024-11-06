package menu.BasicSettings.EmployeeRegistration.model;

import java.sql.Date;

//-- 12. 자격 면허 테이블 (shikaku_menkyou)
//-- 12. 資格免許テーブル (shikaku_menkyou)
public class shikaku_menkyou {
    int shain_ID; // 사원 ID / 社員ID
    String shikaku_mei; // 자격명 / 資格名
    Date hakkyuu_bi; // 발급일 / 発行日
    String hakkyuu_kikan_mei; // 발급 기관명 / 発行機関名
    String shikakushou_bangou; // 자격증 번호 / 資格証番号
    String biko; // 비고 / 備考

    // 기본 생성자 / デフォルトコンストラクタ
    public shikaku_menkyou() {}

    // 매개변수를 받는 생성자 / パラメータ付きコンストラクタ
    public shikaku_menkyou(int shain_ID, String shikaku_mei, Date hakkyuu_bi, String hakkyuu_kikan_mei, 
                           String shikakushou_bangou, String biko) {
        this.shain_ID = shain_ID;
        this.shikaku_mei = shikaku_mei;
        this.hakkyuu_bi = hakkyuu_bi;
        this.hakkyuu_kikan_mei = hakkyuu_kikan_mei;
        this.shikakushou_bangou = shikakushou_bangou;
        this.biko = biko;
    }

    // Getter and Setter methods
    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public String getShikaku_mei() { return shikaku_mei; }
    public void setShikaku_mei(String shikaku_mei) { this.shikaku_mei = shikaku_mei; }

    public Date getHakkyuu_bi() { return hakkyuu_bi; }
    public void setHakkyuu_bi(Date hakkyuu_bi) { this.hakkyuu_bi = hakkyuu_bi; }

    public String getHakkyuu_kikan_mei() { return hakkyuu_kikan_mei; }
    public void setHakkyuu_kikan_mei(String hakkyuu_kikan_mei) { this.hakkyuu_kikan_mei = hakkyuu_kikan_mei; }

    public String getShikakushou_bangou() { return shikakushou_bangou; }
    public void setShikakushou_bangou(String shikakushou_bangou) { this.shikakushou_bangou = shikakushou_bangou; }

    public String getBiko() { return biko; }
    public void setBiko(String biko) { this.biko = biko; }
}
