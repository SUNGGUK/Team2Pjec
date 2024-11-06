package menu.BasicSettings.UserInfo.Model;

import java.time.LocalDate;

// 급여 지급 정보 클래스
// 給与支給情報クラス
public class KyuuyoShikyuuZyouhou {
    private int shain_ID;                  // 사원 ID (社員ID)
    private LocalDate kyuuyo_seisan_kikan; // 급여 정산 기간 (給与精算期間)
    private LocalDate kyuuyo_shikyuu_bi;   // 급여 지급일 (給与支給日)
    private String kinyuu_kikan;           // 금융 기관 (金融機関)
    private String kouza_bangou;           // 계좌 번호 (口座番号)
    private String yokinshu;               // 예금주 (預金者)

    // 기본 생성자
    // デフォルトコンストラクタ
    public KyuuyoShikyuuZyouhou() {}

    // 매개변수를 받는 생성자
    // パラメータ付きのコンストラクタ
    public KyuuyoShikyuuZyouhou(int shain_ID, LocalDate kyuuyo_seisan_kikan, LocalDate kyuuyo_shikyuu_bi,
                                String kinyuu_kikan, String kouza_bangou, String yokinshu) {
        super();
        this.shain_ID = shain_ID;
        this.kyuuyo_seisan_kikan = kyuuyo_seisan_kikan;
        this.kyuuyo_shikyuu_bi = kyuuyo_shikyuu_bi;
        this.kinyuu_kikan = kinyuu_kikan;
        this.kouza_bangou = kouza_bangou;
        this.yokinshu = yokinshu;
    }

    // Getters and Setters
    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public LocalDate getKyuuyo_seisan_kikan() { return kyuuyo_seisan_kikan; }
    public void setKyuuyo_seisan_kikan(LocalDate kyuuyo_seisan_kikan) { this.kyuuyo_seisan_kikan = kyuuyo_seisan_kikan; }

    public LocalDate getKyuuyo_shikyuu_bi() { return kyuuyo_shikyuu_bi; }
    public void setKyuuyo_shikyuu_bi(LocalDate kyuuyo_shikyuu_bi) { this.kyuuyo_shikyuu_bi = kyuuyo_shikyuu_bi; }

    public String getKinyuu_kikan() { return kinyuu_kikan; }
    public void setKinyuu_kikan(String kinyuu_kikan) { this.kinyuu_kikan = kinyuu_kikan; }

    public String getKouza_bangou() { return kouza_bangou; }
    public void setKouza_bangou(String kouza_bangou) { this.kouza_bangou = kouza_bangou; }

    public String getYokinshu() { return yokinshu; }
    public void setYokinshu(String yokinshu) { this.yokinshu = yokinshu; }
}
