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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import projekt.inz.dao.ReceptaDao;
import projekt.inz.pojo.Artykul;
import projekt.inz.pojo.Doktor;
import projekt.inz.pojo.KartaPacjenta;
import projekt.inz.pojo.Pacjent;
import projekt.inz.pojo.Recepta;
import projekt.inz.pojo.Skrzynka;
import projekt.inz.pojo.Uslugi;
import projekt.inz.pojo.Wizyta;
import projekt.inz.service.ArtykulService;
import projekt.inz.service.DoktorService;
import projekt.inz.service.KartaPacjentaService;
import projekt.inz.service.PacjentService;
import projekt.inz.service.SkrzynkaService;
import projekt.inz.service.UslugiService;
import projekt.inz.service.WizytaService;
import projekt.inz.util.ExportToPdf;

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

    @Autowired
    private ReceptaDao receptaDao;

    @Autowired
    private KartaPacjentaService kartaPacjentaService;

    @Autowired
    private UslugiService uslugiService;

    @Autowired
    private ArtykulService artykulService;

    @InitBinder
    public void bindingPreparation(WebDataBinder binder) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }

    @RequestMapping("/doktor")
    public String logged(HttpSession session, Model model) {

        Doktor doktor = (Doktor) session.getAttribute("loggedInDoktor");

        model.addAttribute("doktor", doktor);
        model.addAttribute("pacjentList", pacjentService.getAll());
        model.addAttribute("msgList", skrzynkaService.getAllByDoktor(doktor.getIdDoktor()));
        model.addAttribute("wizytaList", wizytaService.getWizytaByIdDoktor(doktor.getIdDoktor()));

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
        model.addAttribute("doktor", doktorResult);
        model.addAttribute("pacjentList", pacjentService.getAll());
        model.addAttribute("msgList", skrzynkaService.getAllByDoktor(doktor.getIdDoktor()));
        model.addAttribute("wizytaList", wizytaService.getWizytaByIdDoktor(doktor.getIdDoktor()));

        return "doktor";
    }

    @RequestMapping(value = "/doktor.msg", method = RequestMethod.POST)
    public String doMsg(HttpSession session, Model model, String pacjentForm, String msg) {

        Doktor doktor = (Doktor) session.getAttribute("loggedInDoktor");
        Pacjent pacjent = pacjentService.getPacjent(Integer.parseInt(pacjentForm));

        Skrzynka newMsg = new Skrzynka(doktor, pacjent, msg);
        skrzynkaService.add(newMsg);

        model.addAttribute("doktor", doktor);
        model.addAttribute("pacjentList", pacjentService.getAll());
        model.addAttribute("msgList", skrzynkaService.getAllByDoktor(doktor.getIdDoktor()));
        model.addAttribute("wizytaList", wizytaService.getWizytaByIdDoktor(doktor.getIdDoktor()));

        return "doktor";
    }

    @RequestMapping(value = "/doktor.recepta", method = RequestMethod.POST)
    public String doRecepta(HttpSession session, Model model, String pacjentForm, String przepisanieRecepty, Date dataWydania) {

        Doktor doktor = (Doktor) session.getAttribute("loggedInDoktor");
        Pacjent pacjent = pacjentService.getPacjent(Integer.parseInt(pacjentForm));
        LOG.info(dataWydania.toString());

        Recepta recepta = new Recepta(doktor, pacjent, przepisanieRecepty, dataWydania);
        receptaDao.add(recepta);

        ExportToPdf toPdf = new ExportToPdf();
        toPdf.export();

        model.addAttribute("doktor", doktor);
        model.addAttribute("pacjentList", pacjentService.getAll());
        model.addAttribute("msgList", skrzynkaService.getAllByDoktor(doktor.getIdDoktor()));
        model.addAttribute("wizytaList", wizytaService.getWizytaByIdDoktor(doktor.getIdDoktor()));

        return "doktor";
    }

    @RequestMapping(value = "/doktor.karta", method = RequestMethod.POST)
    public String doKarta(HttpSession session, Model model, String pacjentForm, Date terminWizyty, String uslugiForm, String historiaChoroby) {

        Doktor doktor = (Doktor) session.getAttribute("loggedInDoktor");
        Pacjent pacjent = pacjentService.getPacjent(Integer.parseInt(pacjentForm));
        Uslugi uslugi = uslugiService.getUslugi(Integer.parseInt(uslugiForm));
        LOG.info(terminWizyty.toString());

        Wizyta wizyta = new Wizyta(doktor, pacjent, uslugi, terminWizyty);
        wizytaService.add(wizyta);

        KartaPacjenta kartaPacjenta = new KartaPacjenta(pacjent, wizyta, historiaChoroby);
        kartaPacjentaService.add(kartaPacjenta);

        model.addAttribute("doktor", doktor);
        model.addAttribute("pacjentList", pacjentService.getAll());
        model.addAttribute("msgList", skrzynkaService.getAllByDoktor(doktor.getIdDoktor()));
        model.addAttribute("wizytaList", wizytaService.getWizytaByIdDoktor(doktor.getIdDoktor()));

        return "doktor";
    }

    @RequestMapping(value = "/doktor.art", method = RequestMethod.POST)
    public String doArtykul(HttpSession session, Model model, String tytul, String opis, Date dataDodania) {

        Doktor doktor = (Doktor) session.getAttribute("loggedInDoktor");
        LOG.info(dataDodania.toString());

        Artykul art = new Artykul(doktor, tytul, opis, dataDodania);
        artykulService.add(art);

        model.addAttribute("doktor", doktor);
        model.addAttribute("pacjentList", pacjentService.getAll());
        model.addAttribute("msgList", skrzynkaService.getAllByDoktor(doktor.getIdDoktor()));
        model.addAttribute("wizytaList", wizytaService.getWizytaByIdDoktor(doktor.getIdDoktor()));

        return "doktor";
    }
}
