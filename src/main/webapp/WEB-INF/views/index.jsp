<%--
  Created by IntelliJ IDEA.
  User: lunyujie
  Date: 2016/11/14
  Time: 15:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
    <%@include file="common.jsp" %>
</head>
<body>

<div id="wrapper">
    <nav class="navbar navbar-inverse navbar-static-top" role="navigation" style="margin-bottom: 0">
        <jsp:include page="head.jsp"/>
        <!-- /.navbar-top-links -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">
                <ul class="nav" id="side-menu">
                    <li>
                        <a href="<%=basePath%>/user/listUser" target="mainFrame"><i
                                class="fa fa-table fa-fw"></i>个人管理</a>
                    </li>
                    <li>
                        <a href="<%=basePath%>/achievement/listAchievement" target="mainFrame"><i
                                class="fa fa-table fa-fw"></i>成绩管理</a>
                    </li>
                    <li>
                        <a href="<%=basePath%>/archives/listArchives" target="mainFrame"><i class="fa fa-table fa-fw"></i>档案管理</a>
                    </li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <div id="page-wrapper">
        <iframe id="mainFrame" name="mainFrame" scrolling="no" frameborder="0"
                style="width: 100%;height: 100%"></iframe>
    </div>
</div>
</body>
</html>
