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
                    <img  id="role_image1" src="photo/118.bmp" alt="...">
                    <div class="carousel-caption">
                        <h3>李舜生</h3>
                        <p>总有一天，我将撕碎这虚假的星空</p>
                    </div>
                </div>
                <div class="item">
                    <img  id="role_image2" src="photo/143.bmp" alt="...">
                    <div class="carousel-caption">
                        <h3>Homura</h3>
                        <p>我保证，我绝对会拯救你！不管重来几次，我都一定会守护你的！</p>
                    </div>
                </div>
                <div class="item">
                    <img id="role_image3" src="photo/156.bmp" alt="...">
                    <div class="carousel-caption">
                        <h3>Archer</h3>
                        <p>So as I pray...Unlimited Blade Works!!!</p>
                    </div>
                </div>
                <div class="item">
                    <img id="role_image4" src="photo/nero.jpeg" alt="...">
                    <div class="carousel-caption">
                        <h3>尼禄·克劳狄乌斯</h3>
                        <p>Aestus Domus Aurea!!!</p>
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
                <h1>今日HIT</h1>
                <h4>周校长宣布14届学生全体保研</h4>
                <h4>教务处网站被HACK，所有人学分绩变成100</h4>
                <h4>学生游行希望老师取消点名制</h4>
            </div>
            <div class="col-sm-3" id="center_2_2">
                <h1>学校新闻</h1>
                <ul>
                    <li><a href="http://jwc.hit.edu.cn/8c/4c/c4349a166988/page.htm">2017文化素质</a></li>
                    <li><a href="http://jwc.hit.edu.cn/8b/b0/c4349a166832/page.htm">2017创新选课</a></li>
                    <li><a href="http://jwc.hit.edu.cn/8b/23/c4349a166691/page.htm">2017春季选课</a></li>
                </ul>
            </div>
            <div class="col-sm-3" id="center_2_3">
                <h1>学校活动信息</h1>
                <h4>单身狗俱乐部成立，有爆料称内部污浊不堪</h4>
                <h4>工大正心楼蹦极活动将于期末考试后举行</h4>
                <h4>计算机软件学院全体学生联合开展对教务处网站攻击活动</h4>
            </div>
            <div class="col-sm-3" id="center_2_4">
                <h1>友情链接</h1>
                <ul>
                    <li><a href="http://jwc.hit.edu.cn">哈工大教务处</a></li>
                    <li><a href="http://map.hit.edu.cn">哈工大三维地图</a></li>
                    <li><a href="http://cms.hit.edu.cn">哈工大乐学网</a></li>
                </ul>
            </div>
        </div>
    </section>

</body>
</html>
