<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">
            </button>
            <h4 class="modal-title" id="myModalLabel">
                新增文章
            </h4>
        </div>
        <div class="modal-body">
            <form id="addArticle" role="form">
                <div class="form-group">
                    <label>标题:</label><input class="form-control" type="text" placeholder="请输入标题" name="title"
                                             id="title"/>
                </div>
                <div class="form-group">
                    <label>摘要:</label><input class="form-control" type="text" placeholder="请输入摘要"
                                             name="summary" id="summary"/>
                </div>
                <div class="form-group">
                    <label>内容:</label><textarea class="form-control" rows="3" placeholder="请输入内容"
                                                name="content" id="content"></textarea>
                </div>
                <div class="form-group">
                    <label>是否推荐:</label><select class="form-control" name="recommendFlag" id="recommendFlag">
                    <option value="0">推荐</option>
                    <option value="1">不推荐</option>
                </select>
                </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">
                关闭
            </button>
            <button type="button" class="btn btn-primary" onclick="addArticle()"
                    data-dismiss="modal">
                提交
            </button>
        </div>
    </div>
</div>
<script>
    function addArticle() {
        var data = {
            'title': $('#title').val(),
            'summary': $('#summary').val(),
            'content': $('#content').val(),
            'recommendFlag': $('#recommendFlag').val()
        };
        var json_data = JSON.stringify(data);
        $.ajax({
            type: 'POST',
            url: '/article/addArticle',
            data: json_data,
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                if (data.status === 200) {
                    swal("添加成功!", "", "success");
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
                swal("添加失败!", "", "error");
            }
        });
    }
</script>