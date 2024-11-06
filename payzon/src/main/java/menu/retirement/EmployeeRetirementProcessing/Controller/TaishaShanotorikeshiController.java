package menu.retirement.EmployeeRetirementProcessing.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import menu.retirement.EmployeeRetirementProcessing.Model.Taisha_shanotorikeshi;
import menu.retirement.EmployeeRetirementProcessing.Service.TaishaShanotorikeshiService;
import mvc.command.CommandHandler;

public class TaishaShanotorikeshiController implements CommandHandler {

    private TaishaShanotorikeshiService taishaService = new TaishaShanotorikeshiService();

    /**
     * 요청을 처리하여 퇴직 정보를 조회하거나 저장하는 메서드
     */
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        String method = request.getMethod();

        if ("GET".equalsIgnoreCase(method)) {
            processGetRequest(request, response, out);
        } else if ("POST".equalsIgnoreCase(method)) {
            processPostRequest(request, response, out);
        }

        return null; // JSP 페이지가 아닌 JSON 응답이므로 null 반환
    }

    private void processGetRequest(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws IOException {
        
        String shainIdParam = request.getParameter("shain_id");

        if (shainIdParam == null || shainIdParam.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\": \"Invalid shain_id parameter\"}");
            return;
        }
        
        try {
            int shainId = Integer.parseInt(shainIdParam);
            Taisha_shanotorikeshi taisha = taishaService.getTaishaShanotorikeshi(shainId);

            if (taisha == null) {
                taisha = new Taisha_shanotorikeshi(0, "", null, "", "");
            }

            out.print(convertToJson(taisha));
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"error\":\"Invalid shain_id format.\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"error\":\"Data retrieval error.\"}");
        } finally {
            out.flush();
            out.close();
        }
    }

    private void processPostRequest(HttpServletRequest request, HttpServletResponse response, PrintWriter out)
            throws IOException {

        String shainIdParam = request.getParameter("shain_id");
        String taishokuKubun = request.getParameter("taishoku_kubun");
        String taishokuBi = request.getParameter("taishoku_bi");
        String taishokuZiyuu = request.getParameter("taishoku_ziyuu");
        String taishokuGoRenrakusaki = request.getParameter("taishoku_go_renrakusaki");

        try {
            int shainId = Integer.parseInt(shainIdParam);
            Date retirementDate = Date.valueOf(taishokuBi);

            Taisha_shanotorikeshi taisha = new Taisha_shanotorikeshi(
                shainId, taishokuKubun, retirementDate, taishokuZiyuu, taishokuGoRenrakusaki
            );

            boolean isSaved = taishaService.saveTaishaShanotorikeshi(taisha);

            if (isSaved) {
                out.print("{\"success\": true, \"data\": " + convertToJson(taisha) + "}");
            } else {
                response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
                out.print("{\"success\": false, \"error\": \"Data save failed\"}");
            }
        } catch (NumberFormatException e) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            out.print("{\"success\": false, \"error\": \"Invalid shain_id format.\"}");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.print("{\"success\": false, \"error\": \"An error occurred\"}");
            e.printStackTrace();
        } finally {
            out.flush();
            out.close();
        }
    }

    private String convertToJson(Taisha_shanotorikeshi taisha) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");
        jsonBuilder.append("\"shain_ID\":").append(taisha.getShain_ID()).append(",");
        jsonBuilder.append("\"taishoku_kubun\":\"").append(escapeJson(taisha.getTaishoku_kubun())).append("\",");
        jsonBuilder.append("\"taishoku_bi\":\"").append(taisha.getTaishoku_bi() != null ? taisha.getTaishoku_bi().toString() : "").append("\",");
        jsonBuilder.append("\"taishoku_ziyuu\":\"").append(escapeJson(taisha.getTaishoku_ziyuu())).append("\",");
        jsonBuilder.append("\"taishoku_go_renrakusaki\":\"").append(escapeJson(taisha.getTaishoku_go_renrakusaki())).append("\"");
        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }

    private String escapeJson(String input) {
        if (input == null) return "";
        return input.replace("\"", "\\\"")
                    .replace("\\", "\\\\")
                    .replace("/", "\\/")
                    .replace("\b", "\\b")
                    .replace("\f", "\\f")
                    .replace("\n", "\\n")
                    .replace("\r", "\\r")
                    .replace("\t", "\\t");
    }
}

/*
 * package menu.retirement.EmployeeRetirementProcessing.Controller;
 * 
 * import java.io.IOException; import java.io.PrintWriter; import java.sql.Date;
 * 
 * import javax.servlet.ServletException; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import
 * menu.retirement.EmployeeRetirementProcessing.Model.Taisha_shanotorikeshi;
 * import menu.retirement.EmployeeRetirementProcessing.Service.
 * TaishaShanotorikeshiService;
 * 
 * public class TaishaShanotorikeshiController extends HttpServlet {
 * 
 * private static final long serialVersionUID = 1L; private
 * TaishaShanotorikeshiService taishaService = new
 * TaishaShanotorikeshiService();
 * 
 *//**
	 * GET 요청을 처리하여 특정 사원의 퇴직 정보를 조회하는 메서드 GETリクエストを処理して特定社員の退職情報を取得するメソッド
	 */
/*
 * @Override protected void doGet(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * response.setContentType("application/json");
 * response.setCharacterEncoding("UTF-8"); PrintWriter out =
 * response.getWriter();
 * 
 * // 요청 파라미터로부터 사원 ID를 가져옴 // リクエストパラメータから社員IDを取得 String shainIdParam =
 * request.getParameter("shain_id");
 * 
 * // 사원 ID가 제공되지 않은 경우 에러 응답 반환 // 社員IDが提供されていない場合はエラーレスポンスを返す if (shainIdParam
 * == null || shainIdParam.isEmpty()) {
 * response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 상태 반환 /
 * 400ステータスを返す
 * response.getWriter().write("{\"error\": \"Invalid shain_id parameter\"}");
 * return; }
 * 
 * try { // shain_id를 정수로 변환 // shain_idを整数に変換 int shainId =
 * Integer.parseInt(shainIdParam); Taisha_shanotorikeshi taisha =
 * taishaService.getTaishaShanotorikeshi(shainId);
 * 
 * // 만약 해당 사원의 퇴직 정보가 없을 경우 빈 객체 반환 // 該当社員の退職情報がない場合、空のオブジェクトを返す if (taisha ==
 * null) { taisha = new Taisha_shanotorikeshi(0, "", null, "", ""); }
 * 
 * // 퇴직 정보를 JSON으로 변환하여 출력 // 退職情報をJSON形式に変換して出力
 * out.print(convertToJson(taisha)); } catch (NumberFormatException e) { //
 * shain_id가 숫자로 변환할 수 없는 경우 400 상태 반환 // shain_idが数字に変換できない場合は400ステータスを返す
 * response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
 * out.print("{\"error\":\"Invalid shain_id format.\"}"); } catch (Exception e)
 * { // 기타 오류 발생 시 500 상태 반환 // その他のエラーが発生した場合は500ステータスを返す
 * response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
 * out.print("{\"error\":\"Data retrieval error.\"}"); } finally { out.flush();
 * // 버퍼에 남은 데이터를 출력 / バッファに残ったデータを出力 out.close(); // 출력 스트림 종료 / 出力ストリームを閉じる }
 * }
 * 
 *//**
	 * POST 요청을 처리하여 퇴직 정보를 저장하는 메서드 POSTリクエストを処理して退職情報を保存するメソッド
	 */
/*
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * response.setContentType("application/json");
 * response.setCharacterEncoding("UTF-8"); PrintWriter out =
 * response.getWriter();
 * 
 * // 요청 파라미터로부터 필요한 데이터들을 가져옴 // リクエストパラメータから必要なデータを取得 String shainIdParam =
 * request.getParameter("shain_id"); String taishokuKubun =
 * request.getParameter("taishoku_kubun"); String taishokuBi =
 * request.getParameter("taishoku_bi"); String taishokuZiyuu =
 * request.getParameter("taishoku_ziyuu"); String taishokuGoRenrakusaki =
 * request.getParameter("taishoku_go_renrakusaki");
 * 
 * try { // 사원 ID와 퇴직일자를 필요한 형식으로 변환 // 社員IDと退職日を必要な形式に変換 int shainId =
 * Integer.parseInt(shainIdParam); Date retirementDate =
 * Date.valueOf(taishokuBi);
 * 
 * // 퇴직 정보를 담은 객체 생성 // 退職情報を含むオブジェクトを生成 Taisha_shanotorikeshi taisha = new
 * Taisha_shanotorikeshi( shainId, taishokuKubun, retirementDate, taishokuZiyuu,
 * taishokuGoRenrakusaki );
 * 
 * // 퇴직 정보를 데이터베이스에 저장 // 退職情報をデータベースに保存 boolean isSaved =
 * taishaService.saveTaishaShanotorikeshi(taisha);
 * 
 * if (isSaved) { // 저장 성공 시 성공 메시지와 저장된 데이터를 JSON 형태로 응답 //
 * 保存成功時に成功メッセージと保存されたデータをJSON形式で応答 out.print("{\"success\": true, \"data\": " +
 * convertToJson(taisha) + "}"); } else { // 저장 실패 시 500 상태 반환 //
 * 保存失敗時に500ステータスを返す
 * response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
 * out.print("{\"success\": false, \"error\": \"Data save failed\"}"); } } catch
 * (NumberFormatException e) { // 사원 ID가 숫자 형식이 아닌 경우 400 상태 반환 //
 * 社員IDが数値形式でない場合は400ステータスを返す
 * response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
 * out.print("{\"success\": false, \"error\": \"Invalid shain_id format.\"}"); }
 * catch (Exception e) { // 기타 예외 발생 시 500 상태 반환 // その他の例外発生時に500ステータスを返す
 * response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
 * out.print("{\"success\": false, \"error\": \"An error occurred\"}");
 * e.printStackTrace(); // 예외 정보 출력 / 例外情報を出力 } finally { out.flush(); // 버퍼에 남은
 * 데이터를 출력 / バッファに残ったデータを出力 out.close(); // 출력 스트림 종료 / 出力ストリームを閉じる } }
 * 
 *//**
	 * Taisha_shanotorikeshi 객체를 JSON 문자열로 변환하는 메서드
	 * Taisha_shanotorikeshiオブジェクトをJSON文字列に変換するメソッド
	 */
/*
 * private String convertToJson(Taisha_shanotorikeshi taisha) { StringBuilder
 * jsonBuilder = new StringBuilder(); jsonBuilder.append("{");
 * jsonBuilder.append("\"shain_ID\":").append(taisha.getShain_ID()).append(",");
 * jsonBuilder.append("\"taishoku_kubun\":\"").append(escapeJson(taisha.
 * getTaishoku_kubun())).append("\",");
 * jsonBuilder.append("\"taishoku_bi\":\"").append(taisha.getTaishoku_bi() !=
 * null ? taisha.getTaishoku_bi().toString() : "").append("\",");
 * jsonBuilder.append("\"taishoku_ziyuu\":\"").append(escapeJson(taisha.
 * getTaishoku_ziyuu())).append("\",");
 * jsonBuilder.append("\"taishoku_go_renrakusaki\":\"").append(escapeJson(taisha
 * .getTaishoku_go_renrakusaki())).append("\""); jsonBuilder.append("}"); return
 * jsonBuilder.toString(); }
 * 
 *//**
	 * JSON 문자열에서 특수 문자를 이스케이프 처리하는 메서드 JSON文字列内の特殊文字をエスケープ処理するメソッド
	 *//*
		 * private String escapeJson(String input) { if (input == null) return "";
		 * return input.replace("\"", "\\\"") // 큰따옴표 이스케이프 처리 / ダブルクォートのエスケープ処理
		 * .replace("\\", "\\\\") // 역슬래시 이스케이프 처리 / バックスラッシュのエスケープ処理 .replace("/",
		 * "\\/") // 슬래시 이스케이프 처리 / スラッシュのエスケープ処理 .replace("\b", "\\b") // 백스페이스 이스케이프
		 * 처리 / バックスペースのエスケープ処理 .replace("\f", "\\f") // 폼피드 이스케이프 처리 / フォームフィードのエスケープ処理
		 * .replace("\n", "\\n") // 개행 이스케이프 처리 / 改行のエスケープ処理 .replace("\r", "\\r") //
		 * 캐리지 리턴 이스케이프 처리 / キャリッジリターンのエスケープ処理 .replace("\t", "\\t"); // 탭 이스케이프 처리 /
		 * タブのエスケープ処理 } }
		 */