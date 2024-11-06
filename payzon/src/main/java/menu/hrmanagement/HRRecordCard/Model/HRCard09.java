package menu.hrmanagement.HRRecordCard.Model;

import java.util.Date;

public class HRCard09 { // 교육사항 // 教育事項
	
	public HRCard09(){} // 교육 훈련 테이블 // 教育訓練テーブル

	private Integer shain_ID; // 사원id // 社員ID
	private String kyouiku_shurui; // 교육구분 // 教育区分
	private String kyouiku_mei; // 교육명 // 教育名
	private Date kaishi_bi; // 기간부터 // 期間から
	private Date shuuryou_bi; // 기간까지 // 期間まで
	private String kyouiku_kikan_mei; // 교육기관 // 教育機関
	private Integer kyouiku_hi; // 교육비 // 教育費
	private Integer kanpu_kyouiku_hi; // 환급교육비 // 還付教育費
	
	//	사원id // 社員ID
	//	교육구분 // 教育区分
	//	교육명 // 教育名
	//	기간부터 // 期間から
	//	기간까지 // 期間まで
	//	교육기관 // 教育機関
	//	교육비 // 教育費
	//	환급교육비 // 還付教育費
	
	public Integer getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public String getKyouiku_shurui() {
		return kyouiku_shurui;
	}
	public void setKyouiku_shurui(String kyouiku_shurui) {
		this.kyouiku_shurui = kyouiku_shurui;
	}
	public String getKyouiku_mei() {
		return kyouiku_mei;
	}
	public void setKyouiku_mei(String kyouiku_mei) {
		this.kyouiku_mei = kyouiku_mei;
	}
	public Date getKaishi_bi() {
		return kaishi_bi;
	}
	public void setKaishi_bi(Date kaishi_bi) {
		this.kaishi_bi = kaishi_bi;
	}
	public Date getShuuryou_bi() {
		return shuuryou_bi;
	}
	public void setShuuryou_bi(Date shuuryou_bi) {
		this.shuuryou_bi = shuuryou_bi;
	}
	public String getKyouiku_kikan_mei() {
		return kyouiku_kikan_mei;
	}
	public void setKyouiku_kikan_mei(String kyouiku_kikan_mei) {
		this.kyouiku_kikan_mei = kyouiku_kikan_mei;
	}
	public Integer getKyouiku_hi() {
		return kyouiku_hi;
	}
	public void setKyouiku_hi(Integer kyouiku_hi) {
		this.kyouiku_hi = kyouiku_hi;
	}
	public Integer getKanpu_kyouiku_hi() {
		return kanpu_kyouiku_hi;
	}
	public void setKanpu_kyouiku_hi(Integer kanpu_kyouiku_hi) {
		this.kanpu_kyouiku_hi = kanpu_kyouiku_hi;
	}
}
