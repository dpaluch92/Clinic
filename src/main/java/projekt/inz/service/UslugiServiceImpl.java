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

import projekt.inz.dao.UslugiDao;
import projekt.inz.pojo.Uslugi;

/**
 *
 * @author depek
 */
@Service("uslugiService")
public class UslugiServiceImpl implements UslugiService {

    @Autowired
    private UslugiDao uslugiDao;

    @Transactional
    public List<Uslugi> getAll() {
        return uslugiDao.getAll();
    }

    @Override
    public Uslugi getUslugi(int idUslugi) {
        return uslugiDao.getUslugi(idUslugi);
    }
    
    
}
