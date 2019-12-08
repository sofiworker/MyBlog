<%--
  Author: sofiworker
  Version: 1.0.0
  Date: 2019/12/8 22:10
  Description: 编辑文章页面，支持markdown
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新建</title>
    <link rel="stylesheet" href="editormd/css/editormd.css" />
</head>
<body>
<div id="test-editor">
    <textarea style="display:none;">### 关于 Editor.md

**Editor.md** 是一款开源的、可嵌入的 Markdown 在线编辑器（组件），基于 CodeMirror、jQuery 和 Marked 构建。
    </textarea>
</div>
<script src="js/jquery.min.js"></script>
<script src="editormd/editormd.min.js"></script>
<script type="text/javascript">
    $(function() {
        var editor = editormd("test-editor", {
            path   : "editormd/lib/"
        });
    });
</script>
</body>
</html>
