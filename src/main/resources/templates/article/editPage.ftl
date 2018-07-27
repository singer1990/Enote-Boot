<div class="modal-dialog">
    <div class="modal-content">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal">
            </button>
            <h4 class="modal-title" id="myModalLabel">
                编辑文章
            </h4>
        </div>
        <div class="modal-body">
            <form id="editArticle" role="form">
                <input id="id" value="${article.id}" hidden/>
                <div class="form-group">
                    <label>标题:</label><input class="form-control" type="text" placeholder="请输入标题" name="title"
                                             id="title" value="${article.title!}"/>
                </div>
                <div class="form-group">
                    <label>摘要:</label><input class="form-control" type="text" placeholder="请输入摘要"
                                             name="summary" id="summary" value="${article.summary!}"/>
                </div>
                <div class="form-group">
                    <label>内容:</label><textarea class="form-control" rows="3" placeholder="请输入内容"
                                                name="content" id="content">${article.content!}</textarea>
                </div>
                <div class="form-group">
                    <label>是否上架:</label><select class="form-control" name="status" id="status">
                <#if article.status?? && article.status==0>
                    <option value="0" selected>上架</option>
                    <option value="1">下架</option>
                <#else >
                    <option value="0">上架</option>
                    <option value="1" selected>下架</option>
                </#if>
                </select>
                </div>
                <div class="form-group">
                    <label>是否推荐:</label><select class="form-control" name="recommendFlag" id="recommendFlag">
                    <#if article.recommendFlag?? && article.recommendFlag==0>
                        <option value="0" selected>推荐</option>
                        <option value="1">不推荐</option>
                        <#else >
                            <option value="0">推荐</option>
                            <option value="1" selected>不推荐</option>
                        </#if>
                </select>
                </div>
            </form>
        </div>
        <div class="modal-footer">
            <button type="button" class="btn btn-default" data-dismiss="modal">
                关闭
            </button>
            <button type="button" class="btn btn-primary" onclick="editArticle()"
                    data-dismiss="modal">
                提交
            </button>
        </div>
    </div>
</div>
<script>
    function editArticle() {
        var data = {
            'id': $('#id').val(),
            'title': $('#title').val(),
            'summary': $('#summary').val(),
            'content': $('#content').val(),
            'status': $('#status').val(),
            'recommendFlag': $('#recommendFlag').val()
        };
        var json_data = JSON.stringify(data);
        $.ajax({
            type: 'PUT',
            url: '/article/editArticle',
            data: json_data,
            contentType: "application/json",
            dataType: 'json',
            success: function (data) {
                if (data.status === 200) {
                    swal("修改成功!", "", "success");
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
                swal("修改失败!", "", "error");
                $("#userTable").bootstrapTable("refresh");
            }
        });
    }
</script>