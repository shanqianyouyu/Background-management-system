//ajax异步请求判断主键是否重复
/*
data : 要传的数据
url: 请求路径
type: 请求方式
key: 主键
* */
function checkRepeat(data, url, type, key) {
    $.ajax({
        url: url,
        type: type,
        dataType: "json",
        contentType: "application/json",
        data: data,
        success: function (res) {
            console.log(res.status);
            if (res.status !== "false") {
                layer.msg(key + "重复!", {
                    icon: 2,
                    time: 1000 //1秒关闭（如果不配置，默认是3秒）
                });
            }
        },
        error: function () {
        }
    });
}