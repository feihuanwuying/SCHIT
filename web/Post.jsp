<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/10/24
  Time: 21:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${post.title}</title>
</head>
<body>
    <%@include file="Head.jsp"%>
    帖子标题：${post.title} <br>
    帖子作者：${post.posterName} <br>
    帖子内容：${post.content} <br>
    帖子时间：${post.time} <br>

    <s:iterator value="replyList" status="st">
        <s:property value="%{#st.index+2+(pageNumber-1)*pageSize}"></s:property>楼：
        <br>
        <s:property value="replierName"></s:property>：
        <s:property value="content"></s:property>
        <br>
        回复于：<s:property value="time"></s:property>
        <br>
    </s:iterator>

    <a href="showPost.action?pid=${pid}&pageNumber=${1}">首页</a>
    <a href="showPost.action?pid=${pid}&pageNumber=${pageNumber-1}">上一页</a>
    <a href="showPost.action?pid=${pid}&pageNumber=${pageNumber+1}">下一页</a>
    <a href="showPost.action?pid=${pid}&pageNumber=${pageCount}">末页</a>
</body>
</html>
