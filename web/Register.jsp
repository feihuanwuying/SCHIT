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
    <%@include file="Bootstrap.jsp"%>

    <link rel="stylesheet" type="text/css" href="css/register_style.css">
    <title>注册</title>
</head>
<body>
    <%@include file="Head.jsp"%>
    <div class="row">
        <div class="col-sm-offset-3 col-sm-3">
            <s:if test="%{errCode == 1}">
                <p class="bg-warning">用户名已经存在！</p>
            </s:if>
        </div>
    </div>


    <form action="register" method="POST" class="form-horizontal" role="form">
        <div class="form-group">
            <label for="inputUsername" class="col-sm-offset-2 col-sm-2
                    control-label" >用户名</label>
            <div class="col-sm-4">
                <input type="text" name="username" required value="${username}"
                       minlength="8" maxlength="20" pattern="[a-zA-Z0-9]*"
                        id="inputUsername" class="form-control"
                placeholder="请输入用户名，仅由字母和数字组成，最短8个字符，最多20个字符">
            </div>
        </div>


        <div class="form-group">
            <label for="inputPassword" class="col-sm-offset-2 col-sm-2
                    control-label" >密码</label>
            <div class="col-sm-4">
                <input type="password" name="password" required value="${password}"
                       minlength="8" maxlength="20" pattern="[a-zA-Z0-9]*"
                       id="inputPassword" class="form-control"
                       placeholder="请输入密码，仅由字母和数字组成，最短8个字符，最多20个字符">
            </div>
        </div>


        <div class="form-group">
            <label for="inputNickname" class="col-sm-offset-2 col-sm-2
                    control-label" >昵称</label>
            <div class="col-sm-4">
                <input type="text" name="nickname" required
                       minlength="2" maxlength="30" value="${nickname}"
                       id="inputNickname" class="form-control"
                       placeholder="请输入昵称，汉字视为一个字符，最短2个字符，最多30个字符">
            </div>
        </div>

        <div class="form-group">
            <label for="inputEmail" class="col-sm-offset-2 col-sm-2
                    control-label" >邮箱</label>
            <div class="col-sm-4">
                <input type="email" name="email" required value="${email}"
                       maxlength="50" id="inputEmail" class="form-control"
                       placeholder="请输入您的邮箱，不超过50个字符">
            </div>
        </div>
        <input type="hidden" name="url" value="${url}">

        <div class="form-group">
            <div class="col-sm-offset-5 col-sm-1">
                <button type="submit" class="btn btn-default">注册</button>
            </div>
            <div class="col-sm-1">
                <button type="reset" class="btn btn-default">重填</button>
            </div>
        </div>
    </form>
</body>
</html>
