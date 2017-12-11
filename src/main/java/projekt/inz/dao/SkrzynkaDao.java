/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import java.util.List;
import projekt.inz.pojo.Skrzynka;

/**
 *
 * @author depek
 */
public interface SkrzynkaDao {
    
    void add(Skrzynka wiadomosc);
    
    void delete(int idWiadomosc);
    
    Skrzynka getMsg(int idWiadomosci);
    
    List<Skrzynka> getAll();
    
    List<Skrzynka> getAllByDoktor(int idDoktor);
    
    List<Skrzynka> getAllByPacjent(int idPacjent);
}
