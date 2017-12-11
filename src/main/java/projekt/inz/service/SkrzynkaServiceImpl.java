/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.inz.dao.SkrzynkaDao;
import projekt.inz.pojo.Skrzynka;

/**
 *
 * @author depek
 */
@Service("skrzynkaService")
public class SkrzynkaServiceImpl implements SkrzynkaService {

    @Autowired
    SkrzynkaDao skrzynkaDao;

    @Override
    public void add(Skrzynka wiadomosc) {
        skrzynkaDao.add(wiadomosc);
    }

    @Override
    public void delete(int idWiadomosc) {
        skrzynkaDao.delete(idWiadomosc);
    }

    @Override
    public Skrzynka getMsg(int idWiadomosci) {
        return skrzynkaDao.getMsg(idWiadomosci);
    }

    @Override
    public List<Skrzynka> getAll() {
        return skrzynkaDao.getAll();
    }

    @Override
    public List<Skrzynka> getAllByPacjent(int idPacjent) {
        return skrzynkaDao.getAllByPacjent(idPacjent);
    }

    @Override
    public List<Skrzynka> getAllByDoktor(int idDoktor) {
        return skrzynkaDao.getAllByDoktor(idDoktor);
    }

}
