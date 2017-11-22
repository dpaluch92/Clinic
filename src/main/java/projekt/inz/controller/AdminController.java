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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import projekt.inz.pojo.Doktor;
import projekt.inz.pojo.Pacjent;
import projekt.inz.pojo.Rejestracja;
import projekt.inz.service.DoktorService;
import projekt.inz.service.PacjentService;
import projekt.inz.service.RejestracjaService;

/**
 *
 * @author depek
 */
@Controller
public class AdminController {
    
    @Autowired
    PacjentService pacjentService;
    
    @Autowired
    DoktorService doktorService;

    @RequestMapping("/admin")
    public String loggedAdmin() {
        return "admin";
    }
    
    @RequestMapping(value = "/admin.p", method = RequestMethod.POST)
    public String doPacjent(@ModelAttribute Pacjent pacjent, BindingResult result, @RequestParam String action, Map<String, Object> map) {
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
    
    @RequestMapping(value = "/admin.d", method = RequestMethod.POST)
    public String doDoktor(@ModelAttribute Doktor doktor, BindingResult result, @RequestParam String action, Map<String, Object> map) {
        Doktor doktorResult = new Doktor();

        switch (action.toLowerCase()) {
            case "add":
                doktorService.add(doktor);
                doktorResult = doktor;
                break;
            case "edit":
                doktorService.edit(doktor);
                doktorResult = doktor;
                break;
            case "delete":
                doktorService.delete(doktorResult.getIdDoktor());
                doktorResult = new Doktor();
                break;
            case "search":
                Doktor searchedDoktor = doktorService.getDoktor(doktor.getIdDoktor());
                doktorResult = searchedDoktor != null ? searchedDoktor : new Doktor();
                break;
        }
        map.put("pacjent", doktorResult);
        map.put("pacjentList", pacjentService.getAll());
        return "pacjent";
    }
}
