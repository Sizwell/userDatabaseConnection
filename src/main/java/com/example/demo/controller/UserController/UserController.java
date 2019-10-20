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

    @PostMapping(value = "/create/{password}/{firstName}/{lastName}")
    public @ResponseBody User create(@PathVariable String password, @PathVariable String firstName, @PathVariable String lastName) {
        return this.userService.create(UserFactory.createUser(password, firstName, lastName));
    }

    @GetMapping(value = "/read/{s}")
    public @ResponseBody User read(@PathVariable Integer s) {
        return this.userService.read(s);
    }

    @PutMapping(value = "/update/{s}/{password}/{firstName}/{lastName}")
    public @ResponseBody User update(@PathVariable Integer s, @PathVariable String password, @PathVariable String firstName, @PathVariable String lastName) {
        return this.userService.update(UserFactory.updateUser(s, password, firstName, lastName));
    }

    @DeleteMapping(value = "/delete/{s}")
    public void delete(@PathVariable Integer s) {
        this.userService.delete(s);
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public @ResponseBody List<User> getAll() {
        return this.userService.getAll();
    }

    /*
    @Autowired
    UserServiceImpl userService;

    @PostMapping(value = "/create/{password}/{firstName}/{lastName}")
    public @ResponseBody User create(@PathVariable String password, @PathVariable String firstName, @PathVariable String lastName) {
        return this.userService.create(UserFactory.createUser(password, firstName, lastName));
    }

    @GetMapping(value = "/read/{s}")
    public @ResponseBody User read(@PathVariable Integer s) {
        return this.userService.read(s);
    }

    @PutMapping(value = "/update/{id}/{password}/{firstName}/{lastName}")
    public @ResponseBody User update(@PathVariable Integer id, @PathVariable String password, @PathVariable String firstName, @PathVariable String lastName) {
        return this.userService.update(UserFactory.updateUser(id, password, firstName, lastName));
    }

    @DeleteMapping(value = "/delete/{s}")
    public void delete(@PathVariable Integer s) {
        this.userService.delete(s);
    }
    @RequestMapping(value = "/getAll",method = RequestMethod.GET)
    public @ResponseBody List<User> getAll() {
        return this.userService.getAll();
    }
     */
}
