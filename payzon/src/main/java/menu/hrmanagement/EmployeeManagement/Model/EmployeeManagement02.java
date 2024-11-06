package menu.hrmanagement.EmployeeManagement.Model;

public class EmployeeManagement02 {

	public EmployeeManagement02() {}
	
	private Integer shain_ID;
	private String ginkou_mei;					// 은행명 // 銀行名
	private String kouza_bangou;				// 계좌번호 // 口座番号
	
	public Integer getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public String getGinkou_mei() {
		return ginkou_mei;
	}
	public void setGinkou_mei(String ginkou_mei) {
		this.ginkou_mei = ginkou_mei;
	}
	public String getKouza_bangou() {
		return kouza_bangou;
	}
	public void setKouza_bangou(String kouza_bangou) {
		this.kouza_bangou = kouza_bangou;
	}
}