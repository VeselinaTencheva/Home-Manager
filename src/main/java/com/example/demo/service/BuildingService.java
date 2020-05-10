package com.example.demo.service;

import com.example.demo.entity.Building;
import com.example.demo.entity.Person;
import com.example.demo.repository.BuildingRepository;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BuildingService {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private PersonRepository personRepository;

    public List<Building> getBuildings() {
        List<Building> buildingsList = new ArrayList();
        buildingRepository.findAll().forEach(building -> buildingsList.add(building));

        return buildingsList;
    }

    public Building getBuilding(long id) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid building Id:" + id));
        return building;
    }

    public void addBuilding(Building building) {
        buildingRepository.save(building);
    }

    public void updateBuilding(long id, Building building) {
        buildingRepository.save(building);
    }

    public void deleteBuilding(long id) {
        Building building = buildingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid building Id:" + id));
        buildingRepository.delete(building);
    }
    public Integer getCountOfBuildings (){
        List<Building> buildingsList = new ArrayList();
        buildingRepository.findAll().forEach(building -> buildingsList.add(building));
        return buildingsList.size();
    }
    public Integer getCountOfApartments(long id){
        List<Building> buildingsList = new ArrayList();
        buildingRepository.findAll().forEach(building -> buildingsList.add(building));
       return buildingsList.stream().filter(building -> building.getBuildingid()==id).collect(Collectors.toList()).get(0).getBuildingApartments();
    }
    public Integer getCountOfFlors(long id){
        List<Building> buildingsList = new ArrayList();
        buildingRepository.findAll().forEach(building -> buildingsList.add(building));
        return buildingsList.stream().filter(building -> building.getBuildingid()==id).collect(Collectors.toList()).get(0).getBuildingFloors();
    }
    public Double getAreaOfTheBuilding(long id){
        List<Building> buildingsList = new ArrayList();
        buildingRepository.findAll().forEach(building -> buildingsList.add(building));
        return buildingsList.stream().filter(building -> building.getBuildingid()==id).collect(Collectors.toList()).get(0).getBuildingArea();
    }
    public Double getSharedAreaOfTheBuilding(long id){
        List<Building> buildingsList = new ArrayList();
        buildingRepository.findAll().forEach(building -> buildingsList.add(building));
        return buildingsList.stream().filter(building -> building.getBuildingid()==id).collect(Collectors.toList()).get(0).getBuildingSharedArea();
    }
    public String getAddressOfTheBuilding(long id){
        List<Building> buildingsList = new ArrayList();
        buildingRepository.findAll().forEach(building -> buildingsList.add(building));
        return buildingsList.stream().filter(building -> building.getBuildingid()==id).collect(Collectors.toList()).get(0).getBuildingAddress();
    }

    public Integer getCountOfPeopleInTheBuilding(long id){
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(person -> people.add(person));
         return people.stream().filter(person -> person.getBuilding().getBuildingid()==id).collect(Collectors.toList()).size();
    }
    public List<Person> getAllPeopleInTheBuilding(long id){
        List<Person> people = new ArrayList<>();
        personRepository.findAll().forEach(person -> people.add(person));
        return people.stream().filter(person -> person.getBuilding().getBuildingid()==id).collect(Collectors.toList());
    }


}
