package menu.BasicSettings.EmployeeRegistration.model;

import java.sql.Date;

//-- 16. 발령 테이블 (hatsurei)
//-- 16. 発令テーブル (hatsurei)
public class hatsurei {
    int shain_ID; // 사원 ID / 社員ID
    Date hatsurei_bi; // 발령일 / 発令日
    String bu; // 부서 / 部署
    String yakushoku_mei; // 직위명 / 役職名
    String shokumu_mei; // 직무명 / 職務名
    String bikou; // 비고 / 備考

    public hatsurei() {}

    // 모든 필드를 포함하는 생성자 정의 / 全てのフィールドを含むコンストラクタ定義
    public hatsurei(int shain_ID, Date hatsurei_bi, String bu, String yakushoku_mei, String shokumu_mei, String bikou) {
        this.shain_ID = shain_ID;
        this.hatsurei_bi = hatsurei_bi;
        this.bu = bu;
        this.yakushoku_mei = yakushoku_mei;
        this.shokumu_mei = shokumu_mei;
        this.bikou = bikou;
    }

    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public Date getHatsurei_bi() { return hatsurei_bi; }
    public void setHatsurei_bi(Date hatsurei_bi) { this.hatsurei_bi = hatsurei_bi; }

    public String getBu() { return bu; }
    public void setBu(String bu) { this.bu = bu; }

    public String getYakushoku_mei() { return yakushoku_mei; }
    public void setYakushoku_mei(String yakushoku_mei) { this.yakushoku_mei = yakushoku_mei; }

    public String getShokumu_mei() { return shokumu_mei; }
    public void setShokumu_mei(String shokumu_mei) { this.shokumu_mei = shokumu_mei; }

    public String getBikou() { return bikou; }
    public void setBikou(String bikou) { this.bikou = bikou; }
}
