/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.controller;

import projekt.inz.pojo.Pacjent;
import projekt.inz.service.PacjentService;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import projekt.inz.pojo.Wizyta;
import projekt.inz.service.DoktorService;
import projekt.inz.service.WizytaService;

/**
 *
 * @author depek
 */
@Controller
public class PacjentController {

    @Autowired
    private PacjentService pacjentService;

    @Autowired
    private WizytaService wizytaService;

    @Autowired
    private DoktorService doktorService;

    @RequestMapping("/pacjent")
    public String setupForm(HttpSession session, Map<String, Object> map) {

        map.put("pacjent", session.getAttribute("loggedInPacjent"));
        map.put("doktorList", doktorService.getAll());
        map.put("wizyta", new Wizyta());

        return "pacjent";
    }

    @RequestMapping(value = "/pacjent.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Pacjent pacjent, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        Pacjent pacjentResult = new Pacjent();

        switch (action.toLowerCase()) {
            case "edit":
                pacjentService.edit(pacjent);
                pacjentResult = pacjent;
                break;
        }
        map.put("pacjent", pacjentResult);
        map.put("doktorList", doktorService.getAll());
        map.put("wizyta", new Wizyta());
        return "pacjent";
    }

    @RequestMapping(value = "/pacjent.w", method = RequestMethod.POST)
    public String doWizyta(HttpSession session, @ModelAttribute Wizyta wizyta, BindingResult result, @RequestParam String actionW, Map<String, Object> map) {
        Wizyta wizytaResult = new Wizyta();

        switch (actionW.toLowerCase()) {
            case "add":
                wizytaService.add(wizyta);
                wizytaResult = wizyta;
                break;
        }
        map.put("wizyta", wizytaResult);
        map.put("doktorList", doktorService.getAll());
        map.put("pacjent", session.getAttribute("loggedInPacjent"));
        return "pacjent";
    }

}
