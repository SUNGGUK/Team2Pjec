package menu.BasicSettings.UserInfo.Model;

import java.sql.Date;

// 회사 정보 클래스
// 会社情報クラス
public class KaishaZyouhou {
    private String kaisha_mei;        // 회사명 (会社名)
    private String shachou_yakushoku; // CEO 직책 (CEOの職位)
    private String shachou_mei;       // CEO 이름 (CEOの名前)
    private long zigyou_bangou;       // 사업자번호 (事業者番号)
    private long houzin_bangou;       // 법인번호 (法人番号)
    private Date setsuritsu_bi;       // 설립일 (設立日)
    private String ulebusaito;        // 웹사이트 (ウェブサイト)
    private String yubinbango;        // 우편번호 (郵便番号)
    private String zigyouzyou_zyuusho; // 사업장 주소 (事業所住所)
    private long denwa_bangou;        // 전화번호 (電話番号)
    private String fakus__bangou;     // 팩스번호 (FAX番号)
    private String zigyou_shurui;     // 사업 종류 (事業種類)
    private String zigyou_naiyou;     // 사업 내용 (事業内容)

    // 기본 생성자
    // デフォルトコンストラクタ
    public KaishaZyouhou() {}

    // 매개변수를 받는 생성자
    // パラメータ付きのコンストラクタ
    public KaishaZyouhou(String kaisha_mei, String shachou_yakushoku, String shachou_mei, long zigyou_bangou,
                         long houzin_bangou, Date setsuritsu_bi, String ulebusaito, String yubinbango,
                         String zigyouzyou_zyuusho, long denwa_bangou, String fakus__bangou, 
                         String zigyou_shurui, String zigyou_naiyou) {
        super();
        this.kaisha_mei = kaisha_mei;
        this.shachou_yakushoku = shachou_yakushoku;
        this.shachou_mei = shachou_mei;
        this.zigyou_bangou = zigyou_bangou;
        this.houzin_bangou = houzin_bangou;
        this.setsuritsu_bi = setsuritsu_bi;
        this.ulebusaito = ulebusaito;
        this.yubinbango = yubinbango;
        this.zigyouzyou_zyuusho = zigyouzyou_zyuusho;
        this.denwa_bangou = denwa_bangou;
        this.fakus__bangou = fakus__bangou;
        this.zigyou_shurui = zigyou_shurui;
        this.zigyou_naiyou = zigyou_naiyou;
    }

    // Getters and Setters
    public String getKaisha_mei() { return kaisha_mei; }
    public void setKaisha_mei(String kaisha_mei) { this.kaisha_mei = kaisha_mei; }

    public String getShachou_yakushoku() { return shachou_yakushoku; }
    public void setShachou_yakushoku(String shachou_yakushoku) { this.shachou_yakushoku = shachou_yakushoku; }

    public String getShachou_mei() { return shachou_mei; }
    public void setShachou_mei(String shachou_mei) { this.shachou_mei = shachou_mei; }

    public long getZigyou_bangou() { return zigyou_bangou; }
    public void setZigyou_bangou(long zigyou_bangou) { this.zigyou_bangou = zigyou_bangou; }

    public long getHouzin_bangou() { return houzin_bangou; }
    public void setHouzin_bangou(long houzin_bangou) { this.houzin_bangou = houzin_bangou; }

    public Date getSetsuritsu_bi() { return setsuritsu_bi; }
    public void setSetsuritsu_bi(Date setsuritsu_bi) { this.setsuritsu_bi = setsuritsu_bi; }

    public String getUlebusaito() { return ulebusaito; }
    public void setUlebusaito(String ulebusaito) { this.ulebusaito = ulebusaito; }

    public String getYubinbango() { return yubinbango; }
    public void setYubinbango(String yubinbango) { this.yubinbango = yubinbango; }

    public String getZigyouzyou_zyuusho() { return zigyouzyou_zyuusho; }
    public void setZigyouzyou_zyuusho(String zigyouzyou_zyuusho) { this.zigyouzyou_zyuusho = zigyouzyou_zyuusho; }

    public long getDenwa_bangou() { return denwa_bangou; }
    public void setDenwa_bangou(long denwa_bangou) { this.denwa_bangou = denwa_bangou; }

    public String getFakus__bangou() { return fakus__bangou; }
    public void setFakus__bangou(String fakus__bangou) { this.fakus__bangou = fakus__bangou; }

    public String getZigyou_shurui() { return zigyou_shurui; }
    public void setZigyou_shurui(String zigyou_shurui) { this.zigyou_shurui = zigyou_shurui; }

    public String getZigyou_naiyou() { return zigyou_naiyou; }
    public void setZigyou_naiyou(String zigyou_naiyou) { this.zigyou_naiyou = zigyou_naiyou; }
}
