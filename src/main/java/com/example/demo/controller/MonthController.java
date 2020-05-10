package com.example.demo.controller;

import com.example.demo.entity.Month;
import com.example.demo.entity.Payment;
import com.example.demo.service.MonthService;
import com.example.demo.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/month")
public class MonthController {
    @Autowired
    private MonthService monthService;

    @GetMapping
    public List<Month> getMonths(){
        return monthService.getMonths();
    }
    @GetMapping("{id}")
    public Month getMonthById(@PathVariable("id") long id) {
        return monthService.getMonth(id);
    }
    @PostMapping
    public void addMonth(@RequestBody Month month){
        monthService.addMonth(month);
    }
    @PutMapping("{id}")
    public void updateMonth(@PathVariable("id") long id,@RequestBody Month month) {
        monthService.updateMonth(id, month);
    }
    @DeleteMapping("{id}")
    public void deleteMonth(@PathVariable("id") long id) {
        monthService.deleteMonth(id);
    }
}
