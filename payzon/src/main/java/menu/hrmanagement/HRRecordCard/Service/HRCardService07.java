package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO07;
import menu.hrmanagement.HRRecordCard.Model.HRCard07;

public class HRCardService07 {

    private HRCardDAO07 hrcardDAO07;
    
    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService07() {
        this.hrcardDAO07 = new HRCardDAO07(); // HRCardDAO07 객체 생성 / HRCardDAO07オブジェクトを生成
    }
    
    // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    public HRCard07 getHRCardById(int shain_ID) {
        return hrcardDAO07.getHRCardById(shain_ID);
    }
    
    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard07> getAllHRCards07() {
        return hrcardDAO07.getAllHRCards07();
    }
    
    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard07> getAllEmployees() {
        return hrcardDAO07.getAllHRCards07(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
}