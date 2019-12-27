<%--
  Created by IntelliJ IDEA.
  User: daiyu
  Date: 2019/12/21
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mine</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="js/jquery-3.3.1.min%20(1).js"></script>
    <script src="js/bootstrap-select.js"></script>
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <script type="text/javascript" src="layui/layui.all.js"></script>
    <script type="text/javascript" src="layui/layui.js" charset="utf-8"></script>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        #content{
            overflow: hidden;
            text-overflow: ellipsis;
            display: -webkit-box;
            -webkit-line-clamp: 3;
        }
         div.test
         {
             white-space:nowrap;
             width:12em;
             overflow:hidden;
             border:1px solid #000000;
         }
    </style>
</head>
<body>
<div class="layui-layout layui-layout-admin" style="height: 75px">
    <div class="layui-header" style="height: 100%">
        <div class="layui-logo" style="font-weight: bolder;">
            <h1 ><a href="index.jsp" style="color: white;text-decoration-line: none;">个人博客</a></h1>
        </div>
        <ul class="layui-nav layui-layout-right" style="margin-top: 8px;">
            <li class="layui-nav-item">
                <input type="text" name="title"  placeholder="搜索问题" class="layui-input" style="width: 200px;margin-top: 2px">
            </li>
            <li class="layui-nav-item" style="margin-left: 20px">
                <button type="button" class="layui-btn layui-btn-primary">搜索</button>
            </li>
            <li class="layui-nav-item" style="position: relative">
                <a id="myname"></a>
                <span class="layui-badge-dot layui-bg-orange" style="position: absolute;right: 0"></span>
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
                    <legend><h2>我的发布</h2></legend>
                </fieldset>
            </div>
            <div style="padding: 20px; background-color: #F2F2F2;">
                <div class="layui-row layui-col-space15">
                    <div class="layui-col-md12 essay">

                    </div>
                </div>
            </div>
            <div>
                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                    <legend><h2>我的收藏</h2></legend>
                </fieldset>
            </div>
            <div style="padding: 20px; background-color: #F2F2F2;">
                <div class="layui-row layui-col-space15">
                    <div class="layui-col-md12 store">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<script>
    layui.use('element', function(){
        var element = layui.element;

    });
    function loadInfo() {
        $("#myname").text(window.sessionStorage.getItem("username"));
        if (window.sessionStorage.getItem("username")){
            $("#logout").show();
            $("#question").show();
        }
        else{
            $("#login").show();
        }
        a();
        b();
    }

    function a() {
        $.ajax({
            url: "/myessay",
            type: "post",
            dataType: "json",
            contentType: "application/json;charset=UTF-8",
            data: JSON.stringify({}),
            success: function (data) {
                var text = "";
                if (data.msg=="未登录！"){
                    window.location.href="index.jsp";
                }
                data.data.forEach(function (item) {
                    var arr = item.econtent.split("\"");
                    var imgurl = c(arr);
                    text += '<div class="more" ondblclick="intoessay(`' + item.eid + '`)">' +
                        '<div class="layui-card"><br>' +
                        '<div class="layui-card-header" ><h2>' + item.etitle + '</h2></div>' +
                        '<div class="layui-card-body"><div class="layui-col-md9" id="content">&nbsp;&nbsp;&nbsp;&nbsp;' +
                        String(item.econtent).replace("img", "").replace("<p", "").replace("/<*>/","")/*.replace(" ","").slice(0,200)+"..."*/ +
                        '</div>' +
                        '<div class="layui-col-md3">';
                    if (imgurl != null) {
                        text += '<img style=" display:block;position:relative;margin:auto;width: 100px;height: 100px" src="' + imgurl + '">';
                    }
                    text += '</div><div class="layui-row"><br>' +
                        '<span class="glyphicon glyphicon-heart" style="color: indianred">:' + item.elike + '</span>' +
                        '<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="glyphicon glyphicon-tasks" style="color: #5cbfcd">:' + item.tagname + '</span>' +
                        '<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="glyphicon glyphicon-pencil" style="color: #3F7F7F">:' + item.ecomment + '</span>' +
                        '</div><hr>' +
                        '<span class="icon time" style="float: right"><i class="layui-icon layui-icon-log">' +
                        String(item.createTime).replace("T", " ") + '</i></span><br>' +
                        '</div></div></div><hr>';
                })
                $(".essay").html(text);
            },
            error: function (error) {
                console.log(error.statusText)
            }
        })
    }

    function c(arr) {

        var pattern = /^((https|http|ftp|rtsp|mms)?:\/\/)[^\s]+/;
        var url=null;
        arr.forEach(function (src) {
            if(src.match(pattern)){
                url= src;
            }
        })
        return url;
    }

    function b(){
        $.ajax({url:"/mystore",
            type:"post",
            dataType: "json",
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({}),
            success:function(data) {
                var text="";
                data.data.forEach(function(item){
                    var arr=item.econtent.split("\"");
                    var imgurl=c(arr);
                    text+='<div class="more" ondblclick="intoessay(`'+item.eid+'`)">'+
                        '<div class="layui-card"><br>'+
                        '<div class="layui-card-header">'+item.etitle+'</div>'+
                        '<div class="layui-card-body"><div class="layui-col-md9 "id="content">&nbsp;&nbsp;&nbsp;&nbsp;'+item.econtent.replace("img","").replace("<p", "").replace("/<*>/","")+
                        '</div>' +
                        '<div class="layui-col-md3">';
                    if (imgurl!=null){
                        text+='<img style=" display:block;position:relative;margin:auto;width: 100px;height: 100px" src="'+imgurl+'">'
                    }
                    text+='</div><div class="layui-row"><br>' +
                        '<span class="glyphicon glyphicon-user" style="margin: auto;color: #75787b">:'+item.userName+'</span>'+
                        '<span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span><span class="glyphicon glyphicon-tasks" style="color: #5cbfcd">:' + item.tagname + '</span>' +
                        '<span class="icon time" style="float: right"><i class="layui-icon layui-icon-log">'+
                        String(item.createTime).replace("T"," ")+'</i></span><br>'+
                        '</div></div><hr>';
                })
                $(".store").html(text);
            },
            error:function (error) {
                console.log(error.statusText)
            }
        })
    }

    window.onload = loadInfo;

    function intoessay(id){
        window.location.href="Answer.jsp?eid="+id;
    }
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
</script>
</body>
</html>