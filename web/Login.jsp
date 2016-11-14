<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/10/13
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    onload = function () {
        var v = ${errCode};
        if (v == 3 || v == 4) {
            change(2);
        }
    }
    function change(status) {
        if (status == 2) {
            $("#login").css('color', "lightgray");
            $("#register").css("color", "blue");
            $("#loginArea").css("visibility", "hidden");
            $("#loginArea").css("display", "none");
            $("#registerArea").css("visibility", "visible");
            $("#registerArea").css("display", "");
        } else {
            $("#register").css('color', "lightgray");
            $("#login").css("color", "blue");
            $("#registerArea").css("visibility", "hidden");
            $("#registerArea").css("display", "none");
            $("#loginArea").css("visibility", "visible");
            $("#loginArea").css("display", "");
        }
    }
</script>
<html>
<head>
    <%@include file="Bootstrap.jsp"%>
    <link rel="stylesheet" type="text/css" href="css/login_style.css">
    <title>登录</title>
</head>
<body>
    <div class="panel panel-default col-sm-offset-4 col-sm-4" style="top: 20%">
        <div class="panel-body">
            <div class="row text-center">
                <h1 style="color: dodgerblue">工大圈子</h1>
            </div>
            <div class="row">
                <div class="col-sm-offset-3 col-sm-3" align="center">
                    <a href="javascript:change(1);" style="text-decoration: none;color: blue" id="login"><h4>登录</h4></a>
                </div>
                <div class="col-sm-3" align="center">
                    <a href="javascript:change(2);" style="text-decoration: none;color: lightgrey" id="register"><h4>注册</h4></a>
                </div>
            </div>
            <br>


            <div id="registerArea" style="visibility: hidden;display: none">
                <div class="row" align="center">
                    <s:if test="%{errCode == 3}">
                        <h4 class="bg-warning" style="width: 70%">用户名已经存在！</h4>
                    </s:if>
                </div>
                <form action="register" method="POST" class="form-horizontal" role="form">
                    <div class="form-group">
                        <input type="text" name="username" required value="${username}"
                               minlength="8" maxlength="20" pattern="[a-zA-Z0-9]*"
                               id="inputUsername" class="form-control" style="width: 70%"
                               placeholder="请输入用户名，仅由字母和数字组成，最短8个字符，最多20个字符">
                    </div>


                    <div class="form-group">
                        <input type="password" name="password" required value="${password}"
                               minlength="8" maxlength="20" pattern="[a-zA-Z0-9]*"
                               id="inputPassword" class="form-control" style="width: 70%"
                               placeholder="请输入密码，仅由字母和数字组成，最短8个字符，最多20个字符">
                    </div>


                    <div class="form-group">
                        <input type="text" name="nickname" required
                               minlength="2" maxlength="30" value="${nickname}"
                               id="inputNickname" class="form-control" style="width: 70%"
                               placeholder="请输入昵称，汉字视为一个字符，最短2个字符，最多30个字符">
                    </div>

                    <div class="form-group">
                        <input type="email" name="email" required value="${email}"
                               maxlength="50" id="inputEmail" class="form-control"
                               placeholder="请输入您的邮箱，不超过50个字符"
                               style="width: 70%"
                        >
                    </div>
                    <input type="hidden" name="url" value="${url}">

                    <div class="form-group" align="center">
                        <button type="submit" class="btn btn-default"
                                style="width: 70%;background: dodgerblue">注册</button>
                    </div>
                </form>
            </div>

            <div id="loginArea">
                <div class="row" align="center">
                    <s:if test="%{errCode == 1}">
                        <h4 class="bg-warning" style="width: 70%">用户名或密码错误！</h4>
                    </s:if>
                </div>
                <form class="form-horizontal" role="form" action="login" method="post">
                    <input type="hidden" name="url" value="${url}"></input>
                    <div class="form-group">
                        <input type="text" name="username" id="inputUsername"
                               placeholder="请输入用户名" class="form-control"
                               value="${username}" required style="width: 70%">
                    </div>
                    <div class="form-group">
                        <input type="password" name="password" id="inputPassword"
                               placeholder="请输入密码" class="form-control"
                               value="${username}" required style="width: 70%">
                    </div>
                    <div class="form-group" align="center">
                        <button type="submit" class="btn btn-default"
                                style="width: 70%;background: dodgerblue">登录</button>
                        <!--<button type="button" class="btn btn-default" onclick="document.getElementById('reg').submit();">注册</button>-->
                    </div>
                </form>
            </div>
        </div>
    </div>
</body>
</html>