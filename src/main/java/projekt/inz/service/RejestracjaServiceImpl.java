/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.inz.dao.RejestracjaDao;
import projekt.inz.pojo.Rejestracja;
import projekt.inz.util.PasswordCoding;

/**
 *
 * @author depek
 */
@Service("rejestracjaService")
public class RejestracjaServiceImpl implements RejestracjaService {

    @Autowired
    RejestracjaDao rejestracjaDao;

    @Override
    public Rejestracja getRejestracja(String login) {
        return rejestracjaDao.getRejestracja(login);
    }

    @Override
    public Rejestracja loginRejestracja(String login, String haslo) {
        Rejestracja rejestracja = this.getRejestracja(login);
        PasswordCoding coding = new PasswordCoding();
        String coded = coding.encode(haslo);

        if (rejestracja != null && rejestracja.getHaslo().equals(coded)) {
            return rejestracja;
        }
        return null;
    }

    @Override
    public List<Rejestracja> getAll() {
        return rejestracjaDao.getAll();
    }

    @Override
    public void add(Rejestracja rejestracja) {
        PasswordCoding coding = new PasswordCoding();
        rejestracja.setHaslo(coding.encode(rejestracja.getHaslo()));
        rejestracjaDao.add(rejestracja);
    }

    @Override
    public void edit(Rejestracja rejestracja) {
        PasswordCoding coding = new PasswordCoding();
        rejestracja.setHaslo(coding.encode(rejestracja.getHaslo()));
        rejestracjaDao.edit(rejestracja);
    }

    @Override
    public void delete(int idRejestracji) {
        rejestracjaDao.delete(idRejestracji);
    }

    @Override
    public Rejestracja getRejestracja(int idRejestracji) {
        return rejestracjaDao.getRejestracja(idRejestracji);
    }

}
