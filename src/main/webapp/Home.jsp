<%--
  Created by IntelliJ IDEA.
  User: daiyu
  Date: 2019/12/13
  Time: 12:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <script src="js/jquery-3.3.1.min%20(1).js"></script>
    <link rel="stylesheet" href="layui/css/layui.css" type="text/css"/>
    <script src="js/bootstrap-select.js"></script>
    <script type="text/javascript" src="layui/layui.all.js"></script>
    <script type="text/javascript" src="layui/layui.js"></script>
</head>
<body>
<div class="layui-layout layui-layout-admin" style="height: 65px;">
    <div class="layui-header" style="height: 100%">
        <div class="layui-logo" style="font-weight: bolder;">
            <h2 style="color: white">个人博客</h2>
        </div>
        <ul class="layui-nav layui-layout-right">
            <li class="layui-nav-item">
                <input type="text" name="title"  placeholder="搜索问题" class="layui-input" style="width: 200px;margin-top: 2px">
            </li>
            <li class="layui-nav-item" style="margin-left: 20px">
                <button type="button" class="layui-btn layui-btn-primary">搜索</button>
            </li>
            <li class="layui-nav-item">
                <a id="myname"></a>
            </li>
            <li class="layui-nav-item" style="display: none" id="question"><a href="../Login/login.html">提问</a></li>
            <li class="layui-nav-item"><a href="../Login/login.html">退出</a></li>
        </ul>
    </div>
</div>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-col-md12">
            <div>
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                    <legend><h2>发现</h2></legend>
                </fieldset>
                <span class="layui-breadcrumb" lay-separator="|">
                  <a href="javascript:Toggle(0);" class="layui-transfer-active" >最新</a>
                  <a href="javascript:Toggle(1);">7天最热</a>
                  <a href="javascript:Toggle(2);">30天最热</a>
                  <a href="javascript:Toggle(3);" >点击最多</a>
                  <a href="javascript:Toggle(4);" >消灭零回复</a>
                </span>
            </div>
            <hr style="margin: 20px 0">

            <div style="padding: 20px; background-color: #F2F2F2;">
                <div class="layui-row layui-col-space15">
                    <div class="layui-col-md12" id="items">
                    </div>
                </div>
            </div>
            <div style="text-align: center;">
                <div id="demo7"></div>
            </div>
        </div>
    </div>
</div>
<script>
    layui.use('element', function(){
        var element = layui.element;

    });
    //面包屑导航切换
    function Toggle(index){
        $('.layui-breadcrumb').find('a').each(function () {
            $(this).removeClass('layui-transfer-active');
        });
        $('.layui-breadcrumb').find('a').eq(index).addClass('layui-transfer-active');
    }
    function loadInfo() {
        $("#myname").text(window.sessionStorage.getItem("uid"));
        $("#question").show();
    }
    window.onload = loadInfo;

</script>
<script>
    layui.use('laypage', function(){
        var laypage = layui.laypage;
        var data = [];
        data = getDate();
        laypage.render({
            elem: 'demo7'
            ,count: data.length
            ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
            ,jump: function(obj) {
                // console.log(obj);
                $("#items").html("");
                var arr = [],thisData = data.concat().splice(obj.curr*obj.limit - obj.limit, obj.limit);
                layui.each(thisData, function(index, item){
                    arr.push("<a href=\"\">\n" +
                    "                            <div class=\"layui-card\">\n" +
                    "                                 <div class=\"layui-card-header\">" + item.eTitle + "</div>\n" +
                    "                                <div class=\"layui-card-body\">\n" + item.eContent + "</div>\n" +
                    "                                <span class=\"icon time\" style=\"float: right\">" +
                    "                                   <i class=\"layui-icon layui-icon-log\">\n" + String(item.createTime).replace("T", " ") + "</i>" +
                    "                                </span>\n" +
                    "                            </div>\n" +
                    "                        </a><hr>\n");
                });
                $("#items").append(arr);
            }
        });
    });
    function getDate() {
        var date =[];
        $.ajax({url:"http://localhost:9999/AllEssay",
            type:"post",
            dataType: "json",
            async: false,
            contentType: false,
            success:function(data) {
                date = data.data;
            }
        });
        return date;
    }
</script>
</body>
</html>
