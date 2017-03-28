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
    <title>个人管理列表页面</title>
    <%@include file="../common.jsp" %>
    <%--<link rel="stylesheet" href="<%=basePath%>/styles/dataTables.responsive.css">
    <script type="text/javascript" src="<%=basePath%>/scripts/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/scripts/dataTables.bootstrap.min.js"></script>
    <script type="text/javascript" src="<%=basePath%>/scripts/dataTables.responsive.js"></script>--%>
</head>

<body>

<%--<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">个人管理</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>--%>
<!-- /.row -->
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-sm-8"><h3>个人信息</h3></div>
                    <div class="col-sm-4">
                        <form class="form-inline" method="get" action="<%=basePath%>/user/listUser">
                            <div class="form-group">
                                <input type="text" class="form-control" id="name" name="name" value=""
                                       placeholder="姓名"/>
                            </div>
                            <input type="submit" class="btn btn-success" value="查询"/>
                            <a class="btn btn-primary" href="<%=basePath%>/user/editUser"
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
                        <th style="text-align: center">身份证号</th>
                        <th style="text-align: center">电话</th>
                        <th style="text-align: center">邮件</th>
                        <th style="text-align: center">地址</th>
                        <th style="text-align: center">状态</th>
                        <th style="text-align: center">操作</th>
                    </tr>
                    <c:forEach items="${list}" var="list">
                        <tr>
                            <td style="text-align: center">${list.name}</td>
                            <td>${list.idCards}</td>
                            <td>${list.telephone}</td>
                            <td>${list.email}</td>
                            <td>${list.address}</td>
                            <td style="text-align: center">
                                <c:choose>
                                    <c:when test="${list.status=='1'}">
                                        <button type="button" class="btn btn-info btn-circle"><i
                                                class="fa fa-check"></i></button>
                                    </c:when>
                                    <c:when test="${list.status=='0'}">
                                        <button type="button" class="btn btn-warning btn-circle"><i
                                                class="fa fa-times"></i></button>
                                    </c:when>
                                    <c:otherwise>
                                        <button class="btn btn-warning">未知</button>
                                    </c:otherwise>
                                </c:choose>
                            </td>
                            <td style="text-align: center">
                                <a class="btn btn-primary" href="<%=basePath%>/user/editUser?id=${list.id}">修改</a>
                                <a class="btn btn-danger" href="<%=basePath%>/user/removeUser?id=${list.id}">删除</a>
                                <a class="btn btn-info" href="<%=basePath%>/user/showUser?id=${list.id}">查看</a>
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
<script type="text/javascript">
    /*$(function () {
     $.ajax({
     type: 'get',
     url: '<%=basePath%>/user/userListData',
     data: {
     'name': ''
     },
     dataType: 'json',
     success: function (result) {
     console.log(result);
     }
     });

     });

     $(document).ready(function () {
     $('#dataTables-example').DataTable({
     'oLanguage': { //国际化配置
     'sProcessing': '正在获取数据，请稍后...',
     'sLengthMenu': '显示 _MENU_ 条',
     'sZeroRecords': '没有您要搜索的内容',
     'sInfo': '从 _START_ 到  _END_ 条记录 总记录数为 _TOTAL_ 条',
     'sInfoEmpty': '记录数为0',
     'sInfoFiltered': '(全部记录数 _MAX_ 条)',
     'sInfoPostFix': '',
     'sSearch': '搜索 ',
     'sUrl': '',
     'oPaginate': {
     'sFirst': '第一页',
     'sPrevious': '上一页',
     'sNext': '下一页',
     'sLast': '最后一页'
     }
     },
     'bServerSide': true,
     'sAjaxSource': '<%=basePath%>/user/userListData',
     //服务器端，数据回调处理
     "fnServerData": function (sSource, aDataSet, fnCallback) {
     $.ajax({
     "dataType": 'json',
     "type": "GET",
     "url": sSource,
     "data": aDataSet,
     "success": fnCallback
     });
     },
     'aoColumns': [
     {'sClass': 'center', 'mDataProp': 'id'},
     {'sClass': 'center', 'mDataProp': 'id'},
     {'sClass': 'center', 'mDataProp': 'id'},
     {'sClass': 'center', 'mDataProp': 'id'},
     {'sClass': 'center', 'mDataProp': 'id'},
     {'sClass': 'center', 'mDataProp': 'id'}
     ]
     });
     });*/
</script>
</body>
</html>
