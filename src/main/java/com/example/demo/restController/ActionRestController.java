package com.example.demo.restController;

import com.example.demo.model.Action;
import com.example.demo.service.ActionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/action")
public class ActionRestController {
    private final ActionService cashRegisterService;

    public ActionRestController(ActionService cashRegisterService) {
        this.cashRegisterService = cashRegisterService;
    }

    @PostMapping("/add")
    public ResponseEntity<Action> addCashRegister(@RequestBody Action user) {
        Action newUser = cashRegisterService.add(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Action> updateCashRegister(@RequestBody Action user) {
        Action updateAction = cashRegisterService.update(user);
        return new ResponseEntity<>(updateAction, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCashRegister(@PathVariable("id") Long id) {
        cashRegisterService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Action>> getAllCashRegister () {
        List<Action> user = cashRegisterService.findAll();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
