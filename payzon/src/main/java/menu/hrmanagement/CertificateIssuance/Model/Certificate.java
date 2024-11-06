package menu.hrmanagement.CertificateIssuance.Model;

public class Certificate {//제증명서 발급
	
	public Certificate() {}
	
	private Integer hakkyuu_ID;
	private Integer shain_ID;
	private String shain_namae;
	private String zyuumin_bangou;
	private String zyuusho;
	
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
	public String getShain_namae() {
		return shain_namae;
	}
	public void setShain_namae(String shain_namae) {
		this.shain_namae = shain_namae;
	}
	public String getZyuumin_bangou() {
		return zyuumin_bangou;
	}
	public void setZyuumin_bangou(String zyuumin_bangou) {
		this.zyuumin_bangou = zyuumin_bangou;
	}
	public String getZyuusho() {
		return zyuusho;
	}
	public void setZyuusho(String zyuusho) {
		this.zyuusho = zyuusho;
	}
	
}