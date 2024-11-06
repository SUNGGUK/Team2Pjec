package menu.payroll.EmployeePayrollDetails.Model;

public class TotalShiharai{
    private int totalKingaku;         // 지급 항목 ID
    private int shainId;              // 사원 ID
    private double shikyuuzoukyuu;    // 지급 총액
    private double kihonkyu;          // 기본급
    private double shokujitane;       // 식사 수당
    private double hoikutane;         // 보육 수당
    private double yakushokutane;     // 직책 수당
    private double sharyouijihi;      // 차량 유지비
    private double kinzokutane;       // 근속 수당
    private double touchakutane;      // 당직 수당
    private double shouyo;            // 보너스
    private double kyuujitsutane;     // 휴일 수당
    private String kazeiUmu;          // 과세 여부
    private String zessaTani;         // 절사 단위
    private String kintaiIkatsu;      // 근태 연결/일괄 지급
    private double ikkatsuShikyuugaku; // 일괄 지급액
    private String shiyouUmu;         // 사용 여부
    private String keisanHouhou;      // 계산 방법

    // Getters and Setters
    public int getTotalKingaku() {
        return totalKingaku;
    }

    public void setTotalKingaku(int totalKingaku) {
        this.totalKingaku = totalKingaku;
    }

    public int getShainId() {
        return shainId;
    }

    public void setShainId(int shainId) {
        this.shainId = shainId;
    }

    public double getShikyuuzoukyuu() {
        return shikyuuzoukyuu;
    }

    public void setShikyuuzoukyuu(double shikyuuzoukyuu) {
        this.shikyuuzoukyuu = shikyuuzoukyuu;
    }

    public double getKihonkyu() {
        return kihonkyu;
    }

    public void setKihonkyu(double kihonkyu) {
        this.kihonkyu = kihonkyu;
    }

    public double getShokujitane() {
        return shokujitane;
    }

    public void setShokujitane(double shokujitane) {
        this.shokujitane = shokujitane;
    }

    public double getHoikutane() {
        return hoikutane;
    }

    public void setHoikutane(double hoikutane) {
        this.hoikutane = hoikutane;
    }

    public double getYakushokutane() {
        return yakushokutane;
    }

    public void setYakushokutane(double yakushokutane) {
        this.yakushokutane = yakushokutane;
    }

    public double getSharyouijihi() {
        return sharyouijihi;
    }

    public void setSharyouijihi(double sharyouijihi) {
        this.sharyouijihi = sharyouijihi;
    }

    public double getKinzokutane() {
        return kinzokutane;
    }

    public void setKinzokutane(double kinzokutane) {
        this.kinzokutane = kinzokutane;
    }

    public double getTouchakutane() {
        return touchakutane;
    }

    public void setTouchakutane(double touchakutane) {
        this.touchakutane = touchakutane;
    }

    public double getShouyo() {
        return shouyo;
    }

    public void setShouyo(double shouyo) {
        this.shouyo = shouyo;
    }

    public double getKyuujitsutane() {
        return kyuujitsutane;
    }

    public void setKyuujitsutane(double kyuujitsutane) {
        this.kyuujitsutane = kyuujitsutane;
    }

    public String getKazeiUmu() {
        return kazeiUmu;
    }

    public void setKazeiUmu(String kazeiUmu) {
        this.kazeiUmu = kazeiUmu;
    }

    public String getZessaTani() {
        return zessaTani;
    }

    public void setZessaTani(String zessaTani) {
        this.zessaTani = zessaTani;
    }

    public String getKintaiIkatsu() {
        return kintaiIkatsu;
    }

    public void setKintaiIkatsu(String kintaiIkatsu) {
        this.kintaiIkatsu = kintaiIkatsu;
    }

    public double getIkkatsuShikyuugaku() {
        return ikkatsuShikyuugaku;
    }

    public void setIkkatsuShikyuugaku(double ikkatsuShikyuugaku) {
        this.ikkatsuShikyuugaku = ikkatsuShikyuugaku;
    }

    public String getShiyouUmu() {
        return shiyouUmu;
    }

    public void setShiyouUmu(String shiyouUmu) {
        this.shiyouUmu = shiyouUmu;
    }

    public String getKeisanHouhou() {
        return keisanHouhou;
    }

    public void setKeisanHouhou(String keisanHouhou) {
        this.keisanHouhou = keisanHouhou;
    }
}
