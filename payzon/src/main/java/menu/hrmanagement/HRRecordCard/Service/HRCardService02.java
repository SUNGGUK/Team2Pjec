package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO02;
import menu.hrmanagement.HRRecordCard.Model.HRCard02;

public class HRCardService02 {

    private HRCardDAO02 hrcardDAO02;

    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService02() {
        this.hrcardDAO02 = new HRCardDAO02(); // HRCardDAO02 객체 생성 / HRCardDAO02オブジェクトを生成
    }

    // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    public HRCard02 getHRCardById(int shain_ID) {
        return hrcardDAO02.getHRCardById(shain_ID);
    }

    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard02> getAllHRCards02() {
        return hrcardDAO02.getAllHRCards02(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }

    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard02> getAllEmployees() {
        return hrcardDAO02.getAllHRCards02(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
}