package menu.BasicSettings.VacationSettings.model;

// 근태 항목 설정 테이블 클래스
// 勤怠項目設定クラス
public class kintai_koumoku_settei {
    int kintai_ID; // 근태 ID
    String kintai_shurui; // 근태 종류
    String kouzyo_kisoku; // 공제 규칙
    String tani; // 단위
    char shiyou_kanou_umu; // 사용 가능 여부

    // 생성자: 초기값 설정
    // コンストラクタ: 初期値の設定
    public kintai_koumoku_settei(int kintai_ID, String kintai_shurui, String kouzyo_kisoku, String tani, char shiyou_kanou_umu) {
        this.kintai_ID = kintai_ID;
        this.kintai_shurui = kintai_shurui;
        this.kouzyo_kisoku = kouzyo_kisoku;
        this.tani = tani;
        this.shiyou_kanou_umu = shiyou_kanou_umu;
    }

    // 근태 ID 반환
    // 勤怠IDを返す
    public int getKintai_ID() {
        return kintai_ID;
    }

    // 근태 ID 설정
    // 勤怠IDを設定する
    public void setKintai_ID(int kintai_ID) {
        this.kintai_ID = kintai_ID;
    }

    // 근태 종류 반환
    // 勤怠種類を返す
    public String getKintai_shurui() {
        return kintai_shurui;
    }

    // 근태 종류 설정
    // 勤怠種類を設定する
    public void setKintai_shurui(String kintai_shurui) {
        this.kintai_shurui = kintai_shurui;
    }

    // 공제 규칙 반환
    // 控除規則を返す
    public String getKouzyo_kisoku() {
        return kouzyo_kisoku;
    }

    // 공제 규칙 설정
    // 控除規則を設定する
    public void setKouzyo_kisoku(String kouzyo_kisoku) {
        this.kouzyo_kisoku = kouzyo_kisoku;
    }

    // 단위 반환
    // 単位を返す
    public String getTani() {
        return tani;
    }

    // 단위 설정
    // 単位を設定する
    public void setTani(String tani) {
        this.tani = tani;
    }

    // 사용 가능 여부 반환
    // 使用可能かどうかを返す
    public char getShiyou_kanou_umu() {
        return shiyou_kanou_umu;
    }

    // 사용 가능 여부 설정
    // 使用可能かどうかを設定する
    public void setShiyou_kanou_umu(char shiyou_kanou_umu) {
        this.shiyou_kanou_umu = shiyou_kanou_umu;
    }
}
