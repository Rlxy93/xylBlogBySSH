package Controller;

import Service.impl.AdminServiceImpl;
import Service.impl.IndexServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IndexAction extends ActionSupport {
    private IndexServiceImpl indexServiceimpl;

    private AdminServiceImpl adminServiceimpl;

    public AdminServiceImpl getAdminServiceimpl() {
        return adminServiceimpl;
    }

    public void setAdminServiceimpl(AdminServiceImpl adminServiceimpl) {
        this.adminServiceimpl = adminServiceimpl;
    }

    public IndexServiceImpl getIndexServiceimpl() {
        return indexServiceimpl;
    }

    public void setIndexServiceimpl(IndexServiceImpl indexServiceimpl) {
        this.indexServiceimpl = indexServiceimpl;
    }

    private String blogList = "";

    private String categoryList = "";

    public String getCommentList() {
        return commentList;
    }

    private String commentList = "";

    private String BlogListCategory = "";

    public String getBlogListCategory() {
        return BlogListCategory;
    }

    public String getCategoryList() {
        return categoryList;
    }

    public String getBlogList() {
        return blogList;
    }

    public String getAllBlog() {
        blogList = adminServiceimpl.getAllBlog();
        String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>";
        String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>";
        String regEx_html = "<[^>]+>";

        Pattern p_script = Pattern.compile(regEx_script, 2);
        Matcher m_script = p_script.matcher(blogList);
        blogList = m_script.replaceAll("");

        Pattern p_style = Pattern.compile(regEx_style, 2);
        Matcher m_style = p_style.matcher(blogList);
        blogList = m_style.replaceAll("");

        Pattern p_html = Pattern.compile(regEx_html, 2);
        Matcher m_html = p_html.matcher(blogList);
        blogList = m_html.replaceAll("");
        blogList = blogList.replace("&nbsp;", " ");
        return "getAllBlog";
    }

    public String getAllCategory() {
        categoryList = adminServiceimpl.getCategoryList();
        return "getAllCategory";
    }

    public String getAllComment() {
        commentList = indexServiceimpl.getAllComment();
        return "getAllComment";
    }

    public String getBlogListByCategory() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String category = request.getParameter("id");
        try {
            category = new String(request.getParameter("id").getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        BlogListCategory = indexServiceimpl.getBlogListByCategory(category);
        return "getBlogListByCategory";
    }
}
