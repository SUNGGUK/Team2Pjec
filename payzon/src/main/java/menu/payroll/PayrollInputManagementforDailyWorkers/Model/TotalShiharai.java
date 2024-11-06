package menu.payroll.PayrollInputManagementforDailyWorkers.Model;

import java.math.BigDecimal;

public class TotalShiharai {
    private int totalKingaku; // 지급 항목 ID (支給項目ID)
    private int shainId; // 사원 ID (社員ID)
    private BigDecimal shikyuuzoukyuu; // 지급 총액 (支給総額)
    private BigDecimal kihonkyu; // 기본급 (基本給)
    private BigDecimal shokujitane; // 식사 수당 (食事手当)
    private BigDecimal hoikutane; // 보육 수당 (保育手当)
    private BigDecimal yakushokutane; // 직책 수당 (職責手当)
    private BigDecimal sharyouijihi; // 차량 유지비 (車両維持費)
    private BigDecimal kinzokutane; // 근속 수당 (勤続手当)
    private BigDecimal touchakutane; // 당직 수당 (当直手当)
    private BigDecimal shouyo; // 보너스 (ボーナス)
    private BigDecimal kyuujitsutane; // 휴일 수당 (休日手当)
    private String kazeiUmu; // 과세 여부 (課税の有無)
    private String zessaTani; // 절사 단위 (切捨て単位)
    private String kintaiIkatsu; // 근태 연결/일괄 지급 (勤怠連携/一括支給)
    private BigDecimal ikkatsuShikyuugaku; // 일괄 지급액 (一括支給額)
    private String shiyouUmu; // 사용 여부 (使用の有無)
    private String keisanHouhou; // 계산 방법 (計算方法)

    // Constructor
    public TotalShiharai(int totalKingaku, int shainId, BigDecimal shikyuuzoukyuu) {
        this.totalKingaku = totalKingaku;
        this.shainId = shainId;
        this.shikyuuzoukyuu = shikyuuzoukyuu;
    }

    // Getter 및 Setter 메서드
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

    public BigDecimal getShikyuuzoukyuu() {
        return shikyuuzoukyuu;
    }

    public void setShikyuuzoukyuu(BigDecimal shikyuuzoukyuu) {
        if (shikyuuzoukyuu.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("지급 총액은 음수일 수 없습니다."); // 지급 총액은 음수일 수 없습니다 (支給総額は負の値にはできません)
        }
        this.shikyuuzoukyuu = shikyuuzoukyuu;
    }

    public BigDecimal getKihonkyu() {
        return kihonkyu;
    }

    public void setKihonkyu(BigDecimal kihonkyu) {
        this.kihonkyu = kihonkyu;
    }

    public BigDecimal getShokujitane() {
        return shokujitane;
    }

    public void setShokujitane(BigDecimal shokujitane) {
        this.shokujitane = shokujitane;
    }

    public BigDecimal getHoikutane() {
        return hoikutane;
    }

    public void setHoikutane(BigDecimal hoikutane) {
        this.hoikutane = hoikutane;
    }

    public BigDecimal getYakushokutane() {
        return yakushokutane;
    }

    public void setYakushokutane(BigDecimal yakushokutane) {
        this.yakushokutane = yakushokutane;
    }

    public BigDecimal getSharyouijihi() {
        return sharyouijihi;
    }

    public void setSharyouijihi(BigDecimal sharyouijihi) {
        this.sharyouijihi = sharyouijihi;
    }

    public BigDecimal getKinzokutane() {
        return kinzokutane;
    }

    public void setKinzokutane(BigDecimal kinzokutane) {
        this.kinzokutane = kinzokutane;
    }

    public BigDecimal getTouchakutane() {
        return touchakutane;
    }

    public void setTouchakutane(BigDecimal touchakutane) {
        this.touchakutane = touchakutane;
    }

    public BigDecimal getShouyo() {
        return shouyo;
    }

    public void setShouyo(BigDecimal shouyo) {
        this.shouyo = shouyo;
    }

    public BigDecimal getKyuujitsutane() {
        return kyuujitsutane;
    }

    public void setKyuujitsutane(BigDecimal kyuujitsutane) {
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

    public BigDecimal getIkkatsuShikyuugaku() {
        return ikkatsuShikyuugaku;
    }

    public void setIkkatsuShikyuugaku(BigDecimal ikkatsuShikyuugaku) {
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
