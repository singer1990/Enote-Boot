function menuClick(url,that) {
    $(".treeview .treeview-menu li").removeClass("active");
    $(".treeview").removeClass("active");
    if(!$(that).hasClass("treeview")){
        $(that).parent().parent().addClass("active");
    }
    $(that).addClass("active");
    $(".content-wrapper").load(url);
}