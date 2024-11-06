<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>근태 조회</title>
    <style>
        body { font-family: Arial, sans-serif; }
        
        /* 전체 컨테이너 스타일 */
        .container {
            width: 90%;
            margin: 20px auto;
        }
        
        /* 버튼 스타일 */
        .tab-container {
            display: flex;
            margin-bottom: 10px;
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

        /* 필터 영역 스타일 */
        .filter-container {
            display: flex;
            align-items: center;
            gap: 10px;
            flex-wrap: wrap;
            margin-bottom: 20px;
        }
        .filter-container label {
            font-size: 14px;
            margin-right: 5px;
        }
        .filter-container select {
            padding: 5px;
            font-size: 14px;
            width: auto;
        }
        
        /* 테이블 스타일 */
        .table-container {
            width: 100%;
            overflow: auto;
        }
        .e_total ul {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            flex-wrap: wrap;
        }
        .e_total .date ul {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            flex-wrap: wrap;
        }
        .e_total .w_24 {
            width: 24px;
            height: 24px;
            text-align: center;
            line-height: 24px;
            border: 1px solid #ddd;
        }
        .e_total .bb_blue { color: blue; }
        .e_total .bb_red { color: red; }
        .e_total .c_red { color: red; font-weight: bold; }
        .w_88 { width: 88px; }
        .w_70 { width: 70px; }
        .w_92 { width: 92px; }
        .w_199 { width: 199px; }
        .w_100 { width: 100px; }
        .b_none { border-right: none; }
        .ulDiligenceList {
            display: flex;
            align-items: center;
            margin-top: 5px;
        }
        .clsCheck {
            display: flex;
        }
    </style>
</head>
<body>
    <h2>勤怠照会</h2>
    <p>社員別の勤怠状況を一度にご覧いただけます。月別や詳細な勤怠内容も 확인できます.</p>
    <div class="tab-container">
        <button class="tab-button active-tab" onclick="location.href='monthlyQuery.do';">월별 조회</button>
        <button class="tab-button inactive-tab" onclick="location.href='detailedQuery.do';">상세 조회</button>
    </div>

    <div class="filter-container">
        <label>연도: 
            <select name="year">
                <c:forEach var="y" begin="2013" end="2024">
                    <option value="${y}" ${y == 2024 ? 'selected' : ''}>${y}</option>
                </c:forEach>
            </select>
        </label>
        <label>월: 
            <select name="month">
                <c:forEach var="m" begin="1" end="12">
                    <option value="${m}" ${m == 11 ? 'selected' : ''}>${m}</option>
                </c:forEach>
            </select>
        </label>
        <button type="submit">조회</button>
    </div>

    <div class="table-container e_total">
        <!-- Header -->
        <ul class="height_53">
            <li class="w_88">구분</li>
            <li class="w_88"><strong>사원번호</strong></li>
            <li class="w_70"><strong>성명</strong></li>
            <li class="w_92"><strong>부서</strong></li>
            <li class="w_88 b_none"><strong>직위</strong></li>
            <li style="padding-top:0px;">
                <div class="date">
                    <ul>
                        <c:forEach var="day" begin="1" end="16">
                            <li class="w_24">
                                <c:choose>
                                    <c:when test="${day % 7 == 6}"><span class="bb_blue">${day}</span></c:when>
                                    <c:when test="${day % 7 == 0}"><span class="bb_red">${day}</span></c:when>
                                    <c:otherwise>${day}</c:otherwise>
                                </c:choose>
                            </li>
                        </c:forEach>
                    </ul>
                    <ul>
                        <c:forEach var="day" begin="17" end="31">
                            <li class="w_24">
                                <c:choose>
                                    <c:when test="${day % 7 == 6}"><span class="bb_blue">${day}</span></c:when>
                                    <c:when test="${day % 7 == 0}"><span class="bb_red">${day}</span></c:when>
                                    <c:otherwise>${day}</c:otherwise>
                                </c:choose>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </li>
            <li class="w_199">합계</li>
            <li class="w_100">휴가공제</li>
        </ul>

        <!-- Data (기본 틀) -->
        <c:forEach var="i" begin="1" end="5">
            <ul class="anchor ulDiligenceList">
                <li class="w_88">정규직</li>
                <li class="w_88">No-1400<i>${i}</i></li>
                <li class="w_70">홍길동</li>
                <li class="w_92">관리팀</li>
                <li class="w_88 b_none">부장</li>
                <li style="padding-top:0px;">
                    <div class="date clsCheck">
                        <ul>
                            <c:forEach var="day" begin="1" end="16">
                                <li class="w_24"></li>
                            </c:forEach>
                        </ul>
                        <ul>
                            <c:forEach var="day" begin="17" end="31">
                                <li class="w_24"></li>
                            </c:forEach>
                        </ul>
                    </div>
                </li>
                <li class="w_199">0</li>
                <li class="w_100">0</li>
            </ul>
        </c:forEach>
    </div>
</body>
</html>


<%-- <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>근태 조회</title>
    <style>
        body { font-family: Arial, sans-serif; }
        
        /* 전체 컨테이너 스타일 */
        .container {
            width: 90%;
            margin: 20px auto;
        }
        
        /* 버튼 스타일 */
        .tab-container {
            display: flex;
            margin-bottom: 10px;
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

        /* 필터 영역 스타일 */
        .filter-container {
            display: flex;
            align-items: center;
            gap: 10px;
            flex-wrap: wrap;
            margin-bottom: 20px;
        }
        .filter-container label {
            font-size: 14px;
            margin-right: 5px;
        }
        .filter-container select {
            padding: 5px;
            font-size: 14px;
            width: auto;
        }
        
        /* 테이블 스타일 */
        .table-container {
            width: 100%;
            overflow: auto;
        }
        .e_total ul {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            flex-wrap: wrap;
        }
        .e_total .date ul {
            list-style: none;
            padding: 0;
            margin: 0;
            display: flex;
            flex-wrap: wrap;
        }
        .e_total .w_24 {
            width: 24px;
            height: 24px;
            text-align: center;
            line-height: 24px;
            border: 1px solid #ddd;
        }
        .e_total .bb_blue { color: blue; }
        .e_total .bb_red { color: red; }
        .e_total .c_red { color: red; font-weight: bold; }
        .w_88 { width: 88px; }
        .w_70 { width: 70px; }
        .w_92 { width: 92px; }
        .w_199 { width: 199px; }
        .w_100 { width: 100px; }
        .b_none { border-right: none; }
        .ulDiligenceList {
            display: flex;
            align-items: center;
            margin-top: 5px;
        }
        .clsCheck {
            display: flex;
        }
    </style>
    <c:set var="year" value="${param.year != null ? param.year : 2024}" />
    <c:set var="month" value="${param.month != null ? param.month : 11}" />
</head>
<body>
    <h2>勤怠照会</h2>
    <p>社員別の勤怠状況を一度にご覧いただけます。月別や詳細な勤怠内容も確認できます。</p>
    <div class="tab-container">
        <button class="tab-button active-tab" onclick="location.href='monthlyQuery.do';">월별 조회</button>
        <button class="tab-button inactive-tab" onclick="location.href='detailedQuery.do';">상세 조회</button>
    </div>

    <div class="filter-container">
        <label>연도: 
            <select name="year">
                <c:forEach var="y" begin="2013" end="2024">
                    <option value="${y}" ${y == 2024 ? 'selected' : ''}>${y}</option>
                </c:forEach>
            </select>
        </label>
        <label>월: 
            <select name="month">
                <c:forEach var="m" begin="1" end="12">
                    <option value="${m}" ${m == 11 ? 'selected' : ''}>${m}</option>
                </c:forEach>
            </select>
        </label>
        <label>재직: 
            <select name="employmentStatus">
                <option value="전체">전체</option>
                <option value="재직">재직</option>
                <option value="퇴직">퇴직</option>
            </select>
        </label>
        <label>구분별: 
            <select name="employmentType">
                <option value="정규직">정규직</option>
                <option value="계약직">계약직</option>
                <option value="임시직">임시직</option>
                <option value="파견직">파견직</option>
                <option value="위촉직">위촉직</option>
                <option value="일용직">일용직</option>
            </select>
        </label>
        <label>부서별: 
            <select name="department">
                <option value="사장실">사장실</option>
                <option value="개발팀">개발팀</option>
                <option value="콘텐츠팀">콘텐츠팀</option>
                <option value="업무지원팀">업무지원팀</option>
                <option value="디자인팀">디자인팀</option>
                <option value="관리팀">관리팀</option>
                <option value="기획전략팀">기획전략팀</option>
            </select>
        </label>
        <label>직급별: 
            <select name="position">
                <option value="이사">이사</option>
                <option value="차장">차장</option>
                <option value="사장">사장</option>
                <option value="부장">부장</option>
                <option value="과장">과장</option>
                <option value="대리">대리</option>
                <option value="주임">주임</option>
                <option value="사원">사원</option>
                <option value="실장">실장</option>
            </select>
        </label>
        <button type="submit">조회</button>
    </div>

    <div class="table-container e_total">
        <!-- Header -->
        <ul class="height_53">
            <li class="w_88">구분</li>
            <li class="w_88"><strong>사원번호</strong></li>
            <li class="w_70"><strong>성명</strong></li>
            <li class="w_92"><strong>부서</strong></li>
            <li class="w_88 b_none"><strong>직위</strong></li>
            <li style="padding-top:0px;">
                <div class="date">
                    <ul>
                        <c:forEach var="day" begin="1" end="16">
                            <li class="w_24">
                                <c:choose>
                                    <c:when test="${day % 7 == 6}"><span class="bb_blue">${day}</span></c:when>
                                    <c:when test="${day % 7 == 0}"><span class="bb_red">${day}</span></c:when>
                                    <c:otherwise>${day}</c:otherwise>
                                </c:choose>
                            </li>
                        </c:forEach>
                    </ul>
                    <ul>
                        <c:forEach var="day" begin="17" end="31">
                            <li class="w_24">
                                <c:choose>
                                    <c:when test="${day % 7 == 6}"><span class="bb_blue">${day}</span></c:when>
                                    <c:when test="${day % 7 == 0}"><span class="bb_red">${day}</span></c:when>
                                    <c:otherwise>${day}</c:otherwise>
                                </c:choose>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </li>
            <li class="w_199">합계</li>
            <li class="w_100">휴가공제</li>
        </ul>

        <!-- Data -->
        <c:forEach var="attendance" items="${monthlyAttendance}">
            <ul class="anchor ulDiligenceList">
                <li class="w_88"><c:out value="${attendance.category}" /></li>
                <li class="w_88">No-<c:out value="${attendance.employeeId}" /></li>
                <li class="w_70"><c:out value="${attendance.employeeName}" /></li>
                <li class="w_92"><c:out value="${attendance.department}" /></li>
                <li class="w_88 b_none"><c:out value="${attendance.position}" /></li>
                <li style="padding-top:0px;">
                    <div class="date clsCheck">
                        <ul>
                            <c:forEach var="day" begin="1" end="16">
                                <li class="w_24">
                                    <c:choose>
                                        <c:when test="${attendance.attendanceDays[day] == 'present'}">
                                            <span class="c_red">●</span>
                                        </c:when>
                                        <c:otherwise></c:otherwise>
                                    </c:choose>
                                </li>
                            </c:forEach>
                        </ul>
                        <ul>
                            <c:forEach var="day" begin="17" end="31">
                                <li class="w_24">
                                    <c:choose>
                                        <c:when test="${attendance.attendanceDays[day] == 'present'}">
                                            <span class="c_red">●</span>
                                        </c:when>
                                        <c:otherwise></c:otherwise>
                                    </c:choose>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </li>
                <li class="w_199"><c:out value="${attendance.total}" /></li>
                <li class="w_100"><c:out value="${attendance.vacationDeduction}" /></li>
            </ul>
        </c:forEach>
    </div>
</body>
</html>
 --%>