<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <title>근태 조회</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        .table-container, .filter-container, .button-container {
            width: 90%;
            margin: 20px auto;
        }
        .filter-container select, .filter-container input[type="number"] {
            padding: 5px;
            margin-right: 5px;
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
        .button-container button {
            padding: 10px 20px;
            margin-right: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        .button-container .active {
            background-color: #4CAF50;
            color: white;
        }
        
    </style>
</head>
<body>
    <div class="button-container">
        <button onclick="location.href='monthlyQuery.do'" class="active">월별 조회</button>
        <button onclick="location.href='detailedQuery.do'">상세 조회</button>
    </div>

    <div class="filter-container">
        <form method="get" action="monthlyQuery.do">
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
        </form>
    </div>

    <div class="table-container e_total">
        <!-- 헤더 부분 -->
        <ul class="height_53">
            <li class="w_88">구분</li>
            <li class="w_88"><strong>사원번호</strong></li>
            <li class="w_70"><strong>성명</strong></li>
            <li class="w_92"><strong>부서</strong></li>
            <li class="w_88 b_none"><strong>직위</strong></li>
            <li style="padding-top:0px;">
                <!-- 날짜 헤더 부분 -->
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

        <!-- 데이터 부분 예제 -->
        <ul class="anchor ulDiligenceList">
            <li class="w_88">정규직</li>
            <li class="w_88">No-140042</li>
            <li class="w_70">홍길동</li>
            <li class="w_92">관리팀</li>
            <li class="w_88 b_none">대리</li>
            <li style="padding-top:0px;">
                <div class="date clsCheck">
                    <ul>
                        <c:forEach var="day" begin="1" end="16">
                            <li class="w_24">
                                <c:choose>
                                    <c:when test="${day == 3 || day == 5}"><span class="c_red">●</span></c:when>
                                    <c:otherwise></c:otherwise>
                                </c:choose>
                            </li>
                        </c:forEach>
                    </ul>
                    <ul>
                        <c:forEach var="day" begin="17" end="31">
                            <li class="w_24">
                                <c:choose>
                                    <c:when test="${day == 21}"><span class="c_red">●</span></c:when>
                                    <c:otherwise></c:otherwise>
                                </c:choose>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </li>
            <li class="w_199">0</li>
            <li class="w_100">1</li>
        </ul>
    </div>
</body>
</html>
