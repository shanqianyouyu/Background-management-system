window.onload = function () {
     $(function(){
    	 
        $('#email').blur(function(){
        	alert("啊");
            $.ajax({
                type: "POST",
                url: "/crmSys/ajax/username",
                contentType:"application/json",
                data: {username:$("#email").val()},
                dataType: "json",
                success: function(name){
                	alert("success");
                    $('#lab_email').empty();   
                    //验证用户名是否存在
                    $('#lab_email').text("邮箱可用" + name);
                },
                error: function (data) {
                    alert("error");
                    $('#lab_email').empty();   
                    $('#lab_email').text("格式错误");
                }
            });

        });
        
        
     });
};