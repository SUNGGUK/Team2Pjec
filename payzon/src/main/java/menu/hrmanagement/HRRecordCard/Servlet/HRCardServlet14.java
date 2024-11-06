package menu.hrmanagement.HRRecordCard.Servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import menu.hrmanagement.HRRecordCard.Model.HRCard14; // HR 카드 모델 import / HRカードモデルインポート
import menu.hrmanagement.HRRecordCard.Service.HRCardService14; // HR 카드 서비스 import / HRカードサービスインポート

public class HRCardServlet14 extends HttpServlet {
    private static final long serialVersionUID = 1L; // 서블릿의 버전을 식별하는 고유 ID / サーブレットのバージョンを識別するユニークID
    private HRCardService14 hrCardService; // HRCardService14 인스턴스를 담을 변수 / HRCardService14インスタンスを格納する変数

    @Override
    public void init() throws ServletException {
        hrCardService = new HRCardService14(); // HRCardService14의 인스턴스를 초기화 / HRCardService14のインスタンスを初期化
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 모든 사원 정보 가져오기 / すべての社員情報を取得
        List<HRCard14> hrCardList14 = hrCardService.getAllHrCards(); // 모든 사원 정보 조회 / すべての社員情報を照会
        request.setAttribute("hrCardList14", hrCardList14); // 요청 속성에 모든 사원 정보를 저장 / リクエスト属性にすべての社員情報を保存

        // shain_ID 파라미터 가져오기 / shain_IDパラメータを取得
        String shainId = request.getParameter("shain_ID");
        if (shainId != null && !shainId.isEmpty()) { // shain_ID가 null이 아니고 빈 문자열이 아닐 경우 / shain_IDがnullでなく空文字でない場合
            // shain_ID로 특정 사원 정보 가져오기 / shain_IDで特定の社員情報を取得
            HRCard14 selectedEmployee = hrCardService.getHRCardById(Integer.parseInt(shainId)); // 사원 정보 조회 / 社員情報を照会
            request.setAttribute("selectedEmployee", selectedEmployee); // 요청 속성에 특정 사원 정보 저장 / リクエスト属性に特定の社員情報を保存
        }

        // JSP 페이지로 포워딩 / JSPページにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/HRManagement/hrCard.jsp"); // JSP 경로 수정 / JSPパスを修正
        dispatcher.forward(request, response); // 요청 및 응답 객체를 JSP 페이지로 전달 / リクエストおよびレスポンスオブジェクトをJSPページに渡す
    }
}
