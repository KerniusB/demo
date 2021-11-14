package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CashRegisterService {

    private final UserRepository userRepository;

    public CashRegisterService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User add(User user) {
        return userRepository.save(user);
    }


    public User update(User user) {
        return userRepository.save(user);
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }


    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

}
