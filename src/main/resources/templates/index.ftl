<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Starter</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="${staticUrl}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${staticUrl}/css/bootstrap-table.min.css">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="${staticUrl}/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="${staticUrl}/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${staticUrl}/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. We have chosen the skin-blue for this starter
          page. However, you can choose any other skin. Make sure you
          apply the skin class to the body tag so the changes take effect. -->
    <link rel="stylesheet" href="${staticUrl}/css/skins/skin-blue.min.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <!--<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>-->
    <!--<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>-->
    <![endif]-->

    <!-- Google Font -->
    <#--<link rel="stylesheet"-->
          <#--href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">-->
</head>
<!--
BODY TAG OPTIONS:
=================
Apply one or more of the following classes to get the
desired effect
|---------------------------------------------------------|
|LAYOUT OPTIONS | fixed                                   |
|               | layout-boxed                            |
|               | layout-top-nav                          |
|               | sidebar-collapse                        |
|               | sidebar-mini                            |
|---------------------------------------------------------|
-->
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <!-- Main Header -->
    <header class="main-header">

        <!-- Logo -->
        <a href="/homepage/init" class="logo">
            <!-- mini logo for sidebar mini 50x50 pixels -->
            <span class="logo-mini"><b>ENOTE</b></span>
            <!-- logo for regular state and mobile devices -->
            <span class="logo-lg"><b>ENOTE</b>后台管理</span>
        </a>

        <!-- Header Navbar -->
        <nav class="navbar navbar-static-top" role="navigation">
            <!-- Sidebar toggle button-->
            <a href="#" class="sidebar-toggle" data-toggle="push-menu" role="button">
                <span class="sr-only">Toggle navigation</span>
            </a>
            <!-- Navbar Right Menu -->
            <div class="navbar-custom-menu">
                <ul class="nav navbar-nav">
                    <li>
                        <a>
                            <span>${userAccount.username!}</span>
                        </a>
                    </li>
                </ul>
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/user/logout">
                            <span class="hidden-xs">退出</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
    </header>
    <!-- Left side column. contains the logo and sidebar -->
    <aside class="main-sidebar">

        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">

            <!-- Sidebar user panel (optional) -->
            <div class="user-panel">
                <div class="pull-left image">
                    <img src="/static/img/user-160x160.png" class="img-circle" alt="User Image">
                </div>
                <div class="pull-left info">
                    <p>${userAccount.nickName!}</p>
                    <!-- Status -->
                    <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
                </div>
            </div>

            <!-- Sidebar Menu -->
            <ul class="sidebar-menu" data-widget="tree">
                <li class="header">菜单(根据用户角色动态加载)</li>
                <!-- Optionally, you can add icons to the links -->
                <li class="active treeview" onclick="menuClick('/homepage/dashBoard',this)"><a href="#">
                    <i class="fa fa-dashboard"></i> <span>账号信息</span></a>
                </li>
                <#if menuList??>
                    <#list menuList as item>
                        <#if item.isLeaf == 0>
                            <li class="treeview">
                                <a href="javascript:void(0);"><i class="fa fa-list"></i>
                                    <span>${item.name!}</span>
                                    <span class="pull-right-container">
                                        <i class="fa fa-angle-left pull-right"></i>
                                    </span>
                                </a>
                                <ul class="treeview-menu">
                                    <#list item.children as child>
                                        <li onclick="menuClick('${child.url!}',this)">
                                        <a data-url="${child.url!}" href="javascript:void(0);">
                                            <i class="fa fa-circle-o"></i>${child.name!}</a></li>
                                    </#list>
                                </ul>
                            </li>
                        </#if>
                    </#list>
                </#if>
                <#--<li class="treeview">-->
                    <#--<a href="#"><i class="fa fa-list"></i> <span>一级菜单</span>-->
                        <#--<span class="pull-right-container">-->
                            <#--<i class="fa fa-angle-left pull-right"></i>-->
                        <#--</span>-->
                    <#--</a>-->
                    <#--<ul class="treeview-menu">-->
                        <#--<li class="testMethod"><a href="#"><i class="fa fa-circle-o"></i>二级菜单</a></li>-->
                        <#--<li><a href="#"><i class="fa fa-circle-o"></i>二级菜单</a></li>-->
                    <#--</ul>-->
                <#--</li>-->
                <#--<li class="treeview" id="articleList">-->
                    <#--<a href="#"><i class="fa fa-book"></i> <span>Json Data</span></a></li>-->
                <#--<li class="treeview" id="articleInit">-->
                    <#--<a href="#"><i class="fa fa-table"></i> <span>Bootstrap Table</span></a>-->
                <#--</li>-->
            </ul>
            <!-- /.sidebar-menu -->
        </section>
        <!-- /.sidebar -->
    </aside>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>
                Page Header
                <small>Optional description</small>
            </h1>
            <ol class="breadcrumb">
                <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
                <li class="active">Here</li>
            </ol>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <!--------------------------
              | Your Page Content Here |
              -------------------------->

        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- Main Footer -->
    <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
            Anything you want
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2016 <a href="#">Company</a>.</strong> All rights reserved.
    </footer>

    <!-- Control Sidebar -->
    <!-- /.control-sidebar -->
    <!-- Add the sidebar's background. This div must be placed
    immediately after the control sidebar -->
    <div class="control-sidebar-bg"></div>
</div>
<!-- ./wrapper -->

<!-- REQUIRED JS SCRIPTS -->

<!-- jQuery 3 -->
<script src="/static/js/jquery.min.js"></script>
<!-- Bootstrap 3.3.7 -->
<script src="/static/js/bootstrap.min.js"></script>
<!-- Bootstrap-table插件 -->
<script src="/static/js/bootstrap-table.min.js"></script>
<script src="/static/js/bootstrap-table-zh-CN.min.js"></script>
<!-- AdminLTE App -->
<script src="/static/js/adminlte.min.js"></script>
<!-- bootbox弹窗插件 -->
<script src="/static/js/bootbox.min.js"></script>
<!-- sweetalert弹窗插件 -->
<script src="/static/js/sweetalert.min.js"></script>
<!-- 自定义js -->
<script src="/static/js/menuClick.js"></script>
<script>
    $(function () {
        //.ajaxError事件定位到document对象，文档内所有元素发生ajax请求异常，都将冒泡到document对象的ajaxError事件执行处理，ajax方法中有error，先处理error，再冒泡到此处的error
        $(document).ajaxError(
            //所有ajax请求异常的统一处理函数，处理
            function(event,xhr,options,exc){
                if(xhr.status == 'undefined'){
                    return;
                }
                switch(xhr.status){
                    case 403:
                        // 未授权异常
                        swal("403","您没有访问权限。","error");
                        break;
                    case 404:
                        // 未找到页面
                        swal("404","您访问的资源不存在。","error");
                        break;
                    case 500:
                        // 服务器异常
                        swal("500","服务器异常，请稍后再试。","error");
                        break;
                }
            }
        );
        $(".content-wrapper").load("/homepage/dashBoard");
    });
</script>
<!-- Optionally, you can add Slimscroll and FastClick plugins.
     Both of these plugins are recommended to enhance the
     user experience. -->
</body>
</html>