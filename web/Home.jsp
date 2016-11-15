<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/11/12
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String[] sexs = {"保密", "男", "女"};
%>
<script type="text/javascript">
    onload = function () {
        area = document.getElementById("area")
        area.style.height = document.body.clientHeight*0.18;
    }
    window.onresize = function () {
        area = document.getElementById("area")
        area.style.height = document.body.clientHeight*0.18;
    }
    function checkLength(form) {
        var content = form.message.value;
        if (content.length < 2) {
            alert("至少输入2个字符！");
            return false;
        } else if (content.length > 100) {
            alert("不可以超过100字符！")
            return false;
        }
        return true;
    }
</script>
<html>
<head>
    <title>个人空间</title>
</head>
<body>
    <%@include file="Head.jsp"%>
    <div class="row">
        <div class="col-sm-12" align="center">
            <h2>${user.nickname}的个人空间</h2>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3 col-sm-offset-1">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-6" align="left">
                            头像
                        </div>
                        <s:if test="%{user.username.equals(#session.username)}">
                            <div class="col-sm-6" align="right">
                                <a href="#">更换头像</a>
                            </div>
                        </s:if>
                    </div>
                </div>
                <div class="panel-body">
                    <div align="center">
                        <s:if test="%{user.head == ''}">
                            <img src="photo/head.jpg">
                        </s:if>
                        <s:else>
                            <img src="photo/${user.username.hashCode()}${user.head}">
                        </s:else>
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">统计信息</div>
                <div class="panel-body">
                    <div class="row" align="center">
                        共有${visitCount}人访问过${user.id==session.id?"您":"Ta"}的个人空间
                    </div>
                    <div class="row" align="center">
                        发帖数：${postCount}
                        回帖数：${replyCount}
                        好友数：${friendList.size()}
                    </div>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-6" align="left">
                            主题
                        </div>
                        <div class="col-sm-6" align="right">
                            <a href="#">查看全部</a>
                        </div>
                    </div>
                </div>
                <div class="panel-body">
                    <s:if test="%{postCount > 0}">
                        <s:iterator value="postList" status="st">
                            <s:if test="%{#st.index <= 2}">
                                <div class="col-sm-12">
                                        ${time}：<a href="showPost.action?pid=${id}" target="_blank">${title}</a>
                                </div>
                            </s:if>
                        </s:iterator>
                    </s:if>
                    <s:else>
                        还没有发表过主题哦！
                    </s:else>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-6" align="left">
                            个人资料
                        </div>
                        <s:if test="%{user.username.equals(#session.username)}">
                            <div class="col-sm-6" align="right">
                                <a href="#">编辑资料</a>
                            </div>
                        </s:if>
                    </div>
                </div>
                <div class="panel-body">
                    &emsp;昵称：${user.nickname}<br>
                    &emsp;性别：<%=sexs[(int)request.getAttribute("user.sex")]%><br>
                    &emsp;年龄：<s:if test="%{user.birthday == null}">保密</s:if><s:else><%=new Date().getYear()-((Date)request.getAttribute("user.birthday")).getYear()%></s:else><br>
                    &emsp;真实姓名：${user.realName.equals("") ? "保密":user.realName}<br>
                    &emsp;qq号：${user.qq.equals("")?"保密":user.qq}<br>
                    &emsp;手机号：${user.tel.equals("")?"保密":user.tel}<br>
                    &emsp;自我介绍：${user.selfIntro.equals("")?"这个人很懒，什么都没有留下":user.selfIntro}<br>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-6" align="left">
                            留言板
                        </div>
                        <s:if test="%{0 != 0}">
                            <div class="col-sm-6" align="right">
                                <a href="#">查看全部</a>
                            </div>
                        </s:if>
                    </div>
                </div>
                <div class="panel-body">
                    <s:iterator value="informList" status="st">
                        <div class="col-sm-12">
                                <a href="showHome.action?id=${friend.friend.id}" target="_blank"> ${friend.friend.nickname}</a>
                                ${time}：${friendMessage}
                        </div>
                        <br><br>
                    </s:iterator>
                    <form class="form-horizontal" role="form"
                          method="post" action="addMessage.action">
                        <div class="form-group">
                            <div class="col-sm-12">
                            <textarea id="area" name="message"
                                      placeholder="既然来了，说点什么再走吧"
                                      minlength="2" maxlength="100"
                                      class="form-control"
                            ></textarea>
                            <input type="hidden" name="userId" value="${user.id}">
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-10">
                                <button type="submit" class="btn btn-default"
                                onclick="return checkLength(this.form);">留言</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-6" align="left">
                            好友
                        </div>
                        <s:if test="%{friendList.size() != 0}">
                            <div class="col-sm-6" align="right">
                                <a href="friendList.action?id=${user.id}">查看全部</a>
                            </div>
                        </s:if>
                    </div>
                </div>
                <div class="panel-body">
                    <s:if test="%{friendList.size() == 0}">
                        ${user.id==session.id?"您":"Ta"}还没有好友哦！
                    </s:if>
                    <s:else>
                        <s:iterator value="friendList" status="st">
                            <s:if test="%{#st.index <= 4}">
                                <a href="showHome.action?id=${friend.id}" target="_blank">
                                    ${remark}（${friend.nickname}）<br>
                                </a>
                            </s:if>
                        </s:iterator>
                    </s:else>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">
                    <div class="row">
                        <div class="col-sm-6" align="left">
                            最近访客
                        </div>
                        <s:if test="%{visitList.size() != 0}">
                            <div class="col-sm-6" align="right">
                                <a href="#">查看全部</a>
                            </div>
                        </s:if>
                    </div>
                </div>
                <div class="panel-body">
                    <s:if test="%{visitList.size() == 0}">
                        最近还没有访客哦！
                    </s:if>
                    <s:else>
                        <s:iterator value="visitList" status="st">
                            <s:if test="%{#st.index <= 4}">
                                <a href="showHome.action?id=${visitor.id}" target="_blank">
                                ${visitor.nickname}</a>&nbsp;&nbsp;最后访问：${time}
                                <br>
                            </s:if>
                        </s:iterator>
                    </s:else>
                </div>
            </div>
        </div>
    </div>

</body>
</html>
