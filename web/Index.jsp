<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: ZouKaifa
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
        <%--div class="row" id="first">
            <div class="col-sm-12">
                <CENTER id="center_1">
                    <FONT face=隶书 color=red size=44><MARQUEE direction=up behavior=alternate width=80 height=120>工</MARQUEE></FONT>
                    <FONT face=隶书 color=green size=44><MARQUEE direction=up behavior=alternate width=80 height=80>大</MARQUEE></FONT>
                    <FONT face=隶书 color=violet size=44><MARQUEE direction=up behavior=alternate width=80 height=120>圈</MARQUEE></FONT>
                    <FONT face=隶书 color=purple  size=44><MARQUEE direction=up behavior=alternate width=80 height=80>子</MARQUEE></FONT>
                </CENTER>
            </div>
        </div--%>
        <%--div-- class="row">
            <div class="col-sm-offset-1 col-sm-10" >
                <script language =javascript >
                    var curIndex=0;
                    //时间间隔(单位毫秒)，每秒钟显示一张，数组共有5张图片放在Photos文件夹下。
                    var timeInterval=1000;
                    var arr=new Array();
                    arr[0]="photo/118.bmp";
                    arr[1]="photo/143.bmp";
                    arr[2]="photo/156.bmp";
                    arr[3]="photo/191.bmp";
                    setInterval(changeImg,timeInterval);
                    function changeImg()
                    {
                        var obj=document.getElementById("obj");
                        if (curIndex==arr.length-1)
                        {
                            curIndex=0;
                        }
                        else
                        {
                            curIndex+=1;
                        }
                        obj.src=arr[curIndex];
                    }
                </script>
                <img id=obj src ="photo/118.bmp" width=49.5% height=33% border =0 >
                <script language =javascript >
                    var curIndex2=0;
                    //时间间隔(单位毫秒)，每秒钟显示一张，数组共有5张图片放在Photos文件夹下。
                    var timeInterval=1000;
                    var arr2=new Array();
                    arr2[0]="photo/171.bmp";
                    arr2[1]="photo/172.bmp";
                    arr2[2]="photo/174.bmp";
                    arr2[3]="photo/180.bmp";
                    setInterval(changeImg,timeInterval);
                    function changeImg()
                    {
                        var obj2=document.getElementById("obj2");
                        if (curIndex2==arr2.length-1)
                        {
                            curIndex2=0;
                        }
                        else
                        {
                            curIndex2+=1;
                        }
                        obj2.src=arr2[curIndex];
                    }
                </script>
                <img id=obj2 src ="photo/171.bmp" width=49.5% height=33% border =0 >
            </div>
        </div--%>

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
                    <img  id="role_image1" src="http://www.hit.edu.cn/_upload/article/images/6e/3b/5b31b6c74a6e9dd91c1656ca2fc2/42387248-8127-4046-80ff-3a9301bdf498.jpg" alt="...">
                    <div class="carousel-caption">
                        <h3>【视觉志】好雪片片不落别处——哈工大雪景图</h3>
                    </div>
                </div>
                <div class="item">
                    <img  id="role_image2" src="http://www.hit.edu.cn/_upload/article/images/c8/7b/8edd4ede40b7a5d29711869ba058/cb457c93-4f5f-4e2f-aea6-9e50f97505c2.jpg" alt="...">
                    <div class="carousel-caption">
                        <h3>“长征五号”完美首飞 我校设计团队为火箭装扮“靓妆”</h3>
                    </div>
                </div>
                <div class="item">
                    <img id="role_image3" src="http://www.hit.edu.cn/_upload/article/images/b4/b7/423679fd41128fa440197507e567/0298e278-9f49-42c8-bccc-2b785d1f2d6b.jpg" alt="...">
                    <div class="carousel-caption">
                        <h3>179人喜获博士学位</h3>
                    </div>
                </div>
                <div class="item">
                    <img id="role_image4" src="http://www.hit.edu.cn/_upload/article/images/a5/77/0555a5bb48f89b084d0e102c1cf4/318d3f67-3d09-4546-88f9-f9ad9d55a63d.jpg" alt="...">
                    <div class="carousel-caption">
                        <h3>俱怀逸兴壮思飞 ——哈工大与中国航天60年</h3>
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
                <h1>今日哈工大</h1>
                <a href="http://today.hit.edu.cn/news/2016/11-13/4304727111RL0.htm" target="_blank"><h4>【讲座预告】蓝鸟论坛第23 期 ——海外校友帮你规划职业生涯</h4></a>
                <a href="http://today.hit.edu.cn/news/2016/11-13/8473627111RL0.htm" target="_blank"><h4>化工与化学学院邀请劳伦兹伯克利国家实验室</h4></a>
                <a href="http://today.hit.edu.cn/news/2016/11-13/3332844111RL0.htm" target="_blank"><h4>【IROBOT】 S-课堂：新闻撰写培训</h4></a>
            </div>
            <div class="col-sm-3" id="center_2_2">
                <h1>学校新闻</h1>
                <a href="http://news.hit.edu.cn/8d/da/c1511a167386/page.htm"><h4>哈工大信息化校园项目现场评估会召开</h4></a>
                <a href="http://news.hit.edu.cn/8d/3e/c1511a167230/page.htm"><h4>情系哈工大 携手再出发 哈工大日本校友会重组成立</h4></a>
                <a href="http://news.hit.edu.cn/8c/f3/c1511a167155/page.htm"><h4>哈工大韩国来华留学生校友联谊会成立</h4></a>
            </div>
            <div class="col-sm-3" id="center_2_3">
                <h1>学校活动信息</h1>
                <a href="http://today.hit.edu.cn/news/2016/11-10/594824111RL0.htm"><h4>第七届校园单词PK赛即将启幕</h4></a>
                <a href="http://today.hit.edu.cn/news/2016/11-11/1523630111RL1.htm"><h4>【舌战群儒，才辩无双】市政学院辩论队选拔赛即将开始</h4></a>
                <a href="http://today.hit.edu.cn/news/2016/11-09/7992624111RL0.htm"><h4>电气大讲堂预告：大学物理期中考前辅导</h4></a>
            </div>
            <div class="col-sm-3" id="center_2_4">
                <h1>友情链接</h1>
                <ul>
                    <li><a href="http://www.hit.edu.cn">哈工大主页</a></li>
                    <li><a href="http://jwc.hit.edu.cn">哈工大教务处</a></li>
                    <li><a href="http://map.hit.edu.cn">哈工大三维地图</a></li>
                    <li><a href="http://cms.hit.edu.cn">哈工大乐学网</a></li>
                </ul>
            </div>
        </div>
    </section>

</body>
</html>
