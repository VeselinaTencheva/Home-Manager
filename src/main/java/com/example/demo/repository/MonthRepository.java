package com.example.demo.repository;

import com.example.demo.entity.Month;
import org.springframework.data.repository.CrudRepository;

public interface MonthRepository extends CrudRepository<Month,Long> {
}
