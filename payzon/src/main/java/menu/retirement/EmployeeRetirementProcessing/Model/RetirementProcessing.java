package menu.retirement.EmployeeRetirementProcessing.Model;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class RetirementProcessing {
    private String zyoutai; // 상태
    private int shain_ID; // 사원번호
    private String shain_namae; // 성명
    private String bu; // 부서
    private String yakushoku; // 직위
    private Date nyuusha_bi; // 입사일
    private Date taishoku_bi; // 퇴직일
    private String taishoku_kubun; // 퇴직 구분 (정년퇴직, 조기퇴직 등)
    private boolean chuukan_seisan_umu; // 중간정산 여부
    private boolean taishoku_seisan_umu; // 퇴직정산 여부

    
    public long getServiceDays() {
        if (nyuusha_bi == null || taishoku_bi == null) {
            return 0;
        }
        long diffInMillies = Math.abs(taishoku_bi.getTime() - nyuusha_bi.getTime());
        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
    }
    public RetirementProcessing() {
    }
    
    // 생성자
    public RetirementProcessing(String zyoutai, int shain_ID, String shain_namae, String bu, String yakushoku,
                                Date nyuusha_bi, Date taishoku_bi, String taishoku_kubun,
                                boolean chuukan_seisan_umu, boolean taishoku_seisan_umu) {
        this.zyoutai = zyoutai;
        this.shain_ID = shain_ID;
        this.shain_namae = shain_namae;
        this.bu = bu;
        this.yakushoku = yakushoku;
        this.nyuusha_bi = nyuusha_bi;
        this.taishoku_bi = taishoku_bi;
        this.taishoku_kubun = taishoku_kubun;
        this.chuukan_seisan_umu = chuukan_seisan_umu;
        this.taishoku_seisan_umu = taishoku_seisan_umu;
    }

    // Getter와 Setter
    public String getZyoutai() {
        return zyoutai;
    }

    public void setZyoutai(String zyoutai) {
        this.zyoutai = zyoutai;
    }

    public int getShain_ID() {
        return shain_ID;
    }

    public void setShain_ID(int shain_ID) {
        this.shain_ID = shain_ID;
    }

    public String getShain_namae() {
        return shain_namae;
    }

    public void setShain_namae(String shain_namae) {
        this.shain_namae = shain_namae;
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

    public Date getNyuusha_bi() {
        return nyuusha_bi;
    }

    public void setNyuusha_bi(Date nyuusha_bi) {
        this.nyuusha_bi = nyuusha_bi;
    }

    public Date getTaishoku_bi() {
        return taishoku_bi;
    }

    public void setTaishoku_bi(Date taishoku_bi) {
        this.taishoku_bi = taishoku_bi;
    }

    public String getTaishoku_kubun() {
        return taishoku_kubun;
    }

    public void setTaishoku_kubun(String taishoku_kubun) {
        this.taishoku_kubun = taishoku_kubun;
    }

    public boolean isChuukan_seisan_umu() {
        return chuukan_seisan_umu;
    }

    public void setChuukan_seisan_umu(boolean chuukan_seisan_umu) {
        this.chuukan_seisan_umu = chuukan_seisan_umu;
    }

    public boolean isTaishoku_seisan_umu() {
        return taishoku_seisan_umu;
    }

    public void setTaishoku_seisan_umu(boolean taishoku_seisan_umu) {
        this.taishoku_seisan_umu = taishoku_seisan_umu;
    }
    public String toString() {
        return "RetirementProcessing{" +
                "zyoutai='" + zyoutai + '\'' +
                ", shain_ID='" + shain_ID + '\'' +
                ", shain_namae='" + shain_namae + '\'' +
                ", bu='" + bu + '\'' +
                ", yakushoku='" + yakushoku + '\'' +
                ", nyuusha_bi=" + nyuusha_bi +
                ", taishoku_bi=" + taishoku_bi +
                ", taishoku_kubun='" + taishoku_kubun + '\'' +
                ", chuukan_seisan_umu=" + chuukan_seisan_umu +
                ", taishoku_seisan_umu=" + taishoku_seisan_umu +
                '}';
    }

}
