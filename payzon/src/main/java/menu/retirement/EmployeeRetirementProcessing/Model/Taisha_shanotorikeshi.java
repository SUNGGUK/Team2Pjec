package menu.retirement.EmployeeRetirementProcessing.Model;

import java.util.Date;

public class Taisha_shanotorikeshi {
    private int shain_ID;                    // 사원 ID (숫자형)
    private String taishoku_kubun;           // 퇴직 구분
    private Date taishoku_bi;                // 퇴직일
    private String taishoku_ziyuu;           // 퇴직 사유
    private String taishoku_go_renrakusaki;  // 퇴직 후 연락처
    

    
    
    public Taisha_shanotorikeshi() {
    }


	// 전체 필드를 받는 생성자 추가
    public Taisha_shanotorikeshi(int shain_ID, String taishoku_kubun, Date taishoku_bi, String taishoku_ziyuu, String taishoku_go_renrakusaki) {
        this.shain_ID = shain_ID;
        this.taishoku_kubun = taishoku_kubun;
        this.taishoku_bi = taishoku_bi;
        this.taishoku_ziyuu = taishoku_ziyuu;
        this.taishoku_go_renrakusaki = taishoku_go_renrakusaki;
    }

    public int getShain_ID() {
        return shain_ID;
    }

    public void setShain_ID(int shain_ID) {
        this.shain_ID = shain_ID;
    }

    public String getTaishoku_kubun() {
        return taishoku_kubun;
    }

    public void setTaishoku_kubun(String taishoku_kubun) {
        this.taishoku_kubun = taishoku_kubun;
    }

    public Date getTaishoku_bi() {
        return taishoku_bi;
    }

    public void setTaishoku_bi(Date taishoku_bi) {
        this.taishoku_bi = taishoku_bi;
    }

    public String getTaishoku_ziyuu() {
        return taishoku_ziyuu;
    }

    public void setTaishoku_ziyuu(String taishoku_ziyuu) {
        this.taishoku_ziyuu = taishoku_ziyuu;
    }

    public String getTaishoku_go_renrakusaki() {
        return taishoku_go_renrakusaki;
    }

    public void setTaishoku_go_renrakusaki(String taishoku_go_renrakusaki) {
        this.taishoku_go_renrakusaki = taishoku_go_renrakusaki;
    }
    
}
