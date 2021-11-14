package com.example.demo.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UserTest {

    @Test
    void testUserConstructor()
    {
        User user = new User(1L, "Name", "LastName", "+37061111111", "email@gmail.com", "Address", "Password");
        assertAll("Test PhoneNumber constructor",
                () -> assertEquals(1L, user.getId()),
                () -> assertEquals("Name", user.getName()),
                () -> assertEquals("LastName", user.getLastName()),
                () -> assertEquals("+37061111111", user.getTelNr()),
                () -> assertEquals("email@gmail.com", user.getEmail()),
                () -> assertEquals("Address", user.getAddress()),
                () -> assertEquals("Password", user.getPassword())
        );
    }

    @Test
    void setGetId() {
        User user = new User();
        user.setId(1L);
        assertTrue(user.getId().equals(1L));
    }

    @Test
    void setGetName() {
        User user = new User();
        user.setName("testName");
        assertTrue(user.getName().equals("testName"));
    }

    @Test
    void setGetLastName() {
        User user = new User();
        user.setLastName("testName");
        assertTrue(user.getLastName().equals("testName"));
    }

    @Test
    void setGetTelNr() {
        User user = new User();
        user.setTelNr("+37061111111");
        assertTrue(user.getTelNr().equals("+37061111111"));
    }

    @Test
    void setGetEmail() {
        User user = new User();
        user.setEmail("email@gmail.com");
        assertTrue(user.getEmail().equals("email@gmail.com"));
    }

    @Test
    void setGetAddress() {
        User user = new User();
        user.setAddress("Gatviūnų 6-2");
        assertTrue(user.getAddress().equals("Gatviūnų 6-2"));
    }

    @Test
    void setGetPassword() {
        User user = new User();
        user.setPassword("Password123");
        assertTrue(user.getPassword().equals("Password123"));
    }
}