<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  archives: lunyujie
  Date: 2017/3/26
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑档案</title>
    <%@include file="../common.jsp" %>
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="col-sm-12">
                <h3 class="page-header">编辑档案信息</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" action="<%=basePath%>/archives/saveArchives">
                    <input type="hidden" id="id" name="id" value="${archives.id}"/>
                    <div class="form-group">
                        <label for="userId" class="col-sm-2 control-label">姓名<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <select class="form-control" id="userId" name="userId" value="${archives.userId}">
                                <c:forEach items="${users}" var="user">
                                    <c:if test="${user.id==archives.userId}">
                                        <option value="${user.id}" selected="selected">${user.name}</option>
                                    </c:if>
                                    <c:if test="${user.id!=archives.userId}">
                                        <option value="${user.id}">${user.name}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="schoolName" class="col-sm-2 control-label">学校名称<span
                                style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="schoolName" name="schoolName"
                                   value="${archives.schoolName}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="schoolAddress" class="col-sm-2 control-label">学校地址<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="schoolAddress" name="schoolAddress"
                                   value="${archives.schoolAddress}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="teacher" class="col-sm-2 control-label">老师<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="teacher" name="teacher"
                                   value="${archives.teacher}"/></div>
                    </div>
                    <div class="form-group">
                        <label for="grade" class="col-sm-2 control-label">年级<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="grade" name="grade" value="${archives.grade}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">等级<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <c:forEach items="${mapLevels}" var="m">
                                <c:choose>
                                    <c:when test="${m.key==archives.levels}">
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
                    <div class="form-group">
                        <label for="comments" class="col-sm-2 control-label">评价</label>
                        <div class="col-sm-10">
                            <textarea class="form-control" id="comments" name="comments"
                                      rows="3">${archives.comments}</textarea>
                        </div>
                        <div class="col-sm-offset-5">
                            <input type="submit" class="btn btn-success" value="保存"/>
                            <a href="<%=basePath%>/archives/listArchives" class="btn btn-default"/>返回</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
