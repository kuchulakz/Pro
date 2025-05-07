package com.personalbudgettracker.budgettracker.model;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
 
@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long expenseId;
 
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private User user;
 
    private Double amount;
 
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "categoryId") // Establish relationship with Category
    private Category category;
   
    private String description;
 
    private LocalDate date;
 
    public Expense() {
    }
 
    public Expense(Long expenseId, User user, Double amount, Category category, String description, LocalDate date) {
        this.expenseId = expenseId;
        this.user = user;
        this.amount = amount;
        this.category = category;
        this.description = description;
        this.date = date;
    }
 
    public Long getExpenseId() {
        return expenseId;
    }
 
    public void setExpenseId(Long expenseId) {
        this.expenseId = expenseId;
    }
 
    public User getUser() {
        return user;
    }
 
    public void setUser(User user) {
        this.user = user;
    }
 
    public Double getAmount() {
        return amount;
    }
 
    public void setAmount(Double amount) {
        this.amount = amount;
    }
 
    public Category getCategory() {
        return category;
    }
 
    public void setCategory(Category category) {
        this.category = category;
    }
 
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public LocalDate getDate() {
        return date;
    }
 
    public void setDate(LocalDate date) {
        this.date = date;
    }
   
   
   
   
   
}
 