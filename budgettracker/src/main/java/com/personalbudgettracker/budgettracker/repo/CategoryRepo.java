package com.personalbudgettracker.budgettracker.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalbudgettracker.budgettracker.model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    List<Category> findByCategoryName(String categoryName);
}