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
    <s:form action="login" method="post">
        <s:textfield name="username" value="%{username}" label="用户名"></s:textfield>
        <s:password name="password" value="%{username}" label="密码"></s:password>
        <s:submit value="登录"></s:submit>
    </s:form>

</body>
</html>
