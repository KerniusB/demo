package com.example.demo.repository;

import com.example.demo.model.Action;
import com.example.demo.model.CashRegister;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CashRegisterRepositoryTest {

    @Autowired
    ActionRepository actionRepository;
    @Autowired
    CashRegisterRepository cashRegisterRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testSave() {
        CashRegister cashRegister = CashRegister.builder()
                .name("maxima")
                .build();
        cashRegisterRepository.save(cashRegister);

        CashRegister cashRegister2 = cashRegisterRepository.findById(cashRegister.getId()).orElse(null);
        assertNotNull(cashRegister2);
        assertEquals(cashRegister, cashRegister2);
    }

    @Test
    public void testFindAll() {
        CashRegister cashRegister = CashRegister.builder()
                .name("maxima")
                .build();
        cashRegisterRepository.save(cashRegister);

        CashRegister cashRegister2 = CashRegister.builder()
                .name("maxima")
                .build();
        cashRegisterRepository.save(cashRegister2);

        Iterable<CashRegister> cashRegisters = cashRegisterRepository.findAll();
        assertNotNull(cashRegisters);
        List<CashRegister> result = new ArrayList<>();
        cashRegisters.forEach(result::add);
        assertEquals(2, result.size());
    }

    @Test
    public void testDelete() {
        CashRegister cashRegister = CashRegister.builder()
                .name("maxima")
                .build();
        cashRegisterRepository.save(cashRegister);

        cashRegisterRepository.delete(cashRegister);

        Iterable<CashRegister> cashRegisters = cashRegisterRepository.findAll();
        List<CashRegister> result = new ArrayList<>();
        cashRegisters.forEach(result::add);
        assertEquals(0, result.size());
    }

    @Test
    void testDeleteById() {
        CashRegister cashRegister = CashRegister.builder()
                .name("maxima")
                .build();
        cashRegisterRepository.save(cashRegister);

        CashRegister cashRegister2 = CashRegister.builder()
                .name("lidl")
                .build();
        cashRegisterRepository.save(cashRegister2);

        Iterable<CashRegister> cashRegisters = cashRegisterRepository.findAll();
        List<CashRegister> result = new ArrayList<>();
        cashRegisters.forEach(result::add);
        assertEquals(2, result.size());

        cashRegisterRepository.deleteById(cashRegister.getId());

        Iterable<CashRegister> cashRegisters2 = cashRegisterRepository.findAll();
        List<CashRegister> result2 = new ArrayList<>();
        cashRegisters2.forEach(result2::add);
        assertEquals(1, result2.size());
    }

}