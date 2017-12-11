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
import projekt.inz.pojo.Skrzynka;
import projekt.inz.util.HibernateUtil;

/**
 *
 * @author depek
 */
@Repository
public class SkrzynkaDaoImpl implements SkrzynkaDao {

    private Session session;

    @Override
    public void add(Skrzynka wiadomosc) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(wiadomosc);
        session.getTransaction().commit();
    }

    @Override
    public void delete(int idWiadomosc) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.delete(getMsg(idWiadomosc));
        trans.commit();
    }

    @Override
    public Skrzynka getMsg(int idWiadomosci) {
        Skrzynka n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (Skrzynka) session.get(Skrzynka.class, idWiadomosci);
        return n;
    }

    @Override
    public List<Skrzynka> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Skrzynka").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Skrzynka> getAllByDoktor(int idDoktor) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Skrzynka where doktor=" + idDoktor).list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Skrzynka> getAllByPacjent(int idPacjent) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Skrzynka where pacjent=" + idPacjent).list();
    }

}
