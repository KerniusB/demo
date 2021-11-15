package com.example.demo.service;

import com.example.demo.model.Action;
import com.example.demo.repository.ActionRepository;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ActionServiceTest {

    @Mock
    ActionRepository actionRepository;

    @InjectMocks
    ActionService actionService;

    @Test
    void add() {
        Action action = Action.builder()
                .inOut(100)
                .date("2020-01-01")
                .amount(123)
                .build();

        when(actionRepository.save(Mockito.any(Action.class))).thenReturn(action);
        Action added2 = actionService.add(action);
        verify(actionRepository).save(Mockito.any(Action.class));
        assertNotNull(added2);
    }

    @Test
    void update() {
        Action action = Action.builder()
                .inOut(100)
                .date("2020-01-01")
                .amount(123)
                .build();
        actionService.update(action);
        verify(actionRepository).save(Mockito.any(Action.class));
    }

    @Test
    void deleteById() {
        actionService.deleteById(1L);
        verify(actionRepository).deleteById(Mockito.anyLong());
    }

    @Test
    void findAll() {
        Action action = new Action();
        List<Action> actions = new ArrayList<>();
        actions.add(action);
        when(actionRepository.findAll()).thenReturn(actions);
        Iterable<Action> found = actionService.findAll();
        verify(actionRepository).findAll();
        assertEquals(1, StreamSupport.stream(found.spliterator(), false).count());
    }

    @Test
    void findById() {
        Action action = Action.builder()
                .inOut(100)
                .date("2020-01-01")
                .amount(123)
                .build();
        when(actionRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(action)); // static method when daromas tada, kai metodas returnina reiksme
        Action found = actionService.findById(1L);
        verify(actionRepository).findById(Mockito.anyLong());
        assertNotNull(found);
    }
}