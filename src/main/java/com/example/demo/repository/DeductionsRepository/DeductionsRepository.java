package com.example.demo.repository.DeductionsRepository;

import com.example.demo.domain.Deductions.Deductions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeductionsRepository extends JpaRepository <Deductions, Integer>{
}
