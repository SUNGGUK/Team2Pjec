package menu.hrmanagement.HRRecordCard.Model;

public class HRCard03 {
	
	public HRCard03() {} // 9. 부양 가족 테이블 (huyou_kazoku) // 9. 扶養家族テーブル (huyou_kazoku)

	private Integer shain_ID; // 사원id // 社員ID
	private String namae; // 성명(일어) // 名前（日本語）
	private String kankei; // 관계 // 関係
	private String zyuumin_touroku_bangou; // 주민등록번호 // 住民登録番号
	private Boolean shougai_umu; // 동거여부 // 障害有無
	private Boolean zei_kouzyo_umu; // 세액공제 여부 // 税額控除有無
	private Boolean kenkou_hoken_umu; // 건강보험 여부 // 健康保険有無
	private Boolean doukyo_umu; // 동거 여부 // 同居有無
	private Boolean nen20_ika_ko_umu; // 20세 이하 자녀 여부 // 20歳以下子有無

//		사원id // 社員ID
//		관계 // 関係
//		성명(일어) // 名前（日本語）
//		주민등록번호 // 住民登録番号
//		동거여부 // 同居有無

	
	public Integer getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public String getNamae() {
		return namae;
	}
	public void setNamae(String namae) {
		this.namae = namae;
	}
	public String getKankei() {
		return kankei;
	}
	public void setKankei(String kankei) {
		this.kankei = kankei;
	}
	public String getZyuumin_touroku_bangou() {
		return zyuumin_touroku_bangou;
	}
	public void setZyuumin_touroku_bangou(String zyuumin_touroku_bangou) {
		this.zyuumin_touroku_bangou = zyuumin_touroku_bangou;
	}
	public Boolean getShougai_umu() {
		return shougai_umu;
	}
	public void setShougai_umu(Boolean shougai_umu) {
		this.shougai_umu = shougai_umu;
	}
	public Boolean getZei_kouzyo_umu() {
		return zei_kouzyo_umu;
	}
	public void setZei_kouzyo_umu(Boolean zei_kouzyo_umu) {
		this.zei_kouzyo_umu = zei_kouzyo_umu;
	}
	public Boolean getKenkou_hoken_umu() {
		return kenkou_hoken_umu;
	}
	public void setKenkou_hoken_umu(Boolean kenkou_hoken_umu) {
		this.kenkou_hoken_umu = kenkou_hoken_umu;
	}
	public Boolean getDoukyo_umu() {
		return doukyo_umu;
	}
	public void setDoukyo_umu(Boolean doukyo_umu) {
		this.doukyo_umu = doukyo_umu;
	}
	public Boolean getNen20_ika_ko_umu() {
		return nen20_ika_ko_umu;
	}
	public void setNen20_ika_ko_umu(Boolean nen20_ika_ko_umu) {
		this.nen20_ika_ko_umu = nen20_ika_ko_umu;
	}		
}
