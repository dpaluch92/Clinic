/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.service;

import projekt.inz.dao.PacjentDao;
import projekt.inz.pojo.Pacjent;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author depek
 */
@Service("pacjentService")
public class PacjentServiceImpl implements PacjentService {

    @Autowired
    private PacjentDao pacjentDao;

    @Transactional
    @Override
    public List<Pacjent> getAll() {
        return pacjentDao.getAll();
    }

    @Transactional
    @Override
    public void add(Pacjent pacjent) {
        //pacjent.setHaslo(passwordEncoder.encode(pacjent.getHaslo()));
        pacjentDao.add(pacjent);
    }

    @Transactional
    @Override
    public void edit(Pacjent pacjent) {
        pacjentDao.edit(pacjent);
    }

    @Transactional
    @Override
    public void delete(int idPacjenta) {
        pacjentDao.delete(idPacjenta);
    }

    @Transactional
    @Override
    public Pacjent getPacjent(int idPacjenta) {
        return pacjentDao.getPacjent(idPacjenta);
    }

    @Transactional
    public Pacjent getPacjent(String username) {
        return pacjentDao.getPacjent(username);
    }

    @Override
    public Pacjent loginPacjent(String login, String haslo) {
        Pacjent pacjent = this.getPacjent(login);
        if (pacjent != null && pacjent.getHaslo().equals(haslo)) {
            return pacjent;
        }
        return null;
    }

}
