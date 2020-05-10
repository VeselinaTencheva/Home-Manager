package com.example.demo.service;

import com.example.demo.entity.Month;
import com.example.demo.repository.MonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MonthService {
    @Autowired
    private MonthRepository monthRepository;
    public List<Month> getMonths() {
        List<Month> monthsList = new ArrayList();
        monthRepository.findAll().forEach(month -> monthsList.add(month));

        return monthsList;
    }

    public Month getMonth(long id) {
        Month month = monthRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid month Id:" + id));
        return month;
    }

    public void addMonth(Month month) {
        monthRepository.save(month);
    }

    public void updateMonth(long id, Month month) {
        monthRepository.save(month);
    }

    public void deleteMonth(long id) {
        Month month = monthRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid month Id:" + id));
        monthRepository.delete(month);
    }
}
