<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>퇴직급여명세서</title>
    <style>
        body { font-family: Arial, sans-serif; background-color: #f4f4f4; }
        .container { width: 80%; margin: 0 auto; }
        h2 { text-align: center; color: #333; }
        .controls { display: flex; justify-content: space-between; margin-bottom: 20px; }
        .employee-table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        .employee-table th, .employee-table td { border: 1px solid #ccc; padding: 8px; text-align: center; }
        .employee-table th { background-color: #003366; color: #ffffff; }
        .payslip-container { background-color: #ffffff; color: #333; padding: 20px; margin-top: 20px; border-radius: 8px; display: none; box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1); }
        .payslip-table { width: 100%; border-collapse: collapse; }
        .payslip-table th, .payslip-table td { border: 1px solid #ccc; padding: 8px; }
        .payslip-table th { background-color: #eee; text-align: left; }
        .btn { display: inline-block; padding: 10px 20px; margin: 10px 0; font-size: 16px; color: #fff; background-color: #007bff; border: none; border-radius: 4px; cursor: pointer; }
    </style>
</head>
<body>
    <div class="container">
        <h2>퇴직급여명세서</h2>

        <div class="controls">
            <div>
                <label for="yearFilter">지급년도:</label>
                <select id="yearFilter" onchange="filterByYear()">
                    <!-- JavaScript로 년도 옵션 추가 -->
                </select>
            </div>
            <div>
                <label for="searchShainId">사원번호:</label>
                <input type="text" id="searchShainId" placeholder="사원번호 입력">
                <button class="btn" onclick="searchByShainId()">검색</button>
            </div>
        </div>

        <table class="employee-table">
            <thead>
                <tr>
                    <th>구분</th>
                    <th>성명</th>
                    <th>실지급액</th>
                    <th>명세서</th>
                </tr>
            </thead>
            <tbody id="employeeTableBody">
                <!-- 직원 리스트가 여기에 표시됩니다 -->
            </tbody>
        </table>

        <div class="payslip-container" id="payslipContainer">
            <table class="payslip-table">
                <thead>
                    <tr>
                        <th colspan="4" style="text-align: center;">퇴직급여명세서</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <th>퇴직구분</th>
                        <td id="taishokuKubun"></td>
                        <th>성명</th>
                        <td id="shainNamae"></td>
                    </tr>
                    <tr>
                        <th>퇴직금</th>
                        <td id="taishokuKin"></td>
                        <th>지급일자</th>
                        <td id="paymentDate"></td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
    <script>
    const yearFilter = document.getElementById("yearFilter");
    const currentYear = new Date().getFullYear();
    for (let year = 2016; year <= currentYear; year++) {
        const option = document.createElement("option");
        option.value = year;
        option.text = year;
        yearFilter.appendChild(option);
    }
    yearFilter.value = currentYear;

    function filterByYear(year) {
        const selectedYear = year || yearFilter.value;
        fetch(`/retirement/paySlips.do?action=getByYear&year=${selectedYear}`)
            .then(response => response.json())
            .then(data => displayEmployees(data))
            .catch(error => console.error("지급년도 필터링 오류:", error));
    }

    function searchByShainId() {
        const shainId = document.getElementById("searchShainId").value;
        if (!shainId) {
            alert("사원번호를 입력하세요.");
            return;
        }
        fetch(`/retirement/paySlips.do?action=getDetails&shain_id=${shainId}`)
            .then(response => response.json())
            .then(data => data ? displayEmployees([data]) : alert("해당 사원번호의 정보를 찾을 수 없습니다."))
            .catch(error => console.error("사원번호 검색 오류:", error));
    }

    function displayEmployees(employees) {
        const tableBody = document.getElementById("employeeTableBody");
        tableBody.innerHTML = "";
        employees.forEach(employee => {
            const row = document.createElement("tr");
            row.innerHTML = `
                <td>${employee.taishoku_kubun}</td>
                <td>${employee.shain_namae}</td>
                <td>${employee.taishoku_kin}</td>
                <td><button class="btn" onclick="viewPaySlip(${employee.shain_ID})">보기</button></td>
            `;
            tableBody.appendChild(row);
        });
    }

    function viewPaySlip(shainId) {
        fetch(`/retirement/paySlips.do?action=getDetails&shain_id=${shainId}`)
            .then(response => response.json())
            .then(data => {
                if (data) {
                    document.getElementById("taishokuKubun").textContent = data.taishoku_kubun || "";
                    document.getElementById("shainNamae").textContent = data.shain_namae || "";
                    document.getElementById("taishokuKin").textContent = data.taishoku_kin || "";
                    document.getElementById("paymentDate").textContent = data.jitsu_shikyuu_gaku_bi || "";
                    document.getElementById("payslipContainer").style.display = "block";
                }
            })
            .catch(error => console.error("명세서 데이터를 가져오는 중 오류 발생:", error));
    }

    window.onload = function() {
        filterByYear(currentYear);
    };
    </script>
</body>
</html>
