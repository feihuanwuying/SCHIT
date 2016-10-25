<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/10/23
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <s:if test="%{errCode == 1}">
        用户名已经存在！
    </s:if>
    <form action="register" method="POST">
        <tr>
            用户名<input type="text" name="username" required minlength="8" maxlength="20" pattern="[a-zA-Z0-9]*">
        </tr>
        <tr>
            密码<input type="password" name="password" required minlength="8" maxlength="20" pattern="[a-zA-Z0-9]*">
        </tr>
        <tr>
            昵称<input type="text" name="nickname" required minlength="4" maxlength="30">
        </tr>
        <tr>
            邮箱<input type="email" name="email" required maxlength="50">
        </tr>
        <input type="hidden" name="url" value="${url}">
        <button type="submit">注册</button>
        <button type="reset">重填</button>
    </form>
</body>
</html>
