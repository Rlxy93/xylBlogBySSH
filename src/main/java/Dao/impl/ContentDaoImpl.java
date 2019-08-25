package Dao.impl;

import Dao.ContentDao;
import Entity.Blog;
import Entity.Comment;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class ContentDaoImpl implements ContentDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    public List getBlog(String blogId) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Blog.class);
        criteria.add(Restrictions.eq("id", Integer.parseInt(blogId)));
        List list = criteria.list();
        session.close();
        return list;
    }

    @Override
    public List<Comment> getAllCommentById(String blogId) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Comment.class);
        criteria.add(Restrictions.eq("id", Integer.parseInt(blogId)));
        criteria.addOrder(Order.desc("num"));
        List list = criteria.list();
        session.close();
        return list;
    }

    @Override
    public Boolean addComment(Comment comment) {
        Session session = sessionFactory.openSession();
        try{
            session.save(comment);
            session.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
