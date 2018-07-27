<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        菜单列表
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li><a href="#">权限管理</a></li>
        <li class="active">菜单管理</li>
    </ol>
</section>
<section class="content">
    <#--<button class="btn btn-primary" data-toggle="modal" data-target="#addModal">-->
        <#--增加菜单-->
    <#--</button>-->
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true" data-backdrop="static">
    </div>
    <table id="menuTable" class="table table-bordered" data-page-size="20">
        <thead>
        <tr>
            <th data-sortable="true" data-field="id">ID</th>
            <th data-sortable="true" data-field="name">名称</th>
            <th data-sortable="true" data-field="url">地址</th>
            <th data-sortable="true" data-field="parentId">父节点</th>
            <th data-sortable="true" data-field="status">状态</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
</section>
<script>
    $("#menuTable").bootstrapTable({
        url: "/permMenu/permissionList",
        method: "GET",
        search: true,
        searchAlign: "left",
        pagination: true,
        pageSize: 10,
        pageList: [5, 10, 15, 20],
        showRefresh: true,
        locale: "zh-CN",
        striped: true //隔行换色
    });
    function addPage() {
        $("#addModal").load("/permMenu/addPage");
    }
</script>