package menu.hrmanagement.HRRecordCard.Model;

import java.util.Date;

public class HRCard06 {
	

    public HRCard06() {} // 병역 정보 테이블 // 兵役情報テーブル

    private Integer shain_ID; // 사원id // 社員ID
    private String heieki_kubun; // 제대 구분 // 退役区分
    private String gun_betsu; // 군별 // 軍別
    private Date hukumu_kaishi_bi; // 복무기간(부터) // 募集期間（開始日）
    private Date hukumu_shuuryou_bi; // 복무기간(까지) // 募集期間（終了日）
    private String saishuu_kaikyuu; // 최종계급 // 最終階級
    private String heika; // 병과 // 兵科
    private String miryou_ziyuu; // 미필 사유 // 未入隊理由

    //	사원id // 社員ID
    //	제대 구분 // 退役区分
    //	미필 사유 // 未入隊理由
    //	군별 // 軍別
    //	최종계급 // 最終階級
    //	병과 // 兵科
    //	복무기간(부터)~복무기간(까지) // 募集期間（開始日）〜募集期間（終了日）
	
	public Integer getShain_ID() {
		return shain_ID;
	}
	public void setShain_ID(Integer shain_ID) {
		this.shain_ID = shain_ID;
	}
	public String getHeieki_kubun() {
		return heieki_kubun;
	}
	public void setHeieki_kubun(String heieki_kubun) {
		this.heieki_kubun = heieki_kubun;
	}
	public String getGun_betsu() {
		return gun_betsu;
	}
	public void setGun_betsu(String gun_betsu) {
		this.gun_betsu = gun_betsu;
	}
	public Date getHukumu_kaishi_bi() {
		return hukumu_kaishi_bi;
	}
	public void setHukumu_kaishi_bi(Date hukumu_kaishi_bi) {
		this.hukumu_kaishi_bi = hukumu_kaishi_bi;
	}
	public Date getHukumu_shuuryou_bi() {
		return hukumu_shuuryou_bi;
	}
	public void setHukumu_shuuryou_bi(Date hukumu_shuuryou_bi) {
		this.hukumu_shuuryou_bi = hukumu_shuuryou_bi;
	}
	public String getSaishuu_kaikyuu() {
		return saishuu_kaikyuu;
	}
	public void setSaishuu_kaikyuu(String saishuu_kaikyuu) {
		this.saishuu_kaikyuu = saishuu_kaikyuu;
	}
	public String getHeika() {
		return heika;
	}
	public void setHeika(String heika) {
		this.heika = heika;
	}
	public String getMiryou_ziyuu() {
		return miryou_ziyuu;
	}
	public void setMiryou_ziyuu(String miryou_ziyuu) {
		this.miryou_ziyuu = miryou_ziyuu;
	}
}
