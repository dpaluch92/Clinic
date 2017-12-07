/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.controller;

import java.util.Map;
import javax.servlet.http.HttpSession;
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

    @Autowired
    RejestracjaService rejestracjaService;

    @RequestMapping("/admin")
    public String loggedAdmin(HttpSession session, Map<String, Object> map) {

        map.put("pacjent", new Pacjent());
        map.put("pacjentList", pacjentService.getAll());
        map.put("admin", session.getAttribute("loggedInAdmin"));
        map.put("doktor", new Doktor());
        map.put("doktorList", doktorService.getAll());

        map.put("rejestracja", new Rejestracja());
        map.put("rejestracjaList", rejestracjaService.getAll());
        return "admin";
    }

    @RequestMapping(value = "/admin.p", method = RequestMethod.POST)
    public String doPacjent(HttpSession session, @ModelAttribute Pacjent pacjent, BindingResult result, @RequestParam String actionP, Map<String, Object> map) {
        Pacjent pacjentResult = new Pacjent();

        switch (actionP.toLowerCase()) {
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
        map.put("admin", session.getAttribute("loggedInAdmin"));
        map.put("doktor", new Doktor());
        map.put("doktorList", doktorService.getAll());

        map.put("rejestracja", new Rejestracja());
        map.put("rejestracjaList", rejestracjaService.getAll());

        return "admin";
    }

    @RequestMapping(value = "/admin.d", method = RequestMethod.POST)
    public String doDoktor(HttpSession session, @ModelAttribute Doktor doktor, BindingResult result, @RequestParam String actionD, Map<String, Object> map) {
        Doktor doktorResult = new Doktor();

        switch (actionD.toLowerCase()) {
            case "add":
                doktorService.add(doktor);
                doktorResult = doktor;
                break;
            case "edit":
                doktorService.edit(doktor);
                doktorResult = doktor;
                break;
            case "delete":
                doktorService.delete(doktor.getIdDoktor());
                doktorResult = new Doktor();
                break;
            case "search":
                Doktor searchedDoktor = doktorService.getDoktor(doktor.getIdDoktor());
                doktorResult = searchedDoktor != null ? searchedDoktor : new Doktor();
                break;
        }
        map.put("pacjent", new Pacjent());
        map.put("pacjentList", pacjentService.getAll());
        map.put("admin", session.getAttribute("loggedInAdmin"));
        map.put("doktor", doktorResult);
        map.put("doktorList", doktorService.getAll());

        map.put("rejestracja", new Rejestracja());
        map.put("rejestracjaList", rejestracjaService.getAll());
        return "admin";
    }

    @RequestMapping(value = "/admin.r", method = RequestMethod.POST)
    public String doRejestracja(HttpSession session, @ModelAttribute Rejestracja rejestracja, BindingResult result, @RequestParam String actionR, Map<String, Object> map) {
        Rejestracja rejestracjaResult = new Rejestracja();

        switch (actionR.toLowerCase()) {
            case "add":
                rejestracjaService.add(rejestracja);
                rejestracjaResult = rejestracja;
                break;
            case "edit":
                rejestracjaService.edit(rejestracja);
                rejestracjaResult = rejestracja;
                break;
            case "delete":
                rejestracjaService.delete(rejestracjaResult.getIdRejestracji());
                rejestracjaResult = new Rejestracja();
                break;
            case "search":
                Rejestracja searchedRejestracja = rejestracjaService.getRejestracja(rejestracja.getIdRejestracji());
                rejestracjaResult = searchedRejestracja != null ? searchedRejestracja : new Rejestracja();
                break;
        }
        map.put("pacjent", new Pacjent());
        map.put("pacjentList", pacjentService.getAll());
        map.put("admin", session.getAttribute("loggedInAdmin"));
        map.put("doktor", new Doktor());
        map.put("doktorList", doktorService.getAll());

        map.put("rejestracja", rejestracjaResult);
        map.put("rejestracjaList", rejestracjaService.getAll());
        return "admin";
    }
}
