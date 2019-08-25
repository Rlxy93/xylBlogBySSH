package Service.impl;

import Dao.impl.AdminDaoImpl;
import Entity.Admin;
import Entity.Blog;
import Service.AdminService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public class AdminServiceImpl implements AdminService {

    private AdminDaoImpl adminDao;

    public void setAdminDao(AdminDaoImpl adminDao) {
        this.adminDao = adminDao;
    }

    public boolean login(Admin admin){
        List adminList = adminDao.login(admin.getUser(), admin.getPassword());
        if(adminList.isEmpty()){
            return false;
        }
        return true;
    }

    public String getAdminInfo() {
        List list = adminDao.getAdminInfo();
        Admin admin = (Admin) list.get(0);
        JSONObject adminJson = JSONObject.fromObject(admin);
        return adminJson.toString();
    }

    @Override
    public String getCategoryList() {
        List categoryList = adminDao.getCategoryList();
        JSONArray allCategoryJson = JSONArray.fromObject(categoryList);
        return allCategoryJson.toString();
    }

    @Override
    public boolean addBlog(Blog blog) {
        boolean isAddBlog = adminDao.addBlog(blog);
        return isAddBlog;
    }

    public boolean editAdmin(Admin admin) {
        boolean isEditAdmin = adminDao.editAdmin(admin);
        return isEditAdmin;
    }

    @Override
    public String getAllBlog() {
        List blogList = adminDao.getAllBlog();
        JSONArray allBlogJson = JSONArray.fromObject(blogList);
        return allBlogJson.toString();
    }

    @Override
    public boolean deleteBlog(String id) {
        Blog blog = new Blog();
        blog.setId(Integer.parseInt(id));
        boolean isDelete = adminDao.deleteBlog(blog);
        return isDelete;
    }

    @Override
    public String getEditBlogInfo(String id) {
        List list = adminDao.getEditBlogInfo(id);
        Blog blog = (Blog) list.get(0);
        JSONObject blogJson = JSONObject.fromObject(blog);
        return blogJson.toString();
    }

    @Override
    public boolean editBlog(Blog blog) {
        boolean isEditBlog = adminDao.editBlog(blog);
        return isEditBlog;
    }
}
