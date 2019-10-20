package com.example.demo.domain.Deductions;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
public class Deductions {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="native")

    @GenericGenerator(
            name = "native",
            strategy = "native"
    )

    @Column(length = 8,nullable = false)

    private Integer deductionsNo;
    private String deductionType;
    private double deductionAmount;

    public Deductions() {

    }

    public Deductions(Builder builder) {
        this.deductionsNo = builder.deductionNo;
        this.deductionType = builder.deductionType;
        this.deductionAmount = builder.deductionAmount;
    }

    public static class Builder {
        private Integer deductionNo;
        private String deductionType;
        private double deductionAmount;

        public Builder deductionNo(Integer deductNo)
        {
            this.deductionNo = deductNo;
            return this;
        }

        public Builder deductType(String deduct) {
            this.deductionType = deduct;
            return this;
        }

        public Builder deductAmount(double deductAmount) {
            this.deductionAmount = deductAmount;
            return this;
        }

        public Builder deductionsCopy(Deductions deductions)
        {
            this.deductionNo = deductions.deductionsNo;
            this.deductionAmount = deductions.deductionAmount;

            return this;
        }

        public Deductions build() {
            return new Deductions(this);
        }

    }

    public Integer getDeductionsNo()
    {
        return deductionsNo;
    }

    public String getDeductionType() {
        return deductionType;
    }

    public double getDeductionAmount() {
        return deductionAmount;
    }

    @Override
    public String toString() {
        return "------ Deductions ------\n" +
                "Deduction No: '" + getDeductionsNo() + '\''+
                "\nDeduction Type : '" + getDeductionType() + '\'' +
                "\nDeduction Amount = R" + getDeductionAmount() + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Deductions)) return false;
        Deductions that = (Deductions) o;
        return deductionsNo == that.deductionsNo &&
                Double.compare(that.deductionAmount, deductionAmount) == 0 &&
                Objects.equals(deductionType, that.deductionType);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(deductionsNo, deductionType, deductionAmount);
    }
}
