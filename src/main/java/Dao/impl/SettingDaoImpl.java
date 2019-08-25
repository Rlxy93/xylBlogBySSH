package Dao.impl;

import Dao.SettingDao;
import Entity.Setting;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class SettingDaoImpl implements SettingDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List getSetting() {
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(Setting.class);
        List list = criteria.list();
        session.close();
        return list;
    }

    public boolean editSetting(Setting setting) {
        Session session = sessionFactory.openSession();
        try{
            Transaction ts=session.beginTransaction();
            session.update(setting);
            ts.commit();
            session.close();
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
