var setting = "";
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
                setting = JSON.parse(data);
                document.title = setting.mainblogName + "-" + setting.blogName;
                $('#mainblogName').text(setting.mainblogName);
                $('#mainblogName').attr("href", setting.index1);
                $('#chat').attr("href", "http://wpa.qq.com/msgrd?v=3&amp;uin=" + setting.qq + "&amp;site=qq&amp;menu=yes");
                $('#blogName').text(setting.blogName);
                $('#beian').text(setting.beian);
            } else {
                alert("获取配置信息失败！");
            }
        }
    });
});

$(function () {
    var getCategoryListUrl = 'index_getAllCategory';
    $.ajax({
        url: getCategoryListUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data!="") {
                var categoryList = JSON.parse(data);
                $(document).ready(function () {
                    var s = "";
                    for (var i = 0; i < categoryList.length; i++) {
                        s += "<li><a href=\"category.html?id=" + categoryList[i].category + "\">" + categoryList[i].category + "(" + categoryList[i].count + ")" + "</a></li>";
                    }
                    $("#categoryList").append(s);
                });
            } else {
                alert("获取分类列表失败！");
            }
        }
    });
});

$(function () {
    var getCommentListUrl = 'index_getAllComment';
    $.ajax({
        url: getCommentListUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data!="") {
                var commentList = JSON.parse(data);
                $(document).ready(function () {
                    var s = "";
                    for (var i = 0; i < commentList.length; i++) {
                        s += "<li><a href=\"content.html?id=" + commentList[i].id + "\">" + commentList[i].comment + "</a></li>";
                    }
                    $("#commentList").append(s);
                });
            } else {
                alert("获取评论列表失败！");
            }
        }
    });
});

$(function () {
    var getBlogListUrl = 'index_getAllBlog';
    $.ajax({
        url: getBlogListUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data!="") {
                var blogList = JSON.parse(data);
                $(document).ready(function () {
                    var s = "";
                    for (var i = 0; i < blogList.length; i++) {
                        if (blogList[i].mm == "on") {
                            s += "\n" +
                                "        <div id=\"animated_div\" style=\"border:1px solid silver;\">\n" +
                                "            <br>\n" +
                                "            <img src='resources/images/lock.png' style='width:20px;' title='已锁定'>\n" +
                                "            <a style=\"font-size:24px;\" href=\"content.html?id=" + blogList[i].id + "\">" + blogList[i].title + "</a><br>\n" +
                                "            <img src='resources/images/clock.png' style='width:20px;' title='发表时间'>\n" +
                                "            <span style=\"font-size:18px;\">" + blogList[i].time + " &nbsp;\n" +
                                "\t\t<img src='resources/images/male.png' style='width:20px;' title='作者'>" + setting.admin + "</span>\n" +
                                "            <hr>\n" +
                                "            <div style='width:70%;margin:0 auto;font-size:20px;'>\n" +
                                "                该博客已加密！\n" +
                                "            </div>\n" +
                                "        </div>";
                        } else {
                            s += "\n" +
                                "        <div id=\"animated_div\" style=\"border:1px solid silver;\">\n" +
                                "            <br>\n" +
                                "            <a style=\"font-size:24px;\" href=\"content.html?id=" + blogList[i].id + "\">" + blogList[i].title + "</a><br>\n" +
                                "            <img src='resources/images/clock.png' style='width:20px;' title='发表时间'>\n" +
                                "            <span style=\"font-size:18px;\">" + blogList[i].time + " &nbsp;\n" +
                                "\t\t<img src='resources/images/male.png' style='width:20px;' title='作者'>" + setting.admin + "</span>\n" +
                                "            <hr>\n" +
                                "            " + blogList[i].body + "...\n" +
                                "            <br><a style='color:black;' href=\"content.html?id=" + blogList[i].id + "\">[Read More]</a>\n" +
                                "        </div>";
                        }
                    }
                    $("#blogList").append(s);
                    $('#blogCount').text("分类(" + blogList.length + ")");
                });
            } else {
                alert("获取博客列表失败！");
            }
        }
    });
});

$(function () {
    $('#search').keyup(function () {
        if (event.keyCode == 13) {
            var searchContent = $('#search').val();
            window.location = "search.html?searchContent=" + searchContent;
        }
    });
});