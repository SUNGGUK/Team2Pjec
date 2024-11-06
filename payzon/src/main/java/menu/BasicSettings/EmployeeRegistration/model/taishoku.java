package menu.BasicSettings.EmployeeRegistration.model;

import java.sql.Date;

//-- 18. 퇴직 테이블 (taishoku)
//-- 18. 退職テーブル (taishoku)
public class taishoku {
    int shain_ID; // 사원 ID / 社員ID
    String zyoutai; // 상태 / 状態
    String taishoku_kubun; // 퇴직 구분 / 退職区分
    Date taishoku_bi; // 퇴직일 / 退職日
    String taishoku_ziyuu; // 퇴직 사유 / 退職理由
    String taishoku_go_renrakusaki; // 퇴직 후 연락처 / 退職後の連絡先
    char chuukan_seisan_umu; // 중간 정산 여부 / 中間清算有無
    char taishoku_seisan_umu; // 퇴직 정산 여부 / 退職清算有無
    double taishoku_kin; // 퇴직금 / 退職金
    byte[] bikou; // 비고 / 備考

    public taishoku(int shain_ID, String zyoutai, String taishoku_kubun, Date taishoku_bi, String taishoku_ziyuu,
                    String taishoku_go_renrakusaki, char chuukan_seisan_umu, char taishoku_seisan_umu, 
                    double taishoku_kin, byte[] bikou) {
        this.shain_ID = shain_ID;
        this.zyoutai = zyoutai;
        this.taishoku_kubun = taishoku_kubun;
        this.taishoku_bi = taishoku_bi;
        this.taishoku_ziyuu = taishoku_ziyuu;
        this.taishoku_go_renrakusaki = taishoku_go_renrakusaki;
        this.chuukan_seisan_umu = chuukan_seisan_umu;
        this.taishoku_seisan_umu = taishoku_seisan_umu;
        this.taishoku_kin = taishoku_kin;
        this.bikou = bikou;
    }

    public taishoku() {}

    // Getter and Setter methods
    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public String getZyoutai() { return zyoutai; }
    public void setZyoutai(String zyoutai) { this.zyoutai = zyoutai; }

    public String getTaishoku_kubun() { return taishoku_kubun; }
    public void setTaishoku_kubun(String taishoku_kubun) { this.taishoku_kubun = taishoku_kubun; }

    public Date getTaishoku_bi() { return taishoku_bi; }
    public void setTaishoku_bi(Date taishoku_bi) { this.taishoku_bi = taishoku_bi; }

    public String getTaishoku_ziyuu() { return taishoku_ziyuu; }
    public void setTaishoku_ziyuu(String taishoku_ziyuu) { this.taishoku_ziyuu = taishoku_ziyuu; }

    public String getTaishoku_go_renrakusaki() { return taishoku_go_renrakusaki; }
    public void setTaishoku_go_renrakusaki(String taishoku_go_renrakusaki) { this.taishoku_go_renrakusaki = taishoku_go_renrakusaki; }

    public char getChuukan_seisan_umu() { return chuukan_seisan_umu; }
    public void setChuukan_seisan_umu(char chuukan_seisan_umu) { this.chuukan_seisan_umu = chuukan_seisan_umu; }

    public char getTaishoku_seisan_umu() { return taishoku_seisan_umu; }
    public void setTaishoku_seisan_umu(char taishoku_seisan_umu) { this.taishoku_seisan_umu = taishoku_seisan_umu; }

    public double getTaishoku_kin() { return taishoku_kin; }
    public void setTaishoku_kin(double taishoku_kin) { this.taishoku_kin = taishoku_kin; }

    public byte[] getBikou() { return bikou; }
    public void setBikou(byte[] bikou) { this.bikou = bikou; }
}
