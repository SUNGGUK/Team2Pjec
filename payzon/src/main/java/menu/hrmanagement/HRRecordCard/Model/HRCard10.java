package menu.hrmanagement.HRRecordCard.Model;

import java.util.Date;

public class HRCard10 { // 상벌 사항 // 賞罰事項
	
	public HRCard10() {} // 상벌 테이블 // 賞罰テーブル
	
	private Integer shain_ID; // 사원ID // 社員ID
	private String shoubatsu_kubun; // 구분 없음 이거를 이제 오라클에 추가해야함 // 区分（未追加、Oracleに追加する必要があります）
	private String shoubatsu_mei; // 상벌명 // 賞罰名
	private String kantoku_kikan; // 상벌권자 // 監督機関
	private Date shoubatsu_bi; // 상벌일자 // 賞罰日
	private String naiyou; // 상벌내용 // 内容
	private String bikou; // 비고 // 備考
	
	//    shain_ID NUMBER,               -- 사원ID (FK) // 社員ID（外部キー）
	//	  kubun 없음 이거를 이제 오라클에 추가해야함 // 区分（未追加、Oracleに追加する必要があります）
	//    shoubatsu_mei VARCHAR2(30),    -- 상벌 명칭 // 賞罰名
	//    kantoku_kikan VARCHAR2(30),    -- 감독 기관 // 監督機関
	//    shoubatsu_bi DATE,             -- 상벌 날짜 // 賞罰日
	//    naiyou CLOB,                   -- 내용 // 内容
	//    bikou CLOB,                    -- 비고 // 備考
	
	//	사원id // 社員ID
	//	구분 없음 이거를 오라클에 추가해야함 // 区分（未追加、Oracleに追加する必要があります）
	//	상벌명 // 賞罰名
	//	상벌권자 // 監督機関
	//	상벌일자 // 賞罰日
	//	상벌내용 // 内容
	//	비고 // 備考
	
	public Integer getShain_ID() {
		return shain_ID;
	}
	public String getShoubatsu_kubun() {
		return shoubatsu_kubun;
	}
	public void setShoubatsu_kubun(String shoubatsu_kubun) {
		this.shoubatsu_kubun = shoubatsu_kubun;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public String getShoubatsu_mei() {
		return shoubatsu_mei;
	}
	public void setShoubatsu_mei(String shoubatsu_mei) {
		this.shoubatsu_mei = shoubatsu_mei;
	}
	public String getKantoku_kikan() {
		return kantoku_kikan;
	}
	public void setKantoku_kikan(String kantoku_kikan) {
		this.kantoku_kikan = kantoku_kikan;
	}
	public Date getShoubatsu_bi() {
		return shoubatsu_bi;
	}
	public void setShoubatsu_bi(Date shoubatsu_bi) {
		this.shoubatsu_bi = shoubatsu_bi;
	}
	public String getNaiyou() {
		return naiyou;
	}
	public void setNaiyou(String naiyou) {
		this.naiyou = naiyou;
	}
	public String getBikou() {
		return bikou;
	}
	public void setBikou(String bikou) {
		this.bikou = bikou;
	}
}
