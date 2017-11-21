/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.controller;

import projekt.inz.pojo.Pacjent;
import projekt.inz.service.PacjentService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author depek
 */
@Controller
public class PacjentController {

    @Autowired
    private PacjentService pacjentService;

    @RequestMapping("/pacjent")
    public String setupForm(Map<String, Object> map) {
        Pacjent pacjent = new Pacjent();

        map.put("pacjent", pacjent);
        map.put("pacjentList", pacjentService.getAll());

        return "pacjent";
    }

    @RequestMapping(value = "/pacjent.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Pacjent pacjent, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        Pacjent pacjentResult = new Pacjent();

        switch (action.toLowerCase()) {
            case "add":
                pacjentService.add(pacjent);
                pacjentResult = pacjent;
                break;
            case "edit":
                pacjentService.edit(pacjent);
                pacjentResult = pacjent;
                break;
            case "delete":
                pacjentService.delete(pacjent.getIdPacjenta());
                pacjentResult = new Pacjent();
                break;
            case "search":
                Pacjent searchedPacjent = pacjentService.getPacjent(pacjent.getIdPacjenta());
                pacjentResult = searchedPacjent != null ? searchedPacjent : new Pacjent();
                break;
        }
        map.put("pacjent", pacjentResult);
        map.put("pacjentList", pacjentService.getAll());
        return "pacjent";
    }

}
