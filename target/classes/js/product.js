$.tableProduct= {
    columns: productcolumns,
    ajax: ajaxProduct,
    method: 'GET',
    sidePagination: 'client',
    search: true,
    searchOnEnterKey: false,
    pagination: true,
    pageNumber: 1,
    pageSize: 10,
    showPaginationSwitch: true,
    striped: true,
    pageList: "[10, 20]",
    showRefresh: true,
    toolbar: "#toolbarProduct",
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
                '产品编号:  ' + row.pnum,
                '产品名字:  ' + row.pname,
                '供应商姓名:  ' + row.sid,
                '进价:  ' + row.pprice,
                '出售日期:  ' + row.createdate,
                '零售价:  ' + row.pnumber].join(', ')
        }
    }
};

function ajaxProduct(params) {
    $.ajax({
        url: "/crmSys/product/products",
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
var $tableProduct = $("#tableProduct"),
    $addProduct = $("#addProduct"),
    $editProduct = $("#editProduct"),
    $lookProduct = $("#lookProduct"),
    $deleteProduct = $("#deleteProduct");

// 按钮可用与否
$editProduct.prop('disabled', true);
$lookProduct.prop('disabled', true);
$deleteProduct.prop('disabled', true);
$tableProduct.on('check.bs.table uncheck.bs.table ' + 'check-all.bs.table uncheck-all.bs.table', function () {
    //选中的数量不为0并且数量为1
    var bool = !($tableProduct.bootstrapTable('getSelections').length && $tableProduct.bootstrapTable('getSelections').length == 1);
    $editProduct.prop('disabled', bool);
    $lookProduct.prop('disabled', bool);
    $deleteProduct.prop('disabled', bool);
});

// 添加
layui.use("layer", function () {
    $addProduct.on('click', function () {
        var index = layer.open({
            type: 1,
            title: '添加产品',
            shadeClose: false,
            shade: 0,
            scrollbar: false,
            isOutAnim: true,
            anim: 2,
            area: ['550px', '480px'],
            content: $('#layer-product'),
            success: function () {
                $('#layer-product').css("padding", "10px");
                $('#layer-product > .input-group').css("padding", "10px");
                // 显示结点
                $('#layer-product').css("display", 'block');

                // 窗口关闭事件
                $(document).on('click', '#productCancel',
                    function () {
                        layer.close(index);
                    });

                //判断手机号
                // blurVerification("#supplierPhoneNumber");

                // // 客户邮箱查重
                $(document).on('blur', '#productPname', function () {
                    checkRepeat(
                        JSON.stringify({
                            pname: $('#productPname').val().trim()
                        }),
                        "/crmSys/product/checkname", 'POST', "产品名字");
                });

                // 提交事件
                $(document).on('click', '#productCommit', function () {
                    if ($('#productPname').val().trim() == "") {
                        layer.msg('产品名不能为空', {icon: 2});
                        return;
                    }
                    if ($('#productId').val().trim() == "") {
                        layer.msg('供应商名不能为空', {icon: 2});
                        return;
                    }
                    if ($('#productPrice').val().trim() == "") {
                        layer.msg('售价不能为空', {icon: 2});
                        return;
                    }

                    /*
                      pname: $(dom1).val(),
                      sid: $(dom2).val(),
                      pprice: $(dom3).val(),
                    */
                    // 提交点击请求
                    addProduct('#productPname', '#productId', '#productPrice');

                    // 清空所有input框
                    $("#layer-product input").val("");
                    $('#supplierCancel').trigger("click");
                    $tableProduct.bootstrapTable('refresh');
                });
            },
            // 关闭弹窗后执行
            end: function () {
                console.log("添加联系商窗口关闭...");
            },
            // 右上角关闭事件
            cancel: function () {
                //清空输入框
                $("#layer-product input").val("");
            }
        });
    });
});

//删除
$deleteProduct.on('click', function () {
    var ids = getUtilSelections($tableProduct);
    layui.use('layer', function () {
        layer.confirm('您是否要删除当前 ' + ids.length + '条数据？', {
            btn: ['是', '否']
        }, function () {
            console.log("打印删除数组" + ids[0].pname);
            deleteItem(JSON.stringify({
                pname: ids[0].pname
            }), "/crmSys/product/delete", "POST");
            layer.msg('删除成功', {
                icon: 1,
                time: 800 //2秒关闭（如果不配置，默认是3秒）
            }, function () {
            });
            $tableProduct.bootstrapTable('refresh');
        });
    })
});

// 编辑
$editProduct.on('click', function () {
    var row = getUtilSelections($tableProduct)[0];

    layui.use('layer', function () {
        var index = layer.open({
            type: 1,
            title: '编辑客户',
            shadeClose: false,
            shade: 0.8,
            area: ['60%', '70%'],
            content: $('#layer-product'),
            success: function () {
                $('#layer-product').css("padding", "10px");
                $('#layer-product > .input-group').css("padding", "10px");

                if (row == undefined) {
                    layer.msg("未知错误", {
                        icon: 2,
                        time: 1000 // 1秒关闭（如果不配置，默认是3秒）
                    });
                    return;
                }
                $('#productPname').val(row.pname);
                $('#productId').val(row.sid);
                $('#productPrice').val(row.pprice);


                 $('#productPname').attr("disabled", true);

                $(document).on('click', '#productCommit', function () {
                	console.log("产品编辑提交...");
                    // 修改事件
                    updateItem(JSON.stringify({
                        pname: $('#productPname').val(),
                        sid: $('#productId').val(),
                        pprice: $('#productPrice').val()
                    }), "/crmSys/product/update", "POST");
                    $tableProduct.bootstrapTable('refresh');
                    layer.close(index);
                });
            },
            end: function () { // 最后执行reload
                 $('#productPname').attr("disabled", false);
                $('#productPname').val("");
                $('#productId').val("");
                $('#productPrice').val("");
            }
        });
    })
});

/*
 pname: $(dom1).val(),
 sid: $(dom2).val(),
 pprice: $(dom3).val(),
 */

function addProduct(dom1, dom2, dom3) {
    var str = {
        pname: $(dom1).val(),
        sid: $(dom2).val(),
        pprice: $(dom3).val(),
    };
    var jsonStr = JSON.stringify(str);
    console.log("添加产品: " + jsonStr);
    $.ajax({
        type: "POST",
        url: "/crmSys/product/add",
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
