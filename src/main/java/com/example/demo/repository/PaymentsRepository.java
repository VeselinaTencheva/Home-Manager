package com.example.demo.repository;

import com.example.demo.entity.Payment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PaymentsRepository extends CrudRepository<Payment,Long> {
}
