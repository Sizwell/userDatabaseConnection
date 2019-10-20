package com.example.demo.domain.AdminOperations;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
public class AdminOperations {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="native")

    @GenericGenerator(
            name = "native",
            strategy = "native"
    )

    @Column(length = 8,nullable = false)

    private Integer operationID;
    private String operation;

    public AdminOperations() {

    }

    public AdminOperations(Builder builder) {
        this.operationID = builder.operationID;
        this.operation = builder.operation;
    }

    public static class Builder {
        private Integer operationID;
        private String operation;

        public Builder operationID(Integer operationID) {
            this.operationID = operationID;
            return this;
        }

        public Builder operation(String operation) {
            this.operation = operation;
            return this;
        }

        public Builder copy(AdminOperations adminOperations)
        {
            this.operationID = adminOperations.operationID;
            this.operation = adminOperations.operation;

            return this;
        }

        public AdminOperations build() {
            return new AdminOperations(this);
        }

    }

    public Integer getOperationID() {
        return operationID;
    }

    public String getOperation() {
        return operation;
    }


    public String toString() {
        String str;
        str = "Operation ID " + getOperationID() + " Operation: " + getOperation();
        return str;
    }

}
