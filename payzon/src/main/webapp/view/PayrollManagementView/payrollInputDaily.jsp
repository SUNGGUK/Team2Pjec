<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="menu.payroll.PayrollInputManagementforDailyWorkers.Controller.PayrollInputDailyController"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>給与入力/管理(日雇い)</title> <!-- 급여입력/관리(일용직) -->
<link rel="stylesheet" type="text/css" href="styles.css">

</head>
<body>

	<div class="left-table">
		<h1>給与入力/管理(日雇い)</h1> <!-- 급여입력/관리(일용직) -->

		<%
		// 日雇い給与入力管理コントローラのインスタンスを生成 (일용직 급여 입력 관리 컨트롤러 인스턴스 생성)
		PayrollInputDailyController controller = new PayrollInputDailyController();
		// すべての給与データを取得 (모든 급여 데이터를 가져옴)
		List<String[]> payrollData = controller.getAllPayrolls(); // List import가 필요합니다.
		%>

		<%
		// 給与データが空でない場合 (급여 데이터가 비어있지 않은 경우)
		if (payrollData != null && !payrollData.isEmpty()) {
		%>
		<div class="controls">
    <label for="year">適用年</label> <!-- 귀속연도 (適用年) -->
    <select id="year" name="year">
        <% for (int i = 2020; i <= 2030; i++) { %> <!-- 2020년부터 2030년까지의 연도를 선택할 수 있도록 설정 -->
            <option value="<%= i %>"><%= i %></option>
        <% } %>
    </select>

    <label for="month">適用月</label> <!-- 귀속월 (適用月) -->
    <select id="month" name="month">
        <% for (int i = 1; i <= 12; i++) { %> <!-- 1월부터 12월까지의 월을 선택할 수 있도록 설정 -->
            <option value="<%= i %>"><%= i %></option>
        <% } %>
    </select>

    <label for="payrollCycle">給与回数</label> <!-- 급여차수 (給与回数) -->
    <select id="payrollCycle" name="payrollCycle">
        <option value="1">1回目</option>
        <option value="2">2回目</option>
        <option value="3">3回目</option>
    </select>
    
    <label for="settlementStart">精算期間</label> <!-- 정산기간 시작일 (精算期間開始日) -->
    <input type="date" id="settlementStart" name="settlementStart">

    <label for="settlementEnd">~</label> <!-- 정산기간 종료일 (精算期間終了日) -->
    <input type="date" id="settlementEnd" name="settlementEnd">

    <label for="payrollDate">給与支給日</label> <!-- 급여 지급일 (給与支給日) -->
    <input type="date" id="payrollDate" name="payrollDate">
</div>
<div class="button-group">
    <button type="button">過去給与の呼び出し</button> <!-- 지난급여 불러오기 (過去給与の呼び出し) -->
    <button type="button">選択削除</button> <!-- 선택 삭제 (選択削除) -->
    <button type="button">全体削除</button> <!-- 전체 삭제 (全体削除) -->
</div>
		<table border="1">
			<thead>
				<tr>
					<th>区分</th> <!-- 구분 -->
					<th>社員名</th> <!-- 사원 이름 -->
					<th>部署</th> <!-- 부서 -->
					<th>実支給額</th> <!-- 실지급액 -->
				</tr>
			</thead>
			<tbody>
				<%
				// 各行を繰り返してデータを出力 (각 행을 반복하여 데이터 출력)
				for (String[] row : payrollData) {
					double shikyuuzoukyuu = Double.parseDouble(row[3]);
					double koujo_sougaku = Double.parseDouble(row[4]);
					double shiji_kingaku = shikyuuzoukyuu - koujo_sougaku; // 実支給額の計算 (실지급액 계산)
				%>
				<tr>
					<td><%=row[0]%></td>
					<td><%=row[1]%></td>
					<td><%=row[2] %></td>
					<td><%=shiji_kingaku%></td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<%
		} else if (payrollData != null) {
		%>
		<p>給与情報がありません。</p> <!-- 급여 정보가 없습니다. -->
		<%
		}
		%>
	</div>

	<div class="right-table">
		<h2>詳細情報</h2> <!-- 세부 정보 -->
		<table border="1">
			<thead>
				<tr>
					<th>日付</th> <!-- 일자 -->
					<th>支給率</th> <!-- 지급율 -->
					<th>支給額</th> <!-- 지급액 -->
					<th>所得税</th> <!-- 소득세 -->
					<th>地方所得税</th> <!-- 지방소득세 -->
					<th>公租項目</th> <!-- 공제항목 -->
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>00000-00-00</td>
					<td>1.0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>国民年金 <input type="text" name="gukminyeonggeun" value="0"></td> <!-- 국민연금 텍스트 박스 추가 -->
				</tr>
				<tr>
					<td>00000-00-00</td>
					<td>1.0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>健康保険 <input type="text" name="geongangboheom" value="0"></td> <!-- 건강보험 텍스트 박스 추가 -->
				</tr>
				<tr>
					<td>00000-00-00</td>
					<td>1.0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>介護保険 <input type="text" name="janggiyoyangboheom" value="0"></td> <!-- 장기요양보험 텍스트 박스 추가 -->
				</tr>
				<tr>
					<td>00000-00-00</td>
					<td>1.0</td> 
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>雇用保険 <input type="text" name="goeumboheom" value="0"></td> <!-- 고용보험 텍스트 박스 추가 -->
				</tr>
				<tr>
					<td>00000-00-00</td>
					<td>1.0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>所得税 <input type="text" name="soodeukse" value="0"></td> <!-- 소득세 텍스트 박스 추가 -->
				</tr>
				<tr>
					<td>00000-00-00</td>
					<td>1.0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>地方所得税 <input type="text" name="jibangsoodeukse" value="0"></td> <!-- 지방소득세 텍스트 박스 추가 -->
				</tr>
				<tr>
					<td>00000-00-00</td>
					<td>1.0</td>
					<td>0</td>
					<td>0</td>
					<td>0</td>
					<td>互助会費 <input type="text" name="sanghojwi" value="0"></td> <!-- 상조회비 텍스트 박스 추가 -->
				</tr>
			</tbody>
		</table>
	</div>

</body>
</html>
