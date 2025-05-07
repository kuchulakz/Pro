package com.personalbudgettracker.budgettracker.controller;

import com.personalbudgettracker.budgettracker.exceptions.IncomeNotFoundException;
import com.personalbudgettracker.budgettracker.exceptions.NoIncomesFoundException;
import com.personalbudgettracker.budgettracker.model.Income;
import com.personalbudgettracker.budgettracker.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/incomes")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    public ResponseEntity<?> addIncome(@RequestBody Income income) {
        Income savedIncome = incomeService.addIncome(income);
        return ResponseEntity.status(201).body(savedIncome);
    }

  @GetMapping
    public ResponseEntity<?> getAllIncomes() {
        try {
            List<Income> incomeList = incomeService.getAllIncomes();
            return ResponseEntity.status(200).body(incomeList);
        }  
     catch (NoIncomesFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }


    @GetMapping("/{incomeId}")
    public ResponseEntity<?> getIncomeById(@PathVariable Long incomeId) {
        try {
            Income income = incomeService.getIncomeById(incomeId);
            return ResponseEntity.status(200).body(income);
        } catch (IncomeNotFoundException e) {
            

        return ResponseEntity.status(404).body(e.getMessage());

        }
    }

    @PutMapping("/{incomeId}")
    public ResponseEntity<?> updateIncome(@PathVariable Long incomeId, @RequestBody Income updatedIncome) {
        try {
            Income income = incomeService.updateIncome(incomeId, updatedIncome);
            return ResponseEntity.status(200).body(income);
        } catch (IncomeNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{incomeId}")
    public ResponseEntity<?> deleteIncome(@PathVariable Long incomeId) {
        try {
            incomeService.deleteIncome(incomeId);
            return ResponseEntity.status(204).build();
        } catch (IncomeNotFoundException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
