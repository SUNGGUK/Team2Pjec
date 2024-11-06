<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ page import="menu.payroll.PayrollInputManagement.Controller.PayrollInputController" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>給与入力/管理</title> <!-- 급여 입력/관리 (給与入力/管理) -->
    <link rel="stylesheet" type="text/css" href="styles.css">
    <style>
        body {
            display: flex;
            justify-content: space-between;
        }

        .left-table {
            flex: 1;
            margin-right: 20px; // 여백 (余白)
        }

        .right-tables {
            display: flex;
            justify-content: space-between;
            width: 600px;
            margin-left: 20px; // 여백 (余白)
        }

        .right-table {
            border: 1px solid #ccc; // 테두리 (境界線)
            padding: 10px; // 패딩 (パディング)
            width: 48%;
        }

        table {
            width: 100%; // 테이블 너비 (テーブルの幅)
            border-collapse: collapse; // 테이블 경계 합치기 (テーブルの境界結合)
        }

        tr {
            cursor: pointer; // 마우스 커서 포인터 (マウスカーソル)
        }

        tr:hover {
            background-color: #f1f1f1; // 마우스 오버 시 배경색 변경 (マウスオーバー時の背景色)
        }

        td {
            padding: 10px; // 셀 패딩 (セルのパディング)
            border: 1px solid #ccc; // 셀 테두리 (セルの境界線)
            text-align: center; // 텍스트 중앙 정렬 (テキストの中央揃え)
        }

        h2 {
            text-align: center; // 제목 중앙 정렬 (タイトルの中央揃え)
        }
    </style>
</head>
<body>

<div class="left-table">
    <h1>給与入力/管理</h1> <!-- 급여 입력/관리 (給与入力/管理) -->
    <p>月別、社員別給与およびボーナス情報を入力、保存、管理するメニューです。帰属年月、給与次数を確認してください！</p>

    <%
        // PayrollInputController 인스턴스 생성 및 전체 급여 정보 조회 (PayrollInputControllerインスタンス作成と全給与情報取得)
        PayrollInputController controller = new PayrollInputController();
        List<String[]> payrollData = controller.getAllPayrolls();
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
    <button type="button">新規追加</button> <!-- 신규 추가 (新規追加) -->
    <button type="button">選択削除</button> <!-- 선택 삭제 (選択削除) -->
    <button type="button">全体削除</button> <!-- 전체 삭제 (全体削除) -->
</div>
    <% if (payrollData != null && !payrollData.isEmpty()) { %>
        <table border="1">
            <thead>
                <tr>
                    <th>区分</th> <!-- 구분 (区分) -->
                    <th>社員名</th> <!-- 사원 이름 (社員名) -->
                    <th>部署</th> <!-- 부서 (部署) -->
                    <th>支給総額</th> <!-- 지급 총액 (支給総額) -->
                    <th>控除総額</th> <!-- 공제 총액 (控除総額) -->
                    <th>実支給額</th> <!-- 실 지급액 (実支給額) -->
                </tr>
            </thead>
            <tbody>
                <% for (String[] row : payrollData) { 
                    double shikyuuzoukyuu = Double.parseDouble(row[3]); // 지급 총액 (支給総額)
                    double koujo_sougaku = Double.parseDouble(row[4]); // 공제 총액 (控除総額)
                    double shiji_kingaku = shikyuuzoukyuu - koujo_sougaku; // 실 지급액 계산 (実支給額計算)
                %>
                    <tr onclick="location.href='your_target_page.jsp?shainId=<%= row[0] %>';">
                        <td><%= row[0] %></td> <!-- 사원 ID (社員ID) -->
                        <td><%= row[1] %></td> <!-- 사원 이름 (社員名) -->
                        <td><%= row[2] %></td> <!-- 부서 (部署) -->
                        <td><%= shikyuuzoukyuu %></td> <!-- 지급 총액 (支給総額) -->
                        <td><%= koujo_sougaku %></td> <!-- 공제 총액 (控除総額) -->
                        <td><%= shiji_kingaku %></td> <!-- 실 지급액 (実支給額) -->
                    </tr>
                <% } %>
            </tbody>
        </table>
    <% } else if (payrollData != null) { %>
        <p>給与情報がありません。</p> <!-- 급여 정보가 없습니다 (給与情報がありません) -->
    <% } %>
</div>

<div class="right-tables">
    <div class="right-table">
        <h2>支給項目</h2> <!-- 지급 항목 (支給項目) -->
        <table border="1">
            <thead>
                <tr>
                    <th>項目名</th> <!-- 항목 이름 (項目名) -->
                    <th>金額</th> <!-- 금액 (金額) -->
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>基本給</td> <!-- 기본급 (基本給) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>食費</td> <!-- 식비 (食費) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>保育手当</td> <!-- 보육수당 (保育手当) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>職責手当</td> <!-- 직책수당 (職責手当) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>車両維持費</td> <!-- 차량유지비 (車両維持費) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>勤続手当</td> <!-- 근속수당 (勤続手当) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>当直手当</td> <!-- 당직수당 (当直手当) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>賞与</td> <!-- 상여금 (賞与) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>休日手当</td> <!-- 휴일수당 (休日手当) -->
                    <td><input type="number" value="0" /></td>
                </tr>
            </tbody>
        </table>
    </div>

    <div class="right-table">
        <h2>控除項目</h2> <!-- 공제 항목 (控除項目) -->
        <table border="1">
            <thead>
                <tr>
                    <th>項目名</th> <!-- 항목 이름 (項目名) -->
                    <th>金額</th> <!-- 금액 (金額) -->
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>国民年金</td> <!-- 국민연금 (国民年金) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>健康保険</td> <!-- 건강보험 (健康保険) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>長期介護保険</td> <!-- 장기요양보험 (長期介護保険) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>雇用保険</td> <!-- 고용보험 (雇用保険) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>所得税</td> <!-- 소득세 (所得税) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>地方所得税</td> <!-- 지방소득세 (地方所得税) -->
                    <td><input type="number" value="0" /></td>
                </tr>
                <tr>
                    <td>相互扶助費</td> <!-- 상호부조비 (相互扶助費) -->
                    <td><input type="number" value="0" /></td>
                </tr>
            </tbody>
        </table>
    </div>
</div>

</body>
</html>
