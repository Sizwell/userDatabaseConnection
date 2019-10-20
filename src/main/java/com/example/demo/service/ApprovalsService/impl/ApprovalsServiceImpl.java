package com.example.demo.service.ApprovalsService.impl;

import com.example.demo.domain.Approvals.Approvals;
import com.example.demo.repository.ApprovalsRepository.ApprovalsRepository;
import com.example.demo.service.ApprovalsService.ApprovalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalsServiceImpl implements ApprovalsService {

    private static ApprovalsService service = null;
    @Autowired
    private ApprovalsRepository repository;

    private ApprovalsServiceImpl()
    {

    }

    public static ApprovalsService getService()
    {
        if(service == null)
        {
            service = new ApprovalsServiceImpl();
        }
        return service;
    }

    @Override
    public Approvals create(Approvals approvals) {
        return this.repository.save(approvals);
    }

    @Override
    public Approvals read(Integer integer) {
        return this.repository.getOne(integer);
    }

    @Override
    public Approvals update(Approvals approvals) {
        return this.repository.save(approvals);
    }

    @Override
    public void delete(Integer integer) {
        this.repository.deleteById(integer);
    }

    @Override
    public List<Approvals> getAll() {
        return this.repository.findAll();
    }
}
