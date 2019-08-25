package Service.impl;

import Dao.impl.IndexDaoImpl;
import Entity.Blog;
import Entity.Comment;
import Service.IndexService;
import net.sf.json.JSONArray;

import java.util.List;

public class IndexServiceImpl implements IndexService {
    private IndexDaoImpl indexDao;

    public void setIndexDao(IndexDaoImpl indexDao) {
        this.indexDao = indexDao;
    }

    @Override
    public String getAllComment() {
        List<Comment> list = indexDao.getAllComment();
        JSONArray commentJson = JSONArray.fromObject(list);
        return commentJson.toString();
    }

    @Override
    public String getBlogListByCategory(String category) {
        List<Blog> list = indexDao.getBlogListByCategory(category);
        JSONArray blogJson = JSONArray.fromObject(list);
        return blogJson.toString();
    }
}
