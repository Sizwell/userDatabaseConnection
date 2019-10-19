package com.example.demo.controller.UserController;

import com.example.demo.domain.User.User;
import com.example.demo.factory.UserFactory.UserFactory;
import com.example.demo.service.UserService.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @RequestMapping(value = "/create/{password}/{firstName}/{lastName}",method = RequestMethod.POST)
    public @ResponseBody User create(@PathVariable String password, @PathVariable String firstName, @PathVariable String lastName) {
        return this.userService.create(UserFactory.createUser(password, firstName, lastName));
    }

    @RequestMapping(value = "/read/{s}",method = RequestMethod.GET)
    public @ResponseBody User read(@PathVariable Integer s) {
        return this.userService.read(s);
    }

    @RequestMapping(value = "/update/user",method = RequestMethod.PUT)
    public @ResponseBody User update(@RequestBody User user) {
        return this.userService.update(user);
    }

    @RequestMapping(value = "/delete/{s}",method = RequestMethod.DELETE)
    public void delete(@PathVariable Integer s) {
        this.userService.delete(s);
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public @ResponseBody List<User> getAll() {
        return this.userService.getAll();
    }
}
