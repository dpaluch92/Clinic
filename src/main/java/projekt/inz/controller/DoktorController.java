/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import projekt.inz.pojo.Doktor;
import projekt.inz.pojo.Pacjent;
import projekt.inz.pojo.Skrzynka;
import projekt.inz.service.DoktorService;
import projekt.inz.service.PacjentService;
import projekt.inz.service.SkrzynkaService;
import projekt.inz.service.WizytaService;

/**
 *
 * @author depek
 */
@Controller
public class DoktorController {

    @Autowired
    private DoktorService doktorService;

    @Autowired
    private WizytaService wizytaService;

    @Autowired
    private SkrzynkaService skrzynkaService;

    @Autowired
    private PacjentService pacjentService;

    @RequestMapping("/doktor")
    public String logged(HttpSession session, Model model) {
        Doktor logged = (Doktor) session.getAttribute("loggedInDoktor");
        model.addAttribute("doktor", session.getAttribute("loggedInDoktor"));
        model.addAttribute("wizytaList", wizytaService.getWizytaByIdDoktor(logged.getIdDoktor()));
        model.addAttribute("msgList", skrzynkaService.getAllByDoktor(logged.getIdDoktor()));
        model.addAttribute("pacjentList", pacjentService.getAll());
        return "doktor";
    }

    @RequestMapping(value = "/doktor.e", method = RequestMethod.POST)
    public String doDoktor(@ModelAttribute Doktor doktor, BindingResult result, @RequestParam String actionD, Model model) {
        Doktor doktorResult = new Doktor();

        switch (actionD.toLowerCase()) {
            case "edit":
                doktorService.edit(doktor);
                doktorResult = doktor;
                break;
        }
        model.addAttribute("wizytaList", wizytaService.getWizytaByIdDoktor(doktor.getIdDoktor()));
        model.addAttribute("doktor", doktorResult);
        return "doktor";
    }

    @RequestMapping(value = "/doktor.msg", method = RequestMethod.POST)
    public String doMsg(HttpSession session, Model model, String pacjentForm, String msg) {

        Doktor doktor = (Doktor) session.getAttribute("loggedInDoktor");
        Pacjent pacjent = pacjentService.getPacjent(Integer.parseInt(pacjentForm));

        Skrzynka newMsg = new Skrzynka(doktor, pacjent, msg);
        skrzynkaService.add(newMsg);
        model.addAttribute("wizytaList", wizytaService.getWizytaByIdDoktor(doktor.getIdDoktor()));
        model.addAttribute("doktor", doktor);
        model.addAttribute("msgList", skrzynkaService.getAllByDoktor(doktor.getIdDoktor()));
        return "doktor";
    }
}
