package cz.upce.fe.cv02.service;

import cz.upce.fe.cv02.Example;
import cz.upce.fe.cv02.repository.AppUserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppUserServiceTest {
    @Autowired
    private AppUserService appUserService;

    @Autowired
    private AppUserRepository appUserRepository;


    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
        appUserRepository.deleteAll();
    }

    @Test
    @Transactional
    void findById() throws ResourceNotFoundException {
        var expected = appUserRepository.save(Example.EXISTTING);

        var actual = appUserService.findById(expected.getId());

        assertEquals(expected,actual);
    }
}