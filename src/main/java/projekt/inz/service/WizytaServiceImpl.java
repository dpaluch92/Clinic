/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.inz.dao.WizytaDao;
import projekt.inz.pojo.Wizyta;

/**
 *
 * @author depek
 */

@Service("wizytaService")
public class WizytaServiceImpl implements WizytaService {

    @Autowired
    WizytaDao wizytaDao;

    @Override
    public List<Wizyta> getAll() {
        return wizytaDao.getAll();
    }

    @Override
    public void edit(Wizyta wizyta) {
        wizytaDao.edit(wizyta);
    }

    @Override
    public void add(Wizyta wizyta) {
        wizytaDao.add(wizyta);
    }

    @Override
    public void delete(int idWizyty) {
        wizytaDao.delete(idWizyty);
    }

    @Override
    public Wizyta getWizyta(int idWizyty) {
        return wizytaDao.getWizyta(idWizyty);
    }

    @Override
    public List<Wizyta> getWizytaByIdDoktor(int idDoktor) {
        return wizytaDao.getWizytaByIdDoktor(idDoktor);
    }

}
