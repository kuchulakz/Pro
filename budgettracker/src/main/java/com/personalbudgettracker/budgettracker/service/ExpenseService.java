package com.personalbudgettracker.budgettracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personalbudgettracker.budgettracker.model.Expense;
import com.personalbudgettracker.budgettracker.repo.ExpenseRepo;

import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepo expenseRepository;

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Expense getExpenseById(Long id) {
        return expenseRepository.findById(id).orElse(null);
    }

    public Expense saveExpense(Expense expense) {
        return expenseRepository.save(expense);
    }

    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }
}