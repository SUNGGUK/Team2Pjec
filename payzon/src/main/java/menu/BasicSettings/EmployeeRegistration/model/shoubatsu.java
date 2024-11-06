package menu.BasicSettings.EmployeeRegistration.model;

import java.sql.Date;

//-- 15. 상벌 테이블 (shoubatsu)
//-- 15. 賞罰テーブル (shoubatsu)
public class shoubatsu {
    int shain_ID; // 사원 ID / 社員ID
    String shoubatsu_mei; // 상벌명 / 賞罰名
    String kantoku_kikan; // 감독 기간 / 監督期間
    Date shoubatsu_bi; // 상벌일 / 賞罰日
    String naiyou; // 내용 / 内容
    String bikou; // 비고 / 備考

    public shoubatsu() {}

    public shoubatsu(int shain_ID, String shoubatsu_mei, String kantoku_kikan, Date shoubatsu_bi, String naiyou, String bikou) {
        this.shain_ID = shain_ID;
        this.shoubatsu_mei = shoubatsu_mei;
        this.kantoku_kikan = kantoku_kikan;
        this.shoubatsu_bi = shoubatsu_bi;
        this.naiyou = naiyou;
        this.bikou = bikou;
    }

    // Getter and Setter methods
    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public String getShoubatsu_mei() { return shoubatsu_mei; }
    public void setShoubatsu_mei(String shoubatsu_mei) { this.shoubatsu_mei = shoubatsu_mei; }

    public String getKantoku_kikan() { return kantoku_kikan; }
    public void setKantoku_kikan(String kantoku_kikan) { this.kantoku_kikan = kantoku_kikan; }

    public Date getShoubatsu_bi() { return shoubatsu_bi; }
    public void setShoubatsu_bi(Date shoubatsu_bi) { this.shoubatsu_bi = shoubatsu_bi; }

    public String getNaiyou() { return naiyou; }
    public void setNaiyou(String naiyou) { this.naiyou = naiyou; }

    public String getBikou() { return bikou; }
    public void setBikou(String bikou) { this.bikou = bikou; }
}
