<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/10/13
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
    <s:if test="%{errCode == 1}">
        用户名不存在或密码错误!
    </s:if>
    <form action="register.action" method="post" pid="reg">
        <input type="hidden" name="url" value="${url}">
    </form>
    <s:form action="login" method="post">
        <s:textfield name="username" value="%{username}" label="用户名"></s:textfield>
        <s:password name="password" value="%{username}" label="密码"></s:password>
        <s:hidden name="url" value="%{url}"></s:hidden>
        <s:submit value="登录"></s:submit>
        <tr><td colspan="2"><button type="button" onclick="document.getElementById('reg').submit();">注册</button></td></tr>
    </s:form>

</body>
</html>
