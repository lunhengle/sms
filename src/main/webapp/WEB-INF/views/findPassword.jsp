<%--
  Created by IntelliJ IDEA.
  User: lunyujie
  Date: 2017/3/29
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>重置密码</title>
    <%@include file="common.jsp" %>
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="col-sm-12">
                <h3 class="page-header">重置密码</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" action="<%=basePath%>/savePassword">
                    <div class="form-group">
                        <label for="password" class="col-sm-2 control-label">新密码：<span
                                style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="password" name="password"
                                   value="${password}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="resetPassword" class="col-sm-2 control-label">确认新密码：<span
                                style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="password" class="form-control" id="resetPassword" name="resetPassword"
                                   value=""/>
                        </div>
                    </div>
                    <div class="col-sm-offset-5">
                        <input type="submit" class="btn btn-success" value="保存"/>
                        <a href="<%=basePath%>/index" class="btn btn-default"/>返回</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
