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
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import projekt.inz.pojo.Doktor;
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

    @RequestMapping(value = "/pacjent", method = RequestMethod.GET)
    public String setupForm(HttpSession session, Model model) {

        model.addAttribute("pacjent", session.getAttribute("loggedInPacjent"));
        model.addAttribute("doktorList", doktorService.getAll());
        model.addAttribute("selectedDoktor", new Doktor());
        model.addAttribute("selectedPacjent", new Pacjent());
        return "pacjent";
    }

    @RequestMapping(value = "/pacjent.do", method = RequestMethod.POST)
    public String doActions(@ModelAttribute Pacjent pacjent, BindingResult result, @RequestParam String action, Model model) {
        Pacjent pacjentResult = new Pacjent();

        switch (action.toLowerCase()) {
            case "edit":
                pacjentService.edit(pacjent);
                pacjentResult = pacjent;
                break;
        }
        model.addAttribute("pacjent", pacjentResult);
        model.addAttribute("doktorList", doktorService.getAll());
        model.addAttribute("selectedDoktor", new Doktor());
        model.addAttribute("selectedPacjent", new Pacjent());
        return "pacjent";
    }

    @RequestMapping(value = "/pacjent.w", method = RequestMethod.POST)
    public String doWizyta(HttpSession session, Model model,
            @ModelAttribute("selectedDoktor") Doktor selectedDoktor,
            @ModelAttribute("selectedUser") Pacjent selectedPacjent,
            @RequestParam String actionW) {

        model.addAttribute("pacjent", session.getAttribute("loggedInPacjent"));
        model.addAttribute("doktorList", doktorService.getAll());

        selectedPacjent = (Pacjent) session.getAttribute("loggedInPacjent");
        selectedDoktor = doktorService.getDoktor(selectedDoktor.getIdDoktor());

        switch (actionW.toLowerCase()) {
            case "add":
                Wizyta wizyta = new Wizyta(selectedPacjent, selectedDoktor, null, "cos tam");
                wizytaService.add(wizyta);
                break;
        }
        return "pacjent";
    }
}
