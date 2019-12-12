<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Author: sofiworker
  Version: 1.0.0
  Date: 2019/12/11 19:46
  Description: 
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>上传文件测试</title>
</head>
<body>
<form action="fileUpload" method="post" enctype="multipart/form-data">
    上传文件：<input type="file" name="uploadFile" /><br/>
    <input type="submit" value="上传" />
    <input type="reset" value="重置" />
</form>
<hr/>
</body>
</html>
