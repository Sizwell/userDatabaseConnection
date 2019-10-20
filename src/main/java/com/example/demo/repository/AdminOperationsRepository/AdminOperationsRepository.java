package com.example.demo.repository.AdminOperationsRepository;

import com.example.demo.domain.AdminOperations.AdminOperations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminOperationsRepository extends JpaRepository<AdminOperations, Integer>
{
}
