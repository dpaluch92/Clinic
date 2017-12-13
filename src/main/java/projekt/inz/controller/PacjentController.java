package projekt.inz.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import projekt.inz.pojo.Pacjent;
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
import projekt.inz.pojo.Doktor;
import projekt.inz.pojo.Skrzynka;
import projekt.inz.pojo.Uslugi;
import projekt.inz.pojo.Wizyta;
import projekt.inz.service.DoktorService;
import projekt.inz.service.PacjentService;
import projekt.inz.service.SkrzynkaService;
import projekt.inz.service.UslugiService;
import projekt.inz.service.WizytaService;

/**
 *
 * @author depek
 */
@Controller
public class PacjentController {

    @Autowired
    private WizytaService wizytaService;

    @Autowired
    private DoktorService doktorService;

    @Autowired
    private PacjentService pacjentService;

    @Autowired
    private UslugiService uslugiService;

    @Autowired
    private SkrzynkaService skrzynkaService;

    @InitBinder
    public void bindingPreparation(WebDataBinder binder) {

        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, orderDateEditor);
    }

    @RequestMapping(value = "/pacjent", method = RequestMethod.GET)
    public String setupForm(HttpSession session, Model model) {

        Pacjent logged = (Pacjent) session.getAttribute("loggedInPacjent");

        model.addAttribute("pacjent", session.getAttribute("loggedInPacjent"));
        model.addAttribute("doktorList", doktorService.getAll());
        model.addAttribute("uslugiList", uslugiService.getAll());
        model.addAttribute("msgList", skrzynkaService.getAllByPacjent(logged.getIdPacjenta()));

        return "pacjent";
    }

    @RequestMapping(value = "/pacjent.e", method = RequestMethod.POST)
    public String doPacjent(@ModelAttribute Pacjent pacjent, BindingResult result, @RequestParam String actionP, Model model) {

        Pacjent pacjentResult = new Pacjent();

        switch (actionP.toLowerCase()) {
            case "edit":
                pacjentService.edit(pacjent);
                pacjentResult = pacjent;
                break;
        }
        model.addAttribute("pacjent", pacjentResult);
        model.addAttribute("doktorList", doktorService.getAll());
        model.addAttribute("uslugiList", uslugiService.getAll());
        model.addAttribute("msgList", skrzynkaService.getAll());

        return "pacjent";
    }

    @RequestMapping(value = "/pacjent.w", method = RequestMethod.POST)
    public String doWizyta(HttpSession session, Model model, String doktorForm, Date terminWizyty, String uslugiForm) {

        Pacjent pacjent = (Pacjent) session.getAttribute("loggedInPacjent");
        Doktor doktor = doktorService.getDoktor(Integer.parseInt(doktorForm));
        Uslugi uslugi = uslugiService.getUslugi(Integer.parseInt(uslugiForm));
        LOG.info(terminWizyty.toString());

        Wizyta wizyta = new Wizyta(doktor, pacjent, uslugi, terminWizyty);
        wizytaService.add(wizyta);

        model.addAttribute("doktorList", doktorService.getAll());
        model.addAttribute("uslugiList", uslugiService.getAll());
        model.addAttribute("msgList", skrzynkaService.getAll());
        model.addAttribute("pacjent", session.getAttribute("loggedInPacjent"));

        return "pacjent";
    }

    @RequestMapping(value = "/pacjent.msg", method = RequestMethod.POST)
    public String doMsg(HttpSession session, Model model, String doktorForm, String msg) {
        
        Pacjent pacjent = (Pacjent) session.getAttribute("loggedInPacjent");
        Doktor doktor = doktorService.getDoktor(Integer.parseInt(doktorForm));

        Skrzynka newMsg = new Skrzynka(doktor, pacjent, msg);
        skrzynkaService.add(newMsg);

        model.addAttribute("doktorList", doktorService.getAll());
        model.addAttribute("uslugiList", uslugiService.getAll());
        model.addAttribute("msgList", skrzynkaService.getAll());
        model.addAttribute("pacjent", session.getAttribute("loggedInPacjent"));

        return "pacjent";
    }
}
