package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO06;
import menu.hrmanagement.HRRecordCard.Model.HRCard06;

public class HRCardService06 {

    private HRCardDAO06 hrcardDAO06;

    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService06() {
        this.hrcardDAO06 = new HRCardDAO06(); // HRCardDAO06 객체 생성 / HRCardDAO06オブジェクトを生成
    }

    // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    public HRCard06 getHRCardById(int shain_ID) {
        return hrcardDAO06.getHRCardById(shain_ID);
    }

    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard06> getAllHRCards06() {
        return hrcardDAO06.getAllHRCards06();
    }

    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard06> getAllEmployees() {
        return hrcardDAO06.getAllHRCards06(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
}