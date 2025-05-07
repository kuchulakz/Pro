package com.personalbudgettracker.budgettracker.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;
 
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
 
    private String categoryName;
 
    @OneToMany(mappedBy = "category") // One category can have many expenses
    private List<Expense> expenses;
 
    // Getters and Setters
    public Long getCategoryId() {
        return categoryId;
    }
 
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
 
    public String getCategoryName() {
        return categoryName;
    }
 
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
 
    public List<Expense> getExpenses() {
        return expenses;
    }
 
    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }
}