<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/10/24
  Time: 19:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${title}</title>
</head>
<body>
    <%@include file="Head.jsp"%>
    <table>
        <tr>
            <td>主题</td>
            <td>作者</td>
            <td>回复量</td>
            <td>最后发表</td>
        </tr>
        <s:iterator value="postList">
            <tr>
                <td><a href="showPost.action?pid=${id}"><s:property value="title"></s:property></a></td>
                <td><s:property value="posterName"></s:property>
                    <br><s:property value="time"></s:property>
                </td>
                <td><s:property value="replies"></s:property> </td>
                <td><s:property value="replyName"></s:property>
                    <br><s:property value="replyTime"></s:property>
                </td>
            </tr>
        </s:iterator>
    </table>
    <a href="showForumDetail.action?type=${type}&pageNumber=${1}">首页</a>
    <a href="showForumDetail.action?type=${type}&pageNumber=${pageNumber-1}">上一页</a>
    <a href="showForumDetail.action?type=${type}&pageNumber=${pageNumber+1}">下一页</a>
    <a href="showForumDetail.action?type=${type}&pageNumber=${pageCount}">末页</a>
</body>
</html>
