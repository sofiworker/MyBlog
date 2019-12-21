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
    <meta charset="UTF-8">
    <title>Question</title>
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
            <li class="layui-nav-item"><a href="login.jsp">退出</a></li>
        </ul>
    </div>
</div>
<div class="layui-fluid">
    <div class="layui-row">
        <div class="layui-col-md12">
            <div style="padding: 20px; background-color: #F2F2F2;">
                <div class="layui-row layui-col-space15">
                    <div class="layui-col-md12">
                        <div class="layui-card">
                            <div class="layui-card-header" style="margin-bottom: 5px;">
                                <fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
                                    <legend><h2>发起</h2></legend>
                                </fieldset>
                            </div>
                            <div class="layui-card-body">
                                <div class="signin-form">
                                    <form enctype="multipart/form-data" method="post" id="register" name="fm">
                                        <div class="form-group">
                                            <label for="question"><b>问题标题:</b></label>
                                            <input type="text" class="form-control layui-input" id="question"  name="question" placeholder="问题标题...">
                                        </div>
                                    </form>
                                    <hr style="margin: 20px 0">
                                    <form enctype="multipart/form-data" method="post" id="fm_question" name="fm_question">
                                        <div class="layui-form-item layui-form-text">
                                            <label class="layui-form-label"><b>问题描述：</b></label>
                                            <div class="layui-input-block">
                                                <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="myEditor" placeholder="问题描述..."></textarea>
                                            </div>
                                        </div>
                                    </form>
                                    <hr style="margin: 20px 0">
                                    <form class="layui-form" name="fm_tag">
                                           <div class="layui-form-item" >
                                               <div class="layui-input-inline" style="margin-left: 0px;">
                                                   <label for="tag"><b>添加标签:</b></label>
                                                   <select name="tag" id="tag" lay-filter="tag"  lay-verify="required" lay-search="" placeholder="标签...">
                                                   </select>
                                               </div>
                                           </div>
                                    </form>
                                    <hr style="margin: 20px 0">
                                    <form method="post"  name="fm_btn">
                                        <div class="layui-form-item">
                                            <div class="layui-input-block" style="float: right">
                                                <button type="submit" class="layui-btn" lay-submit="" lay-filter="editor">发布</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
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
        layedit.set({
            uploadImage: {
                url: 'http://localhost:9999/fileUpload' //接口url
            }
        });
        var editIndex = layedit.build('myEditor');


        //自定义验证规则
        form.verify({
            content: function(value){
                layedit.sync(editIndex);
            }
        });

        //监听提交
        form.on('submit(editor)', function(data){
            console.log(layedit.getContent(editIndex))
            /*layer.alert(JSON.stringify(data.field.content), {
                title: '评论内容：'
            });*/
            var data = {
                "essay":{
                    "title":fm.question.value,
                    "content":layedit.getContent(editIndex),
                    "userId":"12345678910",
                    "tagId":parseInt(fm_tag.tag.value)
                }
            }
            console.log("11111111111111111111111111111111111111")
            console.log(data)
            console.log("222222222222222222222222222222")
            $.ajax({url:"/edit",
                type:"post",
                dataType: "json",
                contentType:"application/json;charset=UTF-8",
                data:JSON.stringify(data),
                success:function(data) {
                    console.log(data);
                }})
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
        // $(".myname").val(window.sessionStorage.getItem("uid"));
        $(".myname").val("12345678910");
    }
    window.onload = loadInfo;

    function addTag() {
        layui.use('form', function(){
            var form = layui.form;
            $.ajax({url:"http://localhost:9999/tagList",
                type:"post",
                dataType: "json",
                processData: false,
                contentType: false,
                success:function(result) {
                    console.log(result)
                    console.log("1111111111")
                    var tagstr = ''
                    tagstr += ' <option value="">'+"请选择标签"+'</option> ';
                    for (var i=0;i<result.data.length;i++){
                        var ops = '<option value='+result.data[i].tagId+'>'+ result.data[i].tagName +'</option> '
                        tagstr += ops
                    }
                    /*     console.log(tagstr)*/
                    $("#tag").html(tagstr)
                    form.render('select');
                }
            })
        });
    }
    window.onload = addTag;
</script>
</body>
</html>
