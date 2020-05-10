package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class Building {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "building_id")
    private Long buildingid;
    @Column(name = "address", nullable = false)
    private String buildingAddress;
    @Column(name = "floors", nullable = false)
    private int buildingFloors;
    @Column(name = "apartments", nullable = false)
    private int buildingApartments;
    @Column(name = "area", nullable = false)
    private double buildingArea;
    @Column(name = "sharedArea", nullable = false)
    private double buildingSharedArea;
    @Column(name="tax",nullable = true)
    private double tax;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "employee")
    private Employee employee;

    public Building() {
    }

    public Long getBuildingid() {
        return buildingid;
    }

    public void setBuildingid(Long buildingid) {
        this.buildingid = buildingid;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getBuildingAddress() {
        return buildingAddress;
    }

    public void setBuildingAddress(String buildingAddress) {
        this.buildingAddress = buildingAddress;
    }

    public int getBuildingFloors() {
        return buildingFloors;
    }

    public void setBuildingFloors(int buildingFloors) {
        this.buildingFloors = buildingFloors;
    }

    public int getBuildingApartments() {
        return buildingApartments;
    }

    public void setBuildingApartments(int buildingApartments) {
        this.buildingApartments = buildingApartments;
    }

    public double getBuildingArea() {
        return buildingArea;
    }

    public void setBuildingArea(double buildingArea) {
        this.buildingArea = buildingArea;
    }

    public double getBuildingSharedArea() {
        return buildingSharedArea;
    }

    public void setBuildingSharedArea(double buildingSharedArea) {
        this.buildingSharedArea = buildingSharedArea;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    @Override
    public String toString() {
        return "Building{" +
                "buildingid=" + buildingid +
                ", employee=" + employee +
                ", buildingAddress='" + buildingAddress + '\'' +
                ", buildingFloors=" + buildingFloors +
                ", buildingApartments=" + buildingApartments +
                ", buildingArea=" + buildingArea +
                ", buildingSharedArea=" + buildingSharedArea +
                ", tax=" + tax +
                '}';
    }
}
