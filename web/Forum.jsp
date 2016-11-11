<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
  Date: 2016/10/24
  Time: 16:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>论坛区</title>
    <link rel="stylesheet" type="text/css" href="css/forum_style.css">
</head>
<body>
    <%@include file="Head.jsp"%>
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
                    <h4>时间大片子 发帖 聊天灌水区：5055寝室出现不明白色液体池</h4>
                    <h4>胥岩是杰宝 回帖 讲座活动区：如何让孩子热爱学习</h4>
                    <h4>单身周擎阳 发帖 交友征婚区：求一个愿意转性的GAY</h4>
                    <h4>天任开天眼 发帖 学习交流区：今天状态很好啊</h4>
                    <%--a class="btn btn-primary" href="#">查看全部</a--%>
                </div>
            </div>
        </div>
        <%--div class="container">
            <div class="row text-center">
                <h3 id="titleword">每日推荐</h3>
                <h4>新型人工机器人将减少世界单身汉数量</h4>
                <h4>知名作家幻飘雪不慎掉入猪圈</h4>
                <h4>周校长将放宽2014届学生保研政策至100%</h4>
                <a class="btn btn-primary" href="#">查看全部</a>
            </div>
        </div--%>
    </section>
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
            <img src="http://www.down.cc/uploads/allimg/160525/71-1605251H449338.jpg"/>
            <a href="showForumDetail.action?type=3">物品交易区</a>
            <br>主题数：<s:property value="map[3][0]"></s:property>
            回复数：<s:property value="map[3][1]"></s:property>
        </div>

        <div class="col-sm-3" id="r1_c4">
            <img src="http://pic1.win4000.com/wallpaper/4/56248f606115e.jpg"/>
            <a href="showForumDetail.action?type=4">家教兼职区</a>
            <br>主题数：<s:property value="map[4][0]"></s:property>
            回复数：<s:property value="map[4][1]"></s:property>
        </div>
    </div>
    <br>
    <br>
    <div class="row">
        <div class="col-sm-3" id="r2_c1">
            <img src="http://tl.wenming.cn/wmcj/wmcz/201410/W020141028600638835124.jpg"/>
            <a href="showForumDetail.action?type=5">聊天灌水区</a>
            <br>主题数：<s:property value="map[5][0]"></s:property>
            回复数：<s:property value="map[5][1]"></s:property>
        </div>

        <div class="col-sm-3" id="r2_c2">
            <img src="http://i.dimg.cc/a6/b4/4c/c5/27/9f/1d/1d/d7/3a/40/41/89/32/b7/e3.jpg"/>
            <a href="showForumDetail.action?type=6">学习交流区</a>
            <br>主题数：<s:property value="map[6][0]"></s:property>
            回复数：<s:property value="map[6][1]"></s:property>
        </div>

        <div class="col-sm-3" id="r2_c3">
            <img src="http://pic.fh21.com.cn/ymtu/images/20060331/4411726.jpg"/>
            <a href="showForumDetail.action?type=7">交友征婚区</a>
            <br>主题数：<s:property value="map[7][0]"></s:property>
            回复数：<s:property value="map[7][1]"></s:property>
        </div>

        <div class="col-sm-3" id="r2_c4">
            <img src="http://img2.3lian.com/2014/f5/29/d/68.jpg"/>
            <a href="showForumDetail.action?type=8">咨询求助区</a>
            <br>主题数：<s:property value="map[8][0]"></s:property>
            回复数：<s:property value="map[8][1]"></s:property>
        </div>
    </div>
    </section>
</body>
</html>
