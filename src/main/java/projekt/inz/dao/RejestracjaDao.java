/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import projekt.inz.pojo.Rejestracja;

/**
 *
 * @author depek
 */
public interface RejestracjaDao {
    Rejestracja getRejestracja(String login);
}
