/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import java.util.List;
import projekt.inz.pojo.KartaPacjenta;

/**
 *
 * @author depek
 */
public interface KartaPacjentaDao {

    List<KartaPacjenta> getAll();

    void add(KartaPacjenta kartaPacjenta);

    void edit(KartaPacjenta kartaPacjenta);

    void delete(int idKartaPacjenta);

    KartaPacjenta getKartaPacjenta(int idKartaPacjenta);

}
