package com.example.demo.factory.DeductionsFactory;

import com.example.demo.domain.Deductions.Deductions;

public class DeductionsFactory {
    public static Deductions getDeduction(String dedType, double dedAmount) {
        return new Deductions.Builder()
                .deductType(dedType)
                .deductAmount(dedAmount)
                .build();
    }

    public static Deductions updateDeduction(Integer id, String dedType, double dedAmount) {
        return new Deductions.Builder()
                .deductionNo(id)
                .deductType(dedType)
                .deductAmount(dedAmount)
                .build();
    }
}
