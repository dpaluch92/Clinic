/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.inz.dao.KartaPacjentaDao;
import projekt.inz.pojo.KartaPacjenta;

/**
 *
 * @author depek
 */
@Service("kartaPacjentaService")
public class KartaPacjentaServiceImpl implements KartaPacjentaService {

    @Autowired
    private KartaPacjentaDao dao;

    @Override
    public List<KartaPacjenta> getAll() {
        return dao.getAll();
    }

    @Override
    public void add(KartaPacjenta kartaPacjenta) {
        dao.add(kartaPacjenta);
    }

    @Override
    public void edit(KartaPacjenta kartaPacjenta) {
        dao.edit(kartaPacjenta);
    }

    @Override
    public void delete(int idKartaPacjenta) {
        dao.delete(idKartaPacjenta);
    }

    @Override
    public KartaPacjenta getKartaPacjenta(int idKartaPacjenta) {
        return dao.getKartaPacjenta(idKartaPacjenta);
    }

}
