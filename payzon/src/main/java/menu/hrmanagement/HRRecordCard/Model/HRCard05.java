package menu.hrmanagement.HRRecordCard.Model;

import java.util.Date;

public class HRCard05 {

    public HRCard05() {} // 학력 // 学歴

    private Integer gakureki_ID; // 학력id // 学歴ID
    private Integer shain_ID; // 사원id // 社員ID
    private String gakkou_mei; // 학교명 // 学校名
    private String gakui; // 이수 // 学位
    private String senkou; // 전공 // 専攻
    private Date nyuugaku_bi; // 입학년월 // 入学年月
    private Date sotsugyou_bi; // 졸업년월 // 卒業年月
    private String sotsugyou_umu; // 졸업유무 // 卒業有無

    //	학력id // 学歴ID
    //	사원id // 社員ID
    //	학교명 // 学校名
    //	입학년월 // 入学年月
    //	졸업년월 // 卒業年月
    //	전공 // 専攻
    //	이수 -> table에 CHAR 대신 VARCHAR2(50)으로 만들어야 할 듯 // 取得 -> テーブルにCHARの代わりにVARCHAR2(50)で作成する必要があるかもしれません
	
	public Integer getGakureki_ID() {
		return gakureki_ID;
	}
	public void setGakureki_ID(Integer gakureki_ID) {
		this.gakureki_ID = gakureki_ID;
	}
	public Integer getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public String getGakkou_mei() {
		return gakkou_mei;
	}
	public void setGakkou_mei(String gakkou_mei) {
		this.gakkou_mei = gakkou_mei;
	}
	public String getGakui() {
		return gakui;
	}
	public void setGakui(String gakui) {
		this.gakui = gakui;
	}
	public String getSenkou() {
		return senkou;
	}
	public void setSenkou(String senkou) {
		this.senkou = senkou;
	}
	public Date getNyuugaku_bi() {
		return nyuugaku_bi;
	}
	public void setNyuugaku_bi(Date nyuugaku_bi) {
		this.nyuugaku_bi = nyuugaku_bi;
	}
	public Date getSotsugyou_bi() {
		return sotsugyou_bi;
	}
	public void setSotsugyou_bi(Date sotsugyou_bi) {
		this.sotsugyou_bi = sotsugyou_bi;
	}
	public String getSotsugyou_umu() {
		return sotsugyou_umu;
	}
	public void setSotsugyou_umu(String sotsugyou_umu) {
		this.sotsugyou_umu = sotsugyou_umu;
	}
}
