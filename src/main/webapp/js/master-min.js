//提交弹窗
function addAdmin(dom1, dom2, dom3, dom4, dom5) {
    console.log("dom1" + $(dom1).text());
    console.log($(dom1).val());
    var str = {
        loginname: $(dom1).val(),
        password: $(dom2).val(),
        name: $(dom3).val(),
        identity: $(dom4).val(),
        phonenumber: $(dom5).val()
    };
    var jsonStr = JSON.stringify(str);
//    alert(jsonStr);
    console.log(jsonStr);
    $.ajax({
        type: "POST",
        url: "/crmSys/admin/add",
        data: jsonStr,
        contentType: "application/json",
        dataType: 'json',
//        async: false,
        success: function (data) {
            var status = data.status;
            console.log(status);
            if (status.toString() == "true") {
                layer.msg('修改成功', {
                    icon: 1,
                    time: 700 //2秒关闭（如果不配置，默认是3秒）
                }, function () {
                });
            } else {
                layer.msg('修改失败', {
                    icon: 2,
                    time: 700 //2秒关闭（如果不配置，默认是3秒）
                }, function () {
                    // dom1, dom2, dom3, dom4
                    $(dom1).val("");
                    $(dom2).val("");
                    $(dom3).val("");
                    $(dom4).val("");
                });
            }
        },
        error: function () {
            console.error("error");
        }
    });
}
