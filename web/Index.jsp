<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/10/10
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="css/index_style.css">
</head>
<body>
    <%@include file="Head.jsp"%>
    <section class="container">
        <div class="row" id="first">
            <div class="col-sm-12">
                <CENTER id="center_1">
                    <FONT face=隶书 color=red size=25><MARQUEE direction=up behavior=alternate width=60 height=120>工</MARQUEE></FONT>
                    <FONT face=隶书 color=green size=25><MARQUEE direction=up behavior=alternate width=60 height=80>大</MARQUEE></FONT>
                    <FONT face=隶书 color=violet size=25><MARQUEE direction=up behavior=alternate width=60 height=120>圈</MARQUEE></FONT>
                    <FONT face=隶书 color=purple  size=25><MARQUEE direction=up behavior=alternate width=60 height=80>子</MARQUEE></FONT>
                </CENTER>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-8">

            </div>
            <div class="col-sm-4">
                <MARQUEE scrollAmount=2 direction=up height=60>
                    <FONT face=华文彩云 color=#da70d6 size=6>
                        <B>朋友，欢迎您的到来</B>
                    </FONT>
                </MARQUEE>
                <P>&nbsp;</P>
            </div>
        </div>
        <div class="row" id="center_2">
            <div class="col-sm-3">
                <h1 id="today_title">今日HIT</h1>
                <h4>周校长宣布14届学生全体保研</h4>
                <h4>教务处网站被HACK，所有人学分绩变成100</h4>
                <h4>学生游行希望老师取消点名制</h4>
            </div>
            <div class="col-sm-1"></div>
            <div clas="col-sm-8">
                <EMBED height=66% type=audio/mpeg width=66% src="http://map.hit.edu.cn/" volumn="0" autostart="true" loop="-1"></EMBED>
            </div>
        </div>
    </section>

</body>
</html>
