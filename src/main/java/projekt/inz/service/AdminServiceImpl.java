/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projekt.inz.dao.AdminDao;
import projekt.inz.pojo.Admin;

/**
 *
 * @author depek
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminDao adminDao;

    @Override
    public List<Admin> getAll() {
        return adminDao.getAll();
    }

    @Override
    public Admin getAdmin(String login) {
        return adminDao.getAdmin(login);
    }
    
    @Override
    public Admin loginAdmin(String login, String haslo) {
        Admin admin = this.getAdmin(login);
        if (admin != null && admin.getHaslo().equals(haslo)) {
            return admin;
        }
        return null;
    }
}
