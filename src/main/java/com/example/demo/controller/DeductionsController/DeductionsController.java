package com.example.demo.controller.DeductionsController;

import com.example.demo.domain.Deductions.Deductions;
import com.example.demo.factory.DeductionsFactory.DeductionsFactory;
import com.example.demo.service.DeductionsService.DeductionsServiceImplement.DeductionsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deductions")
public class DeductionsController {

    @Autowired
    DeductionsServiceImpl deductionsService;

    @RequestMapping(value = "/create/{type}/{amount}", method = RequestMethod.POST)
    public @ResponseBody Deductions create(@PathVariable String type, @PathVariable Double amount)
    {
        return this.deductionsService.create(DeductionsFactory.getDeduction(type, amount));
    }

    @GetMapping(value = "/read/{b}")
    public @ResponseBody Deductions read(@PathVariable Integer b)
    {
        return this.deductionsService.read(b);
    }

    @PutMapping(value = "/update/{a}/{type}/{amount}")
    public @ResponseBody Deductions update(@PathVariable Integer a, @PathVariable String type , @PathVariable Double amount)
    {
        return this.deductionsService.update(DeductionsFactory.updateDeduction(a, type, amount));
    }
    /*
    @PutMapping(value = "/update/{s}/{password}/{firstName}/{lastName}")
    public @ResponseBody User update(@PathVariable Integer s, @PathVariable String password, @PathVariable String firstName, @PathVariable String lastName) {
        return this.userService.update(UserFactory.updateUser(s, password, firstName, lastName));
    }
     */

    @DeleteMapping(value = "/delete/{x}")
    public void delete(@PathVariable Integer x)
    {
        this.deductionsService.delete(x);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody List<Deductions> getAll()
    {
        return this.deductionsService.getAll();
    }

}
