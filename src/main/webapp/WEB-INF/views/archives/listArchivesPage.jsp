<%--
  Created by IntelliJ IDEA.
  User: lunyujie
  Date: 2016/11/14
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>档案管理列表页面</title>
    <%@include file="../common.jsp" %>
</head>

<body>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-sm-8"><h3>档案信息</h3></div>
                    <div class="col-sm-4">
                        <form class="form-inline" method="get" action="<%=basePath%>/archives/listArchives">
                            <div class="form-group">
                                <input type="text" class="form-control" id="schoolName" name="schoolName" value=""
                                       placeholder="学校名"/>
                            </div>
                            <input type="submit" class="btn btn-success" value="查询"/>
                            <a class="btn btn-primary" href="<%=basePath%>/archives/editArchives"
                               target="_self">增加</a>
                        </form>
                    </div>

                </div>
            </div>
            <!-- /.panel-heading -->
            <div class="panel-body">
                <table width="100%" class="table table-striped table-bordered table-hover"
                       id="dataTables-example">
                    <tr>
                        <th style="text-align: center">姓名</th>
                        <th style="text-align: center">学校名称</th>
                        <th style="text-align: center">老师</th>
                        <th style="text-align: center">年级</th>
                        <th style="text-align: center">等级</th>
                        <th style="text-align: center">学校地址</th>
                        <th style="text-align: center">创建时间</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    <c:forEach items="${list}" var="list">
                        <tr>
                            <td>${list.NAME}</td>
                            <td>${list.SCHOOL_NAME}</td>
                            <td style="text-align: center">${list.TEACHER}</td>
                            <td style="text-align: center">${list.GRADE}</td>
                            <td style="text-align: center">
                                <c:forEach items="${mapLevels}" var="m">
                                    <c:if test="${m.key==list.levels}">
                                        <c:out value="${m.value}"/>
                                    </c:if>
                                </c:forEach>
                            </td>
                            <td>${list.SCHOOL_ADDRESS}</td>
                            <td style="text-align: center">${list.CREATED}</td>
                            <td style="text-align: center">
                                <a class="btn btn-primary"
                                   href="<%=basePath%>/archives/editArchives?id=${list.ID}">修改</a>
                                <a class="btn btn-danger"
                                   href="<%=basePath%>/archives/removeArchives?id=${list.ID}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <!-- /.table-responsive -->
            </div>
            <!-- /.panel-body -->
        </div>
        <!-- /.panel -->
    </div>
    <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
</body>
</html>
