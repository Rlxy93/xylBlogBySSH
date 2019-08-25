function time1() {
    var time = document.getElementById("time1");
    var hour = new Date();
    var min = new Date();
    var sec = new Date();
    hour = hour.getHours();
    min = min.getMinutes();
    sec = sec.getSeconds();
    if (hour >= 6 && hour <= 12)
        time.innerHTML = "，早上好。";
    if (hour >= 12 && hour <= 14)
        time.innerHTML = "，中午好。";
    if (hour >= 14 && hour <= 18)
        time.innerHTML = "，下午好。";
    if (hour >= 18 && hour <= 20)
        time.innerHTML = "，傍晚好。";
    if (hour >= 20 && hour <= 24)
        time.innerHTML = "，晚上好。";
    if (hour >= 0 && hour <= 6)
        time.innerHTML = "，凌晨好。";
};

function bg1() {
    var bg1 = document.getElementById("bg1");
    bg1.style.backgroundColor = "white";
};

function bg11() {
    var bg1 = document.getElementById("bg1");
    bg1.style.backgroundColor = "silver";
};

function bg2() {
    var bg1 = document.getElementById("bg2");
    bg1.style.backgroundColor = "white";
};

function bg22() {
    var bg1 = document.getElementById("bg2");
    bg1.style.backgroundColor = "silver";
};

function bg3() {
    var bg1 = document.getElementById("bg3");
    bg1.style.backgroundColor = "white";
};

function bg33() {
    var bg1 = document.getElementById("bg3");
    bg1.style.backgroundColor = "silver";
};

function bg4() {
    var bg1 = document.getElementById("bg4");
    bg1.style.backgroundColor = "white";
};

function bg44() {
    var bg1 = document.getElementById("bg4");
    bg1.style.backgroundColor = "silver";
};

function fb1() {
    var word = document.getElementById('text1').value;
    var word1 = document.getElementById('Qing_input').value;
    if (word == '' && word1 == '') {
        alert("标题和内容不能为空！");
        return false;
    }
    if (word == '') {
        alert("标题不能为空！");
        return false;
    }
    if (word1 == '') {
        alert("内容不能为空！");
        return false;
    }
};

function mm1() {
    var mm = document.getElementById('yzmm');
    if (mm.style.display == "none")
        mm.style.display = "block";
    else
        mm.style.display = "none";
};

$(function () {
    var userUUID = $.cookie('user');
    $('#user').text(userUUID);
});

$(function () {
    $('#exit').click(function () {
        $.removeCookie('user');
        top.location.href = "./login.html";
    });
});

$(function () {
    var getAdminUrl = 'admin/admin_getAdminInfo';
    $.ajax({
        url: getAdminUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data == "") {
                alert("获取管理员信息失败！");
            } else {
                var admin = JSON.parse(data);
                $('#user').val(admin.user);
                $('#id').val(admin.id);
            }
        }
    });
});

$(function () {
    var getCategoryListUrl = 'admin/admin_getCategoryList';
    $.ajax({
        url: getCategoryListUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data == "") {
                alert("获取分类列表失败！");
            } else {
                var categoryList = JSON.parse(data);
                $(document).ready(function () {
                    var s = "";
                    for (var i = 0; i < categoryList.length; i++) {
                        s += "<option>" + categoryList[i].category + "</option>";
                    }
                    $("#category").append(s);
                });
            }
        }
    });
});

$(function () {
    $('#add').click(function () {
        var addBlogUrl = 'admin/admin_addBlog';
        var blog = {};
        blog.title = $('#title').val();
        // var content = ue.getContent();
        // blog.body = content;
        blog.body = $('#body').val();
        blog.category = $('#category  option:selected').text();
        if ($('#mm:checked')) {
            blog.yzmm = $('#password').val();
        }
        var formData = new FormData();
        formData.append('blog', JSON.stringify(blog));
        $.ajax({
            url: addBlogUrl,
            type: 'POST',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (data) {
                if (data == null) {
                    alert("添加博客失败！");
                } else {
                    alert("添加博客成功！");
                    window.location = "./blogManager.html";
                }
            }
        });
    });
});

$(function () {
    $('#editAdmin').click(function () {
        var editAdminUrl = 'admin/admin_editAdmin';
        var admin = {};
        admin.user = $('#user').val();
        admin.id = $('#id').val();
        admin.password = $('#newPassword').val();
        if (!$('#newPassword').val() == $('#comfirmPassword').val()) {
            return;
        }
        var formData = new FormData();
        formData.append('admin', JSON.stringify(admin));
        $.ajax({
            url: editAdminUrl,
            type: 'POST',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (data) {
                if (data == null) {
                    alert("修改管理员信息失败！");
                } else {
                    alert("修改管理员信息成功！");
                    $.removeCookie('user');
                    top.location.href = "./login.html";
                }
            }
        });
    });
});

$(function () {
    $('#edit').click(function () {
        var editAdminUrl = 'admin/admin_editBlog';
        var blog = {};
        blog.title = $('#title').val();
        // var content = ue.getContent();
        // blog.body = content;
        blog.body = $('#body').val();
        blog.id = $('#blogId').val();
        blog.category = $('#category  option:selected').text();
        if ($('#mm:checked')) {
            blog.yzmm = $('#password').val();
        }
        var formData = new FormData();
        formData.append('blog', JSON.stringify(blog));
        $.ajax({
            url: editAdminUrl,
            type: 'POST',
            contentType: false,
            processData: false,
            cache: false,
            data: formData,
            success: function (data) {
                if (data == null) {
                    alert("修改博客失败！");
                } else {
                    alert("修改博客成功！");
                    top.location.href = "/xylBlogBySSH";
                }
            }
        });
    });
});

$(function () {
    var currentUrl = window.location.href.toString();
    var reg = RegExp(/editBlog.html/);
    var Url = currentUrl.split("?");
    var para = Url[1];
    if (reg.test(currentUrl)) {
        var editBlogUrl = 'admin/admin_getEditBlogInfo?' + para;
        $.ajax({
            url: editBlogUrl,
            type: 'POST',
            contentType: false,
            processData: false,
            cache: false,
            success: function (data) {
                if (data != "") {
                    var blogInfo = JSON.parse(data);
                    $('#title').val(blogInfo.title);
                    $('#body').val(blogInfo.body);
                    $('#oldCategory').val(blogInfo.category);
                    $('#blogId').val(blogInfo.id);
                    $("#category").find("option:contains(" + blogInfo.category + ")").attr("selected", true);
                    if (blogInfo.mm == "on") {
                        $('#mm').attr("checked", "checked");
                        $('#yzmm').css("display", "block");
                        $('#password').val(blogInfo.yzmm);
                        $('#password').attr("type", "text");
                    }
                } else {
                    alert("获取博客详情失败！");
                }
            }
        });
    }
});