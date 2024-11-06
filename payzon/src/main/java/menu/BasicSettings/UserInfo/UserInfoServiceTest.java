package menu.BasicSettings.UserInfo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import menu.BasicSettings.UserInfo.Model.UserInfo;

public class UserInfoServiceTest {
    public static void main(String[] args) {
        UserInfoService userInfoService = new UserInfoService();
        String url = "jdbc:oracle:thin:@localhost:1521:xe"; // JDBC URL
        String user = "system"; // 데이터베이스 사용자 이름
        String password = "1234"; // 데이터베이스 비밀번호

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            UserInfo userInfo = userInfoService.retrieveInitialInfo(conn);

            // 회사 정보 출력
            System.out.println("회사명: " + userInfo.getKaishaZyouhou().getKaisha_mei());
            System.out.println("CEO 직책: " + userInfo.getKaishaZyouhou().getShachou_yakushoku());
            System.out.println("CEO 이름: " + userInfo.getKaishaZyouhou().getShachou_mei());
            System.out.println("사업자번호: " + userInfo.getKaishaZyouhou().getZigyou_bangou());
            System.out.println("법인번호: " + userInfo.getKaishaZyouhou().getHouzin_bangou());
            System.out.println("설립일: " + userInfo.getKaishaZyouhou().getSetsuritsu_bi());
            System.out.println("웹사이트: " + userInfo.getKaishaZyouhou().getUlebusaito());
            System.out.println("우편번호: " + userInfo.getKaishaZyouhou().getYubinbango());
            System.out.println("사업장 주소: " + userInfo.getKaishaZyouhou().getZigyouzyou_zyuusho());
            System.out.println("전화번호: " + userInfo.getKaishaZyouhou().getDenwa_bangou());
            System.out.println("팩스번호: " + userInfo.getKaishaZyouhou().getFakus__bangou());
            System.out.println("사업 종류: " + userInfo.getKaishaZyouhou().getZigyou_shurui());
            System.out.println("사업 내용: " + userInfo.getKaishaZyouhou().getZigyou_naiyou());

            // 급여 정보 출력
            System.out.println("사원 ID: " + userInfo.getKyuuyoShikyuuZyouhou().getShain_ID());
            System.out.println("급여 정산 기간: " + userInfo.getKyuuyoShikyuuZyouhou().getKyuuyo_seisan_kikan());
            System.out.println("급여 지급일: " + userInfo.getKyuuyoShikyuuZyouhou().getKyuuyo_shikyuu_bi());
            System.out.println("금융 기관: " + userInfo.getKyuuyoShikyuuZyouhou().getKinyuu_kikan());
            System.out.println("계좌 번호: " + userInfo.getKyuuyoShikyuuZyouhou().getKouza_bangou());
            System.out.println("예금주: " + userInfo.getKyuuyoShikyuuZyouhou().getYokinshu());

            // 담당자 정보 출력
            System.out.println("담당자 이름: " + userInfo.getTantoushaZyouhou().getNamae());
            System.out.println("부서: " + userInfo.getTantoushaZyouhou().getBu());
            System.out.println("직책: " + userInfo.getTantoushaZyouhou().getYakushoku());
            System.out.println("전화번호: " + userInfo.getTantoushaZyouhou().getDenwa_bangou());
            System.out.println("휴대전화번호: " + userInfo.getTantoushaZyouhou().getKeitai_bangou());
            System.out.println("이메일 주소: " + userInfo.getTantoushaZyouhou().getMeiru_adoresu());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
