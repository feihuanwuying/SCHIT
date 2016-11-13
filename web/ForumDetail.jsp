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
                    <img src="http://uc.pcbeta.com//data/avatar/004/81/07/37_avatar_middle.jpg"/>
                    ${poster.nickname}<br>${time}
                </div>
                <div class="col-sm-1">${replyCount}</div>
                <div class="col-sm-3">
                    <img src="http://uc.pcbeta.com//data/avatar/004/81/07/37_avatar_middle.jpg"/>
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
                        <button class="btn btn-default" onclick="window.location.href='deletePost.action?id=${id}'">删除</button>
                    </s:if>
                </div>
            </div>
        </s:iterator>
    </table>
    <s:if test="%{pageCount > 1}">
        <nav>
            <ul class="pager">
                <li><a href="showForumDetail.action?type=${type}&pageNumber=${1}">首页</a></li>
                <li><a href="showForumDetail.action?type=${type}&pageNumber=${pageNumber-1}">上一页</a></li>
                <li>${pageNumber}/${pageCount}</li>
                <li><a href="showForumDetail.action?type=${type}&pageNumber=${pageNumber+1}">下一页</a></li>
                <li><a href="showForumDetail.action?type=${type}&pageNumber=${pageCount}">末页</a></li>
            </ul>
        </nav>
    </s:if>
    <br><br>
    <s:if test="#session.username != null">
        <form class="form-horizontal" role="form" action="addPost.action" method="post">
            <div class="form-group">
                <label for="inputTitle" class="col-sm-offset-2 col-sm-1
                        control-label">标题</label>
                <div class="col-sm-6">
                    <input type="text" id="inputTitle" name="title" minlength="4"
                           maxlength="50" class="form-control"  required
                           placeholder="请输入标题，4~50个字符">
                </div>
            </div>

            <div class="form-group">
                <label for="area" class="col-sm-offset-2 col-sm-1
                        control-label">内容</label>
                <div class="col-sm-6">
                    <textarea id="area" rows="10" cols="50"
                              name="content" maxlength="4000"
                              placeholder="请输入帖子内容，不超过4000字符"
                              class="form-control"
                    ></textarea>
                </div>
            </div>
            <input type="hidden" name="type" value="${type}">
            <input type="hidden" name="poster.id" value="${session.id}">
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-2">
                    <button type="submit" class="btn btn-default">发表新帖子</button>
                </div>
            </div>
        </form>
    </s:if>
    <s:else>
        <strong><h2>登录开启发帖功能！</h2></strong>
    </s:else>
</body>
</html>
