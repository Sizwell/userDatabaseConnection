package com.example.demo.factory.UserFactory;

import com.example.demo.domain.User.User;

public class UserFactory {
    public static User createUser(String password, String firstName, String lastName){
        return new User.Builder()
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }

    public static User updateUser(Integer id,String password, String firstName, String lastName){
        return new User.Builder()
                .username(id)
                .password(password)
                .firstName(firstName)
                .lastName(lastName)
                .build();
    }
}
