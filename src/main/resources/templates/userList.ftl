<html>
<link href="/static/bootstrapTable/bootstrap-table.css">
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.css">
<head>
    <title>userList</title>
</head>
<body>
<img src="/static/img/flower.jpg"/>
<div>Bootstrap Table</div>
<#--<table data-toggle="table" data-url="/user/list">-->
<#--<thead>-->
<#--<tr>-->
<#--<th data-field="id">Item ID</th>-->
<#--<th data-field="mobileNo">mobileNo</th>-->
<#--<th data-field="realName">realName</th>-->
<#--</tr>-->
<#--</thead>-->
<#--</table>-->
<table id="userTable" class="table table-bordered" data-page-size="20">
    <thead>
    <tr>
        <th data-sortable="true" data-field="id">ID</th>
        <th data-sortable="true" data-field="mobileNo">手机号</th>
        <th data-sortable="true" data-field="realName">昵称</th>
        <th data-sortable="true" data-field="dataSourceType">来源</th>
        <th data-sortable="true" data-field="platform">平台</th>
        <th data-sortable="true" data-field="registerTime">注册时间</th>
        <th data-sortable="true" data-field="reviewApplyTime">审核时间</th>
        <th data-sortable="true" data-field="reviewStatus">审核状态</th>
        <th data-sortable="true" data-field="reviewTime">审核时间</th>
        <th data-sortable="true" data-field="ucenterId">用户ID</th>
        <th data-sortable="true" data-field="ucenterUserId">中心ID</th>
    </tr>
    </thead>
    <tbody>
    </tbody>
</table>
<script src="/static/bootstrapTable/jquery1.11.3.js"></script>
<script src="/static/bootstrapTable/bootstrap3.js"></script>
<script src="/static/bootstrapTable/bootstrap-table.js"></script>
<script src="http://code.jquery.com/jquery-1.11.3.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
<script>
    $("#userTable").bootstrapTable({
        url: "/user/list",
        method: "GET",
        search: true,
        pagination: true,
        pageSize: 15,
        pageList: [5, 10, 15, 20],
        showRefresh: false,
        locale: "zh-CN",
        striped: true //隔行换色
    });
</script>
</body>
</html>
