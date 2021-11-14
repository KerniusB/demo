package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.CashRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashRegister")
public class CashRegisterResource {
    private final CashRegisterService cashRegisterService;

    public CashRegisterResource(CashRegisterService cashRegisterService) {
        this.cashRegisterService = cashRegisterService;
    }

    @PostMapping("/add")
    public ResponseEntity<User> addCashRegister(@RequestBody User user) {
        User newUser = cashRegisterService.add(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateCashRegister(@RequestBody User user) {
        User updateAction = cashRegisterService.update(user);
        return new ResponseEntity<>(updateAction, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCashRegister(@PathVariable("id") Long id) {
        cashRegisterService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllCashRegister () {
        List<User> user = cashRegisterService.findAll();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
