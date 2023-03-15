package cz.upce.fe.cv02.service;

import cz.upce.fe.cv02.domain.AppUser;
import cz.upce.fe.cv02.repository.AppUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AppUserServiceTest {
    @Autowired
    private AppUserService appUserService;

    @MockBean
    private AppUserRepository appUserRepository;

    private static AppUser EXISTTING = new AppUser(
            100L,"test","1234",true, LocalDateTime.now(),LocalDateTime.now());

    @BeforeEach
    void setUp() {
        Mockito.when(appUserRepository.findById(100L))
                .thenReturn(Optional.of(EXISTTING));

    }
    @Test
    void findById() throws ResourceNotFoundException {
        var expected = EXISTTING;

        var actual = appUserService.findById(100L);

        assertEquals(expected,actual);
    }
}