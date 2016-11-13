<%@ page import="java.util.Date" %>
<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/11/12
  Time: 13:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <div class="panel-heading">头像</div>
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
                        共有3人访问过
                    </div>
                    <div class="row" align="center">
                        发帖数：4
                    </div>
                    <div class="row" align="center">
                        回帖数：5
                    </div>
                    <br><br><br><br>
                </div>
            </div>
        </div>
        <div class="col-sm-4">
            <div class="panel panel-default">
                <div class="panel-heading">个人资料</div>
                <div class="panel-body">
                    <div class="row" align="center">
                        昵称：${user.nickname}
                    </div>
                    <div class="row" align="center">
                        年龄：<%=new Date().getYear()-((Date)request.getAttribute("user.birthday")).getYear()%>
                    </div>
                    <br><br><br><br><br>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">留言板</div>
                <div class="panel-body">
                    <div class="row" align="center">
                        <textarea style="width:90%"></textarea>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-sm-3">
            <div class="panel panel-default">
                <div class="panel-heading">好友</div>
                <div class="panel-body">
                    <div class="row" align="center">
                        高桥（小头像）
                    </div>
                    <div class="row" align="center">
                        梁奎兴（小头像）
                    </div>
                    <br><br>
                </div>
            </div>
            <div class="panel panel-default">
                <div class="panel-heading">最近访客</div>
                <div class="panel-body">
                    这里放一堆访问过的小头像
                </div>
                <br><br><br><br>
            </div>
        </div>
    </div>

</body>
</html>
