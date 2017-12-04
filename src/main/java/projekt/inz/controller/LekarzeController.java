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
import projekt.inz.pojo.Doktor;
import projekt.inz.service.DoktorService;

/**
 *
 * @author depek
 */
@Controller
public class LekarzeController {
    @Autowired
    DoktorService doktorService;
    
    @RequestMapping("/lekarze")
    public String HelloWorld(Map<String, Object> map) {
        Doktor doktor = new Doktor();
        
        map.put("doktor", doktor);
        map.put("doktorList", doktorService.getAll());
        
        return "lekarze";
    }
}
