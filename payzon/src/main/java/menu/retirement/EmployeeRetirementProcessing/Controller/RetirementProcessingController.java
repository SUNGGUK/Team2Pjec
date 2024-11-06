package menu.retirement.EmployeeRetirementProcessing.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.retirement.EmployeeRetirementProcessing.Model.RetirementProcessing;
import menu.retirement.EmployeeRetirementProcessing.Service.RetirementProcessingService;
import mvc.command.CommandHandler;

public class RetirementProcessingController implements CommandHandler {

    private RetirementProcessingService retirementProcessingService;

    // 생성자: RetirementProcessingController 생성 시 RetirementProcessingService 초기화
    public RetirementProcessingController() {
        this.retirementProcessingService = new RetirementProcessingService();
    }

    /**
     * 퇴직 처리 목록을 조회하여 JSP로 전달하는 메서드
     */
    private void listRetirementProcessing(HttpServletRequest request, HttpServletResponse response) 
            throws SQLException, ServletException, IOException {
        
        System.out.println("Controller: listRetirementProcessing 호출됨");

        List<RetirementProcessing> list;

        try {
            list = retirementProcessingService.getAllRetirementProcessing();
            System.out.println("Controller: RetirementProcessing 목록 가져오기 성공, 총 " + list.size() + "건");
        } catch (SQLException e) {
            System.err.println("Controller: 데이터베이스에서 목록 가져오기 실패 - " + e.getMessage());
            throw e;
        }
        
        request.setAttribute("list", list);
        request.getRequestDispatcher("/view/RetirementManagement/retirementList.jsp").forward(request, response);
    }

    /**
     * CommandHandler의 process 메서드를 구현하여 요청을 처리
     */
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // 퇴직 처리 목록을 조회하고, JSP 페이지로 포워딩
            listRetirementProcessing(request, response);
        } catch (SQLException e) {
            System.out.println("Controller: 데이터베이스 작업 중 오류 발생: " + e.getMessage());
            throw new ServletException("データベース操作中にエラー発生", e);
        }
        return null;  // JSP 페이지로 직접 포워딩하므로 null 반환
    }
}


/*
 * package menu.retirement.EmployeeRetirementProcessing.Controller;
 * 
 * import java.io.IOException; import java.sql.SQLException; import
 * java.util.List; import javax.servlet.ServletException; import
 * javax.servlet.http.HttpServlet; import javax.servlet.http.HttpServletRequest;
 * import javax.servlet.http.HttpServletResponse;
 * 
 * import
 * menu.retirement.EmployeeRetirementProcessing.Model.RetirementProcessing;
 * import menu.retirement.EmployeeRetirementProcessing.Service.
 * RetirementProcessingService;
 * 
 * public class RetirementProcessingController extends HttpServlet {
 * 
 * private static final long serialVersionUID = 1L; private
 * RetirementProcessingService retirementProcessingService;
 * 
 * // 생성자: RetirementProcessingController 생성 시 RetirementProcessingService 초기화
 * // コンストラクタ：RetirementProcessingControllerの生成時にRetirementProcessingServiceを初期化
 * public RetirementProcessingController() { this.retirementProcessingService =
 * new RetirementProcessingService(); }
 * 
 *//**
	 * 퇴직 처리 목록을 조회하여 JSP로 전달하는 메서드
	 * 
	 * @param request  클라이언트 요청 정보
	 * @param response 서버 응답 정보
	 * @throws SQLException     데이터베이스 관련 예외 발생 시 던짐
	 * @throws ServletException 서블릿 관련 예외 발생 시 던짐
	 * @throws IOException      입출력 예외 발생 시 던짐
	 *
	 *                          退職処理リストを取得し、JSPに渡すメソッド
	 * @param request  クライアントからのリクエスト情報
	 * @param response サーバーからのレスポンス情報
	 * @throws SQLException     データベース関連の例外発生時にスロー
	 * @throws ServletException サーブレット関連の例外発生時にスロー
	 * @throws IOException      入出力例外発生時にスロー
	 */
/*
 * private void listRetirementProcessing(HttpServletRequest request,
 * HttpServletResponse response) throws SQLException, ServletException,
 * IOException {
 * 
 * System.out.println("Controller: listRetirementProcessing 호출됨"); // 메서드 호출 확인용
 * 로그 // コントローラ：listRetirementProcessing呼び出し確認ログ
 * 
 * List<RetirementProcessing> list; // 퇴직 처리 목록을 저장할 변수 // 退職処理リストを保存する変数
 * 
 * try { // 서비스 객체를 통해 모든 퇴직 처리 목록을 가져옴 // サービスオブジェクトを介してすべての退職処理リストを取得 list =
 * retirementProcessingService.getAllRetirementProcessing();
 * System.out.println("Controller: RetirementProcessing 목록 가져오기 성공, 총 " +
 * list.size() + "건"); // 성공 로그 // コントローラ：RetirementProcessingリスト取得成功、合計
 * " + list.size() + "件 } catch (SQLException e) { // 데이터베이스 조회 실패 시 오류 메시지 출력
 * // データベース取得失敗時にエラーメッセージを出力
 * System.err.println("Controller: 데이터베이스에서 목록 가져오기 실패 - " + e.getMessage());
 * throw e; // SQLException을 상위 호출자에게 전달 // SQLExceptionを上位呼び出し元に渡す }
 * 
 * // JSP 페이지로 전달하기 위해 퇴직 처리 목록을 요청 속성에 저장 // JSPページに渡すため、退職処理リストをリクエスト属性に保存
 * request.setAttribute("list", list);
 * 
 * // retirementList.jsp 페이지로 포워딩하여 결과 출력 // retirementList.jspページにフォワードして結果を表示
 * request.getRequestDispatcher("/view/RetirementManagement/retirementList.jsp")
 * .forward(request, response); }
 * 
 *//**
	 * GET 요청을 처리하는 메서드. 퇴직 처리 목록을 가져와서 화면에 출력함
	 * 
	 * @param request  클라이언트 요청 정보
	 * @param response 서버 응답 정보
	 * @throws ServletException 서블릿 관련 예외 발생 시 던짐
	 * @throws IOException      입출력 예외 발생 시 던짐
	 *
	 *                          GETリクエストを処理するメソッド。退職処理リストを取得して画面に表示
	 * @param request  クライアントからのリクエスト情報
	 * @param response サーバーからのレスポンス情報
	 * @throws ServletException サーブレット関連の例外発生時にスロー
	 * @throws IOException      入出力例外発生時にスロー
	 *//*
		 * @Override protected void doGet(HttpServletRequest request,
		 * HttpServletResponse response) throws ServletException, IOException {
		 * 
		 * try { // GET 요청 시 퇴직 처리 목록을 조회하고, JSP 페이지로 포워딩 //
		 * GETリクエスト時に退職処理リストを取得し、JSPページにフォワード listRetirementProcessing(request,
		 * response); } catch (SQLException e) { // 데이터베이스 작업 중 오류 발생 시 콘솔에 오류 메시지 출력 //
		 * データベース操作中のエラー発生時にコンソールにエラーメッセージを出力
		 * System.out.println("Controller: 데이터베이스 작업 중 오류 발생: " + e.getMessage());
		 * 
		 * // 오류 내용을 포함하여 ServletException을 던짐 // エラー内容を含めてServletExceptionをスロー throw
		 * new ServletException("データベース操作中にエラー発生", e); } } }
		 */