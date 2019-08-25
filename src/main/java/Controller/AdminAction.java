package Controller;

import Entity.Admin;
import Entity.Blog;
import Service.impl.AdminServiceImpl;
import Service.impl.SettingServiceImpl;
import com.opensymphony.xwork2.ActionSupport;
import net.sf.json.JSONObject;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminAction extends ActionSupport {

    private AdminServiceImpl adminServiceimpl;

    private Boolean isLogin = false;

    private String adminInfoByJson = "";

    private String categoryListByJson = "";

    private Boolean isAddBlog = false;

    private Boolean isEditAdmin = false;

    private String blogList = "";

    private Boolean isDelete = false;

    private String blogInfo = "";

    private Boolean isEditBlog = false;


    private String settingInfo = "";

    public String getSettingInfo() {
        return settingInfo;
    }


    public Boolean getIsEditBlog() {
        return isEditBlog;
    }

    public String getBlogInfo() {
        return blogInfo;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public String getBlogList() {
        return blogList;
    }

    public Boolean getIsEditAdmin() {
        return isEditAdmin;
    }

    public Boolean getIsAddBlog() {
        return isAddBlog;
    }

    public String getCategoryListByJson() {
        return categoryListByJson;
    }

    public String getAdminInfoByJson() {
        return adminInfoByJson;
    }

    public Boolean getIsLogin() {
        return isLogin;
    }

    public void setAdminService(AdminServiceImpl adminServiceimpl) {
        this.adminServiceimpl = adminServiceimpl;
    }

    private SettingServiceImpl settingServiceimpl;

    public void setSettingServiceimpl(SettingServiceImpl settingServiceimpl) {
        this.settingServiceimpl = settingServiceimpl;
    }

    public String login() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String userCheck = request.getParameter("userCheck");
        JSONObject jsonObject = JSONObject.fromObject(userCheck);
        Admin admin = (Admin) JSONObject.toBean(jsonObject, Admin.class);
        isLogin = adminServiceimpl.login(admin);
        return "login";
    }

    public String getAdminInfo() {
        adminInfoByJson = adminServiceimpl.getAdminInfo();
        return "getAdminInfo";
    }

    public String getSetting() {
        adminInfoByJson = settingServiceimpl.getSetting();
        return "getSettingInfo";
    }

    public String getCategoryList() {
        categoryListByJson = adminServiceimpl.getCategoryList();
        return "getCategoryList";
    }

    public String addBlog() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String blogContent = request.getParameter("blog");
        JSONObject jsonObject = JSONObject.fromObject(blogContent);
        Blog blog = (Blog) JSONObject.toBean(jsonObject, Blog.class);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String time = format.format(date);
        blog.setTime(time);
        if (!blog.getYzmm().equals("")) {
            blog.setMm("on");
        }
        isAddBlog = adminServiceimpl.addBlog(blog);
        return "addBlog";
    }

    public String editAdmin() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String adminJson = request.getParameter("admin");
        JSONObject jsonObject = JSONObject.fromObject(adminJson);
        Admin admin = (Admin) JSONObject.toBean(jsonObject, Admin.class);
        isEditAdmin = adminServiceimpl.editAdmin(admin);
        return "editAdmin";
    }

    public String getAllBlog() {
        blogList = adminServiceimpl.getAllBlog();
        return "getAllBlog";
    }

    public String deleteBlog() {
        HttpServletRequest request = ServletActionContext.getRequest();
        String id = request.getParameter("id");
        isDelete = adminServiceimpl.deleteBlog(id);
        return "deleteBlog";
    }

    public String getEditBlogInfo(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String id = request.getParameter("id");
        blogInfo = adminServiceimpl.getEditBlogInfo(id);
        return "getEditBlogInfo";
    }

    public String editBlog(){
        HttpServletRequest request = ServletActionContext.getRequest();
        String blogContent = request.getParameter("blog");
        JSONObject jsonObject = JSONObject.fromObject(blogContent);
        Blog blog = (Blog) JSONObject.toBean(jsonObject, Blog.class);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        String time = format.format(date);
        blog.setTime(time);
        if (!blog.getYzmm().equals("")) {
            blog.setMm("on");
        }
        adminServiceimpl.editBlog(blog);
        return "editBlog";
    }

}
