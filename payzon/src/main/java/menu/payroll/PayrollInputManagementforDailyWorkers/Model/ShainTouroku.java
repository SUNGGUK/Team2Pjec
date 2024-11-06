package menu.payroll.PayrollInputManagementforDailyWorkers.Model;

import java.util.Date;

public class ShainTouroku {
    private int shainId;                  // 사원 ID (社員ID)
    private String koyouKeitai;           // 고용 형태 (雇用形態)
    private String shainNamae;            // 사원 이름 (社員名)
    private String shainEigoNamae;        // 사원 영어 이름 (社員英名)
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

    // Getter 및 Setter 메서드 (ゲッターとセッターメソッド)
    public int getShainId() {
        return shainId; // 사원 ID 반환 (社員IDを返す)
    }

    public void setShainId(int shainId) {
        this.shainId = shainId; // 사원 ID 설정 (社員IDを設定)
    }

    public String getKoyouKeitai() {
        return koyouKeitai; // 고용 형태 반환 (雇用形態を返す)
    }

    public void setKoyouKeitai(String koyouKeitai) {
        this.koyouKeitai = koyouKeitai; // 고용 형태 설정 (雇用形態を設定)
    }

    public String getShainNamae() {
        return shainNamae; // 사원 이름 반환 (社員名を返す)
    }

    public void setShainNamae(String shainNamae) {
        this.shainNamae = shainNamae; // 사원 이름 설정 (社員名を設定)
    }

    public String getShainEigoNamae() {
        return shainEigoNamae; // 사원 영어 이름 반환 (社員英名を返す)
    }

    public void setShainEigoNamae(String shainEigoNamae) {
        this.shainEigoNamae = shainEigoNamae; // 사원 영어 이름 설정 (社員英名を設定)
    }

    public Date getNyuushaBi() {
        return nyuushaBi; // 입사일 반환 (入社日を返す)
    }

    public void setNyuushaBi(Date nyuushaBi) {
        this.nyuushaBi = nyuushaBi; // 입사일 설정 (入社日を設定)
    }

    public Date getTaishaBi() {
        return taishaBi; // 퇴사일 반환 (退社日を返す)
    }

    public void setTaishaBi(Date taishaBi) {
        this.taishaBi = taishaBi; // 퇴사일 설정 (退社日を設定)
    }

    public String getBu() {
        return bu; // 부서 반환 (部署を返す)
    }

    public void setBu(String bu) {
        this.bu = bu; // 부서 설정 (部署を設定)
    }

    public String getYakushoku() {
        return yakushoku; // 직위 반환 (役職を返す)
    }

    public void setYakushoku(String yakushoku) {
        this.yakushoku = yakushoku; // 직위 설정 (役職を設定)
    }

    public String getNaiGaikokuzin() {
        return naiGaikokuzin; // 내외국인 반환 (内外国人を返す)
    }

    public void setNaiGaikokuzin(String naiGaikokuzin) {
        this.naiGaikokuzin = naiGaikokuzin; // 내외국인 설정 (内外国人を設定)
    }

    public String getZyuuminBangou() {
        return zyuuminBangou; // 주민번호 반환 (住民番号を返す)
    }

    public void setZyuuminBangou(String zyuuminBangou) {
        this.zyuuminBangou = zyuuminBangou; // 주민번호 설정 (住民番号を設定)
    }

    public String getZyuusho() {
        return zyuusho; // 주소 반환 (住所を返す)
    }

    public void setZyuusho(String zyuusho) {
        this.zyuusho = zyuusho; // 주소 설정 (住所を設定)
    }

    public String getDenwaBangou() {
        return denwaBangou; // 전화번호 반환 (電話番号を返す)
    }

    public void setDenwaBangou(String denwaBangou) {
        this.denwaBangou = denwaBangou; // 전화번호 설정 (電話番号を設定)
    }

    public String getKeitaiBangou() {
        return keitaiBangou; // 휴대전화번호 반환 (携帯電話番号を返す)
    }

    public void setKeitaiBangou(String keitaiBangou) {
        this.keitaiBangou = keitaiBangou; // 휴대전화번호 설정 (携帯電話番号を設定)
    }

    public String getMeiruAdoresu() {
        return meiruAdoresu; // 이메일 반환 (メールアドレスを返す)
    }

    public void setMeiruAdoresu(String meiruAdoresu) {
        this.meiruAdoresu = meiruAdoresu; // 이메일 설정 (メールアドレスを設定)
    }

    public String getSns() {
        return sns; // SNS 반환 (SNSを返す)
    }

    public void setSns(String sns) {
        this.sns = sns; // SNS 설정 (SNSを設定)
    }

    public String getBikou() {
        return bikou; // 비고 반환 (備考を返す)
    }

    public void setBikou(String bikou) {
        this.bikou = bikou; // 비고 설정 (備考を設定)
    }
}
