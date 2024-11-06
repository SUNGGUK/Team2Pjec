package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO03;
import menu.hrmanagement.HRRecordCard.Model.HRCard03;

public class HRCardService03 {

    private HRCardDAO03 hrcardDAO03;

    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService03() {
        this.hrcardDAO03 = new HRCardDAO03(); // HRCardDAO03 객체 생성 / HRCardDAO03オブジェクトを生成
    }

    // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    public HRCard03 getHRCardById(int shain_ID) {
        return hrcardDAO03.getHRCardById(shain_ID);
    }

    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard03> getAllHRCards03() {
        return hrcardDAO03.getAllHRCards03();
    }

    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard03> getAllEmployees() {
        return hrcardDAO03.getAllHRCards03(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
}