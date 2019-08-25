package Dao.impl;

import Dao.AdminDao;
import Entity.Admin;
import Entity.Blog;
import Entity.Category;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List login(String username, String password) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Admin.class);
        criteria.add(Restrictions.eq("user", username));
        criteria.add(Restrictions.eq("password", password));
        List list = criteria.list();
        session.close();
        return list;
    }

    @Override
    public List getAdminInfo() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Admin.class);
        List list = criteria.list();
        session.close();
        return list;
    }

    @Override
    public List getCategoryList() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Category.class);
        List list = criteria.list();
        session.close();
        return list;
    }

    @Override
    public boolean addBlog(Blog blog) {
        Session session = sessionFactory.openSession();
        try{
            session.save(blog);
            session.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public boolean editAdmin(Admin admin) {
        Session session = sessionFactory.openSession();
        try{
            Transaction ts=session.beginTransaction();
            session.update(admin);
            ts.commit();
            session.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List getAllBlog() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Blog.class);
        criteria.addOrder(Order.desc("id"));
        List list = criteria.list();
        session.close();
        return list;
    }

    @Override
    public boolean deleteBlog(Blog blog) {
        Session session = sessionFactory.openSession();
        try{
            Transaction ts=session.beginTransaction();
            session.delete(blog);
            ts.commit();
            session.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }

    @Override
    public List getEditBlogInfo(String id) {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Blog.class);
        criteria.add(Restrictions.in("id",Integer.parseInt(id)));
        List list = criteria.list();
        return list;
    }

    @Override
    public boolean editBlog(Blog blog) {
        Session session = sessionFactory.openSession();
        try{
            Transaction ts=session.beginTransaction();
            session.update(blog);
            ts.commit();
            session.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
