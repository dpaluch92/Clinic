/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.controller;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projekt.inz.pojo.Pacjent;
import projekt.inz.service.PacjentService;

/**
 *
 * @author depek
 */
@Controller
public class RegisterController {

    @Autowired
    private PacjentService pacjentService;

    @RequestMapping("/rejestracja")
    public String setupForm(Map<String, Object> map) {
        Pacjent pacjent = new Pacjent();

        map.put("pacjent", pacjent);
        return "rejestracja";
    }

    @RequestMapping("/rejestracja.s")
    public String doActions(@ModelAttribute Pacjent pacjent, BindingResult result, @RequestParam String akcja, Map<String, Object> map) {
        Pacjent pacjentResult = new Pacjent();

        switch (akcja.toLowerCase()) {
            case "zarejestruj":
                pacjentService.add(pacjent);
                pacjentResult = pacjent;
                break;
        }
        map.put("pacjent", pacjentResult);
        return "index";
    }
}
