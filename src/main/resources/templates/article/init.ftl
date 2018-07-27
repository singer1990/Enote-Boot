<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        文章列表
    </h1>
    <ol class="breadcrumb">
        <li><a href="#"><i class="fa fa-dashboard"></i> 主页</a></li>
        <li><a href="#">基础数据管理</a></li>
        <li class="active">文章管理</li>
    </ol>
</section>
<section class="content">
    <button class="btn btn-primary" data-toggle="modal" data-target="#addModal" onclick="addPage()">
        增加文章
    </button>
    <div class="modal fade" id="addModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true" data-backdrop="static">
    </div>
    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true" data-backdrop="static">
    </div>
    <table id="userTable" class="table table-bordered" data-toggle="table" style="vertical-align: middle!important;">
        <#--<thead>-->
        <#--<tr>-->
            <#--<th data-sortable="true" data-field="id">ID</th>-->
            <#--<th data-sortable="true" data-field="title">标题</th>-->
            <#--<th data-sortable="true" data-field="summary">摘要</th>-->
            <#--<th data-sortable="true" data-field="content">内容</th>-->
            <#--<th data-sortable="true" data-field="statusStr">状态</th>-->
            <#--<th data-sortable="true" data-field="recommendStr">推荐</th>-->
            <#--<th data-sortable="true" data-field="createTime">创建时间</th>-->
            <#--<th>操作</th>-->
        <#--</tr>-->
        <#--</thead>-->
        <#--<tbody>-->
        <#--</tbody>-->
    </table>
</section>
<script>
    $("#userTable").bootstrapTable({
        url: "/article/articleList",
        method: "GET",
        search: true,
        searchAlign: "left",
        sortable: true, //是否启用排序
        sortOrder: "asc", //排序方式
        sidePagination: "server", //分页方式：client客户端分页，server服务端分页（*）
        pagination: true, //是否开启分页（*）
        pageNumber: 1, //初始化加载第一页，默认第一页
        pageSize: 10, //每页的记录行数（*）
        pageList: [5, 10, 15, 20], //可供选择的每页的行数（*）
        showRefresh: true, //刷新按钮
        locale: "zh-CN", //中文支持
        striped: true, //隔行换色
        columns: [
            {
                title:"ID",
                field:'id',
                sortable: true
            },
            {
                title:"标题",
                field:'title'
            },
            {
                title:"摘要",
                field:'summary'
            },
            {
                title:"内容",
                field:'content'
            },
            {
                title:"状态",
                field:'status',
                formatter:function(value,row,index){
                    if(value == 1){
                        return "<a style='color: red;'>下架</a>";
                    }else if(value == 0){
                        return "<a style='color: green;'>上架</a>";
                    }

                }
            },
            {
                title:"推荐",
                field:'recommendFlag',
                formatter:function(value,row,index){
                    if(value == 1){
                        return "不推荐";
                    }else if(value == 0){
                        return "推荐";
                    }

                }
            },
            {
                title:"创建时间",
                field:'createTime'
            },
            {
                title:"修改时间",
                field:'updateTime',
                sortable: true
            },
            {
                title:"操作",
                formatter:function(value,row,index){
                    return "<a onclick='editPage("+row.id+")' style='cursor: pointer' data-toggle='modal' data-target='#editModal' class='edit' data-id='"+row.id +"'>编辑</a>"+
                            "<a onclick='doDelete("+row.id+")' style='cursor: pointer' class='delete' data-id='"+row.id +"'>删除</a>";

                }
            }
        ]
    });
    //请求服务数据时所传参数
    function addPage() {
        $("#addModal").load("/article/addPage");
    }
    function editPage(id) {
        $("#editModal").load("/article/editPage?id="+id);
    }
    function doDelete(id) {
        $.ajax({
            type: 'PUT',
            url: '/article/deleteArticle/'+id,
            data: id,
//            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                if (data.status === 200) {
                    swal("删除成功!", "", "success");
                    $("#userTable").bootstrapTable("refresh");
                } else {
                    bootbox.alert({
                        message: data.msg,
                        size: 'small'
                    })
                }
            },
            error: function (data) {
                console.error(data);
                swal("删除失败!", "", "error");
                $("#userTable").bootstrapTable("refresh");
            }
        });
    }
</script>