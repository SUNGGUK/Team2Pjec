package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;
import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO14;
import menu.hrmanagement.HRRecordCard.Model.HRCard14;

public class HRCardService14 {

    private HRCardDAO14 hrcardDAO14;

    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService14() {
        this.hrcardDAO14 = new HRCardDAO14(); // HRCardDAO14 객체 생성 / HRCardDAO14オブジェクトを生成
    }
    
    // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    public HRCard14 getHRCardById(int shain_ID) {
        return hrcardDAO14.getHRCardById(shain_ID);
    }
    
    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard14> getAllHRCards14() {
        return hrcardDAO14.getAllHRCards14();
    }
    
    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard14> getAllEmployees() {
        return hrcardDAO14.getAllHRCards14(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
    
    // 전체 HR 카드를 가져오는 메서드 / 全HRカードを取得するメソッド
    public List<HRCard14> getAllHrCards() {
        return hrcardDAO14.getAllHRCards14(); // DAO 메서드를 호출 / DAOメソッドを呼び出す
    }
}
