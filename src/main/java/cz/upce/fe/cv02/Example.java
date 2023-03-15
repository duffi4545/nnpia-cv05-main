package cz.upce.fe.cv02;

import cz.upce.fe.cv02.domain.AppUser;

import java.time.LocalDateTime;

public final class Example {

    public static AppUser EXISTTING = new AppUser(
            100L,"test","1234",true, LocalDateTime.now(),LocalDateTime.now());

    private Example(){

    }
}
