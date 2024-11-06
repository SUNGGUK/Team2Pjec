package menu.payroll.PayrollInputManagementforDailyWorkers.Model;

public class TotalKouzyo {
    private int koujoId;              // 공제 항목 ID (控除項目ID)
    private int shainId;              // 사원 ID (社員ID)
    private double koujoSougaku;      // 공제 총액 (控除総額)
    private double shotokuzei;        // 소득세 (所得税)
    private double chihoShotokuzei;   // 지방소득세 (地方所得税)
    private String koujoKamoku;       // 공제 항목 (控除項目)
    private double daibuHoken;        // 4대보험 (四大保険)
    private double kikandaniShotokuzei; // 기간단위소득세 (期間単位所得税)
    private double kokuminNenkin;     // 국민연금 (国民年金)
    private double kenkouHoken;       // 건강보험 (健康保険)
    private double choukikaigoHoken;  // 장기요양보험 (長期療養保険)
    private double koyouHoken;        // 고용보험 (雇用保険)
    private double gojokaihi;         // 상호부조비 (相互扶助費)
    private String zessaTani;         // 절사 단위 (切捨単位)
    private String shiyouUmu;         // 사용 여부 (使用有無)
    private String bikou;             // 비고 (備考)
    private String keisanHouhou;      // 계산 방법 (計算方法)

    // Getter 및 Setter 메서드 (ゲッターとセッターメソッド)
    public int getKoujoId() {
        return koujoId; // 공제 항목 ID 반환 (控除項目IDを返す)
    }

    public void setKoujoId(int koujoId) {
        this.koujoId = koujoId; // 공제 항목 ID 설정 (控除項目IDを設定)
    }

    public int getShainId() {
        return shainId; // 사원 ID 반환 (社員IDを返す)
    }

    public void setShainId(int shainId) {
        this.shainId = shainId; // 사원 ID 설정 (社員IDを設定)
    }

    public double getKoujoSougaku() {
        return koujoSougaku; // 공제 총액 반환 (控除総額を返す)
    }

    public void setKoujoSougaku(double koujoSougaku) {
        this.koujoSougaku = koujoSougaku; // 공제 총액 설정 (控除総額を設定)
    }

    public double getShotokuzei() {
        return shotokuzei; // 소득세 반환 (所得税を返す)
    }

    public void setShotokuzei(double shotokuzei) {
        this.shotokuzei = shotokuzei; // 소득세 설정 (所得税を設定)
    }

    public double getChihoShotokuzei() {
        return chihoShotokuzei; // 지방소득세 반환 (地方所得税を返す)
    }

    public void setChihoShotokuzei(double chihoShotokuzei) {
        this.chihoShotokuzei = chihoShotokuzei; // 지방소득세 설정 (地方所得税を設定)
    }

    public String getKoujoKamoku() {
        return koujoKamoku; // 공제 항목 반환 (控除項目を返す)
    }

    public void setKoujoKamoku(String koujoKamoku) {
        this.koujoKamoku = koujoKamoku; // 공제 항목 설정 (控除項目を設定)
    }

    public double getDaibuHoken() {
        return daibuHoken; // 4대보험 반환 (四大保険を返す)
    }

    public void setDaibuHoken(double daibuHoken) {
        this.daibuHoken = daibuHoken; // 4대보험 설정 (四大保険を設定)
    }

    public double getKikandaniShotokuzei() {
        return kikandaniShotokuzei; // 기간단위소득세 반환 (期間単位所得税を返す)
    }

    public void setKikandaniShotokuzei(double kikandaniShotokuzei) {
        this.kikandaniShotokuzei = kikandaniShotokuzei; // 기간단위소득세 설정 (期間単位所得税を設定)
    }

    public double getKokuminNenkin() {
        return kokuminNenkin; // 국민연금 반환 (国民年金を返す)
    }

    public void setKokuminNenkin(double kokuminNenkin) {
        this.kokuminNenkin = kokuminNenkin; // 국민연금 설정 (国民年金を設定)
    }

    public double getKenkouHoken() {
        return kenkouHoken; // 건강보험 반환 (健康保険を返す)
    }

    public void setKenkouHoken(double kenkouHoken) {
        this.kenkouHoken = kenkouHoken; // 건강보험 설정 (健康保険を設定)
    }

    public double getChoukikaigoHoken() {
        return choukikaigoHoken; // 장기요양보험 반환 (長期療養保険を返す)
    }

    public void setChoukikaigoHoken(double choukikaigoHoken) {
        this.choukikaigoHoken = choukikaigoHoken; // 장기요양보험 설정 (長期療養保険を設定)
    }

    public double getKoyouHoken() {
        return koyouHoken; // 고용보험 반환 (雇用保険を返す)
    }

    public void setKoyouHoken(double koyouHoken) {
        this.koyouHoken = koyouHoken; // 고용보험 설정 (雇用保険を設定)
    }

    public double getGojokaihi() {
        return gojokaihi; // 상호부조비 반환 (相互扶助費を返す)
    }

    public void setGojokaihi(double gojokaihi) {
        this.gojokaihi = gojokaihi; // 상호부조비 설정 (相互扶助費を設定)
    }

    public String getZessaTani() {
        return zessaTani; // 절사 단위 반환 (切捨単位を返す)
    }

    public void setZessaTani(String zessaTani) {
        this.zessaTani = zessaTani; // 절사 단위 설정 (切捨単位を設定)
    }

    public String getShiyouUmu() {
        return shiyouUmu; // 사용 여부 반환 (使用有無を返す)
    }

    public void setShiyouUmu(String shiyouUmu) {
        this.shiyouUmu = shiyouUmu; // 사용 여부 설정 (使用有無を設定)
    }

    public String getBikou() {
        return bikou; // 비고 반환 (備考を返す)
    }

    public void setBikou(String bikou) {
        this.bikou = bikou; // 비고 설정 (備考を設定)
    }

    public String getKeisanHouhou() {
        return keisanHouhou; // 계산 방법 반환 (計算方法を返す)
    }

    public void setKeisanHouhou(String keisanHouhou) {
        this.keisanHouhou = keisanHouhou; // 계산 방법 설정 (計算方法を設定)
    }
}
