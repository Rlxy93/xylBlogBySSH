$(function () {
    var loginUrl = 'admin/admin_login';
    $('#login').click(function () {
        var userCheck = {};
        userCheck.user = $('#user').val();
        userCheck.password = $('#password').val();
        var formData = new FormData();
        formData.append('userCheck', JSON.stringify(userCheck));
        $.ajax({
            url: loginUrl,
            type: 'POST',
            data: formData,
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if(data==false){
                    alert("登录失败！用户名或密码错误！");
                }else{
                    $.cookie("user", userCheck.user);
                    window.location="index.html";
                }
            }
        });
    });
});


$(function () {
    var loginUrl = 'admin/admin_login';
    $('.denglu').keyup(function () {

        if (event.keyCode == 13) {
            var userCheck = {};
            userCheck.user = $('#user').val();
            userCheck.password = $('#password').val();
            var formData = new FormData();
            formData.append('userCheck', JSON.stringify(userCheck));
            $.ajax({
                url: loginUrl,
                type: 'POST',
                data: formData,
                contentType: false,
                processData: false,
                cache: false,
                success: function (data) {
                    if(data==false){
                        alert("登录失败！用户名或密码错误！");
                    }else{
                        $.cookie("user", userCheck.user);
                        window.location="index.html";
                    }
                }
            });
        }
        ;
    });
});
