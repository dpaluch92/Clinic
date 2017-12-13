/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import java.util.List;
import projekt.inz.pojo.Uslugi;

/**
 *
 * @author depek
 */
public interface UslugiDao {

    List<Uslugi> getAll();

    Uslugi getUslugi(int idUslugi);

}
