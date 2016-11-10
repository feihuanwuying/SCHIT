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
    <link rel="stylesheet" type="text/css" href="css/post_style.css">
</head>
<script type="text/javascript">
    function reply() {
        document.getElementById("parentId").value = -1;
        document.getElementById("area").focus();
    }
    function replyToFloor(floorId) {
        document.getElementById("parentId").value = floorId;
        document.getElementById("area").focus();
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
</script>
<body>
<%@include file="Head.jsp"%>
    <div class="row">
        <div class="col-sm-6" id="detail_title">帖子标题：${post.title} </div>
    </div>
    <div class="row" id="detail_up">
        <div class="col-sm-1">楼主</div>
        <div class="col-sm-2">
            <img src="http://pic2.52pk.com/files/160907/7247438_130524_1_lit.jpg"/>
            ${post.poster.nickname}
        </div>
        <div class="col-sm-7">${post.content}</div>
        <div class="col-sm-1">发帖时间：${post.time}</div>
        <s:if test="#session.username != null">
            <button onclick="reply()">回复</button>
        </s:if>
        <s:else>
            <button onclick="window.location.href='login.action'">回复</button>
        </s:else>
        <br><br>
    </div>
    <s:iterator value="replyList" status="st">
        <%--如果是回帖，不算在正常楼层中，而且有一个缩进--%>
        <s:if test="%{parentId != -1}">
            <div class="row" >
                <div class="col-sm-2"></div>
                <div class="col-sm-2" id="reply_body">
                    <img src="http://images.17173.com/2016/news/2016/04/29/gxy0429dd03s.jpg"/>
                    ${lastReply.replier.nickname}
                </div>
                <div class="col-sm-4" id="reply_body">
                    <strong>回复${parentReply.floor}楼：</strong>${parentReply.replier.nickname}：
                        ${parentReply.content}
                    <br>${content}<br>
                </div>
                <div class="col-sm-1" id="reply_body">
                    回复于：${time}
                </div>
                <s:if test="#session.username != null">
                    <button onclick="replyToFloor(${id})">回复</button>
                </s:if>
                <s:else>
                    <button onclick="window.location.href='login.action'">回复</button>
                </s:else>
                <s:if test="#session.power == 1">
                    <button onclick="window.location.href='deleteReply.action?id=${id}'">删除</button>
                </s:if>
            </div>
        </s:if>

        <s:else>
            <div class="row" id="detail_body">
                <div class="col-sm-1">
                    ${floor}楼
                </div>
                <div class="col-sm-2">
                    <img src="http://pic.962.net/up/2016-5/201605200847278414228.jpg"/>
                    ${lastReply.replier.nickname}
                </div>
                <div class="col-sm-7" id="detail-body">
                    <br>${content}<br>
                </div>
                <div class="col-sm-1" id="detail-body">
                    回复于：${time}
                </div>
                <s:if test="#session.username != null">
                    <button onclick="replyToFloor(${id})">回复</button>
                </s:if>
                <s:else>
                    <button onclick="window.location.href='login.action'">回复</button>
                </s:else>
                <s:if test="#session.power == 1">
                    <button onclick="window.location.href='deleteReply.action?id=${id}'">删除</button>
                </s:if>
            </div>
        </s:else>
    </s:iterator>
    <nav>
        <ul class="pager">
            <li><a href="showPost.action?pid=${pid}&pageNumber=${1}">首页</a></li>
            <li><a href="showPost.action?pid=${pid}&pageNumber=${pageNumber-1}">上一页</a></li>
            <li><a href="showPost.action?pid=${pid}&pageNumber=${pageNumber+1}">下一页</a></li>
            <li><a href="showPost.action?pid=${pid}&pageNumber=${pageCount}">末页</a></li>
        </ul>
    </nav>
    <s:if test="#session.username != null">
        <form action="addReply.action" method="post">
            <textarea id="area" rows="10" cols="50" name="content"></textarea>
            <input type="hidden" name="postId" value="${post.id}">
            <input type="hidden" name="parentId" id="parentId" value="${-1}">
            <input type="hidden" name="replier.username" value="${session.username}">
            <input type="hidden" name="type" value="${post.type}">
            <button type="submit" onclick="return checkLength(this.form)">提交</button>
        </form>
    </s:if>
    <s:else>
        <strong><h2>登录开启回复功能！</h2></strong>
    </s:else>
</body>
</html>
