window.onload = function () {
    $(function () {
        var emailStatus = false;
        var passwordStatus = false;
        $('#email').blur(function () {

            var text = $("#email").val().trim().replace(/\s/g, "");
            console.log(text);
            //判空
            if (text == "") {
                $('#lab_email').empty();
                $('#lab_email').text("邮箱不能为空!");
                emailStatus = false;
                return false;
            }

            //验证邮箱格式
            if (!text.match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
                $('#lab_email').empty();
                $('#lab_email').text("邮箱格式错误!");
                emailStatus = false;
                return false;
            }
            console.log("格式正确");
            $('#lab_email').empty();

        });

        $('#password').blur(function () {

            var text = $("#password").val().trim().replace(/\s/g, "");
            console.log(text);
            //判空
            if (text == "") {
                $('#lab_password').empty();
                $('#lab_password').text("密码不能为空!");
                passwordStatus = false;
                return false;
            }
            //密码
            if (text.length > 17) {
                $('#lab_password').empty();
                $('#lab_password').text("密码不能超过16位!");
                passwordStatus = false;
                return false;
            }

            console.log("密码格式正确!");
            $('#lab_password').empty();
        });
        $('#sign').click(function () {
            console.log("点击");
            
            var email = $('#email').val().trim().replace(/\s/g, "");
            var password = $('#password').val().trim().replace(/\s/g, "");
            var form = {
                Cemail: email,
                Cnumber: password
            };
            var jsonStr = JSON.stringify(form);
            console.log("jsonStr"+ jsonStr);
            $.ajax({
                type: "POST",
                url: "/crmSys/admin/login",
                contentType: "application/json",
                dataType: 'json',
                data: jsonStr,
                success: function (obj) {
                	if(obj.status == "1"){
                		$('#lab_password').empty();
                        $('#lab_password').text("密码正确!");
                		window.location.href="/crmSys/admin/success";
                	}else{
                		 $('#lab_password').empty();
                         $('#lab_password').text("密码错误!");
                	}
                	
                },
                error: function (XMLHttpRequest,XMLHttpResponse, textStatus, errorThrown) {
                	console.log("1 异步调用返回失败,XMLHttpResponse.readyState:"+XMLHttpRequest.readyState);
                    console.log("2 异步调用返回失败,XMLHttpResponse.status:"+XMLHttpRequest.status);
                    console.log("3 异步调用返回失败,textStatus:"+textStatus);
                    console.log("4 异步调用返回失败,errorThrown:"+errorThrown);
                    window.location.href="/crmSys/admin/error";
//                    alert("登陆失败!");
                }
            });
        });

    });
};