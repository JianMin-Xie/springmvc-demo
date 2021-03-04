<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>登录页面</h1>

<form action="${pageContext.request.contextPath}/user/login" method="">
    用户名：<input type="text" name="username">
    密码：<input type="password" name="password">
    <input type="submit" value="登录">
</form>

</body>
</html>
