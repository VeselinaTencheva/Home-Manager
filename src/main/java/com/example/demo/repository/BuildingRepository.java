package com.example.demo.repository;

import com.example.demo.entity.Building;
import org.springframework.data.repository.CrudRepository;

public interface BuildingRepository extends CrudRepository<Building,Long> {
}
