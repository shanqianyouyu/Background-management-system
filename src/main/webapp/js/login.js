window.onload = function() {
	$(function() {

		$('#email').blur(function() {
			var email = {
				email : $("#email").val()
			};
			var jsonStr = JSON.stringify(email);
			$.ajax({
				type : "POST",
				url : "/crmSys/ajax/email",
				contentType : "application/json",
				dataType : 'json',
				data : jsonStr,
				success : function(email) {
					// json对象转字符串
					console.log("邮箱格式正确" + JSON.stringify(email));
					$('#lab_email').empty();
					// 验证用户名是否存在
					$('#lab_email').text("邮箱可用: " + JSON.stringify(email));
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
					// alert("error");
					console.error(XMLHttpRequest);
					console.log("邮箱错误");
					$('#lab_email').empty();
					$('#lab_email').text("格式错误");
				}
			});

		});

		$('#password').blur(function() {
			var password = {
				password : $("#password").val()
			};
			var jsonStr = JSON.stringify(password);
			$.ajax({
				type : "POST",
				url : "/crmSys/ajax/password",
				contentType : "application/json",
				dataType : 'json',
				data : jsonStr,
				success : function(data) {
					console.log("密码格式正确: " + data.password);
					$('#lab_password').empty();
				},
				error : function(data) {
					console.log("密码格式错误");
					$('#lab_password').empty();
					$('#lab_password').text("密码格式错误");
				}
			});
		});

	});
};