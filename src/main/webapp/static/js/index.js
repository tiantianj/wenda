$(function(){
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    //项目根路径
    var basePath = result+"/";

    //获取导航栏分类数据
    $.post(basePath+"index/category",function (data) {
        if(!data || data.length<10){
            $("#nav-categories>li:last").hide();
        }

        $(data).each(function (index) {
            if(index<10){
                $("#nav-categories>li:last").before("<li><a href=\"#\">"+this.name+"</a></li>");
            }else{
                $("#nav-categories>li:last>ul").append("<li><a href=\"#\">"+this.name+"</a></li>")
            }
        });
    },"json");
});