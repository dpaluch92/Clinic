/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import projekt.inz.pojo.Rejestracja;
import projekt.inz.util.HibernateUtil;

/**
 *
 * @author depek
 */
@Repository
public class RejestracjaDaoImpl implements RejestracjaDao {

    private Session session;

    @Override
    public Rejestracja getRejestracja(String login) {
        Rejestracja n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (Rejestracja) session.createCriteria(Rejestracja.class, "rejestracja").add(Restrictions.eq("rejestracja.login", login)).uniqueResult();

        return n;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Rejestracja> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Rejestracja").list();
    }

    @Override
    public void add(Rejestracja rejestracja) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(rejestracja);
        session.getTransaction().commit();
    }

    @Override
    public void edit(Rejestracja rejestracja) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(rejestracja);
        session.getTransaction().commit();
    }

    @Override
    public void delete(int idRejestracji) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.delete(getRejestracja(idRejestracji));
        trans.commit();
    }

    @Override
    public Rejestracja getRejestracja(int idRejestracji) {
        Rejestracja n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (Rejestracja) session.get(Rejestracja.class, idRejestracji);
        return n;
    }

}
