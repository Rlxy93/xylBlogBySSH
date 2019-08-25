package Dao;

import Entity.Comment;

import java.util.List;

public interface ContentDao {
    List getBlog(String blogId);

    List<Comment> getAllCommentById(String blogId);

    Boolean addComment(Comment comment);
}
