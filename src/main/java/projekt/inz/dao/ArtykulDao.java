/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import java.util.List;
import projekt.inz.pojo.Artykul;

/**
 *
 * @author depek
 */
public interface ArtykulDao {

    List<Artykul> getAll();

    void add(Artykul artykul);

    void edit(Artykul artykul);

    void delete(int idArtykul);

    Artykul getArtykul(int idArtykul);
}
