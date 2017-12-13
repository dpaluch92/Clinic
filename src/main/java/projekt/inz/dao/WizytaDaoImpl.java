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
import projekt.inz.pojo.Wizyta;
import projekt.inz.util.HibernateUtil;

/**
 *
 * @author depek
 */
@Repository
public class WizytaDaoImpl implements WizytaDao {

    private Session session;

    @Override
    @SuppressWarnings("unchecked")
    public List<Wizyta> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Wizyta").list();
    }

    @Override
    public void edit(Wizyta wizyta) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(wizyta);
        session.getTransaction().commit();
    }

    @Override
    public void add(Wizyta wizyta) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(wizyta);
        session.getTransaction().commit();
    }

    @Override
    public void delete(int idWizyty) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.delete(getWizyta(idWizyty));
        trans.commit();
    }

    @Override
    public Wizyta getWizyta(int idWizyty) {
        Wizyta n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (Wizyta) session.get(Wizyta.class, idWizyty);
        return n;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Wizyta> getWizytaByIdDoktor(int idDoktora) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Wizyta where doktor=" + idDoktora).list();
    }

}
