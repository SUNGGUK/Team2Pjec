package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO05;
import menu.hrmanagement.HRRecordCard.Model.HRCard05;

public class HRCardService05 {

    private HRCardDAO05 hrcardDAO05;

    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService05() {
        this.hrcardDAO05 = new HRCardDAO05(); // HRCardDAO05 객체 생성 / HRCardDAO05オブジェクトを生成
    }

    // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    public HRCard05 getHRCardById(int shain_ID) {
        return hrcardDAO05.getHRCardById(shain_ID);
    }

    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard05> getAllHRCards05() {
        return hrcardDAO05.getAllHRCards05();
    }

    // 모든 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard05> getAllEmployees() {
        return hrcardDAO05.getAllHRCards05(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }
}
