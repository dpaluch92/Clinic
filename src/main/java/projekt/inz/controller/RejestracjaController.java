/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projekt.inz.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpSession;
import static org.hibernate.jpa.internal.EntityManagerImpl.LOG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import projekt.inz.pojo.Doktor;
import projekt.inz.pojo.Pacjent;
import projekt.inz.pojo.Rejestracja;
import projekt.inz.pojo.Uslugi;
import projekt.inz.pojo.Wizyta;
import projekt.inz.service.DoktorService;
import projekt.inz.service.PacjentService;
import projekt.inz.service.RejestracjaService;
import projekt.inz.service.UslugiService;
import projekt.inz.service.WizytaService;

/**
 *
 * @author depek
 */
@Controller
public class RejestracjaController {

    @Autowired
    private RejestracjaService rejestracjaService;

    @Autowired
    private DoktorService doktorService;

    @Autowired
    private PacjentService pacjentService;

    @Autowired
    private WizytaService wizytaService;

    @Autowired
    private UslugiService uslugiService;

    @InitBinder
    public void bindingPreparation(WebDataBinder binder) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }

    @RequestMapping("/rejestracja")
    public String loggedRejestracja(HttpSession session, Model model) {

        model.addAttribute("rejestracja", session.getAttribute("loggedInRejestracja"));
        model.addAttribute("doktorList", doktorService.getAll());
        model.addAttribute("pacjentList", pacjentService.getAll());
        model.addAttribute("uslugiList", uslugiService.getAll());
        model.addAttribute("wizytaList", wizytaService.getAll());

        return "rejestracja";
    }

    @RequestMapping("/rejestracja.e")
    public String doDoktor(@ModelAttribute Rejestracja rejestracja, BindingResult result, @RequestParam String actionR, Model model) {

        Rejestracja rejestracjaResult = new Rejestracja();

        switch (actionR.toLowerCase()) {
            case "edit":
                rejestracjaService.edit(rejestracja);
                rejestracjaResult = rejestracja;
                break;
        }

        model.addAttribute("rejestracja", rejestracjaResult);
        model.addAttribute("doktorList", doktorService.getAll());
        model.addAttribute("pacjentList", pacjentService.getAll());
        model.addAttribute("uslugiList", uslugiService.getAll());
        model.addAttribute("wizytaList", wizytaService.getAll());

        return "rejestracja";
    }

    @RequestMapping("/rejestracja.w")
    public String doWizyta(HttpSession session, Model model, String doktorForm, Date terminWizyty, String uslugiForm, String pacjentForm) {

        Pacjent pacjent = pacjentService.getPacjent(Integer.parseInt(pacjentForm));
        Doktor doktor = doktorService.getDoktor(Integer.parseInt(doktorForm));
        Uslugi uslugi = uslugiService.getUslugi(Integer.parseInt(uslugiForm));
        LOG.info(terminWizyty.toString());

        Wizyta wizyta = new Wizyta(doktor, pacjent, uslugi, terminWizyty);
        wizytaService.add(wizyta);

        model.addAttribute("rejestracja", session.getAttribute("loggedInRejestracja"));
        model.addAttribute("doktorList", doktorService.getAll());
        model.addAttribute("pacjentList", pacjentService.getAll());
        model.addAttribute("uslugiList", uslugiService.getAll());
        model.addAttribute("wizytaList", wizytaService.getAll());

        return "rejestracja";
    }
}
