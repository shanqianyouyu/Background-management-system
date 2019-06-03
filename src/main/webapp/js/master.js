window.onload = function () {
    $(function () {

    });

    $(window).resize(function () {
        // AdjustHeight();
        console.log("1");
    });


//admin查询
$('#adminQuery').click(function () {
    var page =0;
    if (page == 0) {
        page = 1;
    }
    var jsonStr = JSON.stringify({pages: page});
    $.ajax({
        type: "POST",
        url: "/crmSys/admin/admins",
        contentType: "application/json",
        dataType: 'json',
        data: jsonStr,
        success: function (data) {
            $('#info').empty();
            console.log("datarows: " + data.rows[0].name);
            var results = data.rows;

            for (var i = 0, size = results.length; i < size; i++) {
                if (data.rows[i].identity == 2) data.rows[i].identity = '普通用户';
                else data.rows[i].identity = '超级用户';
                var $div = '<tr><td><input type="checkbox" class="custom-control-input"></td><td>' + data.rows[i].loginname;
                $div += '</td><td>' + data.rows[i].password;
                $div += '</td><td>' + data.rows[i].name;
                $div += '</td><td>' + data.rows[i].identity;
                $div += '</td></tr>';
                console.log($div);
                $('#info').append($div);
                console.log("添加" + i);
            }
        },
        error: function () {
            console.log("error");
        }
    })
});
};