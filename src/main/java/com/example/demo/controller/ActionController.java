package com.example.demo.controller;

import com.example.demo.model.Action;
import com.example.demo.service.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ActionController {

    @Autowired
    private ActionService actionService;

    //@RequestMapping(value = "/", method= RequestMethod.GET)
    @GetMapping("/action")
    public String getIt(ModelMap model) {
        model.put("actions", actionService.findAll());
        return "action"; // view resolver /WEB-INF/jsp/welcome.jsp
    }

    @GetMapping("/add-action")
    public String showAddPage(ModelMap model) {
        model.addAttribute("action", new Action());
        return "add-action";
    }

    @PostMapping("/add-action")
    public String add(ModelMap model, @ModelAttribute("action") Action action, BindingResult result) {
        if (result.hasErrors()) {
            return "add-action";
        }
        actionService.add(action);
        return "redirect:/action";
    }

    @GetMapping("/update-action/{id}")
    public String showUpdatePage(ModelMap model, @PathVariable long id) {
        model.addAttribute("action", actionService.findById(id));
        return "add-action";
    }

    @PostMapping("/update-action/{id}")
    public String update(ModelMap model, @ModelAttribute("action") Action action, BindingResult result) {
        if (result.hasErrors()) {
            return "add-action";
        }
        actionService.update(action);
        return "redirect:/action";
    }

    @GetMapping("/delete-action/{id}")
    public String delete(@PathVariable long id) {
        actionService.deleteById(id);
        return "redirect:/action";
    }

}
