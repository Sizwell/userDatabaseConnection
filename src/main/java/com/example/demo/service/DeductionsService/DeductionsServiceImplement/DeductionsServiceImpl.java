package com.example.demo.service.DeductionsService.DeductionsServiceImplement;

import com.example.demo.domain.Deductions.Deductions;
import com.example.demo.repository.DeductionsRepository.DeductionsRepository;
import com.example.demo.service.DeductionsService.DeductionsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeductionsServiceImpl implements DeductionsService {
    private static DeductionsService deductionsService = null;

    @Autowired
    private DeductionsRepository deductionsRepository;

    private DeductionsServiceImpl()
    {

    }

    public static DeductionsService getDeductionsService()
    {
        if (deductionsService == null)
        {
            deductionsService = new DeductionsServiceImpl();
        }
        return deductionsService;
    }

    /*

    */

    @Override
    public Deductions create(Deductions deductions)
    {
        return this.deductionsRepository.save(deductions);
    }

    @Override
    public Deductions read(Integer integer)
    {
        Optional<Deductions> deductions = deductionsRepository.findById(integer);
        return deductions.orElse(null);
        //return this.deductionsRepository.getOne(integer);
    }

    @Override
    public Deductions update(Deductions deductions)
    {
        Deductions update = read(deductions.getDeductionsNo());
        if (update != null)
        {
            update.setDeductionAmount(deductions.getDeductionAmount());
            update.setDeductionType(deductions.getDeductionType());

            return this.deductionsRepository.save(update);
        }
        return null;
    }

    @Override
    public void delete(Integer integer)
    {
        Deductions deductions  = deductionsRepository
                .findById(integer)
                .orElse(null);

        if (deductions != null)
        {
            deductionsRepository.deleteById(integer);
        }
        //this.deductionsRepository.deleteById(integer);
    }

    @Override
    public List<Deductions> getAll()
    {
        return this.deductionsRepository.findAll();
    }
}
