/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.inz.dao.ReceptaDao;
import projekt.inz.pojo.Recepta;

/**
 *
 * @author depek
 */
@Service("receptaService")
public class ReceptaServiceImpl implements ReceptaService {

    @Autowired
    private ReceptaDao receptaDao;

    @Override
    public List<Recepta> getAllByDoktor(int idDoktor) {
        return receptaDao.getAllByDoktor(idDoktor);
    }

    @Override
    public void add(Recepta recepta) {
        receptaDao.add(recepta);
    }

    @Override
    public void edit(Recepta recepta) {
        receptaDao.edit(recepta);
    }

    @Override
    public void delete(int idRecepty) {
        receptaDao.delete(idRecepty);
    }

    @Override
    public Recepta getRecepta(int idRecepty) {
        return receptaDao.getRecepta(idRecepty);
    }

}
