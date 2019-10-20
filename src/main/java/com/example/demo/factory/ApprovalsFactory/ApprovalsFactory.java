package com.example.demo.factory.ApprovalsFactory;

import com.example.demo.domain.Approvals.Approvals;

import java.util.Date;

public class ApprovalsFactory {
    public static Approvals getApproval(Date date, String details) {
        return new Approvals.Builder()
                .date(date)
                .details(details)
                .build();
    }

    public static Approvals updateApproval(Integer id, Date date, String details) {
        return new Approvals.Builder()
                .approvalNo(id)
                .date(date)
                .details(details)
                .build();
    }
}
