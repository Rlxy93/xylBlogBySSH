$(function () {
    var currentUrl = document.location.toString();
    var Url = currentUrl.split("?");
    var para = Url[1].substring(14);
    var searchBlogListUrl = 'search_searchBlogList?searchContent=' + para;
    $.ajax({
        url: searchBlogListUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data!="") {
                var searchBlogList = JSON.parse(data);
                $(document).ready(function () {
                    var s = "";
                    for (var i = 0; i < searchBlogList.length; i++) {
                        if (searchBlogList[i].mm == "on") {
                            s += "\n" +
                                "        <div id=\"animated_div\" style=\"border:1px solid silver;\">\n" +
                                "            <br>\n" +
                                "            <img src='resources/images/lock.png' style='width:20px;' title='已锁定'>\n" +
                                "            <a style=\"font-size:24px;\" href=\"./content?id=" + searchBlogList[i].id + "\">" + searchBlogList[i].title + "</a><br>\n" +
                                "            <img src='resources/images/clock.png' style='width:20px;' title='发表时间'>\n" +
                                "            <span style=\"font-size:18px;\">" + searchBlogList[i].time + " &nbsp;\n" +
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
                                "            <a style=\"font-size:24px;\" href=\"content?id=" + searchBlogList[i].id + "\">" + searchBlogList[i].title + "</a><br>\n" +
                                "            <img src='resources/images/clock.png' style='width:20px;' title='发表时间'>\n" +
                                "            <span style=\"font-size:18px;\">" + searchBlogList[i].time + " &nbsp;\n" +
                                "\t\t<img src='resources/images/male.png' style='width:20px;' title='作者'>" + setting.admin + "</span>\n" +
                                "            <hr>\n" +
                                "            " + searchBlogList[i].body + "...\n" +
                                "            <br><a style='color:black;' href=\"resources/content?id=" + searchBlogList[i].id + "\">[Read More]</a>\n" +
                                "        </div>";
                        }
                    }
                    $("#searchBlogList").append(s);
                });
            } else {
                alert("搜索结果为空！");
            }
        }
    });
});