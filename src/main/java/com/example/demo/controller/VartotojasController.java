package com.example.demo.controller;

import com.example.demo.model.CashRegister;
import com.example.demo.service.CashRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VartotojasController {

    @Autowired
    private CashRegisterService cashRegisterService;

    //@RequestMapping(value = "/", method= RequestMethod.GET)
    @GetMapping("/vartotojas")
    public String getVartotojai(ModelMap model) {
        model.put("vartotojai", cashRegisterService.findAll());
        return "vartotojas"; // view resolver /WEB-INF/jsp/welcome.jsp
    }

    @GetMapping("/add-vartotojas")
    public String showAddPage(ModelMap model) {
        model.addAttribute("vartotojas", new CashRegister());
        return "add-vartotojas";
    }

    @PostMapping("/add-vartotojas")
    public String add(ModelMap model, @ModelAttribute("vartotojas") CashRegister vartotojas, BindingResult result) {
        if (result.hasErrors()) {
            return "add-vartotojas";
        }
        cashRegisterService.add(vartotojas);
        return "redirect:/vartotojas";
    }

    @GetMapping("/update-vartotojas/{id}")
    public String showUpdatePage(ModelMap model, @PathVariable long id) {
        model.addAttribute("vartotojas", cashRegisterService.findById(id));
        return "add-vartotojas";
    }

    @PostMapping("/update-vartotojas/{id}")
    public String update(ModelMap model, @ModelAttribute("vartotojas") CashRegister vartotojas, BindingResult result) {
        if (result.hasErrors()) {
            return "add-vartotojas";
        }
        cashRegisterService.update(vartotojas);
        return "redirect:/vartotojas";
    }

    @GetMapping("/delete-vartotojas/{id}")
    public String delete(@PathVariable long id) {
        cashRegisterService.deleteById(id);
        return "redirect:/vartotojas";
    }

}
