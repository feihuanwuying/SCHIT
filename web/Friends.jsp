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
</script>
<html>
<head>
    <title>查看好友</title>
</head>
<body>
    <%@include file="Head.jsp"%>
    <h3 align="center">您共有${friendCount}个好友</h3>
    <table class="table">
        <s:iterator value="friendList">
            <tr class="col-sm-offset-3 col-sm-6">
                <td class="col-sm-3" align="center">${remark}(${friend.nickname})</td>
                <td class="col-sm-1" align="center"><a href="showHome.action?id=${friend.id}" target="_blank">查看资料</a> </td>
                <td class="col-sm-1" align="center"><a onclick="remark(${friend.id})">修改备注</a> </td>
                <td class="col-sm-1" align="center"><a href="#">删除</a> </td>
            </tr>
        </s:iterator>
    </table>
    <nav>
        <ul class="pager">
            <li><a href="friendList.action?pageNumber=${1}&id=${id}">首页</a></li>
            <li><a href="friendList.action?pageNumber=${pageNumber-1}&id=${id}">上一页</a></li>
            <li>${pageNumber}/${pageCount}</li>
            <li><a href="friendList.action?pageNumber=${pageNumber+1}&id=${id}">下一页</a></li>
            <li><a href="friendList.action?pageNumber=${pageCount}&id=${id}">末页</a></li>
        </ul>
    </nav>
</body>
</html>
