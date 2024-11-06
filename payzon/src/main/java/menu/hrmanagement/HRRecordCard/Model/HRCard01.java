package menu.hrmanagement.HRRecordCard.Model;

import java.util.Date;

public class HRCard01 {

	public HRCard01() {}//회사 정보 테이블 会社情報テーブル (kaisha_zyouhou)
	
	private String kaisha_mei;			//회사명 会社名
	private String shachou_yakushoku;	//CEO직책　CEO役職
	private String shachou_mei;			//CEO이름　CEO名前
	private Integer zigyou_bangou;		//사업자번호　事業者番号
	private Integer houzin_bangou;		//법인번호　法人番号
	private Date setsuritsu_bi;			//설립일　設立日
	private String ulebusaito;			//웹사이트　ウェブサイト
	private Integer yubinbango;			//우편번호　メール番号
	private String zigyouzyou_zyuusho;	//사업장 주소　事業所住所
	private Integer denwa_bangou;		//전화번호　電話番号
	private String fakus__bangou;		//팩스번호　ファクス番号
	private String zigyou_shurui;		//사업종류　事業種類
	private String zigyou_naiyou;		//사업내용　事業内容

	public String getKaisha_mei() {
		return kaisha_mei;
	}
	public void setKaisha_mei(String kaisha_mei) {
		this.kaisha_mei = kaisha_mei;
	}
	public String getShachou_yakushoku() {
		return shachou_yakushoku;
	}
	public void setShachou_yakushoku(String shachou_yakushoku) {
		this.shachou_yakushoku = shachou_yakushoku;
	}
	public String getShachou_mei() {
		return shachou_mei;
	}
	public void setShachou_mei(String shachou_mei) {
		this.shachou_mei = shachou_mei;
	}
	public Integer getZigyou_bangou() {
		return zigyou_bangou;
	}
	public void setZigyou_bangou(Integer zigyou_bangou) {
		this.zigyou_bangou = zigyou_bangou;
	}
	public Integer getHouzin_bangou() {
		return houzin_bangou;
	}
	public void setHouzin_bangou(Integer houzin_bangou) {
		this.houzin_bangou = houzin_bangou;
	}
	public Date getSetsuritsu_bi() {
		return setsuritsu_bi;
	}
	public void setSetsuritsu_bi(Date setsuritsu_bi) {
		this.setsuritsu_bi = setsuritsu_bi;
	}
	public String getUlebusaito() {
		return ulebusaito;
	}
	public void setUlebusaito(String ulebusaito) {
		this.ulebusaito = ulebusaito;
	}
	public Integer getYubinbango() {
		return yubinbango;
	}
	public void setYubinbango(Integer yubinbango) {
		this.yubinbango = yubinbango;
	}
	public String getZigyouzyou_zyuusho() {
		return zigyouzyou_zyuusho;
	}
	public void setZigyouzyou_zyuusho(String zigyouzyou_zyuusho) {
		this.zigyouzyou_zyuusho = zigyouzyou_zyuusho;
	}
	public Integer getDenwa_bangou() {
		return denwa_bangou;
	}
	public void setDenwa_bangou(Integer denwa_bangou) {
		this.denwa_bangou = denwa_bangou;
	}
	public String getFakus__bangou() {
		return fakus__bangou;
	}
	public void setFakus__bangou(String fakus__bangou) {
		this.fakus__bangou = fakus__bangou;
	}
	public String getZigyou_shurui() {
		return zigyou_shurui;
	}
	public void setZigyou_shurui(String zigyou_shurui) {
		this.zigyou_shurui = zigyou_shurui;
	}
	public String getZigyou_naiyou() {
		return zigyou_naiyou;
	}
	public void setZigyou_naiyou(String zigyou_naiyou) {
		this.zigyou_naiyou = zigyou_naiyou;
	}
	
}
