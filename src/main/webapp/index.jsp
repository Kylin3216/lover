<%@ page import="tech.dreamfund.util.WebHelper" %>
<%@ page import="tech.dreamfund.model.Account" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: xiasu
  Date: 2017/6/4
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>lovers</title>
    <link href="css/style.css" rel="stylesheet" type="text/css">
    <link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/animate.min.css" rel="stylesheet" type="text/css">
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="jquery/js.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<!--内容-->
<c:choose>
    <c:when test="${account!=null&&account.id>0}">
        <%
            Account account = (Account) session.getAttribute("account");
            String sex =account.getUserDetail()!=null?account.getUserDetail().getSex():"";
        %>
        <div class="container-fluid">
            <div class="row-fluid">
                <div id="men" class="col-sm-3 col-md-3 col-lg-3 <%=WebHelper.setMainLocation(1,sex)%>">
                    <div class="border animated fadeInLeft pull-left">
                        <div class="<%=WebHelper.setHead(1,sex)%>" style="height: 150px">
                        </div>
                        <table class="table">
                            <caption>Your Lover</caption>
                            <tr>
                                <th><a href="#" class="user-photo"></a>
                                    <span class="lover-name">1313313</span>
                                </th>
                                <th><span class="state">在线</span></th>
                            </tr>
                            <tr>
                                <td><span class="glyphicon glyphicon-map-marker"></span>上海</td>
                                <td>天气</td>
                            </tr>
                            <tr>
                                <td class="mood">心情</td>
                            </tr>
                        </table>
                    </div>
                </div>
                <div class="col-sm-6 col-md-6 col-lg-6">
                    <div class="days"></div>
                    <div id="myCarousel" class="carousel slide animated fadeInUp" data-ride="carousel">
                        <!-- 轮播（Carousel）指标 -->
                        <ol class="carousel-indicators">
                            <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                            <li data-target="#myCarousel" data-slide-to="1"></li>
                            <li data-target="#myCarousel" data-slide-to="2"></li>
                        </ol>
                        <!-- 轮播（Carousel）项目 -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <img src="image/loverphoto1.jpg" alt="First slide">
                            </div>
                            <div class="item">
                                <img src="image/loverphoto3.jpg" alt="Second slide">
                            </div>
                            <div class="item">
                                <img src="image/loverphoto4.jpg" alt="Third slide">
                            </div>
                        </div>
                        <!-- 轮播（Carousel）导航 -->
                        <a class="carousel-control left" href="#myCarousel"
                           data-slide="prev">&lsaquo;
                        </a>
                        <a class="carousel-control right" href="#myCarousel"
                           data-slide="next">&rsaquo;
                        </a>
                    </div>
                </div>
                <div id="women" class="col-sm-3 col-md-3 col-lg-3 <%=WebHelper.setMainLocation(0,sex)%>">
                    <div class="border animated fadeInRight pull-right">
                        <div class="<%=WebHelper.setHead(0,sex)%>" style="height: 150px">
                            <button type="button" class="girl-btn myBtn-default edit"><span
                                    class="glyphicon glyphicon-pencil"></span>修改
                            </button>
                        </div>
                        <table class="table">
                            <caption>You</caption>
                            <tr>
                                <th><a href="#" class="user-photo"></a>
                                    <span class="user-name">${account.userDetail!=null?account.userDetail.nickName:""}</span>
                                </th>
                                <th style="width: 30%"><span class="state">在线</span></th>
                            </tr>
                            <tr>
                                <td><span class="glyphicon glyphicon-map-marker"></span>上海</td>
                                <td>天气</td>
                            </tr>
                            <tr>
                                <td class="mood">心情</td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
        <div class="back animated" <c:if test="${account.userDetail!=null&&account.userDetail.nickName!=null}">hidden</c:if>>
            <div class="sex" <c:if test="${account.userDetail!=null}">hidden</c:if>>
                <h3>请设置你的性别</h3>
                <button class="male" value="男"></button>
                <button class="female" value="女"></button>
            </div>
            <div class="information"
                 <c:if test="${account.userDetail==null||account.userDetail.sex==null}">hidden</c:if>>
                <div class="information-title bounceInUp animated"></div>
                <div class="arrow1 fadeInLeft animated"></div>
                <div id="user" class="<%=WebHelper.setLocation(0,sex)%> fadeInUp animated">
                    <p><span>你的账号：</span><span>${account.telephone}</span></p>
                    <p><span>你的昵称：</span><input type="text" maxlength="8" placeholder="点击设置你的昵称" value="${account.userDetail!=null?account.userDetail.nickName:""}"></p>
                    <button type="button" class="myBtn-default btn save">保存</button>
                </div>
                <div id="lover" class="<%=WebHelper.setLocation(1,sex)%> fadeInDown animated">
                    <p><span>对方账号：</span><input id="loverAccount" type="text" placeholder="点击输入你要绑定的账号"></p>
                    <p><span>对方昵称：</span><span id="loverNickName"></span><input type="hidden"></p>
                    <button type="button" class="myBtn-default btn bind" disabled>绑定</button>
                </div>
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="container-fluid" style="padding: 0;margin: 0">
            <div class="row-fluid">
                <div class="col-md-12" style="height:600px;background:url('image/bj2.jpg') no-repeat;">
                    <div class="animated fadeIn index-box col-md-3 col-sm-5 col-md-offset-4 col-sm-offset-2"
                         id="register" hidden>
                        <p class="head" id="registerModal">
                            LOVERS
                        </p>
                        <hr>
                        <form id="rform" class="form-horizontal" role="form">
                            <div class="col-sm-11 col-sm-offset-1">
                                <h4>用户注册</h4>
                            </div>
                            <div class="form-group">
                                <label for="setUser" class="col-sm-1 control-label sr-only">user</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-user"></span></span>
                                        <input name="phoneOrEmail" type="text" class="form-control" id="setUser"
                                               placeholder="请输入手机号/邮箱">
                                    </div>
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="setPassword" class="col-sm-1 control-label sr-only">password</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-lock"></span></span>
                                        <input name="password" type="password" class="form-control" id="setPassword"
                                               placeholder="请设置5-20位密码">
                                    </div>
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="checkPassword" class="col-sm-1 control-label sr-only">password</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-lock"></span></span>
                                        <input name="checkpassword" type="password" class="form-control"
                                               id="checkPassword"
                                               placeholder="请确认密码">
                                    </div>
                                    <p class="help-block"></p>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-1 col-sm-11">
                                    <div class="checkbox">
                                        <label><input name="check" type="checkbox" checked="checked"/>同意<a
                                                href="#">LOVERS用户注册协议</a></label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-1 col-sm-10">
                                    <button id="rbtn" type="button" class="myBtn btnBig">注册</button>
                                    <p style="margin-left: 5px"><a href="#" class="change" data-miss="#register" data-target="#login">已有账号？立即登录</a>
                                    </p>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="animated fadeIn index-box col-md-3 col-sm-5 col-md-offset-4 col-sm-offset-2" id="login">
                        <p class="head" id="loginModal">
                            LOVERS
                        </p>
                        <hr>
                        <form id="lform" class="form-horizontal" role="form">
                            <div class="col-sm-11 col-sm-offset-1">
                                <h4>用户登录</h4>
                            </div>
                            <div class="form-group">
                                <label for="inputUser" class="col-sm-1 control-label sr-only">user</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span class="glyphicon glyphicon-user"></span> </span>
                                        <input name="nameOrPhoneOrEmail" type="text" class="form-control" id="inputUser"
                                               placeholder="手机号/邮箱/账户名">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <label for="inputPassword" class="col-sm-1 control-label sr-only">Password</label>
                                <div class="col-sm-10">
                                    <div class="input-group">
                                        <span class="input-group-addon"><span
                                                class="glyphicon glyphicon-lock"></span></span>
                                        <input name="password" type="password" class="form-control" id="inputPassword"
                                               placeholder="请输入密码">
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-1 col-sm-11">
                                    <div class="checkbox">
                                        <label><input type="checkbox" checked="checked"/>记住我</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-1 col-sm-11">
                                    <button id="lbtn" type="button" class="myBtn btnBig">登录</button>
                                    <button class="myBtn-default forgetPassword">忘记密码</button>
                                    <p style="margin-left: 5px"><a href="#" class="change" data-miss="#login" data-target="#register">没有账号？立即注册</a>
                                    </p>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="alert" hidden></div>
                </div>
            </div>
        </div>
    </c:otherwise>
</c:choose>

</body>
</html>
