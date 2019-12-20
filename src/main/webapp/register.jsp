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
    <!-- meta data -->
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
                            <form action="login.jsp" action="register" method="post">
                                <div class="form-group">
                                    <label for="signin_form">账号</label>
                                    <input type="email" class="form-control" id="signin_form1"  name="userBean.uid" placeholder="请输入您的账号">
                                </div><!--/.form-group -->
                                <div class="form-group">
                                    <label for="signin_form">昵称</label>
                                    <input type="email" class="form-control" id="signin_form3"  name="userBean.username" placeholder="请输入您的昵称">
                                </div><!--/.form-group -->
                                <div class="form-group">
                                    <label for="signin_form">密码</label>
                                    <input type="password" class="form-control" id="signin_form4"  name="userBean.password" placeholder="密码">
                                </div><!--/.form-group -->
                                <div class="form-group">
                                    <label for="signin_form">确认密码</label>
                                    <input type="password" class="form-control" id="signin_form"  name="userBean.password" placeholder="确认密码">
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
                            <button type="button" class="btn signin_btn">
                                注册
                            </button>
                            <p>
                                已注册？
                                <a href="../login.jsp">登录</a>
                            </p>
                        </div><!--/.signin-footer -->
                    </div><!--/.col-->
                </div><!--/.row -->
            </div><!-- .popup-in-txt -->
        </div><!--/.sign-content -->
    </div><!--/.container -->
</section><!--/.signin -->

    <script src="js/jquery.js"></script>
    <script src="js/modernizr.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/bootsnav.js"></script>
    <script src="js/jquery.sticky.js"></script>
    <script src="js/jquery.easing.min.js"></script>
    <script src="js/custom.js"></script>
</body>
</html>
