package com.example.demo.controller.UserController;

import com.example.demo.domain.User.User;
import com.example.demo.factory.UserFactory.UserFactory;
import com.example.demo.repository.UserRepository.UserRepository;
import com.example.demo.service.UserService.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/create/{firstName}/{lastName}/{gender}/{address}/{password}")
    public @ResponseBody User create(@PathVariable String firstName, @PathVariable String lastName
            , @PathVariable String gender, @PathVariable String address, @PathVariable String password) {
        return this.userService.create(UserFactory.createUser(firstName, lastName, gender, address, password));
    }

    @GetMapping(value = "/read/{s}")
    public @ResponseBody User read(@PathVariable Integer s) {
        return this.userService.read(s);
    }

    @PutMapping(value = "/update/{s}/{firstName}/{lastName}/{gender}/{address}/{password}")
    public @ResponseBody User update(@PathVariable Integer s, @PathVariable String firstName, @PathVariable String lastName
            , @PathVariable String gender, @PathVariable String address, @PathVariable String password) {
        return this.userService.update(UserFactory.updateUser(s, firstName, lastName, gender, address, password));
    }

    @DeleteMapping(value = "/delete/{s}")
    public void delete(@PathVariable Integer s) {
        this.userService.delete(s);
    }
    //@RequestMapping
    //
    @Autowired
    UserRepository userRepository;
    @GetMapping(value = "/getAll")
    public @ResponseBody List<User> getAll() {
      //  return this.userService.getAll();
        return this.userRepository.findAll();
    }

}
