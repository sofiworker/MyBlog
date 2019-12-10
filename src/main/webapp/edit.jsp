<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <textarea style="display:none;">
        # Editor.md
# Heading 1
## Heading 2
# Heading 1 link [Heading link](https://github.com/pandao/editor.md "Heading link")
## Heading 2 link [Heading link](https://github.com/pandao/editor.md "Heading link")

#### 标题（用底线的形式）Heading (underline)

This is an H1
=============

This is an H2
-------------


### 引用 Blockquotes

> 引用文本 Blockquotes

引用的行内混合 Blockquotes

### 锚点与链接 Links

[普通链接](http://localhost/)

[普通链接带标题](http://localhost/ "普通链接带标题")

> @pandao

### 多语言代码高亮 Codes

#### 行内代码 Inline code

执行命令：`npm install marked`

#### 缩进风格

        <?php
        echo "Hello world!";
    ?>

        预格式化文本：

    | First Header  | Second Header |
    | ------------- | ------------- |
    | Content Cell  | Content Cell  |
    | Content Cell  | Content Cell  |

#### JS代码　

```javascript
function test() {
	console.log("Hello world!");
}
```

### 图片 Images

Image:

![](https://pandao.github.io/editor.md/examples/images/8.jpg)

> 图为：厦门白城沙滩

图片加链接 (Image + Link)：

[![](https://pandao.github.io/editor.md/examples/images/7.jpg)](https://pandao.github.io/editor.md/images/7.jpg "李健首张专辑《似水流年》封面")

> 图为：李健首张专辑《似水流年》封面

----

### 列表 Lists

#### 无序列表（加号和嵌套）Unordered Lists (+)

+ 列表二
    + 列表二-1
    + 列表二-2
    + 列表二-3

#### GFM task list

- [x] GFM task list 1
- [x] GFM task list 2
- [ ] GFM task list 3

----

### 绘制表格 Tables

| 项目        | 价格   |  数量  |
| --------   | -----:  | :----:  |
| 计算机      | $1600   |   5     |
| 手机        |   $12   |   12   |
| 管线        |    $1    |  234  |

----

#### 特殊符号 HTML Entities Codes

&copy; &  &uml; &trade; &iexcl; &pound;

### End
    </textarea>
</div>
<script src="js/jquery.min.js"></script>
<script src="editormd/editormd.min.js"></script>
<s:form action="edit">
    <script type="text/javascript">
        $(function() {
            var editor = editormd("test-editor", {
                width  : "60%",
                height : 540,
                path   : "editormd/lib/",
                saveHTMLToTextarea : true
            });
            editor.getMarkdown();
            $.ajax()
        });
    </script>
    <input type="submit">
</s:form>
</body>
</html>
