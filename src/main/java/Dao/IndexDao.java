package Dao;

import Entity.Blog;
import Entity.Comment;

import java.util.List;

public interface IndexDao {
    List<Comment> getAllComment();
    List<Blog> getBlogListByCategory(String category);
}
