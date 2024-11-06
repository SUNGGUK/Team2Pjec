package menu.hrmanagement.HRRecordCard.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.hrmanagement.HRRecordCard.Model.HRCard02; // HR 카드 모델 import
import menu.hrmanagement.HRRecordCard.Service.HRCardService02; // HR 카드 서비스 import

public class HRCardServlet02 extends HttpServlet {

    private static final long serialVersionUID = 1L; // 서블릿의 버전을 식별하는 고유 ID (직렬화 지원) / サーブレットのバージョンを識別するユニークID（シリアル化サポート）
    private HRCardService02 hrCardService02; // HRCardService02 인스턴스를 담을 변수 / HRCardService02インスタンスを格納する変数

    @Override
    public void init() throws ServletException {
        // HRCardService02의 인스턴스를 생성하고 초기화 / HRCardService02のインスタンスを生成して初期化
        hrCardService02 = new HRCardService02(); // HRCardService02를 인스턴스화하여 서비스 로직을 수행할 준비 / HRCardService02をインスタンス化してサービスロジックを実行する準備
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 요청 파라미터에서 shain_ID를 가져옴 / リクエストパラメータからshain_IDを取得
        String shain_Id = request.getParameter("shain_ID");
        
        // shain_ID가 null이 아니고 빈 문자열이 아닐 경우에만 사원 정보를 조회 / shain_IDがnullでなく空文字でない場合のみ社員情報を照会
        if (shain_Id != null && !shain_Id.isEmpty()) {
            // shain_ID를 기반으로 사원 정보를 가져옴 / shain_IDを基に社員情報を取得
            HRCard02 hrCard02 = hrCardService02.getHRCardById(Integer.parseInt(shain_Id));
            
            // 요청 속성에 사원 정보를 저장 / リクエスト属性に社員情報を保存
            request.setAttribute("hrCard02", hrCard02); // JSP에서 사용할 수 있도록 요청 속성에 사원 정보 저장 / JSPで使用できるようにリクエスト属性に社員情報を保存
        }

        // JSP 페이지로 포워딩 / JSPページにフォワード
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/HRManagement/hrCard.jsp"); // 요청을 hrCard.jsp 페이지로 포워딩 / リクエストをhrCard.jspページにフォワード
        dispatcher.forward(request, response); // 요청 및 응답 객체를 함께 전달하여 페이지를 렌더링 / リクエストおよびレスポンスオブジェクトを一緒に渡してページをレンダリング
    }
}