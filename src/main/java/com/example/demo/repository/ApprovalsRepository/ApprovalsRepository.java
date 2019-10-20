package com.example.demo.repository.ApprovalsRepository;

import com.example.demo.domain.Approvals.Approvals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApprovalsRepository extends JpaRepository<Approvals, Integer> {

}
