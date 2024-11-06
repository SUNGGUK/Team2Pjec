package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO04;
import menu.hrmanagement.HRRecordCard.Model.HRCard04;

public class HRCardService04 {

    private HRCardDAO04 hrcardDAO04;

    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService04() {
        this.hrcardDAO04 = new HRCardDAO04(); // HRCardDAO04 객체 생성 / HRCardDAO04オブジェクトを生成
    }

    // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    public HRCard04 getHRCardById(int shain_ID) {
        return hrcardDAO04.getHRCardById(shain_ID);
    }

    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard04> getAllHRCards04() {
        return hrcardDAO04.getAllHRCards04();
    }

    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard04> getAllEmployees() {
        return hrcardDAO04.getAllHRCards04(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
}