package com.example.demo.service;

import com.example.demo.entity.Building;
import com.example.demo.entity.Employee;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BuildingRepository buildingRepository;
    public List<Employee> getEmployees() {
        List<Employee> employeesList = new ArrayList();
        employeeRepository.findAll().forEach(employee -> employeesList.add(employee));

        return employeesList;
    }

    public Employee getEmployee(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        return employee;
    }

    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public void updateEmployee(long id, Employee employee) {
     employeeRepository.save(employee);
    }

    public void deleteEmployee(long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid employee Id:" + id));
        employeeRepository.delete(employee);
    }
    public List<Building> employeeToBuildings(long id){
        List<Building>buildings = new ArrayList<>();
        buildingRepository.findAll().forEach(building -> buildings.add(building));
       List<Building>test= buildings.stream().filter(building -> building.getEmployee().getEmployeeid()==id).collect(Collectors.toList());
       return  test;
    }
    public Integer getCountOfEmployees (){
        List<Employee> employeeList = new ArrayList();
        employeeRepository.findAll().forEach(employee -> employeeList.add(employee));
        return employeeList.size();
    }
}
