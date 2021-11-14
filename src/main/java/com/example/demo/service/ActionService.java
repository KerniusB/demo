package com.example.demo.service;


import com.example.demo.model.Action;
import com.example.demo.repository.ActionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActionService {

    private final ActionRepository actionRepository;

    public ActionService(ActionRepository actionRepository) {
        this.actionRepository = actionRepository;
    }


    public Action add(Action action) {
        return actionRepository.save(action);
    }


    public Action update(Action action) {
        return actionRepository.save(action);
    }

    public void deleteById(Long id) {
        actionRepository.deleteById(id);
    }

    public List<Action> findAll() {
        return actionRepository.findAll();
    }

    public Action findById(Long id) {
        return actionRepository.findById(id).orElse(null);
    }

}
