package com.example.demo.controller;

import com.example.demo.entity.Payment;
import com.example.demo.entity.Person;
import com.example.demo.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    @Autowired
    private PaymentsService paymentsService;

    @GetMapping
    public List<Payment> getPayments(){
        return paymentsService.getPayments();
    }
    @GetMapping("{id}")
    public Payment getPaymentById(@PathVariable("id") long id) {
        return paymentsService.getPayment(id);
    }
    @PostMapping
    public void addPayment(@RequestBody Payment payment){
        paymentsService.addPayment(payment);
    }
    @PutMapping("{id}")
    public void updatePayment(@PathVariable("id") long id,@RequestBody Payment payment) {
        paymentsService.updatePayment(id, payment);
    }
    @DeleteMapping("{id}")
    public void deletePayment(@PathVariable("id") long id) {
        paymentsService.deletePayment(id);
    }
    @GetMapping("building/paidTaxes/{id}")
    public List<Payment> getPaidTaxesForABuilding(@PathVariable("id") long id)
    {
        return paymentsService.getPaidTaxesForABuilding(id);
    }
    @GetMapping("building/unpaidTaxes/{id}")
    public List<Payment> getUnpaidTaxesForABuilding(@PathVariable("id") long id)
    {
        return paymentsService.getUnpaidTaxesForABuilding(id);
    }
    @GetMapping("building/sumPaidTaxes/{id}")
    public Double getSumOfPaidTaxesForABuilding(@PathVariable("id")long id){
        return paymentsService.getSumOfPaidTaxesForABuilding(id);
    }
    @GetMapping("building/sumUnpaidTaxes/{id}")
    public Double getSumOfUnpaidTaxesForABuilding(@PathVariable("id")long id){
        return paymentsService.getSumOfUnPaidTaxesForABuilding(id);
    }
    @GetMapping("paidTaxes")
    public List<Payment> getPaidTaxesForAllBuildings(){
        return paymentsService.getPaidTaxesForAllBuildings();
    }
    @GetMapping("unpaidTaxes")
    public List<Payment> getUnPaidTaxesForAllBuildings(){
        return paymentsService.getUnPaidTaxesForAllBuildings();
    }
    @GetMapping("sumPaidTaxes")
    public Double getSumOfPaidTaxesForAllBuildings(){
        return paymentsService.getSumOfPaidTaxesForAllBuildings();
    }
    @GetMapping("sumUnpaidTaxes")
    public Double getSumOfUnPaidTaxesForAllBuildings(){
        return paymentsService.getSumOfUnPaidTaxesForAllBuildings();
    }
    @GetMapping("employee/paidTaxes/{id}")
    public List<Payment> getPaidTaxesForAllBuildingsOfAEmployee(@PathVariable("id")long id){
        return paymentsService.getPaidTaxesForAllBuildingsOfAEmployee(id);
    }
    @GetMapping("employee/unpaidTaxes/{id}")
    public List<Payment> getUnPaidTaxesForAllBuildingsOfAEmployee(@PathVariable("id")long id){
        return paymentsService.getUnPaidTaxesForAllBuildingsOfAEmployee(id);
    }
    @GetMapping("employee/sumPaidTaxes/{id}")
    public Double getSumOfPaidTaxesForAllBuildingsOfAEmployee(@PathVariable("id")long id){
        return paymentsService.getSumOfPaidTaxesForAllBuildingsOfAEmployee(id);
    }
    @GetMapping("employee/sumUnpaidTaxes/{id}")
    public Double getSumOfUnPaidTaxesForAllBuildingsOfAEmployee(@PathVariable("id")long id){
        return paymentsService.getSumOfUnPaidTaxesForAllBuildingsOfAEmployee(id);
    }
}
