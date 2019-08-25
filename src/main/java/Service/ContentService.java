package Service;

import Entity.Comment;

public interface ContentService {

    String getBlog(String blogId);

    String getCommentListByBlogId(String blogId);

    Boolean addComment(Comment comment);
}
