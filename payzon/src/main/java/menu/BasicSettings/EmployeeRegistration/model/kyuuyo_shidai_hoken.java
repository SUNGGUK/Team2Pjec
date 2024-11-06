package menu.BasicSettings.EmployeeRegistration.model;

//-- 7. 급여 및 4대 보험 테이블 (kyuuya_shidai_hoken)
//-- 7. 給与及び四大保険テーブル (kyuuya_shidai_hoken)
public class kyuuyo_shidai_hoken {

    public int shain_ID; // 사원 ID / 社員ID
    public char kokumin_nenkin; // 국민연금 / 国民年金
    public char kenko_hoken; // 건강보험 / 健康保険
    public int genmen1; // 감면 금액 1 / 減免額1
    public char kaigo_hoken; // 개호 보험 / 介護保険
    public int genmen2; // 감면 금액 2 / 減免額2
    public char koyo_hoken; // 고용 보험 / 雇用保険
    public char rodo_sha; // 근로자 / 労働者
    public int zeigaku; // 세액 / 税額
    public char seinen_zei; // 청년세 / 青年税
    public int genmen3; // 감면 금액 3 / 減免額3
    public char jigyo_sha; // 사업자 / 事業者
    public char hiyatoi; // 임시직 / 日雇い
    public char sonota_sha; // 기타 / その他者
    public char rodo_jigyo_sha; // 근로사업자 / 労働事業者
    public char menjo; // 면제 / 免除
    public char gaito_nashi1; // 해당 없음 1 / 該当なし1
    public char shinki_80_1; // 신규 80% 1 / 新規80%1
    public char shinki_90_1; // 신규 90% 1 / 新規90%1
    public char gaito_nashi2; // 해당 없음 2 / 該当なし2
    public char shinki_80_2; // 신규 80% 2 / 新規80%2
    public char shinki_90_2; // 신규 90% 2 / 新規90%2
    public int kihonkyuu; // 기본급 / 基本給
    public int nenkin_shotoku; // 연금 소득 / 年金所得
    public int kenko_shotoku; // 건강 소득 / 健康所得
    public int koyo_shotoku; // 고용 소득 / 雇用所得
    public int sangyou_saigai; // 산업재해 / 産業災害
    public String ginkou_mei; // 은행명 / 銀行名
    public String kouza_bangou; // 계좌번호 / 口座番号

    // 기본 생성자 / デフォルトコンストラクタ
    public kyuuyo_shidai_hoken() {}

    // 모든 필드를 포함하는 생성자 정의 / 全てのフィールドを含むコンストラクタ定義
    public kyuuyo_shidai_hoken(int shain_ID, char kokumin_nenkin, char kenko_hoken, int genmen1, char kaigo_hoken,
                               int genmen2, char koyo_hoken, char rodo_sha, int zeigaku, char seinen_zei,
                               int genmen3, char jigyo_sha, char hiyatoi, char sonota_sha, char rodo_jigyo_sha,
                               char menjo, char gaito_nashi1, char shinki_80_1, char shinki_90_1, char gaito_nashi2,
                               char shinki_80_2, char shinki_90_2, int kihonkyuu, int nenkin_shotoku,
                               int kenko_shotoku, int koyo_shotoku, int sangyou_saigai, String ginkou_mei, 
                               String kouza_bangou) {
        this.shain_ID = shain_ID;
        this.kokumin_nenkin = kokumin_nenkin;
        this.kenko_hoken = kenko_hoken;
        this.genmen1 = genmen1;
        this.kaigo_hoken = kaigo_hoken;
        this.genmen2 = genmen2;
        this.koyo_hoken = koyo_hoken;
        this.rodo_sha = rodo_sha;
        this.zeigaku = zeigaku;
        this.seinen_zei = seinen_zei;
        this.genmen3 = genmen3;
        this.jigyo_sha = jigyo_sha;
        this.hiyatoi = hiyatoi;
        this.sonota_sha = sonota_sha;
        this.rodo_jigyo_sha = rodo_jigyo_sha;
        this.menjo = menjo;
        this.gaito_nashi1 = gaito_nashi1;
        this.shinki_80_1 = shinki_80_1;
        this.shinki_90_1 = shinki_90_1;
        this.gaito_nashi2 = gaito_nashi2;
        this.shinki_80_2 = shinki_80_2;
        this.shinki_90_2 = shinki_90_2;
        this.kihonkyuu = kihonkyuu;
        this.nenkin_shotoku = nenkin_shotoku;
        this.kenko_shotoku = kenko_shotoku;
        this.koyo_shotoku = koyo_shotoku;
        this.sangyou_saigai = sangyou_saigai;
        this.ginkou_mei = ginkou_mei;
        this.kouza_bangou = kouza_bangou;
    }

    // Getter 및 Setter 메서드 (각 메서드에 한국어/일본어 주석 포함)
    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public char getKokumin_nenkin() { return kokumin_nenkin; }
    public void setKokumin_nenkin(char kokumin_nenkin) { this.kokumin_nenkin = kokumin_nenkin; }

    public char getKenko_hoken() { return kenko_hoken; }
    public void setKenko_hoken(char kenko_hoken) { this.kenko_hoken = kenko_hoken; }

    public int getGenmen1() { return genmen1; }
    public void setGenmen1(int genmen1) { this.genmen1 = genmen1; }

    public char getKaigo_hoken() { return kaigo_hoken; }
    public void setKaigo_hoken(char kaigo_hoken) { this.kaigo_hoken = kaigo_hoken; }

    public int getGenmen2() { return genmen2; }
    public void setGenmen2(int genmen2) { this.genmen2 = genmen2; }

    public char getKoyo_hoken() { return koyo_hoken; }
    public void setKoyo_hoken(char koyo_hoken) { this.koyo_hoken = koyo_hoken; }

    public char getRodo_sha() { return rodo_sha; }
    public void setRodo_sha(char rodo_sha) { this.rodo_sha = rodo_sha; }

    public int getZeigaku() { return zeigaku; }
    public void setZeigaku(int zeigaku) { this.zeigaku = zeigaku; }

    public char getSeinen_zei() { return seinen_zei; }
    public void setSeinen_zei(char seinen_zei) { this.seinen_zei = seinen_zei; }

    public int getGenmen3() { return genmen3; }
    public void setGenmen3(int genmen3) { this.genmen3 = genmen3; }

    public char getJigyo_sha() { return jigyo_sha; }
    public void setJigyo_sha(char jigyo_sha) { this.jigyo_sha = jigyo_sha; }

    public char getHiyatoi() { return hiyatoi; }
    public void setHiyatoi(char hiyatoi) { this.hiyatoi = hiyatoi; }

    public char getSonota_sha() { return sonota_sha; }
    public void setSonota_sha(char sonota_sha) { this.sonota_sha = sonota_sha; }

    public char getRodo_jigyo_sha() { return rodo_jigyo_sha; }
    public void setRodo_jigyo_sha(char rodo_jigyo_sha) { this.rodo_jigyo_sha = rodo_jigyo_sha; }

    public char getMenjo() { return menjo; }
    public void setMenjo(char menjo) { this.menjo = menjo; }

    public char getGaito_nashi1() { return gaito_nashi1; }
    public void setGaito_nashi1(char gaito_nashi1) { this.gaito_nashi1 = gaito_nashi1; }

    public char getShinki_80_1() { return shinki_80_1; }
    public void setShinki_80_1(char shinki_80_1) { this.shinki_80_1 = shinki_80_1; }

    public char getShinki_90_1() { return shinki_90_1; }
    public void setShinki_90_1(char shinki_90_1) { this.shinki_90_1 = shinki_90_1; }

    public char getGaito_nashi2() { return gaito_nashi2; }
    public void setGaito_nashi2(char gaito_nashi2) { this.gaito_nashi2 = gaito_nashi2; }

    public char getShinki_80_2() { return shinki_80_2; }
    public void setShinki_80_2(char shinki_80_2) { this.shinki_80_2 = shinki_80_2; }

    public char getShinki_90_2() { return shinki_90_2; }
    public void setShinki_90_2(char shinki_90_2) { this.shinki_90_2 = shinki_90_2; }

    public int getKihonkyuu() { return kihonkyuu; }
    public void setKihonkyuu(int kihonkyuu) { this.kihonkyuu = kihonkyuu; }

    public int getNenkin_shotoku() { return nenkin_shotoku; }
    public void setNenkin_shotoku(int nenkin_shotoku) { this.nenkin_shotoku = nenkin_shotoku; }

    public int getKenko_shotoku() { return kenko_shotoku; }
    public void setKenko_shotoku(int kenko_shotoku) { this.kenko_shotoku = kenko_shotoku; }

    public int getKoyo_shotoku() { return koyo_shotoku; }
    public void setKoyo_shotoku(int koyo_shotoku) { this.koyo_shotoku = koyo_shotoku; }

    public int getSangyou_saigai() { return sangyou_saigai; }
    public void setSangyou_saigai(int sangyou_saigai) { this.sangyou_saigai = sangyou_saigai; }

    public String getGinkou_mei() { return ginkou_mei; }
    public void setGinkou_mei(String ginkou_mei) { this.ginkou_mei = ginkou_mei; }

    public String getKouza_bangou() { return kouza_bangou; }
    public void setKouza_bangou(String kouza_bangou) { this.kouza_bangou = kouza_bangou; }
}
