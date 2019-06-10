$.tableSupplier = {
    columns: suppliercolumns,
    ajax: ajaxSupplier,
    method: 'GET',
    sidePagination: 'client',
    search: true,
    searchOnEnterKey: false,
    pagination: true,
    pageNumber: 1,
    pageSize: 10,
    striped: true,
    showPaginationSwitch: true,
    pageList: "[10, 20]",
    showRefresh: true,
    toolbar: "#toolbarSupplier",
    showToggle: true,                    //是否显示详细视图和列表视图
    iconSize: 'outline',
    paginationPreText: "<",
    paginationNextText: ">",
    paginationFirstText: "First",
    paginationLastText: "Last",
    showColumns: true,
    detailView: false,                   //是否显示父子表
    locale: "zh-CN",
    paginationHAlign: "left",
    paginationDetailHAlign: "right",
    trimOnSearch: true,
    // 这里设置表头样式
    theadClasses: "thead-dark",
    rowAttributes: function (row, index) {
        return {
            'data-toggle': 'popover',
            'data-placement': 'bottom',
            'data-trigger': 'hover',
            'data-index': index,
            'title': ['Index: ' + index,
//                            'ID: ' + row.ProductName,
                '供应商编号:  ' + row.snum,
                '名字:  ' + row.sname,
                '所在地址:  ' + row.saddr,
                '创建日期:  ' + row.createdate,
                '联系电话:  ' + row.snumber].join(', ')
        }
    }
};

function ajaxSupplier(params) {
	console.log("供应商请求数据...");
    $.ajax({
        url: "/crmSys/supplier/suppliers",
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


/**
 * 工具栏按钮
 * @type {*|jQuery|HTMLElement}
 */
var $tableSupplier = $("#tableSupplier"),
    $addSupplier = $("#addSupplier"),
    $editSupplier = $("#editSupplier"),
    $lookSupplier = $("#lookSupplier"),
    $deleteSupplier = $("#deleteSupplier");

// 按钮可用与否
$editSupplier.prop('disabled', true);
$lookSupplier.prop('disabled', true);
$deleteSupplier.prop('disabled', true);
$tableSupplier.on('check.bs.table uncheck.bs.table ' + 'check-all.bs.table uncheck-all.bs.table', function () {
    //选中的数量不为0并且数量为1
    var bool = !($tableSupplier.bootstrapTable('getSelections').length && $tableSupplier.bootstrapTable('getSelections').length == 1);
    $editSupplier.prop('disabled', bool);
    $lookSupplier.prop('disabled', bool);
    $deleteSupplier.prop('disabled', bool);
});

// 添加
layui.use("layer", function () {
    $addSupplier.on('click', function () {
        var index = layer.open({
            type: 1,
            title: '添加供应商',
            shadeClose: false,
            shade: 0.8,
            scrollbar: false,
            isOutAnim: true,
            anim: 2,
            area: ['550px', '480px'],
            content: $('#layer-supplier'),
            success: function () {
                $('#layer-supplier').css("padding", "10px");
                $('#layer-supplier > .input-group').css("padding", "10px");
                // 显示结点
                $('#layer-supplier').css("display", 'block');

                // 窗口关闭事件
                $(document).on('click', '#supplierCancel',
                    function () {
                        layer.close(index);
                    });

                //判断手机号
                blurVerification("#supplierPhoneNumber");

                // 联系电话查重
                $(document).on('blur', '#supplierPhoneNumber', function () {
                    checkRepeat(
                        JSON.stringify({
                            snumber: $('#supplierPhoneNumber').val().trim()
                        }),
                        "/crmSys/supplier/checkphonenumber", 'POST', "联系电话");
                });

                // 提交事件
                $(document).on('click', '#supplierCommit', function () {
                    if($('#supplierName').val().trim() == "") {
                        layer.msg('名字不能为空', {icon: 2});
                        return;
                    }
                    if($('#supplierAddr').val().trim() == "") {
                        layer.msg('城市不能为空', {icon: 2});
                        return;
                    }
                    $('#supplierPhoneNumber').trigger("blur");
                    if (phoneNumberRegular($('#supplierPhoneNumber').val()) !== true) {
                        console.error("电话格式错误!");
                        return;
                    }

                    /*
                      sname: $(dom1).val(),
                      saddr: $(dom2).val(),
                      snumber: $(dom3).val(),
                    */
                    // 提交点击请求
                    addSupplier('#supplierName', '#supplierAddr','#supplierPhoneNumber');

                    // 清空所有input框
                    $("#layer-supplier input").val("");
                    $('#supplierCancel').trigger("click");
                    $tableSupplier.bootstrapTable('refresh');
                });
            },
            // 关闭弹窗后执行
            end: function () {
                console.log("添加联系商窗口关闭...");
            },
            // 右上角关闭事件
            cancel: function () {
                //清空输入框
                $("#layer-supplier input").val("");
            }
        });
    });
});

//删除
$deleteSupplier.on('click', function () {
    var ids = getUtilSelections($tableSupplier);
    layui.use('layer', function () {
        layer.confirm('您是否要删除当前 ' + ids.length + '条数据？', {
            btn: ['是', '否']
        }, function () {
            console.log("打印删除数组" + ids[0].loginname);
            deleteItem(JSON.stringify({
            	//此处要修改
            	snumber: ids[0].snumber
            }), "/crmSys/supplier/delete", "POST");
                layer.msg('删除成功', {
                    icon: 1,
                    time: 800 //2秒关闭（如果不配置，默认是3秒）
                }, function () {
                });
            $tableSupplier.bootstrapTable('refresh');
        });
    })
});

// 编辑
$editSupplier.on('click', function () {
    var row = getUtilSelections($tableSupplier)[0];
    layui.use('layer', function () {
        var index = layer.open({
            type: 1,
            title: '编辑供应商',
            shadeClose: false,
            shade: 0,
            area: ['60%', '70%'],
            content: $('#layer-supplier'),
            success: function () {
                $('#layer-supplier').css("padding", "10px");
                $('#layer-supplier > .input-group').css("padding", "10px");

                if (row == undefined) {
                    layer.msg("未知错误", {
                        icon: 2,
                        time: 1000 // 1秒关闭（如果不配置，默认是3秒）
                    });
                    return;
                }
                $('#supplierName').val(row.sname);
                $('#supplierAddr').val(row.saddr);
                $('#supplierPhoneNumber').val(row.snumber);
                 $('#supplierPhoneNumber').attr("disabled", true);
                $(document).on('click', '#supplierCommit', function () {
                    // 修改事件
                    updateItem(JSON.stringify({
                        sname: $('#supplierName').val(),
                        saddr: $('#supplierAddr').val(),
                        snumber: $('#supplierPhoneNumber').val()
                    }), "/crmSys/supplier/update", "POST");
                    $tableSupplier.bootstrapTable('refresh');
                    layer.close(index);
                });
            },
            end: function () { // 最后执行reload
                 $('#supplierPhoneNumber').attr("disabled", false);
                $('#supplierName').val("");
                $('#supplierAddr').val("");
                $('#supplierPhoneNumber').val("");
            }
        });
    })
});

function addSupplier(dom1, dom2, dom3) {
    var str = {
        sname: $(dom1).val(),
        saddr: $(dom2).val(),
        snumber: $(dom3).val(),
    };
    var jsonStr = JSON.stringify(str);
    console.log("添加供应商: " + jsonStr);
    $.ajax({
        type: "POST",
        url: "/crmSys/supplier/add",
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