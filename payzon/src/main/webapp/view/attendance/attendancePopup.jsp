<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>사원별 근태 기록</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .popup {
            padding: 20px;
            background-color: #fff;
            border: 1px solid #ccc;
            width: 600px;
            margin: auto;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f2f2f2;
        }
        .close-button {
            float: right;
            cursor: pointer;
        }
    </style>
</head>
<body>
    <div class="popup">
        <span class="close-button" onclick="window.close()">X</span>
        <h2>사원별 근태 기록</h2>
        <p>사원 번호: ${shain_id}</p>
        <p>성명: ${employeeName}</p>
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
            <tbody>
                <c:forEach var="record" items="${attendanceList}">
                    <tr>
                        <td>${record.kintai_kiroku_id}</td>
                        <td>${record.kintai_bi}</td>
                        <td>${record.kintai_shurui}</td>
                        <td>${record.start_date} ~ ${record.end_date}</td>
                        <td>${record.kintai_zikan}</td>
                        <td>${record.kinngaku}</td>
                        <td>${record.bikou}</td>
                        <td>
                            <button onclick="editRecord(${record.kintai_kiroku_id})">수정</button>
                            <button onclick="deleteRecord(${record.kintai_kiroku_id})">삭제</button>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <script>
        function editRecord(recordId) {
            // 여기에 수정 기능 구현
            alert("수정 기능은 아직 구현되지 않았습니다.");
        }

        function deleteRecord(recordId) {
            // 여기에 삭제 기능 구현
            if (confirm("이 근태 기록을 삭제하시겠습니까?")) {
                // 삭제 요청을 서버로 전송
                location.href = "${pageContext.request.contextPath}/attendance/delete.do?kintai_kiroku_id=" + recordId;
            }
        }
    </script>
</body>
</html>
