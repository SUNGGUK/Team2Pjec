package menu.BasicSettings.EmployeeRegistration.model;

import java.sql.Date;

//-- 10. 경력 정보 테이블 (keireki_zyouhou)
//-- 10. 経歴情報テーブル (keireki_zyouhou)
public class keireki_zyouhou {
    int shain_ID; // 사원 ID / 社員ID
    String kaisha_mei; // 회사명 / 会社名
    Date tasha_nyuusha_bi; // 타사 입사일 / 他社入社日
    Date tasha_taishoku_bi; // 타사 퇴사일 / 他社退職日
    int kinmu_kikan; // 근무 기간 / 勤務期間
    String saishuu_yakushoku; // 최종 직위 / 最終役職
    String tantou_shokumu; // 담당 직무 / 担当職務
    String taishoku_ziyuu; // 퇴사 이유 / 退職理由

    public keireki_zyouhou() {}

    // 모든 필드를 포함하는 생성자 정의 / 全てのフィールドを含むコンストラクタ定義
    public keireki_zyouhou(int shain_ID, String kaisha_mei, Date tasha_nyuusha_bi, Date tasha_taishoku_bi, 
                           int kinmu_kikan, String saishuu_yakushoku, String tantou_shokumu, String taishoku_ziyuu) {
        this.shain_ID = shain_ID;
        this.kaisha_mei = kaisha_mei;
        this.tasha_nyuusha_bi = tasha_nyuusha_bi;
        this.tasha_taishoku_bi = tasha_taishoku_bi;
        this.kinmu_kikan = kinmu_kikan;
        this.saishuu_yakushoku = saishuu_yakushoku;
        this.tantou_shokumu = tantou_shokumu;
        this.taishoku_ziyuu = taishoku_ziyuu;
    }

    // Getter 및 Setter 메서드 (각 메서드에 한국어/일본어 주석 포함)
    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public String getKaisha_mei() { return kaisha_mei; }
    public void setKaisha_mei(String kaisha_mei) { this.kaisha_mei = kaisha_mei; }

    public Date getTasha_nyuusha_bi() { return tasha_nyuusha_bi; }
    public void setTasha_nyuusha_bi(Date tasha_nyuusha_bi) { this.tasha_nyuusha_bi = tasha_nyuusha_bi; }

    public Date getTasha_taishoku_bi() { return tasha_taishoku_bi; }
    public void setTasha_taishoku_bi(Date tasha_taishoku_bi) { this.tasha_taishoku_bi = tasha_taishoku_bi; }

    public int getKinmu_kikan() { return kinmu_kikan; }
    public void setKinmu_kikan(int kinmu_kikan) { this.kinmu_kikan = kinmu_kikan; }

    public String getSaishuu_yakushoku() { return saishuu_yakushoku; }
    public void setSaishuu_yakushoku(String saishuu_yakushoku) { this.saishuu_yakushoku = saishuu_yakushoku; }

    public String getTantou_shokumu() { return tantou_shokumu; }
    public void setTantou_shokumu(String tantou_shokumu) { this.tantou_shokumu = tantou_shokumu; }

    public String getTaishoku_ziyuu() { return taishoku_ziyuu; }
    public void setTaishoku_ziyuu(String taishoku_ziyuu) { this.taishoku_ziyuu = taishoku_ziyuu; }
}
