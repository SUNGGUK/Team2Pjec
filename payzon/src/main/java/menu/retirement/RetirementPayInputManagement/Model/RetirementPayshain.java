package menu.retirement.RetirementPayInputManagement.Model;

public class RetirementPayshain {
	private String koyou_keitai ; //정규직구분
	private String shain_ID ; //사원번호
	private String shain_namae ; //성명
	private String bu ; //부서
	private String yakushoku ; //직위
	private String zyoutai ; //상태
	
	
	public RetirementPayshain(String koyou_keitai, String shain_ID, String shain_namae, String bu, String yakushoku,
			String zyoutai) {
		super();
		this.koyou_keitai = koyou_keitai;
		this.shain_ID = shain_ID;
		this.shain_namae = shain_namae;
		this.bu = bu;
		this.yakushoku = yakushoku;
		this.zyoutai = zyoutai;
	}
	public String getKoyou_keitai() {
		return koyou_keitai;
	}
	public void setKoyou_keitai(String koyou_keitai) {
		this.koyou_keitai = koyou_keitai;
	}
	public String getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(String shain_ID) {
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
	public String getZyoutai() {
		return zyoutai;
	}
	public void setZyoutai(String zyoutai) {
		this.zyoutai = zyoutai;
	}
		
	
}
