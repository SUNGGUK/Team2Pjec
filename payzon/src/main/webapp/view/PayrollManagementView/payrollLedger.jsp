<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="java.util.List" %>
<%@ page import="menu.payroll.PayrollLedger.Service.PayrollLedgerService" %>
<%
    PayrollLedgerService service = new PayrollLedgerService();
    List<String[]> payrolls = service.getAllPayrolls();

    double totalPayment = 0;
    double totalDeduction = 0;
    double totalRealPayment = 0;
%>

<!DOCTYPE html>
<html>
<head>
    <title>給与台帳</title><!-- 급여대장 -->
    <script>
        function filterByYear() {
            const selectedYear = document.getElementById("yearSelect").value;
            // ページをリロードまたはAJAXを使用して選択した年の給与データを更新するロジックを追加してください。
            alert(selectedYear + " 年が選択されました。"); // 임시 알림
        }
    </script>
</head>
<body>
    <h1>給与台帳</h1>
    <p>月ごとの給与総額と社員別の給与支給状況をご覧いただけます。承認欄を作成して使用できます。</p>
    
    <label for="yearSelect">対象年の選択:</label>
    <select id="yearSelect" onchange="filterByYear()">
        <%
            int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
            for (int year = currentYear; year >= 2000; year--) {
        %>
            <option value="<%= year %>"><%= year %></option>
        <%
            }
        %>
    </select>
    <p>対象年を選択し、給与番号をクリックすると詳細情報を確認できます。</p>
    
	<table border="1">
        <tr>
            <th>対象年月</th> <!-- 귀속연월 -->
            <th>給与番号</th> <!-- 급여차수 -->
            <th>精算期間</th> <!-- 정산기간 -->
            <th>支給日</th> <!-- 지급일 -->
            <th>人数</th> <!-- 인원 -->
            <th>給与総額</th> <!-- 지급총액 -->
            <th>控除総額</th> <!-- 공제총액 -->
            <th>実支給額</th> <!-- 실지급액 -->
            <th>印刷</th> <!-- 인쇄 -->
            <th>削除</th> <!-- 삭제 -->
        </tr>
        <%
            for (String[] payroll : payrolls) {
                double totalShiharai = Double.parseDouble(payroll[6]);
                double totalKoujo = Double.parseDouble(payroll[7]);
                double realPayment = totalShiharai - totalKoujo;

                // 합계 계산
                totalPayment += totalShiharai;
                totalDeduction += totalKoujo;
                totalRealPayment += realPayment;
        %>
            <tr>
                <td><%= payroll[0] %></td> <!-- 귀속연월 -->
                <td><%= payroll[1] %></td> <!-- 급여차수 -->
                <td><%= payroll[2] %> - <%= payroll[3] %></td> <!-- 정산기간 -->
                <td><%= payroll[4] %></td> <!-- 지급일 -->
                <td><%= payroll[5] %></td> <!-- 인원 -->
                <td><%= totalShiharai %></td> <!-- 지급총액 -->
                <td><%= totalKoujo %></td> <!-- 공제총액 -->
                <td><%= realPayment %></td> <!-- 실지급액 -->
                <td><button onclick="window.print()">印刷</button></td> <!-- 인쇄 버튼 -->
                <td><button onclick="deleteRecord('<%= payroll[0] %>')">削除</button></td> <!-- 삭제 버튼 -->
            </tr>
        <%
            }
        %>
        <tr>
            <td>合計</td> <!-- 합계 -->
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td><%= totalPayment %></td> <!-- 지급총액 합계 -->
            <td><%= totalDeduction %></td> <!-- 공제총액 합계 -->
            <td><%= totalRealPayment %></td> <!-- 실지급액 합계 -->
            <td></td>
            <td></td>
        </tr>
    </table>
    <script>
        function deleteRecord(id) {
            if (confirm("本当に削除しますか？")) { // 삭제 확인
                // 삭제 로직을 추가하십시오.
                alert(id + " の項目が削除されました。"); // 삭제 알림
            }
        }
    </script>
</body>
</html>
