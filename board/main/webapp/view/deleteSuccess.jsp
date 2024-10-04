<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 삭제 완료</title>
</head>
<body>
    <h2>게시글 삭제 완료</h2>
    <p>게시글이 성공적으로 삭제되었습니다.</p>
    
    <c:set var="ctxPath" value="${pageContext.request.contextPath}" />
    <a href="${ctxPath}/article/list.do">[게시글 목록보기]</a>
</body>
</html>
	