<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>退職手続き情報</title>
    <style>
        /* 모달 스타일 설정 */
        /* モーダルスタイルの設定 */
        #retirementModal {
            display: none;
            position: fixed;
            z-index: 1000;
            top: 50%;
            left: 50%;
            transform: translate(-50%, -50%);
            background-color: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 80%;
            height: 80%;
            max-width: 800px;
            max-height: 600px;
        }
        #modalBackdrop {
            display: none;
            position: fixed;
            z-index: 900;
            top: 0;
            left: 0;
            width: 100%;
            height: 100%;
            background-color: rgba(0, 0, 0, 0.5);
        }
        .selected-row {
            background-color: #ADD8E6; /* 하늘색 선택된 행 배경 */
            /* 選択された行の背景色(空色) */
        }
    </style>
</head>
<body>
    <div class="container">
        <h2>社員退職手続き</h2>
        
        <!-- 검색 필터 영역 -->
        <!-- 検索フィルターエリア -->
        <div class="filter-area">
            <form id="filterForm">
                <select id="status" name="status">
                    <option value="성명" ${param.status == '氏名' ? 'selected' : ''}>氏名</option>
                    <option value="사원번호" ${param.status == '社員番号' ? 'selected' : ''}>社員番号</option>
                    <option value="부서" ${param.status == '部署' ? 'selected' : ''}>部署</option>
                </select> 
                <input type="text" id="name" name="name" placeholder="検索語を入力してください。" value="${param.name}">
                <button type="button" onclick="filterEmployees()">検索</button>
                <button type="button" onclick="showAllEmployees()">全体表示</button>
            </form>
        </div>

        <!-- 사원 정보 테이블 -->
        <!-- 社員情報テーブル -->
        <table border="1" cellpadding="8" cellspacing="0" style="width: 100%; text-align: center;">
            <thead>
                <tr style="background-color: #003366; color: #ffffff;">
                    <th>番号</th>
                    <th>状態</th>
                    <th>社員番号</th>
                    <th>氏名</th>
                    <th>部署</th>
                    <th>職位</th>
                    <th>入社日</th>
                    <th>退職日</th>
                    <th>勤続研修</th>
                    <th>中間決済</th>
                    <th>退職決済</th>
                </tr>
            </thead>
            <tbody id="employeeTableBody">
                <c:forEach var="item" items="${list}" varStatus="status">
                    <tr 
                        onclick="selectRow(this)" 
                        ondblclick="showModalWithEmployeeInfo('${item.shain_ID}')"
                        style="cursor: pointer;"
                    >
                        <td>${status.index + 1}</td>
                        <td>${item.zyoutai}</td>
                        <td>${item.shain_ID}</td>
                        <td>${item.shain_namae}</td>
                        <td>${item.bu}</td>
                        <td>${item.yakushoku}</td>
                        <td>${item.nyuusha_bi}</td>
                        <td>${item.taishoku_bi}</td>
                        <td>${item.serviceDays}日</td>
                        <td>${item.chuukan_seisan_umu ? "✅" : "❌"}</td>
                        <td>${item.taishoku_seisan_umu ? "✅" : "❌"}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- 모달과 배경 -->
    <!-- モーダルと背景 -->
    <div id="modalBackdrop" onclick="closeRetirementModal()"></div>
    <div id="retirementModal">
        <h2>退社者退職処理のキャンセル</h2>
        <form id="retirementForm">
            <p>社員 ID: <span id="shain_ID"></span></p>
            <label for="retirementType">退職区分</label>
            <select id="retirementType" name="retirementType">
                <option value="">選択</option>
                <option value="定年退職">定年退職</option>
                <option value="解雇">解雇</option>
                <option value="自発的退職">自発的退職</option>
                <option value="役員退職">役員退職</option>
                <option value="中間決済">中間決済</option>
                <option value="以外">以外</option>
            </select>
            <label for="retirementDate">退職日</label>
            <input type="date" id="retirementDate" name="retirementDate">
            <label for="retirementReason">退職理由</label>
            <input type="text" id="retirementReason" name="retirementReason">
            <label for="postRetirementContact">退職後の連絡先</label>
            <input type="text" id="postRetirementContact" name="postRetirementContact">
            <button type="button" onclick="saveRetirementDetails()">保存</button>
            <button type="button" onclick="closeRetirementModal()">閉じる</button>
        </form>
    </div>
    
    <script>
        // 행을 선택 시 배경색 변경으로 강조 표시
        // 行を選択すると背景色が変わり強調表示
        function selectRow(row) {
            const selectedRow = document.querySelector(".selected-row");
            if (selectedRow) {
                selectedRow.classList.remove("selected-row");
            }
            row.classList.add("selected-row");
        }

        // 사원 ID에 따라 모달창 열기 및 데이터 불러오기
        // 社員IDに基づきモーダルを開きデータを取得
        function showModalWithEmployeeInfo(shainId) {
            document.getElementById("shain_ID").textContent = shainId;
            console.log("shainId:", shainId); // shainId가 올바르게 설정되어 있는지 확인
            // shainIdが正しく設定されているか確認
            fetch(`/retirement/getRetirementInfo?shain_id=${shainId}`, {
                method: 'GET'
            })
            .then(response => response.json())
            .then(data => {
                document.getElementById('retirementType').value = data.taishoku_kubun || "";
                document.getElementById('retirementDate').value = data.taishoku_bi || "";
                document.getElementById('retirementReason').value = data.taishoku_ziyuu || "";
                document.getElementById('postRetirementContact').value = data.taishoku_go_renrakusaki || "";

                document.getElementById("modalBackdrop").style.display = "block";
                document.getElementById("retirementModal").style.display = "block";
            })
            .catch(error => console.error("Error fetching retirement data:", error));
        }

        // 모달창 닫기
        // モーダルウィンドウを閉じる
        function closeRetirementModal() {
            document.getElementById("modalBackdrop").style.display = "none";
            document.getElementById("retirementModal").style.display = "none";
        }

        // 모달창의 입력 데이터를 서버에 저장
        // モーダルの入力データをサーバーに保存
        function saveRetirementDetails() {
            const shainId = document.getElementById("shain_ID").textContent;
            const retirementType = document.getElementById('retirementType').value;
            const retirementDate = document.getElementById('retirementDate').value;
            const retirementReason = document.getElementById('retirementReason').value;
            const postRetirementContact = document.getElementById('postRetirementContact').value;

            const data = new URLSearchParams();
            data.append("shain_id", shainId);
            data.append("taishoku_kubun", retirementType);
            data.append("taishoku_bi", retirementDate);
            data.append("taishoku_ziyuu", retirementReason);
            data.append("taishoku_go_renrakusaki", postRetirementContact);

            fetch('/retirement/saveRetirementDetails', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
                },
                body: data
            })
            .then(response => response.json())
            .then(result => {
                if (result.success) {
                    closeRetirementModal();
                    updateDisplayedData(result.data);
                } else {
                    console.error("데이터베이스 저장 실패:", result.error);
                }
            })
            .catch(error => console.error("데이터 전송 오류:", error));
        }

        // 사원 정보 필터링 기능
        // 社員情報のフィルタリング機能
        function filterEmployees() {
            const status = document.getElementById("status").value;
            const searchTerm = document.getElementById("name").value.toLowerCase();
            const rows = document.querySelectorAll("#employeeTableBody tr");

            rows.forEach(row => {
                const employeeName = row.querySelector("td:nth-child(4)").textContent.toLowerCase();
                const employeeId = row.querySelector("td:nth-child(3)").textContent.toLowerCase();
                const department = row.querySelector("td:nth-child(5)").textContent.toLowerCase();

                let isVisible = false;
                if (status === "성명") {
                    isVisible = employeeName.includes(searchTerm);
                } else if (status === "사원번호") {
                    isVisible = employeeId.includes(searchTerm);
                } else if (status === "부서") {
                    isVisible = department.includes(searchTerm);
                }

                row.style.display = isVisible ? "" : "none";
            });
        }

        // 전체 사원 정보 보기
        // 全社員情報を表示
        function showAllEmployees() {
            const rows = document.querySelectorAll("#employeeTableBody tr");
            rows.forEach(row => row.style.display = "");
            document.getElementById("name").value = "";  // 검색어 초기화
            // 検索語を初期化
        }

        // 모달창에 표시된 데이터 업데이트
        // モーダルに表示されたデータを更新
        function updateDisplayedData(data) {
            document.getElementById('retirementType').value = data.taishoku_kubun || "";
            document.getElementById('retirementDate').value = data.taishoku_bi || "";
            document.getElementById('retirementReason').value = data.taishoku_ziyuu || "";
            document.getElementById('postRetirementContact').value = data.taishoku_go_renrakusaki || "";
        }
    </script>
</body>
</html>
