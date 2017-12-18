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
import projekt.inz.pojo.Artykul;
import projekt.inz.util.HibernateUtil;

/**
 *
 * @author depek
 */
@Repository
public class ArtykulDaoImpl implements ArtykulDao {

    private Session session;

    @Override
    @SuppressWarnings("unchecked")
    public List<Artykul> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Artykul").list();
    }

    @Override
    public void add(Artykul artykul) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(artykul);
        session.getTransaction().commit();
    }

    @Override
    public void edit(Artykul artykul) {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(artykul);
        session.getTransaction().commit();
    }

    @Override
    public void delete(int idArtykul) {
        session = HibernateUtil.getSessionFactory().openSession();
        Transaction trans = session.beginTransaction();
        session.delete(getArtykul(idArtykul));
        trans.commit();
    }

    @Override
    public Artykul getArtykul(int idArtykul) {
        Artykul n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (Artykul) session.get(Artykul.class, idArtykul);
        return n;
    }

}
