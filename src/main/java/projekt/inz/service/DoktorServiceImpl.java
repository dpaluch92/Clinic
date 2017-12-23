/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.inz.dao.DoktorDao;
import projekt.inz.pojo.Doktor;
import projekt.inz.util.PasswordCoding;

/**
 *
 * @author depek
 */
@Service("doktorService")
public class DoktorServiceImpl implements DoktorService {

    @Autowired
    private DoktorDao doktorDao;

    @Transactional
    @Override
    public List<Doktor> getAll() {
        return doktorDao.getAll();
    }

    @Transactional
    @Override
    public Doktor getDoktor(String login) {
        return doktorDao.getDoktor(login);
    }

    @Override
    public Doktor loginDoktor(String login, String haslo) {
        Doktor doktor = this.getDoktor(login);
        PasswordCoding coding = new PasswordCoding();
        String coded = coding.encode(haslo);

        if (doktor != null && doktor.getHaslo().equals(coded)) {
            return doktor;
        }
        return null;
    }

    @Override
    public void add(Doktor doktor) {
        PasswordCoding coding = new PasswordCoding();
        doktor.setHaslo(coding.encode(doktor.getHaslo()));
        doktorDao.add(doktor);
    }

    @Override
    public void edit(Doktor doktor) {
        PasswordCoding coding = new PasswordCoding();
        doktor.setHaslo(coding.encode(doktor.getHaslo()));
        doktorDao.edit(doktor);
    }

    @Override
    public void delete(int idDoktora) {
        doktorDao.delete(idDoktora);
    }

    @Override
    public Doktor getDoktor(int idDoktora) {
        return doktorDao.getDoktor(idDoktora);
    }
}
