package menu.BasicSettings.PayrollItemSettings.model;

//-- 21. 지급항목 테이블 (total_shiharai)
//-- 21. 支給項目テーブル (total_shiharai)
public class total_shiharai {
    int total_kingaku; // 총 금액 / 総金額
    int shikyuuzoukyuu; // 지급 증가 / 支給増給
    int kihonkyu; // 기본급 / 基本給
    int shokujitane; // 식사 수당 / 食事手当
    int hoikutane; // 보육 수당 / 保育手当
    int yakushokutane; // 직책 수당 / 役職手当
    int sharyouijihi; // 차량 유지비 / 車両維持費
    int kinzokutane; // 근속 수당 / 勤続手当
    int touchakutane; // 도착 수당 / 到着手当
    int shouyo; // 상여 / 賞与
    int kyuujitsutane; // 휴일 수당 / 休日手当
    String kazei_umu; // 과세 여부 / 課税有無
    String zessa_tani; // 절세 단위 / 節税単位
    String kintai_ikkatsu; // 근태 일괄 / 勤怠一括
    int ikkatsu_shikyuugaku; // 일괄 지급액 / 一括支給額
    char shiyou_umu; // 사용 여부 / 使用有無
    String keisan_houhou; // 계산 방법 / 計算方法

    public total_shiharai(int total_kingaku, int shikyuuzoukyuu, int kihonkyu, int shokujitane, int hoikutane, 
                          int yakushokutane, int sharyouijihi, int kinzokutane, int touchakutane, int shouyo, 
                          int kyuujitsutane, String kazei_umu, String zessa_tani, String kintai_ikkatsu, 
                          int ikkatsu_shikyuugaku, char shiyou_umu, String keisan_houhou) {
        this.total_kingaku = total_kingaku;
        this.shikyuuzoukyuu = shikyuuzoukyuu;
        this.kihonkyu = kihonkyu;
        this.shokujitane = shokujitane;
        this.hoikutane = hoikutane;
        this.yakushokutane = yakushokutane;
        this.sharyouijihi = sharyouijihi;
        this.kinzokutane = kinzokutane;
        this.touchakutane = touchakutane;
        this.shouyo = shouyo;
        this.kyuujitsutane = kyuujitsutane;
        this.kazei_umu = kazei_umu;
        this.zessa_tani = zessa_tani;
        this.kintai_ikkatsu = kintai_ikkatsu;
        this.ikkatsu_shikyuugaku = ikkatsu_shikyuugaku;
        this.shiyou_umu = shiyou_umu;
        this.keisan_houhou = keisan_houhou;
    }

    // Getter and Setter methods
    // Getter 및 Setter 메서드 / Getter と Setter メソッド
    public int getTotal_kingaku() {
        return total_kingaku;
    }

    public void setTotal_kingaku(int total_kingaku) {
        this.total_kingaku = total_kingaku;
    }

    public int getShikyuuzoukyuu() {
        return shikyuuzoukyuu;
    }

    public void setShikyuuzoukyuu(int shikyuuzoukyuu) {
        this.shikyuuzoukyuu = shikyuuzoukyuu;
    }

    public int getKihonkyu() {
        return kihonkyu;
    }

    public void setKihonkyu(int kihonkyu) {
        this.kihonkyu = kihonkyu;
    }

    public int getShokujitane() {
        return shokujitane;
    }

    public void setShokujitane(int shokujitane) {
        this.shokujitane = shokujitane;
    }

    public int getHoikutane() {
        return hoikutane;
    }

    public void setHoikutane(int hoikutane) {
        this.hoikutane = hoikutane;
    }

    public int getYakushokutane() {
        return yakushokutane;
    }

    public void setYakushokutane(int yakushokutane) {
        this.yakushokutane = yakushokutane;
    }

    public int getSharyouijihi() {
        return sharyouijihi;
    }

    public void setSharyouijihi(int sharyouijihi) {
        this.sharyouijihi = sharyouijihi;
    }

    public int getKinzokutane() {
        return kinzokutane;
    }

    public void setKinzokutane(int kinzokutane) {
        this.kinzokutane = kinzokutane;
    }

    public int getTouchakutane() {
        return touchakutane;
    }

    public void setTouchakutane(int touchakutane) {
        this.touchakutane = touchakutane;
    }

    public int getShouyo() {
        return shouyo;
    }

    public void setShouyo(int shouyo) {
        this.shouyo = shouyo;
    }

    public int getKyuujitsutane() {
        return kyuujitsutane;
    }

    public void setKyuujitsutane(int kyuujitsutane) {
        this.kyuujitsutane = kyuujitsutane;
    }

    public String getKazei_umu() {
        return kazei_umu;
    }

    public void setKazei_umu(String kazei_umu) {
        this.kazei_umu = kazei_umu;
    }

    public String getZessa_tani() {
        return zessa_tani;
    }

    public void setZessa_tani(String zessa_tani) {
        this.zessa_tani = zessa_tani;
    }

    public String getKintai_ikkatsu() {
        return kintai_ikkatsu;
    }

    public void setKintai_ikkatsu(String kintai_ikkatsu) {
        this.kintai_ikkatsu = kintai_ikkatsu;
    }

    public int getIkkatsu_shikyuugaku() {
        return ikkatsu_shikyuugaku;
    }

    public void setIkkatsu_shikyuugaku(int ikkatsu_shikyuugaku) {
        this.ikkatsu_shikyuugaku = ikkatsu_shikyuugaku;
    }

    public char getShiyou_umu() {
        return shiyou_umu;
    }

    public void setShiyou_umu(char shiyou_umu) {
        this.shiyou_umu = shiyou_umu;
    }

    public String getKeisan_houhou() {
        return keisan_houhou;
    }

    public void setKeisan_houhou(String keisan_houhou) {
        this.keisan_houhou = keisan_houhou;
    }
}
