<%--
  Created by IntelliJ IDEA.
  User: lunyujie
  Date: 2017/3/26
  Time: 14:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="common.jsp" %>
<div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="<%=basePath%>/index">学生管理系统</a>
</div>
<!-- /.navbar-header -->

<ul class="nav navbar-top-links navbar-right">
    <!-- /.dropdown -->
    <li class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <i class="fa fa-user fa-fw"></i> <i class="fa fa-caret-down"></i>
        </a>
        <ul class="dropdown-menu dropdown-user">
            <li><a href="<%=basePath%>/user/showUser?id=${sessionScope.userId}" target="mainFrame"><i
                    class="fa fa-user fa-fw"></i>
                用户信息</a>
            </li>
            <li><a href="<%=basePath%>/findPassword"><i class="fa fa-gear fa-fw"></i> 重置密码</a>
            </li>
            <li class="divider"></li>
            <li><a href="<%=basePath%>/logout"><i class="fa fa-sign-out fa-fw"></i> 退出系统</a>
            </li>
        </ul>
        <!-- /.dropdown-user -->
    </li>
    <!-- /.dropdown -->
</ul>
<script>
    $(function () {
        $('.dropdown-toggle').dropdown();
    });
</script>