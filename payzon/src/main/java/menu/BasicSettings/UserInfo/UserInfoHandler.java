package menu.BasicSettings.UserInfo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;

import jdbc.connection.ConnectionProvider;
import menu.BasicSettings.UserInfo.Model.UserInfo;
import mvc.command.CommandHandler;

// 사용자 정보 핸들러 클래스
// ユーザー情報ハンドラークラス
public class UserInfoHandler implements CommandHandler {

    private final UserInfoService userInfoService;

    public UserInfoHandler() {
        this.userInfoService = new UserInfoService();
    }

    // 날짜 문자열을 Date 객체로 변환하는 메서드
    // 日付文字列をDateオブジェクトに変換するメソッド
    private Date parseDate(String dateStr) {
        if (dateStr == null || dateStr.isEmpty()) {
            return null;
        }
        try {
            java.util.Date utilDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            return new Date(utilDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    // 요청 처리 메서드
    // リクエストを処理するメソッド
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String action = request.getParameter("action");

        if ("save".equals(action)) {
            return saveUserInfo(request, response);
        } else if ("cancel".equals(action)) {
            return "/view/BasicSettings/UserInfo.jsp";
        } else if ("view".equals(action)) {
            return loadInitialData(request, response);
        } else {
            return loadInitialData(request, response);
        }
    }

    // 초기 데이터를 로드하는 메서드
    // 初期データをロードするメソッド
    private String loadInitialData(HttpServletRequest request, HttpServletResponse response) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            UserInfo userInfo = userInfoService.retrieveInitialInfo(conn);
            request.getSession().setAttribute("userInfo", userInfo);
            return "/view/BasicSettings/UserInfo.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            return "/view/BasicSettings/Error.jsp";
        }
    }

    // 사용자 정보를 저장하는 메서드
    // ユーザー情報を保存するメソッド
    private String saveUserInfo(HttpServletRequest request, HttpServletResponse response) {
        try (Connection conn = ConnectionProvider.getConnection()) {
            conn.setAutoCommit(false);

            UserInfo userInfo = new UserInfo();
            updateUserInfoFromRequest(request, userInfo);

            userInfoService.saveOrUpdateKaishaZyouhou(conn, userInfo);
            userInfoService.saveOrUpdateKyuuyoShikyuuZyouhou(conn, userInfo);
            userInfoService.saveOrUpdateTantoushaZyouhou(conn, userInfo);

            conn.commit();
            return "/view/BasicSettings/SavePopup.jsp";
        } catch (SQLException e) {
            e.printStackTrace();
            return "/view/BasicSettings/Error.jsp";
        }
    }

    // 요청으로부터 사용자 정보를 업데이트하는 메서드
    // リクエストからユーザー情報を更新するメソッド
    private void updateUserInfoFromRequest(HttpServletRequest request, UserInfo userInfo) {
        // 회사 정보 설정
        // 会社情報の設定
        userInfo.getKaishaZyouhou().setKaisha_mei(request.getParameter("kaishaMei"));
        userInfo.getKaishaZyouhou().setShachou_yakushoku(request.getParameter("shachouYakushoku"));
        userInfo.getKaishaZyouhou().setShachou_mei(request.getParameter("shachouMei"));
        String zigyouBangouStr = request.getParameter("zigyouBangou");
        userInfo.getKaishaZyouhou().setZigyou_bangou(zigyouBangouStr != null && !zigyouBangouStr.isEmpty() ? Long.parseLong(zigyouBangouStr) : 0L);
        String houzinBangouStr = request.getParameter("houzinBangou");
        userInfo.getKaishaZyouhou().setHouzin_bangou(houzinBangouStr != null && !houzinBangouStr.isEmpty() ? Long.parseLong(houzinBangouStr) : 0L);
        userInfo.getKaishaZyouhou().setSetsuritsu_bi(Date.valueOf(request.getParameter("setsuritsuBi")));
        userInfo.getKaishaZyouhou().setUlebusaito(request.getParameter("ulebusaito"));
        userInfo.getKaishaZyouhou().setYubinbango(request.getParameter("yubinbango"));
        userInfo.getKaishaZyouhou().setZigyouzyou_zyuusho(request.getParameter("zigyouzyouZyuusho"));

        // 전화번호 및 팩스번호를 결합하여 저장
        // 電話番号とFAX番号を結合して保存
        String denwaBangou = request.getParameter("denwaPrefix") + request.getParameter("denwaFirst") + request.getParameter("denwaLast");
        userInfo.getKaishaZyouhou().setDenwa_bangou(denwaBangou != null && !denwaBangou.isEmpty() ? Long.parseLong(denwaBangou) : 0L);

        String faksBangou = request.getParameter("faksPrefix") + request.getParameter("faksFirst") + request.getParameter("faksLast");
        userInfo.getKaishaZyouhou().setFakus__bangou(faksBangou);

        userInfo.getKaishaZyouhou().setZigyou_shurui(request.getParameter("zigyouShurui"));
        userInfo.getKaishaZyouhou().setZigyou_naiyou(request.getParameter("zigyouNaiyou"));

        // 급여 지급 정보 설정
        // 給与支給情報の設定
        String shainIDStr = request.getParameter("shainID");
        userInfo.getKyuuyoShikyuuZyouhou().setShain_ID(shainIDStr != null && !shainIDStr.isEmpty() ? Integer.parseInt(shainIDStr) : 0);
        userInfo.getKyuuyoShikyuuZyouhou().setKyuuyo_seisan_kikan(Date.valueOf(request.getParameter("kyuuyoSeisanKikan")));
        userInfo.getKyuuyoShikyuuZyouhou().setKyuuyo_shikyuu_bi(Date.valueOf(request.getParameter("kyuuyoShikyuuBi")));
        userInfo.getKyuuyoShikyuuZyouhou().setKinyuu_kikan(request.getParameter("kinyuuKikan"));
        userInfo.getKyuuyoShikyuuZyouhou().setKouza_bangou(request.getParameter("kouzaBangou"));
        userInfo.getKyuuyoShikyuuZyouhou().setYokinshu(request.getParameter("yokinshu"));

        // 담당자 정보 설정
        // 担当者情報の設定
        userInfo.getTantoushaZyouhou().setNamae(request.getParameter("namae"));
        userInfo.getTantoushaZyouhou().setBu(request.getParameter("bu"));
        userInfo.getTantoushaZyouhou().setYakushoku(request.getParameter("yakushoku"));

        // 담당자 전화번호 및 휴대전화번호 결합
        // 担当者の電話番号と携帯電話番号を結合
        String tantoushaDenwaBangou = request.getParameter("tantoushaDenwaPrefix") + request.getParameter("tantoushaDenwaFirst") + request.getParameter("tantoushaDenwaLast");
        userInfo.getTantoushaZyouhou().setDenwa_bangou(tantoushaDenwaBangou);

        String keitaiBangou = request.getParameter("keitaiPrefix") + request.getParameter("keitaiFirst") + request.getParameter("keitaiLast");
        userInfo.getTantoushaZyouhou().setKeitai_bangou(keitaiBangou);

        userInfo.getTantoushaZyouhou().setMeiru_adoresu(request.getParameter("meiruAd"));
    }
}
