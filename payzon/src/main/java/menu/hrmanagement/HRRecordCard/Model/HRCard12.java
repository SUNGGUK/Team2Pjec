package menu.hrmanagement.HRRecordCard.Model;

import java.util.Date;

public class HRCard12 { // 퇴직 사항 // 退職事項
	
	public HRCard12() {} // 퇴직 테이블 // 退職テーブル
	
	private Integer shain_ID; // 사원 ID (Foreign Key) // 社員ID（外部キー）
	private String zyoutai; // 재직상태 // 在職状態
	private String taishoku_kubun; // 퇴직 구분 // 退職区分
	private Date taishoku_bi; // 퇴직 일자 // 退職日
	private String taishoku_ziyuu; // 퇴직 사유 // 退職理由
	private String taishoku_go_renrakusaki; // 퇴직 후 연락처 // 退職後の連絡先
	private Integer taishoku_kin; // 퇴직금 // 退職金
	
	//  shain_ID NUMBER,               -- 사원 ID (Foreign Key) // 社員ID（外部キー）
	//	재직상태 // 在職状態
	//  taishoku_kubun VARCHAR2(100),  -- 퇴직 구분 // 退職区分
	//  taishoku_bi DATE,              -- 퇴직 일자 // 退職日
	//  taishoku_ziyuu VARCHAR2(200),  -- 퇴직 사유 // 退職理由
	//  taishoku_go_renrakusaki VARCHAR2(100), // 퇴직 후 연락처 // 退職後の連絡先
	//  taishoku_kin NUMBER,           -- 퇴직금 // 退職金
	
	//	사원id // 社員ID
	//	퇴직구분 // 退職区分
	//	퇴직일자 // 退職日
	//	퇴직사유 // 退職理由
	//	퇴직금 // 退職金
	//	퇴직후 연락처 // 退職後の連絡先
	
	public Integer getShain_ID() {
		return shain_ID;
	}
	public String getZyoutai() {
		return zyoutai;
	}
	public void setZyoutai(String zyoutai) {
		this.zyoutai = zyoutai;
	}
	public void setShain_ID(Integer shain_ID) {
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
	public Integer getTaishoku_kin() {
		return taishoku_kin;
	}
	public void setTaishoku_kin(Integer taishoku_kin) {
		this.taishoku_kin = taishoku_kin;
	}
}