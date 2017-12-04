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
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import projekt.inz.pojo.Doktor;
import projekt.inz.pojo.Pacjent;
import projekt.inz.service.DoktorService;

/**
 *
 * @author depek
 */
@Controller
public class DoktorController {

    @Autowired
    DoktorService doktorService;

    @RequestMapping("/doktor")
    public String logged(HttpSession session, Model model) {
        model.addAttribute("doktor", session.getAttribute("loggedInDoktor"));
        return "doktor";
    }

    @RequestMapping(value = "/doktor.e", method = RequestMethod.POST)
    public String doDoktor(@ModelAttribute Doktor doktor, BindingResult result, @RequestParam String actionD, Model model) {
        Doktor doktorResult = new Doktor();

        switch (actionD.toLowerCase()) {
            case "edit":
                doktorService.add(doktor);
                doktorResult = doktor;
                break;
        }
        model.addAttribute("doktor", doktorResult);
        return "doktor";
    }
}
