<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/12/12
  Time: 0:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${circle.name}</title>
    <link rel="stylesheet" type="text/css" href="../css/detail_style.css">
</head>
<script type="text/javascript">
    function deletePost(pid) {
        var answer = confirm("确定要删除吗？");
        if (answer == true) {
            window.location.href = 'deleteCirclePost.action?id='+pid;
        }
    }
</script>
<body>
<%@include file="../Head.jsp"%>
    <div class="row">
        <div class="col-sm-offset-11">
            <button onclick="return false;" class="btn btn-primary"
                    data-toggle="modal" data-target="#myModal">发表新主题</button>
        </div>
    </div>
    <s:if test="%{postList == null || postList.size() == 0}">
        <h2 align="center">还没有主题哦！</h2>
    </s:if>
    <s:else>
        <div class="row">
            <div class="panel panel-default">
                <div class="panel-body">
                    <div class="col-sm-4"><h4>主题</h4></div>
                    <div class="col-sm-3"><h4>作者</h4></div>
                    <div class="col-sm-1"><h4>回复量</h4></div>
                    <div class="col-sm-3"><h4>最后发表</h4></div>
                </div>
            </div>
        </div>
        <table>
            <s:iterator value="postList">
                <div class="row" id="detail_body">
                    <div class="col-sm-4"><a href="showCirclePost.action?pid=${id}" target="_blank">${title}</a></div>
                    <div class="col-sm-3">
                        <s:if test="%{poster.head == ''}">
                            <img src="../photo/head.jpg">
                        </s:if>
                        <s:else>
                            <img src="photo/${poster.username.hashCode()}${poster.head}">
                        </s:else>
                            ${poster.nickname}<br>${time}
                    </div>
                    <div class="col-sm-1">${replyCount}</div>
                    <div class="col-sm-3">
                        <s:if test="%{lastReply == null}">
                            <s:if test="%{poster.head == ''}">
                                <img src="../photo/head.jpg">
                            </s:if>
                            <s:else>
                                <img src="photo/${poster.username.hashCode()}${poster.head}">
                            </s:else>
                            ${poster.nickname}
                        </s:if>
                        <s:else>
                            <s:if test="%{lastReply.replier.head == ''}">
                                <img src="../photo/head.jpg">
                            </s:if>
                            <s:else>
                                <img src="photo/${lastReply.replier.username.hashCode()}${lastReply.replier.head}">
                            </s:else>
                            ${lastReply.replier.nickname}
                        </s:else>
                        <br>${lastReplyTime}
                    </div>
                    <div class="col-sm-1">
                        <s:if test="%{isOwner == 1}">
                            <button class="btn btn-default" onclick="deletePost(${id})">删除</button>
                        </s:if>
                    </div>
                </div>
            </s:iterator>
        </table>
        <s:if test="%{pageCount > 1}">
            <nav>
                <ul class="pager">
                    <li><a href="showCircleDetail.action?type=${type}&pageNumber=${1}">首页</a></li>
                    <li><a href="showCircleDetail.action?type=${type}&pageNumber=${pageNumber-1}">上一页</a></li>
                    <li>${pageNumber}/${pageCount}</li>
                    <li><a href="showCircleDetail.action?type=${type}&pageNumber=${pageNumber+1}">下一页</a></li>
                    <li><a href="showCircleDetail.action?type=${type}&pageNumber=${pageCount}">末页</a></li>
                </ul>
            </nav>
        </s:if>
    </s:else>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">新主题</h4>
            </div>
            <form class="form-horizontal" role="form" action="addCirclePost.action" method="post">
                <div class="modal-body">
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-8">
                            <input type="text" id="inputTitle" name="title" minlength="4"
                                   maxlength="50" class="form-control"  required
                                   placeholder="请输入标题，4~50个字符">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-8">
                    <textarea id="area" rows="10" cols="50"
                              name="content" maxlength="4000"
                              placeholder="请输入帖子内容，不超过4000字符"
                              class="form-control"
                    ></textarea>
                        </div>
                    </div>
                    <input type="hidden" name="circleId" value="${circle.id}">
                    <input type="hidden" name="poster.id" value="${session.id}">
                    <div class="col-sm-offset-2 col-sm-1"></div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                    <button type="submit" class="btn btn-primary">发表</button>
                </div>
            </form>
        </div>
    </div>
</div>

</body>
</html>
