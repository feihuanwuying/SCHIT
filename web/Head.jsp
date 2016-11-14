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
<head>
    <link rel="stylesheet" type="text/css" href="css/head_style.css">
</head>
<%@include file="Bootstrap.jsp"%>
<div id="first">
    <li>
        <img src="photo/hitfly.gif">
        <h1>工大圈子</h1>
        <FONT face=华文彩云 color=#da70d6 size=6>
            <B>朋友，欢迎您的到来</B>
        </FONT>

    </li>
</div>
<%--div class="row" id="first">
    <div class="col-sm-8">
        <img src="photo/hitfly.gif"/>
        <h1>工大圈子</h1>
    </div>
    <div class="col-sm-4">
        <MARQUEE scrollAmount=2 direction=up height=60>
            <FONT face=华文彩云 color=#da70d6 size=6>
                <B>朋友，欢迎您的到来</B>
            </FONT>
        </MARQUEE>
        <P>&nbsp;</P>
    </div>
</div--%>

<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.action">工大圈子</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="showForum.action">论坛</a></li>
            </ul>

            <ul class="nav navbar-nav navbar-right">
                <s:if test="#session.username == null">
                    <li><a href="login.action">登录</a></li>
                    <li><a href="register.action">注册</a></li>
                </s:if>
                <s:else>
                    <!-- 该按钮通往个人主页 -->
                    <li><a href="showHome.action?id=${session.id}">${session.nickname}</a></li>
                    <li><a href="friendList.action">好友</a></li>
                    <li><a href="logout.action">注销</a></li>
                </s:else>
            </ul>
        </div>
    </div>

</nav>