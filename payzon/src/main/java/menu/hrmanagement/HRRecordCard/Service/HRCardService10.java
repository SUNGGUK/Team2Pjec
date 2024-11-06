package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO10;
import menu.hrmanagement.HRRecordCard.Model.HRCard10;

public class HRCardService10 {

    private HRCardDAO10 hrcardDAO10;
    
    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService10() {
        this.hrcardDAO10 = new HRCardDAO10(); // HRCardDAO10 객체 생성 / HRCardDAO10オブジェクトを生成
    }
    
    // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    public HRCard10 getHRCardById(int shain_ID) {
        return hrcardDAO10.getHRCardById(shain_ID);
    }
    
    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard10> getAllHRCards10() {
        return hrcardDAO10.getAllHRCards10();
    }
    
    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard10> getAllEmployees() {
        return hrcardDAO10.getAllHRCards10(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
}