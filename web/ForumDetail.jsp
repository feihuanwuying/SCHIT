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
                <td><a href="showPost.action?pid=${id}" target="_blank"><s:property value="title"></s:property></a></td>
                <td><s:property value="poster.nickname"></s:property>
                    <br><s:property value="time"></s:property>
                </td>
                <td><s:property value="replyCount"></s:property> </td>
                <td><s:if test="%{lastReply == null}">
                        ${poster.nickname}
                    </s:if>
                    <s:else>
                        ${lastReply.replier.nickname}
                    </s:else>
                    <br><s:property value="lastReplyTime"></s:property>
                </td>
            </tr>
        </s:iterator>
    </table>
    <a href="showForumDetail.action?type=${type}&pageNumber=${1}">首页</a>
    <a href="showForumDetail.action?type=${type}&pageNumber=${pageNumber-1}">上一页</a>
    <a href="showForumDetail.action?type=${type}&pageNumber=${pageNumber+1}">下一页</a>
    <a href="showForumDetail.action?type=${type}&pageNumber=${pageCount}">末页</a>
    <br><br>
    <s:if test="#session.username != null">
        <form action="addPost.action" method="post">
            标题：<input type="text" name="title" minlength="4" maxlength="50"><br><br>
            内容：<textarea id="area" rows="10" cols="50" name="content" maxlength="4000"></textarea>
            <input type="hidden" name="type" value="${type}">
            <input type="hidden" name="poster.username" value="${session.username}">
            <button type="submit">提交</button>
        </form>
    </s:if>
    <s:else>
        <strong><h2>登录开启回复功能！</h2></strong>
    </s:else>
</body>
</html>
