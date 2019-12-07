<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Author: sofiworker
  Version: 1.0.0
  Date: 2019/12/5 20:42
  Description: 登录页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<s:form action="login" method="POST">
    <div style="color:blue; text-align:center">
        <s:property value="#loginFail"/>
    </div>
    <s:textfield name="userBean.uid" label="账号"/>
    <s:password name="userBean.password" label="密码"/>
    <s:submit name="登录"/>
</s:form>
</body>
<head>
    <title>登录</title>
</head>
</html>
