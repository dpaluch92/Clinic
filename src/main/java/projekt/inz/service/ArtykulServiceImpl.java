/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.inz.dao.ArtykulDao;
import projekt.inz.pojo.Artykul;

/**
 *
 * @author depek
 */
@Service("artykulService")
public class ArtykulServiceImpl implements ArtykulService {

    @Autowired
    private ArtykulDao artykulDao;

    @Override
    public List<Artykul> getAll() {
        return artykulDao.getAll();
    }

    @Override
    public void add(Artykul artykul) {
        artykulDao.add(artykul);
    }

    @Override
    public void edit(Artykul artykul) {
        artykulDao.edit(artykul);
    }

    @Override
    public void delete(int idArtykul) {
        artykulDao.delete(idArtykul);
    }

    @Override
    public Artykul getArtykul(int idArtykul) {
        return artykulDao.getArtykul(idArtykul);
    }

}
