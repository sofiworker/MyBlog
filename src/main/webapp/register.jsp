<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Author: sofiworker
  Version: 1.0.0
  Date: 2019/12/7 22:37
  Description: 用户注册页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
<s:form action="register" method="POST">
    <div style="color:blue; text-align:center">
        <s:property value="#registerFail"/>
    </div>
    <s:textfield name="userBean.uid" label="账号"/>
    <s:textfield name="userBean.username" label="昵称"/>
    <s:password name="userBean.password" label="密码"/>
    <s:submit name="登录"/>
</s:form>
</body>
</html>
