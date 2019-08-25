$(function () {
    var getSettingUrl = 'admin/setting_getSetting';
    $.ajax({
        url: getSettingUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data!="") {
                var setting = JSON.parse(data);
                $('#mainblog_name').val(setting.mainblogName);
                $('#blog_name').val(setting.blogName);
                $('#index').val(setting.index1);
                $('#beian').val(setting.beian);
                $('#admin').val(setting.admin);
                $('#qq').val(setting.qq);
            } else {
                alert("获取配置信息失败！");
                window.location.href = './login.html';
            }
        }
    });
});

$(function () {
    $('#edit').click(function () {
        var editSettingUrl = 'admin/setting_editSetting';
        var setting = {};
        setting.mainblogName = $('#mainblog_name').val();
        setting.blogName = $('#blog_name').val();
        setting.index1 = $('#index').val();
        setting.beian = $('#beian').val();
        setting.admin = $('#admin').val();
        setting.qq = $('#qq').val();
        var formData = new FormData();
        formData.append('setting', JSON.stringify(setting));
        $.ajax({
            url: editSettingUrl,
            type: 'POST',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (data) {
                if (data!=false) {
                    alert("修改配置信息成功！");
                    top.location.href="../";
                } else {
                    alert("修改配置信息失败！");
                }
            }
        });
    });
});