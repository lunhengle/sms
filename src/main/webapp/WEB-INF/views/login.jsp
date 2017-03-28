<%--
  Created by IntelliJ IDEA.
  User: lunyujie
  Date: 2016/12/5
  Time: 16:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <%@include file="common.jsp" %>
    <style>
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-primary">
                <div class="panel-heading">
                    <h2 class="panel-title">学生管理系统</h2>
                </div>
                <div class="panel-body">
                    <form role="form" method="post" action="<%=basePath%>/login">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="账号" name="username" type="username" autofocus>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码" name="password" type="password"
                                       value="">
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">记住密码
                                </label>
                            </div>
                            <input type="submit" class="btn btn-lg btn-primary btn-block" value="登陆"/>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
