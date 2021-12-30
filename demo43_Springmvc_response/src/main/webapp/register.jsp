<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/12/24
  Time: 17:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册页面</title>
</head>
<body>

    <form method="post" action="/user/register">
        用户名：<input type="text" name="username"><br/>
        密码：<input type="text" name="password"><br/>
        昵称：<input type="text" name="nickname"><br/>
        生日：<input type="text" name="birthday"><br/>
        爱好：
        <input type="checkbox" name="hobbies" value="basketball">篮球
        <input type="checkbox" name="hobbies" value="football">足球
        <input type="checkbox" name="hobbies" value="yumaoqiu">羽毛球
        <input type="checkbox" name="hobbies" value="pingpangqiu">乒乓球


        <br/>

        <input type="submit" value="注册">
    </form>
</body>
</html>
