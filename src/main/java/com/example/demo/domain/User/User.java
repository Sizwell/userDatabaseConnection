package com.example.demo.domain.User;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="native")

    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(length = 8,nullable = false)

    /*
    @Column(length = 100)
    private String id;
    */
    private Integer id;
    private String firstName;
    private String lastName;
    private String gender;
    private String addr;
    private String password;


    public User()
    {

    }

    public User(Builder builder){
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.gender = builder.gender;
        this.addr = builder.addr;
        this.password = builder.password;
    }
    public static class Builder{
        private Integer id;
        private String firstName;
        private String lastName;
        private String gender;
        private String addr;
        private String password;


        public Builder id(Integer id){
            this.id = id;
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

        public Builder gender(String gender)
        {
            this.gender = gender;
            return this;
        }

        public Builder address(String address)
        {
            this.addr = address;
            return this;
        }
        public Builder password(String password){
            this.password = password;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

    public Integer getid() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public String getAddr() {
        return addr;
    }

    public String getPassword() {
        return password;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + getid() +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                "gender='" + getGender() + '\'' +
                ", addr='" + getAddr() + '\'' +
                ", password='" + getPassword() + '\'' +
                '}';
    }
}
