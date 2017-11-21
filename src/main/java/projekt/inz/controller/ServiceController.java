/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import projekt.inz.pojo.Uslugi;
import projekt.inz.service.UslugiService;

/**
 *
 * @author depek
 */
@Controller
public class ServiceController {
    
    @Autowired
    private UslugiService uslugiService;

    @RequestMapping("/cennik")
    public String mainMethod(Map<String, Object> map) {
        Uslugi uslugi = new Uslugi();

        map.put("uslugi", uslugi);
        map.put("uslugiList", uslugiService.getAll());

        return "uslugi";
    }
    
}
