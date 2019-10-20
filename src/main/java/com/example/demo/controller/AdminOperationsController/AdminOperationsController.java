package com.example.demo.controller.AdminOperationsController;

import com.example.demo.domain.AdminOperations.AdminOperations;
import com.example.demo.factory.Adminoperations.AdminOperationsFactory;
import com.example.demo.service.AdminOperationsService.impl.AdminOperationServiceImplements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin")
public class AdminOperationsController {

    @Autowired
    AdminOperationServiceImplements adminOperationServiceImplements;

    //private String operationID;
    //    private String operation;

    @RequestMapping(value = "/create/{operation}", method = RequestMethod.POST)
    public @ResponseBody AdminOperations create(@PathVariable String operation)
    {
        return this.adminOperationServiceImplements.create(AdminOperationsFactory.createOperation(operation));
    }

    @GetMapping(value = "/read/{a}")
    public @ResponseBody AdminOperations read(@PathVariable Integer a)
    {
        return this.adminOperationServiceImplements.read(a);
    }


    @PutMapping(value = "/update/{id}/{adminOperations}")
    public @ResponseBody AdminOperations update(@PathVariable Integer id, @PathVariable String adminOperations)
    {
        return this.adminOperationServiceImplements.update(AdminOperationsFactory.updateOperation(id, adminOperations));
    }

    @DeleteMapping(value = "/delete/{d}")
    public void delete(@PathVariable Integer d)
    {
        this.adminOperationServiceImplements.delete(d);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public @ResponseBody
    List<AdminOperations> getAll()
    {
        return this.adminOperationServiceImplements.getAll();
    }

}

