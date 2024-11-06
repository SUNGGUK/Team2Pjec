package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO08;
import menu.hrmanagement.HRRecordCard.Model.HRCard08;

public class HRCardService08 {

    private HRCardDAO08 hrcardDAO08;
    
    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService08() {
        this.hrcardDAO08 = new HRCardDAO08(); // HRCardDAO08 객체 생성 / HRCardDAO08オブジェクトを生成
    }
    
    // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    public HRCard08 getHRCardById(int shain_ID) {
        return hrcardDAO08.getHRCardById(shain_ID);
    }
    
    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard08> getAllHRCards08() {
        return hrcardDAO08.getAllHRCards08();
    }
    
    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard08> getAllEmployees() {
        return hrcardDAO08.getAllHRCards08(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
}