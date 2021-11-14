package com.example.demo.service;

import com.example.demo.model.CashRegister;
import com.example.demo.repository.CashRegisterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashRegisterService {

    private final CashRegisterRepository cashRegisterRepository;

    public CashRegisterService(CashRegisterRepository cashRegisterRepository) {
        this.cashRegisterRepository = cashRegisterRepository;
    }


    public CashRegister add(CashRegister cashRegister) {
        return cashRegisterRepository.save(cashRegister);
    }


    public CashRegister update(CashRegister cashRegister) {
        return cashRegisterRepository.save(cashRegister);
    }

    public void deleteById(Long id) {
        cashRegisterRepository.deleteById(id);
    }

    public List<CashRegister> findAll() {
        return cashRegisterRepository.findAll();
    }


    public CashRegister findById(Long id) {
        return cashRegisterRepository.findById(id).orElse(null);
    }

}
