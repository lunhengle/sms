<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <c:if test="${sessionScope.roleCode==1}">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> 个人管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=basePath%>/user/listUser" target="mainFrame">人员管理</a>
                                </li>
                                <li>
                                    <a href="<%=basePath%>/user/showUser?id=${sessionScope.userId}"
                                       target="mainFrame">个人信息</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        <li>
                            <a href="<%=basePath%>/achievement/listAchievement" target="mainFrame"><i
                                    class="fa fa-bar-chart-o fa-fw"></i>成绩管理</a>
                        </li>
                        <li>
                            <a href="<%=basePath%>/archives/listArchives" target="mainFrame"><i
                                    class="fa fa-edit fa-fw"></i>档案管理</a>
                        </li>
                    </ul>
                </c:if>
                <c:if test="${sessionScope.roleCode==2}">
                    <ul class="nav" id="side-menu">
                        <li>
                            <a href="#"><i class="fa fa-table fa-fw"></i> 个人管理<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="<%=basePath%>/user/showUser?id=${sessionScope.userId}"
                                       target="mainFrame">个人信息</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                    </ul>
                </c:if>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
        <!-- /.navbar-static-side -->
    </nav>

    <div id="page-wrapper">
        <c:if test="${sessionScope.roleCode==1}">
            <div id="count">
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">统计信息</h1>
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
                <!-- /.row -->
                <div class="row">
                    <div class="col-lg-6 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${achievementCount}</div>
                                        <div>成绩信息!</div>
                                    </div>
                                </div>
                            </div>
                            <a href="<%=basePath%>/achievement/listAchievement" target="mainFrame">
                                <div class="panel-footer">
                                    <span class="pull-left">详细信息</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge">${archivesCount}</div>
                                        <div>档案信息</div>
                                    </div>
                                </div>
                            </div>
                            <a href="<%=basePath%>/archives/listArchives" target="mainFrame">
                                <div class="panel-footer">
                                    <span class="pull-left">详细信息</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </c:if>
        <iframe id="mainFrame" name="mainFrame" scrolling="no" frameborder="0"
                style="width: 100%;height: 100%">
        </iframe>
    </div>
</div>
</body>
<script type="text/javascript">
    <!--
    startInit('mainFrame', 560);
    var browserVersion = window.navigator.userAgent.toUpperCase();
    var isOpera = browserVersion.indexOf("OPERA") > -1 ? true : false;
    var isFireFox = browserVersion.indexOf("FIREFOX") > -1 ? true : false;
    var isChrome = browserVersion.indexOf("CHROME") > -1 ? true : false;
    var isSafari = browserVersion.indexOf("SAFARI") > -1 ? true : false;
    var isIE = (!!window.ActiveXObject || "ActiveXObject" in window);
    var isIE9More = (!-[1,] == false);
    function reinitIframe(iframeId, minHeight) {
        try {
            var iframe = document.getElementById(iframeId);
            var bHeight = 0;
            if (isChrome == false && isSafari == false)
                bHeight = iframe.contentWindow.document.body.scrollHeight;

            var dHeight = 0;
            if (isFireFox == true)
                dHeight = iframe.contentWindow.document.documentElement.offsetHeight + 2;
            else if (isIE == false && isOpera == false)
                dHeight = iframe.contentWindow.document.documentElement.scrollHeight;
            else if (isIE == true && isIE9More) {//ie9+
                var heightDeviation = bHeight - eval("window.IE9MoreRealHeight" + iframeId);
                if (heightDeviation == 0) {
                    bHeight += 3;
                } else if (heightDeviation != 3) {
                    eval("window.IE9MoreRealHeight" + iframeId + "=" + bHeight);
                    bHeight += 3;
                }
            }
            else//ie[6-8]、OPERA
                bHeight += 3;
            var height = Math.max(bHeight, dHeight);
            if (height < minHeight) height = minHeight;
            iframe.style.height = height + "px";
        } catch (ex) {
        }
    }
    function startInit(iframeId, minHeight) {
        eval("window.IE9MoreRealHeight" + iframeId + "=0");
        window.setInterval("reinitIframe('" + iframeId + "'," + minHeight + ")", 100);
    }
    $(function () {
        $("a").click(function () {
            $("#count").hide();
        });
    });
    //-->
</script>
</html>
