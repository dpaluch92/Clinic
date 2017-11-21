/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import projekt.inz.pojo.Admin;
import projekt.inz.util.HibernateUtil;

/**
 *
 * @author depek
 */
@Repository
public class AdminDaoImpl implements AdminDao {

    private Session session;

    @Override
    @SuppressWarnings("unchecked")
    public List<Admin> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Doktor").list();
    }

    @Override
    public Admin getAdmin(String login) {
        Admin n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (Admin) session.createCriteria(Admin.class, "admin").add(Restrictions.eq("admin.login", login)).uniqueResult();

        return n;
    }

}
