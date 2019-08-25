package Service.impl;

import Dao.SearchDao;
import Entity.Blog;
import Service.SearchService;
import net.sf.json.JSONArray;

import java.util.List;

public class SearchServiceImpl implements SearchService {

    private SearchDao searchDao;

    public void setSearchDao(SearchDao searchDao) {
        this.searchDao = searchDao;
    }

    @Override
    public String searchBlogList(String searchContent) {
        List<Blog> list = searchDao.searchBlogList(searchContent);
        JSONArray blogJson = JSONArray.fromObject(list);
        return blogJson.toString();
    }
}
