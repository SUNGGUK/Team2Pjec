package menu.payroll.payrollSlip.Model;

public class TotalKouzyo {
    private int koujoId; // 공제 항목 ID (控除項目ID)
    private int shainId; // 사원 ID (社員ID)
    private double koujoSougaku; // 공제 총액 (控除総額)
    private double shotokuzei; // 소득세 (所得税)
    private double chihoShotokuzei; // 지방소득세 (地方所得税)
    private String koujoKamoku; // 공제 항목 (控除項目)
    private double daibuHoken; // 4대보험 (四大保険)
    private double kikandaniShotokuzei; // 기간단위소득세 (期間単位所得税)
    private double kokuminNenkin; // 국민연금 (国民年金)
    private double kenkouHoken; // 건강보험 (健康保険)
    private double choukikaigoHoken; // 장기요양보험 (長期介護保険)
    private double koyouHoken; // 고용보험 (雇用保険)
    private double gojokaihi; // 상호부조비 (相互扶助費)
    private String zessaTani; // 절사 단위 (切捨単位)
    private String shiyouUmu; // 사용 여부 (使用有無)
    private String bikou; // 비고 (備考)
    private String keisanHouhou; // 계산 방법 (計算方法)

    // Getter 및 Setter 메서드 (ゲッターおよびセッターメソッド)
    public int getKoujoId() {
        return koujoId;
    }

    public void setKoujoId(int koujoId) {
        this.koujoId = koujoId;
    }

    public int getShainId() {
        return shainId;
    }

    public void setShainId(int shainId) {
        this.shainId = shainId;
    }

    public double getKoujoSougaku() {
        return koujoSougaku;
    }

    public void setKoujoSougaku(double koujoSougaku) {
        this.koujoSougaku = koujoSougaku;
    }

    public double getShotokuzei() {
        return shotokuzei;
    }

    public void setShotokuzei(double shotokuzei) {
        this.shotokuzei = shotokuzei;
    }

    public double getChihoShotokuzei() {
        return chihoShotokuzei;
    }

    public void setChihoShotokuzei(double chihoShotokuzei) {
        this.chihoShotokuzei = chihoShotokuzei;
    }

    public String getKoujoKamoku() {
        return koujoKamoku;
    }

    public void setKoujoKamoku(String koujoKamoku) {
        this.koujoKamoku = koujoKamoku;
    }

    public double getDaibuHoken() {
        return daibuHoken;
    }

    public void setDaibuHoken(double daibuHoken) {
        this.daibuHoken = daibuHoken;
    }

    public double getKikandaniShotokuzei() {
        return kikandaniShotokuzei;
    }

    public void setKikandaniShotokuzei(double kikandaniShotokuzei) {
        this.kikandaniShotokuzei = kikandaniShotokuzei;
    }

    public double getKokuminNenkin() {
        return kokuminNenkin;
    }

    public void setKokuminNenkin(double kokuminNenkin) {
        this.kokuminNenkin = kokuminNenkin;
    }

    public double getKenkouHoken() {
        return kenkouHoken;
    }

    public void setKenkouHoken(double kenkouHoken) {
        this.kenkouHoken = kenkouHoken;
    }

    public double getChoukikaigoHoken() {
        return choukikaigoHoken;
    }

    public void setChoukikaigoHoken(double choukikaigoHoken) {
        this.choukikaigoHoken = choukikaigoHoken;
    }

    public double getKoyouHoken() {
        return koyouHoken;
    }

    public void setKoyouHoken(double koyouHoken) {
        this.koyouHoken = koyouHoken;
    }

    public double getGojokaihi() {
        return gojokaihi;
    }

    public void setGojokaihi(double gojokaihi) {
        this.gojokaihi = gojokaihi;
    }

    public String getZessaTani() {
        return zessaTani;
    }

    public void setZessaTani(String zessaTani) {
        this.zessaTani = zessaTani;
    }

    public String getShiyouUmu() {
        return shiyouUmu;
    }

    public void setShiyouUmu(String shiyouUmu) {
        this.shiyouUmu = shiyouUmu;
    }

    public String getBikou() {
        return bikou;
    }

    public void setBikou(String bikou) {
        this.bikou = bikou;
    }

    public String getKeisanHouhou() {
        return keisanHouhou;
    }

    public void setKeisanHouhou(String keisanHouhou) {
        this.keisanHouhou = keisanHouhou;
    }
}
