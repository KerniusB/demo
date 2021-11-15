package com.example.demo.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ActionTest {

    @Test
    void testNewObject() {
        Action action = Action.builder()
                .inOut(100)
                .date("2020-01-01")
                .amount(123)
                .build();
        assertAll(() -> assertEquals(100, action.getInOut()),
                () -> assertEquals("2020-01-01", action.getDate()),
                () -> assertEquals(123, action.getAmount()));
    }
}