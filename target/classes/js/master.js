window.onload = function () {
    $(function () {
        var adminQuery = 0;
        //用户查询
        $('#adminQuery').click(function () {
            if (adminQuery == 0) {
                adminQuery = 1;
            }
            console.log("click");
            $.ajax({
                type: "POST",
                url: "crmSys/admin/admins",
                contentType: "application/json",
                dataType: 'json',
                data: adminQuery,
                success: function (data) {
                    console.log(JSON.stringify(data));
                }
            })

        });
    });
};