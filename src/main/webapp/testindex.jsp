<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <title>BLOG</title>

        <link rel="stylesheet" href="css/bootstrap.min.css"/>
        <link rel="stylesheet" href="css/bootstrap-theme.min.css">
        <link rel="stylesheet" href="css/community.css">
        <link rel="icon" href="/images/logo.png" type="image/x-icon"/>
        <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="google-site-verification" content="QGf2OqDw91EjWtNE07HoLJi0x0G2rIYylk6jn6JEoEQ" />
        <!-- Global site tag (gtag.js) - Google Analytics -->
</head>

<body>
<div><div>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">BLOG</span>
                </button>
                <a class="navbar-brand" href="/">BLOG</a>
            </div>

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><form class="navbar-form navbar-left" action="/" method="get">
                        <div class="form-group">
                            <input type="text" class="form-control" name="search" placeholder="搜索问题">
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form></li>

                    <li><a href="/profile/replies">通知 <span class="badge">111</span></a>
                    </li>

                    <li><a href="/profile/questions">我的问题</a></li>
                    <li><a href="/logout">退出登录</a></li>

                    <li>
                        <a href="login.jsp">登录</a>
                    </li>

                </ul>
            </div>
        </div>
    </nav>
</div></div>
<div class="container">
    <div class="container-fluid main">
        <div class="row">
            <div class="col-lg-9 col-md-12 col-sm-12 col-xs-12">
                <h3><span class="glyphicon glyphicon-th-list" aria-hidden="true"></span> 发现</h3>
                <ul class="nav nav-tabs">
                    <li role="presentation">
                        <a href="/?sort=new">最新</a>
                    </li>
                    <li role="presentation">
                        <a href="/?sort=hot30">30天最热</a>
                    </li>
                    <li role="presentation">
                        <a href="/?sort=hot7">7天最热</a>
                    </li>
                    <li role="presentation">
                        <a href="/?sort=hot">最热</a>
                    </li>
                    <li role="presentation">
                        <a href="/?sort=no" class="red">消灭零回复</a>
                    </li>
                </ul>

                <div class="media">
                    <div class="media-left">
                        <a href="#">
                            <img class="media-object img-rounded"
                                 src="">
                        </a>
                    </div>
                    <div class="media-body">
                        <h4 class="media-heading">
                            <a href="/question/599">ucloud对象存储问题</a>
                        </h4>
                        <span class="text-desc"><span>0</span> 个回复 • <span>0</span> 次浏览 • <span>2019-12-10 11:43</span></span>
                    </div>
                </div>


                <nav aria-label="Page navigation" class="text-center">
                    <ul class="pagination">
                        <li>
                            <a href="/?page=60&amp;search=&amp;tag=&amp;sort="
                               aria-label="Previous">
                                <span aria-hidden="true"><</span>
                            </a>
                        </li>
                        <li class="active">
                            <a href="/?page=1&amp;search=&amp;tag=&amp;sort=">1</a>
                        </li>

                        <li>
                            <a href="/?page=2&amp;search=&amp;tag=&amp;sort=">2</a>
                        </li>

                        <li>
                            <a href="/?page=3&amp;search=&amp;tag=&amp;sort=">3</a>
                        </li>

                        <li>
                            <a href="/?page=4&amp;search=&amp;tag=&amp;sort=">4</a>
                        </li>

                        <li>
                            <a href="/?page=2&amp;search=&amp;tag=&amp;sort="
                               aria-label="Previous">
                                <span aria-hidden="true">&gt;</span>
                            </a>
                        </li>
                    </ul>

                </nav>

            </div>
        </div>
    </div>
</div>
</body>
</html>