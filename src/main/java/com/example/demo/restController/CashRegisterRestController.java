package com.example.demo.restController;

import com.example.demo.model.CashRegister;
import com.example.demo.service.CashRegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cashRegister")
public class CashRegisterRestController {
    private final CashRegisterService cashRegisterService;

    public CashRegisterRestController(CashRegisterService cashRegisterService) {
        this.cashRegisterService = cashRegisterService;
    }

    @PostMapping("/add")
    public ResponseEntity<CashRegister> addCashRegister(@RequestBody CashRegister user) {
        CashRegister newUser = cashRegisterService.add(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<CashRegister> updateCashRegister(@RequestBody CashRegister user) {
        CashRegister updateAction = cashRegisterService.update(user);
        return new ResponseEntity<>(updateAction, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteCashRegister(@PathVariable("id") Long id) {
        cashRegisterService.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CashRegister>> getAllCashRegister () {
        List<CashRegister> user = cashRegisterService.findAll();
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
