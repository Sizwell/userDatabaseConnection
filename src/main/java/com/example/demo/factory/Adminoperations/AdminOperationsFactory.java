package com.example.demo.factory.Adminoperations;

import com.example.demo.domain.AdminOperations.AdminOperations;

public class AdminOperationsFactory {
    public static AdminOperations createOperation(String operation)
    {
        return new AdminOperations.Builder()
                .operation(operation)
                .build();
    }

    public static AdminOperations updateOperation(Integer id, String operation)
    {
        return new AdminOperations.Builder()
                .operationID(id)
                .operation(operation)
                .build();
    }
}
