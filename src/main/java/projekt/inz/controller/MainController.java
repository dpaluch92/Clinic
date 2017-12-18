/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import projekt.inz.service.ArtykulService;

/**
 *
 * @author depek
 */
@Controller
public class MainController {

    @Autowired
    private ArtykulService artykulService;

    @RequestMapping(value = "/")
    public String HelloWorld(Model model) {
        model.addAttribute("artList", artykulService.getAll());
        return "index";
    }
}
