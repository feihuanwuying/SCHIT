<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/12/10
  Time: 23:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../Bootstrap.jsp"%>
    <title>圈子</title>
</head>
<body>
    <%@include file="../Head.jsp"%>
    <div class="row">
        <div class="col-sm-offset-11">
            <button onclick="return false;" class="btn btn-primary"
               data-toggle="modal" data-target="#myModal">创建新圈子</button>
        </div>
    </div>
    <s:if test="%{circleList == null || circleList.size() == 0}">
        <h2 align="center">您还没有自己的圈子哦！</h2>
    </s:if>
    <s:else>
        <div class="row col-sm-offset-1 col-sm-offset-10">
            <div class="row">
                <s:iterator value="circleList">
                    <div class="col-sm-3">
                        <img src="../photo/${label}.jpg" style="width:100px;
                     height:100px;
                     float:left;"/>
                        <a href="showCircleDetail.action?circleId=${id}">
                                ${name}
                        </a><br>人数：${members}<br>
                        未查看：${inform}<br>
                        主题数：${postCount}<br>
                        回帖数：${replyCount}
                        <br><br>
                    </div>
                </s:iterator>
            </div>
        </div>
    </s:else>
    <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>
                    <h4 class="modal-title" id="myModalLabel">创建圈子</h4>
                </div>
                <form action="addCircle.action" method="post" class="form-horizontal" role="form">
                    <div class="modal-body">
                        <div class="form-group">
                            <s:iterator value="friendList">
                                <div class="col-sm-4">
                                    <input type="checkbox" name="userIdList" value=${friend.id}>
                                        ${remark}(${friend.nickname})
                                </div>
                            </s:iterator>
                        </div>
                        <div class="form-group">
                            <div class="col-sm-offset-2 col-sm-4">
                                <input type="text" name="name" required value="${name}"
                                       minlength="2" maxlength="10" class="form-control"
                                       placeholder="请输入圈子名称，2~10个字符">
                            </div>
                            <div class="col-sm-4">
                                <select name="label" required class="form-control">
                                    <option value="学习" selected>学习</option>
                                    <option value="交友">交友</option>
                                    <option value="班级">班级</option>
                                    <option value="运动">运动</option>
                                    <option value="电竞">电竞</option>
                                    <option value="情感">情感</option>
                                    <option value="兼职">兼职</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                        <button type="submit" class="btn btn-primary">创建</button>
                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
