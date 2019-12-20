<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Author: sofiworker
  Version: 1.0.0
  Date: 2019/12/7 22:37
  Description: 用户注册页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html  lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&amp;subset=devanagari,latin-ext" rel="stylesheet">
    <title>注册</title>
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootsnav.css" >
    <link rel="stylesheet" href="css/style.css">
    <link rel="stylesheet" href="css/responsive.css">
    <script src="js/jquery.js"></script>
    <script type="text/javascript" src="layui/layui.js"></script>
    <script type="text/javascript" src="layui/layui.all.js"></script>
</head>
<body>
<!--[if lte IE 9]>
<p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="https://browsehappy.com/">upgrade your browser</a> to improve your experience and security.</p>
<![endif]-->

<!-- signin end -->
<section class="signin signup popup-up">
    <div class="container">

        <div class="sign-content popup-in-content">
            <div class="popup-in-txt">
                <h2>注册</h2>

                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-form">
                            <form enctype="multipart/form-data" method="post" id="register">
                                <div class="form-group">
                                    <label for="signin_form1">账号</label>
                                    <input type="text" class="form-control" id="signin_form1"  name="uid" placeholder="请输入您的账号">
                                </div><!--/.form-group -->
                                <div class="form-group">
                                    <label for="signin_form2">昵称</label>
                                    <input type="text" class="form-control" id="signin_form2"  name="username" placeholder="请输入您的昵称">
                                </div><!--/.form-group -->
                                <div class="form-group">
                                    <label for="signin_form3">密码</label>
                                    <input type="password" class="form-control" id="signin_form3"  name="password" placeholder="密码">
                                </div><!--/.form-group -->
                                <div class="form-group">
                                    <label for="signin_form4">确认密码</label>
                                    <input type="password" class="form-control" id="signin_form4"  name="password" placeholder="确认密码">
                                </div><!--/.form-group -->
                                <div class="form-group">
                                    <label for="signin_form5">性别</label>
                                    <input type="text" class="form-control" id="signin_form5"  name="gender" placeholder="性别">
                                </div><!--/.form-group -->
                                <div class="form-group">
                                    <label for="signin_form6">个人签名</label>
                                    <input type="text" class="form-control" id="signin_form6"  name="sign" placeholder="个人签名">
                                </div><!--/.form-group -->
                                <div class="form-group">
                                    <label for="id_head" >头像</label>
                                    <label for="id_head" style="margin-left: 15px"><img id="head-img" src="image/work.jpg" alt="" style="height:80px;width:80px"></label>
                                    <input accept="image/*" type="file" id="id_head" name="photo" style="display: none" onclick="avatar()">
                                    <span class="help-block">点击图片更换头像</span>
                                </div>
                                <div class="form-group" style="display: none">
                                    <input type="text" class="form-control"   name="type" value="0">
                                </div><!--/.form-group -->
                                <div class="form-group" style="display: none">
                                    <input type="date" class="form-control"   name="createtime" id="time" value="">
                                </div><!--/.form-group -->
                            </form><!--/form -->
                        </div><!--/.signin-form -->
                    </div><!--/.col -->
                </div><!--/.row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-password">
                            <div class="awesome-checkbox-list">
                                <ul class="unstyled centered">
                                    <li>
                                        <input class="styled-checkbox" id="styled-checkbox-2" type="checkbox" value="value2">
                                        <label for="styled-checkbox-2">接受注册协议</label>
                                    </li>
                                    <li></li>
                                </ul>
                            </div><!--/.awesome-checkbox-list -->
                        </div><!--/.signin-password -->
                    </div><!--/.col -->
                </div><!--/.row -->
                <div class="row">
                    <div class="col-sm-12">
                        <div class="signin-footer">
                            <button type="button" class="btn signin_btn" onclick="register()">
                                注册
                            </button>
                            <p>
                                已注册？
                                <a href="login.jsp">登录</a>
                            </p>
                        </div><!--/.signin-footer -->
                    </div><!--/.col-->
                </div><!--/.row -->
            </div><!-- .popup-in-txt -->
        </div><!--/.sign-content -->
    </div><!--/.container -->
</section><!--/.signin -->
<script>
    function avatar() {
        $("#id_head").change(function () {
            // 1. 创建一个读取文件的对象
            var fileReader = new FileReader();
            // 当前选中文件对象
            // console.log(this.files[0]);
            // 读取选中文件
            fileReader.readAsDataURL(this.files[0]);
            fileReader.onload = function () {
                $("#head-img").attr("src", fileReader.result);
            };
        });
    }
    var $ = layui.$;
    function form2JsonString(formId) {
        var paramArray = $('#' + formId).serializeArray();
        var jsonObj = {};
        $(paramArray).each(function () {
            jsonObj[this.name] = this.value;
        });
        return JSON.stringify(jsonObj);
    }
    function register(){
        console.log('11111111111111111');
        getTime()
        var userBean  = eval("("+form2JsonString("register")+")");
        console.log(userBean)
        var data = {userBean}
        console.log(data)
        $.ajax({url:"http://localhost:9999/register",
            type:"post",
            dataType: "json",
            processData: false,
            contentType: false,
            data:data,
            success:function(data) {
                console.log(data);
                console.log(data.data.uid);
            }})
        /*window.location.href="login.jsp";*/
    }
    function getTime() {
        var date = new Date();
        var year=date.getFullYear();
        var mon=date.getMonth()+1;
        var da=date.getDate();
        var mytime=year+"-"+mon+"-"+da;
        console.log("1111111111111111111111"+mytime)
        $("#time").val(mytime)
    }
</script>
<script src="js/jquery.js"></script>
<script src="js/modernizr.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootsnav.js"></script>
<script src="js/jquery.sticky.js"></script>
<script src="js/jquery.easing.min.js"></script>
<script src="js/custom.js"></script>
</body>
</html>
