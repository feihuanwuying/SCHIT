<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  user: ZouKaifa
  Date: 2016/10/10
  Time: 12:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <link rel="stylesheet" type="text/css" href="css/index_style.css">
</head>
<body>
    <%@include file="Head.jsp"%>
    <section class="container">

        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
            <!-- Indicators -->
            <ol class="carousel-indicators">
                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                <li data-target="#carousel-example-generic" data-slide-to="3"></li>
            </ol>

            <!-- Wrapper for slides -->
            <div class="carousel-inner" role="listbox">
                <div class="item active">
                    <a href="http://www.hit.edu.cn/_redirect?siteId=2&columnId=216&articleId=168743" target="_blank"><img  id="role_image1" src="http://www.hit.edu.cn/_upload/article/images/79/3a/2d4444b140d9add4d27f91832ea9/b8b5bc37-7b15-417c-a732-cc8012cc660e.jpg" alt="..."></a>
                    <div class="carousel-caption">
                        <h3>【图说】纪念钱学森诞辰105周年</h3>
                    </div>
                </div>
                <div class="item">
                    <a href="http://www.hit.edu.cn/_redirect?siteId=2&columnId=216&articleId=167977" target="_blank"><img  id="role_image2" src="http://www.hit.edu.cn/_upload/article/images/4c/d3/c36c008d4ad2b81a2b6ed87d6f80/68a190e1-86f8-49c6-92ec-d1f5a9cfd664.jpg" alt="..."></a>
                    <div class="carousel-caption">
                        <h3>我校研制的新一代磁聚焦型霍尔电推力器在国际上首次实现空间应用</h3>
                    </div>
                </div>
                <div class="item">
                    <a href="http://www.hit.edu.cn/_redirect?siteId=2&columnId=216&articleId=168038" target="_blank"><img id="role_image3" src="http://www.hit.edu.cn/_upload/article/images/bc/b6/ee3eb2f34dac991aeefa3ddb32bb/a18fb9b1-dfae-44ad-85d0-135ff5361202.jpg" alt="..."></a>
                    <div class="carousel-caption">
                        <h3>肿瘤诊疗一体化研究获突破 我校科研成果发表于《先进材料》</h3>
                    </div>
                </div>
                <div class="item">
                    <a href="http://www.hit.edu.cn/_redirect?siteId=2&columnId=216&articleId=168031" target="_blank"><img id="role_image4" src="http://www.hit.edu.cn/_upload/article/images/8f/01/2d2852184cf8964abd1c79553847/f6da4d70-52cf-4887-a8c1-ef581ed0a37f.jpg" alt="..."></a>
                    <div class="carousel-caption">
                        <h3>像鱼一样在流体中快速运动 我校磁场驱动仿鱼形纳米马达研究取得重要进展</h3>
                    </div>
                </div>
            </div>

            <!-- Controls -->
            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>

        <div class="row" id="center_2">
            <div class="col-sm-3" id="center_2_1">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3>今日哈工大</h3></div>
                    <div class="panel-body">
                        <a href="http://today.hit.edu.cn/news/2016/11-30/7773346111RL0.htm" target="_blank"><h5>关于报送2016年年度工作总结及2017年工作要点的通知</h5></a>
                        <a href="http://today.hit.edu.cn/news/2016/12-07/6451146121RL0.htm" target="_blank"><h5>关于国防特色学科专业建设项目集中归档的通知</h5></a>
                        <a href="http://today.hit.edu.cn/news/2016/12-09/6391137121RL1.htm" target="_blank"><h5>关于《哈工大读本》书目荐阅活动的通知</h5></a>
                        <a href="http://today.hit.edu.cn/news/2016/12-08/4355139021RL1.htm" target="_blank"><h5>学校办公室关于暂停校印使用的通知</h5></a>
                    </div>
                </div>
            </div>
            <div class="col-sm-3" id="center_2_2">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3>学校新闻</h3></div>
                    <div class="panel-body">
                        <a href="http://today.hit.edu.cn/news/2016/12-12/5104431121RL0.htm" target="_blank"><h5>【教职工绿色健康年】12月12日——12月18日“教职工绿色健康年”活动公告</h5></a>
                        <a href="http://today.hit.edu.cn/news/2016/12-12/3314200121RL0.htm" target="_blank"><h5>美国驻沈阳领事馆签证讲座通知</h5></a>
                        <a href="http://today.hit.edu.cn/news/2016/12-12/3555449021RL0.htm" target="_blank"><h5>关于2016年秋季学期住房货币化补贴发放的通知</h5></a>
                        <a href="http://today.hit.edu.cn/news/2016/12-12/7633039021RL0.htm" target="_blank"><h5>第五届“中外一家亲”晚会震撼来袭</h5></a>
                    </div>
                </div>
            </div>
            <div class="col-sm-3" id="center_2_3">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3>学校活动信息</h3></div>
                    <div class="panel-body">
                        <a href="http://today.hit.edu.cn/news/2016/12-09/121418121RL1.htm" target="_blank"><h5>一站到底——趣味知识问答类活动通知</h5></a>
                        <a href="http://today.hit.edu.cn/news/2016/12-09/6295057121RL0.htm" target="_blank"><h5>【十佳社团】2016年度“十佳社团”颁奖典礼直播预告</h5></a>
                        <a href="http://today.hit.edu.cn/news/2016/12-09/2935025121RL0.htm" target="_blank"><h5>【备战电路】电气大讲堂第七讲之电路复习讲座预告</h5></a>
                        <a href="http://today.hit.edu.cn/news/2016/12-09/1255554121RL0.htm" target="_blank"><h5>【周末影院】第九期放映预告：《奇幻森林》</h5></a>
                    </div>
                </div>
            </div>
            <div class="col-sm-3" id="center_2_4">
                <div class="panel panel-default">
                    <div class="panel-heading"><h3>友情链接</h3></div>
                    <div class="panel-body">
                        <ul>
                            <li><a href="http://www.hit.edu.cn" target="_blank">哈工大主页</a></li>
                            <li><a href="http://jwc.hit.edu.cn" target="_blank">哈工大教务处</a></li>
                            <li><a href="http://map.hit.edu.cn" target="_blank">哈工大三维地图</a></li>
                            <li><a href="http://cms.hit.edu.cn" target="_blank">哈工大乐学网</a></li>
                            <li><a href="http://www.lib.hit.edu.cn" target="_blank">哈工大图书馆</a> </li>
                            <li><a href="http://today.hit.edu.cn" target="_blank">今日哈工大</a> </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>

</body>
</html>
