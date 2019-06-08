// var $table = $("#adminTable"),
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


// 编辑
$editCustomer.on('click', function () {
    var row = getSelections()[0];

    layui.use('layer', function () {
        var index = layer.open({
            type: 1,
            title: '编辑商品',
            shadeClose: false,
            shade: 0.8,
            area: ['60%', '70%'],
            content: $('#layer-customer'),
            success: function () {
                $('#layer-customer').css("padding", "10px");
                $('#layer-customer > .input-group').css("padding", "10px");

                if (row == undefined) {
                    layer.msg("未知错误", {
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


                // $('#customerName').attr("disabled", true);

                $(document).on('click', '#customerCommit', function () {
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
                    layer.close(index);
                });
            },
            end: function () { // 最后执行reload
                // $('#customerName').attr("disabled", false);
                $('#customerName').val("");
                $('#customerPhoneNumber').val("");
                $('#customerAddr').val("");
                $('#customerCreateDate').val("");
                $('#customerEmail').val("");
                $('#customerRank').val("");
            }
        });
    })
});

