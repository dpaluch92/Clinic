/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.service;

import java.util.List;
import projekt.inz.pojo.Recepta;

/**
 *
 * @author depek
 */
public interface ReceptaService {

    List<Recepta> getAllByDoktor(int idDoktor);

    void add(Recepta recepta);

    void edit(Recepta recepta);

    void delete(int idRecepty);

    Recepta getRecepta(int idRecepty);
}
