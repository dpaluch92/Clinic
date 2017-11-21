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
import projekt.inz.pojo.Doktor;
import projekt.inz.util.HibernateUtil;

/**
 *
 * @author depek
 */
@Repository
public class DoktorDaoImpl implements DoktorDao {

    private Session session;

    @Override
    @SuppressWarnings("unchecked")
    public List<Doktor> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Doktor").list();
    }
    
    @Override
    public Doktor getDoktor(String login) {
        Doktor n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (Doktor) session.createCriteria(Doktor.class, "doktor").add(Restrictions.eq("doktor.login", login)).uniqueResult();

        return n;
    }
}
