package menu.payroll.PayrollLedger.Model;

import java.math.BigDecimal;
import java.util.Date;

public class TotalKingaku {
    private int kingakuId;           // 총액 ID (総額ID)
    private Integer shainId;         // 사원 ID (외래 키) (社員ID 外部キー)
    private int gatsu;               // 월 (月)
    private int nendo;               // 연도 (年度)
    private BigDecimal totalShiharai; // 지급 총액 (支給総額)
    private BigDecimal totalKouzyo;   // 공제 총액 (控除総額)
    private Date seisanKaishiBi;     // 정산 시작일 (精算開始日)
    private Date seisanShuryoBi;     // 정산 종료일 (精算終了日)
    private Date shikyuuBi;          // 지급일 (支給日)

    // 기본 생성자 (デフォルトコンストラクタ)
    public TotalKingaku() {
    }

    // 모든 필드를 초기화하는 생성자 (全てのフィールドを初期化するコンストラクタ)
    public TotalKingaku(int kingakuId, Integer shainId, int gatsu, int nendo, BigDecimal totalShiharai, BigDecimal totalKouzyo, Date seisanKaishiBi, Date seisanShuryoBi, Date shikyuuBi) {
        this.kingakuId = kingakuId;
        this.shainId = shainId;
        this.gatsu = gatsu;
        this.nendo = nendo;
        this.totalShiharai = totalShiharai;
        this.totalKouzyo = totalKouzyo;
        this.seisanKaishiBi = seisanKaishiBi;
        this.seisanShuryoBi = seisanShuryoBi;
        this.shikyuuBi = shikyuuBi;
    }

    // Getter 및 Setter 메서드 (ゲッターおよびセッター)
    public int getKingakuId() {
        return kingakuId; // 총액 ID 반환 (総額IDを返す)
    }

    public void setKingakuId(int kingakuId) {
        this.kingakuId = kingakuId; // 총액 ID 설정 (総額IDを設定する)
    }

    public Integer getShainId() {
        return shainId; // 사원 ID 반환 (社員IDを返す)
    }

    public void setShainId(Integer shainId) {
        this.shainId = shainId; // 사원 ID 설정 (社員IDを設定する)
    }

    public int getGatsu() {
        return gatsu; // 월 반환 (月を返す)
    }

    public void setGatsu(int gatsu) {
        this.gatsu = gatsu; // 월 설정 (月を設定する)
    }

    public int getNendo() {
        return nendo; // 연도 반환 (年度を返す)
    }

    public void setNendo(int nendo) {
        this.nendo = nendo; // 연도 설정 (年度を設定する)
    }

    public BigDecimal getTotalShiharai() {
        return totalShiharai; // 지급 총액 반환 (支給総額を返す)
    }

    public void setTotalShiharai(BigDecimal totalShiharai) {
        this.totalShiharai = totalShiharai; // 지급 총액 설정 (支給総額を設定する)
    }

    public BigDecimal getTotalKouzyo() {
        return totalKouzyo; // 공제 총액 반환 (控除総額を返す)
    }

    public void setTotalKouzyo(BigDecimal totalKouzyo) {
        this.totalKouzyo = totalKouzyo; // 공제 총액 설정 (控除総額を設定する)
    }

    public Date getSeisanKaishiBi() {
        return seisanKaishiBi; // 정산 시작일 반환 (精算開始日を返す)
    }

    public void setSeisanKaishiBi(Date seisanKaishiBi) {
        this.seisanKaishiBi = seisanKaishiBi; // 정산 시작일 설정 (精算開始日を設定する)
    }

    public Date getSeisanShuryoBi() {
        return seisanShuryoBi; // 정산 종료일 반환 (精算終了日を返す)
    }

    public void setSeisanShuryoBi(Date seisanShuryoBi) {
        this.seisanShuryoBi = seisanShuryoBi; // 정산 종료일 설정 (精算終了日を設定する)
    }

    public Date getShikyuuBi() {
        return shikyuuBi; // 지급일 반환 (支給日を返す)
    }

    public void setShikyuuBi(Date shikyuuBi) {
        this.shikyuuBi = shikyuuBi; // 지급일 설정 (支給日を設定する)
    }

    @Override
    public String toString() {
        return "TotalKingaku{" +
                "kingakuId=" + kingakuId + // 총액 ID (総額ID)
                ", shainId=" + shainId + // 사원 ID (社員ID)
                ", gatsu=" + gatsu + // 월 (月)
                ", nendo=" + nendo + // 연도 (年度)
                ", totalShiharai=" + totalShiharai + // 지급 총액 (支給総額)
                ", totalKouzyo=" + totalKouzyo + // 공제 총액 (控除総額)
                ", seisanKaishiBi=" + seisanKaishiBi + // 정산 시작일 (精算開始日)
                ", seisanShuryoBi=" + seisanShuryoBi + // 정산 종료일 (精算終了日)
                ", shikyuuBi=" + shikyuuBi + // 지급일 (支給日)
                '}'; 
    }
}
