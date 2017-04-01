<%--
  Created by IntelliJ IDEA.
  achievement: lunyujie
  Date: 2017/3/26
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成绩档案</title>
    <%@include file="../common.jsp" %>
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="col-sm-12">
                <h3 class="page-header">编辑成绩信息</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" action="<%=basePath%>/achievement/saveAchievement">
                    <input type="hidden" id="id" name="id" value="${achievement.id}"/>
                    <div class="form-group">
                        <label for="userId" class="col-sm-2 control-label">姓名<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <select class="form-control" id="userId" name="userId" value="${achievement.userId}">
                                <c:forEach items="${users}" var="user">
                                    <c:if test="${user.id==achievement.userId}">
                                        <option value="${user.id}" selected="selected">${user.name}</option>
                                    </c:if>
                                    <c:if test="${user.id!=achievement.userId}">
                                        <option value="${user.id}">${user.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="subject" class="col-sm-2 control-label">学科<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="subject" name="subject"
                                   value="${achievement.subject}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="schoolYear" class="col-sm-2 control-label">学年<span
                                style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="schoolYear" name="schoolYear"
                                   value="${achievement.schoolYear}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="achievement" class="col-sm-2 control-label">成绩<span
                                style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="achievement" name="achievement"
                                   value="${achievement.achievement}"/></div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">等级<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <c:forEach items="${mapLevels}" var="m">
                                <c:choose>
                                    <c:when test="${m.key==achievement.levels}">
                                        <div class="radio">
                                            <label><input type="radio" name="levels" value="${m.key}" checked>${m.value}
                                            </label>
                                        </div>
                                    </c:when>
                                    <c:otherwise>
                                        <div class="radio">
                                            <label><input type="radio" name="levels" value="${m.key}">${m.value}</label>
                                        </div>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </div>
                    </div>
                    <div class="col-sm-offset-5">
                        <input type="submit" class="btn btn-success" value="保存"/>
                        <a href="<%=basePath%>/achievement/listAchievement" class="btn btn-default"/>返回</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
