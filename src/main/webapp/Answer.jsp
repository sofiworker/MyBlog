<%--
  Created by IntelliJ IDEA.
  User: daiyu
  Date: 2019/12/21
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Answer</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <script src="js/jquery-3.3.1.min%20(1).js"></script>
    <script src="js/bootstrap-select.js"></script>
    <link rel="stylesheet" href="layui/css/layui.css"  media="all">
    <script type="text/javascript" src="layui/layui.all.js"></script>
    <script type="text/javascript" src="layui/layui.js" charset="utf-8"></script>
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
                <a class="myname"></a>
            </li>
            <li class="layui-nav-item" style="display: none" id="question"><a href="Question.jsp">提问</a></li>
            <li class="layui-nav-item"><a href="login.jsp">退出</a></li>
        </ul>
    </div>
</div>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-col-md12">
            <hr style="margin: 20px 0">
            <div style="padding: 20px; background-color: #F2F2F2;">
                <div class="layui-row layui-col-space15">
                    <div class="layui-col-md12">
                        <a href="">
                            <div class="layui-card">
                                <div class="layui-card-header" style="margin-bottom: 5px;">标题</div>
                                <span class="layui-breadcrumb" lay-separator="|" style="margin-left: 15px;">
                                    <a>作者：xxx |</a>
                                    <a>发布时间：xxx |</a>
                                    <a>阅读数：xxx </a>
                                </span>
                                <hr style="margin-top: 5px;">
                                <div class="layui-card-body">
                                    内容
                                    <hr style="margin: 20px 0">
                                    <button type="button" class="layui-btn layui-btn-normal layui-btn-sm" style="border-radius:10px">标签</button>
                                    <hr style="margin: 20px 0">
                                    0个评论
                                    <hr style="margin: 20px 0">
                                    提交评论
                                    <hr style="margin: 20px 0">
                                    <img src="image/work.jpg" alt="" style="width: 40px;height: 40px">
                                    <span class="myname">林泽一</span>
                                    <hr style="margin: 20px 0">
                                    <form class="layui-form" action="">
                                        <div class="layui-form-item layui-form-text">
                                            <label class="layui-form-label">用户评论区</label>
                                            <div class="layui-input-block">
                                                <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="myEditor"></textarea>
                                            </div>
                                        </div>
                                        <div class="layui-form-item">
                                            <div class="layui-input-block" style="float: right">
                                                <button type="submit" class="layui-btn" lay-submit="" lay-filter="editor">提交评论</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<script type="text/javascript" src="layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'layedit'], function(){
        var form = layui.form
            ,layer = layui.layer
            ,layedit = layui.layedit;


        //创建一个编辑器
        var editIndex = layedit.build('myEditor');

        //自定义验证规则
        form.verify({
            content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听提交
        form.on('submit(editor)', function(data){
            layer.alert(JSON.stringify(data.field.content), {
                title: '评论内容：'
            })
            return false;
        });



    });
</script>
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
        $(".myname").val(window.sessionStorage.getItem("uid"));
        geteid();
    }
    window.onload = loadInfo;

    function geteid(){
        var eid=location.search.split("=")[1];
        $.ajax({url:"/getEssay",
            type:"post",
            dataType: "json",
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify({"str":eid}),
            success:function(data) {
                console.log(data);
            }
        })
    }


</script>
</body>
</html>