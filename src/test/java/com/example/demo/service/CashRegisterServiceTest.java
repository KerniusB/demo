package com.example.demo.service;

import com.example.demo.model.Action;
import com.example.demo.model.CashRegister;
import com.example.demo.repository.ActionRepository;
import com.example.demo.repository.CashRegisterRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CashRegisterServiceTest {

    @Mock
    CashRegisterRepository cashRegisterRepository;

    @InjectMocks
    CashRegisterService cashRegisterService;

    @Mock
    ActionRepository actionRepository;

    @InjectMocks
    ActionService actionService;

    @Test
    void add() {
        CashRegister cashRegister = CashRegister.builder()
                .name("lidl")
                .build();

        when(cashRegisterRepository.save(Mockito.any(CashRegister.class))).thenReturn(cashRegister);
        CashRegister cashRegister2 = cashRegisterService.add(cashRegister);
        verify(cashRegisterRepository).save(Mockito.any(CashRegister.class));
        assertNotNull(cashRegister2);
    }

    @Test
    void update() {
        CashRegister cashRegister = CashRegister.builder()
                .name("lidl")
                .build();

        cashRegisterService.update(cashRegister);
        verify(cashRegisterRepository).save(Mockito.any(CashRegister.class));
    }

    @Test
    void deleteById() {
        cashRegisterService.deleteById(1L);
        verify(cashRegisterRepository).deleteById(Mockito.anyLong());
    }

    @Test
    void findAll() {
        CashRegister cashRegister = new CashRegister();
        List<CashRegister> cashRegisters = new ArrayList<>();
        cashRegisters.add(cashRegister);
        when(cashRegisterRepository.findAll()).thenReturn(cashRegisters);
        Iterable<CashRegister> found = cashRegisterService.findAll();
        verify(cashRegisterRepository).findAll();
        assertEquals(1, StreamSupport.stream(found.spliterator(), false).count());
    }

    @Test
    void findById() {
        CashRegister cashRegister = CashRegister.builder()
                .name("lidl")
                .build();
        when(cashRegisterRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(cashRegister)); // static method when daromas tada, kai metodas returnina reiksme
        CashRegister found = cashRegisterService.findById(1L);
        verify(cashRegisterRepository).findById(Mockito.anyLong());
        assertNotNull(found);
    }
}