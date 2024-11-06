package menu.payroll.PayrollLedger.Model;

import java.util.Date;

public class ShainKyuuyo {
    private int kyuuyoId;               // 급여 ID (給与ID)
    private int shainId;                // 사원 ID (외래 키) (社員ID (外部キー))
    private int koujoSougaku;           // 공제 총액 (控除総額)
    private Date shikyuuBi;             // 지급일 (支給日)
    private Date seisanKaishiBi;        // 정산 기간 시작일 (精算期間開始日)
    private Date seisanShuryoBi;        // 정산 기간 종료일 (精算期間終了日)
    private int shikyuuzoukyuu;         // 지급 총액 (支給総額)

    // 기본 생성자 (デフォルトコンストラクタ)
    public ShainKyuuyo() {
    }

    // 모든 필드를 초기화하는 생성자 (全てのフィールドを初期化するコンストラクタ)
    public ShainKyuuyo(int kyuuyoId, int shainId, int koujoSougaku, Date shikyuuBi, Date seisanKaishiBi, Date seisanShuryoBi, int shikyuuzoukyuu) {
        this.kyuuyoId = kyuuyoId;
        this.shainId = shainId;
        this.koujoSougaku = koujoSougaku;
        this.shikyuuBi = shikyuuBi;
        this.seisanKaishiBi = seisanKaishiBi;
        this.seisanShuryoBi = seisanShuryoBi;
        this.shikyuuzoukyuu = shikyuuzoukyuu;
    }

    // Getter 및 Setter 메서드 (ゲッターおよびセッター)
    public int getKyuuyoId() {
        return kyuuyoId; // 급여 ID 반환 (給与IDを返す)
    }

    public void setKyuuyoId(int kyuuyoId) {
        this.kyuuyoId = kyuuyoId; // 급여 ID 설정 (給与IDを設定する)
    }

    public int getShainId() {
        return shainId; // 사원 ID 반환 (社員IDを返す)
    }

    public void setShainId(int shainId) {
        this.shainId = shainId; // 사원 ID 설정 (社員IDを設定する)
    }

    public int getKoujoSougaku() {
        return koujoSougaku; // 공제 총액 반환 (控除総額を返す)
    }

    public void setKoujoSougaku(int koujoSougaku) {
        this.koujoSougaku = koujoSougaku; // 공제 총액 설정 (控除総額を設定する)
    }

    public Date getShikyuuBi() {
        return shikyuuBi; // 지급일 반환 (支給日を返す)
    }

    public void setShikyuuBi(Date shikyuuBi) {
        this.shikyuuBi = shikyuuBi; // 지급일 설정 (支給日を設定する)
    }

    public Date getSeisanKaishiBi() {
        return seisanKaishiBi; // 정산 기간 시작일 반환 (精算期間開始日を返す)
    }

    public void setSeisanKaishiBi(Date seisanKaishiBi) {
        this.seisanKaishiBi = seisanKaishiBi; // 정산 기간 시작일 설정 (精算期間開始日を設定する)
    }

    public Date getSeisanShuryoBi() {
        return seisanShuryoBi; // 정산 기간 종료일 반환 (精算期間終了日を返す)
    }

    public void setSeisanShuryoBi(Date seisanShuryoBi) {
        this.seisanShuryoBi = seisanShuryoBi; // 정산 기간 종료일 설정 (精算期間終了日を設定する)
    }

    public int getShikyuuzoukyuu() {
        return shikyuuzoukyuu; // 지급 총액 반환 (支給総額を返す)
    }

    public void setShikyuuzoukyuu(int shikyuuzoukyuu) {
        this.shikyuuzoukyuu = shikyuuzoukyuu; // 지급 총액 설정 (支給総額を設定する)
    }

    @Override
    public String toString() {
        return "ShainKyuuyo{" +
                "kyuuyoId=" + kyuuyoId +
                ", shainId=" + shainId +
                ", koujoSougaku=" + koujoSougaku +
                ", shikyuuBi=" + shikyuuBi +
                ", seisanKaishiBi=" + seisanKaishiBi +
                ", seisanShuryoBi=" + seisanShuryoBi +
                ", shikyuuzoukyuu=" + shikyuuzoukyuu +
                '}'; // 문자열 표현 반환 (文字列表現を返す)
    }
}
