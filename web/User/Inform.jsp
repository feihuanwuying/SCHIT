<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/11/29
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../Bootstrap.jsp"%>
    <title>查看通知</title>
</head>
<body>
    <%@include file="../Head.jsp"%>
    <table class="table-bordered table-responsive">
        <tr>
            <th>内容</th>
            <th>时间</th>
            <th>操作</th>
        </tr>
        <s:iterator value="informList">
            <s:if test="%{informType == 6}">
                <!-- 好友留言-->
                <s:if test="%{#session.id != friend.friend.id}">
                    <tr>
                        <td>
                            <strong>${friend.friend.nickname}</strong>给您留言:
                            ${friendMessage}
                        </td>
                        <td>${time}</td>
                        <td><a href="#">回复</a> </td>
                    </tr>
                </s:if>
            </s:if>
            <s:elseif test="%{informType == 1}">
                <tr>
                    <td>
                        <strong>${friend.friend.nickname}</strong> 请求添加您为好友，
                        附加信息：${friendMessage.equals("")?"无":friendMessage}
                    </td>
                    <td>${time}</td>
                    <td><s:if test="%{treatment == 0 || treatment == 1}">
                        <a href="#">同意</a>
                        <a href="" onclick="return false;"
                           data-toggle="modal" data-target="#denyModal">拒绝</a>
                        <div class="modal fade" id="denyModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                            <div class="modal-dialog">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                        <h4 class="modal-title" id="myModalLabel">拒绝</h4>
                                    </div>
                                    <form action="denyFriend.action" method="post">
                                        <div class="modal-body">
                                            附加信息<input type="text" maxlength="100" name="message">
                                            <input type="hidden" name="informId" value="${id}">
                                        </div>
                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                            <button type="submit" class="btn btn-primary">发送</button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </s:if>
                        <s:elseif test="%{treatment == 2}">
                            已同意
                        </s:elseif>
                        <s:elseif test="%{treatment == 3}">
                            已拒绝
                        </s:elseif>
                    </td>
                </tr>
            </s:elseif>
            <s:elseif test="%{informType == 7}">
                <tr>
                    <td>
                        <strong>${friend.friend.nickname}</strong> 拒绝了您的好友请求，附加信息：${friendMessage}
                    </td>
                    <td>${time}</td>
                    <td></td>
                </tr>
            </s:elseif>
        </s:iterator>
    </table>
    <nav>
        <ul class="pager">
            <li><a href="showInform.action?pageNumber=${1}">首页</a></li>
            <li><a href="showInform.action?pageNumber=${pageNumber-1}">上一页</a></li>
            <li>${pageNumber}/${pageCount}</li>
            <li><a href="showInform.action?pageNumber=${pageNumber+1}">下一页</a></li>
            <li><a href="showInform.action?pageNumber=${pageCount}">末页</a></li>
        </ul>
    </nav>
</body>
</html>
