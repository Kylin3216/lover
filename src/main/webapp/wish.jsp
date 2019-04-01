<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 2017/6/13
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>愿望</title>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="jquery/js.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="beach">
    <div class="wish">
        <div class="wish-board animated tada">
            <ul class="nav nav-tabs wish-title">
                <li class="active">
                    <a href="#oursWish" data-toggle="tab">我们的愿望</a>
                </li>
                <li>
                    <a href="#myWish" data-toggle="tab">我的愿望</a>
                </li>
                <li>
                    <a href="#hisWish" data-toggle="tab">他的愿望</a>
                </li>
                <li>
                    <a href="#writeWish" data-toggle="tab">许愿</a>
                </li>
            </ul>
            <div class="tab-content wish-content">
                <div class="tab-pane active" id="oursWish">
                    <ul>
                        <%--<li>
                            <div><span><span class="glyphicon glyphicon-time"></span>发表时间</span>
                                <p>我希望早点结婚，买一个大房子</p></div>
                            <input type="checkbox"/>已完成
                        </li>--%>
                    </ul>
                </div>
                <div class="tab-pane" id="myWish">
                    <ul>

                    </ul>
                </div>
                <div class="tab-pane" id="hisWish">
                    <ul hidden>
                        <li>
                            <div><span><span class="glyphicon glyphicon-time"></span>发表时间</span>
                                <p>我希望早点结婚，买一个大房子</p></div>
                            <input type="checkbox"/>已完成
                        </li>
                    </ul>
                </div>
                <div class="tab-pane" id="writeWish">
                    <textarea placeholder="有什么愿望写下来慢慢实现……"></textarea>
                    <br>
                    <button class="btn btn-primary save-wish">发表</button><span class="size"></span>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
