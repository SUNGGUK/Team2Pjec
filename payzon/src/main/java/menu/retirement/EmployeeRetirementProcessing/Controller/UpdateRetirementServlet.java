package menu.retirement.EmployeeRetirementProcessing.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jdbc.connection.ConnectionProvider;
import menu.retirement.EmployeeRetirementProcessing.DAO.RetirementProcessingDAO;
import menu.retirement.EmployeeRetirementProcessing.Model.RetirementProcessing;
import mvc.command.CommandHandler;

public class UpdateRetirementServlet implements CommandHandler {

    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("application/json");

        StringBuilder jsonBuilder = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                jsonBuilder.append(line);
            }
        }

        String jsonString = jsonBuilder.toString();
        RetirementProcessing retirementData = new RetirementProcessing();

        // JSON 데이터에서 값 추출하여 설정
        retirementData.setShain_ID(extractIntValue(jsonString, "shain_ID"));
        retirementData.setZyoutai(extractStringValue(jsonString, "zyoutai"));
        retirementData.setTaishoku_bi(java.sql.Date.valueOf(extractStringValue(jsonString, "taishoku_bi")));
        retirementData.setTaishoku_kubun(extractStringValue(jsonString, "taishoku_kubun"));
        retirementData.setChuukan_seisan_umu(Boolean.parseBoolean(extractStringValue(jsonString, "chuukan_seisan_umu")));
        retirementData.setTaishoku_seisan_umu(Boolean.parseBoolean(extractStringValue(jsonString, "taishoku_seisan_umu")));

        try (Connection conn = ConnectionProvider.getConnection()) {
            RetirementProcessingDAO dao = new RetirementProcessingDAO();
            dao.update(conn, retirementData);

            response.getWriter().write("{\"success\": true}");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("{\"success\": false, \"error\": \"" + e.getMessage() + "\"}");
        }
        
        return null; // JSON 응답을 사용하므로 null 반환
    }

    private String extractStringValue(String jsonString, String key) {
        String search = "\"" + key + "\":\"";
        int start = jsonString.indexOf(search) + search.length();
        int end = jsonString.indexOf("\"", start);
        return jsonString.substring(start, end);
    }

    private int extractIntValue(String jsonString, String key) {
        String search = "\"" + key + "\":";
        int start = jsonString.indexOf(search) + search.length();
        int end = jsonString.indexOf(",", start);
        if (end == -1) end = jsonString.indexOf("}", start);
        return Integer.parseInt(jsonString.substring(start, end).trim());
    }
}


/*
 * package menu.retirement.EmployeeRetirementProcessing.Controller;
 * 
 * import java.io.BufferedReader; import java.io.IOException; import
 * java.sql.Connection;
 * 
 * import javax.servlet.ServletException; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse;
 * 
 * import jdbc.connection.ConnectionProvider; import
 * menu.retirement.EmployeeRetirementProcessing.DAO.RetirementProcessingDAO;
 * import
 * menu.retirement.EmployeeRetirementProcessing.Model.RetirementProcessing;
 * 
 * public class UpdateRetirementServlet extends HttpServlet { private static
 * final long serialVersionUID = 1L;
 * 
 * @Override protected void doPost(HttpServletRequest request,
 * HttpServletResponse response) throws ServletException, IOException {
 * response.setContentType("application/json");
 * 
 * StringBuilder jsonBuilder = new StringBuilder(); try (BufferedReader reader =
 * request.getReader()) { String line; while ((line = reader.readLine()) !=
 * null) { jsonBuilder.append(line); } }
 * 
 * String jsonString = jsonBuilder.toString(); RetirementProcessing
 * retirementData = new RetirementProcessing();
 * 
 * // JSON 데이터에서 값 추출하여 설정
 * retirementData.setShain_ID(extractIntValue(jsonString, "shain_ID"));
 * retirementData.setZyoutai(extractStringValue(jsonString, "zyoutai"));
 * retirementData.setTaishoku_bi(java.sql.Date.valueOf(extractStringValue(
 * jsonString, "taishoku_bi")));
 * retirementData.setTaishoku_kubun(extractStringValue(jsonString,
 * "taishoku_kubun"));
 * retirementData.setChuukan_seisan_umu(Boolean.parseBoolean(extractStringValue(
 * jsonString, "chuukan_seisan_umu")));
 * retirementData.setTaishoku_seisan_umu(Boolean.parseBoolean(extractStringValue
 * (jsonString, "taishoku_seisan_umu")));
 * 
 * try (Connection conn = ConnectionProvider.getConnection()) {
 * RetirementProcessingDAO dao = new RetirementProcessingDAO(); dao.update(conn,
 * retirementData); // retirementData 전달
 * 
 * response.getWriter().write("{\"success\": true}"); } catch (Exception e) {
 * e.printStackTrace();
 * response.getWriter().write("{\"success\": false, \"error\": \"" +
 * e.getMessage() + "\"}"); } }
 * 
 * private String extractStringValue(String jsonString, String key) { String
 * search = "\"" + key + "\":\""; int start = jsonString.indexOf(search) +
 * search.length(); int end = jsonString.indexOf("\"", start); return
 * jsonString.substring(start, end); }
 * 
 * private int extractIntValue(String jsonString, String key) { String search =
 * "\"" + key + "\":"; int start = jsonString.indexOf(search) + search.length();
 * int end = jsonString.indexOf(",", start); if (end == -1) end =
 * jsonString.indexOf("}", start); return
 * Integer.parseInt(jsonString.substring(start, end).trim()); } }
 */