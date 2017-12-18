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
import projekt.inz.pojo.KartaPacjenta;
import projekt.inz.util.HibernateUtil;

/**
 *
 * @author depek
 */
@Repository
public class KartaPacjentaDaoImpl implements KartaPacjentaDao {

    private Session session;

    @Override
    @SuppressWarnings("unchecked")
    public List<KartaPacjenta> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from KartaPacjenta").list();
    }

    @Override
    public void add(KartaPacjenta kartaPacjenta) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(kartaPacjenta);
        session.getTransaction().commit();
    }

    @Override
    public void edit(KartaPacjenta kartaPacjenta) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(kartaPacjenta);
        session.getTransaction().commit();
    }

    @Override
    public void delete(int idKartaPacjenta) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.delete(getKartaPacjenta(idKartaPacjenta));
        trans.commit();
    }

    @Override
    public KartaPacjenta getKartaPacjenta(int idKartaPacjenta) {
        KartaPacjenta n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (KartaPacjenta) session.get(KartaPacjenta.class, idKartaPacjenta);
        return n;
    }

}
