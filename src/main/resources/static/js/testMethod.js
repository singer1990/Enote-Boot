overcome = {
    // init : function (){
    //     bootbox.alert({
    //         message:"欢迎您",
    //         size:'small'
    //     })
    // },
    doClick: function () {
        alert ('点击触发事件!');
    }
};
$(function(){
    // overcome.init();
    $('.testMethod').click(function () {
        overcome.doClick();
    });

    $("#articleInit").on('click',function () {
        $('.content-wrapper').load('/article/init');
    });

    $("#articleList").on('click',function () {
        $('.content-wrapper').load('/article/articleList');
    });

});