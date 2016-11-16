<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/11/5
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">
    function remark(id) {
        var newRemark = prompt("请输入新的备注:");
        window.location.href = "updateRemark.action?friendId="+id+"&remark="+newRemark;
    };
    function deletef(pid) {
        var answer = confirm("确定要删除吗？");
        if (answer == true) {
            window.location.href = "deleteFriend.action?friendId="+pid;
        }
    }
</script>
<html>
<head>
    <title>查看好友</title>
</head>
<body>
    <%@include file="../Head.jsp"%>
    <h3 align="center">${user.username.equals(sessionScope.get("username"))?"您":"Ta"}共有${friendCount}个好友</h3>
    <table class="table">
        <s:iterator value="friendList">
            <tr class="col-sm-offset-3 col-sm-6">
                <td class="col-sm-3" align="center">${remark}(${friend.nickname})</td>
                <td class="col-sm-1" align="center"><a href="showHome.action?id=${friend.id}" target="_blank">查看资料</a> </td>
                <td class="col-sm-1" align="center"><a onclick="remark(${friend.id})">修改备注</a> </td>
                <td class="col-sm-1" align="center"><a onclick="deletef(${friend.id})">删除</a> </td>
            </tr>
        </s:iterator>
    </table>
    <s:if test="%{friendCount > 8}">
        <nav>
            <ul class="pager">
                <li><a href="friendList.action?pageNumber=${1}&id=${id}">首页</a></li>
                <li><a href="friendList.action?pageNumber=${pageNumber-1}&id=${id}">上一页</a></li>
                <li>${pageNumber}/${pageCount}</li>
                <li><a href="friendList.action?pageNumber=${pageNumber+1}&id=${id}">下一页</a></li>
                <li><a href="friendList.action?pageNumber=${pageCount}&id=${id}">末页</a></li>
            </ul>
        </nav>
    </s:if>
</body>
</html>
