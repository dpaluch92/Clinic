/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import static org.hibernate.jpa.internal.EntityManagerImpl.LOG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import projekt.inz.pojo.Doktor;
import projekt.inz.pojo.Pacjent;
import projekt.inz.pojo.Uslugi;
import projekt.inz.pojo.Wizyta;
import projekt.inz.service.ArtykulService;
import projekt.inz.service.DoktorService;
import projekt.inz.service.PacjentService;
import projekt.inz.service.UslugiService;
import projekt.inz.service.WizytaService;

/**
 *
 * @author depek
 */
@Controller
public class MainController {

    @Autowired
    private ArtykulService artykulService;

    @Autowired
    private DoktorService doktorService;

    @Autowired
    private UslugiService uslugiService;

    @Autowired
    private PacjentService pacjentService;

    @Autowired
    private WizytaService wizytaService;

    @InitBinder
    public void bindingPreparation(WebDataBinder binder) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }

    @RequestMapping(value = "/")
    public String HelloWorld(Model model) {
        model.addAttribute("artList", artykulService.getAll());
        return "index";
    }

    @RequestMapping(value = "/terminy", method = RequestMethod.GET)
    public String getTerminy(Model model) {

        model.addAttribute("doktorList", doktorService.getAll());
        model.addAttribute("uslugiList", uslugiService.getAll());

        return "terminy";
    }

    @RequestMapping(value = "/terminy.do", method = RequestMethod.POST)
    public String postTerminy(Model model,
            String imie, String nazwisko, String login, String haslo, String email, String adres, String pesel,
            String doktorForm, String uslugiForm, Date terminWizyty) {

        Pacjent pacjent = new Pacjent(imie, nazwisko, login, haslo, email, adres, pesel);
        pacjentService.add(pacjent);

        Doktor doktor = doktorService.getDoktor(Integer.parseInt(doktorForm));
        Uslugi uslugi = uslugiService.getUslugi(Integer.parseInt(uslugiForm));
        LOG.info(terminWizyty.toString());

        Wizyta wizyta = new Wizyta(doktor, pacjent, uslugi, terminWizyty);
        wizytaService.add(wizyta);

        model.addAttribute("doktorList", doktorService.getAll());
        model.addAttribute("uslugiList", uslugiService.getAll());

        return "index";
    }

}
