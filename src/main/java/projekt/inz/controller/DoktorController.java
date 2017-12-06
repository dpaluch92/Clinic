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
import projekt.inz.service.DoktorService;
import projekt.inz.service.WizytaService;

/**
 *
 * @author depek
 */
@Controller
public class DoktorController {

    @Autowired
    DoktorService doktorService;
    
    @Autowired
    WizytaService wizytaService;

    @RequestMapping("/doktor")
    public String logged(HttpSession session, Model model) {
        Doktor logged = (Doktor) session.getAttribute("loggedInDoktor");
        model.addAttribute("doktor", session.getAttribute("loggedInDoktor"));
        model.addAttribute("wizytaList", wizytaService.getWizytaByIdDoktor(logged.getIdDoktor()));
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
}
