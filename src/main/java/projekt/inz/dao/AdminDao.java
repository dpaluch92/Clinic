/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.dao;

import java.util.List;
import projekt.inz.pojo.Admin;

/**
 *
 * @author depek
 */
public interface AdminDao {

    List<Admin> getAll();

    Admin getAdmin(String login);
}
