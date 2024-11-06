package menu.hrmanagement.HRRecordCard.Service;

import java.util.List;

import menu.hrmanagement.HRRecordCard.DAO.HRCardDAO01;
import menu.hrmanagement.HRRecordCard.Model.HRCard01;

public class HRCardService01 {

    private HRCardDAO01 hrcardDAO01;

    // 기본 생성자 혹은 DAO 주입 생성자 / 基本コンストラクタまたはDAO注入コンストラクタ
    public HRCardService01() {
        this.hrcardDAO01 = new HRCardDAO01(); // HRCardDAO01 객체 생성 / HRCardDAO01オブジェクトを生成
    }

    // public HRCard01 getHRCardById(int shain_ID) {
    //     return hrcardDAO01.getHRCardById(shain_ID); // 특정 사원 ID로 HR 카드를 조회하는 메서드 / 特定社員IDでHRカードを照会するメソッド
    // }

    // 전체 직원 목록을 가져오는 메서드 / 全社員リストを取得するメソッド
    public List<HRCard01> getAllHRCards01() {
        return hrcardDAO01.getAllHRCards01(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }

    public List<HRCard01> getAllEmployees() {
        return hrcardDAO01.getAllHRCards01(); // DAO 메서드 호출 / DAOメソッドを呼び出す
    }

}