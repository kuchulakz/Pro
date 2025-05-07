package com.personalbudgettracker.budgettracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalbudgettracker.budgettracker.model.Expense;

@Repository
public interface ExpenseRepo extends JpaRepository<Expense, Long> {   
} 