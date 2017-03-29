<%--
  Created by IntelliJ IDEA.
  User: lunyujie
  Date: 2016/12/6
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    StringBuffer url = request.getRequestURL();
    String basePath = url.delete(url.length() - request.getRequestURI().length(), url.length()).append(request.getServletContext().getContextPath()).toString();
%>
<link rel="stylesheet" href="<%=basePath%>/styles/bootstrap.min.css"/>
<!-- MetisMenu CSS -->
<link rel="stylesheet" href="<%=basePath%>/styles/metisMenu.min.css"/>
<link rel="stylesheet" href="<%=basePath%>/styles/sb-admin-2.min.css"/>
<!-- Morris Charts CSS -->
<%--<link rel="stylesheet" href="<%=basePath%>/styles/morris.css"/>--%>

<link rel="stylesheet" href="<%=basePath%>/styles/font-awesome.min.css"/>

<script type="text/javascript" src="<%=basePath%>/scripts/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script type="text/javascript" src="<%=basePath%>/scripts/metisMenu.min.js"></script>
<!-- Morris Charts JavaScript -->
<%--<script type="text/javascript" src="<%=basePath%>/scripts/raphael.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/morris.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/scripts/morris-data.js"></script>--%>

<script type="text/javascript" src="<%=basePath%>/scripts/sb-admin-2.min.js"></script>

