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
    <title>${post.title}</title>
</head>
<script type="text/javascript">
    function reply() {
        document.getElementById("parentId").value = -1;
        document.getElementById("but").click();
    }
    function replyToFloor(floorId) {
        document.getElementById("parentId").value = floorId;
        document.getElementById("but").click();
    }
    function checkLength(form) {
        var content = form.content.value;
        if (content.length < 4) {
            alert("至少输入4个字符！");
            return false;
        } else if (content.length > 4000) {
            alert("不可以超过4000字符！")
            return false;
        }
        return true;
    }
    function deleteReply(pid) {
        var answer = confirm("确定要删除吗？");
        if (answer == true) {
            window.location.href = 'deleteCircleReply.action?id='+pid;
        }
    }
</script>
<body>
<%@include file="../Head.jsp"%>
<div style="display: none;visibility: hidden;">
    <button onclick="return false;" class="btn btn-primary"
            data-toggle="modal" data-target="#myModal" id="but"></button>
</div>
<div class="row">
    <table class="table-responsive table-bordered col-sm-offset-1 col-sm-10">
        <tr>
            <td bgcolor="#add8e6" class="col-sm-2">
            </td>
            <td valign="top" id="title" class="col-sm-8">
                <h2>${post.title}</h2>
            </td>
            <s:if test="%{only == 0}">
                <button class="btn btn-default" onclick="window.location.href='showCirclePost.action?pid=${post.id}&only=1'">只看楼主</button>
            </s:if>
            <s:else>
                <button class="btn btn-default" onclick="window.location.href='showCirclePost.action?pid=${post.id}'">取消只看楼主</button>
            </s:else>
        </tr>
        <tr>
            <td bgcolor="#add8e6" class="col-sm-2" align="center">
                <strong>${post.poster.nickname}</strong><br>
                <s:if test="%{post.poster.head == ''}">
                    <img id="img_user" src="../photo/head.jpg">
                </s:if>
                <s:else>
                    <img id="img_user" src="photo/${post.poster.username.hashCode()}${post.poster.head}">
                </s:else>
                <br><br>
            </td>
            <td valign="top">
                <div class="col-sm-8">
                    发表于：${post.time}<br><br>
                    ${post.content}
                </div>
                <div class="col-sm-3" align="right">
                    <br><br>楼主
                </div>
                <div class="col-sm-1">
                    <s:if test="#session.username != null">
                        <button class="btn btn-default" onclick="reply()">回复</button>
                    </s:if>
                    <s:else>
                        <button class="btn btn-default" onclick="window.location.href='login.action'">回复</button>
                    </s:else>

                </div>
            </td>
        </tr>
        <s:iterator value="replyList" status="st">
            <s:if test="%{only==0||(only==1&&replier.username.equals(post.poster.username))}">
                <tr>
                    <td bgcolor="#add8e6" class="col-sm-2" align="center">
                        <strong>${replier.nickname}</strong><br>
                        <s:if test="%{replier.head == ''}">
                            <img id="img_user" src="../photo/head.jpg">
                        </s:if>
                        <s:else>
                            <img id="img_user" src="photo/${replier.username.hashCode()}${replier.head}">
                        </s:else>
                        <br><br>
                    </td>
                    <td valign="top">
                        <div class="col-sm-8">
                            回复${parentReply.floor}楼于：${time}<br><br>
                            <s:if test="%{parentId != -1}">
                                回复：
                                <div style="background: lightgray">
                                        ${parentReply.replier.nickname} 发表于 ${parentReply.time}
                                    <br>
                                        ${parentReply.content}<br>
                                </div>
                            </s:if>
                                ${content}
                        </div>
                        <div class="col-sm-3" align="right">
                            <br><br>${floor}楼
                        </div>
                        <div class="col-sm-1">
                            <s:if test="#session.username != null">
                                <button class="btn btn-default" onclick="replyToFloor(${id})">回复</button>
                            </s:if>
                            <s:else>
                                <button class="btn btn-default" onclick="window.location.href='login.action'">回复</button>
                            </s:else>
                            <s:if test="#session.power == 1">
                                <button class="btn btn-default" onclick="deleteReply(${id})">删除</button>
                            </s:if>
                        </div>
                    </td>
                </tr>
            </s:if>
        </s:iterator>
    </table>
</div>
<s:if test="%{pageCount > 1}">
    <nav>
        <ul class="pager">
            <li><a href="showPost.action?pid=${pid}&pageNumber=${1}">首页</a></li>
            <li><a href="showPost.action?pid=${pid}&pageNumber=${pageNumber-1}">上一页</a></li>
            <li>${pageNumber}/${pageCount}</li>
            <li><a href="showPost.action?pid=${pid}&pageNumber=${pageNumber+1}">下一页</a></li>
            <li><a href="showPost.action?pid=${pid}&pageNumber=${pageCount}">末页</a></li>
        </ul>
    </nav>
</s:if>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                <h4 class="modal-title" id="myModalLabel">回复</h4>
            </div>
            <form action="addCircleReply.action" method="post" class="form-horizontal" role="form">
                <div class="modal-body">
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-8">
                    <textarea id="area" rows="10" cols="50"
                              name="content" maxlength="4000"
                              placeholder="请输入回复内容，4~4000字符"
                              class="form-control"
                    ></textarea>
                        </div>
                    </div>
                    <input type="hidden" name="postId" value="${post.id}">
                    <input type="hidden" name="parentId" id="parentId" value="${-1}">
                    <input type="hidden" name="replier.id" value="${session.id}">
                    <input type="hidden" name="circleId" value="${post.circleId}">
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
