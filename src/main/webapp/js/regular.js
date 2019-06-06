//密码正则
function passwordRegular(password) {
    if (password.trim() == "") {
        return "密码不能为空!";
    }
    if (!password.trim().match(/^[a-z0-9_-]{6,18}$/)) {
        return "密码格式错误";
    }
    return true;
}

//用户名正则
function usernamedRegular(username) {
    if (username.trim() == "") {
        return "用户名不能为空";
    }
    if (!username.trim().match(/^[a-z0-9_-]{3,16}$/)) {
        return "用户名格式错误";
    }
    return true;
}

//邮箱验证
function emailRegular(email) {
    if (email.trim() == "") {
        return "邮箱不能为空";
    }
    if (!email.trim().match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
        return "邮箱格式错误";
    }
    return true;

}

//中文姓名验证
function nameRegular(name) {
    if (name.trim() == "") {
        return "姓名不能为空";
    }
    if (!name.trim().match(/^([a-zA-Z0-9\u4e00-\u9fa5\·]{1,10})$/)) {
        return "姓名格式错误";
    }
    return true;
}

//电话正则
function phoneNumberRegular(number) {
    if (number.trim() == "") {
        return "电话不能为空";
    }
    if (!(/^1(3|4|5|6|7|8|9)\d{9}$/.test(number.trim()))) {
        return "电话格式错误";
    }
    return true;
}

//
function blurVerification(dom) {
    $(document).on('blur', dom, function () {
        var data = $(dom).val();
        var msg;
        if (dom.toLowerCase().indexOf("password") >= 0) {
            msg = passwordRegular(data);
        } else if (dom.toLowerCase().indexOf("loginname") >= 0) {
            console.log("login...");
            msg = usernamedRegular(data);
        }else if(dom.toLowerCase().indexOf("phonenumber") >= 0){
            msg = phoneNumberRegular(data);
        }  else if (dom.toLowerCase().indexOf("name") >= 0) {
            msg = nameRegular(data);
        } else if (dom.toLowerCase().indexOf("email") >= 0) {
            msg = emailRegular(data);
        }
        if (msg == true) {
            return true;
        }
        layer.msg(msg, {
            icon: 2,
            time: 1000 //1秒关闭（如果不配置，默认是3秒）
        });
        return false;
    });
}