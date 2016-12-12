<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  user: ZouKaifa
  Date: 2016/11/29
  Time: 13:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看通知</title>
</head>
<body>
    <%@include file="../Head.jsp"%>
    <div class="row col-sm-offset-2 col-sm-8">
        <table class="table table-bordered table-responsive table-striped">
            <tr>
                <td>内容</td>
                <td>时间</td>
                <td>操作</td>
            </tr>
            <s:iterator value="informList">
                <s:if test="%{informType == 6}">
                    <!-- 好友留言-->
                    <s:if test="%{#session.id != friend.friend.id}">
                        <tr>
                            <td>
                                <a href="showHome.action?id=${friend.friend.id}"><strong>${friend.friend.nickname}</strong></a>给您留言:
                                    ${friendMessage}
                            </td>
                            <td>${time}</td>
                            <td><a href="" onclick="return false;"
                            data-toggle="modal" data-target="#mess">回踩</a> </td>
                            <div class="modal fade" id="mess" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <h4 class="modal-title" id="myModalLabel">私信</h4>
                                        </div>
                                        <form class="form-horizontal" role="form"
                                              method="post" action="addMessage.action">
                                            <div class="modal-body" style="text-align: center">
                                                <textarea id="area" rows="10" cols="50"
                                                          name="message" maxlength="100" minlength="2"
                                                          placeholder="请输入留言内容，2~100字符"
                                                          class="form-control" required
                                                ></textarea>
                                                <input type="hidden" name="userId" value="${friend.friend.id}">
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                <button type="submit" class="btn btn-primary">发送</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </tr>
                    </s:if>
                </s:if>
                <s:elseif test="%{informType == 1}">
                    <tr>
                        <td>
                            <a href="showHome.action?id=${friend.friend.id}"><strong>${friend.friend.nickname}</strong></a> 请求添加您为好友，
                            附加信息：${friendMessage.equals("")?"无":friendMessage}
                        </td>
                        <td>${time}</td>
                        <td><s:if test="%{treatment == 0 || treatment == 1}">
                            <a href="" onclick="return false;"
                               data-toggle="modal" data-target="#agreeModal">同意</a>
                            <div class="modal fade" id="agreeModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <h4 class="modal-title" id="myModalLabel">添加新好友</h4>
                                        </div>
                                        <form action="agreeFriend.action" method="post">
                                            <div class="modal-body">
                                                备注<input type="text" maxlength="30" name="remark">
                                                <input type="hidden" name="informId" value="${id}">
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                <button type="submit" class="btn btn-primary">添加</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
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
                            <a href="showHome.action?id=${friend.friend.id}"><strong>${friend.friend.nickname}</strong></a> 拒绝了您的好友请求，附加信息：${friendMessage}
                        </td>
                        <td>${time}</td>
                        <td></td>
                    </tr>
                </s:elseif>
                <s:elseif test="%{informType == 3}">
                    <tr>
                        <td>
                            <a href="showHome.action?id=${friend.friend.id}"><strong>${friend.friend.nickname}</strong></a> 同意了您的好友请求
                        </td>
                        <td>${time}</td>
                        <td></td>
                    </tr>
                </s:elseif>
                <s:elseif test="%{informType == 4}">
                    <tr>
                        <td>
                            <a href="showHome.action?id=${friend.friend.id}"><strong>${friend.friend.nickname}</strong></a>
                            在<a href="showPost.action?pid=${informId}" target="_blank">${friend.remark}</a>中回复您：
                                ${friendMessage}
                        </td>
                        <td>${time}</td>
                        <td></td>
                    </tr>
                </s:elseif>
                <s:elseif test="%{informType == 2}">
                    <tr>
                        <td>
                            <a href="showHome.action?id=${friend.friend.id}"><strong>${friend.friend.nickname}</strong></a>
                            向您发送私信：${friendMessage}
                        </td>
                        <td>${time}</td>
                        <td>
                            <a href="" onclick="return false;"
                               data-toggle="modal" data-target="#message">回复</a>
                            <div class="modal fade" id="message" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
                                <div class="modal-dialog">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                                            <h4 class="modal-title" id="myModalLabel">私信</h4>
                                        </div>
                                        <form action="sendMessage.action" method="post">
                                            <div class="modal-body" style="text-align: center">
                                                <textarea id="area" rows="10" cols="50"
                                                          name="message" maxlength="1000" minlength="2"
                                                          placeholder="请输入私信内容，2~1000字符"
                                                          class="form-control" required
                                                ></textarea>
                                                <input type="hidden" name="id" value="${friend.friend.id}">
                                            </div>
                                            <div class="modal-footer">
                                                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                                                <button type="submit" class="btn btn-primary">发送</button>
                                            </div>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </td>
                    </tr>
                </s:elseif>
                <s:elseif test="%{informType == 8}">
                    <td>
                        <a href="showPost.action?id=${friend.friend.id}">
                            <strong>${friend.friend.nickname}</strong></a>
                            邀请您加入了圈子：
                            <a href="showCircleDetail.action?id=${informId}">${friend.remark}</a>
                        </a>
                    </td>
                </s:elseif>
            </s:iterator>
        </table>
        <s:if test="%{pageCount > 1}">
            <nav>
                <ul class="pager">
                    <li><a href="showInform.action?pageNumber=${1}">首页</a></li>
                    <li><a href="showInform.action?pageNumber=${pageNumber-1}">上一页</a></li>
                    <li>${pageNumber}/${pageCount}</li>
                    <li><a href="showInform.action?pageNumber=${pageNumber+1}">下一页</a></li>
                    <li><a href="showInform.action?pageNumber=${pageCount}">末页</a></li>
                </ul>
            </nav>
        </s:if>
    </div>
</body>
</html>
