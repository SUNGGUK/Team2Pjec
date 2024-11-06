package menu.hrmanagement.HRRecordCard.Model;

import java.util.Date;

public class HRCard02 {

	public HRCard02() {}//사원 등록 6번테이블社員登録(shain_touroku)　6番テーブル (shain_touroku)
	
	private Integer shain_ID;					//사원id(사원번호)	社員ID		
	private String koyou_keitai;				//고용형태(구분)雇用形態
	private String shain_namae;					//사원명(일어)社員名（日本語）
	private String shain_eigo_namae;			//사원명(영어)社員名（英語）
	private Date nyuusha_bi;					//입사일入社日
	private Date taisha_bi;						//퇴사일退職日
	private String bu;							//부서部署
	private String yakushoku;					//직위役職
	private String nai_gaikokuzin;				//내/외국인内・外国人
	private String zyuumin_bangou;				//주민번호住民番号
	private String zyuusho;						//주소住所
	private String denwa_bangou;				//전화번호電話番号
	private String keitai_bangou;				//휴대전화번호携帯電話番号
	private String meiru_adoresu;				//메일주소メール住所
	private String sns;							//snsSNS
	private String busho_mei;					//부서명部署名
	private String shokui_mei;					//직무명職位名
	private String bikou;						//비고備考
	
//	인사기록카드 표에 들어감　//　人事記録カードの表に入る
//	사원번호 : shain_ID　//　社員番号 : shain_ID
//	입사일　//　入社日
//	퇴사일　//　退職日
//	성명(일어)　//　姓名（日本語）
//	성명(영어)　//　姓名（英語）
//	주민등록번호　//　住民登録番号
//	사원구분(고용형태)　//　社員区分（雇用形態）
//	주소　//　住所
//	휴대전화번호　//　携帯電話番号
//	전화번호　//　電話番号
//	email　//　メールアドレス

//	인사기록카드 사원선택 쪽임　//　人事記録カードの社員選択の方
//	구분(고용형태)　//　区分（雇用形態）
//	사원번호 shain_ID　//　社員番号 shain_ID
//	성명(일어)　//　姓名（日本語）
//	부서　//　部署
//	직위　//　役職
//	상태　//　状態
	
	public Integer getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public String getKoyou_keitai() {
		return koyou_keitai;
	}
	public void setKoyou_keitai(String koyou_keitai) {
		this.koyou_keitai = koyou_keitai;
	}
	public String getShain_namae() {
		return shain_namae;
	}
	public void setShain_namae(String shain_namae) {
		this.shain_namae = shain_namae;
	}
	public String getShain_eigo_namae() {
		return shain_eigo_namae;
	}
	public void setShain_eigo_namae(String shain_eigo_namae) {
		this.shain_eigo_namae = shain_eigo_namae;
	}
	public Date getNyuusha_bi() {
		return nyuusha_bi;
	}
	public void setNyuusha_bi(Date nyuusha_bi) {
		this.nyuusha_bi = nyuusha_bi;
	}
	public Date getTaisha_bi() {
		return taisha_bi;
	}
	public void setTaisha_bi(Date taisha_bi) {
		this.taisha_bi = taisha_bi;
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
	public String getNai_gaikokuzin() {
		return nai_gaikokuzin;
	}
	public void setNai_gaikokuzin(String nai_gaikokuzin) {
		this.nai_gaikokuzin = nai_gaikokuzin;
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
	public String getDenwa_bangou() {
		return denwa_bangou;
	}
	public void setDenwa_bangou(String denwa_bangou) {
		this.denwa_bangou = denwa_bangou;
	}
	public String getKeitai_bangou() {
		return keitai_bangou;
	}
	public void setKeitai_bangou(String keitai_bangou) {
		this.keitai_bangou = keitai_bangou;
	}
	public String getMeiru_adoresu() {
		return meiru_adoresu;
	}
	public void setMeiru_adoresu(String meiru_adoresu) {
		this.meiru_adoresu = meiru_adoresu;
	}
	public String getSns() {
		return sns;
	}
	public void setSns(String sns) {
		this.sns = sns;
	}
	public String getBusho_mei() {
		return busho_mei;
	}
	public void setBusho_mei(String busho_mei) {
		this.busho_mei = busho_mei;
	}
	public String getShokui_mei() {
		return shokui_mei;
	}
	public void setShokui_mei(String shokui_mei) {
		this.shokui_mei = shokui_mei;
	}
	public String getBikou() {
		return bikou;
	}
	public void setBikou(String bikou) {
		this.bikou = bikou;
	}
}
