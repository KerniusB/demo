package com.example.demo.repository;

import com.example.demo.model.Action;
import com.example.demo.model.CashRegister;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.DirtiesContext;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ActionRepositoryTest {

    @Autowired
    ActionRepository actionRepository;
    @Autowired
    CashRegisterRepository cashRegisterRepository;
    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void testSave() {
        Action action = Action.builder()
                .inOut(100)
                .date("2020-01-01")
                .amount(123)
                .build();
        actionRepository.save(action);

        Action action2 = actionRepository.findById(action.getId()).orElse(null);
        assertNotNull(action2);
        assertEquals(action, action2);
    }

    @Test
    public void testFindAll() {
        Action action = Action.builder()
                .inOut(100)
                .date("2020-01-01")
                .amount(123)
                .build();
        actionRepository.save(action);

        Action action2 = Action.builder()
                .inOut(101)
                .date("2020-01-02")
                .amount(1234)
                .build();
        actionRepository.save(action2);

        Iterable<Action> actions = actionRepository.findAll();
        assertNotNull(actions);
        List<Action> result = new ArrayList<>();
        actions.forEach(result::add);
        assertEquals(2, result.size());
    }

    @Test
    public void testDelete() {
        Action action = Action.builder()
                .inOut(100)
                .date("2020-01-01")
                .amount(123)
                .build();
        actionRepository.save(action);

        actionRepository.delete(action);

        Iterable<Action> vartotojai = actionRepository.findAll();
        List<Action> result = new ArrayList<>();
        vartotojai.forEach(result::add);
        assertEquals(0, result.size());
    }

    @Test
    void testDeleteById() {
        Action action = Action.builder()
                .inOut(100)
                .date("2020-01-01")
                .amount(123)
                .build();
        actionRepository.save(action);

        Action action2 = Action.builder()
                .inOut(101)
                .date("2020-01-02")
                .amount(1234)
                .build();
        actionRepository.save(action2);

        Iterable<Action> actions = actionRepository.findAll();
        List<Action> result = new ArrayList<>();
        actions.forEach(result::add);
        assertEquals(2, result.size());

        actionRepository.deleteById(action.getId());
        Iterable<Action> actions2 = actionRepository.findAll();
        List<Action> result2 = new ArrayList<>();
        actions2.forEach(result2::add);
        assertEquals(1, result2.size());
    }

}