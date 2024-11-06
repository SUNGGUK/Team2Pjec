package menu.BasicSettings.UserInfo.Model;

import java.sql.Date;

public class UserInfo {
    private KaishaZyouhou kaishaZyouhou;
    private KyuuyoShikyuuZyouhou kyuuyoShikyuuZyouhou;
    private Tantousha_Zyouhou tantoushaZyouhou;

    // 기본 생성자
    // デフォルトコンストラクタ
    public UserInfo() {
        this.kaishaZyouhou = new KaishaZyouhou();
        this.kyuuyoShikyuuZyouhou = new KyuuyoShikyuuZyouhou();
        this.tantoushaZyouhou = new Tantousha_Zyouhou();
    }

    // Getters and Setters
    public KaishaZyouhou getKaishaZyouhou() { return kaishaZyouhou; }
    public void setKaishaZyouhou(KaishaZyouhou kaishaZyouhou) { this.kaishaZyouhou = kaishaZyouhou; }

    public KyuuyoShikyuuZyouhou getKyuuyoShikyuuZyouhou() { return kyuuyoShikyuuZyouhou; }
    public void setKyuuyoShikyuuZyouhou(KyuuyoShikyuuZyouhou kyuuyoShikyuuZyouhou) { this.kyuuyoShikyuuZyouhou = kyuuyoShikyuuZyouhou; }

    public Tantousha_Zyouhou getTantoushaZyouhou() { return tantoushaZyouhou; }
    public void setTantoushaZyouhou(Tantousha_Zyouhou tantoushaZyouhou) { this.tantoushaZyouhou = tantoushaZyouhou; }

    // 회사 정보 클래스
    // 会社情報クラス
    public static class KaishaZyouhou {
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
        public void setFakus__bangou(String fakus_bangou) { this.fakus__bangou = fakus_bangou; }

        public String getZigyou_shurui() { return zigyou_shurui; }
        public void setZigyou_shurui(String zigyou_shurui) { this.zigyou_shurui = zigyou_shurui; }

        public String getZigyou_naiyou() { return zigyou_naiyou; }
        public void setZigyou_naiyou(String zigyou_naiyou) { this.zigyou_naiyou = zigyou_naiyou; }
    }

    // 급여 지급 정보 클래스
    // 給与支給情報クラス
    public static class KyuuyoShikyuuZyouhou {
        private int shain_ID;             // 사원 ID (社員ID)
        private Date kyuuyo_seisan_kikan; // 급여 정산 기간 (給与精算期間)
        private Date kyuuyo_shikyuu_bi;   // 급여 지급일 (給与支給日)
        private String kinyuu_kikan;      // 금융 기관 (金融機関)
        private String kouza_bangou;      // 계좌 번호 (口座番号)
        private String yokinshu;          // 예금주 (預金者)

        // 기본 생성자
        // デフォルトコンストラクタ
        public KyuuyoShikyuuZyouhou() {}

        // Getters and Setters
        public int getShain_ID() { return shain_ID; }
        public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

        public Date getKyuuyo_seisan_kikan() { return kyuuyo_seisan_kikan; }
        public void setKyuuyo_seisan_kikan(Date kyuuyo_seisan_kikan) { this.kyuuyo_seisan_kikan = kyuuyo_seisan_kikan; }

        public Date getKyuuyo_shikyuu_bi() { return kyuuyo_shikyuu_bi; }
        public void setKyuuyo_shikyuu_bi(Date kyuuyo_shikyuu_bi) { this.kyuuyo_shikyuu_bi = kyuuyo_shikyuu_bi; }

        public String getKinyuu_kikan() { return kinyuu_kikan; }
        public void setKinyuu_kikan(String kinyuu_kikan) { this.kinyuu_kikan = kinyuu_kikan; }

        public String getKouza_bangou() { return kouza_bangou; }
        public void setKouza_bangou(String kouza_bangou) { this.kouza_bangou = kouza_bangou; }

        public String getYokinshu() { return yokinshu; }
        public void setYokinshu(String yokinshu) { this.yokinshu = yokinshu; }
    }

    // 담당자 정보 클래스
    // 担当者情報クラス
    public static class Tantousha_Zyouhou {
        private String namae;            // 이름 (名前)
        private String bu;               // 부서 (部署)
        private String yakushoku;        // 직책 (職位)
        private String denwa_bangou;     // 전화번호 (電話番号)
        private String keitai_bangou;    // 휴대전화번호 (携帯電話番号)
        private String meiru_adoresu;    // 이메일 주소 (メールアドレス)

        // 기본 생성자
        // デフォルトコンストラクタ
        public Tantousha_Zyouhou() {}

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
}
