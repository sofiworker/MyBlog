<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Author: sofiworker
  Version: 1.0.0
  Date: 2019/12/5 20:42
  Description: 登录页面
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html  lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <script src="../js/jquery.js"></script>
    <script type="text/javascript" src="../layui/layui.js"></script>
    <script type="text/javascript" src="../layui/layui.all.js"></script>
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <script src="../js/bootstrap.min.js"></script>
</head>
<body>
<p class="browserupgrade"></p>
<section class="signin popup-in">
    <div class="container">
        <div class="sign-content popup-in-content">
            <div class="popup-in-txt">
                <h2><img src="../image/login.png"> 个人博客</h2>
                <div class="row">
                    <div class="signin-form">
                        <form  name="fm" action="login" method="post">
                            <div class="form-group">
                                <label >用户名</label>
                                <input type="text" class="form-control" name="userBean.uid" placeholder="请输入正确的用户名">
                            </div><!--/.form-group -->
                            <div class="form-group">
                                <label >密码</label>
                                <input type="password" class="form-control" name="userBean.password" id="password" placeholder="请输入正确的密码">
                            </div><!--/.form-group -->
                            <div class="signin-footer">
                                <span><a href="#"></a ></span>
                                <input type="submit" value="登  录" id="logininput" class="btn signin_btn"  style="font-size: 20px;width:525px">
                                <span><a href="#"></a ></span>
                            </div><!--/.signin-footer -->
                        </form><!--/form -->
                        <div class="row">
                            <div class="col-sm-12">
                                <div class="signin-footer">
                                    <p>
                                        未注册？
                                        <a href="../register.jsp">注册</a>
                                    </p>
                                </div><!--/.signin-footer -->
                            </div><!--/.col-->
                        </div><!--/.row -->
                    </div><!--/.signin-form -->
                </div><!--/.col -->
            </div><!--/.row -->
        </div><!-- .popup-in-txt -->
    </div><!--/.sign-content -->
    </div><!--/.container -->
</section>
<footer class="footer-copyright">
    <div id="scroll-Top">
        <i class="fa fa-angle-double-up return-to-top" id="scroll-top1" data-toggle="tooltip" data-placement="top" title="" data-original-title="Back to Top" aria-hidden="true"></i>
    </div>
</footer>
</body>
</html>
