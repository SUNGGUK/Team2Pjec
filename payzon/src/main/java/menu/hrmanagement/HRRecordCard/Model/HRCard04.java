package menu.hrmanagement.HRRecordCard.Model;

import java.util.Date;

public class HRCard04 {

    public HRCard04() {} // 8. 4대 보험 정보 테이블 (shidai_hoken_zyouhou) // 8. 4大保険情報テーブル (shidai_hoken_zyouhou)

    private Integer hoken_ID; // 보험id // 保険ID
    private Integer shain_ID; // 사원id // 社員ID
    private String hoken_shurui; // 보험 종류 // 保険種類
    private String touroku_bangou; // 등록 번호 // 登録番号
    private Date shutoku_bi; // 취득일 // 取得日
    private Date sousitsu_bi; // 상실일 // 喪失日

    //	국민연금 // 国民年金
    //	건강보험 // 健康保険
    //	고용보험 // 雇用保険
    //	산업재해보험 // 労災保険
    //	기호번호(등록번호) // 記号番号（登録番号）
    //	취득일 // 取得日
    //	상실일 // 喪失日

    //	4대 보험 정보 테이블 (shidai_hoken_zyouhou) // 4大保険情報テーブル (shidai_hoken_zyouhou)
    //    hoken_ID NUMBER PRIMARY KEY,   -- 보험ID (PK) // 保険ID (PK)
    //    shain_ID NUMBER,               -- 사원ID (FK) // 社員ID (FK)
    //    hoken_shurui VARCHAR2(30),     -- 보험 종류 // 保険種類
    //    touroku_bangou VARCHAR2(50),   -- 등록 번호 // 登録番号
    //    shutoku_bi DATE,               -- 취득일 // 取得日
    //    sousitsu_bi DATE,              -- 상실일 // 喪失日
	public Integer getHoken_ID() {
		return hoken_ID;
	}
	public void setHoken_ID(Integer hoken_ID) {
		this.hoken_ID = hoken_ID;
	}
	public Integer getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public String getHoken_shurui() {
		return hoken_shurui;
	}
	public void setHoken_shurui(String hoken_shurui) {
		this.hoken_shurui = hoken_shurui;
	}
	public String getTouroku_bangou() {
		return touroku_bangou;
	}
	public void setTouroku_bangou(String touroku_bangou) {
		this.touroku_bangou = touroku_bangou;
	}
	public Date getShutoku_bi() {
		return shutoku_bi;
	}
	public void setShutoku_bi(Date shutoku_bi) {
		this.shutoku_bi = shutoku_bi;
	}
	public Date getSousitsu_bi() {
		return sousitsu_bi;
	}
	public void setSousitsu_bi(Date sousitsu_bi) {
		this.sousitsu_bi = sousitsu_bi;
	}
}
