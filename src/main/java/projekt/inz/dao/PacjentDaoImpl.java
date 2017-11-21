/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import projekt.inz.util.HibernateUtil;
import projekt.inz.pojo.Pacjent;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

/**
 *
 * @author depek
 */
@Repository
public class PacjentDaoImpl implements PacjentDao {

    private Session session;

    @Override
    @SuppressWarnings("unchecked")
    public List<Pacjent> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Pacjent").list();
    }

    @Override
    public void add(Pacjent pacjent) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(pacjent);
        session.getTransaction().commit();
    }

    @Override
    public void edit(Pacjent pacjent) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(pacjent);
        session.getTransaction().commit();
    }

    @Override
    public Pacjent getPacjent(int idPacjenta) {
        Pacjent n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (Pacjent) session.get(Pacjent.class, idPacjenta);
        return n;
    }

    @Override
    public Pacjent getPacjent(String login) {
        Pacjent n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (Pacjent) session.createCriteria(Pacjent.class, "pacjent")
                .add(Restrictions.eq("pacjent.login", login)).uniqueResult();

        return n;
    }

    @Override
    public void delete(int idPacjenta) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.delete(getPacjent(idPacjenta));
        trans.commit();
    }
}
