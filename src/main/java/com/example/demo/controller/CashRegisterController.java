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
public class CashRegisterController {

    @Autowired
    private CashRegisterService cashRegisterService;

    //@RequestMapping(value = "/", method= RequestMethod.GET)
    @GetMapping("/cashRegister")
    public String getIt(ModelMap model) {
        model.put("cashRegisters", cashRegisterService.findAll());
        return "cashRegister"; // view resolver /WEB-INF/jsp/welcome.jsp
    }

    @GetMapping("/add-cashRegister")
    public String showAddPage(ModelMap model) {
        model.addAttribute("cashRegister", new CashRegister());
        return "add-cashRegister";
    }

    @PostMapping("/add-cashRegister")
    public String add(ModelMap model, @ModelAttribute("cashRegister") CashRegister cashRegister, BindingResult result) {
        if (result.hasErrors()) {
            return "add-cashRegister";
        }
        cashRegisterService.add(cashRegister);
        return "redirect:/cashRegister";
    }

    @GetMapping("/update-cashRegister/{id}")
    public String showUpdatePage(ModelMap model, @PathVariable long id) {
        model.addAttribute("cashRegister", cashRegisterService.findById(id));
        return "add-cashRegister";
    }

    @PostMapping("/update-cashRegister/{id}")
    public String update(ModelMap model, @ModelAttribute("cashRegister") CashRegister cashRegister, BindingResult result) {
        if (result.hasErrors()) {
            return "add-cashRegister";
        }
        cashRegisterService.update(cashRegister);
        return "redirect:/cashRegister";
    }

    @GetMapping("/delete-cashRegister/{id}")
    public String delete(@PathVariable long id) {
        cashRegisterService.deleteById(id);
        return "redirect:/cashRegister";
    }

}
