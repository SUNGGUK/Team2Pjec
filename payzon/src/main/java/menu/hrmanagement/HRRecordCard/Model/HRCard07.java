package menu.hrmanagement.HRRecordCard.Model;

import java.util.Date;

public class HRCard07 {//경력
	
    public HRCard07() {} // 경력 정보 테이블 // 経歴情報テーブル

    private Integer shain_ID; // 사원id // 社員ID
    private String kaisha_mei; // 회사명 // 会社名
    private Date nyuusha_bi; // 입사일자 // 入社日
    private Date taishoku_bi; // 퇴사일자 // 退職日
    private Integer kinmu_kikan; // 근무기간 -> 필요 없음 // 勤務期間 -> 不要
    private String saishuu_yakushoku; // 최종직위 // 最終職位
    private String tantou_shokumu; // 담당업무 // 担当業務
    private String taishoku_ziyuu; // 퇴직 사유 // 退職理由

    //	사원id // 社員ID
    //	회사명 // 会社名
    //	입사일자 // 入社日
    //	퇴사일자 // 退職日
    //	근무기간 -> 필요 없음 // 勤務期間 -> 不要
    //	최종직위 // 最終職位
    //	담당업무 // 担当業務
	
	public Integer getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public String getKaisha_mei() {
		return kaisha_mei;
	}
	public void setKaisha_mei(String kaisha_mei) {
		this.kaisha_mei = kaisha_mei;
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
	public Integer getKinmu_kikan() {
		return kinmu_kikan;
	}
	public void setKinmu_kikan(Integer kinmu_kikan) {
		this.kinmu_kikan = kinmu_kikan;
	}
	public String getSaishuu_yakushoku() {
		return saishuu_yakushoku;
	}
	public void setSaishuu_yakushoku(String saishuu_yakushoku) {
		this.saishuu_yakushoku = saishuu_yakushoku;
	}
	public String getTantou_shokumu() {
		return tantou_shokumu;
	}
	public void setTantou_shokumu(String tantou_shokumu) {
		this.tantou_shokumu = tantou_shokumu;
	}
	public String getTaishoku_ziyuu() {
		return taishoku_ziyuu;
	}
	public void setTaishoku_ziyuu(String taishoku_ziyuu) {
		this.taishoku_ziyuu = taishoku_ziyuu;
	}
}
