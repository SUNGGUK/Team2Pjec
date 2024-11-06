package menu.BasicSettings.EmployeeRegistration.model;

//-- 4. 부서 테이블 (busho_settei)
//-- 4. 部署テーブル (busho_settei)
public class busho_settei {
    int shain_id; // 사원 ID / 社員ID
    String busho_mei; // 부서명 / 部署名

    public busho_settei() {}

    // 모든 필드를 포함하는 생성자 정의 / 全てのフィールドを含むコンストラクタ定義
    public busho_settei(int shain_id, String busho_mei) {
        this.shain_id = shain_id;
        this.busho_mei = busho_mei;
    }

    public int getShain_id() { return shain_id; }
    public void setShain_id(int shain_id) { this.shain_id = shain_id; }

    public String getBusho_mei() { return busho_mei; }
    public void setBusho_mei(String busho_mei) { this.busho_mei = busho_mei; }
}
