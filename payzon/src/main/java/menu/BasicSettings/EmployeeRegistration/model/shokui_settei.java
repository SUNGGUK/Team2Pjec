package menu.BasicSettings.EmployeeRegistration.model;

//-- 5. 직위 테이블 (shokui_settei)
//-- 5. 職位テーブル (shokui_settei)
public class shokui_settei {
    int shain_id; // 사원 ID / 社員ID
    String shokui_mei; // 직위명 / 職位名

    // 생성자 / コンストラクタ
    public shokui_settei(int shain_id, String shokui_mei) {
        this.shain_id = shain_id;
        this.shokui_mei = shokui_mei;
    }
    
    public shokui_settei() {}

    // Getter and Setter methods
    public int getShain_id() { return shain_id; }
    public void setShain_id(int shain_id) { this.shain_id = shain_id; }

    public String getShokui_mei() { return shokui_mei; }
    public void setShokui_mei(String shokui_mei) { this.shokui_mei = shokui_mei; }
}
