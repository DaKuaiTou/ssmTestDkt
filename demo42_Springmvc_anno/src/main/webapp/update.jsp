<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/25
  Time: 15:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户更新</title>
</head>
<body>
    <form method="post" action="/user/updateUser">
        用户名：<input type="text" name="username"><br>
        密码：<input type="text" name="password"><br>
        昵称：<input type="text" name="nickname"><br>
        <input type="hidden" name="id" value="1">
        <input type="submit" value="更新">
    </form>
</body>
</html>
