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
    <%@include file="Bootstrap.jsp"%>
    <title>登录</title>
</head>
<body>

    <div class="row">
        <div class="col-sm-offset-3 col-sm-3">
            <s:if test="%{errCode == 1}">
                <p class="bg-warning">添加失败，已存在相同的用户名！</p>
            </s:if>
        </div>
    </div>


    <form action="register.action" method="post" id="reg">
        <input type="hidden" name="url" value="${url}">
    </form>


    <form class="form-horizontal" role="form" action="login" method="post">


        <div class="form-group">
            <label for="inputUsername" class="col-sm-offset-2 col-sm-2
                    control-label" >用户名</label>
            <div class="col-sm-4">
                <input type="text" name="username" id="inputUsername"
                       class="form-control" placeholder="请输入用户名"
                    value="${username}" required>
            </div>
        </div>

        <div class="form-group">
            <label for="inputPassword" class="col-sm-offset-2 col-sm-2
                    control-label" >密码</label>
            <div class="col-sm-4">
                <input type="password" name="password" id="inputPassword"
                       class="form-control" placeholder="请输入密码"
                       value="${username}" required>
            </div>
        </div>
        <input type="hidden" name="url" value="${url}"></input>

        <div class="form-group">
            <div class="col-sm-offset-5 col-sm-1">
                <button type="submit" class="btn btn-default">登陆</button>
            </div>
            <div class="col-sm-1">
                <button type="button" class="btn btn-default" onclick="document.getElementById('reg').submit();">注册</button>
            </div>
        </div>
    </form>

</body>
</html>
