package menu.BasicSettings.EmployeeRegistration.model;

import java.sql.Date;

//-- 6. 사원 등록 테이블 (shain_touroku)
//-- 6. 社員登録テーブル (shain_touroku)
public class shain_touroku {

    int shain_ID; // 사원 ID / 社員ID
    String koyou_keitai; // 고용 형태 / 雇用形態
    String shain_namae; // 사원 이름 / 社員名
    String shain_eigo_namae; // 사원 영어 이름 / 社員英語名
    Date nyuusha_bi; // 입사일 / 入社日
    Date taisha_bi; // 퇴사일 / 退社日
    String bu; // 부서 / 部署
    String yakushoku; // 직위 / 役職
    String nai_gaikokuzin; // 내국인/외국인 구분 / 内国人・外国人区分
    String zyuumin_bangou; // 주민번호 / 住民番号
    String zyuusho; // 주소 / 住所
    String denwa_bangou; // 전화번호 / 電話番号
    String keitai_bangou; // 휴대전화번호 / 携帯電話番号
    String meiru_adoresu; // 이메일 주소 / メールアドレス
    String sns; // SNS 정보 / SNS情報
    String bikou; // 비고 / 備考

    // 기본 생성자 / デフォルトコンストラクタ
    public shain_touroku() {}

    // 매개변수를 받는 생성자 / パラメータ付きコンストラクタ
    public shain_touroku(int shain_ID, String koyou_keitai, String shain_namae, String shain_eigo_namae, Date nyuusha_bi, Date taisha_bi,
                         String bu, String yakushoku, String nai_gaikokuzin, String zyuumin_bangou, String zyuusho,
                         String denwa_bangou, String keitai_bangou, String meiru_adoresu, String sns, String bikou) {
        this.shain_ID = shain_ID;
        this.koyou_keitai = koyou_keitai;
        this.shain_namae = shain_namae;
        this.shain_eigo_namae = shain_eigo_namae;
        this.nyuusha_bi = nyuusha_bi;
        this.taisha_bi = taisha_bi;
        this.bu = bu;
        this.yakushoku = yakushoku;
        this.nai_gaikokuzin = nai_gaikokuzin;
        this.zyuumin_bangou = zyuumin_bangou;
        this.zyuusho = zyuusho;
        this.denwa_bangou = denwa_bangou;
        this.keitai_bangou = keitai_bangou;
        this.meiru_adoresu = meiru_adoresu;
        this.sns = sns;
        this.bikou = bikou;
    }

    // Getter and Setter methods (각 메서드에 주석)
    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public String getKoyou_keitai() { return koyou_keitai; }
    public void setKoyou_keitai(String koyou_keitai) { this.koyou_keitai = koyou_keitai; }

    public String getShain_namae() { return shain_namae; }
    public void setShain_namae(String shain_namae) { this.shain_namae = shain_namae; }

    public String getShain_eigo_namae() { return shain_eigo_namae; }
    public void setShain_eigo_namae(String shain_eigo_namae) { this.shain_eigo_namae = shain_eigo_namae; }

    public Date getNyuusha_bi() { return nyuusha_bi; }
    public void setNyuusha_bi(Date nyuusha_bi) { this.nyuusha_bi = nyuusha_bi; }

    public Date getTaisha_bi() { return taisha_bi; }
    public void setTaisha_bi(Date taisha_bi) { this.taisha_bi = taisha_bi; }

    public String getBu() { return bu; }
    public void setBu(String bu) { this.bu = bu; }

    public String getYakushoku() { return yakushoku; }
    public void setYakushoku(String yakushoku) { this.yakushoku = yakushoku; }

    public String getNai_gaikokuzin() { return nai_gaikokuzin; }
    public void setNai_gaikokuzin(String nai_gaikokuzin) { this.nai_gaikokuzin = nai_gaikokuzin; }

    public String getZyuumin_bangou() { return zyuumin_bangou; }
    public void setZyuumin_bangou(String zyuumin_bangou) { this.zyuumin_bangou = zyuumin_bangou; }

    public String getZyuusho() { return zyuusho; }
    public void setZyuusho(String zyuusho) { this.zyuusho = zyuusho; }

    public String getDenwa_bangou() { return denwa_bangou; }
    public void setDenwa_bangou(String denwa_bangou) { this.denwa_bangou = denwa_bangou; }

    public String getKeitai_bangou() { return keitai_bangou; }
    public void setKeitai_bangou(String keitai_bangou) { this.keitai_bangou = keitai_bangou; }

    public String getMeiru_adoresu() { return meiru_adoresu; }
    public void setMeiru_adoresu(String meiru_adoresu) { this.meiru_adoresu = meiru_adoresu; }

    public String getSns() { return sns; }
    public void setSns(String sns) { this.sns = sns; }

    public String getBikou() { return bikou; }
    public void setBikou(String bikou) { this.bikou = bikou; }
}
