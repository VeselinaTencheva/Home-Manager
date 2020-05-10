package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "month_id")
    private Long monthid;
    @Column(name = "name", nullable = false)
    private String monthName;
    public Month() {
    }

    public Long getMonthid() {
        return monthid;
    }

    public void setMonthid(Long monthid) {
        this.monthid = monthid;
    }

    public String getMonthName() {
        return monthName;
    }

    public void setMonthName(String monthName) {
        this.monthName = monthName;
    }

    @Override
    public String toString() {
        return "Month{" +
                "monthid=" + monthid +
                ", monthName='" + monthName + '\'' +
                '}';
    }
}
