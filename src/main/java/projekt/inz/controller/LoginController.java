/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import projekt.inz.pojo.Admin;
import projekt.inz.pojo.Doktor;
import projekt.inz.pojo.Pacjent;
import projekt.inz.service.AdminService;
import projekt.inz.service.DoktorService;
import projekt.inz.service.PacjentService;

/**
 *
 * @author depek
 */
@Controller
public class LoginController {

    @Autowired
    PacjentService pacjentService;

    @Autowired
    DoktorService doktorService;
    
    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String showLoginForm() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String verifyLogin(@RequestParam String login, @RequestParam String haslo, HttpSession session, Model model) {
        
        Pacjent pacjent = pacjentService.loginPacjent(login,haslo);
        Doktor doktor = doktorService.loginDoktor(login,haslo);
        Admin admin = adminService.loginAdmin(login, haslo);

        if (pacjent != null) {
            session.setAttribute("loggedInPacjent", pacjent);
            return "redirect:/pacjent";
        } else if (doktor != null) {
            session.setAttribute("loggedInDoktor", doktor);
            return "redirect:/doktor";
        } else if (admin != null) {
            session.setAttribute("loggedInAdmin", admin);
            return "redirect:/admin";
        }

        model.addAttribute("loginError", "Error logging in");
        return "login";
    }
    
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("loggedInPacjent");
        session.removeAttribute("loggedInDoktor");
        session.removeAttribute("loggedInAdmin");
        return "login";
    }

}
