<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>근태 기록 / 관리</title>
    <style>
        body {
        font-family: 'Arial', sans-serif;
        margin: 20px;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
    }

    .container {
        display: flex;
        gap: 20px;
    }

    .employee-list {
        width: 60%;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        border: 1px solid #ccc;
    }

    th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }

    th {
        background-color: #f0f0f0;
    }

    .attendance-management {
        width: 35%;
        padding: 20px;
        border: 1px solid #ccc;
        background-color: #f9f9f9;
        box-sizing: border-box;
    }

    .attendance-management label {
        display: inline-block;
        margin-bottom: 5px;
        font-weight: bold;
        width: 100px;
    }

    .attendance-management input[type="text"],
    .attendance-management input[type="date"],
    .attendance-management input[type="number"],
    .attendance-management select {
        width: calc(100% - 110px);
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box;
        display: inline-block;
    }

    .button-group {
        display: flex;
        align-items: center;
    }

    .popup, .overlay {
        display: none;
    }

    .popup {
        position: fixed;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: white;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        z-index: 10;
        width: 500px;
        max-width: 90%;
    }

    .overlay {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        z-index: 9;
    }

    .close {
        float: right;
        cursor: pointer;
        font-weight: bold;
    }
    </style>
</head>
<body>
    <h1>근태 기록 / 관리</h1>
    <div class="container">
        <!-- 사원 목록 -->
        <div class="employee-list">
            <table>
                <thead>
                    <tr>
                        <th>선택</th>
                        <th>구분</th>
                        <th>사원번호</th>
                        <th>성명</th>
                        <th>부서</th>
                        <th>직위</th>
                        <th>근태기록</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${employeeList}">
                        <tr>
                            <td><input type="checkbox" name="selectedEmployee" value="${employee.shain_id}"></td>
                            <td>${employee.employment_type}</td>
                            <td>No-${employee.shain_id}</td>
                            <td>${employee.shain_name}</td>
                            <td>${employee.department}</td>
                            <td>${employee.yakushoku}</td>
                            <td><button onclick="viewAttendance(${employee.shain_id})">관리</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

        <!-- 근태 기록 팝업 -->
        <div id="attendancePopup" class="popup">
            <span class="close" onclick="closeAllPopups()">X</span>
            <h3>사원별 근태 기록</h3>
            <table>
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>입력일자</th>
                        <th>근태항목</th>
                        <th>근태기간</th>
                        <th>근태일수</th>
                        <th>금액</th>
                        <th>적요</th>
                        <th>수정/삭제</th>
                    </tr>
                </thead>
                <tbody></tbody> <!-- 데이터를 여기에 표시 -->
            </table>
        </div>

        <div id="overlay" class="overlay" onclick="closeAllPopups();"></div>
    </div>

    <script>
    // 근태 기록 보기 함수
    function viewAttendance(shainId) {
        const requestUrl = `/attendanceManagement.do?action=viewAttendance&shain_id=${shainId}`;
        console.log("Request URL:", requestUrl);

        fetch(requestUrl)
            .then(response => response.json())
            .then(data => populateAttendancePopup(data))
            .catch(error => console.error('Error:', error));
    }

    // 팝업에 데이터 표시
    function populateAttendancePopup(data) {
        const popupBody = document.querySelector("#attendancePopup tbody");
        popupBody.innerHTML = ""; // 기존 내용을 초기화

        data.forEach(record => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${record.id}</td>
                <td>${record.inputDate}</td>
                <td>${record.attendanceType}</td>
                <td>${record.startDate} ~ ${record.endDate}</td>
                <td>${record.days}</td>
                <td>${record.amount}</td>
                <td>${record.description}</td>
                <td>
                    <button onclick="editAttendance(${record.id})">수정</button>
                    <button onclick="deleteAttendance(${record.id})">삭제</button>
                </td>
            `;
            popupBody.appendChild(row);
        });

        // 팝업과 오버레이 표시
        document.getElementById("attendancePopup").style.display = "block";
        document.getElementById("overlay").style.display = "block";
    }

    // 팝업 닫기 함수
    function closeAllPopups() {
        document.getElementById("attendancePopup").style.display = "none";
        document.getElementById("overlay").style.display = "none";
    }
    </script>
</body>
</html>
 --%>

<%-- <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>근태 기록 / 관리</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        margin: 20px;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
    }

    .container {
        display: flex;
        gap: 20px;
    }

    .employee-list {
        width: 60%;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        border: 1px solid #ccc;
    }

    th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }

    th {
        background-color: #f0f0f0;
    }

    .attendance-management {
        width: 35%;
        padding: 20px;
        border: 1px solid #ccc;
        background-color: #f9f9f9;
        box-sizing: border-box;
    }

    .attendance-management label {
        display: inline-block;
        margin-bottom: 5px;
        font-weight: bold;
        width: 100px;
    }

    .attendance-management input[type="text"],
    .attendance-management input[type="date"],
    .attendance-management input[type="number"],
    .attendance-management select {
        width: calc(100% - 110px);
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box;
        display: inline-block;
    }

    .button-group {
        display: flex;
        align-items: center;
    }

    .popup, .overlay {
        display: none;
    }

    .popup {
        position: fixed;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: white;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        z-index: 10;
        width: 500px;
        max-width: 90%;
    }

    .overlay {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        z-index: 9;
    }

    .close {
        float: right;
        cursor: pointer;
        font-weight: bold;
    }
</style>
</head>
<body>
    <h1>근태 기록 / 관리</h1>
    <p style="text-align: center;">급여와 연관된 근태 기록을 관리하는 메뉴입니다. 사원별 근태 내역을 관리하실 수 있습니다.</p>

    <div class="container">
        <div class="employee-list">
            <table>
                <thead>
                    <tr>
                        <th>선택</th>
                        <th>구분</th>
                        <th>사원번호</th>
                        <th>성명</th>
                        <th>부서</th>
                        <th>직위</th>
                        <th>근태기록</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${employeeList}">
                        <tr>
                            <td><input type="checkbox" name="selectedEmployee" value="${employee.shain_id}"></td>
                            <td>${employee.employment_type}</td>
                            <td>No-${employee.shain_id}</td>
                            <td>${employee.shain_name}</td>
                            <td>${employee.department}</td>
                            <td>${employee.yakushoku}</td>
                            <td><button onclick="viewAttendance(${employee.shain_id})">관리</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button type="button" onclick="viewLeaveStatus()">휴가현황</button>
        </div>

        <div class="attendance-management">
           <form>
				<label>입력일자:</label>
				<input type="date" id="inputDate"><br>
				
				<label>근태항목:</label>
				<select id="attendanceType">
					<option value="">선택하세요.</option>
					<option value="연차">연차</option>
				</select><br>
				
				<label>기간:</label>
				<input type="date" id="startDate"> ~ <input type="date" id="endDate"><br>
				
				<div class="button-group">
					<label>근태일수:</label>
					<input type="number" id="days">
				</div>

				<label>금액(수당):</label>
				<input type="text" id="amount"><br>
				
				<label>적요:</label>
				<input type="text" id="description"><br>
				
				<div class="button-group">
					<button type="button" onclick="saveAttendanceRecord()">저장</button>
					<button type="reset">내용 지우기</button>
				</div>
			</form>
        </div>
    </div>

    <div id="overlay" class="overlay" onclick="closeAllPopups();"></div>

    <div id="attendancePopup" class="popup">
        <span class="close" onclick="closeAllPopups()">X</span>
        <h3>사원별 근태 기록</h3>
        <table>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>입력일자</th>
                    <th>근태항목</th>
                    <th>근태기간</th>
                    <th>근태일수</th>
                    <th>금액</th>
                    <th>적요</th>
                    <th>수정/삭제</th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>

    <div id="leavePopup" class="popup">
        <span class="close" onclick="closeAllPopups()">X</span>
        <h3>휴가 일수 현황</h3>
        <table>
            <thead>
                <tr>
                    <th>구분</th>
                    <th>성명</th>
                    <th>직위</th>
                    <th>휴가항목</th>
                    <th>전체</th>
                    <th>사용</th>
                    <th>잔여</th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>

    <script>
    // Function to show the attendance popup when 'Manage' button is clicked
    function viewAttendance(shainId) {
    // Debugging log
    console.log("shainId received in viewAttendance function:", shainId);

    // Check if the shainId is valid
    if (!shainId) {
        alert("Invalid shainId: No employee ID received.");
        return;
    }

    // Construct the request URL
    const requestUrl = `/attendanceManagement.do?action=viewAttendance&shain_id=${shainId}`;
    console.log("Requesting URL:", requestUrl); // Log the request URL for debugging

    // Make the request
    fetch(requestUrl)
        .then(response => {
            if (!response.ok) {
                throw new Error("Network response was not ok");
            }
            return response.json();
        })
        .then(data => {
            console.log("Data received:", data); // Log the data for debugging
            populateAttendancePopup(data);
            document.getElementById("attendancePopup").style.display = "block";
            document.getElementById("overlay").style.display = "block";
        })
        .catch(error => {
            console.error('Error fetching attendance data:', error);
            alert('Failed to fetch attendance data. Please try again.');
        });
}


    function populateAttendancePopup(data) {
        const attendancePopupBody = document.querySelector("#attendancePopup tbody");
        attendancePopupBody.innerHTML = ""; // Clear existing rows

        data.forEach((record, index) => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${index + 1}</td>
                <td>${record.kintai_bi || ''}</td> <!-- Use correct field names here -->
                <td>${record.kintai_shurui || ''}</td>
                <td>${record.startDate || ''} ~ ${record.endDate || ''}</td>
                <td>${record.kintai_zikan || ''}</td>
                <td>${record.kinngaku || ''}</td>
                <td>${record.bikou || ''}</td>
                <td>
                    <button onclick="editAttendance(${record.kintai_kiroku_id})">Edit</button>
                    <button onclick="deleteAttendance(${record.kintai_kiroku_id})">Delete</button>
                </td>
            `;
            attendancePopupBody.appendChild(row);
        });
    }


function closeAllPopups() {
    document.getElementById("attendancePopup").style.display = "none";
    document.getElementById("overlay").style.display = "none";
}

    </script>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>勤怠記録 / 管理</title>
<style>
    body {
        font-family: 'Arial', sans-serif;
        margin: 20px;
    }

    h1 {
        text-align: center;
        margin-bottom: 20px;
    }

    .container {
        display: flex;
        gap: 20px;
    }

    .employee-list {
        width: 60%;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        border: 1px solid #ccc;
    }

    th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: center;
    }

    th {
        background-color: #f0f0f0;
    }

    .attendance-management {
        width: 35%;
        padding: 20px;
        border: 1px solid #ccc;
        background-color: #f9f9f9;
        box-sizing: border-box;
    }

    .attendance-management label {
        display: inline-block;
        margin-bottom: 5px;
        font-weight: bold;
        width: 100px;
    }

    .attendance-management input[type="text"],
    .attendance-management input[type="date"],
    .attendance-management input[type="number"],
    .attendance-management select {
        width: calc(100% - 110px);
        padding: 8px;
        margin-bottom: 10px;
        box-sizing: border-box;
        display: inline-block;
    }

    .button-group {
        display: flex;
        align-items: center;
    }

    .popup, .overlay {
        display: none;
    }

    .popup {
        position: fixed;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
        background-color: white;
        padding: 20px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        z-index: 10;
        width: 500px;
        max-width: 90%;
    }

    .overlay {
        position: fixed;
        top: 0;
        left: 0;
        width: 100%;
        height: 100%;
        background-color: rgba(0, 0, 0, 0.5);
        z-index: 9;
    }

    .close {
        float: right;
        cursor: pointer;
        font-weight: bold;
    }
</style>
</head>
<body>
    <h1>勤怠記録 / 管理</h1>
    <p style="text-align: center;">給与と関連する勤怠記録を管理するメニューです。社員別の勤怠内訳を管理できます。</p>

    <div class="container">
        <div class="employee-list">
            <table>
                <thead>
                    <tr>
                        <th>選択</th>
                        <th>区分</th>
                        <th>社員番号</th>
                        <th>氏名</th>
                        <th>部署</th>
                        <th>職位</th>
                        <th>勤怠記録</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="employee" items="${employeeList}">
                        <tr>
                            <td><input type="checkbox" name="selectedEmployee" value="${employee.shain_id}"></td>
                            <td>${employee.employment_type}</td>
                            <td>No-${employee.shain_id}</td>
                            <td>${employee.shain_name}</td>
                            <td>${employee.department}</td>
                            <td>${employee.yakushoku}</td>
                            <td><button onclick="viewAttendance(${employee.shain_id})">管理</button></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <button type="button" onclick="viewLeaveStatus()">休暇状況</button>
        </div>

        <div class="attendance-management">
           <form>
				<label>入力日付:</label>
				<input type="date" id="inputDate"><br>
				
				<label>勤怠項目:</label>
				<select id="attendanceType">
					<option value="">選択してください。</option>
					<option value="年次休暇">年次休暇</option>
				</select><br>
				
				<label>期間:</label>
				<input type="date" id="startDate"> ~ <input type="date" id="endDate"><br>
				
				<div class="button-group">
					<label>勤怠日数:</label>
					<input type="number" id="days">
				</div>

				<label>金額（手当）:</label>
				<input type="text" id="amount"><br>
				
				<label>備考:</label>
				<input type="text" id="description"><br>
				
				<div class="button-group">
					<button type="button" onclick="saveAttendanceRecord()">保存</button>
					<button type="reset">内容をクリア</button>
				</div>
			</form>
        </div>
    </div>

    <div id="overlay" class="overlay" onclick="closeAllPopups();"></div>

    <div id="attendancePopup" class="popup">
        <span class="close" onclick="closeAllPopups()">X</span>
        <h3>社員別勤怠記録</h3>
        <table>
            <thead>
                <tr>
                    <th>番号</th>
                    <th>入力日付</th>
                    <th>勤怠項目</th>
                    <th>勤怠期間</th>
                    <th>勤怠日数</th>
                    <th>金額</th>
                    <th>備考</th>
                    <th>修正/削除</th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>

    <div id="leavePopup" class="popup">
        <span class="close" onclick="closeAllPopups()">X</span>
        <h3>休暇日数状況</h3>
        <table>
            <thead>
                <tr>
                    <th>区分</th>
                    <th>氏名</th>
                    <th>職位</th>
                    <th>休暇項目</th>
                    <th>全体</th>
                    <th>使用</th>
                    <th>残り</th>
                </tr>
            </thead>
            <tbody></tbody>
        </table>
    </div>

    <script>
    function viewAttendance(shainId) {
        console.log("shainId received in viewAttendance function:", shainId);

        if (!shainId) {
            alert("Invalid shainId: No employee ID received.");
            return;
        }

        const requestUrl = `/attendanceManagement.do?action=viewAttendance&shain_id=${shainId}`;
        console.log("Requesting URL:", requestUrl);

        fetch(requestUrl)
            .then(response => {
                if (!response.ok) {
                    throw new Error("Network response was not ok");
                }
                return response.json();
            })
            .then(data => {
                console.log("Data received:", data);
                populateAttendancePopup(data);
                document.getElementById("attendancePopup").style.display = "block";
                document.getElementById("overlay").style.display = "block";
            })
            .catch(error => {
                console.error('Error fetching attendance data:', error);
                alert('勤怠データの取得に失敗しました。再試行してください。');
            });
    }

    function populateAttendancePopup(data) {
        const attendancePopupBody = document.querySelector("#attendancePopup tbody");
        attendancePopupBody.innerHTML = "";

        data.forEach((record, index) => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${index + 1}</td>
                <td>${record.kintai_bi || ''}</td>
                <td>${record.kintai_shurui || ''}</td>
                <td>${record.startDate || ''} ~ ${record.endDate || ''}</td>
                <td>${record.kintai_zikan || ''}</td>
                <td>${record.kinngaku || ''}</td>
                <td>${record.bikou || ''}</td>
                <td>
                    <button onclick="editAttendance(${record.kintai_kiroku_id})">編集</button>
                    <button onclick="deleteAttendance(${record.kintai_kiroku_id})">削除</button>
                </td>
            `;
            attendancePopupBody.appendChild(row);
        });
    }

    function closeAllPopups() {
        document.getElementById("attendancePopup").style.display = "none";
        document.getElementById("overlay").style.display = "none";
    }

    </script>
</body>
</html>
