/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import projekt.inz.pojo.Uslugi;
import projekt.inz.util.HibernateUtil;

/**
 *
 * @author depek
 */
@Repository
public class UslugiDaoImpl implements UslugiDao {

    private Session session;

    @Override
    @SuppressWarnings("unchecked")
    public List<Uslugi> getAll() {
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        return session.createQuery("from Uslugi").list();
    }
    
    @Override
    public Uslugi getUslugi(int idUslugi) {
        Uslugi n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (Uslugi) session.get(Uslugi.class, idUslugi);
        return n;
    }

}
