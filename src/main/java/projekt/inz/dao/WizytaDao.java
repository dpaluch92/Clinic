/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import java.util.List;
import projekt.inz.pojo.Wizyta;

/**
 *
 * @author depek
 */
public interface WizytaDao {
    
    List<Wizyta> getAll();
    
    void edit(Wizyta wizyta);
    
    void add(Wizyta wizyta);
    
    void delete(int idWizyty);
    
    Wizyta getWizyta(int idWizyty);
       
}
