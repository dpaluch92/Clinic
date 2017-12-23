/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import projekt.inz.pojo.Recepta;
import projekt.inz.util.HibernateUtil;

/**
 *
 * @author depek
 */
@Repository
public class ReceptaDaoImpl implements ReceptaDao {

    private Session session;

    @Override
    @SuppressWarnings("unchecked")
    public List<Recepta> getAllByDoktor(int idDoktor) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Recepta where doktor=" + idDoktor).list();
    }

    @Override
    public void add(Recepta recepta) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(recepta);
        session.getTransaction().commit();
    }

    @Override
    public void edit(Recepta recepta) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(recepta);
        session.getTransaction().commit();
    }

    @Override
    public void delete(int idRecepty) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.delete(getRecepta(idRecepty));
        trans.commit();
    }

    @Override
    public Recepta getRecepta(int idRecepty) {
        Recepta n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (Recepta) session.get(Recepta.class, idRecepty);
        return n;
    }

}
