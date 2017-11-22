/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import projekt.inz.pojo.Rejestracja;
import projekt.inz.util.HibernateUtil;

/**
 *
 * @author depek
 */
@Repository
public class RejestracjaDaoImpl implements RejestracjaDao{
    
    private Session session;

    @Override
    public Rejestracja getRejestracja(String login) {
        Rejestracja n;
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        n = (Rejestracja) session.createCriteria(Rejestracja.class, "rejestracja").add(Restrictions.eq("rejestracja.login", login)).uniqueResult();

        return n;
    }
    
}
