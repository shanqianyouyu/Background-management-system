/**
 * ajax异步请求判断主键是否重复
 * data : 要传的数据
 * url: 请求路径
 * type: 请求方式
 * key: 主键
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

/**
 * ajax请求删除
 *
data : 要传的数据
url: 请求路径
type: 请求方式
* */
function deleteItem(data, url, type) {

    $.ajax({
        url: url,
        type: type,
        dataType: "json",
        contentType: "application/json",
        data: data,
        success: function (res) {
            if (res.status == "false") {
                layer.msg("删除失败", {
                    icon: 2,
                    time: 1000 //1秒关闭（如果不配置，默认是3秒）
                });
            }
            layer.open()
        },
        error: function () {
            console.error("删除出bug了...")
        }
    });
}
/**
 * ajax请求修改
 * data : 要传的数据
 * url: 请求路径
 * type: 请求方式
 */

function updateItem(data, url, type) {

    $.ajax({
        url: url,
        type: type,
        dataType: "json",
        contentType: "application/json",
        data: data,
        success: function (res) {
            if (res.status == "false") {
                layer.msg("修改失败", {
                    icon: 2,
                    time: 1000 //1秒关闭（如果不配置，默认是3秒）
                });
            }else {
                layer.msg('修改成功!', {
                    icon: 1,
                    time: 800 //2秒关闭（如果不配置，默认是3秒）
                }, function(){
                });
            }
        },
        error: function () {
            console.error("修改出bug了...")
        }
    });
}

/**
 * 返回一个类型的所有的数据
 * @param data
 */
function ajaxdatas(data,params) {
    $.ajax({
        url: "/crmSys/" + data + "/" + data + "s",
        type: "GET",
        dataType: "json",
        success: function (rs) {
            var message = rs.array;
            // 注意，必须返回参数 params
            params.success({ 
                total: rs.total,
                rows: message
            });
            // debugger;
        },
        error: function (rs) {
            console.log(rs)
        }
    });
}