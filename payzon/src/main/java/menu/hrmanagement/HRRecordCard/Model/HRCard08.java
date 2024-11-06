package menu.hrmanagement.HRRecordCard.Model;

import java.util.Date;

public class HRCard08 { // 외국어명 // 外国語名

    public HRCard08() {} // 어학 능력 테이블 // 語学能力テーブル

    private Integer shain_ID; // 사원id // 社員ID
    private String gaikokugo_mei; // 외국어명 // 外国語名
    private String shiken_mei; // 시험 // 試験
    private Integer kounin_tensuu; // 공인점수 // 公認点数
    private Date shutoku_bi; // 취득일 // 取得日
    private String dokkai; // 독해 // 読解
    private String sakubun; // 작문 // 作文
    private String kaiwa; // 회화 // 会話

    //	사원id // 社員ID
    //	외국어명 // 外国語名
    //	시험 // 試験
    //	공인점수 // 公認点数
    //	취득일 // 取得日
    //	독해 // 読解
    //	작문 // 作文
    //	회화 // 会話
	
	public Integer getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public String getGaikokugo_mei() {
		return gaikokugo_mei;
	}
	public void setGaikokugo_mei(String gaikokugo_mei) {
		this.gaikokugo_mei = gaikokugo_mei;
	}
	public String getShiken_mei() {
		return shiken_mei;
	}
	public void setShiken_mei(String shiken_mei) {
		this.shiken_mei = shiken_mei;
	}
	public Integer getKounin_tensuu() {
		return kounin_tensuu;
	}
	public void setKounin_tensuu(Integer kounin_tensuu) {
		this.kounin_tensuu = kounin_tensuu;
	}
	public Date getShutoku_bi() {
		return shutoku_bi;
	}
	public void setShutoku_bi(Date shutoku_bi) {
		this.shutoku_bi = shutoku_bi;
	}
	public String getDokkai() {
		return dokkai;
	}
	public void setDokkai(String dokkai) {
		this.dokkai = dokkai;
	}
	public String getSakubun() {
		return sakubun;
	}
	public void setSakubun(String sakubun) {
		this.sakubun = sakubun;
	}
	public String getKaiwa() {
		return kaiwa;
	}
	public void setKaiwa(String kaiwa) {
		this.kaiwa = kaiwa;
	}
}
