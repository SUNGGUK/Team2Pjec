package menu.payroll.payrollSlip.Model;

import java.util.Date;

public class ShainTouroku {
    private int shainId;                  // 사원 ID (社員ID)
    private String koyouKeitai;           // 고용 형태 (雇用形態)
    private String shainNamae;            // 사원 이름 (社員名前)
    private String shainEigoNamae;        // 사원 영어 이름 (社員英語名前)
    private Date nyuushaBi;               // 입사일 (入社日)
    private Date taishaBi;                // 퇴사일 (退社日)
    private String bu;                     // 부서 (部署)
    private String yakushoku;              // 직위 (役職)
    private String naiGaikokuzin;         // 내외국인 (内外国人)
    private String zyuuminBangou;         // 주민번호 (住民番号)
    private String zyuusho;                // 주소 (住所)
    private String denwaBangou;           // 전화번호 (電話番号)
    private String keitaiBangou;          // 휴대전화번호 (携帯電話番号)
    private String meiruAdoresu;          // 이메일 (メールアドレス)
    private String sns;                   // SNS (SNS)
    private String bikou;                  // 비고 (備考)

    // Getter 및 Setter 메서드 (ゲッターおよびセッターメソッド)
    public int getShainId() {
        return shainId;
    }

    public void setShainId(int shainId) {
        this.shainId = shainId;
    }

    public String getKoyouKeitai() {
        return koyouKeitai;
    }

    public void setKoyouKeitai(String koyouKeitai) {
        this.koyouKeitai = koyouKeitai;
    }

    public String getShainNamae() {
        return shainNamae;
    }

    public void setShainNamae(String shainNamae) {
        this.shainNamae = shainNamae;
    }

    public String getShainEigoNamae() {
        return shainEigoNamae;
    }

    public void setShainEigoNamae(String shainEigoNamae) {
        this.shainEigoNamae = shainEigoNamae;
    }

    public Date getNyuushaBi() {
        return nyuushaBi;
    }

    public void setNyuushaBi(Date nyuushaBi) {
        this.nyuushaBi = nyuushaBi;
    }

    public Date getTaishaBi() {
        return taishaBi;
    }

    public void setTaishaBi(Date taishaBi) {
        this.taishaBi = taishaBi;
    }

    public String getBu() {
        return bu;
    }

    public void setBu(String bu) {
        this.bu = bu;
    }

    public String getYakushoku() {
        return yakushoku;
    }

    public void setYakushoku(String yakushoku) {
        this.yakushoku = yakushoku;
    }

    public String getNaiGaikokuzin() {
        return naiGaikokuzin;
    }

    public void setNaiGaikokuzin(String naiGaikokuzin) {
        this.naiGaikokuzin = naiGaikokuzin;
    }

    public String getZyuuminBangou() {
        return zyuuminBangou;
    }

    public void setZyuuminBangou(String zyuuminBangou) {
        this.zyuuminBangou = zyuuminBangou;
    }

    public String getZyuusho() {
        return zyuusho;
    }

    public void setZyuusho(String zyuusho) {
        this.zyuusho = zyuusho;
    }

    public String getDenwaBangou() {
        return denwaBangou;
    }

    public void setDenwaBangou(String denwaBangou) {
        this.denwaBangou = denwaBangou;
    }

    public String getKeitaiBangou() {
        return keitaiBangou;
    }

    public void setKeitaiBangou(String keitaiBangou) {
        this.keitaiBangou = keitaiBangou;
    }

    public String getMeiruAdoresu() {
        return meiruAdoresu;
    }

    public void setMeiruAdoresu(String meiruAdoresu) {
        this.meiruAdoresu = meiruAdoresu;
    }

    public String getSns() {
        return sns;
    }

    public void setSns(String sns) {
        this.sns = sns;
    }

    public String getBikou() {
        return bikou;
    }

    public void setBikou(String bikou) {
        this.bikou = bikou;
    }
}
