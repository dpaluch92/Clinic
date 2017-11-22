/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.inz.dao.RejestracjaDao;
import projekt.inz.pojo.Rejestracja;

/**
 *
 * @author depek
 */
@Service("rejestracjaService")
public class RejestracjaServiceImpl implements RejestracjaService{
    
    @Autowired
    RejestracjaDao rejestracjaDao;

    @Override
    public Rejestracja getRejestracja(String login) {
        return rejestracjaDao.getRejestracja(login);
    }

    @Override
    public Rejestracja loginRejestracja(String login, String haslo) {
        Rejestracja rejestracja = this.getRejestracja(login);
        if (rejestracja != null && rejestracja.getHaslo().equals(haslo)) {
            return rejestracja;
        }
        return null;
    }
    
}
