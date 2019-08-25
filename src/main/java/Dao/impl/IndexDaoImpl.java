package Dao.impl;

import Dao.IndexDao;
import Entity.Blog;
import Entity.Comment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class IndexDaoImpl implements IndexDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Comment> getAllComment() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Comment.class);
        criteria.addOrder(Order.desc("num"));
        List list = criteria.list();
        session.close();
        return list;
    }

    @Override
    public List<Blog> getBlogListByCategory(String category) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Blog.class);
        criteria.add(Restrictions.eq("category", category));
        List<Blog> list = criteria.list();
        session.close();
        return list;
    }
}
