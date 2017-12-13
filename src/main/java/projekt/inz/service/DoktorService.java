/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.service;

import java.util.List;
import projekt.inz.pojo.Doktor;

/**
 *
 * @author depek
 */
public interface DoktorService {

    List<Doktor> getAll();

    Doktor getDoktor(String login);

    Doktor loginDoktor(String login, String haslo);

    void add(Doktor doktor);

    void edit(Doktor doktor);

    void delete(int idDoktora);

    Doktor getDoktor(int idDoktora);
}
