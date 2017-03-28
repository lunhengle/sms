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
    <title>成绩管理列表页面</title>
    <%@include file="../common.jsp" %>
</head>

<body>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-sm-8"><h3>成绩信息</h3></div>
                    <div class="col-sm-4">
                        <form class="form-inline" method="get" action="<%=basePath%>/achievement/listAchievement">
                            <div class="form-group">
                                <input type="text" class="form-control" id="schoolYear" name="schoolYear" value=""
                                       placeholder="学年"/>
                            </div>
                            <input type="submit" class="btn btn-success" value="查询"/>
                            <a class="btn btn-primary" href="<%=basePath%>/achievement/editAchievement"
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
                        <th style="text-align: center">学科</th>
                        <th style="text-align: center">学年</th>
                        <th style="text-align: center">成绩</th>
                        <th style="text-align: center">等级</th>
                        <th style="text-align: center">创建时间</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    <c:forEach items="${list}" var="list">
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
                            <td style="text-align: center">
                                <a class="btn btn-primary"
                                   href="<%=basePath%>/achievement/editAchievement?id=${list.id}">修改</a>
                                <a class="btn btn-danger"
                                   href="<%=basePath%>/achievement/removeAchievement?id=${list.id}">删除</a>
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
