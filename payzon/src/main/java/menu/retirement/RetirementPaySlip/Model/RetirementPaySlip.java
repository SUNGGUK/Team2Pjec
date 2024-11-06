package menu.retirement.RetirementPaySlip.Model;

import java.sql.Date;

public class RetirementPaySlip {

	private String taishoku_kubun;//구분(고용형태)
	private String shain_namae;
	private int taishoku_kin; //퇴직금
	private Date jitsu_shikyuu_gaku_bi;//퇴직급여일
	private int shain_ID;	
	
	
	public RetirementPaySlip(int shain_ID) {
		super();
		this.shain_ID = shain_ID;
	}



	public int getShain_ID() {
		return shain_ID;
	}



	public void setShain_ID(int shain_ID) {
		this.shain_ID = shain_ID;
	}



	public RetirementPaySlip(String taishoku_kubun, String shain_namae, int taishoku_kin, Date jitsu_shikyuu_gaku_bi,int shain_ID) {
		super();
		this.taishoku_kubun = taishoku_kubun;
		this.shain_namae = shain_namae;
		this.taishoku_kin = taishoku_kin;
		this.jitsu_shikyuu_gaku_bi = jitsu_shikyuu_gaku_bi;
	}

	
	
	public String getTaishoku_kubun() {
		return taishoku_kubun;
	}
	public void setTaishoku_kubun(String taishoku_kubun) {
		this.taishoku_kubun = taishoku_kubun;
	}
	public String getShain_namae() {
		return shain_namae;
	}
	public void setShain_namae(String shain_namae) {
		this.shain_namae = shain_namae;
	}
	public int getTaishoku_kin() {
		return taishoku_kin;
	}
	public void setTaishoku_kin(int taishoku_kin) {
		this.taishoku_kin = taishoku_kin;
	}
	public Date getJitsu_shikyuu_gaku_bi() {
		return jitsu_shikyuu_gaku_bi;
	}
	public void setJitsu_shikyuu_gaku_bi(Date jitsu_shikyuu_gaku_bi) {
		this.jitsu_shikyuu_gaku_bi = jitsu_shikyuu_gaku_bi;
	}
	
}
	
	
	
