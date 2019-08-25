package Service.impl;

import Dao.ContentDao;
import Entity.Blog;
import Entity.Comment;
import Service.ContentService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.List;

public class ContentServiceImpl implements ContentService {

    private ContentDao contentDao;

    public void setContentDao(ContentDao contentDao) {
        this.contentDao = contentDao;
    }

    @Override
    public String getBlog(String blogId) {
        List list = contentDao.getBlog(blogId);
        Blog blog = (Blog) list.get(0);
        JSONObject blogJson = JSONObject.fromObject(blog);
        return blogJson.toString();
    }

    @Override
    public String getCommentListByBlogId(String blogId) {
        List<Comment> list = contentDao.getAllCommentById(blogId);
        JSONArray commentJson = JSONArray.fromObject(list);
        return commentJson.toString();
    }

    @Override
    public Boolean addComment(Comment comment) {
        Boolean isComment = contentDao.addComment(comment);
        return isComment;
    }
}
