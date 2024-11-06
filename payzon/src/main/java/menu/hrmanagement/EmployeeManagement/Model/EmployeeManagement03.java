package menu.hrmanagement.EmployeeManagement.Model;

import java.util.Date;

public class EmployeeManagement03 { // 재직, 퇴직 상태 // 在職、退職状態

	public EmployeeManagement03() {} // 18. 퇴직 테이블 (taishoku) // 退職テーブル (退職)
	
	private Integer shain_ID; // 사원 ID (Foreign Key) // 社員ID (外部キー)
	private String zyoutai; // 상태(재직, 퇴직) // 状態（在職、退職）
	private Date taishoku_bi;
	
	public Integer getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public String getZyoutai() {
		return zyoutai;
	}
	public void setZyoutai(String zyoutai) {
		this.zyoutai = zyoutai;
	}
	public Date getTaishoku_bi() {
		return taishoku_bi;
	}
	public void setTaishoku_bi(Date taishoku_bi) {
		this.taishoku_bi = taishoku_bi;
	}
}