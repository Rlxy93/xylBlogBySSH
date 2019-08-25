package Dao.impl;

import Dao.SearchDao;
import Entity.Blog;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Expression;

import java.util.List;

public class SearchDaoImpl implements SearchDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List searchBlogList(String searchContent) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Blog.class);
        criteria.add(Expression.or(Expression.like("title","%"+searchContent+"%"),Expression.like("body","%"+searchContent+"%")));
        List<Blog> list = criteria.list();
        session.close();
        return list;
    }
}
