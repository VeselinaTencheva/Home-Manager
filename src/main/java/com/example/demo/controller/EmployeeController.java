package com.example.demo.controller;

import com.example.demo.entity.Building;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Month;
import com.example.demo.service.EmployeeService;
import com.example.demo.service.MonthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @GetMapping("{id}")
    public Employee getEmployeeById(@PathVariable("id") long id) {
        return employeeService.getEmployee(id);
    }
    @PostMapping
    public void addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
    }
    @PutMapping("{id}")
    public void updateEmployee(@PathVariable("id") long id,@RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }
    @DeleteMapping("{id}")
    public void deleteEmployee(@PathVariable("id") long id) {
        employeeService.deleteEmployee(id);
    }
    @GetMapping("api1/{id}")
    public List<Building> getEmployeeWithItsBuildings(@PathVariable("id")long id){
        return employeeService.employeeToBuildings(id);
    }
    @GetMapping("api2")
   public Integer getCountOfEmployees(){
        return employeeService.getCountOfEmployees();
    }
}
