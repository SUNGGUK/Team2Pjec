package menu.BasicSettings.EmployeeRegistration.model;

import java.sql.Date;

//-- 11. 병역 정보 테이블 (heieki_zyouhou)
//-- 11. 兵役情報テーブル (heieki_zyouhou)
public class heieki_zyouhou {
    int shain_ID; // 사원 ID / 社員ID
    String heieki_kubun; // 병역 구분 / 兵役区分
    String gun_betsu; // 군 종류 / 軍別
    Date hukumu_kaishi_bi; // 복무 시작일 / 復務開始日
    Date hukumu_shuuryou_bi; // 복무 종료일 / 復務終了日
    String saishuu_kaikyuu; // 최종 계급 / 最終階級
    String heika; // 병과 / 兵科
    String miryou_ziyuu; // 면제 사유 / 免除理由

    public heieki_zyouhou() {}

    // 모든 필드를 포함하는 생성자 정의 / 全てのフィールドを含むコンストラクタ定義
    public heieki_zyouhou(int shain_ID, String heieki_kubun, String gun_betsu, Date hukumu_kaishi_bi, 
                          Date hukumu_shuuryou_bi, String saishuu_kaikyuu, String heika, String miryou_ziyuu) {
        this.shain_ID = shain_ID;
        this.heieki_kubun = heieki_kubun;
        this.gun_betsu = gun_betsu;
        this.hukumu_kaishi_bi = hukumu_kaishi_bi;
        this.hukumu_shuuryou_bi = hukumu_shuuryou_bi;
        this.saishuu_kaikyuu = saishuu_kaikyuu;
        this.heika = heika;
        this.miryou_ziyuu = miryou_ziyuu;
    }

    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public String getHeieki_kubun() { return heieki_kubun; }
    public void setHeieki_kubun(String heieki_kubun) { this.heieki_kubun = heieki_kubun; }

    public String getGun_betsu() { return gun_betsu; }
    public void setGun_betsu(String gun_betsu) { this.gun_betsu = gun_betsu; }

    public Date getHukumu_kaishi_bi() { return hukumu_kaishi_bi; }
    public void setHukumu_kaishi_bi(Date hukumu_kaishi_bi) { this.hukumu_kaishi_bi = hukumu_kaishi_bi; }

    public Date getHukumu_shuuryou_bi() { return hukumu_shuuryou_bi; }
    public void setHukumu_shuuryou_bi(Date hukumu_shuuryou_bi) { this.hukumu_shuuryou_bi = hukumu_shuuryou_bi; }

    public String getSaishuu_kaikyuu() { return saishuu_kaikyuu; }
    public void setSaishuu_kaikyuu(String saishuu_kaikyuu) { this.saishuu_kaikyuu = saishuu_kaikyuu; }

    public String getHeika() { return heika; }
    public void setHeika(String heika) { this.heika = heika; }

    public String getMiryou_ziyuu() { return miryou_ziyuu; }
    public void setMiryou_ziyuu(String miryou_ziyuu) { this.miryou_ziyuu = miryou_ziyuu; }
}
