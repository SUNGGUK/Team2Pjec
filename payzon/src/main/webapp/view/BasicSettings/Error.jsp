<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>エラー発生</title>
    <style>
        .container { width: 60%; margin: auto; text-align: center; padding: 50px; border: 1px solid #ccc; border-radius: 10px; margin-top: 100px; }
        h1 { color: #d9534f; }
        p { font-size: 16px; color: #333; }
        .button {
            display: inline-block;
            margin-top: 20px;
            padding: 10px 20px;
            color: #fff;
            background-color: #5bc0de;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            font-size: 16px;
        }
        .button:hover { background-color: #31b0d5; }
    </style>
</head>
<body>
    <div class="container">
        <h1>エラーが発生しました</h1>
        <p>リクエストの処理中に問題が発生しました。しばらくしてから再度お試しください。</p>
        <p>問題が解決しない場合は、システム管理者にお問い合わせください。</p>
        <a href="<%= request.getContextPath() %>/index.jsp" class="button">ホームに戻る</a>
    </div>
</body>
</html>
