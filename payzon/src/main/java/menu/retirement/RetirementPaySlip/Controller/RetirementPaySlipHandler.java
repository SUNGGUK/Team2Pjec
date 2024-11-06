package menu.retirement.RetirementPaySlip.Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.retirement.RetirementPaySlip.Model.RetirementPaySlip;
import menu.retirement.RetirementPaySlip.Service.RetirementPaySlipService;

public class RetirementPaySlipHandler extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private RetirementPaySlipService retirementPaySlipService = new RetirementPaySlipService();

    /**
     * GET 요청을 처리하여 지급년도 또는 사원 ID에 따라 퇴직급여 정보를 조회하는 메서드
     * @param request 클라이언트 요청 정보
     * @param response 서버 응답 정보
     * @throws ServletException 서블릿 관련 예외 발생 시 던짐
     * @throws IOException 입출력 예외 발생 시 던짐
     * GETリクエストを処理するメソッド。退職処理リストを取得して画面に表示
     * @param request クライアントからのリクエスト情報
     * @param response サーバーからのレスポンス情報
     * @throws ServletException サーブレット関連の例外発生時にスロー
     * @throws IOException 入出力例外発生時にスロー 
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 요청에서 action 파라미터 값을 가져옴
        // リクエストからactionパラメータの値を取得
        String action = request.getParameter("action");

        try {
            if ("getByYear".equals(action)) {
                // 지급년도를 기준으로 조회
                // 支給年度に基づいて検索
                String yearParam = request.getParameter("year");
                
                if (yearParam != null && !yearParam.isEmpty()) { // 연도 값이 존재할 때
                                                                // 年度の値が存在する場合
                    try {
                        int year = Integer.parseInt(yearParam);  // 연도를 정수로 변환
                                                                // 年度を整数に変換
                        List<RetirementPaySlip> paySlips = retirementPaySlipService.getRetirementPaySlipsByYear(year);  // 서비스 호출
                                                                                                                         // サービス呼び出し
                        request.setAttribute("paySlips", paySlips); // 조회 결과를 요청 속성에 저장
                                                                    // 検索結果をリクエスト属性に保存
                    } catch (NumberFormatException e) {
                        // 연도가 잘못된 형식일 경우 오류 메시지 설정
                        // 年度の形式が不正な場合、エラーメッセージを設定
                        System.err.println("Invalid year format: " + yearParam);
                        request.setAttribute("error", "올바른 형식의 연도를 입력하세요.");
                    }
                } else {
                    // 연도 파라미터가 없거나 비어있을 경우 오류 메시지 설정
                    // 年度パラメータが存在しないか空の場合、エラーメッセージを設定
                    System.err.println("Year parameter is missing or empty.");
                    request.setAttribute("error", "연도를 입력하세요.");
                }

            } else if ("getDetails".equals(action)) {
                // 사원 ID를 기준으로 조회
                // 社員IDに基づいて検索
                String shainIdParam = request.getParameter("shain_id");
                
                if (shainIdParam != null && !shainIdParam.isEmpty()) { // 사원 ID 값이 존재할 때
                                                                      // 社員IDの値が存在する場合
                    try {
                        int shainId = Integer.parseInt(shainIdParam);  // 사원 ID를 정수로 변환
                                                                      // 社員IDを整数に変換
                        RetirementPaySlip paySlip = retirementPaySlipService.getRetirementPaySlipByShainId(shainId);  // 서비스 호출
                                                                                                                     // サービス呼び出し
                        
                        if (paySlip != null) {
                            request.setAttribute("paySlip", paySlip); // 조회된 퇴직급여 데이터를 요청 속성에 저장
                                                                       // 検索された退職給与データをリクエスト属性に保存
                        } else {
                            request.setAttribute("error", "해당 사원 번호의 데이터가 없습니다."); // 데이터가 없을 때 오류 메시지 설정
                                                                                      // データがない場合、エラーメッセージを設定
                        }
                    } catch (NumberFormatException e) {
                        // 사원 ID가 잘못된 형식일 경우 오류 메시지 설정
                        // 社員IDの形式が不正な場合、エラーメッセージを設定
                        System.err.println("Invalid shain_id format: " + shainIdParam);
                        request.setAttribute("error", "올바른 형식의 사원 번호를 입력하세요.");
                    }
                } else {
                    // 사원 ID 파라미터가 없거나 비어있을 경우 오류 메시지 설정
                    // 社員IDパラメータが存在しないか空の場合、エラーメッセージを設定
                    System.err.println("Shain ID parameter is missing or empty.");
                    request.setAttribute("error", "사원 번호를 입력하세요.");
                }
            }

            // 요청 속성을 설정한 후 JSP 페이지로 포워딩
            // リクエスト属性を設定後、JSPページにフォワード
            request.getRequestDispatcher("/view/RetirementManagement/retirementPaySlip.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("error.jsp");  // 오류 발생 시 에러 페이지로 리다이렉트
                                                // エラーが発生した場合、エラーページにリダイレクト
        }
    }
}
