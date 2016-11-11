<%@ page import="java.io.File" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/11/11
  Time: 10:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@include file="Head.jsp"%>
    <s:form action="testImg" enctype="multipart/form-data">
        <s:file name="file" />
        <button type="submit">上传</button>
    </s:form>


    <%
        out.print("<img src='img/"+
                    session.getAttribute("username").hashCode()+".jpg'"
                    +"/>");
    %>

</body>
</html>
