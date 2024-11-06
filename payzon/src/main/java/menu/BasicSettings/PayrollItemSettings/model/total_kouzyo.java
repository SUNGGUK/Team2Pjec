package menu.BasicSettings.PayrollItemSettings.model;

//-- 22. 공제항목 테이블 (total_kouzyo)
//-- 22. 控除項目テーブル (total_kouzyo)
public class total_kouzyo {
    int koujo_id; // 공제 ID / 控除ID
    int koujo_sougaku; // 공제 총액 / 控除総額
    int shotokuzei; // 소득세 / 所得税
    int chiho_shotokuzei; // 지방 소득세 / 地方所得税
    int koujokamoku; // 공제 항목 / 控除項目
    int daibu_hoken; // 대부 보험 / 代部保険
    int kikandani_shotokuzei; // 기간 단위 소득세 / 期間単位所得税
    int kokumin_nenkin; // 국민 연금 / 国民年金
    int kenkou_hoken; // 건강 보험 / 健康保険
    int choukikaigo_hoken; // 장기 개호 보험 / 長期介護保険
    int koyou_hoken; // 고용 보험 / 雇用保険
    int gojokaihi; // 고조 회비 / 互助会費
    String zessa_tani; // 절세 단위 / 節税単位
    char shiyou_umu; // 사용 여부 / 使用有無
    String bikou; // 비고 / 備考
    String keisan_houhou; // 계산 방법 / 計算方法

    public total_kouzyo(int koujo_id, int koujo_sougaku, int shotokuzei, int chiho_shotokuzei, int koujokamoku,
                        int daibu_hoken, int kikandani_shotokuzei, int kokumin_nenkin, int kenkou_hoken,
                        int choukikaigo_hoken, int koyou_hoken, int gojokaihi, String zessa_tani, 
                        char shiyou_umu, String bikou, String keisan_houhou) {
        this.koujo_id = koujo_id;
        this.koujo_sougaku = koujo_sougaku;
        this.shotokuzei = shotokuzei;
        this.chiho_shotokuzei = chiho_shotokuzei;
        this.koujokamoku = koujokamoku;
        this.daibu_hoken = daibu_hoken;
        this.kikandani_shotokuzei = kikandani_shotokuzei;
        this.kokumin_nenkin = kokumin_nenkin;
        this.kenkou_hoken = kenkou_hoken;
        this.choukikaigo_hoken = choukikaigo_hoken;
        this.koyou_hoken = koyou_hoken;
        this.gojokaihi = gojokaihi;
        this.zessa_tani = zessa_tani;
        this.shiyou_umu = shiyou_umu;
        this.bikou = bikou;
        this.keisan_houhou = keisan_houhou;
    }

    // Getter and Setter methods
    // Getter 및 Setter 메서드 / Getter と Setter メソッド
    public int getKoujo_id() {
        return koujo_id;
    }

    public void setKoujo_id(int koujo_id) {
        this.koujo_id = koujo_id;
    }

    public int getKoujo_sougaku() {
        return koujo_sougaku;
    }

    public void setKoujo_sougaku(int koujo_sougaku) {
        this.koujo_sougaku = koujo_sougaku;
    }

    public int getShotokuzei() {
        return shotokuzei;
    }

    public void setShotokuzei(int shotokuzei) {
        this.shotokuzei = shotokuzei;
    }

    public int getChiho_shotokuzei() {
        return chiho_shotokuzei;
    }

    public void setChiho_shotokuzei(int chiho_shotokuzei) {
        this.chiho_shotokuzei = chiho_shotokuzei;
    }

    public int getKoujokamoku() {
        return koujokamoku;
    }

    public void setKoujokamoku(int koujokamoku) {
        this.koujokamoku = koujokamoku;
    }

    public int getDaibu_hoken() {
        return daibu_hoken;
    }

    public void setDaibu_hoken(int daibu_hoken) {
        this.daibu_hoken = daibu_hoken;
    }

    public int getKikandani_shotokuzei() {
        return kikandani_shotokuzei;
    }

    public void setKikandani_shotokuzei(int kikandani_shotokuzei) {
        this.kikandani_shotokuzei = kikandani_shotokuzei;
    }

    public int getKokumin_nenkin() {
        return kokumin_nenkin;
    }

    public void setKokumin_nenkin(int kokumin_nenkin) {
        this.kokumin_nenkin = kokumin_nenkin;
    }

    public int getKenkou_hoken() {
        return kenkou_hoken;
    }

    public void setKenkou_hoken(int kenkou_hoken) {
        this.kenkou_hoken = kenkou_hoken;
    }

    public int getChoukikaigo_hoken() {
        return choukikaigo_hoken;
    }

    public void setChoukikaigo_hoken(int choukikaigo_hoken) {
        this.choukikaigo_hoken = choukikaigo_hoken;
    }

    public int getKoyou_hoken() {
        return koyou_hoken;
    }

    public void setKoyou_hoken(int koyou_hoken) {
        this.koyou_hoken = koyou_hoken;
    }

    public int getGojokaihi() {
        return gojokaihi;
    }

    public void setGojokaihi(int gojokaihi) {
        this.gojokaihi = gojokaihi;
    }

    public String getZessa_tani() {
        return zessa_tani;
    }

    public void setZessa_tani(String zessa_tani) {
        this.zessa_tani = zessa_tani;
    }

    public char getShiyou_umu() {
        return shiyou_umu;
    }

    public void setShiyou_umu(char shiyou_umu) {
        this.shiyou_umu = shiyou_umu;
    }

    public String getBikou() {
        return bikou;
    }

    public void setBikou(String bikou) {
        this.bikou = bikou;
    }

    public String getKeisan_houhou() {
        return keisan_houhou;
    }

    public void setKeisan_houhou(String keisan_houhou) {
        this.keisan_houhou = keisan_houhou;
    }
}
