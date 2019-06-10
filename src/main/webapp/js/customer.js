function ajaxCustomer(params) {
    console.log("我点了...");
    $.ajax({
        url: "/crmSys/customer/customers",
        type: "GET",
        dataType: "json",
        success: function (rs) {
            var message = rs.array;
            params.success({ // 注意，必须返回参数 params
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

var $tableCustomer = $("#tableCustomer"),
    $addCustomer = $("#addCustomer"),
    $editCustomer = $("#editCustomer"),
    $lookCustomer = $("#lookCustomer"),
    $deleteCustomer = $("#deleteCustomer"),
    $refreshCustomer = $("#refreshCustomer");

// 按钮可用与否
$editCustomer.prop('disabled', true);
$lookCustomer.prop('disabled', true);
$deleteCustomer.prop('disabled', true);
$tableCustomer.on('check.bs.table uncheck.bs.table ' + 'check-all.bs.table uncheck-all.bs.table', function () {
    //选中的数量不为0并且数量为1
    var bool = !($tableCustomer.bootstrapTable('getSelections').length && $tableCustomer.bootstrapTable('getSelections').length == 1);
    $editCustomer.prop('disabled', bool);
    $lookCustomer.prop('disabled', bool);
    $deleteCustomer.prop('disabled', bool);
});

// 添加
layui.use("layer", function () {
    $addCustomer.on('click', function () {
    	$('#customerCommit').css("display","inline-block");
        var index = layer.open({
            type: 1,
            title: '添加客户',
            shadeClose: false,
            shade: 0.8,
            scrollbar: false,
            isOutAnim: true,
            anim: 2,
            area: ['550px', '480px'],
            content: $('#layer-customer'),
            success: function () {
                $('#layer-customer').css("padding", "10px");
                $('#layer-customer > .input-group').css("padding", "10px");
                // 显示结点
                $('#layer-customer').css("display", 'block');

                // 窗口关闭事件
                $(document).on('click', '#customerCancel',
                    function () {
                        layer.close(index);
                    });
                // 判断用户名格式
                blurVerification("#customerName");
                //判断手机号
                blurVerification("#customerPhoneNumber");

                // 判断admin电话
                blurVerification("#customerEmail");

                // 客户邮箱查重
                $(document).on('blur', '#customerEmail', function () {
                    checkRepeat(
                        JSON.stringify({
                            cemail: $('#customerEmail').val().trim()
                        }),
                        "/crmSys/customer/checkemail", 'POST', "邮箱");
                });
            },
            // 关闭弹窗后执行
            end: function () {
            	$('#customerCommit').css("display","none");
            },
            // 右上角关闭事件
            cancel: function () {
                $("#layer-customer input").val("");
            }
        });
    });
});

//删除
$deleteCustomer.on('click', function () {
    var ids = getUtilSelections($tableCustomer);
    layui.use('layer', function () {
        layer.confirm('您是否要删除当前 ' + ids.length + '条数据？', {
            btn: ['是', '否']
        }, function () {
            console.log("打印删除数组" + ids[0].loginname);
            deleteItem(JSON.stringify({
                cemail: ids[0].cemail
            }), "/crmSys/customer/delete", "POST");
             layui.use('layer', function () {
                 layer.msg('删除成功', {
                     icon: 1,
                     time: 800 //2秒关闭（如果不配置，默认是3秒）
                 }, function () {
                 });
             });
            $tableCustomer.bootstrapTable('refresh');
        });
    })
});

//编辑
$editCustomer.on('click', function () {
	$('#customerCommit2').css("display","inline-block");
    var row = getUtilSelections($tableCustomer)[0];
    console.log("row: " + row);

    layui.use('layer', function () {
        var indexcustomer = layer.open({
            type: 1,
            title: '编辑客户',
            shadeClose: false,
            shade: 0,
            area: ['70%', '60%'],
            content: $('#layer-customer'),
            success: function () {
                $('#layer-customer').css("padding", "10px");
                $('#layer-customer > .input-group').css("padding", "10px");

                if (row == undefined) {
                    layer.msg("Customer未知错误", {
                        icon: 2,
                        time: 1000 // 1秒关闭（如果不配置，默认是3秒）
                    });
                    return;
                }
                $('#customerName').val(row.cname);
                $('#customerPhoneNumber').val(row.cnumber);
                $('#customerAddr').val(row.caddr);
                $('#customerCreateDate').val(row.createdate);
                $('#customerEmail').val(row.cemail);
                $('#customerRank').val(row.crank);


                 $('#customerPhoneNumber').attr("disabled", true);
            },
            end: function () { // 最后执行reload
            	$('#customerPhoneNumber').attr("disabled", false);
                // $('#customerName').attr("disabled", false);
                $('#customerName').val("");
                $('#customerPhoneNumber').val("");
                $('#customerAddr').val("");
                $('#customerCreateDate').val("");
                $('#customerEmail').val("");
                $('#customerRank').val("");
                $('#customerCommit2').css("display","none");
            }
        });
    })
});

//添加提交
$(document).on('click', '#customerCommit', function () {
    $('#customerName').trigger("blur");
    if (nameRegular($('#customerName').val()) !== true) {
        console.error("客户姓名错误!");
        return;
    }
    $('#customerPhoneNumber').trigger("blur");
    if (phoneNumberRegular($('#customerPhoneNumber').val()) !== true) {
        console.error("客户电话格式错误!");
        return;
    }
    $('#customerEmail').trigger("blur");
    if (emailRegular($('#customerEmail').val()) !== true) {
        console.error("客户邮箱错误!");
        return;
    }
    /*
      cname: $(dom1).val(),
      cnumber: $(dom2).val(),
      caddr: $(dom3).val(),
      cemail: $(dom4).val(),
      crank: $(dom5).val()
    */
    // 提交点击请求
    addCustomer('#customerName',
        '#customerPhoneNumber', '#customerAddr', '#customerEmail', "#customerRank");

    // 清空所有input框
    $("#layer-customer input").val("");
    $('#customerCancel').trigger("click");
    $tableCustomer.bootstrapTable('refresh');
});

//编辑提交
$(document).on('click', '#customerCommit2', function () {
    // 修改事件
    updateItem(JSON.stringify({
        cname: $('#customerName').val(),
        cnumber: $('#customerPhoneNumber').val(),
        caddr: $('#customerAddr').val(),
        createdate: $('#customerCreateDate').val(),
        cemail: $('#customerEmail').val(),
        crank: $('#customerRank').val()
    }), "/crmSys/customer/update", "POST");
    $tableCustomer.bootstrapTable('refresh');
    $('#customerCancel').trigger("click");
//    console.log("我要关闭编辑弹窗了...");
//    layer.close(indexcustomer);
});

//添加客户
function addCustomer(dom1, dom2, dom3, dom4, dom5) {
    var str = {
        cname: $(dom1).val(),
        cnumber: $(dom2).val(),
        caddr: $(dom3).val(),
        cemail: $(dom4).val(),
        crank: $(dom5).val()
    };
    console.log("cemail: "+ $(dom4).val());
    console.log("crank: "+ $(dom5).val())
    var jsonStr = JSON.stringify(str);
    console.log("添加客户: " + jsonStr);
    $.ajax({
        type: "POST",
        url: "/crmSys/customer/add",
        data: jsonStr,
        contentType: "application/json",
        dataType: 'json',
        success: function (data) {
            var status = data.status;
            console.log(status);
            if (status == "true") {
                layer.msg('添加成功', {
                    icon: 1,
                    time: 700 //2秒关闭（如果不配置，默认是3秒）
                }, function () {
                });
            } else {
                layer.msg('添加失败', {
                    icon: 2,
                    time: 700 //0.7秒关闭（如果不配置，默认是3秒）
                }, function () {
                });
            }
        },
        error: function () {
            console.error("error");
        }
    });

}

