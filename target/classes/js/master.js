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
    console.dir("row: " + row);
    layui.use('layer', function () {
        var index = layer.open({
            type: 1,
            title: '查看用户',
            shadeClose: true,
            shade: 0.8,
            area: ['50%', '350px'],
            content: $('#layer-admin'),
            success: function () {
                console.log("查看...");
                $('#adminLoginname').val(row.loginname);
                $('#adminPassword').val(row.password);
                $('#adminName').val(row.name);
                $('#adminIdentity').val(row.identity);
                $('#adminPhoneNumber').val(row.phonenumber);

                $('#adminLoginname').attr("disabled", true);
                $('#adminPassword').attr("disabled", true);
                $('#adminName').attr("disabled", true);
                $('#adminIdentity').attr("disabled", true);
                $('#adminPhoneNumber').attr("disabled", true);
                
                $('#commit').css("display", "none");
                $('#cancel').css("display", "none");

                $('#layer-admin').css("padding", "10px");
                $('#layer-admin > .input-group').css("padding", "10px");

            },
            //关闭弹窗后执行
            end: function () {
            	$('#adminLoginname').attr("disabled", false);
                $('#adminPassword').attr("disabled", false);
                $('#adminName').attr("disabled", false);
                $('#adminIdentity').attr("disabled", false);
                $('#adminPhoneNumber').attr("disabled", false);
                
                $('#adminLoginname').val("");
                $('#adminPassword').val("");
                $('#adminName').val("");
                $('#adminIdentity').val("");
                $('#adminPhoneNumber').val("");
            	
                $('#commit').css("display", "inline-block");
                $('#cancel').css("display", "inline-block");
                console.log("查看用户...");
            },
            //右上角关闭事件
            cancel: function () {
                $(":input").val("");
            }
        });
    })
});

//编辑
$edit.on('click', function () {
    var row = getSelections()[0];

    layui.use('layer', function () {
        var index = layer.open({
            type: 1,
            title: '编辑商品',
            shadeClose: false,
            shade: 0.8,
            area: ['50%', '60%'],
            content: $('#layer-admin'),
            // content: 'edit.html?id=' + id + '&name=' + name + '&price=' + price,
            success: function () {
                $('#layer-admin').css("padding", "10px");
                $('#layer-admin > .input-group').css("padding", "10px");

                $('#adminLoginname').val(row.loginname);
                $('#adminPassword').val(row.password);
                $('#adminName').val(row.name);
                $('#adminIdentity').val(row.identity);
                $('#adminPhoneNumber').val(row.phonenumber);

                $('#adminLoginname').attr("disabled", true);

                $(document).on('click', '#commit', function () {
                    //修改事件
                    updateItem(JSON.stringify({
                            loginname: $('#adminLoginname').val(),
                            password: $('#adminPassword').val(),
                            name: $('#adminName').val(),
                            identity: $('#adminIdentity').val(),
                            phonenumber: $('#adminPhoneNumber').val()
                        }),
                        "/crmSys/admin/update", "POST"
                    );
//                    $('#refresh').trigger("click");
//                    $table.bootstrapTable('refresh');
                    layer.close(index);
                });

            },
            end: function () { //最后执行reload
            	$('#adminLoginname').attr("disabled", false);
            	$('#adminLoginname').val("");
                $('#adminPassword').val("");
                $('#adminName').val("");
                $('#adminIdentity').val("");
                $('#adminPhoneNumber').val("");
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
            console.log("打印删除数组" + ids[0].loginname);
            deleteItem(JSON.stringify({
                    loginname: ids[0].loginname
                }
            ), "/crmSys/admin/delete", "POST");
            console.log("before...");
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
            	 $('#layer-admin').css("padding", "10px");
                 $('#layer-admin > .input-group').css("padding", "10px");
                //显示结点
                $('#layer-admin').css("display", 'block');

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