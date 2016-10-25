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
    帖子标题：${post.title} <br>
    帖子作者：${post.posterNickName} <br>
    帖子内容：${post.content} <br>
    帖子时间：${post.time} <br>
    <s:if test="#session.username != null">
        <button onclick="reply()">回复</button>
    </s:if>
    <s:else>
        <button onclick="window.location.href='login.action'">回复</button>
    </s:else>
    <br><br>

    <s:iterator value="replyList" status="st">
        <s:property value="floor"></s:property>楼
        <s:property value="replierNickName"></s:property>
        <s:if test="%{parentId != -1}">
            <br>
            <strong>回复<s:property value="parentReply.floor"></s:property>楼：</strong><s:property value="parentReply.replierNickName"></s:property>：
            <s:property value="parentReply.content"></s:property>
        </s:if>
        <br>
        <s:property value="content"></s:property>
        <br>
        回复于：<s:property value="time"></s:property>
        <s:if test="#session.username != null">
            <button onclick="replyToFloor(<s:property value='id'></s:property>)">回复</button>
        </s:if>
        <s:else>
            <button onclick="window.location.href='login.action'">回复</button>
        </s:else>
        <br>
        <br>
        <br>
    </s:iterator>

    <a href="showPost.action?pid=${pid}&pageNumber=${1}">首页</a>
    <a href="showPost.action?pid=${pid}&pageNumber=${pageNumber-1}">上一页</a>
    <a href="showPost.action?pid=${pid}&pageNumber=${pageNumber+1}">下一页</a>
    <a href="showPost.action?pid=${pid}&pageNumber=${pageCount}">末页</a>
    <br><br>
    <s:if test="#session.username != null">
        <form action="addReply.action" method="post">
            <textarea id="area" rows="10" cols="50" name="content"></textarea>
            <input type="hidden" name="postId" value="${post.id}">
            <input type="hidden" name="parentId" id="parentId" value="${-1}">
            <input type="hidden" name="replierName" value="${session.username}">
            <input type="hidden" name="type" value="${post.type}">
            <button type="submit" onclick="return checkLength(this.form)">提交</button>
        </form>
    </s:if>
    <s:else>
        <strong><h2>登录开启回复功能！</h2></strong>
    </s:else>
</body>
</html>