package projekt.inz.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import projekt.inz.pojo.Pacjent;
import projekt.inz.service.PacjentService;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
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
    private WizytaService wizytaService;

    @Autowired
    private DoktorService doktorService;

    @RequestMapping(value = "/pacjent", method = RequestMethod.GET)
    public String setupForm(HttpSession session, Model model) {
        
        model.addAttribute("doktorList", doktorService.getAll());
        return "pacjent";
    }

    @RequestMapping(value = "/pacjent.w", method = RequestMethod.POST)
    public String doWizyta(HttpSession session, Model model, String doktorForm, String uwagi, Date terminWizyty) {
        
        Pacjent pacjent = (Pacjent) session.getAttribute("loggedInPacjent");
        Doktor doktor = doktorService.getDoktor(Integer.parseInt(doktorForm));
        
        Wizyta wizyta = new Wizyta(pacjent, doktor, terminWizyty, uwagi);
        model.addAttribute("doktorList", doktorService.getAll());
        return "pacjent";
    }
}
