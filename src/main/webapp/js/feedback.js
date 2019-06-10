$.tabbleFeedback = {
    columns: feedbackcolumns,
    ajax: ajaxFeedback,
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
    toolbar: "#toolbarFeedback",
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
                '编号:  ' + row.pid,
                '产品问题:  ' + row.fitem,
                'cid:  ' + row.cid,
                'uid:  ' + row.uid,
                '服务日期:  ' + row.createtime,
                '服务信息:  ' + row.period].join(', ')
        }
    }
};

function ajaxFeedback(params) {
    $.ajax({
        url: "/crmSys/feedback/feedbacks",
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
var $tableFeedback = $("#tableFeedback"),
    $addFeedback = $("#addFeedback"),
    $editFeedback = $("#editFeedback"),
    $lookFeedback = $("#lookFeedback"),
    $deleteFeedback = $("#deleteFeedback");

// 按钮可用与否
$editFeedback.prop('disabled', true);
$lookFeedback.prop('disabled', true);
$deleteFeedback.prop('disabled', true);
$tableFeedback.on('check.bs.table uncheck.bs.table ' + 'check-all.bs.table uncheck-all.bs.table', function () {
    //选中的数量不为0并且数量为1
    var bool = !($tableFeedback.bootstrapTable('getSelections').length && $tableFeedback.bootstrapTable('getSelections').length == 1);
    $editFeedback.prop('disabled', bool);
    $lookFeedback.prop('disabled', bool);
    $deleteFeedback.prop('disabled', bool);
});

// 添加
layui.use("layer", function () {
    $addFeedback.on('click', function () {
    	$('#feedbackCommit').css("display","inline-block");
        var index = layer.open({
            type: 1,
            title: '添加投诉信息',
            shadeClose: false,
            shade: 0,
            scrollbar: false,
            isOutAnim: true,
            anim: 2,
            area: ['550px', '480px'],
            content: $('#layer-feedback'),
            success: function () {
                $('#layer-feedback').css("padding", "10px");
                $('#layer-feedback > .input-group').css("padding", "10px");
                // 显示结点
                $('#layer-feedback').css("display", 'block');

                // 窗口关闭事件
                $(document).on('click', '#feedbackCancel',
                    function () {
                        layer.close(index);
                    });

                //判断手机号
                // blurVerification("#supplierPhoneNumber");

                // 活动名字查重
                // $(document).on('blur', '#feedbackPid', function () {
                //     checkRepeat(
                //         JSON.stringify({
                //             pid: $('#feedbackPid').val().trim()
                //         }),
                //         "/crmSys/feedback/checkpid", 'POST', "编号");
                // });
                $("#layer-feedback input").val("");
                $('#feedbackCancel').trigger("click");
                $tableFeedback.bootstrapTable('refresh');
            },
            // 关闭弹窗后执行
            end: function () {
            	 
                console.log("添加联系商窗口关闭...");
                $('#feedbackCommit').css("display","none");
            },
            // 右上角关闭事件
            cancel: function () {
                //清空输入框
                $("#layer-feedback input").val("");
            }
        });
    });
});

//删除
$deleteFeedback.on('click', function () {
    var ids = getUtilSelections($tableFeedback);
    layui.use('layer', function () {
        layer.confirm('您是否要删除当前 ' + ids.length + '条数据？', {
            btn: ['是', '否']
        }, function () {
            // console.log("打印删除数组" + ids[0].pname);
            deleteItem(JSON.stringify({
            	createtime: ids[0].createtime
            }), "/crmSys/feedback/delete", "POST");
            layer.msg('删除成功', {
                icon: 1,
                time: 800 //2秒关闭（如果不配置，默认是3秒）
            }, function () {
            });
            $tableFeedback.bootstrapTable('refresh');
        });
    })
});

// 编辑
$editFeedback.on('click', function () {
    var row = getUtilSelections($tableFeedback)[0];
    $('#feedbackCommit2').css("display","inline-block");
    layui.use('layer', function () {
        var index = layer.open({
            type: 1,
            title: '编辑投诉信息',
            shadeClose: false,
            shade: 0.8,
            area: ['60%', '70%'],
            content: $('#layer-feedback'),
            success: function () {
                $('#layer-feedback').css("padding", "10px");
                $('#layer-feedback > .input-group').css("padding", "10px");

                if (row == undefined) {
                    layer.msg("未知错误", {
                        icon: 2,
                        time: 1000 // 1秒关闭（如果不配置，默认是3秒）
                    });
                    return;
                }

                $('#feedbackFitem').val(row.fitem);
                $('#feedbackCid').val(row.cid);
                $('#feedbackUid').val(row.uid);
                $('#feedbackPeriod').val(row.period);
                $('#feedbackCreatetime').val(row.createtime);
                $('#feedbackCreatetime').parent().css("display", "table");
                 $('#feedbackCreatetime').attr("disabled", true);
                 layer.close(index);

            },
            end: function () { // 最后执行reload
                $tableFeedback.bootstrapTable('refresh');
                $('#feedbackCreatetime').parent().css("display", "none");
                $('#feedbackCreatetime').attr("disabled", false);
                $('#feedbackFitem').val();
                $('#feedbackCid').val();
                $('#feedbackUid').val();
                $('#feedbackPeriod').val();
                $('#feedbackCommit2').css("display","none");
            }
        });
    })
});

/*
fitem   feedbackFitem
cid     feedbackCid
uid     feedbackUid
period  feedbackPeriod
*/

function addFeedback(dom1, dom2, dom3, dom4) {
    var str = {
        fitem: $(dom1).val(),
        cid: $(dom2).val(),
        uid: $(dom3).val(),
        period: $(dom4).val(),
    };
    var jsonStr = JSON.stringify(str);
    console.log("处理投诉信息: " + jsonStr);
    $.ajax({
        type: "POST",
        url: "/crmSys/feedback/add",
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

//提交事件
$(document).on('click', '#feedbackCommit', function () {
    if ($('#feedbackFitem').val().trim() == "") {
        layer.msg('产品问题不能为空', {icon: 2});
        return;
    }
    if ($('#feedbackCid').val().trim() == "") {
        layer.msg('cid不能为空', {icon: 2});
        return;
    }
    if ($('#feedbackUid').val().trim() == "") {
        layer.msg('uid不能为空', {icon: 2});
        return;
    }
    if ($('#feedbackPeriod').val().trim() == "") {
        layer.msg('服务信息不能为空', {icon: 2});
        return;
    }
    /*
    fitem   feedbackFitem
    cid     feedbackCid
    uid     feedbackUid
    period  feedbackPeriod
    */
    // 提交点击请求
    addFeedback('#feedbackFitem', '#feedbackCid', '#feedbackUid', '#feedbackPeriod');
});


//编辑提交
$(document).on('click', '#feedbackCommit2', function () {
    console.log("产品编辑提交...");
    console.log($('#feedbackFitem').val());
    console.log($('#feedbackCid').val());
    console.log($('#feedbackUid').val());

    // 修改事件
    updateItem(JSON.stringify({
        fitem: $('#feedbackFitem').val(),
        cid: $('#feedbackCid').val(),
        uid: $('#feedbackUid').val(),
        period: $('#feedbackPeriod').val(),
        createtime: $('#feedbackCreatetime').val()
    }), "/crmSys/feedback/update", "POST");
});