package menu.hrmanagement.CertificateIssuanceRegister.Model;

import java.util.Date;

public class CertificateRegister {//발급대장

	public CertificateRegister() {}//shoumei_hakkyuu 테이블
	
	private Integer hakkyuu_ID;
	private Integer shain_ID;
	private Date shinsei_bi;
	private Date hakkyuu_bi;
	private String mokuteki;
	private String zyoutai;
	private String hakkyuusha_mei;
	private String bikou;
	
	public Integer getHakkyuu_ID() {
		return hakkyuu_ID;
	}
	public void setHakkyuu_ID(Integer hakkyuu_ID) {
		this.hakkyuu_ID = hakkyuu_ID;
	}
	public Integer getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public Date getShinsei_bi() {
		return shinsei_bi;
	}
	public void setShinsei_bi(Date shinsei_bi) {
		this.shinsei_bi = shinsei_bi;
	}
	public Date getHakkyuu_bi() {
		return hakkyuu_bi;
	}
	public void setHakkyuu_bi(Date hakkyuu_bi) {
		this.hakkyuu_bi = hakkyuu_bi;
	}
	public String getMokuteki() {
		return mokuteki;
	}
	public void setMokuteki(String mokuteki) {
		this.mokuteki = mokuteki;
	}
	public String getZyoutai() {
		return zyoutai;
	}
	public void setZyoutai(String zyoutai) {
		this.zyoutai = zyoutai;
	}
	public String getHakkyuusha_mei() {
		return hakkyuusha_mei;
	}
	public void setHakkyuusha_mei(String hakkyuusha_mei) {
		this.hakkyuusha_mei = hakkyuusha_mei;
	}
	public String getBikou() {
		return bikou;
	}
	public void setBikou(String bikou) {
		this.bikou = bikou;
	}
}
