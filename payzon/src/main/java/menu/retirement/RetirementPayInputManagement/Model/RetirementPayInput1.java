package menu.retirement.RetirementPayInputManagement.Model;

import java.sql.Date;

public class RetirementPayInput1 {
	private String shain_id;
	private Date jitsu_shikyuu_gaku_bi ; //지급일
	private String seisan_kubun;//구분
	private String shain_namae; //성명
	private String yakushoku; //직위
	private String bu;//부서
	private Date Santei_kikan;//산정기간
	private int kinzoku_nissuu; 			//근속일수
	private String taishoku_kin;//실지급액
	private String kouza_bangou;			//계좌번호

	public RetirementPayInput1(String shain_id,Date jitsu_shikyuu_gaku_bi, String seisan_kubun, String shain_namae, String yakushoku, String bu,
			Date santei_kikan, int kinzoku_nissuu, String taishoku_kin, String kouza_bangou) {
		super();
		this.jitsu_shikyuu_gaku_bi = jitsu_shikyuu_gaku_bi;
		this.seisan_kubun = seisan_kubun;
		this.shain_namae = shain_namae;
		this.yakushoku = yakushoku;
		this.bu = bu;
		this.Santei_kikan = santei_kikan;
		this.kinzoku_nissuu = kinzoku_nissuu;
		this.taishoku_kin = taishoku_kin;
		this.kouza_bangou = kouza_bangou;
		this.shain_id = shain_id;
	}
	
	
	public String getShain_id() {
		return shain_id;
	}


	public void setShain_id(String shain_id) {
		this.shain_id = shain_id;
	}


	public Date getJitsu_shikyuu_gaku_bi() {
		return jitsu_shikyuu_gaku_bi;
	}
	public void setJitsu_shikyuu_gaku_bi(Date jitsu_shikyuu_gaku_bi) {
		this.jitsu_shikyuu_gaku_bi = jitsu_shikyuu_gaku_bi;
	}
	public String getSeisan_kubun() {
		return seisan_kubun;
	}
	public void SetSeisan_kubun(String seisan_kubun) {
		this.seisan_kubun = seisan_kubun;
	}
	public String getShain_namae() {
		return shain_namae;
	}
	public void setShain_namae(String shain_namae) {
		this.shain_namae = shain_namae;
	}
	public String getYakushoku() {
		return yakushoku;
	}
	public void setYakushoku(String yakushoku) {
		this.yakushoku = yakushoku;
	}
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
	public Date getSantei_kikan() {
		return Santei_kikan;
	}
	public void setSantei_kikan(Date santei_kikan) {
		Santei_kikan = santei_kikan;
	}
	public int getKinzoku_nissuu() {
		return kinzoku_nissuu;
	}
	public void setKinzoku_nissuu(int kinzoku_nissuu) {
		this.kinzoku_nissuu = kinzoku_nissuu;
	}
	public String getTaishoku_kin() {
		return taishoku_kin;
	}
	public void setTaishoku_kin(String taishoku_kin) {
		this.taishoku_kin = taishoku_kin;
	}
	public String getKouza_bangou() {
		return kouza_bangou;
	}
	public void setKouza_bangou(String kouza_bangou) {
		this.kouza_bangou = kouza_bangou;
	}
	
	
	
	
}
