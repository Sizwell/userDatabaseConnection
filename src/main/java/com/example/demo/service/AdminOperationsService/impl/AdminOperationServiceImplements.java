package com.example.demo.service.AdminOperationsService.impl;

import com.example.demo.domain.AdminOperations.AdminOperations;
import com.example.demo.repository.AdminOperationsRepository.AdminOperationsRepository;
import com.example.demo.service.AdminOperationsService.AdminOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminOperationServiceImplements implements AdminOperationsService {

    private static AdminOperationsService adminOperationsService = null;

    @Autowired
    private AdminOperationsRepository repository;

    private AdminOperationServiceImplements()
    {

    }

    public static AdminOperationsService getService()
    {
        if (adminOperationsService == null)
        {
            adminOperationsService = new AdminOperationServiceImplements();
        }
        return adminOperationsService;
    }

    @Override
    public AdminOperations create(AdminOperations adminOperations) {
        return this.repository.save(adminOperations);
    }

    @Override
    public AdminOperations read(Integer integer) {
        return this.repository.getOne(integer);
    }

    @Override
    public AdminOperations update(AdminOperations adminOperations) {
        return this.repository.save(adminOperations);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.deleteById(integer);
    }

    @Override
    public List<AdminOperations> getAll() {
        return this.repository.findAll();
    }
}
