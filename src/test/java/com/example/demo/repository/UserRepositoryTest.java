package com.example.demo.repository;

import com.example.demo.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
    @Autowired
    protected UserRepository userRepository;

    @Test
    public void save()
    {
        User user = new User("Vardas", "Pavarde", "+37066666666", "email@gmail.com", "Adreso gatve 5", "Slaptazodis!1");
        userRepository.save(user);
        User userById = userRepository.getById(user.getId());
        assertNotNull(userById);
        assertEquals(user, userById);
    }

    @Test
    public void delete()
    {
        User user = new User("Vardas", "Pavarde", "+37066666666", "email@gmail.com", "Adreso gatve 5", "Slaptazodis!1");
        userRepository.save(user);
        long id = user.getId();
        User userById = userRepository.getById(id);
        assertNotNull(userById);
        userRepository.deleteById(id);
        Iterable<User> listUsers = userRepository.findAll();
        List<User> result = StreamSupport.stream(listUsers.spliterator(), false).collect(Collectors.toList());
        assertEquals(0, result.size());
    }

    @Test
    public void findAll()
    {
        User user = new User("Vardas", "Pavarde", "+37066666666", "email@gmail.com", "Adreso gatve 5", "Slaptazodis!1");
        userRepository.save(user);
        User user2 = new User("Vardas", "Pavarde", "+37066666666", "email@gmail.com", "Adreso gatve 5", "Slaptazodis!1");
        userRepository.save(user2);
        Iterable<User> users = userRepository.findAll();
        assertNotNull(users);
        List<User> result = new ArrayList<>();
        users.forEach(result::add);
        assertEquals(2, result.size());
    }
}