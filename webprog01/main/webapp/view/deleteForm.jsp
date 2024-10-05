<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>게시글 삭제</title>
</head>
<body>
    <h2>게시글 삭제</h2>
    <form action="delete.do" method="post">
        <!-- 게시글 번호를 hidden 필드로 추가 -->
        <input type="hidden" name="no" value="${article.number}"/>

        <p>
            게시글 번호: <strong>${article.number}</strong>
        </p>
        <p>
            제목: <strong>${article.title}</strong>
        </p>
        <p>
            작성자: <strong>${article.writer.name}</strong>
        </p>
        <p>이 게시글을 정말로 삭제하시겠습니까?</p>
        
        <input type="submit" value="삭제"/>
        <a href="read.do?no=${article.number}">취소</a>
    </form>
</body>
</html>
