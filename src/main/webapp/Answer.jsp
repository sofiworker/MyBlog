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
                                <div class="layui-card-header" style="margin-bottom: 5px;" id="title"></div>
                                <span class="layui-breadcrumb" lay-separator="|" style="margin-left: 15px;">
                                    <a id="author">作者：</a>
                                    <a id="publishTime">发布时间：</a>
                                    <a id="visitors">收藏数： </a>
                                </span>
                                <hr style="margin-top: 5px;">
                                <div class="layui-card-body">
                                    <span id="content"></span>
                                    <hr style="margin: 20px 0">
                                    <div id="tagName"></div>
                                    <hr style="margin: 20px 0">
                                    <span id="commentCount"></span>
                                    <div id="CommentContent"></div>
                                    提交评论
                                    <hr style="margin: 20px 0">
                                    <img src="image/work.jpg" alt="" style="width: 40px;height: 40px">
                                    <span class="myname"></span>
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
        //监听提交
        form.on('submit(editor)', function(data){
            var jsondata = {
                "comment":{
                    "level":0,
                    "content":layedit.getContent(editIndex),
                    "eid":"30d419e39abe4ed5bf7f9994c33b165f"//window.sessionStorage.getItem("eid")
                }
            }
            layedit.getContent(editIndex).attr({width:"100",height:"100"});
            console.log(layedit.getContent(editIndex))
            $.ajax({url:"http://localhost:9999/comment",
                type:"post",
                dataType: "json",
                contentType:"application/json;charset=UTF-8",
                data:JSON.stringify(jsondata),
                success:function(result) {
                    /*console.log('111111111222222222222222211111111');
                    console.log(result);*/
                    /*window.location.reload();*/
                }
            })
            return false;
        });

    });
</script>
<script>
    var visitorCount = 0;
    $(function(){   //window.sessionStorage.getItem("eid")
        var data= {"essayId":"30d419e39abe4ed5bf7f9994c33b165f"}
        console.log(data)
        $.ajax({
            url:"http://localhost:9999/commentList",
            type:"post",
            dataType: "json",
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify(data),
            success:function(result) {
                if(result.data.length !== 0 && result.data.length !== null){
                    /*console.log('11111111111111111');
                    console.log(result);*/
                    var comstr = '<hr>'
                    for(i in result.data){
                        comstr += result.data[i].content+'<br>';
                        comstr += ' <span class="icon time" style="float: right">'+ '<i class="layui-icon layui-icon-user" style="size:10px">'+"  "+
                            '</i>'+result.data[i].username+"  "+'<i class="layui-icon layui-icon-log" style="size:10px">'+"  "+
                            '</i>'+(result.data[i].createTime).replace("T"," ")+'</span><hr>'
                    }
                    $("#commentCount").html("<b>"+result.data.length+"条评论</b>");
                    $("#CommentContent").html(comstr);
                    // $("#myname").html(window.sessionStorage.getItem("username"));
                }
            }
        })
    })
    $(function(){
        var data= {"str":"30d419e39abe4ed5bf7f9994c33b165f"}
        console.log(data)
        $.ajax({
            url:"http://localhost:9999/getEssay",
            type:"post",
            dataType: "json",
            contentType:"application/json;charset=UTF-8",
            data:JSON.stringify(data),
            success:function(result) {
                visitorCount++;
                console.log('00000000000000000000000000');
                console.log(result);
                $("#title").html('<h2><b>'+result.data.ETitle+'</b></h2>')
                $("#content").html(result.data.EContent)
                $("#tagName").html('<button type="button" class="layui-btn layui-btn-normal layui-btn-sm" style="border-radius:10px">'+result.data.tagName+'</button>');
                $("#author").append(result.data.userName +' | ');
                $("#publishTime").append((result.data.createTime).replace("T"," ") +' | ');
                $("#visitors").append(result.data.ELike)
            }
        })
    })

    function search() {
        layui.use('laypage', function(){
            var laypage = layui.laypage;
            var sdata ={"str":form.title.value};
            console.log(sdata)
            $.ajax({url:"http://localhost:9999/SearchEssay",
                type:"post",
                contentType:"application/json;charset=UTF-8",
                data:JSON.stringify(sdata),
                success:function(mydata) {
                    console.log(mydata)
                    var data =  mydata.data
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
                }
            });
        });
    }
</script>
</body>
</html>