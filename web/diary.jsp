<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 2017/6/11
  Time: 15:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>diary</title>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="jquery/js.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="container-fluid" style="margin: 0px;height: 700px;background:url('/image/moodbj.png') no-repeat">
    <div class="row-fluid">
        <div class="col-md-9">
            <ul class="nav nav-tabs">
                <li <c:if test="${mode==0}">class="active"</c:if>>
                    <a href="/diary?mode=0">心情</a>
                </li>
                <li class="<c:if test="${mode==1}">active</c:if> showYear">
                    <a href="/diary?mode=1">日记</a>
                </li>
                <li <c:if test="${mode==2}">class="active"</c:if>>
                    <a href="/diary?mode=2">情书</a>
                </li>
            </ul>
            <div class="tab-content animated bounceInUp">
                <div class="<c:if test="${mode==0}">active</c:if> tab-pane mood-mode" id="mood">
                    <span class="picture1"></span>
                    <form role="form">
                        <div class="form-group">
                            <label for=""><span class="glyphicon glyphicon-pencil"></span> 发表心情</label><span
                                class="word-limit"></span>
                            <textarea class="form-control mood-text" rows="5" placeholder="记录与你的点点滴滴……"></textarea>
                            <button class="myBtn-default pull-right publish" type="button">发表</button>
                        </div>
                    </form>
                    <div class="mood-content">
                        <ul class="mood-ul">
                            <c:forEach items="${moodList}" var="mood">
                                <li class="mood-li">
                                    <div class="li-left">
                                        <div class="mood-block">
                                        <span><fmt:formatDate value="${mood.writeTime}"
                                                              pattern="yyyy-MM-dd HH:mm"/></span>
                                        </div>
                                        <p>${mood.content}</p>
                                    </div>
                                    <button class="delete li-right" type="button"><span class="delete-span" hidden><span
                                            class="glyphicon glyphicon-trash"></span></span></button>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <div class="<c:if test="${mode==1}">active</c:if> tab-pane diary-mode" id="diary">
                    <div class="book" id="bookTitle">
                        <span class="picture2"></span>
                        <div class="title"><span>我的日记本</span></div>
                        <span class="details"><span id="date"></span><span id="week"></span></span>
                        <button type="button" class="myBtn-default" id="return" hidden></button>
                        <div class="bookContentBg fl">&nbsp;</div>
                        <div class="bookContentBg fr">&nbsp;</div>
                        <div class="box" id="book">
                            <div class="bookMain">
                                <div class="paper" id="writeDiary" hidden>
                                    <button type="button" class="myBtn-default" id="saveDiary">保存</button>
                                    <div class="bookContentLeft">
                                        <textarea class="bookTitle1" contenteditable="true" id="writeTitle"
                                                  placeholder="题目" onkeydown="writeTitle()"></textarea>
                                        <div class="bookContent">
                                            <div class="text">
                                                <textarea id="writeContent1" placeholder="今天想说啥？"></textarea>
                                            </div>
                                            <div class="pageNum">01</div>
                                        </div>
                                    </div>
                                    <div class="bookContentRight">
                                        <div class="bookTitle"></div>
                                        <div class="bookContent">
                                            <div class="text">
                                                <textarea id="writeContent2"></textarea>
                                            </div>
                                            <div class="pageNum">02</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="paper" id="diaryList">
                                    <button type="button" class="myBtn-default" id="write"><span
                                            class="glyphicon glyphicon-pencil"></span>写日记
                                    </button>
                                    <div class="bookContentLeft">
                                        <div class="bookTitle">目录</div>
                                        <div class="bookContent">
                                            <ul class="list mar_md half list-unstyled" id="list-left-left">
                                            </ul>
                                            <ul class="list mar_md half list-unstyled" id="list-left-right">
                                            </ul>
                                            <div class="pageNum">01</div>
                                        </div>
                                    </div>
                                    <div class="bookContentRight">
                                        <div class="bookTitle"></div>
                                        <div class="bookContent">
                                            <ul class="list mar_md half list-unstyled" id="list-right-left">
                                            </ul>
                                            <ul class="list mar_md half list-unstyled" id="list-right-right">
                                            </ul>
                                            <div class="pageNum">02</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="paper" id="readDiary" hidden>
                                    <button type="button" class="btn btn-primary" id="deleteDiary">删除</button>
                                    <div class="bookContentLeft">
                                        <div class="bookTitle" id="readTitle"></div>
                                        <div class="bookContent">
                                            <div class="text">
                                                <div id="leftContent"></div>
                                            </div>
                                            <div class="pageNum">01</div>
                                        </div>
                                    </div>
                                    <div class="bookContentRight">
                                        <div class="bookTitle"></div>
                                        <div class="bookContent">
                                            <div class="text">
                                                <div id="rightContent"></div>
                                            </div>
                                            <div class="pageNum">02</div>
                                        </div>
                                    </div>
                                </div>
                                <div class="bookRing">
                                    <div class="ring1">&nbsp;</div>
                                    <div class="ring2">&nbsp;</div>
                                    <div class="ring3">&nbsp;</div>
                                </div>
                                <div class="bookRing" style="top:362px;">
                                    <div class="ring1">&nbsp;</div>
                                    <div class="ring2">&nbsp;</div>
                                    <div class="ring3">&nbsp;</div>
                                </div>
                            </div>
                            <div class="bookPaple1">&nbsp;</div>
                            <div class="bookPaple2">&nbsp;</div>
                            <div class="bookPaple3">&nbsp;</div>
                            <div class="bookPaple4">&nbsp;</div>
                            <div class="bookPaple5">&nbsp;</div>
                            <div class="bookPaple6">&nbsp;</div>
                        </div>
                    </div>
                </div>
                <div class="<c:if test="${mode==2}">active</c:if> tab-pane" id="love-letter">
                    <span class="picture3"></span>
                    <div class="letter-nav col-md-2">
                        <a href="/navToBox?state=0"><button class="receive-box"></button></a>
                        <a href="/navToBox?state=1"><button class="send-box"></button></a>
                        <a href="/navToBox?state=2"><button class="draft-box"></button></a>
                    </div>
                    <div class="letter-mode col-md-7">
                        <div class="letter-image"></div>
                        <div class="letter-content">
                            <h4 class="pull-left">${title}</h4><span class="size pull-left"></span>
                            <button class="myBtn-default write pull-left">写情书</button>
                            <button class="myBtn-default save-letter pull-left">保存</button>
                            <div>
                                <textarea placeholder="点击这里来一封浪漫的情书……" hidden></textarea>
                                <table class="table table-striped table-hover">
                                    <c:forEach items="${loveLetterList}" var="letter">
                                    <tr class="read">
                                        <td><a href="#"><span class="time"><fmt:formatDate value="${letter.sendTime}" pattern="yyyy-MM-dd"/></span><span
                                                class="content"  style="width: 459px">${letter.content}</span></a><a href="#" ><span
                                                class="glyphicon glyphicon-trash delete-letter"></span>
                                            <input type="hidden" value="${letter.id}"></a>
                                        </td>
                                    </tr>
                                    </c:forEach>
                                    <%--<div class="null-content"><hr style="float: left;width: 40%"><span style="width: 20%">暂无内容</span><hr style="float: right;width: 40%"></div>--%>
                                </table>
                                <p hidden></p>
                                <input id="getId" type="hidden"/>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-3 diary-right">
            <div class="qq1"></div>
            <div class="qq2"></div>
            <div class="qq3"></div>
            <div class="qq4"></div>
        </div>
    </div>
</div>
</body>
</html>
