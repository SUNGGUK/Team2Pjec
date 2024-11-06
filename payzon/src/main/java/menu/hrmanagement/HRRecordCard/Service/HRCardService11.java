package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO11;
import menu.hrmanagement.HRRecordCard.Model.HRCard11;

public class HRCardService11 {

    private HRCardDAO11 hrcardDAO11;
    
    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService11() {
        this.hrcardDAO11 = new HRCardDAO11(); // HRCardDAO11 객체 생성 / HRCardDAO11オブジェクトを生成
    }
    
    // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    public HRCard11 getHRCardById(int shain_ID) {
        return hrcardDAO11.getHRCardById(shain_ID);
    }
    
    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard11> getAllHRCards11() {
        return hrcardDAO11.getAllHRCards11();
    }
    
    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard11> getAllEmployees() {
        return hrcardDAO11.getAllHRCards11(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
}