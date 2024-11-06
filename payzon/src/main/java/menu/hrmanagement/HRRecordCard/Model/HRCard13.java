package menu.hrmanagement.HRRecordCard.Model;

import java.util.Date;

public class HRCard13 { // 도장 // 印章
	
	public HRCard13() {} // 도장/로고변경이력테이블 // 印章/ロゴ変更履歴テーブル
	
	private Integer rireki_id; // 이력 ID // 履歴ID
	private String stanpu_shubetsu; // 도장 종류 // 印章の種類
	private Date shinsei_bi; // 신청일 // 申請日
	private String shinkou_zyoutai; // 진행 상태 // 進行状態
	private String henkou_naiyou; // 변경 내용 // 変更内容
	private String fairu_keiro; // 파일 경로 // ファイルパス
	
	//	이력id // 履歴ID
	//	도장 // 印章
	
	//	    rireki_id NUMBER PRIMARY KEY,        -- 履歴ID
	//	    stanpu_shubetsu VARCHAR2(20),        -- 印章の種類（ロゴ、印章など）
	//	    shinsei_bi DATE,                     -- 申請日
	//	    shinkou_zyoutai VARCHAR2(20),        -- 進行状態（完了、使用中など）
	//	    henkou_naiyou CLOB,                  -- 変更内容（変更事項の説明）
	//	    fairu_keiro VARCHAR2(200),           -- ファイルパス
	
	//	이력id // 履歴ID
	//	도장 // 印章
	
	public Integer getRireki_id() {
		return rireki_id;
	}
	public void setRireki_id(Integer rireki_id) {
		this.rireki_id = rireki_id;
	}
	public String getStanpu_shubetsu() {
		return stanpu_shubetsu;
	}
	public void setStanpu_shubetsu(String stanpu_shubetsu) {
		this.stanpu_shubetsu = stanpu_shubetsu;
	}
	public Date getShinsei_bi() {
		return shinsei_bi;
	}
	public void setShinsei_bi(Date shinsei_bi) {
		this.shinsei_bi = shinsei_bi;
	}
	public String getShinkou_zyoutai() {
		return shinkou_zyoutai;
	}
	public void setShinkou_zyoutai(String shinkou_zyoutai) {
		this.shinkou_zyoutai = shinkou_zyoutai;
	}
	public String getHenkou_naiyou() {
		return henkou_naiyou;
	}
	public void setHenkou_naiyou(String henkou_naiyou) {
		this.henkou_naiyou = henkou_naiyou;
	}
	public String getFairu_keiro() {
		return fairu_keiro;
	}
	public void setFairu_keiro(String fairu_keiro) {
		this.fairu_keiro = fairu_keiro;
	}
}