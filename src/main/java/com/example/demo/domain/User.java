package com.example.demo.domain;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(length = 8,nullable = false)

    /*
    @Column(length = 100)
    private String username;
    */
    private Integer username;
    private String password;
    private String firstName;
    private String lastName;

    public User(){}
    public User(Builder builder){
        this.username = builder.username;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }
    public static class Builder{
        private Integer username;
        private String password;
        private String firstName;
        private String lastName;


        public Builder username(Integer username){
            this.username = username;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public Builder firstName(String firstName){
            this.firstName = firstName;
            return this;
        }
        public Builder lastName(String lastName){
            this.lastName = lastName;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }
}
