/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author depek
 */
@Controller
public class AdminController {

    @RequestMapping("/admin")
    public String loggedAdmin() {
        return "admin";
    }
}
