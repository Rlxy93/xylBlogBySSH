package Dao;

import Entity.Admin;
import Entity.Blog;

import java.util.List;

public interface AdminDao {
    List login(String username, String password);
    List getAdminInfo();
    List getCategoryList();
    boolean addBlog(Blog blog);
    boolean editAdmin(Admin admin);
    List getAllBlog();
    boolean deleteBlog(Blog blog);
    List getEditBlogInfo(String id);
    boolean editBlog(Blog blog);
}
