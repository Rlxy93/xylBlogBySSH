$(function () {
    var getBlogUrl = 'admin/admin_getAllBlog';
    $.ajax({
        url: getBlogUrl,
        type: 'POST',
        contentType: false,
        processData: false,
        cache: false,
        success: function (data) {
            if (data!="") {
                var blog = JSON.parse(data);
                $(document).ready(function () {
                    var s = "";
                    for (var i = 0; i < blog.length; i++) {
                        s += "<tr>\n" +
                            "        <td>" + (i + 1) + "</td>\n" +
                            "        <td>" + blog[i].title + "</td>\n" +
                            "        <td>" + blog[i].time + "</td>\n" +
                            "        <td><a onclick=\"return del('./admin_deleteBlog?id=" + blog[i].id + "')\" href=>删除</a>\n" +
                            "            <a href=\"./editBlog.html?id=" + blog[i].id + "\">修改</a></td>\n" +
                            "    </tr>";
                    }
                    $("#blogList").append(s);
                });
            } else {
                alert("获取博客列表失败！");
            }
        }
    });
});

function del(deleteUrl) {
    var bool = confirm("是否删除此博客？");
    if (bool) {
        $(function () {
            $.ajax({
                url: deleteUrl,
                type: 'POST',
                contentType: false,
                processData: false,
                cache: false,
                success: function (data) {
                    if (data==false) {
                        alert("删除博客失败！");
                    } else {
                        alert("删除博客成功！");
                    }
                }
            });
        });
        return true;
    } else {
        alert("删除失败！");
        return false;
    }
}