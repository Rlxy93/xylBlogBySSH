$(function () {
    var currentUrl = document.location.toString();
    var Url = currentUrl.split("?");

    var para = Url[1];

    var getBlogContentUrl = 'content_getBlog?' + para;
    $.ajax({
        url: getBlogContentUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data!="") {
                var blogContent = JSON.parse(data);
                document.title = blogContent.title;
                $(document).ready(function () {
                    var s = "";
                    s += "<br><a style=\"font-size:24px;\" href=\"content.html?id=" + blogContent.id + "\">" + blogContent.title + "</a><br>\n" +
                        "\t\t<img src='resources/images/clock.png' style='width:20px;' title='发表时间'><span style=\"font-size:18px;\">" + blogContent.time + " &nbsp;<img\n" +
                        "            src='resources/images/male.png' style='width:20px;' title='作者'>" + "lxy" + "</span>\n" +
                        "\t<hr>\n" +
                        "\t\t<div class='neirong2'>" + blogContent.body + "<br></div>";
                    $("#animated_div").append(s);
                });
            } else {
                alert("获取博客详情失败！");
            }
        }
    });
});

$(function () {
    var currentUrl = document.location.toString();
    var Url = currentUrl.split("?");

    var para = Url[1];

    var getCommentListByBlogIdUrl = 'content_getCommentListByBlogId?' + para;
    $.ajax({
        url: getCommentListByBlogIdUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data!="") {
                var commentList = JSON.parse(data);
                $(document).ready(function () {
                    var s = "";
                    for (var i = 0; i < commentList.length; ++i) {
                        s += "<div class='comment'>本评论由 <span style='color:red;'>" + commentList[i].name + "</span> 发表于：" + commentList[i].time + "<br><br>" + commentList[i].comment + "</div><br><br>";
                    }
                    $("#commentListByBlogId").append(s);
                });
            } else {
                alert("获取评论列表失败！");
            }
        }
    });
});