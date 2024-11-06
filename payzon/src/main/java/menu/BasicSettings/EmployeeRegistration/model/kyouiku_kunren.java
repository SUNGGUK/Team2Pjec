package menu.BasicSettings.EmployeeRegistration.model;

import java.sql.Date;

//-- 14. 교육 훈련 테이블 (kyouiku_kunren)
//-- 14. 教育訓練テーブル (kyouiku_kunren)
public class kyouiku_kunren {
    int shain_ID; // 사원 ID / 社員ID
    String kyouiku_shurui; // 교육 종류 / 教育種類
    String kyouiku_mei; // 교육 명칭 / 教育名称
    Date kaishi_bi; // 시작일 / 開始日
    Date shuuryou_bi; // 종료일 / 終了日
    String kyouiku_kikan_mei; // 교육 기관명 / 教育機関名
    double kyouiku_hi; // 교육 비용 / 教育費用
    double kanpu_kyouiku_hi; // 환불된 교육 비용 / 還付教育費用

    public kyouiku_kunren() {}

    // 모든 필드를 포함하는 생성자 정의 / 全てのフィールドを含むコンストラクタ定義
    public kyouiku_kunren(int shain_ID, String kyouiku_shurui, String kyouiku_mei, Date kaishi_bi, Date shuuryou_bi,
                          String kyouiku_kikan_mei, double kyouiku_hi, double kanpu_kyouiku_hi) {
        this.shain_ID = shain_ID;
        this.kyouiku_shurui = kyouiku_shurui;
        this.kyouiku_mei = kyouiku_mei;
        this.kaishi_bi = kaishi_bi;
        this.shuuryou_bi = shuuryou_bi;
        this.kyouiku_kikan_mei = kyouiku_kikan_mei;
        this.kyouiku_hi = kyouiku_hi;
        this.kanpu_kyouiku_hi = kanpu_kyouiku_hi;
    }

    // Getter 및 Setter 메서드 (각 메서드에 한국어/일본어 주석 포함)
    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public String getKyouiku_shurui() { return kyouiku_shurui; }
    public void setKyouiku_shurui(String kyouiku_shurui) { this.kyouiku_shurui = kyouiku_shurui; }

    public String getKyouiku_mei() { return kyouiku_mei; }
    public void setKyouiku_mei(String kyouiku_mei) { this.kyouiku_mei = kyouiku_mei; }

    public Date getKaishi_bi() { return kaishi_bi; }
    public void setKaishi_bi(Date kaishi_bi) { this.kaishi_bi = kaishi_bi; }

    public Date getShuuryou_bi() { return shuuryou_bi; }
    public void setShuuryou_bi(Date shuuryou_bi) { this.shuuryou_bi = shuuryou_bi; }

    public String getKyouiku_kikan_mei() { return kyouiku_kikan_mei; }
    public void setKyouiku_kikan_mei(String kyouiku_kikan_mei) { this.kyouiku_kikan_mei = kyouiku_kikan_mei; }

    public double getKyouiku_hi() { return kyouiku_hi; }
    public void setKyouiku_hi(double kyouiku_hi) { this.kyouiku_hi = kyouiku_hi; }

    public double getKanpu_kyouiku_hi() { return kanpu_kyouiku_hi; }
    public void setKanpu_kyouiku_hi(double kanpu_kyouiku_hi) { this.kanpu_kyouiku_hi = kanpu_kyouiku_hi; }
}
