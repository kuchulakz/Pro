package com.personalbudgettracker.budgettracker.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalbudgettracker.budgettracker.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
    Optional<User> findByEmail(String email);
}
