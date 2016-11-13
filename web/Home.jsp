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
</script>
<html>
<head>
    <title>个人空间</title>
</head>
<body>
    <%@include file="Head.jsp"%>
    <div class="row-fluid">
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
                        <img src="http://uc.pcbeta.com//data/avatar/004/81/07/37_avatar_middle.jpg">
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
                    <form class="form-horizontal" role="form"
                          method="post">
                        <div class="form-group">
                            <div class="col-sm-12">
                                <textarea id="area"
                                          placeholder="既然来了，说点什么再走吧"
                                          minlength="4" maxlength="200"
                                          class="form-control"
                                ></textarea>
                            </div>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-10">
                                <button type="submit" class="btn btn-default">留言</button>
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
                                <a href="showHome.action?id=${friend.id}">
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
                                <a href="showHome.action?id=${visitor.id}">
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
