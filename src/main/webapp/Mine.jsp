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
</head>
<body>
<div class="layui-layout layui-layout-admin" style="height: 65px">
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
            <li class="layui-nav-item" style="display: none" id="question"><a href="Question.jsp">提问</a></li>
            <li class="layui-nav-item"><a href="login.jsp">退出</a></li>
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

        $.ajax({url:"/myessay",
            type:"post",
            dataType: "json",
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({}),
            success:function(data) {
                var text="";
                data.data.forEach(function(item){
                    text+='<div class="more" onclick="intoessay(`'+item.eid+'`)">'+
                        '<div class="layui-card">'+
                        '<div class="layui-card-header">'+item.etitle+'</div>'+
                        '<div class="layui-card-body"><div class="layui-col-md9">&nbsp;&nbsp;&nbsp;&nbsp;'+item.econtent+
                        '</div>' +
                        '<div class="layui-col-md3">' +
                        '<img style=" display:block;position:relative;margin:auto;width: 100px;height: 100px" src="http://192.168.161.1:9999/upload/f8161ce46f5d422281396b0d5629d2c3.jpg">' +
                        '</div><div class="layui-row"><br>' +
                        '<span class="glyphicon glyphicon-heart" style="margin: auto;color: indianred">:'+item.elike+'</span>'+
                        '<span style="float: right;color: #00a8c6">tag:'+item.tagname+'</span></div><hr></div>'+
                        '<span class="icon time" style="float: right"><i class="layui-icon layui-icon-log">'+
                        String(item.createTime).replace("T"," ")+'</i></span>'+
                        '</div></div><hr>';
                })
                $(".essay").html(text);
                console.log(data);
            },
            error:function (error) {
                console.log(error.statusText)
            }
            })

        $.ajax({url:"/mystore",
            type:"post",
            dataType: "json",
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({}),
            success:function(data) {
                var text="";
                data.data.forEach(function(item){
                    text+='<div class="more" onclick="intoessay(`'+item.eid+'`)">'+
                        '<div class="layui-card">'+
                        '<div class="layui-card-header">'+item.etitle+'</div>'+
                        '<div class="layui-card-body"><div class="layui-col-md9">&nbsp;&nbsp;&nbsp;&nbsp;'+item.econtent+
                        '</div>' +
                        '<div class="layui-col-md3">' +
                        '<img style=" display:block;position:relative;margin:auto;width: 100px;height: 100px" src="http://192.168.161.1:9999/upload/f8161ce46f5d422281396b0d5629d2c3.jpg">' +
                        '</div><div class="layui-row"><br>' +
                        '<span class="glyphicon glyphicon-user" style="margin: auto;color: #75787b">:'+item.userName+'</span>'+
                        '<span style="float: right;color: #00a8c6">tag:'+item.tagname+'</span></div><hr></div>'+
                        '<span class="icon time" style="float: right"><i class="layui-icon layui-icon-log">'+
                        String(item.createTime).replace("T"," ")+'</i></span>'+
                        '</div></div><hr>';
                })
                $(".store").html(text);
                console.log(data);

            },
            error:function (error) {
                console.log(error.statusText)
            }
        })
    }
    window.onload = loadInfo;
    function intoessay(id){
        console.log(id)
    }

</script>
</body>
</html>