/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import java.util.List;
import projekt.inz.pojo.Rejestracja;

/**
 *
 * @author depek
 */
public interface RejestracjaDao {

    Rejestracja getRejestracja(String login);

    List<Rejestracja> getAll();

    void add(Rejestracja rejestracja);

    void edit(Rejestracja rejestracja);

    void delete(int idRejestracji);

    Rejestracja getRejestracja(int idRejestracji);
}
