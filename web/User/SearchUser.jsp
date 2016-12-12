<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/11/29
  Time: 9:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../Bootstrap.jsp"%>
    <link rel="stylesheet" type="text/css" href="../css/searchuser_style.css">
    <title>好友搜索</title>
</head>
<body>
    <%@include file="../Head.jsp"%>
    <form action="searchUser.action" method="post">
        <div class="top-search">请输入昵称进行搜索：</div >
        <input type="text" name="nickname">
        <button class="btn btn-primary" type="submit">搜索</button>
    </form>
    <s:if test="%{userList != null}">
        <s:if test="%{userList.size() == 0}">
            <h2 align="center">没有用户！</h2>
        </s:if>
        <s:else>

            <div class="row">
                <div class="col-sm-12">共搜索到${userList.size()}个用户</div>
            </div>
        <s:iterator value="userList">
            <div class="row col-sm-offset-4">
                <div class="col-sm-2" align="center">
                    <s:if test="%{head == ''}">
                        <img style="width: 66px;height:66px;" src="../photo/head.jpg">
                    </s:if>
                    <s:else>
                        <img style="width: 66px;height:66px;" src="../photo/${username.hashCode()}${head}">
                    </s:else>
                        <br>${nickname}</div>
                <div class="col-sm-2" align="center"><a href="showHome.action?id=${id}" target="_blank">更多信息</a></div>
                <div class="col-sm-2" align="center">
                    <a href="" onclick="return false;"
                       data-toggle="modal" data-target="#myModal">加为好友</a>
                    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                        <div class="modal-dialog">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                    <h4 class="modal-title" id="myModalLabel">添加好友</h4>
                                </div>
                                <form action="applyFriend.action" method="post">
                                    <div class="modal-body">
                                        备注<input type="text" maxlength="30" name="remark"><br>
                                        附加信息<input type="text" maxlength="100" name="message">
                                        <input type="hidden" name="friendId" value="${id}">
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                        <button type="submit" class="btn btn-primary">发送请求</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </s:iterator>
            <nav>
                <ul class="pager">
                    <li><a href="searchUser.action?nickname=${nickname}&pageNumber=${1}">首页</a></li>
                    <li><a href="searchUser.action?nickname=${nickname}&pageNumber=${pageNumber-1}">上一页</a></li>
                    <li>${pageNumber}/${pageCount}</li>
                    <li><a href="searchUser.action?nickname=${nickname}&pageNumber=${pageNumber+1}">下一页</a></li>
                    <li><a href="searchUser.action?nickname=${nickname}&pageNumber=${pageCount}">末页</a></li>
                </ul>
            </nav>
        </s:else>
    </s:if>


</body>
</html>
