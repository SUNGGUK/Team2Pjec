package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO09;
import menu.hrmanagement.HRRecordCard.Model.HRCard09;

public class HRCardService09 {

    private HRCardDAO09 hrcardDAO09;
    
    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService09() {
        this.hrcardDAO09 = new HRCardDAO09(); // HRCardDAO09 객체 생성 / HRCardDAO09オブジェクトを生成
    }
    
    // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    public HRCard09 getHRCardById(int shain_ID) {
        return hrcardDAO09.getHRCardById(shain_ID);
    }
    
    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard09> getAllHRCards09() {
        return hrcardDAO09.getAllHRCards09();
    }
    
    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard09> getAllEmployees() {
        return hrcardDAO09.getAllHRCards09(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
}