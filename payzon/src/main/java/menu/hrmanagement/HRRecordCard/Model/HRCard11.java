package menu.hrmanagement.HRRecordCard.Model;

import java.util.Date;

public class HRCard11 { // 인사발령 // 人事異動

	public HRCard11() {} // 발령 테이블 // 異動テーブル
	
	private Integer shain_ID; // 사원ID // 社員ID
	private String hatsurei_kubun; // 발령구분 X 없음 오라클 내에 정보 기입해야함 // 異動区分（なし、Oracleに情報を記入する必要があります）
	private Date hatsurei_bi; // 발령일자 // 異動日
	private String bu; // 부서 // 部署
	private String yakushoku_mei; // 직위 // 職位名
	private String shokumu_mei; // 직책 및 담당업무 // 職務名
	private String bikou; // 비고 // 備考
	
	// -- 16. 발령 테이블 (hatsurei) // 16. 異動テーブル（hatsurei）
	// CREATE TABLE hatsurei ( // テーブルの作成
	//     shain_ID NUMBER,               -- 사원ID (KF) // 社員ID（外部キー）
	// 	kubun 없음 // 区分（なし）
	//     hatsurei_bi DATE,              -- 발령일 // 異動日
	//     bu VARCHAR2(30),               -- 부서 // 部署
	//     yakushoku_mei VARCHAR2(100),   -- 직위 명칭 // 職位名
	//     shokumu_mei VARCHAR2(30),      -- 직무 명칭 // 職務名
	//     bikou CLOB,                    -- 비고 // 備考
	
	//	사원id // 社員ID
	//	발령구분 X 없음 오라클 내에 정보 기입해야함 // 異動区分（なし、Oracleに情報を記入する必要があります）
	//	발령일자 // 異動日
	//	부서 // 部署
	//	직위 // 職位
	//	직책 및 담당업무 // 職務
	//	비고 // 備考
	
	public Integer getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public String getHatsurei_kubun() {
		return hatsurei_kubun;
	}
	public void setHatsurei_kubun(String hatsurei_kubun) {
		this.hatsurei_kubun = hatsurei_kubun;
	}
	public Date getHatsurei_bi() {
		return hatsurei_bi;
	}
	public void setHatsurei_bi(Date hatsurei_bi) {
		this.hatsurei_bi = hatsurei_bi;
	}
	public String getBu() {
		return bu;
	}
	public void setBu(String bu) {
		this.bu = bu;
	}
	public String getYakushoku_mei() {
		return yakushoku_mei;
	}
	public void setYakushoku_mei(String yakushoku_mei) {
		this.yakushoku_mei = yakushoku_mei;
	}
	public String getShokumu_mei() {
		return shokumu_mei;
	}
	public void setShokumu_mei(String shokumu_mei) {
		this.shokumu_mei = shokumu_mei;
	}
	public String getBikou() {
		return bikou;
	}
	public void setBikou(String bikou) {
		this.bikou = bikou;
	}
}
