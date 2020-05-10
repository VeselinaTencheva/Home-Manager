package com.example.demo.service;

import com.example.demo.entity.Building;
import com.example.demo.entity.Payment;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PaymentsService {
    @Autowired
    private PaymentsRepository paymentsRepository;
    @Autowired
    private BuildingRepository buildingRepository;
    public List<Payment> getPayments() {
        List<Payment> paymentList = new ArrayList();
        paymentsRepository.findAll().forEach(payment -> paymentList.add(payment));

        return paymentList;
    }

    public Payment getPayment(long id) {
        Payment payment = paymentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment Id:" + id));
        return payment;
    }

    public void addPayment(Payment payment) {
        paymentsRepository.save(payment);
    }

    public void updatePayment(long id, Payment payment) {
        paymentsRepository.save(payment);
    }

    public void deletePayment(long id) {
        Payment payment = paymentsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment Id:" + id));
        paymentsRepository.delete(payment);
    }
    public List<Payment>getPaidTaxesForABuilding(long id){
        List<Payment>payments = new ArrayList<>();
        paymentsRepository.findAll().forEach(payment ->payments.add(payment));
        return payments.stream().filter(payment -> payment.getPerson().getBuilding().getBuildingid()==(id)).filter(payment -> payment.isHasPaid()==true).collect(Collectors.toList());
    }
    public List<Payment> getUnpaidTaxesForABuilding(long id) {
        List<Payment>payments = new ArrayList<>();
        paymentsRepository.findAll().forEach(payment ->payments.add(payment));
        return payments.stream().filter(payment -> payment.getPerson().getBuilding().getBuildingid()==(id)).filter(payment -> payment.isHasPaid()==false).collect(Collectors.toList());
    }
    public Double getSumOfPaidTaxesForABuilding(long id){
        List<Payment> paidTaxes = getPaidTaxesForABuilding(id);
        double tax = 0;

        Optional<Building> building= buildingRepository.findById(id);
        tax = building.get().getTax();
        return paidTaxes.size()*tax;
    }
    public Double getSumOfUnPaidTaxesForABuilding(long id){
        List<Payment> unpaidTaxes = getUnpaidTaxesForABuilding(id);
        double tax = 0;

        Optional<Building> building= buildingRepository.findById(id);
        tax = building.get().getTax();
        return unpaidTaxes.size()*tax;
    }

    public List<Payment> getPaidTaxesForAllBuildings(){
        List<Payment>payments = new ArrayList<>();
        paymentsRepository.findAll().forEach(payment ->payments.add(payment));
        return payments.stream().filter(payment -> payment.isHasPaid()==true).collect(Collectors.toList());
    }
    public List<Payment> getUnPaidTaxesForAllBuildings(){
        List<Payment>payments = new ArrayList<>();
        paymentsRepository.findAll().forEach(payment ->payments.add(payment));
        return payments.stream().filter(payment -> payment.isHasPaid()==false).collect(Collectors.toList());
    }
    public Double getSumOfPaidTaxesForAllBuildings(){
        List<Payment>payments = new ArrayList<>();
        paymentsRepository.findAll().forEach(payment ->payments.add(payment));
        double sum=0;
        for(Payment payment:payments){
            if(payment.isHasPaid()==true){
                sum+=payment.getPerson().getBuilding().getTax();
            }
        }
        return sum;
    }
    public Double getSumOfUnPaidTaxesForAllBuildings(){
        List<Payment>payments = new ArrayList<>();
        paymentsRepository.findAll().forEach(payment ->payments.add(payment));
        double sum=0;
        for(Payment payment:payments){
            if(payment.isHasPaid()==false){
                sum+=payment.getPerson().getBuilding().getTax();
            }
        }
        return sum;
    }

    public List<Payment>getPaidTaxesForAllBuildingsOfAEmployee(long id){
        List<Payment>payments = new ArrayList<>();
        paymentsRepository.findAll().forEach(payment ->payments.add(payment));
        return payments.stream().filter(payment -> payment.getPerson().getBuilding().getEmployee().getEmployeeid()==(id)).filter(payment -> payment.isHasPaid()==true).collect(Collectors.toList());
    }
    public List<Payment> getUnPaidTaxesForAllBuildingsOfAEmployee(long id) {
        List<Payment>payments = new ArrayList<>();
        paymentsRepository.findAll().forEach(payment ->payments.add(payment));
        return payments.stream().filter(payment -> payment.getPerson().getBuilding().getEmployee().getEmployeeid()==(id)).filter(payment -> payment.isHasPaid()==false).collect(Collectors.toList());
    }
    public Double getSumOfPaidTaxesForAllBuildingsOfAEmployee(long id){
        List<Payment> paidTaxes = getPaidTaxesForAllBuildingsOfAEmployee(id);
        double tax = 0;

        Optional<Building> building= buildingRepository.findById(id);
        tax = building.get().getTax();
        return paidTaxes.size()*tax;
    }
    public Double getSumOfUnPaidTaxesForAllBuildingsOfAEmployee(long id){
        List<Payment> unpaidTaxes = getUnPaidTaxesForAllBuildingsOfAEmployee(id);
        double tax = 0;

        Optional<Building> building= buildingRepository.findById(id);
        tax = building.get().getTax();
        return unpaidTaxes.size()*tax;
    }

}
