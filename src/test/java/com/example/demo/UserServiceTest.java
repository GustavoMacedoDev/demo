package com.example.demo;

import com.example.demo.domain.User;
import com.example.demo.enums.ProfileEnum;
import com.example.demo.enums.StatusEnum;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserServiceImpl;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    User userNew = new User(-1, "g@gmail.com",
            "$2a$10$PLCJD4Yu0PU/z9xoJxV4BumzWca9bKQ9VGtFfCzwrdSArfl0ai/La", ProfileEnum.ROLE_USER);

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Autowired
    private UserRepository userRepository;


    @Test
    public void saveTest() {

        userServiceImpl.save(userNew);

        Optional<User> obj = userRepository.findByEmail("g@gmail.com");
        Assert.assertEquals(obj.get().getEmail(), userNew.getEmail());


    }

    @Test
    public void findByIdTest() {
        Optional<User> userEmail = userRepository.findByEmail("g@gmail.com");
        Optional<User> userId = userRepository.findById(userEmail.get().getId());

        Integer idEsperado = 1;
        Integer idBuscado = userId.get().getId();
        Assert.assertEquals(idEsperado, idBuscado);
    }

    @After
    public void tearDown() {
    }
}
