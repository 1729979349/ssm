<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/common/head.jsp"%>
</head>
<body>
<h1>${message}</h1>
<h1>用户登录</h1>
<form action="${ctx}/user/userLogin" method="post">
    用户账号：<input type="text" name="username"><br>
    用户密码：<input type="password" name="password"><br>
    <input type="submit" value="登录">
</form>
</body>
</html>
