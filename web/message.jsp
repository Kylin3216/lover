<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%--
  Created by IntelliJ IDEA.
  User: Elvira
  Date: 2017/7/9
  Time: 14:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>消息中心</title>
    <script src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="jquery/js.js"></script>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<div class="container-fluid">
    <div class="row-fluid">
        <div class="col-sm-7 col-sm-offset-2">
            <h2 style="text-align: center">消息中心</h2>
            <c:forEach var="message" items="${messageList}">
                <div class="news">
                    <input type="hidden" value="${message.state}">
                    <a href="<c:if test="${message.type==0}">#</c:if><c:if test="${message.type!=0}">/readMessage?id=${message.id}</c:if>">
                        <div class="<c:if test="${!message.state}">typeicon</c:if><c:if test="${message.state}">typeiconRead</c:if>">
                            &nbsp;
                        </div>
                        <div class="<c:if test="${!message.state}">textMain</c:if><c:if test="${message.state}">textMainRead</c:if>">
                            <i class="<c:if test="${!message.state}">corrow</c:if><c:if test="${message.state}">corrowRead</c:if>">
                                &nbsp;</i>
                            <em><fmt:formatDate
                                    value="${message.sendTime}" pattern="yyyy-MM-dd HH:mm:ss"/></em>
                            <br/>
                            <span>${message.content}</span>
                            <c:if test="${message.type==0}">
                                <c:choose>
                                    <c:when test="${message.isDone==0}">
                                        <button class="btnAgree" value="${message.id}">同意</button>
                                        <button class="btnRefuse" value="${message.id}">拒绝</button>
                                    </c:when>
                                    <c:when test="${message.isDone==1}">
                                        <button disabled>已同意</button>
                                    </c:when>
                                    <c:otherwise>
                                        <button disabled>已拒绝</button>
                                    </c:otherwise>
                                </c:choose>
                            </c:if>
                        </div>
                    </a>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
</body>
</html>
