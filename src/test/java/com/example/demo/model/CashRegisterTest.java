package com.example.demo.model;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CashRegisterTest {

    @Test
    void testNewObject() {
        CashRegister cashRegister = CashRegister.builder()
                .name("maxima")
                .build();
        assertAll(() -> assertEquals("maxima", cashRegister.getName()));
    }
}