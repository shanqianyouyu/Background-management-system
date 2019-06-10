window.onload = function () {
    $(function () {
        var emailStatus = false;
        var passwordStatus = false;
        $('#loginname').blur(function () {

            var text = $("#loginname").val().trim().replace(/\s/g, "");
            console.log(text);
            //判空
            if (text == "") {
                $('#lab_email').empty();
                $('#lab_email').text("用户名不能为空!");
                emailStatus = false;
                return false;
            }

            //验证用户名格式
            if (!text.match(/^[a-zA-Z0-9_-]{3,16}$/)) {
                $('#lab_email').empty();
                $('#lab_email').text("用户名格式错误!");
                emailStatus = false;
                return false;
            }
            console.log("用户名格式正确");
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
            
            var loginname = $('#loginname').val().trim().replace(/\s/g, "");
            var password = $('#password').val().trim().replace(/\s/g, "");
            var form = {
                loginname: loginname,
                password: password
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
                }
            });
        });

    });
    $('#toCheck').click(function(){
    	console.log('click...');
    	$('#login').hide(100);
    	
    	setTimeout(function(){
    		$('#verificationCode').css("display","block");
    		$('#verificationCode').show(500);
    		
    	},500); 
    	return false;
    });
    
    $('#toLogin').click(function(){
    	$('#verificationCode').toggle(100);
    	setTimeout(function(){
    	$('#login').css("display","block");
    	$('#login').show(500);
    	},500); 
    });
    
    //用户名验证
    $('#verificationLogin').blur(function () {
    	
        var text = $("#verificationLogin").val().trim().replace(/\s/g, "");
        console.log(text);
        //判空
        if (text == "") {
            $('#lab_verificationloginname').empty();
            $('#lab_verificationloginname').text("用户名不能为空!");
            return false;
        }

        //用户名格式
        if (!text.match(/^[a-zA-Z0-9_-]{3,16}$/)) {
            $('#lab_verificationloginname').empty();
            $('#lab_verificationloginname').text("用户名格式错误!");
            emailStatus = false;
            return false;
        }
        console.log("用户名格式正确");
        $('#lab_verificationloginname').empty();

    });
    
    
    
    $('#getCode').click(function(){
    	$.ajax({
    		type: "POST",
            url: "/crmSys/admin/getcode",
            contentType: "application/json",
            dataType: 'json',
            data: JSON.stringify({
            	loginname: $('#verificationLogin').val(),
            	phonenumber: $('#verificationEmail').val()
//            	code: $('#code').val()
            }),
            success: function (obj) {
            	if(obj.status == "true"){
            		console.log("验证码获取成功");
            	}else{
            		alert("验证码获取失败");
            	}
            },
            error: function (XMLHttpRequest,XMLHttpResponse, textStatus, errorThrown) {
            	console.log("1 异步调用返回失败,XMLHttpResponse.readyState:"+XMLHttpRequest.readyState);
                console.log("2 异步调用返回失败,XMLHttpResponse.status:"+XMLHttpRequest.status);
                console.log("3 异步调用返回失败,textStatus:"+textStatus);
                console.log("4 异步调用返回失败,errorThrown:"+errorThrown);
                window.location.href="/crmSys/admin/error";
            }
    	});
    });
    
    $('#verificationEmail').blur(function(){
    	var text = $('#verificationEmail').val().trim();
    	$('#lab_verificationEmail').empty();
    	if(text=="") {
    		$('#lab_verificationEmail').text("邮箱不能为空");
    	}
    });
    
    $('#submitCode').click(function(){
    	$.ajax({
    		type: "POST",
    		url: "/crmSys/admin/verificationCode",
    		contentType: "application/json",
    		dataType: 'json',
    		data: JSON.stringify({
    			loginname: $('#verificationLogin').val(),
    			phonenumber: $('#verificationEmail').val(),
            	code: $('#code').val()
    		}),
    		success: function (obj) {
    			if(obj.status == "true"){
    				console.log("密码修改成功");
    				alert(obj.msg);
    			}else{
    				alert("密码修改失败");
    			}
    			alert(obj.msg);
    		},
    		error: function (XMLHttpRequest,XMLHttpResponse, textStatus, errorThrown) {
    			console.log("1 异步调用返回失败,XMLHttpResponse.readyState:"+XMLHttpRequest.readyState);
    			console.log("2 异步调用返回失败,XMLHttpResponse.status:"+XMLHttpRequest.status);
    			console.log("3 异步调用返回失败,textStatus:"+textStatus);
    			console.log("4 异步调用返回失败,errorThrown:"+errorThrown);
    			window.location.href="/crmSys/admin/error";
    		}
    	});
    });
    
    
};