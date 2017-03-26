<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lunhengle
  Date: 2017/3/26
  Time: 19:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查看个人信息</title>
    <%@include file="../common.jsp" %>
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-primary">
            <div class="panel-heading">
                个人信息
            </div>
            <div class="panel-body">
                <div class="row">
                    <h1>${user.name}</h1>
                    <address>
                        <strong>状态:</strong>
                        <c:choose>
                            <c:when test="${user.status=='1'}">
                                <button type="button" class="btn btn-info btn-circle"><i
                                        class="fa fa-check"></i></button>
                            </c:when>
                            <c:when test="${user.status=='0'}">
                                <button type="button" class="btn btn-warning btn-circle"><i
                                        class="fa fa-times"></i></button>
                            </c:when>
                            <c:otherwise>
                                <button class="btn btn-warning">未知</button>
                            </c:otherwise>
                        </c:choose>
                    </address>
                </div>
                <div class="row">
                    <address><strong>身份证号：</strong><br>${user.idCards}</address>
                </div>
                <div class="row">
                    <address><strong>手机号：</strong><br>${user.telephone}</address>
                </div>
                <div class="row">
                    <address>
                        <strong>邮箱：</strong><br>${user.email}
                    </address>
                </div>
                <div class="row">
                    <address>
                        <strong>地址：</strong><br>
                        ${user.address}
                    </address>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
