package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO13;
import menu.hrmanagement.HRRecordCard.Model.HRCard13;

public class HRCardService13 {

    private HRCardDAO13 hrcardDAO13;
    
    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService13() {
        this.hrcardDAO13 = new HRCardDAO13(); // HRCardDAO13 객체 생성 / HRCardDAO13オブジェクトを生成
    }
    
    // 특정 사원 ID로 HR 카드를 조회하는 메서드 (주석 처리됨) / 特定社員IDでHRカードを照会するメソッド（コメントアウトされている）
    // public HRCard13 getHRCardById(int shain_ID) {
    //     return hrcardDAO13.getHRCardById(shain_ID);
    // }
    
    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard13> getAllHRCards13() {
        return hrcardDAO13.getAllHRCards13();
    }
    
    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard13> getAllEmployees() {
        return hrcardDAO13.getAllHRCards13(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
}