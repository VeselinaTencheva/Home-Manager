package com.example.demo.controller;

import com.example.demo.entity.Building;
import com.example.demo.entity.Person;
import com.example.demo.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/building")
public class BuildingController {
    @Autowired
    private BuildingService buildingService;

    @GetMapping
    public List<Building> getBuildings(){
        return buildingService.getBuildings();
    }
    @GetMapping("{id}")
    public Building getBuildingById(@PathVariable("id") long id) {
        return buildingService.getBuilding(id);
    }
    @PostMapping
    public void addBuilding(@RequestBody Building building){
        buildingService.addBuilding(building);
    }
    @PutMapping("{id}")
    public void updateBuilding(@PathVariable("id") long id,@RequestBody Building building) {
        buildingService.updateBuilding(id, building);
    }
    @GetMapping("api1")
    public Integer getCountOfBuildings(){
        return buildingService.getCountOfBuildings();
    }

    @DeleteMapping("{id}")
    public void deleteBuilding(@PathVariable("id") long id) {
        buildingService.deleteBuilding(id);
    }
    @GetMapping("apartments/{id}")
    public Integer getCountOfBuildingApartments(@PathVariable("id") long id){
        return buildingService.getCountOfApartments(id);
    }
    @GetMapping("floors/{id}")
    public Integer getCountOfBuildingFloors(@PathVariable("id") long id){
        return buildingService.getCountOfFlors(id);
    }
    @GetMapping("area/{id}")
    public Double getBuildingArea(@PathVariable("id") long id){
        return buildingService.getAreaOfTheBuilding(id);
    }
    @GetMapping("sharedArea/{id}")
    public Double getCountOfBuildingSharedArea(@PathVariable("id") long id){
        return buildingService.getSharedAreaOfTheBuilding(id);
    }
    @GetMapping("address/{id}")
    public String getBuildingAddress(@PathVariable("id") long id){
        return buildingService.getAddressOfTheBuilding(id);
    }
    @GetMapping("countOfPeople/{id}")
    public Integer getCountOfPeopleInTheBuilding(@PathVariable("id") long id){
        return buildingService.getCountOfPeopleInTheBuilding(id);
    }
    @GetMapping("people/{id}")
    public List<Person> getPeopleInTheBuilding(@PathVariable("id") long id){
        return buildingService.getAllPeopleInTheBuilding(id);
    }

}
