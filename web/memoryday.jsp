<%@ page import="tech.dreamfund.util.WebHelper" %>
<%@ page import="tech.dreamfund.model.MemoryDay" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 2017/6/13
  Time: 20:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>纪念日</title>
    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="jquery/js.js"></script>
    <script src="http://www.jq22.com/jquery/1.8.3/jquery.min.js"></script>
    <script type="text/javascript" src="jquery/simple.switch.min.js"></script>
    <link rel="stylesheet" href="css/simple.switch.three.css" type="text/css">
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="container-fluid" style="margin: 0px;height: 700px;background: url('/image/memory.jpg') no-repeat">
    <div class="row-fluid">
        <div class="col-md-8 memory animated rotateInDownLeft" id="memory">
            <div class="memory-left" id="memory-left">
                <div class="memory-title animated rubberBand"></div>
                <form method="post" action="/saveOrUpdateMemoryDay">
                    <p class="memory-tips"><span class="glyphicon glyphicon-pencil">
                    <input type="text" id="memoryName" name="memoryName" placeholder="点击输入纪念日内容"></span>
                    </p>
                    <div id="demo">
                        <p class="memory-tips"><span class="glyphicon glyphicon-calendar date date1 fl" id="from">
                    <input type="text" id="memoryTime" name="memoryDate"
                           placeholder="点击这里选择日期"></span><input type="checkbox" class="checkbox">
                            <script>
                                $(".checkbox").simpleSwitch({
                                    "theme": "FlatCircular"
                                });
                            </script>
                        </p>
                        <button type="button" class="myBtn-default add-memory">新增/设置</button>
                        <input type="hidden" name="id" value="0">
                        <div id="dd"></div>
                    </div>
                    <div id="calendar" class="calendar"></div>
                </form>
            </div>
            <div class="bird"></div>
            <div class="right-div">
                <ul class="memory-right list-unstyled">
                    <c:forEach items="${memoryDayList}" var="memory" varStatus="status">
                        <li class="<c:if test="${status.first}">first</c:if> <c:if test="${!status.first}">list</c:if>">
                            <div class="date">
                                <button type="button" class="add">
                                    <c:if test="${memory.memoryDate==null}">点击设置</c:if>
                                    <c:if test="${memory.memoryDate!=null}"><fmt:formatDate value="${memory.memoryDate}"
                                                                                            pattern="yyyy-MM-dd"/></c:if>
                                </button>
                                <input type="hidden" value="${memory.id}">
                            </div>
                            <p>距离<span class="memory-name">${memory.content}</span>还有</p>
                            <%
                                MemoryDay memoryDay = (MemoryDay) pageContext.getAttribute("memory");
                                int days = WebHelper.getCountdownDays(memoryDay.getMemoryDate());
                                if (WebHelper.getCountdownHours(memoryDay.getMemoryDate()) > 0
                                        || WebHelper.getCountdownMinutes(memoryDay.getMemoryDate()) > 0
                                        || WebHelper.getCountdownSeconds(memoryDay.getMemoryDate()) > 0){
                                    days=days+1;
                                }
                            %>
                            <div class="days"><%=days%>
                            </div>
                            天
                        </li>
                    </c:forEach>
                </ul>
                <div style="width: 470px;text-align: center;">
                    <ul class="pagination">
                        <li><a href="#">&laquo;</a></li>
                        <li class="active"><a href="#">1</a></li>
                        <li><a href="#">&raquo;</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="jquery/calendar.js"></script>
<script>
    $('#dd').calendar({
        trigger: '#memoryTime',
        offset: [200, -20],
        zIndex: 999,
        format: 'yyyy-mm-dd',
        selectedRang: ['1921/1/1', new Date()],
        data: [{date: '2015/11/23', value: '面试'}, {date: '2017/7/8', value: '出去玩'}],
        onSelected: function (view, date, data) {
            console.log('event: onSelected')
        },
        onClose: function (view, date, data) {
            console.log('event: onClose');
            console.log('view:' + view);
            console.log('date:' + date);
            console.log('data:' + (data || 'None'));
        }
    });
    $(".add").click(function () {
        $("#memoryTime").trigger("click");
        return false;
    })
</script>
</body>
</html>
