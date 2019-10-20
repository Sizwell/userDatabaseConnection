package com.example.demo.domain.Approvals;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;


@Data
@Entity
public class Approvals {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO,
            generator="native")

    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(length = 8,nullable = false)

    private Integer approvalNo;
    private Date date;
    private String details;

    public Approvals() {

    }

    public Approvals(Builder builder) {
        this.approvalNo = builder.approvalNo;
        this.date = builder.date;
        this.details = builder.details;
    }

    public static class Builder {
        private Integer approvalNo;
        private Date date;
        private String details;

        public Builder approvalNo(Integer vin) {
            this.approvalNo = vin;
            return this;
        }

        public Builder date(Date date) {
            this.date = date;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public Builder copyApprovals(Approvals approvals)
        {
            this.approvalNo = approvals.approvalNo;
            this.details = approvals.details;
            this.date = approvals.date;

            return this;
        }

        public Approvals build() {
            return new Approvals(this);
        }
    }

    public Integer getApprovalNo() {
        return approvalNo;
    }

    public Date getDate() {
        return date;
    }

    public String getDetails() {
        return details;
    }

    @Override
    public String toString() {
        return "------ Approvals ------\n" +
                "Approval No : '" + getApprovalNo() + '\'' +
                "\nDate date : " + getDate() +
                "\nDetails : '" + getDetails() + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Approvals)) return false;
        Approvals approvals = (Approvals) o;
        return approvalNo.equals(approvals.approvalNo) &&
                date.equals(approvals.date) &&
                Objects.equals(details, approvals.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(approvalNo, date, details);
    }

}
