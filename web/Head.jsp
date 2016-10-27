<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/10/10
  Time: 23:18
  用户登录、注册，置于页面头
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<s:if test="#session.username != null">
    欢迎回来，${sessionScope.nickname}！
    <button type="button" onclick="window.location.href='logout.action'">注销</button>
</s:if>
<s:else>
    <button type="button" onclick="window.location.href='login.action'">登录</button>
    <button type="button" onclick="window.location.href='register.action'">注册</button>
</s:else>
<button type="button" onclick="window.location.href='index.action'">主页</button>
<br>
