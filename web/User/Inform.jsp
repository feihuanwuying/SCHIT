<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/11/29
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../Bootstrap.jsp"%>
    <title>查看通知</title>
</head>
<body>
    <%@include file="../Head.jsp"%>
    <s:iterator value="informList">
        ${friend.friend.nickname} ${friendMessage}<br>
    </s:iterator>
    <nav>
        <ul class="pager">
            <li><a href="showInform.action?pageNumber=${1}">首页</a></li>
            <li><a href="showInform.action?pageNumber=${pageNumber-1}">上一页</a></li>
            <li>${pageNumber}/${pageCount}</li>
            <li><a href="showInform.action?pageNumber=${pageNumber+1}">下一页</a></li>
            <li><a href="showInform.action?pageNumber=${pageCount}">末页</a></li>
        </ul>
    </nav>
</body>
</html>
