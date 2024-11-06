package menu.BasicSettings.UserInfo.Model;

// 담당자 정보 클래스
// 担当者情報クラス
public class Tantousha_Zyouhou {
    private String namae;            // 이름 (名前)
    private String bu;               // 부서 (部署)
    private String yakushoku;        // 직책 (職位)
    private String denwa_bangou;     // 전화번호 (電話番号)
    private String keitai_bangou;    // 휴대전화번호 (携帯電話番号)
    private String meiru_adoresu;    // 이메일 주소 (メールアドレス)

    // 기본 생성자
    // デフォルトコンストラクタ
    public Tantousha_Zyouhou() {}

    // 매개변수를 받는 생성자
    // パラメータ付きのコンストラクタ
    public Tantousha_Zyouhou(String namae, String bu, String yakushoku, String denwa_bangou, String keitai_bangou,
                             String meiru_adoresu) {
        super();
        this.namae = namae;
        this.bu = bu;
        this.yakushoku = yakushoku;
        this.denwa_bangou = denwa_bangou;
        this.keitai_bangou = keitai_bangou;
        this.meiru_adoresu = meiru_adoresu;
    }

    // Getters and Setters
    public String getNamae() { return namae; }
    public void setNamae(String namae) { this.namae = namae; }

    public String getBu() { return bu; }
    public void setBu(String bu) { this.bu = bu; }

    public String getYakushoku() { return yakushoku; }
    public void setYakushoku(String yakushoku) { this.yakushoku = yakushoku; }

    public String getDenwa_bangou() { return denwa_bangou; }
    public void setDenwa_bangou(String denwa_bangou) { this.denwa_bangou = denwa_bangou; }

    public String getKeitai_bangou() { return keitai_bangou; }
    public void setKeitai_bangou(String keitai_bangou) { this.keitai_bangou = keitai_bangou; }

    public String getMeiru_adoresu() { return meiru_adoresu; }
    public void setMeiru_adoresu(String meiru_adoresu) { this.meiru_adoresu = meiru_adoresu; }
}
