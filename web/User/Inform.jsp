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
    <table class="table-bordered table-responsive">
        <tr>
            <th>内容</th>
            <th>时间</th>
            <th>操作</th>
        </tr>
        <s:iterator value="informList">
            <s:if test="%{informType==6}">
                <s:if test="%{#session.id != friend.friend.id}">
                    <tr>
                        <td>
                            ${friend.friend.nickname} 给您留言:
                            ${friendMessage}
                        </td>
                        <td>${time}</td>
                        <td><a href="#">回复</a> </td>
                    </tr>
                </s:if>
            </s:if>
        </s:iterator>
    </table>
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
