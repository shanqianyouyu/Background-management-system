window.onload = function () {
    $(function () {
        AdjustHeight();

    });

    $(window).resize(function () {
        AdjustHeight();
        console.log("1");
    });

    function AdjustHeight() {
        var head = $('.head').height();
        var content = document.documentElement.clientHeight;

        $('.leftNav').css("height", parseInt(content) - parseInt(head));
        $('.context').css("height", parseInt(content) - parseInt(head));
    }



//bootstrap-table
    $('#adminQuery').on('click', function () {
    })
};

//自定义ajax方法
function ajaxRequest(params) {
    //debugger;
    $.ajax({
        url: "/crmSys/admin/admins",
        type: "GET",
        dataType: "json",
        success: function (rs) {
            var message = rs.array;
            params.success({ //注意，必须返回参数 params
                total: rs.total,
                rows: message
            });

            //debugger;
        },
        error: function (rs) {
            console.log(rs)
        }
    });
}

var $table = $("#table"),
    $add = $("#add"),
    $edit = $("#edit"),
    $look = $("#look"),
    $delete = $("#delete"),
    $refresh = $("#refresh");
//按钮可用与否
$edit.prop('disabled', true);
$look.prop('disabled', true);
$delete.prop('disabled', true);
$table.on('check.bs.table uncheck.bs.table ' +
    'check-all.bs.table uncheck-all.bs.table',
    function () {
        var bool = !($table.bootstrapTable('getSelections').length && $table.bootstrapTable('getSelections').length == 1);
        $edit.prop('disabled', bool);
        $look.prop('disabled', bool);
        $delete.prop('disabled', bool);
    });

/**
 * 获得选中的数据，为一个对象数组
 */
function getSelections() {
    return $.map($table.bootstrapTable('getSelections'), function (row) {
        console.log("选中" + row);
        console.dir(row);
        return row;
    });
}

//刷新
$refresh.on('click', function () {
    $table.bootstrapTable('refresh');
});

//查看
$look.on('click', function () {
    var row = getSelections()[0];
    var id = row.id;
    var name = row.name;
    var price = row.price; //debugger;

    layui.use('layer', function () {
        layer.open({
            type: 2,
            title: '查看商品',
            shadeClose: false,
            shade: 0.8,
            area: ['50%', '60%'],
            content: 'edit.html?id=' + id + '&name=' + name + '&price=' + price + '&type=look'
        });
    })
});
//编辑
$edit.on('click', function () {
    var row = getSelections()[0];
    var id = row.id;
    var name = row.name;
    var price = row.price;

    layui.use('layer', function () {
        layer.open({
            type: 2,
            title: '编辑商品',
            shadeClose: false,
            shade: 0.8,
            area: ['50%', '60%'],
            content: 'edit.html?id=' + id + '&name=' + name + '&price=' + price,
            end: function () { //最后执行reload
                location.reload();
            }
        });
    })
});
//删除
$delete.on('click', function () {
    var ids = getSelections();
    layui.use('layer', function () {
        layer.confirm('您是否要删除当前 ' + ids.length + '条数据？', {
            btn: ['是', '否']
        }, function () {
            delServer(ids);
        });
    })
});

//删除
function delServer(ids) {
    layui.use('layer', function () {
        layer.msg('删除成功');
    })
}

//添加
layui.use("layer", function () {
    $add.on('click', function () {
        console.log("123");
        var index = layer.open({
            type: 1,
            title: '添加用户',
            shadeClose: false,
            shade: 0.8,
            scrollbar: false,
            isOutAnim: true,
            anim: 2,
            area: ['550px', '480px'],
            content: $('#layer-admin'),
            success: function () {
                //显示结点
                $('#layer-admin').css("display", 'block');
                //添加padding
                $('div').css("padding", '10px');

                // 窗口关闭事件
                $(document).on('click', '#cancel', function () {
                    layer.close(index);
                });
                //判断登录名
                blurVerification('#adminLoginname');
                //判断密码格式
                blurVerification('#adminPassword');
                //判断用户名格式
                blurVerification("#adminName");
                //判断admin电话
                blurVerification("#adminPhoneNumber");
                
              //登录名查重
                $(document).on('blur','#adminLoginname',function () {
                    console.log("blur...");
                    checkRepeat(JSON.stringify({
                        loginname: $('#adminLoginname').val().trim()
                    }),"/crmSys/admin/checkLoginName",'POST',"登录名");
                })

                //提交事件
                $(document).on('click', '#commit', function () {
                    // console.log("...");
                    $('#adminLoginname').trigger("blur");
                    if (usernamedRegular($('#adminLoginname').val()) !== true) {
                        console.error("登录名错误!");
                        return;
                    }
                    $('#adminPassword').trigger("blur");
                    if (passwordRegular($('#adminPassword').val()) !== true) {
                        console.error("密码格式错误!");
                        return;
                    }
                    $('#adminName').trigger("blur");
                    if (nameRegular($('#adminName').val()) !== true) {
                        console.error("姓名错误!");
                        return;
                    }
                    $('#adminPhoneNumber').trigger("blur");
                    if (phoneNumberRegular($('#adminPhoneNumber').val()) !== true) {
                        console.error("电话错误!");
                        return;
                    }
                    //提交点击请求
                    addAdmin('#adminLoginname', '#adminPassword', '#adminName', '#adminIdentity', "#adminPhoneNumber");
                    //清空所有input框
                    $(":input").val("");
                    $('#cancel').trigger("click");
                    $table.bootstrapTable('refresh');
                });
            },
            //关闭弹窗后执行
            end: function () {
                console.log("借书...");
            },
            //右上角关闭事件
            cancel: function () {
                $(":input").val("");
            }
        });
    });
});