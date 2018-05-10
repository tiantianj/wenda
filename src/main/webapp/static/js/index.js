$(function(){
    var pathName = document.location.pathname;
    var index = pathName.substr(1).indexOf("/");
    var result = pathName.substr(0,index+1);
    //项目根路径
    var basePath = result+"/";

    //获取导航栏分类数据
    $.post(basePath+"index/category",function (data) {
        console.log(data);
    });
});