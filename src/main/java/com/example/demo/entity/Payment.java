package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentid;
    @ManyToOne
    @JoinColumn(name = "person")
    private Person person;
    @ManyToOne
    @JoinColumn(name = "month")
    private Month month;
    @Column(name = "hasPersonPaid")
    private boolean hasPaid=false;
    public Payment() {
    }

    public Long getPaymentid() {
        return paymentid;
    }

    public void setPaymentid(Long paymentid) {
        this.paymentid = paymentid;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Month getMonth() {
        return month;
    }

    public boolean isHasPaid() {
        return hasPaid;
    }

    public void setHasPaid(boolean hasPaid) {
        this.hasPaid = hasPaid;
    }
    public void setMonth(Month month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentid=" + paymentid +
                ", person=" + person +
                ", month=" + month +
                ", hasPaid=" + hasPaid +
                '}';
    }
}
