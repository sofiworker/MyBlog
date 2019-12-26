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
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<style>
    #content{
        overflow: hidden;
        text-overflow: ellipsis;
        display: -webkit-box;
        -webkit-line-clamp: 3;
    }
</style>
<body>
<div class="layui-layout layui-layout-admin" style="height: 75px">
    <div class="layui-header" style="height: 100%">
        <div class="layui-logo" style="font-weight: bolder;">
            <h1 ><a href="index.jsp" style="color: white;text-decoration-line: none;">个人博客</a></h1>
        </div>
        <ul class="layui-nav layui-layout-right" style="margin-top: 8px;">
            <li class="layui-nav-item">
                <form name="form">
                    <input type="text" name="title"  placeholder="搜索问题" class="layui-input" style="width: 200px;margin-top: 2px">
                </form>
            </li>
            <li class="layui-nav-item" style="margin-left: 20px">
                <button type="button" class="layui-btn layui-btn-primary" onclick="search()">搜索</button>
            </li>
            <li class="layui-nav-item">
                <a id="myname" href="Mine.jsp"></a>
            </li>
            <li class="layui-nav-item" style="display: none" id="question"><a href="edit.jsp">提问</a></li>
            <li class="layui-nav-item" style="display: none" id="login"><a href="login.jsp">登录</a></li>
            <li class="layui-nav-item" style="display: none" id="logout"><a onclick="logout()">退出</a></li>
        </ul>
    </div>
</div>
<div class="layui-container">
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
</div>>
<script>
    function logout(){
        $.ajax({url:"/logout",
            type:"post",
            dataType: "json",
            processData: false,
            contentType: false,
            success:function(result) {
                window.sessionStorage.clear();
                window.location.href="index.jsp"
            }
        })
    }
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
        $("#myname").text(window.sessionStorage.getItem("username"));
        if (window.sessionStorage.getItem("username")){
            $("#logout").show();
            $("#question").show();
        }
        else{
            $("#login").show();
        }

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
                    var text="";
                    var content=item.EContent.split("\"");
                    var imgurl=c(content);
                    text += '<div class="more" ondblclick="intoessay(`' + item.EId + '`)">' +
                        '<div class="layui-card"><br>' +
                        '<div class="layui-card-header"><h2>' + item.ETitle + '</h2></div>' +
                        '<div class="layui-card-body"><div class="layui-col-md9" id="content">&nbsp;&nbsp;&nbsp;&nbsp;' + String(item.EContent).replace("img","").replace("<p", "").replace("/<*>/","")+
                        '</div>' +
                        '<div class="layui-col-md3">';
                    if (imgurl != null) {
                        text += '<img style=" display:block;position:relative;margin:auto;width: 100px;height: 100px" src="' + imgurl + '">';
                    }
                    text += '</div><div class="layui-row"><br>' +
                        '<span class="glyphicon glyphicon-user" style="color: #474d5b">'+item.userName+'</span>'+
                        '<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>' +
                        '<span class="glyphicon glyphicon-heart" style="color: indianred">:' + item.ELike + '</span>' +
                        '<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="glyphicon glyphicon-tasks" style="color: #5cbfcd">:' + item.tagName + '</span>' +
                        '<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="glyphicon glyphicon-pencil" style="color: #3F7F7F">:' + item.EComment + '</span>' +
                        '</div><hr>' + '<span class="icon time" style="float: right"><i class="layui-icon layui-icon-log">' +
                        String(item.createTime).replace("T", " ") + '</i></span><br>' +
                        '</div>' +
                        '</div></div><hr>';
                    arr.push(text);
                });
                $("#items").html(arr);
            }
        });
    });

    function c(content) {
        var pattern = /^((https|http|ftp|rtsp|mms)?:\/\/)[^\s]+/;
        var url;
        content.forEach(function (src) {
            if(src.match(pattern)){
                url=src;
            }
        })
        return url;
    }

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

    function intoessay(id){
        window.location.href="Answer.jsp?eid="+id;
    }
    function search() {
        layui.use('laypage', function(){
            var laypage = layui.laypage;
            var sdata ={"str":form.title.value};
            console.log(sdata)
            $.ajax({url:"/SearchEssay",
                type:"post",
                dataType:"json",
                contentType: "application/json",
                data:JSON.stringify(sdata),
                success:function(mydata) {
                    console.log(mydata)
                    var data =  mydata.data
                    console.log(data)
                    laypage.render({
                        elem: 'demo7'
                        ,count: data.length
                        ,layout: ['count', 'prev', 'page', 'next', 'limit', 'refresh', 'skip']
                        ,jump: function(obj) {
                            // console.log(obj);
                            $("#items").html("");
                            var arr = [],thisData = data.concat().splice(obj.curr*obj.limit - obj.limit, obj.limit);
                            layui.each(thisData, function(index, item){
                                var text="";
                                var content=item.EContent.split("\"");
                                var imgurl=c(content);
                                text += '<div class="more" ondblclick="intoessay(`' + item.EId + '`)">' +
                                    '<div class="layui-card"><br>' +
                                    '<div class="layui-card-header" ><h2>' + item.ETitle + '</h2></div>' +
                                    '<div class="layui-card-body"><div class="layui-col-md9 show">&nbsp;&nbsp;&nbsp;&nbsp;' + String(item.EContent).replace("img", "") +
                                    '</div>' +
                                    '<div class="layui-col-md3">';
                                if (imgurl != null) {
                                    text += '<img style=" display:block;position:relative;margin:auto;width: 100px;height: 100px" src="' + imgurl + '">';
                                }
                                text += '</div><div class="layui-row"><br>' +
                                    '<span class="glyphicon glyphicon-user" style="color: #474d5b">'+item.userName+'</span>'+
                                    '<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>' +
                                    '<span class="glyphicon glyphicon-heart" style="color: indianred">:' + item.ELike + '</span>' +
                                    '<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="glyphicon glyphicon-tasks" style="color: #5cbfcd">:' + item.tagName + '</span>' +
                                    '<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="glyphicon glyphicon-pencil" style="color: #3F7F7F">:' + item.EComment + '</span>' +
                                    '</div><hr>' +'<span class="icon time" style="float: right"><i class="layui-icon layui-icon-log">' +
                                    String(item.createTime).replace("T", " ") + '</i></span><br></div>'
                                     +
                                    '</div></div><hr>';
                                arr.push(text);
                            });
                            $("#items").append(arr);
                        }
                    });
                }
            });
        });
    }
</script>
</body>
</html>
