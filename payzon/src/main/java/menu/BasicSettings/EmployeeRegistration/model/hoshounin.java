package menu.BasicSettings.EmployeeRegistration.model;

import java.sql.Date;

//-- 17. 보증인 테이블 (hoshounin)
//-- 17. 保証人テーブル (hoshounin)
public class hoshounin {
    int shain_ID; // 사원 ID / 社員ID
    String hoshounin_mei; // 보증인 이름 / 保証人名
    String kankei; // 관계 / 関係
    String zyuumin_touroku_bangou; // 주민 등록 번호 / 住民登録番号
    double hoshou_kingaku; // 보증 금액 / 保証金額
    Date hoshou_bi; // 보증 시작일 / 保証日
    Date syuuryou_bi; // 보증 종료일 / 終了日
    String denwa_bangou; // 전화 번호 / 電話番号

    public hoshounin() {}

    // 모든 필드를 포함하는 생성자 정의 / 全てのフィールドを含むコンストラクタ定義
    public hoshounin(int shain_ID, String hoshounin_mei, String kankei, String zyuumin_touroku_bangou, 
                     double hoshou_kingaku, Date hoshou_bi, Date syuuryou_bi, String denwa_bangou) {
        this.shain_ID = shain_ID;
        this.hoshounin_mei = hoshounin_mei;
        this.kankei = kankei;
        this.zyuumin_touroku_bangou = zyuumin_touroku_bangou;
        this.hoshou_kingaku = hoshou_kingaku;
        this.hoshou_bi = hoshou_bi;
        this.syuuryou_bi = syuuryou_bi;
        this.denwa_bangou = denwa_bangou;
    }

    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public String getHoshounin_mei() { return hoshounin_mei; }
    public void setHoshounin_mei(String hoshounin_mei) { this.hoshounin_mei = hoshounin_mei; }

    public String getKankei() { return kankei; }
    public void setKankei(String kankei) { this.kankei = kankei; }

    public String getZyuumin_touroku_bangou() { return zyuumin_touroku_bangou; }
    public void setZyuumin_touroku_bangou(String zyuumin_touroku_bangou) { this.zyuumin_touroku_bangou = zyuumin_touroku_bangou; }

    public double getHoshou_kingaku() { return hoshou_kingaku; }
    public void setHoshou_kingaku(double hoshou_kingaku) { this.hoshou_kingaku = hoshou_kingaku; }

    public Date getHoshou_bi() { return hoshou_bi; }
    public void setHoshou_bi(Date hoshou_bi) { this.hoshou_bi = hoshou_bi; }

    public Date getSyuuryou_bi() { return syuuryou_bi; }
    public void setSyuuryou_bi(Date syuuryou_bi) { this.syuuryou_bi = syuuryou_bi; }

    public String getDenwa_bangou() { return denwa_bangou; }
    public void setDenwa_bangou(String denwa_bangou) { this.denwa_bangou = denwa_bangou; }
}
