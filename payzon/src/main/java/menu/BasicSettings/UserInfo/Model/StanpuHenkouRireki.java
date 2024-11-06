package menu.BasicSettings.UserInfo.Model;

import java.util.Date;

//-- 38. 도장/로고변경이력테이블 (stanpu_henkou_rireki)
//-- 38. 印鑑/ロゴ変更履歴テーブル (stanpu_henkou_rireki)
public class StanpuHenkouRireki {
    private int rirekiId;           // 이력 ID (履歴ID)
    private String stanpuShubetsu;  // 스탬프 종류 (スタンプ種別)
    private Date shinseiBi;         // 신청일 (申請日)
    private String shinkouZyoutai;  // 진행 상태 (進行状態)
    private String henkouNaiyou;    // 변경 내용 (変更内容)
    private String fairuKeiro;      // 파일 경로 (ファイル経路)

    // 생성자
    // コンストラクタ
    public StanpuHenkouRireki(int rirekiId, String stanpuShubetsu, Date shinseiBi, String shinkouZyoutai, String henkouNaiyou, String fairuKeiro) {
        this.rirekiId = rirekiId;
        this.stanpuShubetsu = stanpuShubetsu;
        this.shinseiBi = shinseiBi;
        this.shinkouZyoutai = shinkouZyoutai;
        this.henkouNaiyou = henkouNaiyou;
        this.fairuKeiro = fairuKeiro;
    }

    // Getters and Setters
    public int getRirekiId() { return rirekiId; }
    public void setRirekiId(int rirekiId) { this.rirekiId = rirekiId; }

    public String getStanpuShubetsu() { return stanpuShubetsu; }
    public void setStanpuShubetsu(String stanpuShubetsu) { this.stanpuShubetsu = stanpuShubetsu; }

    public Date getShinseiBi() { return shinseiBi; }
    public void setShinseiBi(Date shinseiBi) { this.shinseiBi = shinseiBi; }

    public String getShinkouZyoutai() { return shinkouZyoutai; }
    public void setShinkouZyoutai(String shinkouZyoutai) { this.shinkouZyoutai = shinkouZyoutai; }

    public String getHenkouNaiyou() { return henkouNaiyou; }
    public void setHenkouNaiyou(String henkouNaiyou) { this.henkouNaiyou = henkouNaiyou; }

    public String getFairuKeiro() { return fairuKeiro; }
    public void setFairuKeiro(String fairuKeiro) { this.fairuKeiro = fairuKeiro; }
}
