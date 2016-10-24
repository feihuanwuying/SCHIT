<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/10/24
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>论坛区</title>
</head>
<body>
    <%@include file="Head.jsp"%>
    <a href="showForumDetail.action?type=5">聊天灌水区</a> 主题数：<s:property value="map[5][0]"></s:property>
    回复数：<s:property value="map[5][1]"></s:property>
    <br>
    <a href="showForumDetail.action?type=6">学习交流区</a>  主题数：<s:property value="map[6][0]"></s:property>
    回复数：<s:property value="map[6][1]"></s:property>
    <br>
    <a href="showForumDetail.action?type=7">交友征婚区</a>  主题数：<s:property value="map[7][0]"></s:property>
    回复数：<s:property value="map[7][1]"></s:property>
    <br>
    <a href="showForumDetail.action?type=5">咨询求助区</a>  主题数：<s:property value="map[8][0]"></s:property>
    回复数：<s:property value="map[8][1]"></s:property>
</body>
</html>
