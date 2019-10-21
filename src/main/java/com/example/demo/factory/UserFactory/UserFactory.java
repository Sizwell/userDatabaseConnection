package com.example.demo.factory.UserFactory;

import com.example.demo.domain.User.User;

public class UserFactory {
    public static User createUser(String firstName, String lastName, String gender, String addr, String password){
        return new User.Builder()
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .address(addr)
                .password(password)
                .build();
    }

    public static User updateUser(Integer id, String firstName, String lastName, String gender, String addr, String password){
        return new User.Builder()
                .id(id)
                .firstName(firstName)
                .lastName(lastName)
                .gender(gender)
                .address(addr)
                .password(password)
                .build();
    }
}
