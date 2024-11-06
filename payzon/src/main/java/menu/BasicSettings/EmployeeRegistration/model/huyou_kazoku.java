package menu.BasicSettings.EmployeeRegistration.model;

//-- 9. 부양 가족 테이블 (huyou_kazoku)
//-- 9. 扶養家族テーブル (huyou_kazoku)
public class huyou_kazoku {
    int shain_ID; // 사원 ID / 社員ID
    String namae; // 이름 / 名前
    String kankei; // 관계 / 関係
    String zyuumin_touroku_bangou; // 주민 등록 번호 / 住民登録番号
    char shougai_umu; // 장애 유무 / 障害有無
    char zei_kouzyo_umu; // 세금 공제 유무 / 税控除有無
    char kenkou_hoken_umu; // 건강 보험 유무 / 健康保険有無
    char doukyo_umu; // 동거 여부 / 同居有無
    char nen20_ika_ko_umu; // 20세 이하 자녀 여부 / 20歳以下子有無

    public huyou_kazoku() {}

    // 모든 필드를 포함하는 생성자 정의 / 全てのフィールドを含むコンストラクタ定義
    public huyou_kazoku(int shain_ID, String namae, String kankei, String zyuumin_touroku_bangou, 
                        char shougai_umu, char zei_kouzyo_umu, char kenkou_hoken_umu, 
                        char doukyo_umu, char nen20_ika_ko_umu) {
        this.shain_ID = shain_ID;
        this.namae = namae;
        this.kankei = kankei;
        this.zyuumin_touroku_bangou = zyuumin_touroku_bangou;
        this.shougai_umu = shougai_umu;
        this.zei_kouzyo_umu = zei_kouzyo_umu;
        this.kenkou_hoken_umu = kenkou_hoken_umu;
        this.doukyo_umu = doukyo_umu;
        this.nen20_ika_ko_umu = nen20_ika_ko_umu;
    }

    // Getter 및 Setter 메서드 (각 메서드에 한국어/일본어 주석 포함)
    public int getShain_ID() { return shain_ID; }
    public void setShain_ID(int shain_ID) { this.shain_ID = shain_ID; }

    public String getNamae() { return namae; }
    public void setNamae(String namae) { this.namae = namae; }

    public String getKankei() { return kankei; }
    public void setKankei(String kankei) { this.kankei = kankei; }

    public String getZyuumin_touroku_bangou() { return zyuumin_touroku_bangou; }
    public void setZyuumin_touroku_bangou(String zyuumin_touroku_bangou) { this.zyuumin_touroku_bangou = zyuumin_touroku_bangou; }

    public char getShougai_umu() { return shougai_umu; }
    public void setShougai_umu(char shougai_umu) { this.shougai_umu = shougai_umu; }

    public char getZei_kouzyo_umu() { return zei_kouzyo_umu; }
    public void setZei_kouzyo_umu(char zei_kouzyo_umu) { this.zei_kouzyo_umu = zei_kouzyo_umu; }

    public char getKenkou_hoken_umu() { return kenkou_hoken_umu; }
    public void setKenkou_hoken_umu(char kenkou_hoken_umu) { this.kenkou_hoken_umu = kenkou_hoken_umu; }

    public char getDoukyo_umu() { return doukyo_umu; }
    public void setDoukyo_umu(char doukyo_umu) { this.doukyo_umu = doukyo_umu; }

    public char getNen20_ika_ko_umu() { return nen20_ika_ko_umu; }
    public void setNen20_ika_ko_umu(char nen20_ika_ko_umu) { this.nen20_ika_ko_umu = nen20_ika_ko_umu; }
}
