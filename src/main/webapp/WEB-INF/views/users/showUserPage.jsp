<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: lunyujie
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
                    <address><strong>手机号：</strong><br>${user.telephone}</address>
                </div>
                <div class="row">
                    <address><strong>邮箱：</strong><br>${user.email}</address>
                    <address><strong>地址：</strong><br>${user.address}</address>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-12">
        <div class="panel panel-primary">
            <div class="panel-heading">
                档案信息
            </div>
            <div class="panel-body">
                <div class="row">
                    <table width="100%" class="table table-striped table-bordered table-hover">
                        <tr>
                            <th style="text-align: center">学校名称</th>
                            <th style="text-align: center">老师</th>
                            <th style="text-align: center">年级</th>
                            <th style="text-align: center">等级</th>
                            <th style="text-align: center">学校地址</th>
                            <th style="text-align: center">创建时间</th>
                        </tr>
                        <c:forEach items="${archivesList}" var="list">
                            <tr>
                                <td>${list.schoolName}</td>
                                <td style="text-align: center">${list.teacher}</td>
                                <td style="text-align: center">${list.grade}</td>
                                <td style="text-align: center">
                                    <c:forEach items="${mapLevels}" var="m">
                                        <c:if test="${m.key==list.levels}">
                                            <c:out value="${m.value}"/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td>${list.schoolAddress}</td>
                                <td style="text-align: center">${list.created}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
    <div class="col-lg-12">
        <div class="panel panel-primary">
            <div class="panel-heading">
                成绩信息
            </div>
            <div class="row">
                <!-- /.panel-heading -->
                <div class="panel-body">
                    <table width="100%" class="table table-striped table-bordered table-hover">
                        <tr>
                            <th style="text-align: center">学科</th>
                            <th style="text-align: center">学年</th>
                            <th style="text-align: center">成绩</th>
                            <th style="text-align: center">等级</th>
                            <th style="text-align: center">创建时间</th>
                        </tr>
                        <c:forEach items="${achievementList}" var="list">
                            <tr>
                                <td style="text-align: center">${list.subject}</td>
                                <td style="text-align: center">${list.schoolYear}</td>
                                <td style="text-align: center">${list.achievement}</td>
                                <td style="text-align: center">
                                    <c:forEach items="${mapLevels}" var="m">
                                        <c:if test="${m.key==list.levels}">
                                            <c:out value="${m.value}"/>
                                        </c:if>
                                    </c:forEach>
                                </td>
                                <td style="text-align: center">${list.created}</td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
