package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.CashRegisterService;
import com.example.demo.validators.EmailValidator.EmailValidator;
import com.example.demo.validators.PasswordChecker.Validators.*;
import com.example.demo.validators.PhoneValidator.PhoneValidator;
import com.example.demo.validators.PhoneValidator.TelephoneNumberFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
public class VartotojasController {


    private EmailValidator emailValidator = new EmailValidator();
    private List<String> forbiddenSymbols = Arrays.asList("!", "?");
    private List<String> domainAndTLD = Arrays.asList("gmail.com", "yahoo.com");

    private PhoneValidator phoneValidator = new PhoneValidator();
    private TelephoneNumberFormat tf = new TelephoneNumberFormat(8, "+370", "8");

    private PasswordChecker passwordChecker = new PasswordChecker();
    private LengthValidator lengthValidator = new LengthValidator(10);
    private SpecialCharacterValidator specialCharacterValidator = new SpecialCharacterValidator("!?");
    private UpperCaseValidator upperCaseValidator = new UpperCaseValidator();

    @Autowired
    private CashRegisterService vartotojasService;

    //@RequestMapping(value = "/", method= RequestMethod.GET)
    @GetMapping("/vartotojas")
    public String getVartotojai(ModelMap model) {
        model.put("vartotojai", vartotojasService.findAll());
        return "vartotojas"; // view resolver /WEB-INF/jsp/welcome.jsp
    }

    @GetMapping("/add-vartotojas")
    public String showAddPage(ModelMap model) {
        model.addAttribute("vartotojas", new User());
        return "add-vartotojas";
    }

    @PostMapping("/add-vartotojas")
    public String add(ModelMap model, @ModelAttribute("vartotojas") User vartotojas, BindingResult result) {
        if (!emailValidator.isValid(vartotojas.getEmail(), forbiddenSymbols, domainAndTLD)) {
            model.addAttribute("errorMessage", "Not valid email input!");
            return "add-vartotojas";
        }
        phoneValidator.addFormat("LT", tf);
        if (!phoneValidator.isValid("LT" ,vartotojas.getTelNr())) {
            model.addAttribute("errorMessage", "Not valid phone input!");
            return "add-vartotojas";
        }
        passwordChecker.addValidator(lengthValidator);
        passwordChecker.addValidator(specialCharacterValidator);
        passwordChecker.addValidator(upperCaseValidator);
        if(!passwordChecker.isValid(vartotojas.getPassword())){
            model.addAttribute("errorMessage", "Not valid password input!");
            return "add-vartotojas";
        }
        vartotojasService.add(vartotojas);
        return "redirect:/vartotojas";
    }

    @GetMapping("/update-vartotojas/{id}")
    public String showUpdatePage(ModelMap model, @PathVariable long id) {
        model.addAttribute("vartotojas", vartotojasService.findById(id));
        return "add-vartotojas";
    }

    @PostMapping("/update-vartotojas/{id}")
    public String update(ModelMap model, @ModelAttribute("vartotojas") User vartotojas, BindingResult result) {
        if (result.hasErrors()) {
            return "add-vartotojas";
        }
        if (!emailValidator.isValid(vartotojas.getEmail(), forbiddenSymbols, domainAndTLD)) {
            model.addAttribute("errorMessage", "Not valid email input!");
            return "add-vartotojas";
        }
        phoneValidator.addFormat("LT", tf);
        if (!phoneValidator.isValid("LT", vartotojas.getTelNr())) {
            model.addAttribute("errorMessage", "Not valid phone input!");
            return "add-vartotojas";
        }
        passwordChecker.addValidator(lengthValidator);
        passwordChecker.addValidator(specialCharacterValidator);
        passwordChecker.addValidator(upperCaseValidator);
        if(!passwordChecker.isValid(vartotojas.getPassword())){
            model.addAttribute("errorMessage", "Not valid password input!");
            return "add-vartotojas";
        }
        vartotojasService.update(vartotojas);
        return "redirect:/vartotojas";
    }

    @GetMapping("/delete-vartotojas/{id}")
    public String delete(@PathVariable long id) {
        vartotojasService.deleteById(id);
        return "redirect:/vartotojas";
    }

}
