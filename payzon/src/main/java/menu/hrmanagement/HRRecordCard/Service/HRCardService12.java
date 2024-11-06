package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO12;
import menu.hrmanagement.HRRecordCard.Model.HRCard12;

public class HRCardService12 {

    private HRCardDAO12 hrcardDAO12;
    
    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService12() {
        this.hrcardDAO12 = new HRCardDAO12(); // HRCardDAO12 객체 생성 / HRCardDAO12オブジェクトを生成
    }
    
    // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    public HRCard12 getHRCardById(int shain_ID) {
        return hrcardDAO12.getHRCardById(shain_ID);
    }
    
    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard12> getAllHRCards12() {
        return hrcardDAO12.getAllHRCards12();
    }
    
    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard12> getAllEmployees() {
        return hrcardDAO12.getAllHRCards12(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
}