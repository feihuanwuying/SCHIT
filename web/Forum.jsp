<%@ page import="vo.Post" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/10/24
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    String[] types = {"", "讲座活动区", "招聘信息区", "物品交易区", "家教兼职区",
    "聊天灌水区", "学习交流区", "交友征婚区", "咨询求助区"};
%>
<html>
<head>
    <title>论坛区</title>
    <link rel="stylesheet" type="text/css" href="css/forum_style.css">
</head>
<body>
    <%@include file="Head.jsp"%>
    <!--
    <section class="jumbotron">
        <div class="container">
            <div class="row text-center">
                <h2>论坛区</h2>
            </div>
        </div>
        <div class="container">
            <div class="row text-center">
                <div class="text">
                    <h3 id="titleword">最新发帖</h3>
                    <%
                        List<Post> list = (List<Post>) request.getAttribute("latestPostList");
                        for (int i = 0; i < list.size(); i++) {
                            out.print("<h4>" +list.get(i).getPoster().getNickname()+
                                    "在 <a href='showForumDetail.action?type="
                                    + list.get(i).getType()+"'>"
                                    + types[list.get(i).getType()] +
                                    "</a> 发帖：<a href='showPost?pid=" +
                                    list.get(i).getId()+"'>"+
                                    list.get(i).getTitle() +
                                    "</a></h4>");
                        }
                    %>
                    <%--a class="btn btn-primary" href="#">查看全部</a--%>
                </div>
            </div>
        </div>

        <div class="container" id="jum_img">

        </div>
    </section>
    -->
    <section class="container">
    <div class="row">
        <div class="col-sm-3" id="r1_c1">
            <img src="http://img1.niutuku.com/vector/201101/2703/img18159389.jpg"/>
            <a href="showForumDetail.action?type=1">讲座活动区</a>
            <br>主题数：<s:property value="map[1][0]"></s:property>
            回复数：<s:property value="map[1][1]"></s:property>
        </div>

        <div class="col-sm-3" id="r1_c2">
            <img src="http://img02.tooopen.com/images/20150518/tooopen_sy_124909121826.jpg"/>
            <a href="showForumDetail.action?type=2">招聘信息区</a>
            <br>主题数：<s:property value="map[2][0]"></s:property>
            回复数：<s:property value="map[2][1]"></s:property>
        </div>

        <div class="col-sm-3" id="r1_c3">
            <img src="photo/shop.jpg"/>
            <a href="showForumDetail.action?type=3">物品交易区</a>
            <br>主题数：<s:property value="map[3][0]"></s:property>
            回复数：<s:property value="map[3][1]"></s:property>
        </div>

        <div class="col-sm-3" id="r1_c4">
            <!http://img5.imgtn.bdimg.com/it/u=3111751426,1434100115&fm=21&gp=0.jpg>
            <img src="photo/teach.jpg"/>
            <a href="showForumDetail.action?type=4">家教兼职区</a>
            <br>主题数：<s:property value="map[4][0]"></s:property>
            回复数：<s:property value="map[4][1]"></s:property>
        </div>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col-sm-3" id="r2_c1">
            <!http://img3.imgtn.bdimg.com/it/u=2214176382,148781067&fm=21&gp=0.jpg>
            <img src="photo/chat.png"/>
            <a href="showForumDetail.action?type=5">聊天灌水区</a>
            <br>主题数：<s:property value="map[5][0]"></s:property>
            回复数：<s:property value="map[5][1]"></s:property>
        </div>

        <div class="col-sm-3" id="r2_c2">
            <img src="photo/study.jpg"/>
            <a href="showForumDetail.action?type=6">学习交流区</a>
            <br>主题数：<s:property value="map[6][0]"></s:property>
            回复数：<s:property value="map[6][1]"></s:property>
        </div>

        <div class="col-sm-3" id="r2_c3">
            <img src="photo/love.jpg"/>
            <a href="showForumDetail.action?type=7">交友征婚区</a>
            <br>主题数：<s:property value="map[7][0]"></s:property>
            回复数：<s:property value="map[7][1]"></s:property>
        </div>

        <div class="col-sm-3" id="r2_c4">
            <!http://img4.imgtn.bdimg.com/it/u=3946467442,3069249694&fm=21&gp=0.jpg>
            <img src="photo/phy.jpg"/>
            <a href="showForumDetail.action?type=8">咨询求助区</a>
            <br>主题数：<s:property value="map[8][0]"></s:property>
            回复数：<s:property value="map[8][1]"></s:property>
        </div>
    </div>
    </section>
</body>
</html>
