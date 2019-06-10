$.tabbleActivity = {
    columns: activitycolumns,
    showPaginationSwitch: true,
    ajax: ajaxActivity,
    method: 'GET',
    sidePagination: 'client',
    search: true,
    searchOnEnterKey: false,
    pagination: true,
    pageNumber: 1,
    pageSize: 10,
    striped: true,
    pageList: "[10, 20]",
    showRefresh: true,
    toolbar: "#toolbarActivity",
    showToggle: true,                    //是否显示详细视图和列表视图
    iconSize: 'outline',
    paginationPreText: "<<",
    paginationNextText: ">>",
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
                '活动:  ' + row.aitem,
                '活动细则:  ' + row.adetail,
                '活动日期:  ' + row.createdate,
                'Uid:  ' + row.uid,
                '参加人员:  ' + row.cus].join(', ')
        }
    }
};

function ajaxActivity(params) {
    $.ajax({
        url: "/crmSys/activity/activitys",
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
var $tableActivity = $("#tableActivity"),
    $addActivity = $("#addActivity"),
    $editActivity = $("#editActivity"),
    $lookActivity = $("#lookActivity"),
    $deleteActivity = $("#deleteActivity");

// 按钮可用与否
$editActivity.prop('disabled', true);
$lookActivity.prop('disabled', true);
$deleteActivity.prop('disabled', true);
$tableActivity.on('check.bs.table uncheck.bs.table ' + 'check-all.bs.table uncheck-all.bs.table', function () {
    //选中的数量不为0并且数量为1
    var bool = !($tableActivity.bootstrapTable('getSelections').length && $tableActivity.bootstrapTable('getSelections').length == 1);
    $editActivity.prop('disabled', bool);
    $lookActivity.prop('disabled', bool);
    $deleteActivity.prop('disabled', bool);
});

// 添加
layui.use("layer", function () {
    $addActivity.on('click', function () {
        var index = layer.open({
            type: 1,
            title: '添加活动',
            shadeClose: false,
            shade: 0,
            scrollbar: false,
            isOutAnim: true,
            anim: 2,
            area: ['550px', '480px'],
            content: $('#layer-actvity'),
            success: function () {
                $('#layer-actvity').css("padding", "10px");
                $('#layer-actvity > .input-group').css("padding", "10px");
                // 显示结点
                $('#layer-actvity').css("display", 'block');

                // 窗口关闭事件
                $(document).on('click', '#activityCancel',
                    function () {
                        layer.close(index);
                    });

                //判断手机号
                // blurVerification("#supplierPhoneNumber");

                // 活动名字查重
                $(document).on('blur', '#activityAitem', function () {
                    checkRepeat(
                        JSON.stringify({
                            aitem: $('#activityAitem').val().trim()
                        }),
                        "/crmSys/activity/checkaitem", 'POST', "活动名");
                });

                // 提交事件
                $(document).on('click', '#activityCommit', function () {
                    if ($('#activityAitem').val().trim() == "") {
                        layer.msg('活动名不能为空', {icon: 2});
                        return;
                    }
                    if ($('#activityAdetail').val().trim() == "") {
                        layer.msg('活动细则不能为空', {icon: 2});
                        return;
                    }
                    if ($('#activityUid').val().trim() == "") {
                        layer.msg('uid不能为空', {icon: 2});
                        return;
                    }

                    /*
                    aitem   activityAitem
                    adetail activityAdetail
                    uid     activityUid
                    cus     activityCus
                    */
                    // 提交点击请求
                    addActivity('#activityAitem', '#activityAdetail', '#activityUid', '#activityCus');

                    // 清空所有input框
                    $("#layer-actvity input").val("");
                    $('#activityCancel').trigger("click");
                    $tableActivity.bootstrapTable('refresh');
                });
            },
            // 关闭弹窗后执行
            end: function () {
                console.log("添加联系商窗口关闭...");
            },
            // 右上角关闭事件
            cancel: function () {
                //清空输入框
                $("#layer-actvity input").val("");
            }
        });
    });
});

//删除
$deleteActivity.on('click', function () {
    var ids = getUtilSelections($tableActivity);
    layui.use('layer', function () {
        layer.confirm('您是否要删除当前 ' + ids.length + '条数据？', {
            btn: ['是', '否']
        }, function () {
            // console.log("打印删除数组" + ids[0].pname);
            deleteItem(JSON.stringify({
                aitem: ids[0].aitem
            }), "/crmSys/activity/delete", "POST");
            layer.msg('删除成功', {
                icon: 1,
                time: 800 //2秒关闭（如果不配置，默认是3秒）
            }, function () {
            });
            $tableActivity.bootstrapTable('refresh');
        });
    })
});

// 编辑
$editActivity.on('click', function () {
    var row = getUtilSelections($tableActivity)[0];

    layui.use('layer', function () {
        var index = layer.open({
            type: 1,
            title: '编辑客户',
            shadeClose: false,
            shade: 0.8,
            area: ['60%', '70%'],
            content: $('#layer-actvity'),
            success: function () {
                $('#layer-actvity').css("padding", "10px");
                $('#layer-actvity > .input-group').css("padding", "10px");

                if (row == undefined) {
                    layer.msg("未知错误", {
                        icon: 2,
                        time: 1000 // 1秒关闭（如果不配置，默认是3秒）
                    });
                    return;
                }
                $('#activityAitem').val(row.aitem);
                $('#activityAdetail').val(row.adetail);
                $('#activityUid').val(row.uid);
                $('#activityCus').val(row.cus);


                $('#activityAitem').attr("disabled", true);

                $(document).on('click', '#activityCommit', function () {
                    console.log("产品编辑提交...");
                    console.log($('#activityAdetail').val());
                    console.log($('#activityUid').val());
                    console.log($('#activityCus').val());
                    
                    // 修改事件
                    updateItem(JSON.stringify({
                    	aitem: $('#activityAitem').val(),
                        adetail: $('#activityAdetail').val(),
                        uid: $('#activityUid').val(),
                        cus: $('#activityCus').val()
                    }), "/crmSys/activity/update", "POST");
                    
                    layer.close(index);
                });
            },
            end: function () { // 最后执行reload
            	$tableActivity.bootstrapTable('refresh');
                $('#activityAitem').attr("disabled", false);
                $('#activityAitem').val();
                $('#activityAdetail').val();
                $('#activityUid').val();
                $('#activityCus').val();
            }
        });
    })
});

/*
aitem   activityAitem
adetail activityAdetail
uid     activityUid
cus     activityCus
*/

function addActivity(dom1, dom2, dom3, dom4) {
    var str = {
        aitem: $(dom1).val(),
        adetail: $(dom2).val(),
        uid: $(dom3).val(),
        cus: $(dom4).val(),
    };
    var jsonStr = JSON.stringify(str);
    console.log("添加活动信息: " + jsonStr);
    $.ajax({
        type: "POST",
        url: "/crmSys/activity/add",
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

