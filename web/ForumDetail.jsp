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
    <link rel="stylesheet" type="text/css" href="css/detail_style.css">
</head>
<body>
    <%@include file="Head.jsp"%>
    <table>
        <div class="row">
            <div class="col-sm-4">主题</div>
            <div class="col-sm-3">作者</div>
            <div class="col-sm-1">回复量</div>
            <div class="col-sm-3">最后发表</div>
        </div>
        <s:iterator value="postList">
            <div class="row" id="detail_body">
                <div class="col-sm-4"><a href="showPost.action?pid=${id}" target="_blank">${title}</a></div>
                <div class="col-sm-3">
                    <img src="http://ww2.sinaimg.cn/thumb150/006nE56Ygw1f7dsyyyqk7j30g40g9aaz.jpg"/>
                    ${poster.nickname}<br>${time}
                </div>
                <div class="col-sm-1">${replyCount}</div>
                <div class="col-sm-3">
                    <img src="http://pic.962.net/up/2016-8/14701279968599348.jpg"/>
                    <s:if test="%{lastReply == null}">
                        ${poster.nickname}
                    </s:if>
                    <s:else>
                        ${lastReply.replier.nickname}
                    </s:else>
                    <br>${lastReplyTime}
                </div>
                <div class="col-sm-1">
                    <s:if test="#session.power == 1">
                        <button onclick="window.location.href='deletePost.action?id=${id}'">删除</button>
                    </s:if>
                </div>
            </div>
        </s:iterator>
    </table>
    <a class="btn btn-primary" href="showForumDetail.action?type=${type}&pageNumber=${1}">首页</a>
    <a class="btn btn-primary" href="showForumDetail.action?type=${type}&pageNumber=${pageNumber-1}">上一页</a>
    <a class="btn btn-primary" href="showForumDetail.action?type=${type}&pageNumber=${pageNumber+1}">下一页</a>
    <a class="btn btn-primary" href="showForumDetail.action?type=${type}&pageNumber=${pageCount}">末页</a>
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
        <strong><h2>登录开启发帖功能！</h2></strong>
    </s:else>
</body>
</html>
