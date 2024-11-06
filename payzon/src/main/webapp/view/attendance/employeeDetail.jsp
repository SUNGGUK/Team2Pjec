<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>勤怠照会 - 詳細照会</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .container { width: 90%; margin: 20px auto; display: flex; }
        .filter-container { width: 30%; margin-right: 20px; }
        .filter-container label { display: block; margin-top: 10px; }
        .filter-container select, .filter-container input[type="text"], .filter-container input[type="date"] {
            width: 100%; padding: 5px; margin-top: 5px;
        }
        .filter-container button { width: 48%; padding: 10px; margin-top: 10px; font-size: 16px; }
        .table-container { width: 70%; overflow: auto; }
        table { width: 100%; border-collapse: collapse; margin-top: 10px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        .tab-container {
            display: flex;
            margin-bottom: 20px;
        }
        .tab-button {
            flex: 1;
            padding: 5px 10px;
            font-size: 14px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
            max-width: 100px;
        }
        .active-tab {
            background-color: #008b8b;
            color: white;
        }
        .inactive-tab {
            background-color: #f2f2f2;
            color: #333;
        }
    </style>
    <script>
    function applyClientSideFilters() {
        const inputDate = document.querySelector("input[name='inputDate']").value;
        const attendanceStartDate = document.querySelector("input[name='attendanceStartDate']").value;
        const attendanceEndDate = document.querySelector("input[name='attendanceEndDate']").value;
        const department = document.querySelector("select[name='department']").value;
        const employeeName = document.querySelector("input[name='employeeName']").value;
        const attendanceGroup = document.querySelector("select[name='attendanceGroup']").value;
        const attendanceItem = document.querySelector("select[name='attendanceItem']").value;
        const vacationItem = document.querySelector("select[name='vacationItem']").value;
        const note = document.querySelector("input[name='note']").value;

        const rows = document.querySelectorAll("tbody tr");

        rows.forEach(row => {
            const rowInputDate = row.querySelector(".inputDate")?.textContent.trim();
            const rowDepartment = row.querySelector(".department")?.textContent.trim();
            const rowEmployeeName = row.querySelector(".employeeName")?.textContent.trim();
            const rowAttendanceGroup = row.querySelector(".attendanceGroup")?.textContent.trim();
            const rowAttendanceItem = row.querySelector(".attendanceItem")?.textContent.trim();
            const rowVacationItem = row.querySelector(".vacationItem")?.textContent.trim();
            const rowNote = row.querySelector(".note")?.textContent.trim();

            let isMatch = true;

            if (inputDate && rowInputDate !== inputDate) isMatch = false;
            if (attendanceStartDate && rowInputDate < attendanceStartDate) isMatch = false;
            if (attendanceEndDate && rowInputDate > attendanceEndDate) isMatch = false;
            if (department && department !== rowDepartment) isMatch = false;
            if (employeeName && !rowEmployeeName.includes(employeeName)) isMatch = false;
            if (attendanceGroup && attendanceGroup !== rowAttendanceGroup) isMatch = false;
            if (attendanceItem && attendanceItem !== rowAttendanceItem) isMatch = false;
            if (vacationItem && vacationItem !== rowVacationItem) isMatch = false;
            if (note && !rowNote.includes(note)) isMatch = false;

            row.style.display = isMatch ? "" : "none";
        });
    }
    </script>
</head>
<body>
    <h2>勤怠照会</h2>
    <p>社員別の勤怠状況を一度にご覧いただけます。月別や詳細な勤怠内容も確認できます。</p>
    <div class="tab-container">
        <button class="tab-button inactive-tab" onclick="location.href='monthlyQuery.do';">月別照会</button>
        <button class="tab-button active-tab" onclick="location.href='detailedQuery.do';">詳細照会</button>
    </div>
    <div class="container">
        <div class="filter-container">
            <form id="filterForm" onsubmit="event.preventDefault(); applyClientSideFilters();">
                <label><input type="checkbox" name="inputDateCheck"> 入力日付:</label>
                <input type="date" name="inputDate">

                <label><input type="checkbox" name="attendancePeriodCheck"> 勤怠期間:</label>
                <input type="date" name="attendanceStartDate"> ~ 
                <input type="date" name="attendanceEndDate">

                <label><input type="checkbox" name="departmentCheck"> 部署:</label>
                <select name="department">
                    <option value="">選択してください</option>
                    <option value="社長室">社長室</option>
                    <option value="開発チーム">開発チーム</option>
                    <option value="コンテンツチーム">コンテンツチーム</option>
                    <option value="業務支援チーム">業務支援チーム</option>
                    <option value="デザインチーム">デザインチーム</option>
                    <option value="管理チーム">管理チーム</option>
                    <option value="企画戦略チーム">企画戦略チーム</option>
                </select>

                <label><input type="checkbox" name="employeeNameCheck"> 氏名:</label>
                <input type="text" name="employeeName" placeholder="氏名を入力してください。">

                <label><input type="checkbox" name="attendanceGroupCheck"> 勤怠グループ:</label>
                <select name="attendanceGroup">
                    <option value="">選択してください</option>
                    <option value="休暇">休暇</option>
                    <option value="延長勤務">延長勤務</option>
                    <option value="遅刻早退">遅刻早退</option>
                    <option value="特勤">特勤</option>
                    <option value="その他">その他</option>
                </select>

                <label><input type="checkbox" name="attendanceItemCheck"> 勤怠項目:</label>
                <select name="attendanceItem">
                    <option value="">選択してください</option>
                    <option value="年次休暇">年次休暇</option>
                    <option value="半日休暇">半日休暇</option>
                    <option value="遅刻">遅刻</option>
                    <option value="早退">早退</option>
                    <option value="外勤">外勤</option>
                    <option value="休日勤務">休日勤務</option>
                    <option value="延長勤務">延長勤務</option>
                    <option value="報奨休暇">報奨休暇</option>
                    <option value="夜勤">夜勤</option>
                    <option value="請願休暇">請願休暇</option>
                </select>

                <label><input type="checkbox" name="vacationItemCheck"> 休暇項目:</label>
                <select name="vacationItem">
                    <option value="">選択してください</option>
                    <option value="2014_年次休暇">2014_年次休暇</option>
                    <option value="2015_報奨休暇">2015_報奨休暇</option>
                    <option value="2015_年次休暇">2015_年次休暇</option>
                    <option value="2016_報奨休暇">2016_報奨休暇</option>
                    <option value="2016_年次休暇">2016_年次休暇</option>
                    <option value="2017_報奨休暇">2017_報奨休暇</option>
                    <option value="2017_年次休暇">2017_年次休暇</option>
                    <option value="2018_報奨休暇">2018_報奨休暇</option>
                </select>

                <label><input type="checkbox" name="noteCheck"> 備考:</label>
                <input type="text" name="note">

                <button type="button" onclick="applyClientSideFilters()">検索</button>
                <button type="reset" onclick="window.location.href='detailedQuery.do';">全体表示</button>
            </form>
        </div>

        <div class="table-container">
            <!-- フィルタリングされた結果を表示するテーブル -->
            <table>
                <thead>
                    <tr>
                        <th>入力日付</th>
                        <th>区分</th>
                        <th>氏名</th>
                        <th>部署</th>
                        <th>職位</th>
                        <th>勤怠項目</th>
                        <th>勤怠期間</th>
                        <th>勤怠日数</th>
                        <th>金額</th>
                        <th>備考</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="attendance" items="${employeeAttendance}">
                        <tr>
                            <td class="inputDate"><c:out value="${attendance.inputDate}" /></td>
                            <td class="category"><c:out value="${attendance.category}" /></td>
                            <td class="employeeName"><c:out value="${attendance.employeeName}" /></td>
                            <td class="department"><c:out value="${attendance.department}" /></td>
                            <td class="position"><c:out value="${attendance.position}" /></td>
                            <td class="attendanceItem"><c:out value="${attendance.attendanceItem}" /></td>
                            <td class="attendancePeriod"><c:out value="${attendance.attendancePeriod}" /></td>
                            <td class="attendanceDays"><c:out value="${attendance.attendanceDays}" /></td>
                            <td class="amount"><c:out value="${attendance.amount}" /></td>
                            <td class="note"><c:out value="${attendance.bikou}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>


<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>근태조회 - 상세 조회</title>
    <style>
        body { font-family: Arial, sans-serif; }
        .container { width: 90%; margin: 20px auto; display: flex; }
        .filter-container { width: 30%; margin-right: 20px; }
        .filter-container label { display: block; margin-top: 10px; }
        .filter-container select, .filter-container input[type="text"], .filter-container input[type="date"] {
            width: 100%; padding: 5px; margin-top: 5px;
        }
        .filter-container button { width: 48%; padding: 10px; margin-top: 10px; font-size: 16px; }
        .table-container { width: 70%; overflow: auto; }
        table { width: 100%; border-collapse: collapse; margin-top: 10px; }
        th, td { border: 1px solid #ddd; padding: 8px; text-align: center; }
        th { background-color: #f2f2f2; }
        .tab-container {
        display: flex;
        margin-bottom: 20px;
    }
    .tab-button {
        flex: 1;
        padding: 5px 10px; /* Reduced padding for a smaller button */
        font-size: 14px; /* Smaller font size */
        border: none;
        cursor: pointer;
        border-radius: 5px;
        max-width: 100px; /* Limit the maximum width to control the button size */
    }
    .active-tab {
        background-color: #008b8b; /* Active color */
        color: white;
    }
    .inactive-tab {
        background-color: #f2f2f2; /* Inactive color */
        color: #333;
    }
    </style>
    <script>
    function applyClientSideFilters() {
        // 각 필터 조건 값을 가져옵니다.
        const inputDate = document.querySelector("input[name='inputDate']").value;
        const attendanceStartDate = document.querySelector("input[name='attendanceStartDate']").value;
        const attendanceEndDate = document.querySelector("input[name='attendanceEndDate']").value;
        const department = document.querySelector("select[name='department']").value;
        const employeeName = document.querySelector("input[name='employeeName']").value;
        const attendanceGroup = document.querySelector("select[name='attendanceGroup']").value;
        const attendanceItem = document.querySelector("select[name='attendanceItem']").value;
        const vacationItem = document.querySelector("select[name='vacationItem']").value;
        const note = document.querySelector("input[name='note']").value;

        console.log("Filters - inputDate:", inputDate, "attendanceStartDate:", attendanceStartDate, "attendanceEndDate:", attendanceEndDate);
        console.log("Filters - department:", department, "employeeName:", employeeName, "attendanceGroup:", attendanceGroup);
        console.log("Filters - attendanceItem:", attendanceItem, "vacationItem:", vacationItem, "note:", note);

        // 필터링을 위해 테이블의 모든 행을 가져옵니다.
        const rows = document.querySelectorAll("tbody tr");

        rows.forEach(row => {
            const rowInputDate = row.querySelector(".inputDate")?.textContent.trim();
            const rowDepartment = row.querySelector(".department")?.textContent.trim();
            const rowEmployeeName = row.querySelector(".employeeName")?.textContent.trim();
            const rowAttendanceGroup = row.querySelector(".attendanceGroup")?.textContent.trim();
            const rowAttendanceItem = row.querySelector(".attendanceItem")?.textContent.trim();
            const rowVacationItem = row.querySelector(".vacationItem")?.textContent.trim();
            const rowNote = row.querySelector(".note")?.textContent.trim();

            let isMatch = true;

            if (inputDate && rowInputDate !== inputDate) isMatch = false;
            if (attendanceStartDate && rowInputDate < attendanceStartDate) isMatch = false;
            if (attendanceEndDate && rowInputDate > attendanceEndDate) isMatch = false;
            if (department && department !== rowDepartment) isMatch = false;
            if (employeeName && !rowEmployeeName.includes(employeeName)) isMatch = false;
            if (attendanceGroup && attendanceGroup !== rowAttendanceGroup) isMatch = false;
            if (attendanceItem && attendanceItem !== rowAttendanceItem) isMatch = false;
            if (vacationItem && vacationItem !== rowVacationItem) isMatch = false;
            if (note && !rowNote.includes(note)) isMatch = false;

            console.log(`Row ${row.rowIndex}: isMatch =`, isMatch);

            row.style.display = isMatch ? "" : "none";
        });
    }
    </script>

</head>
<body>
    <h2>근태조회</h2>
    <p>사원별 근태현황을 한 번에 보실 수 있습니다. 월별, 상세 근태내역도 확인할 수 있습니다.</p>
    <div class="tab-container">
        <button class="tab-button inactive-tab" onclick="location.href='monthlyQuery.do';">월별 조회</button>
        <button class="tab-button active-tab" onclick="location.href='detailedQuery.do';">상세 조회</button>
    </div>
    <div class="container">
        <div class="filter-container">
            <form id="filterForm" onsubmit="event.preventDefault(); applyClientSideFilters();">
                <label><input type="checkbox" name="inputDateCheck"> 입력일자:</label>
                <input type="date" name="inputDate">

                <label><input type="checkbox" name="attendancePeriodCheck"> 근태기간:</label>
                <input type="date" name="attendanceStartDate"> ~ 
                <input type="date" name="attendanceEndDate">

                <label><input type="checkbox" name="departmentCheck"> 부서:</label>
                <select name="department">
                    <option value="">선택하세요</option>
                    <option value="사장실">사장실</option>
                    <option value="개발팀">개발팀</option>
                    <option value="콘텐츠팀">콘텐츠팀</option>
                    <option value="업무지원팀">업무지원팀</option>
                    <option value="디자인팀">디자인팀</option>
                    <option value="관리팀">관리팀</option>
                    <option value="기획전략팀">기획전략팀</option>
                </select>

                <label><input type="checkbox" name="employeeNameCheck"> 성명:</label>
                <input type="text" name="employeeName" placeholder="성명을 입력하세요.">

                <label><input type="checkbox" name="attendanceGroupCheck"> 근태그룹:</label>
                <select name="attendanceGroup">
                    <option value="">선택하세요</option>
                    <option value="휴가">휴가</option>
                    <option value="연장근무">연장근무</option>
                    <option value="지각조퇴">지각조퇴</option>
                    <option value="특근">특근</option>
                    <option value="기타">기타</option>
                </select>

                <label><input type="checkbox" name="attendanceItemCheck"> 근태항목:</label>
                <select name="attendanceItem">
                    <option value="">선택하세요</option>
                    <option value="연차">연차</option>
                    <option value="반차">반차</option>
                    <option value="지각">지각</option>
                    <option value="조퇴">조퇴</option>
                    <option value="외근">외근</option>
                    <option value="휴일근무">휴일근무</option>
                    <option value="연장근무">연장근무</option>
                    <option value="포상휴가">포상휴가</option>
                    <option value="야간근무">야간근무</option>
                    <option value="청원휴가">청원휴가</option>
                </select>

                <label><input type="checkbox" name="vacationItemCheck"> 휴가항목:</label>
                <select name="vacationItem">
                    <option value="">선택하세요</option>
                    <option value="2014_연차">2014_연차</option>
                    <option value="2015_포상휴가">2015_포상휴가</option>
                    <option value="2015_연차">2015_연차</option>
                    <option value="2016_포상휴가">2016_포상휴가</option>
                    <option value="2016_연차">2016_연차</option>
                    <option value="2017_포상휴가">2017_포상휴가</option>
                    <option value="2017_연차">2017_연차</option>
                    <option value="2018_포상휴가">2018_포상휴가</option>
                </select>

                <label><input type="checkbox" name="noteCheck"> 적요:</label>
                <input type="text" name="note">

                <button type="button" onclick="applyClientSideFilters()">검색</button>
                <button type="reset" onclick="window.location.href='detailedQuery.do';">전체보기</button>
            </form>
        </div>

        <div class="table-container">
            <!-- 필터링된 결과를 표시하는 테이블 -->
            <table>
                <thead>
                    <tr>
                        <th>입력일자</th>
                        <th>구분</th>
                        <th>성명</th>
                        <th>부서</th>
                        <th>직위</th>
                        <th>근태항목</th>
                        <th>근태기간</th>
                        <th>근태일수</th>
                        <th>금액</th>
                        <th>적요</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="attendance" items="${employeeAttendance}">
                        <tr>
                            <td class="inputDate"><c:out value="${attendance.inputDate}" /></td>
                            <td class="category"><c:out value="${attendance.category}" /></td>
                            <td class="employeeName"><c:out value="${attendance.employeeName}" /></td>
                            <td class="department"><c:out value="${attendance.department}" /></td>
                            <td class="position"><c:out value="${attendance.position}" /></td>
                            <td class="attendanceItem"><c:out value="${attendance.attendanceItem}" /></td>
                            <td class="attendancePeriod"><c:out value="${attendance.attendancePeriod}" /></td>
                            <td class="attendanceDays"><c:out value="${attendance.attendanceDays}" /></td>
                            <td class="amount"><c:out value="${attendance.amount}" /></td>
                            <td class="note"><c:out value="${attendance.bikou}" /></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html> --%>