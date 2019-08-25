package Service;

import Entity.Admin;
import Entity.Blog;

public interface AdminService {
    boolean login(Admin admin);
    String getAdminInfo();
    String getCategoryList();
    boolean addBlog(Blog blog);
    boolean editAdmin(Admin admin);
    String getAllBlog();
    boolean deleteBlog(String id);
    String getEditBlogInfo(String id);
    boolean editBlog(Blog blog);
}
