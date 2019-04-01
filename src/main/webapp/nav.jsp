<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>

<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 2017/6/13
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <!--？-->
    <title>Title</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="css/animate.min.css" rel="stylesheet" type="text/css">
    <link href="css/IMGUP.css" rel="stylesheet"/>
    <link href="css/cropper.min.css" rel="stylesheet">
    <link href="css/sitelogo.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
    <div class="navbar-header">
        <button class="navbar-toggle" type="button" data-toggle="collapse"
                data-target="#bs-example-navbar-collapse-1"><span class="sr-only">Toggle navigation</span><span
                class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button>
        <a class="navbar-brand" href="#">
            <p>LOVERS</p>
        </a>
    </div>
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <c:choose>
            <c:when test="${account!=null&&account.id>0}">
                <ul class="nav navbar-nav glink">
                    <li <c:if test="${nav=='index'||nav==null}">class="active"</c:if>><a href="/index"><span
                            class="glyphicon glyphicon-home"></span>主页</a></li>
                    <li <c:if test="${nav=='diary'}">class="active"</c:if>>
                        <a  href="/diary?mode=0"><span class="glyphicon glyphicon-book"></span>随笔</a></li>
                    <li <c:if test="${nav=='memoryday'}">class="active"</c:if>><a
                            href="/memoryday"><span
                            class=" glyphicon glyphicon-bell"></span>纪念日</a></li>
                    <li <c:if test="${nav=='album'}">class="active"</c:if>><a
                            href="/album"><span
                            class=" glyphicon glyphicon-camera"></span>相册</a></li>
                    <li <c:if test="${nav=='wish'}">class="active"</c:if>><a
                            href="/wish"><span
                            class="glyphicon glyphicon-send"></span>愿望广场</a></li>
                    <li <c:if test="${nav=='privity'}">class="active"</c:if>><a href="/privity"><span
                            class="glyphicon glyphicon-heart"></span>默契考验</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown user">
                        <a class="dropdown-toggle" href="#" data-toggle="dropdown">
                            <span class="user-name" style="width: 80px;text-align: center">${account.userDetail!=null?account.userDetail.nickName:""}</span><strong
                                    class="caret" style="margin-top: -8px"></strong></a>
                        <ul class="dropdown-menu">
                            <li class="edit"><a class="edit" href="#">个人信息</a></li>
                            <li><a href="/message">消息中心<span class="badge pull-right"
                                                                style="background: #ff647d;margin-top: 2px">1</span></a>
                            </li>
                            <li class="divider">
                            </li>
                            <li><a href="/exit">退出登录</a></li>
                        </ul>
                    </li>
                    <li class="dropdown set">
                        <a class="dropdown-toggle" href="#" data-toggle="dropdown"><span style="width: 70px;display: inline-block;text-align: center">设置<strong class="caret"></strong></span></a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">更换主题</a>
                            </li>
                            <li>
                                <a href="#">操作</a>
                            </li>
                            <li>
                                <a href="#">设置栏目</a>
                            </li>
                            <li class="divider">
                            </li>
                            <li>
                                <a href="#">更多设置</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#" class="change" data-miss="#login" data-target="#register">
                        <span class="glyphicon glyphicon-user"></span> 注册</a></li>
                    <li style="margin-right: 20px"><a href="#" class="change" data-miss="#register" data-target="#login">
                        <span class="glyphicon glyphicon-log-in"></span> 登录</a></li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
<footer>
    <hr style="margin-bottom: 5px">
    &copy;2017-2018 By Kylin And Elvira
</footer>
</body>
</html>
