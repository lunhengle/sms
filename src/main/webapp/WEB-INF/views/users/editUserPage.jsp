<%--
  Created by IntelliJ IDEA.
  User: lunyujie
  Date: 2017/3/26
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>编辑个人</title>
    <%@include file="../common.jsp" %>
</head>
<body>
<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-default">
            <div class="col-sm-12">
                <h3 class="page-header">编辑个人信息</h3>
            </div>
            <div class="panel-body">
                <form class="form-horizontal" method="post" action="<%=basePath%>/user/saveUser">
                    <input type="hidden" id="id" name="id" value="${user.id}"/>
                    <div class="form-group">
                        <label for="name" class="col-sm-2 control-label">姓名<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name" value="${user.name}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="idCards" class="col-sm-2 control-label">身份证号<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="idCards" name="idCards"
                                   value="${user.idCards}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="telephone" class="col-sm-2 control-label">电话<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="telephone" name="telephone"
                                   value="${user.telephone}"/></div>
                    </div>
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">邮件<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="email" name="email" value="${user.email}"/>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="address" class="col-sm-2 control-label">地址<span style="color: red">*</span></label>
                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="address" name="address"
                                   value="${user.address}"/></div>
                    </div>
                    <div class="col-sm-offset-5">
                        <input type="submit" class="btn btn-success" value="保存"/>
                        <a href="<%=basePath%>/user/listUser" class="btn btn-default"/>返回</a>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
